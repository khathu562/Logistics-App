package com.logistics.logisticsapp.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF protection if using token-based authentication
            .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Enable CORS with custom configuration
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/payments.html",
                    "/messaging.html",
                    "/index.html",
                    "/login.html",
                    "/profile.html",
                    "/welcome.html",
                    "/registration.html",
                    "/GeolocationExample.html",
                    "/forget_password.html",
                    "/css/**", // Allow access to CSS files
                    "/static/css/**" // Allow access if accessed through static path
                ).permitAll()
                .anyRequest().authenticated() // Require authentication for all other requests
            )
            .headers(headers -> headers
                .httpStrictTransportSecurity(hsts -> hsts.disable()) // Disable HSTS; for production, consider enabling
                .contentSecurityPolicy(csp -> csp
                    .policyDirectives("script-src 'self' 'unsafe-inline'; frame-ancestors 'self';")
                ) // Set Content Security Policy
            );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:8080")); // Adjust for your frontend origin
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type", "X-Requested-With"));
        configuration.setAllowCredentials(true); // Allows cookies/auth to be included in requests if needed

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
