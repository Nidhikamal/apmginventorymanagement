package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InventoryStoneVariant;

import lombok.Getter;
import lombok.Setter;
/**
 * Request DTO for InventoryStoneVariant
 * @author AMAL
 *
 */
@Getter
@Setter
@Validated
public class InventoryStoneVariantRequestDTO {

	private Long id;
	@NotBlank(message="Please enter Item Code")
	@Size(min = 1, max = 15, message = "Item Code must be between 1 and 15 characters")
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
	

	public InventoryStoneVariant toModel(InventoryStoneVariantRequestDTO invLibrarysmallstoneRequestDTO) {

		InventoryStoneVariant invstonevariant = new InventoryStoneVariant();

		try {
			if (invLibrarysmallstoneRequestDTO.getId() != null) {
				invstonevariant.setId(invLibrarysmallstoneRequestDTO.getId());
			}
			if (invLibrarysmallstoneRequestDTO.getItemCode() != null && !invLibrarysmallstoneRequestDTO.getItemCode().isEmpty()) {
				invstonevariant.setItemCode(invLibrarysmallstoneRequestDTO.getItemCode());
			}
			if (invLibrarysmallstoneRequestDTO.getStoneId() != null && !invLibrarysmallstoneRequestDTO.getStoneId().isEmpty()) {
				invstonevariant.setStoneId(invLibrarysmallstoneRequestDTO.getStoneId());
			}
			if (invLibrarysmallstoneRequestDTO.getWeight() != null && invLibrarysmallstoneRequestDTO.getWeight()>0) {
				invstonevariant.setWeight(invLibrarysmallstoneRequestDTO.getWeight());
			}
			if (invLibrarysmallstoneRequestDTO.getPieces() != null && invLibrarysmallstoneRequestDTO.getPieces()>0) {
				invstonevariant.setPieces(invLibrarysmallstoneRequestDTO.getPieces());
			}
			if (invLibrarysmallstoneRequestDTO.getTotalPieces() != null && invLibrarysmallstoneRequestDTO.getTotalPieces()>0) {
				invstonevariant.setTotalPieces(invLibrarysmallstoneRequestDTO.getTotalPieces());
			}
			if (invLibrarysmallstoneRequestDTO.getPrice() != null && invLibrarysmallstoneRequestDTO.getPrice()>0) {
				invstonevariant.setPrice(invLibrarysmallstoneRequestDTO.getPrice());
			}
			if (invLibrarysmallstoneRequestDTO.getSize() != null && invLibrarysmallstoneRequestDTO.getSize()>0) {
				invstonevariant.setSize(invLibrarysmallstoneRequestDTO.getSize());
			}
			if (invLibrarysmallstoneRequestDTO.getPlateSize() != null && invLibrarysmallstoneRequestDTO.getPlateSize()>0) {
				invstonevariant.setPlateSize(invLibrarysmallstoneRequestDTO.getPlateSize());
			}
			if (invLibrarysmallstoneRequestDTO.getPointers() != null && invLibrarysmallstoneRequestDTO.getPointers()>0) {
				invstonevariant.setPointers(invLibrarysmallstoneRequestDTO.getPointers());
			}
			if (invLibrarysmallstoneRequestDTO.getTotalWeight() != null && invLibrarysmallstoneRequestDTO.getTotalWeight()>0) {
				invstonevariant.setTotalWeight(invLibrarysmallstoneRequestDTO.getTotalWeight());
			}
			if (invLibrarysmallstoneRequestDTO.getStyleSize() != null && invLibrarysmallstoneRequestDTO.getStyleSize()>0) {
				invstonevariant.setStyleSize(invLibrarysmallstoneRequestDTO.getStyleSize());
			}
			if (invLibrarysmallstoneRequestDTO.getPieces1() != null && invLibrarysmallstoneRequestDTO.getPieces1()>0) {
				invstonevariant.setPieces1(invLibrarysmallstoneRequestDTO.getPieces1());
			}
			if (invLibrarysmallstoneRequestDTO.getPieces2() != null && invLibrarysmallstoneRequestDTO.getPieces2()>0) {
				invstonevariant.setPieces2(invLibrarysmallstoneRequestDTO.getPieces2());
			}
			if (invLibrarysmallstoneRequestDTO.getPieces1() != null && invLibrarysmallstoneRequestDTO.getPieces3()>0) {
				invstonevariant.setPieces3(invLibrarysmallstoneRequestDTO.getPieces3());
			}
			if (invLibrarysmallstoneRequestDTO.getPieces4() != null && invLibrarysmallstoneRequestDTO.getPieces4()>0) {
				invstonevariant.setPieces4(invLibrarysmallstoneRequestDTO.getPieces4());
			}
			if (invLibrarysmallstoneRequestDTO.getPieces5() != null && invLibrarysmallstoneRequestDTO.getPieces5()>0) {
				invstonevariant.setPieces5(invLibrarysmallstoneRequestDTO.getPieces5());
			}
			if (invLibrarysmallstoneRequestDTO.getWeight1() != null && invLibrarysmallstoneRequestDTO.getWeight1()>0) {
				invstonevariant.setWeight1(invLibrarysmallstoneRequestDTO.getWeight1());
			}
			if (invLibrarysmallstoneRequestDTO.getWeight2() != null && invLibrarysmallstoneRequestDTO.getWeight2()>0) {
				invstonevariant.setWeight2(invLibrarysmallstoneRequestDTO.getWeight2());
			}
			if (invLibrarysmallstoneRequestDTO.getWeight3() != null && invLibrarysmallstoneRequestDTO.getWeight3()>0) {
				invstonevariant.setWeight3(invLibrarysmallstoneRequestDTO.getWeight3());
			}
			if (invLibrarysmallstoneRequestDTO.getWeight4() != null && invLibrarysmallstoneRequestDTO.getWeight4()>0) {
				invstonevariant.setWeight4(invLibrarysmallstoneRequestDTO.getWeight4());
			}
			if (invLibrarysmallstoneRequestDTO.getWeight5() != null && invLibrarysmallstoneRequestDTO.getWeight5()>0) {
				invstonevariant.setWeight5(invLibrarysmallstoneRequestDTO.getWeight5());
			}
			if (invLibrarysmallstoneRequestDTO.getMmSize() != null && invLibrarysmallstoneRequestDTO.getMmSize()>0) {
				invstonevariant.setMmSize(invLibrarysmallstoneRequestDTO.getMmSize());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invstonevariant;

	}

}