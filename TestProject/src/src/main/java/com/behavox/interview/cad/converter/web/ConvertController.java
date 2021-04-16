package com.behavox.interview.cad.converter.web;

import com.behavox.interview.cad.converter.entity.ConvertResponse;
import com.behavox.interview.cad.converter.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertController {

    @Autowired
    private ConvertService convertService;

    @RequestMapping("/convert")
    public ConvertResponse convert(@RequestParam double amount, @RequestParam String targetSymbol) {
        return convertService.convert(amount, targetSymbol);
    }
}
