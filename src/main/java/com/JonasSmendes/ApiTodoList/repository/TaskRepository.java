package com.JonasSmendes.ApiTodoList.repository;

import com.JonasSmendes.ApiTodoList.model.Category;
import com.JonasSmendes.ApiTodoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Category> findByCategory(Category category);
}
