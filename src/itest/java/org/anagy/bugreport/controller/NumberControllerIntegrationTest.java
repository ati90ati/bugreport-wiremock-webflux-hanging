package org.anagy.bugreport.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.stream.IntStream;

import static org.anagy.bugreport.mock.MockUtils.mockService1;
import static org.anagy.bugreport.mock.MockUtils.mockService2;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
@TestPropertySource(properties = {"wiremock.server.https-port=-1"})
class NumberControllerIntegrationTest {

    private static final int TRIES_PER_TEST = 1000;

    @Autowired
    private WebTestClient client;

    @Test
    void getNumbers1() {
        getNumbers();
    }

    @Test
    void getNumbers2() {
        getNumbers();
    }

    @Test
    void getNumbers3() {
        getNumbers();
    }

    @Test
    void getNumbers4() {
        getNumbers();
    }

    @Test
    void getNumbers5() {
        getNumbers();
    }

    private void getNumbers() {
        IntStream.range(0, TRIES_PER_TEST)
                .forEach(value -> testGetNumbers());
    }

    private void testGetNumbers() {
        // Given
        mockService1();
        mockService2();

        // When
        client.get().uri("/numbers")
                .exchange()
                // Then
                .expectStatus().isOk()
                .expectBody(String.class)
                .consumeWith(responseBody -> {
                    final String result =
                            responseBody.getResponseBody();

                    assertThat(result).isEqualTo("1, 2");
                });
    }

}
