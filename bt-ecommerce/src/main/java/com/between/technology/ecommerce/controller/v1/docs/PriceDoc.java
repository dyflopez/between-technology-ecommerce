package com.between.technology.ecommerce.controller.v1.docs;

import com.between.technology.ecommerce.dto.PriceSearcherDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Tag(name = "Prices", description = "API exposed for retrieving prices")
@RequestMapping("/api/v1/price")
public interface PriceDoc {

    @Operation(
            summary = "Get prices by Date, Product ID, and Brand",
            description = "This operation searches for the current value of a product."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product information",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @PostMapping("/details")
    ResponseEntity getPriceByDateAndProductIdAndBrandId(@Valid @RequestBody PriceSearcherDTO priceSearcherDTO);
}
