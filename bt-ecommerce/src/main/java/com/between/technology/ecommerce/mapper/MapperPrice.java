package com.between.technology.ecommerce.mapper;

import com.between.technology.ecommerce.dto.response.PriceDetailsResponseDTO;
import com.between.technology.ecommerce.model.PriceEntity;

import java.time.LocalDateTime;

public class MapperPrice {

    public static PriceDetailsResponseDTO mapToDto(PriceEntity details) {
        return PriceDetailsResponseDTO.builder()
                .productId(details.getProduct().getId())
                .brandId(details.getBrand().getId())
                .startDate(details.getStartDate())
                .endDate(details.getEndDate())
                .finalPrice(details.getPrice())
                .brand(details.getBrand().getName())
                .product(details.getProduct().getName())
                .build();
    }
}
