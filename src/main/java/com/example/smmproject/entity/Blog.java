package com.example.smmproject.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Lob
    private String content;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "blog_category_id")
    private BlogCategory blogCategory;

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BlogCategory blogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(BlogCategory blogCategory) {
        this.blogCategory = blogCategory;
    }
}
