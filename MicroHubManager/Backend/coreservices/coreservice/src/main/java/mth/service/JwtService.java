package mth.service;

import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    public final String SECRETE_KEY = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0987654321";
    public final SecretKey key = Keys.hmacShaKeyFor(SECRETE_KEY.getBytes());
    public Object generateJWT(Object username, Object role) throws Exception
    { //HEADER.PAYLOAD.TOKEN ---> Format
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", username);
        payload.put("role", role);
        return Jwts.builder()
                .setClaims(payload)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(key);
    }
    public Map<String, Object> validateJWT(String token) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        if (claims.getExpiration().before(new Date())) {
            throw new RuntimeException("Token expired");
        }

        Map<String, Object> payload = new HashMap<>();
        payload.put("username", claims.get("username"));
        payload.put("role", claims.get("role"));

        return payload;
    }
}


