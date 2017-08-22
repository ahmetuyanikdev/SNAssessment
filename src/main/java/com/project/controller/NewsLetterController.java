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
        List<Subscriber> subscribers = subscriberService.getAllSubscribers();
        Map<String,Notification> bookNotificationMap = new HashMap<String,Notification>();
        for (Subscriber s : subscribers){
            logger.info(">> calculating for subscriber : "+s.getEmail());
            NewsLetter newsLetter = new NewsLetter();
            newsLetter.setRecipient(s.getEmail());
            bookNotificationMap.clear();
            for(String categoryCode : s.getCategoryCodes()){
                String path = categoryCode;
                generateNotifications(categoryCode,bookNotificationMap,path);
            }
            newsLetter.setNotifications((new ArrayList<>(bookNotificationMap.values())));
            newsLetters.add(newsLetter);
        }
        return newsLetters;
    }

    public void generateNotifications(String currentCategory, Map<String,Notification> bookNotificationMap, String pathQueue){
        if(!pathQueue.equals(currentCategory)){
            pathQueue = pathQueue.concat("-").concat(currentCategory);
        }
        List<Book> books = bookService.getAllMatchingBooks(currentCategory);
        for(Book b : books){
            logger.info(">> path : "+pathQueue);
            if(!bookNotificationMap.keySet().contains(b.getTitle())){
                Notification notification = new Notification();
                notification.setBook(b.getTitle());
                List<String> pathList= Arrays.asList(pathQueue.split("-"));

                notification.getCategoryPaths().add(pathList);
                bookNotificationMap.put(b.getTitle(),notification);
            }
            else
            {
                Notification notification = bookNotificationMap.get(b.getTitle());
                notification.getCategoryPaths().add(Arrays.asList(pathQueue.split("-")));
                bookNotificationMap.put(b.getTitle(),notification);
            }
        }
        List<Category> subCategories = categoryService.findSubCategories(currentCategory);
        for (Category c : subCategories){
            generateNotifications(c.getCode(),bookNotificationMap,pathQueue);
        }

    }
}
