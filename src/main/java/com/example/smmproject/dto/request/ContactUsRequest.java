package com.example.smmproject.dto.request;


import java.util.List;

public class ContactUsRequest {
    private List<String> emails;
    private List<String> phoneNumbers;
    private String location;

    public List<String> getEmails() {
        return emails;
    }

    public ContactUsRequest setEmails(List<String> emails) {
        this.emails = emails;
        return this;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public ContactUsRequest setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public ContactUsRequest setLocation(String location) {
        this.location = location;
        return this;
    }
}
