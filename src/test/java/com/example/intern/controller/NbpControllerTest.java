package com.example.intern.controller;

import com.example.intern.dto.nbp.DisplayRatesDto;
import com.example.intern.dto.nbp.NbpCurrency;
import com.example.intern.dto.nbp.RatesDto;
import com.example.intern.exception.NbpControllerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NbpControllerTest {

    private RestTemplate restTemplate;
    private NbpController nbpController;

    @BeforeEach
    public void init(){
        restTemplate = new RestTemplate();
        nbpController = new NbpController(restTemplate);
    }

    @Test
    void DisplayRatesDtoWithThbParamShouldReturnInstanceOfDouble() {
        //given
        RatesDto ratesDto = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/A/THB/",RatesDto.class);

        //when
        DisplayRatesDto displayRatesDto = nbpController.displayRatesDto(ratesDto);

        //then
        assertThat(displayRatesDto.getValue(),is(instanceOf(Double.class)));
    }
    @Test
    void DisplayRatesDtoWithNullCurrencyParamShouldThrowException() throws NbpControllerException {
       //given
        NbpCurrency nbpCurrency = new NbpCurrency();

       // when

       //then
        assertThrows(NbpControllerException.class,() -> nbpController.getCurrentlyCourse(nbpCurrency));
    }
}
