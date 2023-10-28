package com.example.smmproject.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "blog_category")
public class BlogCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String blogType;
    @OneToMany(mappedBy = "blogCategory")
    private List<Blog> blogs;

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String blogType() {
        return blogType;
    }

    public void setBlogType(String blogType) {
        this.blogType = blogType;
    }

    public List<Blog> blogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
