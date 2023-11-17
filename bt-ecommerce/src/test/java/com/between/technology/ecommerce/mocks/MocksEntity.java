package com.between.technology.ecommerce.mocks;

import com.between.technology.ecommerce.model.BrandEntity;
import com.between.technology.ecommerce.model.PriceEntity;
import com.between.technology.ecommerce.model.ProductEntity;

import java.time.LocalDateTime;

public class MocksEntity {

    public  static  ProductEntity getMockProductEntity(long id,String product){
        return  ProductEntity
                .builder()
                .id(id)
                .name(product)
                .build();
    }

    public  static BrandEntity getMockBrandEntity(long id, String brand){
        return  BrandEntity
                .builder()
                .id(id)
                .name(brand)
                .build();
    }

    public  static PriceEntity getMockPriceEntity(double price,
                                                  ProductEntity product,
                                                  BrandEntity brand,
                                                  int priority
    ){
        return  PriceEntity
                .builder()
                .price(price)
                .product(product)
                .brand(brand)
                .currencyIso("EUR")
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .priority(priority)
                .build();
    }

}
