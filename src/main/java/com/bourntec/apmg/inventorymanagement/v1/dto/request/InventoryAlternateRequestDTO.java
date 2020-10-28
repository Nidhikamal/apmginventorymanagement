package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InventoryAlternate;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Class is used as a InventoryAlternateRequestDTO  object for inventory  
 * 
 * @author Babu V
 *
 */
@Validated
@Getter
@Setter
public class InventoryAlternateRequestDTO {

	private Long id;
	private String itemCode;
	private String itemCodeAlt;
	private String desc1;
	private String priorityCode;
	private String locationCode;
	
	
	
	
	public InventoryAlternate toModel(InventoryAlternateRequestDTO vendorItemMatchRequestDTO) {
		InventoryAlternate inventoryAlternate = new InventoryAlternate();
		
		try {
			inventoryAlternate.setItemCode(vendorItemMatchRequestDTO.getItemCode());
			inventoryAlternate.setItemCodeAlt(vendorItemMatchRequestDTO.getItemCodeAlt());
			inventoryAlternate.setDesc1(vendorItemMatchRequestDTO.getDesc1());
			inventoryAlternate.setPriorityCode(vendorItemMatchRequestDTO.getPriorityCode());
			inventoryAlternate.setLocationCode(vendorItemMatchRequestDTO.getLocationCode());
			inventoryAlternate.setId(vendorItemMatchRequestDTO.getId());
			
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return inventoryAlternate;

	}




	public String getItemCode() {
		return itemCode;
	}




	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}




	public String getItemCodeAlt() {
		return itemCodeAlt;
	}




	public void setItemCodeAlt(String itemCodeAlt) {
		this.itemCodeAlt = itemCodeAlt;
	}




	public String getDesc1() {
		return desc1;
	}




	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}




	public String getPriorityCode() {
		return priorityCode;
	}




	public void setPriorityCode(String priorityCode) {
		this.priorityCode = priorityCode;
	}




	public String getLocationCode() {
		return locationCode;
	}




	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

}
