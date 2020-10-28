package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InventoryLibraryStone;

import lombok.Getter;
import lombok.Setter;
/**
 * Request DTO for InventoryLibraryStone
 * @author AMAL
 *
 */
@Getter
@Setter
@Validated
public class InventoryLibraryStoneRequestDTO {

	private Long id;
	@NotBlank(message="Please enter Item Code")
	@Size(min = 1, max = 15, message = "Item Code must be between 1 and 15 characters")
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
	

	public InventoryLibraryStone toModel(InventoryLibraryStoneRequestDTO invLibrarystoneRequestDTO) {

		InventoryLibraryStone invlibrarystone = new InventoryLibraryStone();

		try {
			if (invLibrarystoneRequestDTO.getId() != null) {
				invlibrarystone.setId(invLibrarystoneRequestDTO.getId());
			}
			if (invLibrarystoneRequestDTO.getItemCode() != null && !invLibrarystoneRequestDTO.getItemCode().isEmpty()) {
				invlibrarystone.setItemCode(invLibrarystoneRequestDTO.getItemCode());
			}
			if (invLibrarystoneRequestDTO.getClarity() != null && !invLibrarystoneRequestDTO.getClarity().isEmpty()) {
				invlibrarystone.setClarity(invLibrarystoneRequestDTO.getClarity());
			}
			if (invLibrarystoneRequestDTO.getColor() != null && !invLibrarystoneRequestDTO.getColor().isEmpty()) {
				invlibrarystone.setColor(invLibrarystoneRequestDTO.getColor());
			}
			if (invLibrarystoneRequestDTO.getLibraryId() != null && invLibrarystoneRequestDTO.getLibraryId()>0) {
				invlibrarystone.setLibraryId(invLibrarystoneRequestDTO.getLibraryId());
			}
			if (invLibrarystoneRequestDTO.getPieces() != null && invLibrarystoneRequestDTO.getPieces()>0) {
				invlibrarystone.setPieces(invLibrarystoneRequestDTO.getPieces());
			}
			if (invLibrarystoneRequestDTO.getPointers() != null && invLibrarystoneRequestDTO.getPointers()>0) {
				invlibrarystone.setPointers(invLibrarystoneRequestDTO.getPointers());
			}
			if (invLibrarystoneRequestDTO.getPrice() != null && invLibrarystoneRequestDTO.getPrice()>0) {
				invlibrarystone.setPrice(invLibrarystoneRequestDTO.getPrice());
			}
			if (invLibrarystoneRequestDTO.getRemarks() != null && !invLibrarystoneRequestDTO.getRemarks().isEmpty()) {
				invlibrarystone.setRemarks(invLibrarystoneRequestDTO.getRemarks());
			}
			if (invLibrarystoneRequestDTO.getSetting() != null && !invLibrarystoneRequestDTO.getSetting().isEmpty()) {
				invlibrarystone.setSetting(invLibrarystoneRequestDTO.getSetting());
			}
			if (invLibrarystoneRequestDTO.getShape() != null && !invLibrarystoneRequestDTO.getShape().isEmpty()) {
				invlibrarystone.setShape(invLibrarystoneRequestDTO.getShape());
			}
			if (invLibrarystoneRequestDTO.getTotal() != null && invLibrarystoneRequestDTO.getTotal()>0) {
				invlibrarystone.setTotal(invLibrarystoneRequestDTO.getTotal());
			}
			if (invLibrarystoneRequestDTO.getWeight() != null && invLibrarystoneRequestDTO.getWeight()>0) {
				invlibrarystone.setWeight(invLibrarystoneRequestDTO.getWeight());
			}
			if (invLibrarystoneRequestDTO.getStyleSize() != null && invLibrarystoneRequestDTO.getStyleSize()>0) {
				invlibrarystone.setStyleSize(invLibrarystoneRequestDTO.getStyleSize());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invlibrarystone;

	}

}