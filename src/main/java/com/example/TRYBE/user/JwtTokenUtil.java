package com.example.TRYBE.user;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtTokenUtil {
    public static String createToken(String email, String key, long expireTimeMs) {
        Claims claims = Jwts.claims();
        claims.put("email", email);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, key)
                .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs))
                .compact();
    }

    public static String getEmail(String token, String secretKey){
        return extractClaim(token, secretKey).get("email").toString();
    }

    public static boolean isExpired(String token, String secretKey){
        Date expiredDate = extractClaim(token, secretKey).getExpiration();
        return expiredDate.before(new Date());
    }

    private static Claims extractClaim(String token, String secretKey){
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
