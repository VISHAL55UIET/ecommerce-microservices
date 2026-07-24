package com.ecommarce.api_gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthenticationGatewayFilterFactory
        extends AbstractGatewayFilterFactory<AuthenticationGatewayFilterFactory.Config> {

    public AuthenticationGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {

            HttpHeaders headers = exchange.getRequest().getHeaders();

            // Authorization header present?
            if (!headers.containsKey(HttpHeaders.AUTHORIZATION)) {

                log.warn("Authorization Header Missing");

                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

                return exchange.getResponse().setComplete();
            }

            String authHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);

            log.info("Authorization Header : {}", authHeader);

            // Temporary validation
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {

                log.warn("Invalid Authorization Header");

                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

                return exchange.getResponse().setComplete();
            }

            return chain.filter(exchange);
        };
    }

    public static class Config {

    }
}