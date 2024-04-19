package br.com.todolist.todo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.todolist.todo.model.TodoItem;
import br.com.todolist.todo.model.DTO.TodoItemDTO;
import br.com.todolist.todo.repository.TodoItemRepository;
import br.com.todolist.todo.service.TodoItemService;

@Service
public class TodoItemImpl implements TodoItemService{

    private TodoItemRepository todoItemRepository;

    public TodoItemImpl(TodoItemRepository todoItemRepository){
        this.todoItemRepository = todoItemRepository;
    }

    @Override
    public TodoItem save(TodoItemDTO request) {
        if(request.getTitle() == null || request.getContent() == null || request.getDate() == null) throw new RuntimeException("O item deve conter um título ou conteúdo ou data válidos");
        if(request.getTitle().isBlank() || request.getContent().isBlank()) throw new RuntimeException("O item deve conter um título e conteúdo");
        TodoItem todoItem = new TodoItem(request.getTitle(), request.getContent(), request.getDate());
        return todoItemRepository.save(todoItem);
    }

    @Override
    public List<TodoItem> getAllItens() {
        return todoItemRepository.findAll();
    }

    @Override
    public TodoItem getItemById(UUID uuid) {
        return todoItemRepository.findById(uuid)
                    .orElseThrow(() -> new RuntimeException("item com o id: " + uuid + " não foi encontrado"));
    }

    @Override
    public List<TodoItem> getItemsByTitle(String title) {
        return todoItemRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public TodoItem update(UUID uuid, TodoItemDTO request) {
        
        try {          
            TodoItem todoItem = getItemById(uuid);

            if(request.getTitle().isBlank()) request.setTitle(todoItem.getTitle());
            if(request.getContent().isBlank()) request.setContent(todoItem.getContent());
            if(request.getDate() == null) request.setDate(todoItem.getDate());

            todoItem.setTitle(request.getTitle());
            todoItem.setContent(request.getContent());
            todoItem.setDate(request.getDate());

            return todoItemRepository.save(todoItem);

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível encontrar o item.");
        }
    }

    @Override
    public void delete(UUID uuid) {
        todoItemRepository.delete(getItemById(uuid));
    }
    
    @Override
    public TodoItem changeTaskStatus(UUID uuid){
        try {
            TodoItem todoItem = getItemById(uuid);
            if(todoItem.getIsFinish() == false){
                todoItem.setIsFinish(true);
            }else{
                todoItem.setIsFinish(false);
            }
            return todoItemRepository.save(todoItem);
        } catch(Exception e){
            throw new RuntimeException("Não foi possível encontrar o item.");
        }
    }
}
