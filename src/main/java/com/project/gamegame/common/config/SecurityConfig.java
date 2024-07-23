package com.project.gamegame.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.ContentSecurityPolicyHeaderWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .httpBasic(httpBasic -> httpBasic.disable())
                // token을 사용하는 방식이기 때문에 csrf를 disable 처리한다.
                .csrf(csrf -> csrf.disable())
                // CORS 설정
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                // 요청 권한 설정
                .authorizeHttpRequests(authorize
                        -> authorize

                        .requestMatchers(
                                "api/user/checkId",
                                "/user/register",
                                "/user/login").permitAll()
                        .requestMatchers("/api/user/**").permitAll()
                        .requestMatchers("/user/**").permitAll()
                        .requestMatchers("/api/**").permitAll()
                        .requestMatchers("/board/**").permitAll()
                        .requestMatchers("/reply/**").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()

                )
                // 세션을 사용하지 않기 때문에 STATELESS로 설정한다.
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 예외 처리 설정 (JWT 인증 설정)
                .build();


    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("OPTIONS", "HEAD", "GET", "POST", "PUT", "PATCH", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type", "Set-Cookie"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
