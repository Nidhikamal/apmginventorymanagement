package com.bourntec.apmg.inventorymanagement.v1.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.ProductKeywords;
import com.bourntec.apmg.entity.VendorItemMatch;



/**
 * 
 * Repository for carried out crud operations of Keywords
 * 
 * @author Babu v
 *
 */
@Repository(value = "ProductKeywordsRepository")
public interface ProductKeywordsRepository extends 
JpaRepository<ProductKeywords,String>,JpaSpecificationExecutor {

	
	//Optional<ProductKeywords>  findById(String itemCode);

	//void deleteById(Optional<ProductKeywords> prodkey);
}
