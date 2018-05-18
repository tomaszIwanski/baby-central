package com.archangel_design.babyscheduller.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AuthServiceConfiguration {

    private static final Logger restLogger = LoggerFactory.getLogger(RestTemplate.class);

    @Bean
    public RestTemplate authRestTemplate(RestTemplateBuilder builder) {
        return configureRestTemplateBuilder(builder, "Auth service")
            .build();
    }

    private RestTemplateBuilder configureRestTemplateBuilder(RestTemplateBuilder builder, String name) {
        return builder
            .additionalInterceptors(
                (HttpRequest request, byte[] body, ClientHttpRequestExecution execution) -> {
                    restLogger.info("{} request ({} {}) pending...", name, request.getMethod(), request.getURI());
                    HttpHeaders headers = request.getHeaders();
                    headers.add("X-User-Agent", "HireGround API");
                    return execution.execute(request, body);
                }
            );
    }

    @Bean
    @Autowired
    public AuthenticationProvider authenticationProvider() {
        return new com.archangel_design.babyscheduller.service.AuthenticationProvider();
    }

}
