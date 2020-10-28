package com.bourntec.apmg.inventorymanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.Inventory1;
import com.bourntec.apmg.entity.Inventory2;
import com.bourntec.apmg.entity.PointSaleOrderJob;



/**
 * 
 * Repository for carried out crud operations of CodesColor Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Repository(value = "Inventory2Repository")
public interface Inventory2Repository extends JpaRepository<Inventory2,String> ,JpaSpecificationExecutor {
	Inventory2  findByItemCode(String itemCode);
}
