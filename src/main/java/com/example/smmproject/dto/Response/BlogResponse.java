package com.example.smmproject.dto.Response;

import java.time.LocalDate;
import java.util.List;

public class BlogResponse {
    private Long id;
    private Long blogCategoryId;
    private String title;
    private String content;
    private LocalDate date;

    private List<String> socialMediaLinks;

    public List<String> getSocialMediaLinks() {
        return socialMediaLinks;
    }

    public void setSocialMediaLinks(List<String> socialMediaLinks) {
        this.socialMediaLinks = socialMediaLinks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBlogCategoryId() {
        return blogCategoryId;
    }

    public void setBlogCategoryId(Long blogCategoryId) {
        this.blogCategoryId = blogCategoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
