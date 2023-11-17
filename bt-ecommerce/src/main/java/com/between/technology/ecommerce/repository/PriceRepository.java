package com.between.technology.ecommerce.repository;


import com.between.technology.ecommerce.model.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {


    @Query("SELECT p FROM PriceEntity p WHERE p.startDate <= ?1 AND p.endDate >= ?1 AND p.brand.id = ?2 AND p.product.id = ?3 order by p.priority desc")
    Optional<List<PriceEntity>> findDetails(LocalDateTime date, long brandId, long productId);


}
