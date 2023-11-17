package com.between.technology.ecommerce.service.impl;

import com.between.technology.ecommerce.dto.response.PriceDetailsResponseDTO;
import com.between.technology.ecommerce.dto.PriceSearcherDTO;
import com.between.technology.ecommerce.exception.MyHandleException;
import com.between.technology.ecommerce.mapper.MapperPrice;
import com.between.technology.ecommerce.model.PriceEntity;
import com.between.technology.ecommerce.repository.PriceRepository;
import com.between.technology.ecommerce.service.IPriceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PriceServiceImpl implements IPriceService {

    private final PriceRepository priceRepository;
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity getFinalPrice(PriceSearcherDTO priceSearcherDTO) {

        log.info(
                "Searching final price -  getFinalPrice() request data: \n{}",
                priceSearcherDTO
        );

        var priceList = this.priceRepository.findDetails(priceSearcherDTO.getApplicationDate(),
                                                      priceSearcherDTO.getBrandId(),
                                                    priceSearcherDTO.getProductId())
                .orElseGet(ArrayList::new);

        if (priceList.isEmpty()) {
            throw new MyHandleException("The details do not exist");
        }
        log.info(
                "getting final price-  getPricesFinally() request data: \n{}",
                priceSearcherDTO
        );
        PriceDetailsResponseDTO pricesFinally = this.getPricesFinally(priceList);

        return ResponseEntity.ok(pricesFinally);
    }


    private PriceDetailsResponseDTO getPricesFinally(List<PriceEntity> priceEntityList){
        return priceEntityList
                .stream()
                .max(Comparator.comparingInt(PriceEntity::getPriority))
                .map(details -> MapperPrice.mapToDto(details))
                .get();
    }
}
