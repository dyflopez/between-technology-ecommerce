package com.between.technology.ecommerce.service;

import com.between.technology.ecommerce.dto.PriceSearcherDTO;
import org.springframework.http.ResponseEntity;

public interface IPriceService {

    ResponseEntity getFinalPrice(PriceSearcherDTO priceSearcherDTO);

}
