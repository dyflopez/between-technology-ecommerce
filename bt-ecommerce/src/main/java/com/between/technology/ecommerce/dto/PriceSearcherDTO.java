package com.between.technology.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceSearcherDTO {

    @NotNull
    @JsonProperty("brand_id")
    private  long brandId;

    @NotNull
    @JsonProperty("application_date")
    private LocalDateTime applicationDate;

    @NotNull
    @JsonProperty("product_id")
    private  long productId;

}
