package com.bourntec.apmg.inventorymanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.InventoryLibraryStone;

@Repository(value = "InventoryLibraryStoneRepository")
public interface InventoryLibraryStoneRepository
		extends JpaRepository<InventoryLibraryStone, Long>, JpaSpecificationExecutor<InventoryLibraryStone> {
}
