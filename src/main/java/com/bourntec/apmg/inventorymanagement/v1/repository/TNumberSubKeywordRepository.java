package com.bourntec.apmg.inventorymanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.TNumberSubKeyword;



/**
 * 
 * Repository for carried out crud operations of TNumberSubKeyword Entity
 * @author Srijini
 *
 */
@Repository(value = "TNumberSubKeywordRepository")
public interface TNumberSubKeywordRepository extends JpaRepository<TNumberSubKeyword, Long>, JpaSpecificationExecutor<TNumberSubKeyword>{
}
