package com.example.smmproject.configuration.security;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtService {

    private final Set<ClaimProvider> claimProvider;

    private final Set<ClaimSetProvider> claimSetProviders;

    private final SecurityProperties securityProperties;

    private Key key;

    public Claim parseToken(String token) {

        return (Claim) Jwts.parser();
    }

    public String issueToken(Authentication authentication, Duration duration) {
        log.info("Issue JWT token for {} for {}", authentication.getPrincipal(), duration);

        final JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(authentication.getName())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plus(duration)))
                .setHeaderParam("type", "JWT")
                .signWith(SignatureAlgorithm.HS512, key);

        addClaims(jwtBuilder, authentication);
        addClaimSets(jwtBuilder, authentication);

        return jwtBuilder.compact();
    }

    private JwtBuilder addClaims(JwtBuilder jwtBuilder, Authentication authentication) {
        claimProvider.forEach(claimProvider -> {
            Claim claim = claimProvider.provide(authentication);
            log.info("Adding claim {}", claim);
            jwtBuilder.claim(claim.getKey(), claim.getClaim());
        });
        return jwtBuilder;
    }

    private JwtBuilder addClaimSets(JwtBuilder jwtBuilder, Authentication authentication) {
        claimSetProviders.forEach(claimSetProvider -> {
            ClaimSet claimSet = claimSetProvider.provide(authentication);
            log.info("Adding claim set {}", claimSet);
            jwtBuilder.claim(claimSet.getKey(), claimSet.getClaim());
        });
        return jwtBuilder;
    }
}
