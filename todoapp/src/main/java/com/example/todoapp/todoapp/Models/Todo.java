package com.example.todoapp.todoapp.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


@JsonIgnoreProperties(value = {"createdAt"}, allowGetters =  true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(collection = "todos")

public class Todo {



    public Todo(String id, @Size(max = 200) @NotBlank String title, Boolean completed, Date createdAt) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Id
    String id;

    @Size(max = 200)
    @NotBlank
    String title;

    Boolean completed;

    Date createdAt = new Date(System.currentTimeMillis());
}
