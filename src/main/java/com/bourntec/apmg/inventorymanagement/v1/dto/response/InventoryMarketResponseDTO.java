package com.bourntec.apmg.inventorymanagement.v1.dto.response;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
/**
 * Response dto for InventoryMarket
 * @author Nince
 *
 */
@Getter
@Setter
@Validated
public class InventoryMarketResponseDTO {

	private String responseMessage;
}
