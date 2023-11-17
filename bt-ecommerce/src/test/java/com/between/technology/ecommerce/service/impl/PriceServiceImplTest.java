package com.between.technology.ecommerce.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.between.technology.ecommerce.mocks.MocksDto;
import com.between.technology.ecommerce.mocks.MocksEntity;
import com.between.technology.ecommerce.model.PriceEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.between.technology.ecommerce.dto.PriceSearcherDTO;
import com.between.technology.ecommerce.dto.response.PriceDetailsResponseDTO;
import com.between.technology.ecommerce.repository.PriceRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class PriceServiceImplTest {

    @Autowired
    private PriceServiceImpl iPriceServiceImpl;

    @MockBean
    private PriceRepository priceRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetPriceByDateAndProductIdAndBrandId() {

        var mockDTO = new PriceSearcherDTO();
        mockDTO.setProductId(1);
        mockDTO.setBrandId(1);
        LocalDateTime date = LocalDateTime.of(2023, 11, 15, 12, 30, 0);
        mockDTO.setApplicationDate(date);

        var mockProduct = MocksEntity
                .getMockProductEntity(1L ,"jeans");


        var mockBrand = MocksEntity
                .getMockBrandEntity(1L,"ZARA");

        var mockPriceEntity = MocksEntity
                .getMockPriceEntity(30.50,mockProduct,mockBrand,1);

        var mockPrice = MocksEntity
                .getMockPriceEntity(10,mockProduct,mockBrand,0);

        List<PriceEntity> priceEntityList = new ArrayList<>();
        priceEntityList.add(mockPriceEntity);
        priceEntityList.add(mockPrice);

        when(priceRepository.findDetails(any(),anyLong(),anyLong())).thenReturn(Optional.of(priceEntityList));

        ResponseEntity response =   iPriceServiceImpl.getFinalPrice(mockDTO);
        var responseBody  = (PriceDetailsResponseDTO)response.getBody();

        verify(priceRepository, times(1)).findDetails(any(),anyLong(),anyLong());


        PriceDetailsResponseDTO pricesFinally = new  PriceDetailsResponseDTO();

        assertEquals(responseBody.getProductId(), 1);
        assertEquals(responseBody.getProduct(), "jeans");
        assertEquals(responseBody.getFinalPrice(), 30.5);

    }

    @Test
    void testShowErrorWhenDetailsDoNotExist() {

        LocalDateTime date = LocalDateTime.of(2023, 11, 15, 12, 30, 0);

        var mockDTO = MocksDto.getPriceSearcherDTO(date,1,1);

        mockDTO.setApplicationDate(date);


        when(priceRepository.findDetails(any(), anyLong(), anyLong())).thenReturn(Optional.of(new ArrayList<>()));

        assertThrows(Exception.class, () -> iPriceServiceImpl.getFinalPrice(mockDTO), "The details do not exist");

    }
}
