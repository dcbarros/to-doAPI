package br.com.todolist.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.todolist.todo.model.TodoItem;
import br.com.todolist.todo.model.DTO.TodoItemDTO;
import br.com.todolist.todo.service.TodoItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("todo")
public class TodoItemsController {
    
    private TodoItemService todoItemService;

    public TodoItemsController(TodoItemService todoItemService){
        this.todoItemService = todoItemService;
    }

    @GetMapping
    @Operation(summary = "Rota responsável pelo listagem os itens que estão salvos na lista do to-do")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Listagem de itens",
            content = {
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TodoItem.class)
                )
            }
        )
    })
    public ResponseEntity<Iterable<TodoItem>> getAll() {
        return ResponseEntity.ok(todoItemService.getAllItens());
    }

    @GetMapping("/{uuid}")
    @Operation(summary = "Rota responsável pela localização do item")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Listagem do item",
            content = {
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TodoItem.class)
                )
            }
        ),
        @ApiResponse(
            responseCode = "400", 
            description = "Informação inválida",
            content = {
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TodoItem.class)
                )
            }
        )
    })
    public ResponseEntity<TodoItem> getItemByUUID(@PathVariable UUID uuid) {
        return ResponseEntity.ok(todoItemService.getItemById(uuid));
    }

    @PostMapping
    @Operation(summary = "Rota responsável pelo cadastro do item")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Item cadastrado",
            content = {
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TodoItem.class)
                )
            }
        )
    })
    public ResponseEntity<TodoItem> newItem(@RequestBody TodoItemDTO request) {
        try {
            TodoItem todoItem = todoItemService.save(request);
            return ResponseEntity.ok(todoItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{uuid}")
    @Operation(summary = "Rota responsável pela atualização do item")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Item atualizado",
            content = {
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TodoItem.class)
                )
            }
        )
    })
    public ResponseEntity<TodoItem> updateItem(@PathVariable UUID uuid, @RequestBody TodoItemDTO request) {
        try {
            TodoItem todoItem = todoItemService.update(uuid,request);
            return ResponseEntity.ok(todoItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("isFinishTask/{uuid}")
    @Operation(summary = "Rota responsável pelo troca de finalização do item")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Item atualizado",
            content = {
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TodoItem.class)
                )
            }
        )
    })
    public ResponseEntity<TodoItem> putMethodName(@PathVariable UUID uuid) {
        return ResponseEntity.ok(todoItemService.changeTaskStatus(uuid));
    }

    @DeleteMapping("/{uuid}")
    @Operation(summary = "Rota responsável pela exclusão do item")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Item excluido",
            content = {
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TodoItem.class)
                )
            }
        )
    })
    public ResponseEntity<Void> deleteItem(@PathVariable UUID uuid){
        todoItemService.delete(uuid);
        return ResponseEntity.ok().build();
    }
    
    
    
}
