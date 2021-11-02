package com.capitole.application.service;

import com.capitole.controller.model.PriceResponse;
import com.capitole.domain.PriceRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class PriceServiceImpl implements PriceService{


    @Override
    public PriceResponse getPriceByApplyDate(PriceRequest priceRequest) {
        String str = "2021-04-05 00:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        return new PriceResponse(1,1, 1, dateTime, dateTime, BigDecimal.valueOf(0.0));
    }
}
