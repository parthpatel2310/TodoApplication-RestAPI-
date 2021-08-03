package com.abc.rest.webservice.restfulwebservices.bean;

import org.springframework.web.bind.annotation.CrossOrigin;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="USERTYPE")
@CrossOrigin
public class UserTypeBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usertypeid")
    private int id;

    private String userTypeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public UserTypeBean(){
    }

    public UserTypeBean(int id) {
        this.id = id;
    }

    public UserTypeBean(int i, String user) {
        id =i;
        userTypeName = user;
    }
}
