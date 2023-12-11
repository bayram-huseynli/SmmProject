    package com.example.smmproject.entity;

    import javax.persistence.*;

    @Entity
    public class WantedPacket {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "tiktok_post")
        private Long tiktokPost;
        @Column(name = "instagram_post")
        private Long instagramPost;

        @Column(name = "instagram_story")
        private Long instagramStory;

        @Column(name = "tiktok_story")
        private Long tiktokStory;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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
