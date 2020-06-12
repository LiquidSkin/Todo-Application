package com.example.app.TodoApplicationBackend.Models;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;


public class Todo {

    @Id
    String id;

    @Size
    String title;
}
