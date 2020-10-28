package com.bourntec.apmg.inventorymanagement.v1.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Srijini
 *
 */
@Getter
@Setter

public class ManufactureSmallStoneResponseDTO {
	private Long id;
	private String jobNo;
	private String itemCode;
	private String shape;
	private String clarity;
	private String color;
	private Double weight;
	private Double styleSize;
	private Double pointers;
	private String setting;
	private Double pieces;
	private Double price;
	private Double total;
	private String remarks;
	private String stoneId;
}
