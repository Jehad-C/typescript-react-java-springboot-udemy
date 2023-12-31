package com.demo.library.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/api/books/secure/**")
                                .authenticated()
                                .requestMatchers("/api/reviews/secure/**")
                                .authenticated()
                                .requestMatchers("/api/messages/secure/**")
                                .authenticated()
                                .requestMatchers("/api/admin/secure/**")
                                .authenticated()
                                .anyRequest()
                                .permitAll())
                .oauth2ResourceServer(oaut2 ->
                        oaut2.jwt(Customizer.withDefaults()))
                .cors(Customizer.withDefaults())
                .csrf(csrf ->
                        csrf.disable())
                .setSharedObject(ContentNegotiationStrategy.class,
                        new HeaderContentNegotiationStrategy());

        Okta.configureResourceServer401ResponseBody(http);
        return http.build();
    }
}
