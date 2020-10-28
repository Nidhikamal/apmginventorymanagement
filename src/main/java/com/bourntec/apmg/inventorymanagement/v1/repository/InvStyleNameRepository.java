package com.bourntec.apmg.inventorymanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.InvStyleName;
@Repository("InvStyleNameRepository")



/**
 * 
 * Repository for carried out crud operations of StyleName
 * 
 * @author Vidya
 *
 */
public interface InvStyleNameRepository
extends JpaRepository<InvStyleName, String> {

	
}
