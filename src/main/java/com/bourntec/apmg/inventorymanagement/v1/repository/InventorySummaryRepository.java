package com.bourntec.apmg.inventorymanagement.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.InventoryAlternate;
import com.bourntec.apmg.entity.InventoryFindings;
import com.bourntec.apmg.entity.InventorySummary;

/**
 * @author Babu
 *
 */
@Repository
public interface InventorySummaryRepository
		extends JpaRepository<InventorySummary, Long>, JpaSpecificationExecutor<InventorySummary> {
	InventorySummary  findByItemCode(String itemCode);
}
