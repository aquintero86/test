package com.capitole.infraestructure.rest;

import com.capitole.application.service.PriceService;
import com.capitole.controller.model.PriceResponse;
import com.capitole.domain.PriceRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class PriceControllerImpl implements PriceController{


    private final PriceService priceService;

    public PriceControllerImpl(PriceService priceService) {
        this.priceService = priceService;
    }



    @Override
    public ResponseEntity<PriceResponse> getPrice(PriceRequest priceRequest) {
        PriceResponse response = priceService.getPriceByApplyDate(priceRequest);
        return ResponseEntity.ok(response);
    }
}
