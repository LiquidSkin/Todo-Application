package com.example.todoapp.todoapp.Controller;

import com.example.todoapp.todoapp.Models.Todo;
import com.example.todoapp.todoapp.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin("*")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;


    @GetMapping("/todo")
    List<Todo>getAllTasks()
    {
        return todoRepository.findAll();
    }
    @PostMapping("/todo")
    ResponseEntity<Todo> addTask(@Valid @RequestBody Todo todo)
    {
        todoRepository.save(todo);
        return ResponseEntity.ok().body(todo);
    }
    @PutMapping("/todo/{id}")
    ResponseEntity<Todo> updateTask(@Valid @RequestBody Todo todo, @PathVariable String id)
    {
        return todoRepository.findById(id).map(
                oldTodo -> {
                    oldTodo.setTitle(oldTodo.getTitle());
                    oldTodo.setCompleted(oldTodo.getCompleted());
                    todoRepository.save(oldTodo);
                    return ResponseEntity.ok().body(oldTodo);
                }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/todo")
    ResponseEntity<Todo> deleteTask(@Valid @RequestBody Todo todo, @PathVariable String id)
    {
        
    }

}