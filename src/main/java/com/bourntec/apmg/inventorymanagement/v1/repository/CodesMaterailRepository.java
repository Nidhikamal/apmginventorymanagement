package com.bourntec.apmg.inventorymanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CodesMaterial;



/**
 * 
 * Repository for carried out crud operations of CodesMaterial Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Repository(value = "CodesMaterailRepository")
public interface CodesMaterailRepository extends JpaRepository<CodesMaterial, String> ,JpaSpecificationExecutor{

	/**
	 * Method that fetches Material Codes according the requested {id}
	 * 
	 * @param entity
	 * @return
	 */
	

}
