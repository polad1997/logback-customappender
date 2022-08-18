package com.example.springboot.service;

import ch.qos.logback.classic.Logger;
import com.example.springboot.HelloController;
import com.example.springboot.appender.FilterAppender;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static java.lang.Thread.currentThread;

@Component
public class TestService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestService.class);

    public void write() {

//        new Thread(() -> {
//            sleep(time);
//        }).start();

        LOGGER.info("Example logging 1 : {} ::::::::::: current Thread: {}  ", TestService.class, currentThread().getName());
        LOGGER.info("Example logging 2 : {} ::::::::::: current Thread: {}  ", TestService.class, currentThread().getName());
        LOGGER.info("Example logging 3 : {} ::::::::::: current Thread: {}  ", TestService.class, currentThread().getName());

//        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
//
//        for (ch.qos.logback.classic.Logger logE : context.getLoggerList()) {
//            for (Iterator<Appender<ILoggingEvent>> index = logE.iteratorForAppenders(); index.hasNext(); ) {
//                Appender<ILoggingEvent> appender = index.next();
//                System.out.println("appender ::: " + appender.getName());
//            }
//        }
    }

}
