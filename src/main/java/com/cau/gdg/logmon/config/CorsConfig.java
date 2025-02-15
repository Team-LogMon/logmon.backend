package com.cau.gdg.logmon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // ✅ 모든 엔드포인트에 CORS 적용
                        .allowedOrigins("http://localhost:5173", "https://logmon-4ba86.web.app")// ✅ 모든 도메인 허용
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // ✅ 허용할 HTTP 메서드
                        .allowedHeaders("*") // ✅ 모든 헤더 허용
                        .allowCredentials(true); // ✅ 쿠키/인증정보 포함 허용 (필요할 경우)
            }
        };
    }
}
