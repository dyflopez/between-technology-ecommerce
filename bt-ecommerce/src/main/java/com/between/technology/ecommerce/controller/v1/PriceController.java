package com.between.technology.ecommerce.controller.v1;

import com.between.technology.ecommerce.controller.v1.docs.PriceDoc;
import com.between.technology.ecommerce.dto.PriceSearcherDTO;
import com.between.technology.ecommerce.service.IPriceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class PriceController implements PriceDoc {


    private final IPriceService iPriceService;

    @Override
    public ResponseEntity getPriceByDateAndProductIdAndBrandId(PriceSearcherDTO priceSearcherDTO) {
        return this.iPriceService.getFinalPrice(priceSearcherDTO);
    }

}
