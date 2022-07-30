package com.in28minutes.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {
	@Autowired
	TodoService service;

	@GetMapping("/todos")
	public List<Todo> retrieveAllTodos() {
		return service.retrieveTodos("in28Minutes");
	}

	@GetMapping("/todos/{id}")
	public Todo retrieveTodo(@PathVariable int id) {
		return service.retrieveTodo(id);
	}

}
