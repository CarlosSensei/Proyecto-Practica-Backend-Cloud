package com.ccsw.tutorialloans.client;

import com.ccsw.tutorialloans.client.model.ClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "SPRING-CLOUD-EUREKA-CLIENT-CLIENT", url = "http://localhost:8080")
public interface ClientClient {

    @GetMapping(value = "/client")
    List<ClientDto> findAll();
}
