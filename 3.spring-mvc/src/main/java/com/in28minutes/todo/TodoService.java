package com.in28minutes.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static final List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "in28Minutes", "Learn Spring MVC", LocalDate.now(), false));
        todos.add(new Todo(2, "in28Minutes", "Learn Struts", LocalDate.now(), false));
        todos.add(new Todo(3, "in28Minutes", "Learn Hibernate", LocalDate.now(), false));
    }

    public void addTodo(String name, String desc, LocalDate targetDate, boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user))
                filteredTodos.add(todo);
        }
        return filteredTodos;
    }

    public Todo retrieveTodo(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id)
                return todo;
        }
        return null;
    }

    public void updateTodo(Todo todo) {
        todos.remove(todo);
        todos.add(todo);
    }

}
