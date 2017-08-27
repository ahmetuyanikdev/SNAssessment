package com.project.service;

import com.project.model.Category;
import com.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category save(Category obj) {
        Category category = obj;
        categoryRepository.save(category);
        return category;
    }

    public Category read(String code) {
        Category category = categoryRepository.findByCode(code);
        return category;
    }

    public List<Category> findSubCategories(String category) {
        return categoryRepository.findBySuperCategoryCode(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void deleteAll() {
        categoryRepository.deleteAll();
    }
}
