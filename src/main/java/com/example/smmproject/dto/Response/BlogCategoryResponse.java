package com.example.smmproject.dto.Response;

public class BlogCategoryResponse {
   private Long id;
   private String blogType;

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
}
