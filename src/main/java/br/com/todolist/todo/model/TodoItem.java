package br.com.todolist.todo.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TodoItem {
    
    @Id
    @UuidGenerator
    private UUID id;
    private String title;
    private String content;
    private LocalDateTime date;
    private Boolean isFinish;
    
    
    public TodoItem(String title, String content, LocalDateTime date) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.isFinish = false;
    }
    
    public TodoItem() {
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Boolean getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Boolean isFinish) {
        this.isFinish = isFinish;
    }
    
}
