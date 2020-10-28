package com.bourntec.apmg.inventorymanagement.v1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.InventoryKeyword;

@Repository(value = "InventoryKeywordRepository")
public interface InventoryKeywordRepository
extends JpaRepository<InventoryKeyword, String>, JpaSpecificationExecutor {
Optional<InventoryKeyword> findById(Long id);
}
