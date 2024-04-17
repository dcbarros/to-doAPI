package br.com.todolist.todo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.todolist.todo.model.TodoItem;
@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem,UUID>{
    List<TodoItem> findByTitleContaining(String title);
}
