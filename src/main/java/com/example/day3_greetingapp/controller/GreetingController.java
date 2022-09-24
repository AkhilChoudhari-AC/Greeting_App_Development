package com.example.day3_greetingapp.controller;

import com.example.day3_greetingapp.model.Greeting;
import com.example.day3_greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;


@RestController
public class GreetingController {

//   It is final, it will not change # "hello"
    private static final String template = "Hello %s!";

    //Automatically creating the counting
    private static AtomicInteger counter = new AtomicInteger();

    @Autowired
    GreetingService greetingService;
    // adding the data in database
    @GetMapping("/getGreeting")
    public Greeting greeting(@RequestParam(value="name",defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
    // creating the database
    @PostMapping("/postGreeting")
    public Greeting sayHello(@RequestBody Greeting greeting) {
        return new Greeting(counter.incrementAndGet(),String.format(template, greeting.getContent()));
    }
    // updating/ edit the data in the database
    @PutMapping("/putMapping/{counter}")
    public Greeting sayHello(@PathVariable int counter,@RequestParam (value="content") String content) {
        return new Greeting(counter,String.format(template, content));
    }
    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage(){
        return new ResponseEntity<String>(greetingService.getMessage(), HttpStatus.OK);
    }
}

