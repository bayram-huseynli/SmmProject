    package com.example.smmproject.entity;

    import jakarta.persistence.*;

    @Entity
    public class WantedPacket {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "video")
        private Long video;
        @Column(name = "photo")
        private Long photo;

        @Column(name = "graphic_Post")
        private Long graphicPost;

        @Column(name = "motion_Video")
        private Long motionVideo;

        @Column(name = "location_Targeding")
        private Long locationTargeding;

        @Column(name = "menu_System")
        private Long menuSystem;

        @Column(name = "tiktok_Management")
        private Long tiktokManagement;


    }
