package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Category;
import com.example.pathfinder.model.enums.CategoryEnum;
import com.example.pathfinder.repository.CategoryRepository;
import com.example.pathfinder.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getCategoriesByNames(List<CategoryEnum> categoryEnums) {
        return categoryRepository.findAllByNameIn(categoryEnums);
    }
}
