package com.servidorcentral.models;

import com.servidorcentral.dtos.CategoryDTO;

public class Category {

    private String name;

    public Category(String name) {
        this.name = name;
    }

    // Getters
    public String getName() {
        return name;
    }

    // Other methods
    public CategoryDTO getDTO() {
        return new CategoryDTO(this);
    }

}

