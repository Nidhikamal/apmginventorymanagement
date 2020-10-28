package com.bourntec.apmg.inventorymanagement.v1.dto.response; 
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

/**
 * Response dto for InventoryLibraryFindingResponseDTO
 * @author Vidya.p
 *
 */
@Getter
@Setter
@Validated

public class InventoryLibraryFindingResponseDTO{
	
	private Long id;
	private String itemCode;
	private Long libraryId;
	private Double karat;
	private String material;
	private Long pieces;
	private Double price;
	private Double total;
	private Double wtPiece;	
	private String responseMessage;
	
}
