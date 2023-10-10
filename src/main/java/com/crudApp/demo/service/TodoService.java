package com.crudApp.demo.service;

import com.crudApp.demo.model.Todo;
import com.crudApp.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    // Pobranie wszystkich zadań
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // Pobranie zadania po ID
    public Todo getTodoById(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isPresent()) {
            return todo.get();
        } else {
            throw new RuntimeException("Todo not found for id :: " + id);
        }
    }

    // Utworzenie nowego zadania
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // Aktualizacja istniejącego zadania
    public Todo updateTodo(Long id, Todo todoDetails) {
        Optional<Todo> todoOptional = todoRepository.findById(id);

        if(todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            todo.setTitle(todoDetails.getTitle());
            todo.setDescription(todoDetails.getDescription());
            todo.setStatus(todoDetails.getStatus());
            todo.setDueDate(todoDetails.getDueDate());
            return todoRepository.save(todo);
        } else {
            throw new RuntimeException("Todo not found for id :: " + id);
        }
    }

    // Usunięcie zadania
    public void deleteTodo(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isPresent()) {
            todoRepository.delete(todo.get());
        } else {
            throw new RuntimeException("Todo not found for id :: " + id);
        }
    }
}
