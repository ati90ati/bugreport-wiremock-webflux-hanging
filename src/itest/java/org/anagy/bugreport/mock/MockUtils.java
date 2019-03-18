package org.anagy.bugreport.mock;

import org.anagy.bugreport.client.client1.Client1Dto;

import java.util.UUID;

import static com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder.okForJson;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

public final class MockUtils {

    private MockUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void mockService1() {
        stubFor(get("/service1/api/name")
                .willReturn(okForJson(new Client1Dto(UUID.randomUUID(), "1"))));
    }

    public static void mockService2() {
        stubFor(get("/service2/api/name")
                .willReturn(okForJson(new Client1Dto(UUID.randomUUID(), "2"))));
    }

}
