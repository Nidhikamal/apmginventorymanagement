package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InventoryRank;

/**
 * 
 * Class is used as a data transfer object for materail codes 
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
public class InventoryRankRequestDTO {

	
    private String rank;
	private String desc1; 
	private String locationCode;
	
	
	public InventoryRank toModel(InventoryRankRequestDTO invRankRequestDTO) {
		InventoryRank invrank = new InventoryRank();
		
		try {
			invrank.setRank(invRankRequestDTO.getRank());
			invrank.setLocationCode(invRankRequestDTO.getLocationCode());
			invrank.setDesc1(invRankRequestDTO.getDesc1());
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return invrank;

	}


	public String getRank() {
		return rank;
	}


	public String getDesc1() {
		return desc1;
	}


	public String getLocationCode() {
		return locationCode;
	}


	public void setRank(String rank) {
		this.rank = rank;
	}


	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}


	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}


	

	
}
