package com.between.technology.ecommerce.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDetailsResponseDTO {

    private long productId;

    private long brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private double finalPrice;

    private String brand;

    private String product;

}
