package com.bourntec.apmg.inventorymanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.Inventory1;
import com.bourntec.apmg.entity.InventoryStockHistory;



/**
 * 
 * Repository for carried out crud operations of CodesColor Entity
 * 
 * @author Vidya.p
 *
 */
@Repository(value = "InventoryStockHistory")
public interface InventoryStockHistoryRepository extends 
JpaRepository<InventoryStockHistory,String> ,JpaSpecificationExecutor{

	
}
