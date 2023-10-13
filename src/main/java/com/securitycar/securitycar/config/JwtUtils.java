package com.securitycar.securitycar.config;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.MacAlgorithm;
import io.jsonwebtoken.security.SecureDigestAlgorithm;

@Component
public class JwtUtils {
    @Value("${jwt.secret.key}")
    private String secretKey;
    @Value("${jwt.expiration.time}")
    private String timeExpiration;

    public String generateToken(String username) {
        var builder = Jwts.builder();
        builder.subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExpiration)));
        return builder.signWith(getSignatureKey(), Jwts.SIG.HS256).compact();
    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSignatureKey())
                    .build().parseSignedClaims(token)
                    .getPayload();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Claims allClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignatureKey())
                .build().parseSignedClaims(token)
                .getPayload();
    }

    // public String getClaims(String token, String key) {
    // return Jwts.parser()
    // .verifyWith(getSignatureKey())
    // .build().parseSignedClaims(token)
    // .getBody();
    // }

    public SecretKey getSignatureKey() {
        byte[] keysBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keysBytes);
    }
}
