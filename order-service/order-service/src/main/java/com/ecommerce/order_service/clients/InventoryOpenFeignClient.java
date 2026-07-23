package com.ecommerce.order_service.clients;

import com.ecommerce.order_service.dto.OrderRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "inventory-service",
        url = "http://localhost:9010",
        path = "/api/v1/products"
)
public interface InventoryOpenFeignClient {

    @PutMapping("/reduce-stocks")
    Double reduceStocks(@RequestBody OrderRequestDto orderRequestDto);

}