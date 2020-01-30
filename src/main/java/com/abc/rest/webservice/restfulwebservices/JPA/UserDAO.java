package com.abc.rest.webservice.restfulwebservices.JPA;

import com.abc.rest.webservice.restfulwebservices.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserDAO extends JpaRepository<UserBean,Integer> {

    UserBean findUSerBeanByUserName(String userName);

}
