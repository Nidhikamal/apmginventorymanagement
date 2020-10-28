package com.bourntec.apmg.inventorymanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.MarketCode;



/**
 * 
 * Repository for carried out crude operations of Market Code Entity
 * 
 * @author Nince
 *
 */
@Repository
public interface MarketCodeRepository extends JpaRepository<MarketCode, String>, JpaSpecificationExecutor<MarketCode>{

}
	

