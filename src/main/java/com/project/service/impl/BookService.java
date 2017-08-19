package com.project.service.impl;

import com.project.model.Book;
import com.project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book save(Book book){
        bookRepository.save(book);
        return book;
    }

    public List<Book> getAllMatchingBooks(String categoryCode){
       return bookRepository.findByCategoryCodes(categoryCode);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void deleteAll(){
        bookRepository.deleteAll();
    }


}
