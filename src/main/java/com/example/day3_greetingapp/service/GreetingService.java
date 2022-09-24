package com.example.day3_greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getMessage() {
        return "Hello World";
    }
}