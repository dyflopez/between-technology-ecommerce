package com.between.technology.ecommerce.controller.v1;

import com.between.technology.ecommerce.dto.PriceSearcherDTO;
import com.between.technology.ecommerce.dto.response.PriceDetailsResponseDTO;
import com.between.technology.ecommerce.mocks.MocksDto;
import com.between.technology.ecommerce.service.IPriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;

@SpringBootTest
public class PriceControllerTest {

    @Mock
    private IPriceService iPriceService;

    @InjectMocks
    private PriceController priceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetPriceByDateAndProductIdAndBrandId() {

        //getPriceSearcherDTO

        LocalDateTime date = LocalDateTime.of(2023, 11, 15, 12, 30, 0);

        PriceSearcherDTO mockDTO = MocksDto.getPriceSearcherDTO(date,1,1);

        PriceDetailsResponseDTO pricesFinally = MocksDto.getPriceDetailsResponseDTO(1,
                1,
                date,
                date,
                25.45,
                "ZARA",
                "VESTIDO RIB CUT OUT"
        );

        ResponseEntity<PriceDetailsResponseDTO> expectedResponse = ResponseEntity.ok(pricesFinally);
        
        when(iPriceService.getFinalPrice(mockDTO)).thenReturn(expectedResponse);
        when(priceController.getPriceByDateAndProductIdAndBrandId(mockDTO)).thenReturn(expectedResponse);


        ResponseEntity<PriceDetailsResponseDTO> response = priceController.getPriceByDateAndProductIdAndBrandId(mockDTO);

        assertEquals(response.getBody().getProductId(), 1);
        assertNotNull(response.getBody());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getProductId(), 1);
        assertEquals(response.getBody().getBrand(), "ZARA");
        assertEquals(response.getBody().getProduct(), "VESTIDO RIB CUT OUT");

    }
}
