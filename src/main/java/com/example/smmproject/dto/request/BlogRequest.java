package com.example.smmproject.dto.request;


import java.time.LocalDate;
import java.util.List;

public class BlogRequest {
    private Long blogCategoryId;
    private String title;
    private String content;
    private LocalDate date;
    private List<String> socialMediaLinks;
    private List<String> imageLinks;
    private String fullName;


    public List<String> getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(List<String> imageLinks) {
        this.imageLinks = imageLinks;
    }

    public List<String> getSocialMediaLinks() {
        return socialMediaLinks;
    }

    public void setSocialMediaLinks(List<String> socialMediaLinks) {
        this.socialMediaLinks = socialMediaLinks;
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

    public String getFullName() {
        return fullName;
    }

    public BlogRequest setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}
