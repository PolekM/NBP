package com.example.intern.controller;

import com.example.intern.dto.nbp.DisplayRatesDto;
import com.example.intern.dto.nbp.NbpCurrency;
import com.example.intern.dto.nbp.Rates;
import com.example.intern.dto.nbp.RatesDto;
import com.example.intern.exception.NbpControllerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
public class NbpController {

    RestTemplate restTemplate;

    @Autowired
    public NbpController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/currencies/get-current-currency-value-command")
    public DisplayRatesDto getCurrentlyCourse(@RequestBody NbpCurrency nbpDto) throws NbpControllerException {

        Optional.ofNullable(nbpDto.getCurrency()).orElseThrow(() -> new NbpControllerException("Waluta nie może być równa null"));
        String nbpURL = "http://api.nbp.pl/api/exchangerates/rates/A/"+nbpDto.getCurrency()+"/";
        RatesDto ratesDto = restTemplate.getForObject(nbpURL,RatesDto.class);
        return displayRatesDto(ratesDto);
    }

    public DisplayRatesDto displayRatesDto(RatesDto ratesDto){
        DisplayRatesDto displayRatesDto = new DisplayRatesDto();
        Rates rates = ratesDto.getRates().get(0);
        displayRatesDto.setValue(rates.getMid());
        return displayRatesDto;
    }
}
