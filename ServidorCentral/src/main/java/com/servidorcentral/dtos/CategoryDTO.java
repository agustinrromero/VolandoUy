package com.servidorcentral.dtos;

import com.servidorcentral.models.Category;

public record CategoryDTO(String name) {

    public CategoryDTO(Category category) {
        this(category.getName());
    }
}

