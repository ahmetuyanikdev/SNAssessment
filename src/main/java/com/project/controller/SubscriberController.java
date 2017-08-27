package com.project.controller;

import com.project.model.Subscriber;
import com.project.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/subscribers")
public class SubscriberController {

    @Autowired
    SubscriberService subscriberService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Subscriber save(@RequestBody Subscriber subscriber) {
        subscriberService.create(subscriber);
        return subscriber;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Subscriber> getAll() {
        return subscriberService.getAllSubscribers();
    }

    @RequestMapping(value = "/{email:.+}", method = RequestMethod.GET)
    @ResponseBody
    public Subscriber getByEmail(@PathVariable String email) {
        return subscriberService.read(email);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Subscriber> deleteAll() {
        subscriberService.delete();
        return subscriberService.getAllSubscribers();
    }


}

