package com.capitole.application.service;

import com.capitole.controller.model.PriceResponse;
import com.capitole.domain.PriceRequest;

public interface PriceService {

   PriceResponse getPriceByApplyDate(PriceRequest priceRequest);

}

