package com.JonasSmendes.ApiTodoList.repository;

import com.JonasSmendes.ApiTodoList.model.Category;
import com.JonasSmendes.ApiTodoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Task> findById(Long id);
}
