package com.project.model;

import java.util.LinkedList;
import java.util.List;

public class Notification {

    String book;

    public Notification() {
        categoryPaths = new LinkedList<>();
    }

    List<List<String>> categoryPaths;

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public List<List<String>> getCategoryPaths() {
        return categoryPaths;
    }

    public void setCategoryPaths(List<List<String>> categoryPaths) {
        this.categoryPaths = categoryPaths;
    }
}
