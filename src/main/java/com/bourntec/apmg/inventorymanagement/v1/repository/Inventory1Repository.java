package com.bourntec.apmg.inventorymanagement.v1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.Inventory1;

/**
 * 
 * Repository for carried out crud operations of CodesColor Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Repository(value = "Inventory1Repository")
public interface Inventory1Repository extends JpaRepository<Inventory1, String>, JpaSpecificationExecutor {

	/**
	 * Method that fetches Color Codes according the requested {id}
	 * 
	 * @param entity
	 * @return
	 */

	@Modifying
	@Query("update Inventory1 inv  set inv.inStockP =  ?1 where inv.itemCode = ?2")
	void updateStock(int stock, String itemCode);

	Optional<Inventory1> findByItemCode(String invId);

}
