package com.studysetting;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class config implements WebMvcConfigurer { // web에서의 MVC 동작에 관한 설정 인터페이스

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		  registry.addMapping("/**").allowedOrigins("*"); // 모든 페이지에 대해.모든 Origin 허용
		  registry.addMapping("/**").allowedOrigins("http://localhost:8080", "http://localhost:8081"); // 모든 페이지에 대해.선택된 Origin만 접근 허용
		  registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST"); // 모든 페이지.모든 오리진의.GET, POST 메서드 허용
	}
}