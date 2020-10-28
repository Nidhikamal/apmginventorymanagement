package com.bourntec.apmg.inventorymanagement.v1.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CollectionSubKeyword;



/**
 * 
 * Repository for carried out crud operations of CodesColor Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Repository(value = "CollectionSubKeywordRepository")
public interface CollectionSubKeywordRepository extends JpaRepository<CollectionSubKeyword, String>,JpaSpecificationExecutor<CollectionSubKeyword> {

	Optional<CollectionSubKeyword> findBySubKeyId(String subKeyId);

	/**
	 * Method that fetches Color Codes according the requested {id}
	 * 
	 * @param entity
	 * @return
	 */
	

}
