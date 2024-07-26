package com.project.gamegame.user.token;

import com.project.gamegame.user.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor

public class TokenProvider {
    @Value("${spring.jwt.secreat}")
    private String SECRET_KEY;

    public String createToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());
//        claims.put("phone", user.getPhone());
//        claims.put("name", user.getName());

        Date expiry = new Date(System.currentTimeMillis() + 3600000);

        return Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.ES512)
                .addClaims(claims)
                .setIssuer("who")
                .setIssuedAt(new Date())
                .setExpiration(expiry)
                .setSubject(String.valueOf(user.getId()))
                .compact();
    }

    public TokenUserInfo getTokenAccountUserInfo(String token) {
        Claims claims = Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .parseClaimsJws(token)
                .getBody();

        //log.info("claims : {}", claims);

        return TokenUserInfo.builder()
                .id(Long.valueOf(claims.getSubject()))
                .email(claims.get("email", String.class))
                .phone(claims.get("phoneNum", String.class))
                //.name(Claims.get("name", String.class))
                .build();
    }
}
