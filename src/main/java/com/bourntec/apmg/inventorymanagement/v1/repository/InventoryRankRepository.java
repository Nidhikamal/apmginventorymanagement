package com.bourntec.apmg.inventorymanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
 
import com.bourntec.apmg.entity.InventoryRank;



/**
 * 
 * Repository for carried out crud operations of CodesColor Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Repository(value = "InventoryRankRepository")
public interface InventoryRankRepository extends JpaRepository<InventoryRank, String>, JpaSpecificationExecutor<InventoryRank> {

	/**
	 * Method that fetches Color Codes according the requested {id}
	 * 
	 * @param entity
	 * @return
	 */
	

}
