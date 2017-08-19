package com.project.model;

import java.util.List;

public class Notification {

    String book;

    List<String> categoryPaths;

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public List<String> getCategoryPaths() {
        return categoryPaths;
    }

    public void setCategoryPaths(List<String> categoryPaths) {
        this.categoryPaths = categoryPaths;
    }
}
