package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InventoryKeyword;

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
public class InventoryKeywordRequestDTO {
	private Long id;
	@NotBlank(message="Please enter key id")
	@Size(min = 1, max = 3, message = "Key Id must be between 1 and 3 characters")
	private String keyId;
	@Size(min = 5, max = 15, message = "Item Code must be between 3 and 15 characters")
	private String itemCode;

	public InventoryKeyword toModel(InventoryKeywordRequestDTO inventoryKeyWordRequestDTO) {

	InventoryKeyword inventoryKeyWord = new InventoryKeyword();

		try {
			if (inventoryKeyWordRequestDTO.getId() != null) {
				inventoryKeyWord.setId(inventoryKeyWordRequestDTO.getId());
			}
			if (inventoryKeyWordRequestDTO.getKeyId() != null && !inventoryKeyWordRequestDTO.getKeyId().isEmpty()) {
				inventoryKeyWord.setKeyId(inventoryKeyWordRequestDTO.getKeyId());
			}
			if (inventoryKeyWordRequestDTO.getItemCode() != null && !inventoryKeyWordRequestDTO.getItemCode().isEmpty()) {
				inventoryKeyWord.setItemCode(inventoryKeyWordRequestDTO.getItemCode());
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventoryKeyWord;
	}

}