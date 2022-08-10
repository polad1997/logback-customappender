package com.example.springboot.service;

import ch.qos.logback.classic.Logger;
import com.example.springboot.appender.FilterAppender;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestService.class);

    public void write() {
        LOGGER.info("Example logging 1 : {} ", TestService.class);
        LOGGER.info("Example logging 2 : {} ", TestService.class);
        LOGGER.info("Example logging 3 : {} ", TestService.class);

//        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
//
//        for (ch.qos.logback.classic.Logger logE : context.getLoggerList()) {
//            for (Iterator<Appender<ILoggingEvent>> index = logE.iteratorForAppenders(); index.hasNext(); ) {
//                Appender<ILoggingEvent> appender = index.next();
//                System.out.println("appender ::: " + appender.getName());
//            }
//        }


        Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        FilterAppender appender = (FilterAppender) logger.getAppender("filter");
        System.out.println("eventList:::::::::" + appender.getEventList()   );
    }


}
