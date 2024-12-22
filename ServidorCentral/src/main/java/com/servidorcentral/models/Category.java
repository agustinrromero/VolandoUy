package com.servidorcentral.models;

import com.servidorcentral.dtos.CategoryDTO;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}

