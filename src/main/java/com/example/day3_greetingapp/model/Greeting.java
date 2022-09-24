package com.example.day3_greetingapp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// creating Data Structure for our class
// creating tables inside our database by name "Greeting"
@Entity
public class Greeting {

    // creating id automatically in our database
    @Id
    public Integer id;

    public String content;

    // creating blank constructor for storing data in our database # giving error if not used
    public Greeting(){

    }
    // creating parameterized construction
    public Greeting(String content) {
        this.content = content;
    }
    public Greeting(Integer id, String content){
        super();
        this.id = id;
        this.content = content;
    }

    //getter and setter for above two variable
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
