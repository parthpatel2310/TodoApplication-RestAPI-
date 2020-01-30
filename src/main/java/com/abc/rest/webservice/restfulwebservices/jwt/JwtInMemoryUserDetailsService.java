package com.abc.rest.webservice.restfulwebservices.jwt;

import com.abc.rest.webservice.restfulwebservices.JPA.UserDAO;
import com.abc.rest.webservice.restfulwebservices.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  @Autowired
  private UserDAO userDAO;

  @Override
  public UserBean loadUserByUsername(String username) throws UsernameNotFoundException {
  UserBean user = userDAO.findUSerBeanByUserName(username);
    if (user == null) {
    throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
  }
    return user;
}

}