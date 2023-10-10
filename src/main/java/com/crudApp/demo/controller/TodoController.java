package com.crudApp.demo.controller;

import com.crudApp.demo.model.Todo;
import com.crudApp.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    // Pobranie wszystkich zadań
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    // Pobranie zadania po ID
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }

    // Utworzenie nowego zadania
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    // Aktualizacja istniejącego zadania
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id,
                           @RequestBody Todo todoDetails) {
        return todoService.updateTodo(id, todoDetails);
    }

    // Usunięcie zadania
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }
}
