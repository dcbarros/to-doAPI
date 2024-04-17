package br.com.todolist.todo.model;

import java.util.UUID;

import jakarta.persistence.Id;

public class Users {
    
    @Id
    private UUID uuid;
    private String email;
    private String password;

    public Users(){}
    
    public Users(String email, String password) {
        this.uuid = UUID.randomUUID();
        this.email = email;
        this.password = password;
    }

    public UUID getUuid() {
        return uuid;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
