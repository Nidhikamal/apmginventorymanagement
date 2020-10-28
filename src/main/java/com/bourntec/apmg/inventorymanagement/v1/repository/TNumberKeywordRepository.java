package com.bourntec.apmg.inventorymanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.TNumberKeyword;



/**
 * 
 * Repository for carried out crud operations of TNumberKeyword Entity
 * @author Srijini
 *
 */
@Repository(value = "TNumberKeywordRepository")
public interface TNumberKeywordRepository extends JpaRepository<TNumberKeyword, Long>, JpaSpecificationExecutor<TNumberKeyword>{
}
