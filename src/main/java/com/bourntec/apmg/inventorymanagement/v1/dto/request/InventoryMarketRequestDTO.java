package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InventoryMarket;

import lombok.Getter;
import lombok.Setter;
/**
 * Request DTO for InventoryKeyWord
 * @author Nince
 *
 */
@Getter
@Setter
@Validated
public class InventoryMarketRequestDTO {
	private Long id;
	@NotBlank(message="Please enter market code")
	@Size(min = 1, max = 3, message = "Market code must be between 1 and 3 characters")
	private String marketCode;
	@Size(min = 5, max = 15, message = "Item Code must be between 3 and 15 characters")
	private String itemCode;
	private String locationCode;

	public InventoryMarket toModel(InventoryMarketRequestDTO inventoryMarketRequestDTO) {

		InventoryMarket inventoryKeyWord = new InventoryMarket();

		try {
			if (inventoryMarketRequestDTO.getId() != null) {
				inventoryKeyWord.setId(inventoryMarketRequestDTO.getId());
			}
			if (inventoryMarketRequestDTO.getMarketCode() != null && !inventoryMarketRequestDTO.getMarketCode().isEmpty()) {
				inventoryKeyWord.setMarketCode(inventoryMarketRequestDTO.getMarketCode());
			}
			if (inventoryMarketRequestDTO.getItemCode() != null && !inventoryMarketRequestDTO.getItemCode().isEmpty()) {
				inventoryKeyWord.setItemCode(inventoryMarketRequestDTO.getItemCode());
			}
			if (inventoryMarketRequestDTO.getLocationCode() != null && !inventoryMarketRequestDTO.getLocationCode().isEmpty()) {
				inventoryKeyWord.setLocationCode(inventoryMarketRequestDTO.getLocationCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventoryKeyWord;
	}

}