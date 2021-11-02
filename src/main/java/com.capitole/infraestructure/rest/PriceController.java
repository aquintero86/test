package com.capitole.infraestructure.rest;

import com.capitole.domain.PriceRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.capitole.controller.model.PriceResponse;

@RequestMapping(value = "/")
public interface PriceController {

    @GetMapping(
            value = "/v1/price",
            produces = {"application/json"},
            consumes = {"application/json"})
    ResponseEntity<PriceResponse> getPrice(@RequestBody PriceRequest priceRequest);

}
