package com.ecommarce.api_gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class GlobalLoggingFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {

        long start = System.currentTimeMillis();

        log.info("Incoming Request: {} {}",
                exchange.getRequest().getMethod(),
                exchange.getRequest().getURI());

        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    long time = System.currentTimeMillis() - start;

                    log.info("Response Status: {} | Time Taken: {} ms",
                            exchange.getResponse().getStatusCode(),
                            time);
                }));
    }
}