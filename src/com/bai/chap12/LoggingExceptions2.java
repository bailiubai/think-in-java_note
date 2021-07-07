package com.bai.chap12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @Author:liuBai
 * @Time : 2021/7/7 15:19
 */
public class LoggingExceptions2 {

    private static Logger logger = Logger.getLogger("LoggingExceptions2");

    static void logException(Exception e){
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        try{
            throw new NullPointerException();
        }catch (NullPointerException e){
            logException(e);
        }
    }

}
