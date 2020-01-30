package com.abc.rest.webservice.restfulwebservices.service;

import com.abc.rest.webservice.restfulwebservices.JPA.TodoDAO;
import com.abc.rest.webservice.restfulwebservices.JPA.UserDAO;
import com.abc.rest.webservice.restfulwebservices.bean.TodoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {


    private  static List<TodoBean> todoList = new ArrayList();


    @Autowired
    private TodoDAO todoDAO;

    @Autowired
    private UserDAO userDAO;



    public List<TodoBean> findAll(int userId)
    {
        List<TodoBean> todoListByUser = todoDAO.findByUserId(userId);

        return todoListByUser;
    }

    public void deleteById(int id)
    {
        todoDAO.deleteById(id);
    }

    public TodoBean findById(int id)
    {
         TodoBean todo = todoDAO.findById(id).get();
            if(todo != null)
                return  todo;
        return null;
    }

    public TodoBean saveTodo(TodoBean todo)
    {
        todoDAO.save(todo);
        return todo;
    }

}
