package com.capitole.infraestructure.rest;

import com.capitole.application.service.PriceService;
import com.capitole.domain.PriceRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;

import org.mockito.Mock;
import org.junit.Before;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.capitole.controller.model.PriceResponse;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PriceControllerImplTest {


    @Autowired
    PriceControllerImpl subject;

    @Mock
    PriceService priceService;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        subject = new PriceControllerImpl(priceService);
    }

    @Test
    public void shouldResponseOkGetPrice(){
        PriceResponse response = buidPriceResponse();
        when(priceService.getPriceByApplyDate(new PriceRequest())).thenReturn(response);
        ResponseEntity<PriceResponse> entity =
                subject.getPrice(new PriceRequest());
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }



    public PriceResponse buidPriceResponse(){
        String str = "2021-04-05 00:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        return new com.capitole.controller.model.PriceResponse(1,1, 1, dateTime, dateTime, BigDecimal.valueOf(0.0));
    }

}
