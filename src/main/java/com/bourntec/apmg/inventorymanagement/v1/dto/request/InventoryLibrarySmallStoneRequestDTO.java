package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InventoryLibrarySmallStone;

import lombok.Getter;
import lombok.Setter;
/**
 * Request DTO for InventoryLibrarySmallStone
 * @author AMAL
 *
 */
@Getter
@Setter
@Validated
public class InventoryLibrarySmallStoneRequestDTO {

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
	private String stoneId;
	private Double styleSize;
	private Double total;
	private Double weight;
	

	public InventoryLibrarySmallStone toModel(InventoryLibrarySmallStoneRequestDTO invLibrarysmallstoneRequestDTO) {

		InventoryLibrarySmallStone invlibrarysmallstone = new InventoryLibrarySmallStone();

		try {
			if (invLibrarysmallstoneRequestDTO.getId() != null) {
				invlibrarysmallstone.setId(invLibrarysmallstoneRequestDTO.getId());
			}
			if (invLibrarysmallstoneRequestDTO.getItemCode() != null && !invLibrarysmallstoneRequestDTO.getItemCode().isEmpty()) {
				invlibrarysmallstone.setItemCode(invLibrarysmallstoneRequestDTO.getItemCode());
			}
			if (invLibrarysmallstoneRequestDTO.getClarity() != null && !invLibrarysmallstoneRequestDTO.getClarity().isEmpty()) {
				invlibrarysmallstone.setClarity(invLibrarysmallstoneRequestDTO.getClarity());
			}
			if (invLibrarysmallstoneRequestDTO.getColor() != null && !invLibrarysmallstoneRequestDTO.getColor().isEmpty()) {
				invlibrarysmallstone.setColor(invLibrarysmallstoneRequestDTO.getColor());
			}
			if (invLibrarysmallstoneRequestDTO.getLibraryId() != null && invLibrarysmallstoneRequestDTO.getLibraryId()>0) {
				invlibrarysmallstone.setLibraryId(invLibrarysmallstoneRequestDTO.getLibraryId());
			}
			if (invLibrarysmallstoneRequestDTO.getPieces() != null && invLibrarysmallstoneRequestDTO.getPieces()>0) {
				invlibrarysmallstone.setPieces(invLibrarysmallstoneRequestDTO.getPieces());
			}
			if (invLibrarysmallstoneRequestDTO.getPointers() != null && invLibrarysmallstoneRequestDTO.getPointers()>0) {
				invlibrarysmallstone.setPointers(invLibrarysmallstoneRequestDTO.getPointers());
			}
			if (invLibrarysmallstoneRequestDTO.getPrice() != null && invLibrarysmallstoneRequestDTO.getPrice()>0) {
				invlibrarysmallstone.setPrice(invLibrarysmallstoneRequestDTO.getPrice());
			}
			if (invLibrarysmallstoneRequestDTO.getRemarks() != null && !invLibrarysmallstoneRequestDTO.getRemarks().isEmpty()) {
				invlibrarysmallstone.setRemarks(invLibrarysmallstoneRequestDTO.getRemarks());
			}
			if (invLibrarysmallstoneRequestDTO.getSetting() != null && !invLibrarysmallstoneRequestDTO.getSetting().isEmpty()) {
				invlibrarysmallstone.setSetting(invLibrarysmallstoneRequestDTO.getSetting());
			}
			if (invLibrarysmallstoneRequestDTO.getShape() != null && !invLibrarysmallstoneRequestDTO.getShape().isEmpty()) {
				invlibrarysmallstone.setShape(invLibrarysmallstoneRequestDTO.getShape());
			}
			if (invLibrarysmallstoneRequestDTO.getStoneId() != null && !invLibrarysmallstoneRequestDTO.getStoneId().isEmpty()) {
				invlibrarysmallstone.setStoneId(invLibrarysmallstoneRequestDTO.getStoneId());
			}
			if (invLibrarysmallstoneRequestDTO.getTotal() != null && invLibrarysmallstoneRequestDTO.getTotal()>0) {
				invlibrarysmallstone.setTotal(invLibrarysmallstoneRequestDTO.getTotal());
			}
			if (invLibrarysmallstoneRequestDTO.getWeight() != null && invLibrarysmallstoneRequestDTO.getWeight()>0) {
				invlibrarysmallstone.setWeight(invLibrarysmallstoneRequestDTO.getWeight());
			}
			if (invLibrarysmallstoneRequestDTO.getStyleSize() != null && invLibrarysmallstoneRequestDTO.getStyleSize()>0) {
				invlibrarysmallstone.setStyleSize(invLibrarysmallstoneRequestDTO.getStyleSize());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invlibrarysmallstone;

	}

}