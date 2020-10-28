package com.bourntec.apmg.inventorymanagement.v1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.InventorySubKeyword;

@Repository(value = "InventorySubKeywordRepository")
public interface InventorySubKeywordRepository
extends JpaRepository<InventorySubKeyword, String>, JpaSpecificationExecutor {
Optional<InventorySubKeyword> findById(Long id);
}
