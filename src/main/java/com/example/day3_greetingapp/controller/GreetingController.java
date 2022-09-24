package com.example.day3_greetingapp.controller;

import com.example.day3_greetingapp.model.Greeting;
import com.example.day3_greetingapp.service.GreetingService;
import com.example.day3_greetingapp.service.User;
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

    //UC1
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
   //UC2
    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage(){
        return new ResponseEntity<String>(greetingService.getMessage(), HttpStatus.OK);
    }
    //UC3
    @GetMapping("/getGreetingMessage")
    public ResponseEntity<String>getGreetingMessage(@RequestParam(value="fName",defaultValue="World") String fName,@RequestParam(value="lName",defaultValue="") String lName){
        return new ResponseEntity<String>(greetingService.getGreetingMessage(fName,lName),HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<String> getGreeting(@RequestBody User user){
        return new ResponseEntity<String>(greetingService.postMessage(user.getfName(),user.getlName()),HttpStatus.OK);
    }
}

