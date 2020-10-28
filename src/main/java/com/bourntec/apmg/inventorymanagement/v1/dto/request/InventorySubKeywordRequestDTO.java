package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InventorySubKeyword;

import lombok.Getter;
import lombok.Setter;
/**
 * Request DTO for InventorySubKeyWord
 * @author Nince
 *
 */
@Getter
@Setter
@Validated
public class InventorySubKeywordRequestDTO {
	private Long id;
	@NotBlank(message="Please enter key id")
	@Size(min = 1, max = 3, message = "Key Id must be between 1 and 3 characters")
	private String keyId;
	@Size(min = 1, max = 3, message = "Sub Key Id must be between 1 and 3 characters")
	private String subKeyId;
	@Size(min = 5, max = 15, message = "Item Code must be between 3 and 15 characters")
	private String itemCode;

	public InventorySubKeyword toModel(InventorySubKeywordRequestDTO inventorySubKeyWordRequestDTO) {

	InventorySubKeyword inventorySubKeyWord = new InventorySubKeyword();

		try {
			if (inventorySubKeyWordRequestDTO.getId() != null) {
				inventorySubKeyWord.setId(inventorySubKeyWordRequestDTO.getId());
			}
			if (inventorySubKeyWordRequestDTO.getKeyId() != null && !inventorySubKeyWordRequestDTO.getKeyId().isEmpty()) {
				inventorySubKeyWord.setKeyId(inventorySubKeyWordRequestDTO.getKeyId());
			}
			if (inventorySubKeyWordRequestDTO.getSubKeyId() != null && !inventorySubKeyWordRequestDTO.getSubKeyId().isEmpty()) {
				inventorySubKeyWord.setSubKeyId(inventorySubKeyWordRequestDTO.getSubKeyId());
			}
			if (inventorySubKeyWordRequestDTO.getItemCode() != null && !inventorySubKeyWordRequestDTO.getItemCode().isEmpty()) {
				inventorySubKeyWord.setItemCode(inventorySubKeyWordRequestDTO.getItemCode());
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventorySubKeyWord;
	}

}