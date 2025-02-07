package com.cinema.videotecha.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.hibernate.annotations.Comment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordConverter implements AttributeConverter<String, String> {
    private final PasswordEncoder passwordEncoder;

    public PasswordConverter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String convertToDatabaseColumn(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public String convertToEntityAttribute(String hashedPassword) {
        return hashedPassword;
    }
}
