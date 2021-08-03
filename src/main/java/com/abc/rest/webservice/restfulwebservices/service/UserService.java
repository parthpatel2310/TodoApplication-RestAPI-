package com.abc.rest.webservice.restfulwebservices.service;

import com.abc.rest.webservice.restfulwebservices.JPA.UserDAO;
import com.abc.rest.webservice.restfulwebservices.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public UserBean saveUser(UserBean user)
    {
         userDAO.save(user);
         return  user;
    }

    public UserBean getUserByName(String username)
    {
        UserBean user = userDAO.findUSerBeanByUserName(username);
        return user;
    }

    public List<UserBean> findAll(){
        List<UserBean> userBeanList = userDAO.findAll();
        return  userBeanList;
    }






}
