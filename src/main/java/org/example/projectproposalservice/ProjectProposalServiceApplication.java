package org.example.projectproposalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ProjectProposalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectProposalServiceApplication.class, args);
    }
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

}
