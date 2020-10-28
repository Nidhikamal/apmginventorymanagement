package com.bourntec.apmg.inventorymanagement.v1.dto.response; 
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

/**
 * Response dto for InventoryLibraryMaterialResponseDTO
 * @author Vidya.p
 *
 */
@Getter
@Setter
@Validated

public class InventoryLibraryMaterialResponseDTO{
	
	private Long id;
	private String libraryId;
	private Double karat;
	private String material;
	private Double price;
	private String color;
	private Double weight;
	
	private String responseMessage;
	
}
