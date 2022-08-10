package com.example.springboot.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.springframework.context.annotation.Configuration;

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
        if (prefix == null || "".equals(prefix)) {
            addError("Prefix is not set for FilterAppender.");
            return;
        }
//        eventMap.put(prefix + System.currentTimeMillis(), eventObject);
        System.out.println("eventObject.getLoggerName ::::::::::: " + eventObject.getLoggerName());
        eventList.add(eventObject);
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

}

