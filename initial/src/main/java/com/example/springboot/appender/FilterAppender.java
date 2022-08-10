package com.example.springboot.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Configuration
public class FilterAppender extends AppenderBase<ILoggingEvent> {

    private String prefix;
    private ConcurrentMap<String, ILoggingEvent> eventMap = new ConcurrentHashMap<>();
    private List<ILoggingEvent> eventList = Collections.synchronizedList(new ArrayList<>());

    @Override
    protected void append(ILoggingEvent eventObject) {
        if (isLoggerUnderSpecificPackage(eventObject)) eventList.add(eventObject);
    }

    public Map<String, ILoggingEvent> getEventMap() {
        return eventMap;
    }

    public List<ILoggingEvent> getEventList() {
        return eventList;
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

