package br.com.todolist.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "TODO List API",
		version = "1.0",
		description = "Documentando uma API básica de cadastro de tarefas a serem realizadas",
		contact = @Contact(name = "Davison", email = "dcbarros11@gmail.com", url = "https://www.github.com/dcbarros")
	)
)
public class ToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
	}

}
