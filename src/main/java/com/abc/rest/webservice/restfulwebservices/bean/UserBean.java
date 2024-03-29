package com.abc.rest.webservice.restfulwebservices.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name="user")
@CrossOrigin
public class UserBean  implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int id;

    private String name;

    private String password;

    private String userName;

    @OneToOne
    @JoinColumn(name="usertypeid")
    private UserTypeBean userTypeId;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserBean(){

    }



    public UserBean(int id, String name, String password, String userName, UserTypeBean userType) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.userName = userName;
        this.userTypeId = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserTypeBean getUserType() {
        return userTypeId;
    }

    public void setUserType(UserTypeBean userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBean userBean = (UserBean) o;
        return id == userBean.id && Objects.equals(name, userBean.name) && Objects.equals(password, userBean.password) && Objects.equals(userName, userBean.userName) && Objects.equals(userTypeId, userBean.userTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, userName, userTypeId);
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", userTypeId=" + userTypeId +
                '}';
    }
}
