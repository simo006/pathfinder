package com.example.pathfinder.service;

import com.example.pathfinder.model.entity.Category;
import com.example.pathfinder.model.enums.CategoryEnum;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    Set<Category> getCategoriesByNames(List<CategoryEnum> categoryEnums);
}
