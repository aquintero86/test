package com.capitole.application.service;


import com.capitole.domain.PriceRequest;
import com.capitole.infraestructure.repository.PriceRepository;
import com.capitole.infraestructure.repository.models.PriceModel;
import com.capitole.infraestructure.rest.dto.PriceResponse;
import org.springframework.stereotype.Service;


import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@Service
public class PriceServiceImpl implements PriceService{

    private final PriceRepository repository;

    public PriceServiceImpl(PriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public PriceResponse getPriceByApplyDate(PriceRequest priceRequest) {
        Iterable<PriceModel> priceModels = repository.findPriceByApplyDate(priceRequest.getProductId(), priceRequest.getBrandId(), priceRequest.getApplyDate());
        Stream<PriceModel> stream = StreamSupport.stream(priceModels.spliterator(), false);
        PriceModel priceModel = priceModels.iterator().next();
        return PriceResponse.builder()
                    .startDate(priceModel.getStartDate())
                    .endDate(priceModel.getEndDate())
                    .rateToApply(priceModel.getPriceList())
                    .productuId(priceModel.getProductId())
                    .brandId(priceModel.getBrandId())
                            .finalPrice(priceModel.getPrice())
         .build();
    }
}
