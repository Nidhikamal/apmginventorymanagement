package com.bourntec.apmg.inventorymanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.TypeData;



/**
 * 
 * Repository for carried out crud operations of CodesColor Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Repository(value = "TypeDataRepository")
public interface TypeDataRepository extends JpaRepository<TypeData, String>, JpaSpecificationExecutor<TypeData>{

	/**
	 * Method that fetches TypeData according the requested {id}
	 * 
	 * @param entity
	 * @return
	 */
	

}
