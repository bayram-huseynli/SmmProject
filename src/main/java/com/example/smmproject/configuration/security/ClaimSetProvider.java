package com.example.smmproject.configuration.security;

import org.springframework.security.core.Authentication;

public interface ClaimSetProvider {

    ClaimSet provide(Authentication authentication);
}
