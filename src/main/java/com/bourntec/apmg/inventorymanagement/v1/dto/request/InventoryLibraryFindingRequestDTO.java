package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InvWeight;
import com.bourntec.apmg.entity.InventoryLibrary;
import com.bourntec.apmg.entity.InventoryLibraryFinding;

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

public class InventoryLibraryFindingRequestDTO {
    private Long id;
	@NotBlank(message="Please enter itemCode")
	@Size(min = 1, max = 15, message = "Job No must be between 1 and 15 characters")
	private String itemCode;
	@NotBlank(message="Please enter libraryId")
	private Long libraryId;
	private Double karat;
	@Size(min = 1, max = 5, message = "Material must be between 1 and 5 characters")
	private String material;
	private Long pieces;
	private Double price;
	private Double total;
	private Double wtPiece;
	


	public InventoryLibraryFinding toModel(InventoryLibraryFindingRequestDTO inventoryLibraryFindingRequestDTO ) {

		InventoryLibraryFinding inventoryLibraryFinding = new InventoryLibraryFinding();

		try {
			if (inventoryLibraryFindingRequestDTO.getId() != null) {
				inventoryLibraryFinding.setId(inventoryLibraryFindingRequestDTO.getId());
			}
			
			if (inventoryLibraryFindingRequestDTO.getItemCode() != null) {
				inventoryLibraryFinding.setItemCode(inventoryLibraryFindingRequestDTO.getItemCode());
			}
			if (inventoryLibraryFindingRequestDTO.getLibraryId() != null) {
				inventoryLibraryFinding.setLibraryId(inventoryLibraryFindingRequestDTO.getLibraryId());
			}
			if (inventoryLibraryFindingRequestDTO.getKarat() != null ) {
				inventoryLibraryFinding.setKarat(inventoryLibraryFindingRequestDTO.getKarat());
			}
			if (inventoryLibraryFindingRequestDTO.getMaterial() != null && !inventoryLibraryFindingRequestDTO.getMaterial().isEmpty()) {
				inventoryLibraryFinding.setMaterial(inventoryLibraryFindingRequestDTO.getMaterial());
			}	
			if (inventoryLibraryFindingRequestDTO.getPieces() != null) {
				inventoryLibraryFinding.setPieces(inventoryLibraryFindingRequestDTO.getPieces());
			}	
			if (inventoryLibraryFindingRequestDTO.getPrice() != null) {
				inventoryLibraryFinding.setPrice(inventoryLibraryFindingRequestDTO.getPrice());
			}	
			
			if (inventoryLibraryFindingRequestDTO.getTotal() != null) {
				inventoryLibraryFinding.setTotal(inventoryLibraryFindingRequestDTO.getTotal());
			}
			
			if (inventoryLibraryFindingRequestDTO.getWtPiece() != null) {
				inventoryLibraryFinding.setWtPiece(inventoryLibraryFindingRequestDTO.getWtPiece());
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventoryLibraryFinding;

	}

}
