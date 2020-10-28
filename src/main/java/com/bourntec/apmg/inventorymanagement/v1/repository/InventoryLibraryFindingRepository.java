package com.bourntec.apmg.inventorymanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.InvWeight;
import com.bourntec.apmg.entity.InventoryLibrary;
import com.bourntec.apmg.entity.InventoryLibraryFinding;

/**
 * 
 * Repository for carried out crud operations of CodesColor Entity
 * 
 * @author Vidya.p
 *
 */
@Repository(value = "InventoryLibraryFindingRepository")
public interface InventoryLibraryFindingRepository extends JpaRepository<InventoryLibraryFinding, Long>, JpaSpecificationExecutor<InventoryLibraryFinding> {

	

}
