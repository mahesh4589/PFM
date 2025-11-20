package com.pfm.notification_service.service.impl;

import com.pfm.notification_service.model.dto.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserClient {

    private final WebClient webClient;

    public UserClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<UserDto> getUserRecord(Long userId) {

        System.out.println("call User serbvice and get Userid");
        return  webClient.get()
                .uri("http://localhost:8083/api/v1/{id}",userId)
                .retrieve()
                .bodyToMono(UserDto.class);


    }
}