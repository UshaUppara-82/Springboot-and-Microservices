package com;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator route (RouteLocatorBuilder build) {
		return build.routes()
				.route("CUSTOMER-SERVICE", r->r.path("/customer/**").uri("http://localhost:2001"))
				.route("FREQUENTFLYER-SERVICE", r->r.path("/frequentflyer/**").uri("http://localhost:2001"))
				.route("FLIGHT-SERVICE", r->r.path("/flight/**").uri("http://localhost:2002"))
				.route("AIRPORT-SERVICE", r->r.path("/airport/**").uri("http://localhost:2002"))
				.route("BOOKING-SERVICE", r->r.path("/booking/**").uri("http://localhost:2003"))
				.route("PASSENGER-SERVICE", r->r.path("/passenger/**").uri("http://localhost:2003"))
				.route("PAYMENT-SERVICE", r->r.path("/payment/**").uri("http://localhost:2003"))
				.route("NOTIFICATION-SERVICE", r->r.path("/notification/**").uri("http://localhost:2004"))
				.build();
	}
	@Bean
	public CorsWebFilter corsWebFilter() {
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("http://localhost:4200"); // Angular frontend
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", config);

	    return new CorsWebFilter(source);
	}

}

