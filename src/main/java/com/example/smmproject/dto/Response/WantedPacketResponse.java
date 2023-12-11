package com.example.smmproject.dto.Response;

public class WantedPacketResponse {
    private Long id;
    private Long tiktokPost;
    private Long instagramPost;
    private Long instagramStory;
    private Long tiktokStory;

    public Long getTiktokPost() {
        return tiktokPost;
    }

    public void setTiktokPost(Long tiktokPost) {
        this.tiktokPost = tiktokPost;
    }

    public Long getInstagramPost() {
        return instagramPost;
    }

    public void setInstagramPost(Long instagramPost) {
        this.instagramPost = instagramPost;
    }

    public Long getInstagramStory() {
        return instagramStory;
    }

    public void setInstagramStory(Long instagramStory) {
        this.instagramStory = instagramStory;
    }

    public Long getTiktokStory() {
        return tiktokStory;
    }

    public void setTiktokStory(Long tiktokStory) {
        this.tiktokStory = tiktokStory;
    }
}
