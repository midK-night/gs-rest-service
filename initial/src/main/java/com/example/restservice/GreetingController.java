package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting") //@GetMapping annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method.
    public Greeting greeting(
        @RequestParam(value = "name", defaultValue = "World") String name) //@RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method. If the name parameter is absent in the request, the defaultValue of World is used.
        {
            return new Greeting(
                counter.incrementAndGet(), // increases id, fetches it
                 String.format(template, name)) // formats template with name, if no = World
    }
}