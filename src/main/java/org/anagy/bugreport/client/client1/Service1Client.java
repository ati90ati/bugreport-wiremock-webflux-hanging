package org.anagy.bugreport.client.client1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class Service1Client {

    private static final String BASE_API_PATH = "/service1/api";

    private final WebClient client;

    public Service1Client(@Value("${api.service1.url}") final String apiUrl, final WebClient.Builder webClientBuilder) {
        this.client = webClientBuilder.clone()
                .baseUrl(apiUrl + BASE_API_PATH)
                .build();
    }

    public Mono<Client1Dto> getServiceName() {
        return client.get().uri("/name")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Client1Dto.class)
                .doOnNext(n -> log.debug("Client received {} ", n))
                .doOnError(e -> log.error("Error while getting service name", e));
    }

}
