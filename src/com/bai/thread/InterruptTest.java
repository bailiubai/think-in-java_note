package com.bai.thread;

/**
 * @Author:liuBai
 * @Time : 2021/4/7 10:54
 *
 * 线程的interrupt()调用不管是在该线程的阻塞方法调用前或调用后，都会导致该线程抛出InterruptedException；
 * interrupt调用在阻塞方法调用前；
 */
public class InterruptTest {

    public static class TestThread extends Thread{
        public volatile boolean go = false;
        public void run(){
            test();
        }

        private synchronized void test(){
            System.out.println("running");

            while (!go){

            }
            try {
                if (isInterrupted()){
                    System.out.println("Interrupted");
                }

                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
                System.out.println("InterruptedException");
            }
        }
    }

    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.start();

        thread.interrupt();
        thread.go = true;
    }
}
