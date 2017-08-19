package com.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Category {
    @Id
    private String code;

    private String title;

    private String superCategoryCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSuperCategoryCode() {
        return superCategoryCode;
    }

    public void setSuperCategoryCode(String superCategoryCode) {
        this.superCategoryCode = superCategoryCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
