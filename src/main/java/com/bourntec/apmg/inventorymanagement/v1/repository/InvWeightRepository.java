package com.bourntec.apmg.inventorymanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.InvWeight;

/**
 * 
 * Repository for carried out crud operations of CodesColor Entity
 * 
 * @author Vidya.p
 *
 */
@Repository(value = "InvWeightRepository")
public interface InvWeightRepository extends JpaRepository<InvWeight, String>, JpaSpecificationExecutor<InvWeight> {

	

}
