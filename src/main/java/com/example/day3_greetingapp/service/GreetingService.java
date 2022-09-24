package com.example.day3_greetingapp.service;

import com.example.day3_greetingapp.model.Greeting;
import com.example.day3_greetingapp.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.day3_greetingapp.controller.GreetingController.template;

@Service
public class GreetingService {

    @Autowired
    GreetingAppRepository repo;
    public String getMessage() {
        return "Hello World";
    }
    public String getGreetingMessage(String fName, String lName) {
        return "Hello "+fName+""+lName;
    }
    public String postMessage(String fName,String lName) {
        return "Hello "+fName+""+lName;
    }
    public Greeting saveMessage(Greeting greeting) {
        Greeting newGreeting=new Greeting(String.format(template,greeting.getContent()));
        repo.save(newGreeting);
        return newGreeting;
    }
    public String getData(Integer id) {
        Greeting newGreeting=repo.getById(id);
        return newGreeting.getContent();
    }
}