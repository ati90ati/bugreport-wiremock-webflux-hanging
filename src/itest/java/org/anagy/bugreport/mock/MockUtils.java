package org.anagy.bugreport.mock;

import lombok.experimental.UtilityClass;
import org.anagy.bugreport.client.client1.Client1Dto;

import java.util.UUID;

import static com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder.okForJson;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

@UtilityClass
public class MockUtils {

    public static void mockService1() {
        stubFor(get("/service1/api/name")
                .willReturn(okForJson(new Client1Dto(UUID.randomUUID(), "1"))));
    }

    public static void mockService2() {
        stubFor(get("/service2/api/name")
                .willReturn(okForJson(new Client1Dto(UUID.randomUUID(), "2"))));
    }

}
