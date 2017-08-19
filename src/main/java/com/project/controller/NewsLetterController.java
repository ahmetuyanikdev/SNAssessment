package com.project.controller;

import com.project.model.*;
import com.project.service.impl.BookService;
import com.project.service.impl.CategoryService;
import com.project.service.impl.SubscriberService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.function.Consumer;

@Controller
@RequestMapping(value = "/newsletter")
public class NewsLetterController {

    Logger logger = Logger.getLogger(NewsLetterController.class);

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SubscriberService subscriberService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<NewsLetter> getNewsLetters(){
        logger.warn(" === Calculating NewsLetters ===");
        List<NewsLetter> newsLetters = new LinkedList<NewsLetter>();
        List<Notification> notifications = new LinkedList<Notification>();
        List<Subscriber> subscribers = subscriberService.getAllSubscribers();
        for (Subscriber s : subscribers){
            logger.info(">> calculating for subscriber : "+s.getEmail());
            notifications.clear();
            NewsLetter newsLetter = new NewsLetter();
            newsLetter.setRecipient(s.getEmail());
            for(String categoryCode : s.getCategoryCodes()){
                String path = categoryCode.concat("-");
                generateNotifications(categoryCode,notifications,path);
            }
            newsLetter.setNotifications(notifications);
            newsLetters.add(newsLetter);
        }
        return newsLetters;
    }

    public void generateNotifications(String currentCategory, List<Notification> notifications, String pathQueue){
        List<Book> books = bookService.getAllMatchingBooks(currentCategory);
        for(Book b : books){
            Notification notification = new Notification();
            notification.setBook(b.getTitle());
            List<String>paths = Arrays.asList(pathQueue.split("-"));
            notification.setCategoryPaths(paths);
            notifications.add(notification);
        }
        pathQueue = pathQueue.concat("-").concat(currentCategory);
        List<Category> subCategories = categoryService.findSubCategories(currentCategory);
        for (Category c : subCategories){
            generateNotifications(c.getCode(),notifications,pathQueue);
        }

    }
}
