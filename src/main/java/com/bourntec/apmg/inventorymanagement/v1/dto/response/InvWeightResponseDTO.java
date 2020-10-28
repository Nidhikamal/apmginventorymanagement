package com.bourntec.apmg.inventorymanagement.v1.dto.response; 
import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.Inventory1RequestDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * Response dto for InvWeightResponseDTO
 * @author Vidya.p
 *
 */
@Getter
@Setter
@Validated

public class InvWeightResponseDTO{

	private String itemCode;
	private String waxType;
	private String injectingTime;
	private String vaccum;
	private String pressure;
	private String tumblingTime;
	private Double wtIn10k;
	private Double wtIn14k;
	private Double wtIn18k;
	private Double wtInPt;
	private String config;
	private String locking;
	private String responseMessage;
	
}
