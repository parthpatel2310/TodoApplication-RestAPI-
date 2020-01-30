package com.abc.rest.webservice.restfulwebservices.controller;

import com.abc.rest.webservice.restfulwebservices.bean.TodoBean;
import com.abc.rest.webservice.restfulwebservices.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{userId}/todos")
    public List<TodoBean> getAllTodos(@PathVariable int userId)
    {
        Object[] rowStartIdxAndCount= new Object[5];
        String search = (String) rowStartIdxAndCount[4];
        Long pageNo = (Long) rowStartIdxAndCount[0];
        Long pageLength = (Long) rowStartIdxAndCount[1];
        String sortColumn = (String) rowStartIdxAndCount[2];
        String sortDirection = (String) rowStartIdxAndCount[3];


        return todoService.findAll(userId);
    }

    @DeleteMapping("/users/deletetodos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int id)
    {
       todoService.deleteById(id);
       return ResponseEntity.noContent().build();

    }

    @GetMapping("/users/todosbyid/{id}")
    public TodoBean getTodo(@PathVariable int id)
    {
        TodoBean todo = todoService.findById(id);
        return todo;
    }

    @PutMapping("/users/updatetodos/{id}")
    public ResponseEntity<TodoBean>  updateTodo(@PathVariable int id,@RequestBody TodoBean todo)
    {
        TodoBean updatedTodo = todoService.saveTodo(todo);
        if(todo != null) {
            return new ResponseEntity<TodoBean>(todo, HttpStatus.OK);
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping("/users/createtodos")
    public ResponseEntity<TodoBean>  saveTodo(@RequestBody TodoBean todo)
    {

        TodoBean updatedTodo = todoService.saveTodo(todo);
        if(todo != null) {
            return new ResponseEntity<TodoBean>(todo, HttpStatus.OK);
        }
        return  ResponseEntity.notFound().build();
    }



}
