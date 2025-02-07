package com.cinema.videotecha.service.impl;

import com.cinema.videotecha.config.RsaKeyProperties;
import com.cinema.videotecha.model.User;
import com.cinema.videotecha.service.TokenService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.function.Function;
@Service
public class TokenServiceImpl implements TokenService {
    private final JwtEncoder encoder;
    private final RsaKeyProperties jwtConfigProperties;

    public TokenServiceImpl(JwtEncoder encoder, RsaKeyProperties jwtConfigProperties) {
        this.encoder = encoder;
        this.jwtConfigProperties = jwtConfigProperties;
    }

    public String generateToken(User user) {
        Instant now = Instant.now();
        String role = user.getRole().getAuthority();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("videotecha")
                .issuedAt(now)
                .expiresAt(now.plus(30, ChronoUnit.MINUTES))
                .subject(user.getUsername())
                .claim("role", role)
                .build();
        return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtConfigProperties.publicKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

}
