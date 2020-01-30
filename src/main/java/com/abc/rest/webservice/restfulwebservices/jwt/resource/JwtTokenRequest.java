package com.abc.rest.webservice.restfulwebservices.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {

  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
/*
{
"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU3NzExNjk4OCwiaWF0IjoxNTc2NTEyMTg4fQ.cPhDbjyJmG78QIi_pzzRxBNxL8yCzeMCQVb5uqvCcSTrsUCdTRvyY_xSTKl30XIUMw-20LWTlrIp2jxwg7NO_A"
}
 */