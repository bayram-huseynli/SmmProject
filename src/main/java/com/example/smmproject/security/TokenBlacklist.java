package com.example.smmproject.security;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class TokenBlacklist {

    private ConcurrentHashMap<String, Long> blacklist = new ConcurrentHashMap<>();

    public void blacklistToken(String token, long expiryDate) {
        blacklist.put(token, expiryDate);
    }

    public boolean isTokenBlacklisted(String token) {
        Long expiryDate = blacklist.get(token);
        if (expiryDate == null) {
            return false;
        }
        return System.currentTimeMillis() <= expiryDate;
    }
}

