package com.example.todoapp.todoapp.Repository;


import com.example.todoapp.todoapp.Models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
}
