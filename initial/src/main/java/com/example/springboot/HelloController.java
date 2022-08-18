package com.example.springboot;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.example.springboot.appender.FilterAppender;
import com.example.springboot.service.TestService;
import com.example.springboot.service.ThreadTask;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static java.lang.Thread.currentThread;

@RestController
public class HelloController {

    @Autowired
    private FilterAppender filterAppender;

    @Autowired
    private TestService service;

    @GetMapping("/logs")
    public ResponseEntity<?> index() {

//        service.write();

        Thread thread1 = new Thread(new ThreadTask());
        Thread thread2 = new Thread(new ThreadTask());
        Thread thread3 = new Thread(new ThreadTask());

        thread1.start();
        thread2.start();
        thread3.start();

        Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        FilterAppender appender = (FilterAppender) logger.getAppender("filter");
        return ResponseEntity.ok(appender.getEventMap());
    }
}
