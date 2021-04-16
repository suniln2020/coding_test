package com.behavox.interview.cad.converter.service;

import com.behavox.interview.cad.converter.entity.ConvertResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class ConvertServiceTest {

    private ConvertService convertService;

    @Mock
    private ConversionRateService conversionRateService;

    @BeforeEach
    public void injectMocks() {
        MockitoAnnotations.initMocks(this);
        when(conversionRateService.fetchRate("USD")).thenReturn(1.5);
        convertService = new ConvertService(conversionRateService);
    }

    @Test
    public void convert() {
        ConvertResponse response = convertService.convert(3.0, "USD");
        assertNotNull(response);
        assertThat(response.getCadAmount()).isEqualTo(3.0);
        assertThat(response.getTargetSymbol()).isEqualTo("USD");
        assertThat(response.getRate()).isEqualTo(1.5);
        assertThat(response.getTargetAmount()).isEqualTo(2.0);
    }
}