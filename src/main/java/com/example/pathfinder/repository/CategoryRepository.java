package com.example.pathfinder.repository;

import com.example.pathfinder.model.entity.Category;
import com.example.pathfinder.model.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Set<Category> findAllByNameIn(List<CategoryEnum> categoryEnums);
}
