package com.ecommerce.inventory_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "order-service",
        url = "http://localhost:9020",
        path = "/orders"
)
public interface OrdersFeignClient {

    @GetMapping("/core/helloOrders")
    String helloOrders();
}