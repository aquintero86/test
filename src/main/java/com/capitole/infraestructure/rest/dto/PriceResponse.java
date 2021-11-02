package com.capitole.controller.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class PriceResponse {

    @JsonProperty("ProductId")
    private int productuId;

    @JsonProperty("BrandiId")
    private int brandId;

    @JsonProperty("RateToApply")
    private int rateToApply;

    @JsonProperty("StartDate")
    private LocalDateTime startDate;

    @JsonProperty("EndDate")
    private LocalDateTime endDate;

    @JsonProperty("FinalPrice")
    private BigDecimal finalPrice;

    public PriceResponse(int productuId, int brandId, int rateToApply, LocalDateTime startDate,
                         LocalDateTime endDate, BigDecimal finalPrice){
        this.brandId = brandId;
        this.productuId = productuId;
        this.rateToApply = rateToApply;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finalPrice = finalPrice;
    }

}
