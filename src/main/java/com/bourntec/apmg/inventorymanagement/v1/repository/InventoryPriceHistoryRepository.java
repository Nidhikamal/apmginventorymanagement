package com.bourntec.apmg.inventorymanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.InventoryPriceHistory;



/**
 * 
 * Repository for carried out crud operations of CodesColor Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Repository(value = "InventoryPriceHistoryRepository")
public interface InventoryPriceHistoryRepository extends JpaRepository<InventoryPriceHistory, String> {

	/**
	 * Method that fetches Color Codes according the requested {id}
	 * 
	 * @param entity
	 * @return
	 */
	

}
