package com.project.repository;

import com.project.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,String>{
    Category findByCode(String code);
}
