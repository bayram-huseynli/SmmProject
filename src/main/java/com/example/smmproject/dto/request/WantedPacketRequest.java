package com.example.smmproject.dto.request;

public class WantedPacketRequest {
    private Long video;
    private Long photo;
    private Long tiktokPost;
    private Long instagramPost;
    private Long instagramStory;
    private Long tiktokStory;

    public Long getVideo() {
        return video;
    }

    public void setVideo(Long video) {
        this.video = video;
    }

    public Long getPhoto() {
        return photo;
    }

    public void setPhoto(Long photo) {
        this.photo = photo;
    }

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
