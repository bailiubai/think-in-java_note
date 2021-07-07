package com.bai.chap12;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException extends Exception{
    private static Logger logger = Logger.getLogger("LoggingException");

    public LoggingException(){
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

/**
 * @Author:liuBai
 * @Time : 2021/7/7 14:50
 */
public class LoggingExceptions {

    public static void main(String[] args) {
        try{
            throw new LoggingException();
        }catch (LoggingException e){
            System.err.println("Caught "+e);
        }
        try{
            throw new LoggingException();
        }catch (LoggingException e){
            System.err.println("Caught "+e);
        }
    }

}
