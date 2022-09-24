package com.example.day3_greetingapp.service;

import com.example.day3_greetingapp.model.Greeting;
import com.example.day3_greetingapp.model.User;
import com.example.day3_greetingapp.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    private static String template = "Hello %s";

    @Autowired
    GreetingAppRepository repo;

    public String getMessage() {
        return "Hello World";
    }

    public String getGreetingMessage(String fName, String lName) {
        return "Hello " + fName + "" + lName;
    }

    public String postMessage(User user) {
        return "Hello " + user.getfName() + "" + user.getlName();
    }

    public Greeting saveMessage(Greeting greeting) {
        Greeting newGreeting = new Greeting(String.format(template, greeting.getContent()));
        repo.save(newGreeting);
        return newGreeting;
    }

    public String getDataById(Integer id) {
        Greeting newGreeting = repo.getById(id);
        return newGreeting.getContent();
    }

    public List<Greeting> getAllData() {
        List<Greeting> list = repo.findAll();
        return list;
    }


}