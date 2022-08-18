package com.example.springboot.appender;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static java.lang.Thread.currentThread;

@Configuration
public class FilterAppender extends AppenderBase<ILoggingEvent> {

    private String prefix;
    private final Map<String, List<ILoggingEvent>> eventMap = new HashMap<>();

    @Override
    protected void append(ILoggingEvent eventObject) {
        if (isLoggerUnderSpecificPackage(eventObject)) {
            if (!eventMap.containsKey(currentThread().getName())) {
                List<ILoggingEvent> eventListByThreadName = new ArrayList<>();
                eventListByThreadName.add(eventObject);
                eventMap.put(currentThread().getName(), eventListByThreadName);
            } else {
                eventMap.get(currentThread().getName()).add(eventObject);
            }
        }
    }

    public Map<String, List<ILoggingEvent>> getEventMap() {
        return eventMap;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    private boolean isLoggerUnderSpecificPackage(ILoggingEvent eventObject) {
        if (!ObjectUtils.isEmpty(eventObject)) {
            return eventObject.getLoggerName().startsWith("com.example.springboot.service");
        }
        return false;
    }

}

