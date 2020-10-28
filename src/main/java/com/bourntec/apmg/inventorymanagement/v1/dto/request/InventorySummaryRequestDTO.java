
package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import javax.persistence.Column;

import com.bourntec.apmg.entity.InventoryFindings;
import com.bourntec.apmg.entity.InventorySummary;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author Babu
 *
 */
@Getter
@Setter
public class InventorySummaryRequestDTO {

	private String itemCode;
	
	private String pictures;
	
	private String silver;
	
	private String master;
	
	private String stoneBreakdown;
	
	private String design;


	public InventorySummary toModel(InventorySummaryRequestDTO summary) {
		InventorySummary inventorySummary = new InventorySummary();

		try {
			inventorySummary.setItemCode(summary.getItemCode());
			inventorySummary.setPictures(summary.getPictures());	
			inventorySummary.setSilver(summary.getSilver());	
			inventorySummary.setMaster(summary.getMaster());	
			inventorySummary.setStoneBreakdown(summary.getStoneBreakdown());
			inventorySummary.setDesign(summary.getDesign());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventorySummary;

	}
}



