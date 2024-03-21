package br.com.grupo63.hackatonserviceauth.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.token.key.public}")
    private String jwtSigningKey;

    public String createToken(String id, String email) {
        Date now = new Date();

        return Jwts.builder()
                .subject(id)
                .claim("email", email)
                .issuedAt(now)
                .signWith(SignatureAlgorithm.HS256, jwtSigningKey)
                .compact();
    }

}
