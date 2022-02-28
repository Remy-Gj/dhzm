package com.dhzm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfing {

    @Bean
    public CorsFilter corsFilter(){

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedOrigin("http://192.168.1.22:8081");
        corsConfiguration.addAllowedOrigin("http://192.168.1.22:8080");
        corsConfiguration.addAllowedHeader("http://127.0.0.1:8080");
        corsConfiguration.addAllowedHeader("http://127.0.0.1:8081");
        corsConfiguration.addAllowedHeader("http://192.168.1.144:8080");
        corsConfiguration.addAllowedHeader("http://192.168.1.22:8080");
//        corsConfiguration.addAllowedMethod("OPTIONS");
//        corsConfiguration.addAllowedMethod("HEAD");
//        corsConfiguration.addAllowedMethod("GET");
//        corsConfiguration.addAllowedMethod("PUT");
//        corsConfiguration.addAllowedMethod("POST");
//        corsConfiguration.addAllowedMethod("DELETE");
//        corsConfiguration.addAllowedMethod("PATCH");
        corsConfiguration.setAllowCredentials(true);


        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**",corsConfiguration);

        CorsFilter corsFilter = new CorsFilter(source);

        return corsFilter;

    }
}
