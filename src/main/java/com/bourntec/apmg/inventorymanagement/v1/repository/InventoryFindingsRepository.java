package com.bourntec.apmg.inventorymanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.InventoryFindings;

/**
 * @author Srijini
 *
 */
@Repository
public interface InventoryFindingsRepository
		extends JpaRepository<InventoryFindings, Long>, QueryByExampleExecutor<InventoryFindings> {

}
