package com.bourntec.apmg.inventorymanagement.v1.dto.response;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
/**
 * Response dto for InventoryLibraryStone
 * @author AMAL
 *
 */
@Getter
@Setter
@Validated
public class InventoryLibraryStoneResponseDTO {

	private Long id;
	private String itemCode;
	private String clarity;
	private String color;
	private Long libraryId;
	private Integer pieces;
	private Double pointers;
	private Double price;
	private String remarks;
	private String setting;
	private String shape;
	private Double styleSize;
	private Double total;
	private Double weight;
	
	private String responseMessage;
}
