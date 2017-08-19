package com.project.controller;

import com.project.model.Subscriber;
import com.project.service.impl.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/subscribers")
public class SubscriberController {

    @Autowired
    SubscriberService subscriberService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Subscriber save(@RequestBody Subscriber subscriber){
        subscriberService.create(subscriber);
        return subscriber;
    }

    @RequestMapping(value = "/{email:.+}",method = RequestMethod.GET)
    @ResponseBody
    public Subscriber getByEmail(@PathVariable String email){
        return subscriberService.read(email);
    }

    @RequestMapping(value = "/deleteAll",method = RequestMethod.GET)
    public void deleteAll(){
        subscriberService.delete();
    }


}

