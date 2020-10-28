package com.bourntec.apmg.inventorymanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.TNumberHistory;



/**
 * 
 * Repository for carried out crud operations of TNumberHistory Entity
 * @author Srijini
 *
 */
@Repository(value = "TNumberHistoryRepository")
public interface TNumberHistoryRepository extends JpaRepository<TNumberHistory, Long>, JpaSpecificationExecutor<TNumberHistory>{
}
