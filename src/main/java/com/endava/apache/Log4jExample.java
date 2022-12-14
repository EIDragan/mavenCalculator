package com.endava.apache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jExample {
    private static final Logger LOGGER = LogManager.getLogger(Log4jExample.class);

    public void loggerTest(String s) {
        LOGGER.info("This is a test with {}", s);
    }

    public static void main(String[] args) {
        Log4jExample e = new Log4jExample();
        e.loggerTest("EEEEEE");
    }
}
