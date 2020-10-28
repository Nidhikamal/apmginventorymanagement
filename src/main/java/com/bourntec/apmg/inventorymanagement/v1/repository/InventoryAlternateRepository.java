package com.bourntec.apmg.inventorymanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.InventoryAlternate;

/**
 * 
 * Repository for carried out crud operations of InventoryAlternate
 * 
 * @author Babu v
 *
 */
@Repository(value = "InventoryAlternateRepository")
public interface InventoryAlternateRepository extends JpaRepository<InventoryAlternate, Long>, JpaSpecificationExecutor<InventoryAlternate>{

}