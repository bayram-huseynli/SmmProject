package com.example.smmproject.dto.Response;

import java.time.LocalDate;

public class BlogResponse {
    private Long id;
    private Long blogCategoryId;
    private String title;
    private String content;
    private LocalDate date;

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long blogCategoryId() {
        return blogCategoryId;
    }

    public void setBlogCategoryId(Long blogCategoryId) {
        this.blogCategoryId = blogCategoryId;
    }

    public String title() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String content() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate date() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
