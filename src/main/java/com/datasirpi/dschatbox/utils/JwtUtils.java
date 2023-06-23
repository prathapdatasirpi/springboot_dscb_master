package com.datasirpi.dschatbox.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    @Value("${expiry-duration}")
    private long expiryDuration;

    @Value("${jwt-secret-key}")
    private String secret;

    public String generateJwt() {

        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;

        Date issuedAt = new Date();
        Date expiryAt = new Date(expiryTime);

        // claims
        Claims claims = Jwts.claims()
                .setIssuer(String.valueOf("employeeEntity"))
                .setIssuedAt(issuedAt);
//                .setExpiration(expiryAt);  //commented temporarily

        // set extra variables in token
        claims.put("userMail", "employeeEntity");

        // generate jwt using claims
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims verifyAccessToken(String authorization) throws Exception {
        // authorization = Bearer ebyljdlkfjlksdjfkjdfjdf -> spliting the into two by empty space
        String[] accessToken = authorization.split(" ");
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(accessToken[1]).getBody();
            return claims;
        } catch(Exception e) {
            throw new Exception("Access Denied");
        }
    }
}
