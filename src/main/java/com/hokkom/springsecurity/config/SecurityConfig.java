package com.hokkom.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
        requestCache.setMatchingRequestParameterName(null);

        http
                .requestCache(request ->
                        request.requestCache(requestCache));
        http
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/**")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                );

        http
                .formLogin(Customizer.withDefaults());
        http
                .csrf(Customizer.withDefaults());

        return http.build();
    }
}
