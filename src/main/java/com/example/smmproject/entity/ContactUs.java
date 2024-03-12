package com.example.smmproject.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contact_us")
public class ContactUs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<String> emails=new ArrayList<>();

    @ElementCollection
    private List<String> phoneNumbers = new ArrayList<>();

    private String location;



    public Long getId() {
        return id;
    }

    public ContactUs setId(Long id) {
        this.id = id;
        return this;
    }

    public List<String> getEmails() {
        return emails;
    }

    public ContactUs setEmails(List<String> emails) {
        this.emails = emails;
        return this;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public ContactUs setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public ContactUs setLocation(String location) {
        this.location = location;
        return this;
    }


}