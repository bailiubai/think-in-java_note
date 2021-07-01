package com.bai.thread.local;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/**
 * @Author:liuBai
 * @Time : 2021/5/13 14:38
 */
public class ThreadLocalBak<T> {

    /**
     * ThreadLocals依赖于附加到每个线程的每线程线性探测哈希映射（thread.ThreadLocals和inheritableThreadLocals）。
     * ThreadLocal对象充当键，通过threadLocalHashCode搜索。这是一个自定义哈希代码（仅在ThreadLocalMaps中有用）消除冲突
     *在通常情况下，连续构造的threadlocal由相同的线程使用，而在不太常见的情况下保持良好的性能
     */
   private final int threadLocalHashCode =nextHashCode();

    /**
     * 下一个要给出的哈希码。原子更新。开始于0
     */
   private static AtomicInteger nextHashCode = new AtomicInteger();

    /**
     *连续生成的散列码之间的差异
     * 隐式顺序线程将局部IDs转换为近似最优分布
     * 两个表的幂的乘法散列值。
     */
   private static final int HASH_INCREMENT=0x61c88647;//十进制：1640531527

    /**
     * 返回下一个哈希码
     * @return
     */
   private static int nextHashCode(){
       return nextHashCode.getAndAdd(HASH_INCREMENT);
   }

    /**
     *返回当前线程的“初始值”线程局部变量。
     * 此方法将首先被调用线程使用{@link#get}访问变量的时间方法，除非线程以前调用了{@link#set}方法，在这种情况下，{@code initialValue}方法将不会为线程调用。
     * 通常，此方法在每个线程最多调用一次，但在随后调用{@link#remove}，后跟{@link#get}。
     *
     * 这个实现只返回{@code null}；如果程序员希望线程局部变量具有除{@code null}以外的初始值，则必须将{@code ThreadLocal}子类化，并重写此方法。
     * 通常，将使用匿名内部类。
     * @return
     */
   protected T initialValue(){
       return null;
   }

    /**
     * 创建线程局部变量。
     * 变量的初始值是通过调用{@code Supplier}上的{@code get}方法来确定的。
     *
     * @param supplier 用于确定初始值的供应商
     * @param <S> 线程本地值的类型
     * @return 一个新的线程局部变量
     */
   public static <S>ThreadLocalBak<S> withInitial(Supplier<? extends S> supplier){
        return new SuppliedThreadLocal<>(supplier);
   }

    /**
     * 创建线程局部变量
     */
    public ThreadLocalBak(){
    }

//    public T get(){
//        Thread thread = Thread.currentThread();
//        ThreadLocalBakMap map =getMap(thread);
//    }

    /**
     * ThreadLocal的一个扩展，它从指定的{@code Supplier}。
     * @param <T>
     */
    static final class SuppliedThreadLocal<T> extends ThreadLocalBak<T>{

       private final Supplier<? extends T> supplier;

        SuppliedThreadLocal(Supplier<? extends T> supplier){
            this.supplier = Objects.requireNonNull(supplier);
        }

        @Override
        protected T initialValue(){
            return supplier.get();
        }
    }

    /**
     * ThreadLocalBakMap是一个定制的哈希映射，仅适用于维护线程本地值。
     * 在ThreadLocalBak类之外不导出任何操作。
     * 类是包私有的，允许在类线程中声明字段。
     * 为了帮助处理非常大和长寿命的用法，哈希表条目使用weakreference作为键。
     * 但是，由于不使用引用队列，因此只有当表开始耗尽空间时，才能保证删除过时的条目。
     */
    static class ThreadLocalBakMap{

        /**
         * 此哈希映射中的条目扩展WeakReference，使用其主ref字段作为键（它始终是ThreadLocal对象）。
         * 请注意，null键（即entry.get（）==null）意味着不再引用该键，因此可以从表中删除该项。
         * 在下面的代码中，这些条目被称为“过时条目”。
         */
        static class Entry extends WeakReference<ThreadLocalBak<?>>{

            /**
             * 与此ThreadLocal关联的值。
             */
            Object value;

            Entry(ThreadLocalBak<?> k,Object v){
                super(k);
                value = v;
            }
        }

        /**
         * 初始容量必须是2的幂。
         */
        private static final int INITIAL_CAPACITY =16;

