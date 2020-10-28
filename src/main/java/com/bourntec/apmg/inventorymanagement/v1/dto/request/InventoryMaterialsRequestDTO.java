package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InventoryMaterialsUsed;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Class is used as a data transfer object for inventory materails
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
@Getter
@Setter
public class InventoryMaterialsRequestDTO {

	private Long id;
	private String itemCode;
	private Double weight;
	private String materialId;
	private Double karatValue;
	private Double price;
	private String color;
	private Double karat;

	public InventoryMaterialsUsed toModel(InventoryMaterialsRequestDTO invmaterialsRequestDTO) {
		InventoryMaterialsUsed invmat = new InventoryMaterialsUsed();

		try {

			invmat.setItemCode(invmaterialsRequestDTO.getItemCode());
			invmat.setId(invmaterialsRequestDTO.getId());
			invmat.setColor(invmaterialsRequestDTO.getColor());
			invmat.setKaratValue(invmaterialsRequestDTO.getKaratValue());
			invmat.setMaterialId(invmaterialsRequestDTO.getMaterialId());
			invmat.setPrice(invmaterialsRequestDTO.getPrice());
			invmat.setWeight(invmaterialsRequestDTO.getWeight());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invmat;

	}
}
