package com.example.springboot;

import com.example.springboot.appender.FilterAppender;
import com.example.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private FilterAppender filterAppender;

    @Autowired
    private TestService service;

    @GetMapping("/logs")
    public String index() {
        service.write();
        return "Greetings from Spring Boot!";
    }

}
