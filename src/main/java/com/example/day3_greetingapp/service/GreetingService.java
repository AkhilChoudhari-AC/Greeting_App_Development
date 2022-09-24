package com.example.day3_greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getMessage() {
        return "Hello World";
    }
    public String getGreetingMessage(String fName, String lName) {
        return "Hello "+fName+""+lName;
    }
    public String postMessage(String fName,String lName) {
        return "Hello "+fName+""+lName;
    }
}