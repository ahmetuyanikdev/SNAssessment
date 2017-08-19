package com.project.repository;

import com.project.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,String>{
    List<Book> findByCategoryCodes(String categoryCode);
}
