package com.behavox.interview.cad.converter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class ConversionRateService {

    private static final Logger logger = LoggerFactory.getLogger(ConversionRateService.class);

    @Autowired
    private RestTemplate restTemplate;

    /*
        GET https://api.ratesapi.io/api/latest?base=USD&symbols=CAD HTTP/2
        {
            base: "USD",
            rates: {
                CAD: 1.3322187076
            },
            date: "2019-08-23"
        }
     */

    public double fetchRate(String target) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/latest")
                .queryParam("base", target)
                .queryParam("symbols", "CAD");
        try {
            ResponseEntity<Map> response = restTemplate.getForEntity(builder.toUriString(), Map.class);
            return (double) ((Map)(response.getBody().get("rates"))).get("CAD");
        } catch (HttpClientErrorException e) {
            logger.error("Failed to retrieve rate for target symbol '{}'", target, e);
        }
        return 0.00;
    }
}
