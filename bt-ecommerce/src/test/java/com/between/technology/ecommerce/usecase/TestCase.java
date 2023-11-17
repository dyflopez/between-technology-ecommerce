package com.between.technology.ecommerce.usecase;

import com.between.technology.ecommerce.controller.v1.PriceController;
import com.between.technology.ecommerce.dto.PriceSearcherDTO;
import com.between.technology.ecommerce.dto.response.PriceDetailsResponseDTO;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestCase {

    @Autowired
    private PriceController controller;

    @ParameterizedTest
    @CsvFileSource(resources = "/TestEcommerceDoc.csv", numLinesToSkip = 1)
    void restIntegrationTest(ArgumentsAccessor argumentsAccessor) {

        TestEcommerceDoc testEcommerceDoc = getMapperTestDoc(argumentsAccessor);

        PriceSearcherDTO priceSearcherDTO = PriceSearcherDTO
                .builder()
                .brandId(testEcommerceDoc.getBrandId())
                .productId(testEcommerceDoc.getProductId())
                .applicationDate(testEcommerceDoc.getApplicationDate())
                .build();

        try{
            ResponseEntity result = this.controller.getPriceByDateAndProductIdAndBrandId(priceSearcherDTO);
            if (result.getStatusCode() == HttpStatus.OK) {
                PriceDetailsResponseDTO priceDetails = (PriceDetailsResponseDTO)result.getBody();
                if (priceDetails != null) {
                    assertEquals(priceDetails.getBrandId(), testEcommerceDoc.getBrandId());
                    assertEquals(priceDetails.getProductId(),testEcommerceDoc.getProductId());
                    assertEquals(priceDetails.getFinalPrice(), testEcommerceDoc.getFinalPriceResponse());
                    assertEquals(priceDetails.getBrand(), testEcommerceDoc.getBrandResponse());
                    assertEquals(priceDetails.getProduct(), testEcommerceDoc.getProductResponse());
                }
            } else {
                assertEquals(result.getStatusCode() ,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            assertEquals(e.getMessage() ,"The details do not exist");
        }
    }


    private TestEcommerceDoc getMapperTestDoc(ArgumentsAccessor argumentsAccessor){

        LocalDateTime applicationDate = LocalDateTime.of(
                argumentsAccessor.getInteger(2),
                argumentsAccessor.getInteger(3),
                argumentsAccessor.getInteger(4),
                argumentsAccessor.getInteger(5),
                0
        );

       return TestEcommerceDoc
                .builder()
                .applicationDate(applicationDate)
                .brandId(argumentsAccessor.getLong(0))
               .productId(argumentsAccessor.getLong(1))
                .finalPriceResponse(argumentsAccessor.getDouble(6))
                .brandResponse(argumentsAccessor.getString(7))
                .productResponse(argumentsAccessor.getString(8))
                .build();
    }
}
