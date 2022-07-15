package com.hashkart.user;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    private String SECRET_KEY = "secret";

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        if(extractAllClaims(token)!= null) {
            final Claims claims = extractAllClaims(token);
            return claimsResolver.apply(claims);
        }
        return null;
    }
    private Claims extractAllClaims(String token){
        try {
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public String createToken(String username){

        Claims claims = Jwts.claims().setSubject(username);
        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 *10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Boolean validateToken(String token){
        if(extractExpiration(token)!= null) {
            return !extractExpiration(token).before(new Date());
        }
        return false;
    }
}
