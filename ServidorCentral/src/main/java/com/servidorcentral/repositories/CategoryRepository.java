package com.servidorcentral.repositories;

import com.servidorcentral.models.Category;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CategoryRepository {

    private static CategoryRepository instance;
    private final Set<Category> categories;

    private CategoryRepository() {
        this.categories = new HashSet<>();
    }

    public static CategoryRepository getInstance() {
        if (instance == null) {
            instance = new CategoryRepository();
        }
        return instance;
    }

    public Set<String> getAllCategories() {
        return this.categories.stream()
                .map(Category::getName)
                .collect(Collectors.toSet());
    }

}

