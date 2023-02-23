package br.com.apione.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

	@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
        		.route(r -> r
        				.path("/apione/**")
                        .uri("lb://apione-service")
//                        .id("employeeModule")
                        )
        		.route(r -> r
        				.path("/apitwo/**")
                        .uri("lb://apitwo-service")
//                        .id("consumerModule")
                        )
                .build();
    }
	
}


/*
 * ## Api One Service Route
spring.cloud.gateway.routes[0].id=apione
spring.cloud.gateway.routes[0].uri=lb://apione-service
spring.cloud.gateway.routes[0].predicates[0]=Path=/apione/**

## Api Two Service Route
spring.cloud.gateway.routes[1].id=apitwo
spring.cloud.gateway.routes[1].uri=lb://apitwo-service
spring.cloud.gateway.routes[1].predicates[0]=Path=/apitwo/**
 *  */