package com.bourntec.apmg.inventorymanagement.v1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.InventoryMaterialsUsed;



/**
 * 
 * Repository for carried out crud operations of CodesColor Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Repository(value = "InventoryMaterialsUsedRepository")
public interface InventoryMaterialsUsedRepository extends JpaRepository<InventoryMaterialsUsed, Long>, JpaSpecificationExecutor {

	/**
	 * Method that fetches Color Codes according the requested {id}
	 * 
	 * @param entity
	 * @return
	 */
	
    List<InventoryMaterialsUsed>  findByItemCode(String itemCode);
}
