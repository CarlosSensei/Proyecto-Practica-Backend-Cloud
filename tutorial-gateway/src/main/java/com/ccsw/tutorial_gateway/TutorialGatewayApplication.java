package com.ccsw.tutorial_gateway;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TutorialGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialGatewayApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(RouteLocator routeLocator) {

		return args -> {

			routeLocator.getRoutes()
					.doOnNext(route ->
							System.out.println("RUTA: " + route.getId()))
					.subscribe();
		};
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

		return builder.routes()
				.route("category",
						r -> r.path("/category/**")
								.uri("http://localhost:8091"))

				.route("author",
						r -> r.path("/author/**")
								.uri("http://localhost:8092"))

				.route("game",
						r -> r.path("/game/**")
								.uri("http://localhost:8093"))

				.route("client",
						r -> r.path("/client/**")
								.uri("http://localhost:8094"))

				.route("loan",
						r -> r.path("/loan/**")
								.uri("http://localhost:8095"))

				.route("auth",
						r -> r.path("/auth/**")
								.uri("http://localhost:8096"))
				.build();
	}
}
