package com.project.controller;


import com.project.model.Category;
import com.project.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Category save(@RequestBody Category category){
        categoryService.save(category);
        return category;
    }

    @RequestMapping(value = "/deleteAll",method = RequestMethod.GET)
    public void deleteAll(){
        categoryService.deleteAll();
    }

    @RequestMapping(value = "/{code}",method = RequestMethod.GET)
    @ResponseBody
    public Category getByCode(@PathVariable String code){
        Category category =categoryService.read(code);
        return category;
    }

}
