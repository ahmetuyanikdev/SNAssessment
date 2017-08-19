package com.project.repository;

import com.project.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category,String>{

    Category findByCode(String code);

    List<Category> findBySuperCategoryCode(String category);
}
