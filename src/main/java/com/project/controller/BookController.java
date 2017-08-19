package com.project.controller;

import com.project.model.Book;
import com.project.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Book save(@RequestBody Book book){
        bookService.save(book);
        return book;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getAll(){
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/deleteAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Book> deleteAll(){
        bookService.deleteAll();
        return bookService.getAllBooks();
    }


}
