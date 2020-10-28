package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.MarketCode;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Class is used as a data transfer object for market code  
 * 
 * @author Nince
 *
 */

@Getter
@Setter
@Validated
public class MarketCodeRequestDTO {

	
	private String marketCode;
	private String marketName;
	private String desc1;
	private String locationCode;
	
	public MarketCode toModel(MarketCodeRequestDTO marketCodeRequestDTO) {
		MarketCode marketCode = new MarketCode();
		
		try {
			if(marketCodeRequestDTO.getMarketCode() != null && !marketCodeRequestDTO.getMarketCode().isEmpty()) {
				marketCode.setMarketCode(marketCodeRequestDTO.getMarketCode());
			}
			if(marketCodeRequestDTO.getMarketName() != null && !marketCodeRequestDTO.getMarketName().isEmpty()) {
				marketCode.setMarketName(marketCodeRequestDTO.getMarketName());
			}
			if(marketCodeRequestDTO.getDesc1() != null && !marketCodeRequestDTO.getDesc1().isEmpty()) {
				marketCode.setDesc1(marketCodeRequestDTO.getDesc1());
			}
			if(marketCodeRequestDTO.getLocationCode() != null && !marketCodeRequestDTO.getLocationCode().isEmpty()) {
				marketCode.setLocationCode(marketCodeRequestDTO.getLocationCode());
			}
		} catch (Exception e) {
            e.printStackTrace();
		}
		return marketCode;

	}
	
}
