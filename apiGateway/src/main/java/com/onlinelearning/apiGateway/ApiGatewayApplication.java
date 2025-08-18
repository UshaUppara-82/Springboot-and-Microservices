package com.onlinelearning.apiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
	    return builder.routes()
	            .route("USER-SERVICE", r -> r.path("/users/**")
	                    .uri("http://localhost:8101"))   // User Service
	            .route("COURSE-SERVICE", r -> r.path("/courses/**")
	                    .uri("http://localhost:8102"))   // Course Service
	            .route("CONTENT-SERVICE", r -> r.path("/contents/**")
	                    .uri("http://localhost:8103"))   // Content Service
	            .route("ENROLLMENT-SERVICE", r -> r.path("/enrollments/**")
	                    .uri("http://localhost:8104"))   // Enrollment Service
	            .build();
	}
	@Bean
	public CorsWebFilter corsWebFilter() {
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("http://localhost:4200");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", config);
	    return new CorsWebFilter(source);
	}


}
