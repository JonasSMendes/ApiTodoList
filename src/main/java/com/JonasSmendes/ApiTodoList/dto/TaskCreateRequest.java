package com.JonasSmendes.ApiTodoList.dto;

public record TaskCreateRequest(
        String title, String description, boolean completed, Integer categoryId
) {
}
