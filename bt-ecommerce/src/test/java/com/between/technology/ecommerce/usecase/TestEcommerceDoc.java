package com.between.technology.ecommerce.usecase;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestEcommerceDoc {

    private LocalDateTime applicationDate;

    private long brandId;

    private long productId;

    private double finalPriceResponse;

    private String brandResponse;

    private String productResponse;
}
