package com.bourntec.apmg.inventorymanagement.v1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.InventoryAlternate;
import com.bourntec.apmg.entity.VendorItemMatch;



/**
 * 
 * Repository for carried out crud operations of Vendor Item Match
 * 
 * @author Babu v
 *
 */
@Repository(value = "VendorItemMatchRepository")
public interface VendorItemMatchRepository extends 
JpaRepository<VendorItemMatch,String>,JpaSpecificationExecutor {

	 List<VendorItemMatch>  findByItemCode(String itemCode);

}
