package br.com.fiap.challengePlusoft.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "teste_secret_key";

    public String gerarToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return criarToken(claims, username);
    }

    private String criarToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean validarToken(String token, String username) {
        final String extractedUsername = extrairUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpirado(token));
    }

    public String extrairUsername(String token) {
        return extrairClaims(token).getSubject();
    }

    private Claims extrairClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpirado(String token) {
        return extrairClaims(token).getExpiration().before(new Date());
    }
}
