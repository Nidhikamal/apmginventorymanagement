package com.bourntec.apmg.inventorymanagement.v1.dto.response;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
/**
 * Response dto for InventoryStoneVariant
 * @author AMAL
 *
 */
@Getter
@Setter
@Validated
public class InventoryStoneVariantResponseDTO {

	private Long id;
	private String itemCode;
	private Double weight;
	private Integer pieces;
	private Double size;
	private String stoneId;
	private Double price;
	private Short plateSize;
	private Double pointers;
	private Integer totalPieces;
	private Double totalWeight;
	private Double styleSize;
	private Integer pieces1;
	private Integer pieces2;
	private Integer pieces3;
	private Integer pieces4;
	private Integer pieces5;
	private Double weight1;
	private Double weight2;
	private Double weight3;
	private Double weight4;
	private Double weight5;
	private Double mmSize;
	private String responseMessage;
}
