package br.com.todolist.todo.service;

import java.util.List;
import java.util.UUID;

import br.com.todolist.todo.model.TodoItem;
import br.com.todolist.todo.model.DTO.TodoItemDTO;

public interface TodoItemService {
    TodoItem save(TodoItemDTO request);
    List<TodoItem> getAllItens();
    TodoItem getItemById(UUID uuid);
    List<TodoItem> getItemsByTitle(String title);
    TodoItem update(UUID uuid, TodoItemDTO request);
    TodoItem changeTaskStatus(UUID uuid);
    void delete(UUID uuid);
}
