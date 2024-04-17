package br.com.todolist.todo.model.DTO;

import java.time.LocalDateTime;

public class TodoItemDTO {
    private String title;
    private String content;
    private LocalDateTime date;
    
    public TodoItemDTO(String title, String content, LocalDateTime date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }
    
    public TodoItemDTO() {
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

    
}
