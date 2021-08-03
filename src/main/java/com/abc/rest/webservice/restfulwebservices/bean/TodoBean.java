package com.abc.rest.webservice.restfulwebservices.bean;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="todo")
@CrossOrigin
public class TodoBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="userid")
    private UserBean userId;

    private String description;

    @Column(columnDefinition = "DATE")
    private LocalDate targetDate;

    private boolean status;

    public TodoBean() {
    }

    public TodoBean(Integer id, UserBean userId, String description, LocalDate targetDate, boolean status) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.targetDate = targetDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserBean getUserId() {
        return userId;
    }

    public void setUserId(UserBean userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoBean)) return false;
        TodoBean todoBean = (TodoBean) o;
        return getId() == todoBean.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TodoBean{" +
                "id=" + id +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", status=" + status +
                '}';
    }
}
