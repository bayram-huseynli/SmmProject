package com.example.smmproject.dto.Request;


import java.time.LocalDate;

public class BlogRequest {
    private Long blogCategoryId;
    private String title;
    private String content;
    private LocalDate date;

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
