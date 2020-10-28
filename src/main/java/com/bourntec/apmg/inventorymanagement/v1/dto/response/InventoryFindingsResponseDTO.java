package com.bourntec.apmg.inventorymanagement.v1.dto.response;


import lombok.Getter;
import lombok.Setter;

/**
 * @author Srijini
 *
 */
@Getter
@Setter
public class InventoryFindingsResponseDTO {
	private Long id;
	private String itemCode;
	private String findingId;
	private Integer pieces;
	private Integer price;
	private Integer total;
	private Integer wtPiece;
	private Integer karat;
	private String material;
	
	private String responseMessage;
}
