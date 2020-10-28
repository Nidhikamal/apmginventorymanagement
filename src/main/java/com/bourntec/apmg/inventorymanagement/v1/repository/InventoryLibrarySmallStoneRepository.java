package com.bourntec.apmg.inventorymanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.InventoryLibrarySmallStone;

@Repository(value = "InventoryLibrarySmallStoneRepository")
public interface InventoryLibrarySmallStoneRepository
		extends JpaRepository<InventoryLibrarySmallStone, Long>, JpaSpecificationExecutor<InventoryLibrarySmallStone> {
}
