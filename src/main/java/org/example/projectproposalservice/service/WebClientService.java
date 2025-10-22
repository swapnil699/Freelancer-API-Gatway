package org.example.projectproposalservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebClientService {

    private final WebClient.Builder webClientBuilder;

    @Value("${communication.base-url:http://localhost:8081}")
    private String baseUrl; // you can configure this per service

    public <T> Mono<T> post(String endpoint, Object body, Class<T> responseType) {
        return webClientBuilder.build()
                .post()
                .uri(baseUrl + endpoint)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(responseType);
    }

    public <T> Mono<T> get(String endpoint, Class<T> responseType) {
        return webClientBuilder.build()
                .get()
                .uri(baseUrl + endpoint)
                .retrieve()
                .bodyToMono(responseType);
    }
}