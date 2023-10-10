package com.crudApp.demo.repository;

import com.crudApp.demo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByStatus(Boolean status);
    List<Todo> findByStatusOrderByDueDateAsc(Boolean status);
    List<Todo> findByStatusOrderByDueDateDesc(Boolean status);
    List<Todo> findByDueDateBefore(LocalDate date);
    List<Todo> findByDueDateAfter(LocalDate date);
    List<Todo> findByTitleContaining(String titleFragment);






}

