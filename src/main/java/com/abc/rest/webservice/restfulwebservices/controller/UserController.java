package com.abc.rest.webservice.restfulwebservices.controller;

import com.abc.rest.webservice.restfulwebservices.bean.UserBean;
import com.abc.rest.webservice.restfulwebservices.jwt.JwtTokenUtil;
import com.abc.rest.webservice.restfulwebservices.jwt.resource.AuthenticationException;
import com.abc.rest.webservice.restfulwebservices.jwt.resource.JwtTokenResponse;
import com.abc.rest.webservice.restfulwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/users/createusers")
    public ResponseEntity<?> saveTodo(@RequestBody UserBean user)
    {
        UserBean users = userService.getUserByName(user.getUsername());
        if(users != null)
        {
            return  new ResponseEntity<>("Username alreay exist",HttpStatus.PRECONDITION_FAILED);
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        UserBean createdUser = userService.saveUser(user);
        if(createdUser != null) {

            final UserDetails userDetails = createdUser;

            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new JwtTokenResponse(token));
        }
        return  ResponseEntity.notFound().build();
    }

    @GetMapping("/users/getuserdetails/{username}")
    public ResponseEntity<UserBean> getUserDetails(@PathVariable String username)
    {

        UserBean users = userService.getUserByName(username);
        if(users != null)
        {
            return new ResponseEntity<UserBean>(users, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

}
