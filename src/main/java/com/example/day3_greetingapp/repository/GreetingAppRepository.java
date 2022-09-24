package com.example.day3_greetingapp.repository;


import com.example.day3_greetingapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingAppRepository extends JpaRepository<Greeting, Integer> {};