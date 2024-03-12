package com.example.smmproject.dto.response;

import java.util.List;

public class ContactUsResponse {
    private Long id;
    private List<String> emails;
    private List<String> phoneNumbers;
    private String location;

    public Long getId() {
        return id;
    }

    public ContactUsResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public List<String> getEmails() {
        return emails;
    }

    public ContactUsResponse setEmails(List<String> emails) {
        this.emails = emails;
        return this;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public ContactUsResponse setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public ContactUsResponse setLocation(String location) {
        this.location = location;
        return this;
    }
}
