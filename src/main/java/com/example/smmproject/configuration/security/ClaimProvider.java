package com.example.smmproject.configuration.security;

import org.springframework.security.core.Authentication;

public interface ClaimProvider {

    Claim provide(Authentication authentication);
}
