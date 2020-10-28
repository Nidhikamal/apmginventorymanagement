package com.bourntec.apmg.inventorymanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.InvUnitCharge;



/**
 * 
 * Repository for carried out crud operations of Inv Unit Charge Entity
 * 
 * @author Nince
 *
 */
@Repository
public interface InvUnitChargeRepository extends JpaRepository<InvUnitCharge, String>, JpaSpecificationExecutor<InvUnitCharge>{

}
	

