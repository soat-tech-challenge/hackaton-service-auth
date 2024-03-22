package br.com.grupo63.hackatonserviceauth.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.token.key.private}")
    private String jwtSigningKey;

    public String createToken(String id, String email) throws NoSuchAlgorithmException, InvalidKeySpecException {
        Date now = new Date();

        return Jwts.builder()
                .subject(id)
                .claim("email", email)
                .issuedAt(now)
                .signWith(getSigningKey(), SignatureAlgorithm.RS256)
                .compact();
    }

    private Key getSigningKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
            byte[] privateKeyBytes = Base64.getDecoder().decode(jwtSigningKey);

            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            return keyFactory.generatePrivate(keySpec);
    }

}
