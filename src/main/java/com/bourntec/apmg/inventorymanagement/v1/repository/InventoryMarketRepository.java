package com.bourntec.apmg.inventorymanagement.v1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.InventoryMarket;

@Repository(value = "InventoryMarketRepository")
public interface InventoryMarketRepository
extends JpaRepository<InventoryMarket, String>, JpaSpecificationExecutor {
Optional<InventoryMarket> findById(Long id);
}
