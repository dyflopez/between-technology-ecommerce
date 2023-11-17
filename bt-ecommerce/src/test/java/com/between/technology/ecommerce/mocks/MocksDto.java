package com.between.technology.ecommerce.mocks;

import com.between.technology.ecommerce.dto.PriceSearcherDTO;
import com.between.technology.ecommerce.dto.response.PriceDetailsResponseDTO;

import java.time.LocalDateTime;

public class MocksDto {

    public  static PriceSearcherDTO getPriceSearcherDTO(LocalDateTime applicationDate,
                                                        int productId,
                                                        int brandId
    ){
        return  PriceSearcherDTO
                .builder()
                .applicationDate(applicationDate)
                .productId(productId)
                .brandId(brandId)
                .build();
    }

    public  static PriceDetailsResponseDTO getPriceDetailsResponseDTO(long productId,
                                                                      long brandId,
                                                                      LocalDateTime startDate,
                                                                      LocalDateTime endDate,
                                                                      double finalPrice,
                                                                      String brand,
                                                                      String product){
        return  PriceDetailsResponseDTO
                .builder()
                .productId(productId)
                .brandId(brandId)
                .startDate(startDate)
                .endDate(endDate)
                .finalPrice(finalPrice)
                .brand(brand)
                .product(product)
                .build();
    }



}
