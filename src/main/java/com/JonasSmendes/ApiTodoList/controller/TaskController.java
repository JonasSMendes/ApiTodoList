package com.JonasSmendes.ApiTodoList.controller;

import com.JonasSmendes.ApiTodoList.dto.TaskCreateRequest;
import com.JonasSmendes.ApiTodoList.dto.TaskUpdateRequest;
import com.JonasSmendes.ApiTodoList.model.Category;
import com.JonasSmendes.ApiTodoList.model.Task;
import com.JonasSmendes.ApiTodoList.repository.CategoryRepository;
import com.JonasSmendes.ApiTodoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class TaskController {

    @Autowired
    private final TaskRepository taskRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

    public TaskController(TaskRepository taskRepository, CategoryRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Task>> getTasksByCategory (@PathVariable Integer id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        List<Task> taskList = taskRepository.findByCategory(categoryOptional.get());

        return ResponseEntity.ok(taskList);
    }

    @PostMapping("/{id}/task")
    public ResponseEntity<Task> postTask (@PathVariable Integer id, @RequestBody TaskCreateRequest createRequest){

        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Category category = categoryOptional.get();

        Task task = new Task();
        task.setTitle(createRequest.title());
        task.setDescription(createRequest.description());
        task.setCompleted(createRequest.completed());
        task.setCategory(category);

        Task taskResponse = taskRepository.save(task);
        return ResponseEntity.ok(taskResponse);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Task> putTask (@PathVariable Long id, @RequestBody TaskUpdateRequest taskUpdateRequest){
        Optional<Task> taskOptional = taskRepository.findById(id);
        if(taskOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Optional<Category> categoryOptional = categoryRepository.findById(taskUpdateRequest.categoryId());
        if (categoryOptional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Task existingTask = taskOptional.get();
        existingTask.setTitle(taskUpdateRequest.title());
        existingTask.setDescription(taskUpdateRequest.description());
        existingTask.setCompleted(taskUpdateRequest.completed());
        existingTask.setCategory(categoryOptional.get());

        Task taskResponse = taskRepository.save(existingTask);
        return ResponseEntity.ok(taskResponse);

    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deteleTask(@PathVariable Long id){
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
         taskRepository.delete(taskOptional.get());

        return ResponseEntity.noContent().build();
    }
}
