package com.project.controller;

import com.project.model.Subscriber;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/newsletter")
public class NewsLetterController {
    Logger logger = Logger.getLogger(NewsLetterController.class);

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Subscriber> getNewsLetters(){
        logger.warn("=== returning all news letters method hit ===");
        return null;
    }



}
