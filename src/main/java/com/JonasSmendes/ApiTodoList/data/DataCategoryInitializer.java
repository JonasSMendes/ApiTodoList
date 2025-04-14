package com.JonasSmendes.ApiTodoList.data;

import com.JonasSmendes.ApiTodoList.model.Category;
import com.JonasSmendes.ApiTodoList.repository.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataCategoryInitializer {

    @Autowired
    private final CategoryRepository repository;

    public DataCategoryInitializer(CategoryRepository categoryRepository) {
        this.repository = categoryRepository;
    }

    @PostConstruct
    public void init(){
        createCategoryIfNotExist(1, "Casa");
        createCategoryIfNotExist(2, "Escola");
        createCategoryIfNotExist(3, "Trabalho");
        createCategoryIfNotExist(4, "Saúde");
        createCategoryIfNotExist(5, "Lazer");
    }

    private void createCategoryIfNotExist(Integer id, String name) {
        if (!repository.existsById(id)){
            Category category = new Category();
            category.setId(id);
            category.setName(name);
        }
    }
}
