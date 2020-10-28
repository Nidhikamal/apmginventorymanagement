package com.bourntec.apmg.inventorymanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.TNumber;



/**
 * 
 * Repository for carried out crud operations of TNumber Entity
 * @author Srijini
 *
 */
@Repository(value = "TNumberRepository")
public interface TNumberRepository extends JpaRepository<TNumber, Long>, JpaSpecificationExecutor<TNumber>{
}
