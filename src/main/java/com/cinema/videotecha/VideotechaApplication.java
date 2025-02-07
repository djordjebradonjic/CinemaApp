package com.cinema.videotecha;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.cinema.videotecha.config.RsaKeyProperties;

import java.util.Arrays;

@ComponentScan(basePackages = { "com.cinema.videotecha" })
@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class VideotechaApplication {
	public static void main(String[] args) {
		SpringApplication.run(VideotechaApplication.class, args);
	}

}
