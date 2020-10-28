package com.bourntec.apmg.inventorymanagement.v1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.LibraryItem;
import com.bourntec.apmg.entity.VendorItemMatch;



/**
 * 
 * Repository for carried out crud operations of Vendor Item Match
 * 
 * @author Babu v
 *
 */
@Repository(value = "ImageItemRepository")
public interface ImageItemRepository extends 
JpaRepository<LibraryItem,String>,JpaSpecificationExecutor {

	 List<LibraryItem>  findByItemCode(String itemCode);

}
