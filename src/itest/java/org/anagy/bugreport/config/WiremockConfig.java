package org.anagy.bugreport.config;

import com.github.tomakehurst.wiremock.core.Options;
import org.springframework.cloud.contract.wiremock.WireMockConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WiremockConfig {

    @Bean
    public WireMockConfigurationCustomizer wireMockConfigurationCustomizer() {
        return config -> config.useChunkedTransferEncoding(Options.ChunkedEncodingPolicy.BODY_FILE);
    }

}
