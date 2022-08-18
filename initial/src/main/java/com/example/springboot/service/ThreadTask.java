package com.example.springboot.service;

import org.slf4j.LoggerFactory;

import static java.lang.Thread.currentThread;

public class ThreadTask implements Runnable {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ThreadTask.class);

    public void run() {
        magic();
    }

    public void magic() {
        LOGGER.info("Example logging 1 : {} ::::::::::: current Thread: {}  ", TestService.class, currentThread().getName());
        LOGGER.info("Example logging 2 : {} ::::::::::: current Thread: {}  ", TestService.class, currentThread().getName());
        LOGGER.info("Example logging 3 : {} ::::::::::: current Thread: {}  ", TestService.class, currentThread().getName());
    }
}