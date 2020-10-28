package com.bourntec.apmg.inventorymanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.InventoryStoneVariant;

@Repository(value = "InventoryStoneVariantRepository")
public interface InventoryStoneVariantRepository
		extends JpaRepository<InventoryStoneVariant, Long>, JpaSpecificationExecutor<InventoryStoneVariant> {
}
