package com.ecommarce.api_gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LoggingOrdersFilter extends AbstractGatewayFilterFactory<LoggingOrdersFilter.Config> {

    public LoggingOrdersFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {

            long start = System.currentTimeMillis();

            log.info("========== Orders Filter ==========");
            log.info("Method : {}", exchange.getRequest().getMethod());
            log.info("Path   : {}", exchange.getRequest().getURI().getPath());

            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {

                        long timeTaken = System.currentTimeMillis() - start;

                        log.info("Status : {}", exchange.getResponse().getStatusCode());
                        log.info("Time   : {} ms", timeTaken);
                        log.info("===================================");

                    }));
        };
    }

    public static class Config {
    }
}