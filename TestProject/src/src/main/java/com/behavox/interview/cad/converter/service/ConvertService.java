package com.behavox.interview.cad.converter.service;

import com.behavox.interview.cad.converter.entity.ConvertResponse;
import org.springframework.stereotype.Service;

@Service
public class ConvertService {

    private final ConversionRateService conversionRateService;

    public ConvertService(ConversionRateService conversionRateService) {
        this.conversionRateService = conversionRateService;
    }

    public ConvertResponse convert(double amount, String targetSymbol) {
        final double rate = conversionRateService.fetchRate(targetSymbol);
        ConvertResponse result = new ConvertResponse();
        result.setCadAmount(amount);
        result.setRate(rate);
        result.setTargetSymbol(targetSymbol);
        result.setTargetAmount(convert(amount, rate));
        return result;
    }

    public double convert(double cadAmount, double toCadRate) {
        return cadAmount / toCadRate;
    }
}
