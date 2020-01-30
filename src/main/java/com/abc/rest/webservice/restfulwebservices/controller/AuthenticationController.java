package com.abc.rest.webservice.restfulwebservices.controller;

import com.abc.rest.webservice.restfulwebservices.bean.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AuthenticationController {


   @GetMapping("/checklogin")
    public AuthenticationBean authenticationBean()
    {
        return new AuthenticationBean("HOw are you");

    }






}
