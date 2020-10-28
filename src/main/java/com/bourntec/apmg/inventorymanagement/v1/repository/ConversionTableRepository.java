package com.bourntec.apmg.inventorymanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.ConversionTable;



/**
 * 
 * Repository for carried out crude operations of Conversion Table Entity
 * 
 * @author Nince
 *
 */
@Repository
public interface ConversionTableRepository extends JpaRepository<ConversionTable, String>, JpaSpecificationExecutor<ConversionTable>{

}
	

