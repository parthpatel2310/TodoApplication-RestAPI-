package com.abc.rest.webservice.restfulwebservices.controller;

import com.abc.rest.webservice.restfulwebservices.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HelloWorldController {

    @GetMapping("/helloWorld/{name}")
    public HelloWorldBean helloWorld(@PathVariable String name)
    {
        return new HelloWorldBean("Welcome "+name);
    }

   @GetMapping("/helloWorldBean")
    public HelloWorldBean helloWorldBean()
    {
        return new HelloWorldBean("HOw are you");
    }






}
