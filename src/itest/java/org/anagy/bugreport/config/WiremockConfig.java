package org.anagy.bugreport.config;

import com.github.tomakehurst.wiremock.core.Options;
import org.springframework.cloud.contract.wiremock.WireMockSpring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WiremockConfig {

    @Bean
    public Options wiremockOptions() {
        final com.github.tomakehurst.wiremock.core.WireMockConfiguration wireMockConfiguration = WireMockSpring
                .options();

        wireMockConfiguration.useChunkedTransferEncoding(Options.ChunkedEncodingPolicy.BODY_FILE);
        wireMockConfiguration.port(12345);

        return wireMockConfiguration;
    }

}
