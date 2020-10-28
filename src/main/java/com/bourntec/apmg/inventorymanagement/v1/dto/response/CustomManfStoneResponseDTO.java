package com.bourntec.apmg.inventorymanagement.v1.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Srijini
 *
 */
@Getter
@Setter
public class CustomManfStoneResponseDTO extends ManfStoneResponseDTO {
	private String stoneId;
	
	private String specification;
	
	private Double salesPrice;
	
	private String desc1;
	
	private int mntPcs;
	
	private int pieces;
	
	private int weight;
}
