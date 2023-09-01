package com.valcon.videotechaivana;
import com.valcon.videotechaivana.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
 import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@ComponentScan(basePackages = {"com.valcon.videotechaivana"})
@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class VideotechaIvanaApplication {
	public static void main(String[] args) {
		SpringApplication.run(VideotechaIvanaApplication.class, args);
	}



}
