package com.example.day3_greetingapp.controller;

import com.example.day3_greetingapp.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello %s!";

    //Automatically creating the counting
    private static AtomicInteger counter = new AtomicInteger();
    // adding the data from database
    @GetMapping("/getGreeting")
    public Greeting greeting(@RequestParam(value="name",defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
    // creating the database
    @PostMapping("/postGreeting")
    public Greeting sayHello(@RequestBody Greeting greeting) {
        return new Greeting(counter.incrementAndGet(),String.format(template, greeting.getContent()));
    }
    // updating/ edit the data in the data base
    @PutMapping("/putMapping/{counter}")
    public Greeting sayHello(@PathVariable int counter,@RequestParam (value="content") String content) {
        return new Greeting(counter,String.format(template, content));
    }
}

