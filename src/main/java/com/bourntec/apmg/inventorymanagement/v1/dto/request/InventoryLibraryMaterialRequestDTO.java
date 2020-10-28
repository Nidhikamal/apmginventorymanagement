package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InventoryLibraryMaterial;

import lombok.Getter;
import lombok.Setter;

/**
 * Request DTO for InvWeightRequestDTO
 * @author Vidya
 *
 */

@Getter
@Setter
@Validated

public class InventoryLibraryMaterialRequestDTO {
	private Long id;
	@NotBlank(message="Please enter libraryId")
	@Size(min = 1, max = 10, message = "Library id must be between 1 and 15 characters")
	private String libraryId;
	private Double karat;
	@Size(min = 1, max = 9, message = "Material must be between 1 and 9 characters")
	private String material;
	private Double price;
	@Size(min = 1, max = 5, message = "Color must be between 1 and 15 characters")
	private String color;
	private Double weight;
	

	


	public  InventoryLibraryMaterial toModel(InventoryLibraryMaterialRequestDTO inventoryLibraryMaterialRequestDTO ) {

		InventoryLibraryMaterial inventoryLibraryMaterial = new InventoryLibraryMaterial();

		try {
			if (inventoryLibraryMaterialRequestDTO.getId() != null) {
				inventoryLibraryMaterial.setId(inventoryLibraryMaterialRequestDTO.getId());
			}
			
			if (inventoryLibraryMaterialRequestDTO.getLibraryId() != null&&!inventoryLibraryMaterialRequestDTO.getLibraryId().isEmpty()) {
				inventoryLibraryMaterial.setLibraryId(inventoryLibraryMaterialRequestDTO.getLibraryId());
			}
			if (inventoryLibraryMaterialRequestDTO.getKarat() != null ) {
				inventoryLibraryMaterial.setKarat(inventoryLibraryMaterialRequestDTO.getKarat());
			}
			if (inventoryLibraryMaterialRequestDTO.getMaterial() != null && !inventoryLibraryMaterialRequestDTO.getMaterial().isEmpty()) {
				inventoryLibraryMaterial.setMaterial(inventoryLibraryMaterialRequestDTO.getMaterial());
			}	
			if (inventoryLibraryMaterialRequestDTO.getColor() != null) {
				inventoryLibraryMaterial.setColor(inventoryLibraryMaterialRequestDTO.getColor());
			}	
			if (inventoryLibraryMaterialRequestDTO.getPrice() != null) {
				inventoryLibraryMaterial.setPrice(inventoryLibraryMaterialRequestDTO.getPrice());
			}	
			
			if (inventoryLibraryMaterialRequestDTO.getWeight()!= null) {
				inventoryLibraryMaterial.setWeight(inventoryLibraryMaterialRequestDTO.getWeight());
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventoryLibraryMaterial;

	}

}
