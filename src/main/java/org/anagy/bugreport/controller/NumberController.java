package org.anagy.bugreport.controller;

import org.anagy.bugreport.client.client1.Client1Dto;
import org.anagy.bugreport.client.client1.Service1Client;
import org.anagy.bugreport.client.client2.Client2Dto;
import org.anagy.bugreport.client.client2.Service2Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping(value = NumberController.API_PATH)
public class NumberController {

    static final String API_PATH = "/numbers";

    private final Service1Client service1Client;
    private final Service2Client service2Client;

    public NumberController(final Service1Client service1Client,
                            final Service2Client service2Client) {
        this.service1Client = service1Client;
        this.service2Client = service2Client;
    }

    @GetMapping
    public Mono<String> getNumbers() {
        return Mono.zip(
                service1Client.getServiceName(),
                service2Client.getServiceName())
                .map(this::joinToString);
    }

    private String joinToString(final Tuple2<Client1Dto, Client2Dto> objects) {
        return String.join(", ",
                objects.getT1().getNumber(),
                objects.getT2().getNumber());
    }

}
