package com.bourntec.apmg.inventorymanagement.v1.dto.response;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventorySummaryRequestDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Babu
 *
 */
@Getter
@Setter
public class InventorySummaryResponseDTO extends InventorySummaryRequestDTO{
	private String itemCode;
	
	private String pictures;
	
	private String silver;
	
	private String master;
	
	private String stoneBreakdown;
	
	private String design;

	private String responseMessage;
}
