package com.JonasSmendes.ApiTodoList.repository;

import com.JonasSmendes.ApiTodoList.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
