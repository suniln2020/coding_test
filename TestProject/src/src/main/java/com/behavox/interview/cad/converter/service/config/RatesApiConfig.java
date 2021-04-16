package com.behavox.interview.cad.converter.service.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConfigurationProperties(prefix = "services.rates")
public class RatesApiConfig {

    private String apiUrl;

    @Bean
    public RestTemplate ratesApiRestTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.rootUri(apiUrl).build();
        restTemplate.setRequestFactory(new OkHttp3ClientHttpRequestFactory());
        return restTemplate;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}
