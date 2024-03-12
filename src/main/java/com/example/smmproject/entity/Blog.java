package com.example.smmproject.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDate date;
    @ElementCollection
    private List<String> imageLinks;
    @ElementCollection
    private List<String> socialMediaLinks;
    private String fullName;


    @ManyToOne
    @JoinColumn(name = "blog_category_id")
    private BlogCategory blogCategory;
    public void addSocialMediaLink(String link) {
        this.socialMediaLinks.add(link);
    }

    public List<String> getSocialMediaLinks() {
        return socialMediaLinks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BlogCategory getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(BlogCategory blogCategory) {
        this.blogCategory = blogCategory;
    }

    public List<String> getImageLinks() {
        return imageLinks;
    }

    public Blog setImageLinks(List<String> imageLinks) {
        this.imageLinks = imageLinks;
        return this;
    }

    public Blog setSocialMediaLinks(List<String> socialMediaLinks) {
        this.socialMediaLinks = socialMediaLinks;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Blog setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}
