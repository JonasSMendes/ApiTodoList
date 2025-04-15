package com.JonasSmendes.ApiTodoList.dto;

public record TaskUpdateRequest(
        String title, String description, boolean completed, Integer categoryId
) {
}