        /**
         * 表格，根据需要调整大小。table.length必须始终是2的幂。
         */
        private Entry[] table ;

        /**
         *表中的条目数
         */
        private int size = 0;

        /**
         *要调整大小的下一个大小值
         */
        private int threshold; //默认是0

        /**
         *设置“调整大小阈值”（resize threshold）以保持最差的2/3负载系数。
         * @param len
         */
        private void setThreshold(int len){
            threshold = len * 2 / 3;
        }

        /**
         * 镜头模块中的增量。
         * @param i
         * @param len
         * @return
         */
        private static int nextIndex(int i,int len){
            return ((i + 1 < len) ? i+1 : 0);
        }

        /**
         *仅限减量和模块。
         * @param i
         * @param len
         * @return
         */
        private static int prevIndex(int i,int len){
            return ((i - 1 >= 0)? i-1 : len - 1);
        }

        /**
         * 构造一个最初包含（firstKey，firstValue）的新映射。
         * ThreadLocalMaps是延迟构建的，因此我们只有在至少有一个条目要放入其中时才创建一个
         * @param firstKey
         * @param firstValue
         */
        ThreadLocalBakMap(ThreadLocalBak<?> firstKey,Object firstValue){
            table = new Entry[INITIAL_CAPACITY];
            int i = firstKey.threadLocalHashCode &(INITIAL_CAPACITY - 1);
            table[i] =new Entry(firstKey,firstValue);
            size = 1;
            setThreshold(INITIAL_CAPACITY);
        }

        private ThreadLocalBakMap(ThreadLocalBakMap parentMap){
            Entry[] parentTable = parentMap.table;
            int len = parentTable.length;
            setThreshold(len);
            table = new Entry[len];

            for (int j=0 ; j<len ; j++){
                Entry e = parentTable[j];
                if (e!=null){
                    @SuppressWarnings("unchecked")
                    ThreadLocalBak<Object> key =(ThreadLocalBak<Object>)e.get();
                    if (key!=null){
                        Object value = key.childValue(e.value);
                        Entry c = new Entry(key,value);
                        int h = key.threadLocalHashCode & (len - 1);
                        while (table[h] != null)
                            h =nextIndex(h,len);
                        table[h] = c;
                        size++;
                    }
                }
            }
        }

        private Entry getEntry(ThreadLocalBak<?> key){
            int i = key.threadLocalHashCode & (table.length - 1);
            Entry e = table[i];
            if (e != null && e.get() == key){
                return e;
            }else{
                return getEntryAfterMiss(key,i,e);
            }
        }

        private Entry getEntryAfterMiss(ThreadLocalBak<?> key,int i,Entry e){
            Entry[] tab = table;
            int len = tab.length;

            while (e !=null){
                ThreadLocalBak<?> k = e.get();
                if (k == key)
                    return e;
                if (k == null)
                    expungeStaleEntry(i);
                else
                    i = nextIndex(i,len);
                e = tab[i];
            }
            return null;
        }

        private void set(ThreadLocalBak<?> key,Object value){
            Entry[] tab =table;
            int len =tab.length;
            int i = key.threadLocalHashCode & (len-1);

        }

        private int expungeStaleEntry(int staleSlot){
            Entry[] tab = table;
            int len =tab.length;

            //驱逐进入斯大林洛特
            tab[staleSlot].value = null ;
            tab[staleSlot] = null;
            size--;

            //
            Entry e;
            int i;
            for (i = nextIndex(staleSlot,len);(e = tab[i])!=null;i=nextIndex(i,len)){
                ThreadLocalBak k = e.get();
                if (k==null){
                    e.value=null;
                    tab[i]=null;
                    size--;
                }else{
                    int h =k.threadLocalHashCode &(len - 1);
                    if (h != i){
                        tab[i] = null;
                        while (tab[h] != null){
                            h =nextIndex(h,len);
                        }
                        tab[h]=e;
                    }
                }
            }
            return i;
        }

    }

    /**
     * 方法childValue是在子类InheritableThreadLocal中定义的，
     * 但是在这里内部定义是为了提供createInheritedMap工厂方法，而不需要在InheritableThreadLocal中为map类定义子类。
     * 这种技术比在方法中嵌入测试实例更可取。
     * @param parentValue
     * @return
     */
    T childValue(T parentValue){
        throw new UnsupportedOperationException();
    }

}
