/**
 * 
 */
package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import com.bourntec.apmg.entity.AdditionalOrderData;

import lombok.Getter;
import lombok.Setter;

/**
 * @author naveen
 *
 */

@Getter
@Setter
public class AdditionalOrderDataRequestDTO {
	private Long id;
	private String additionalDataValue;
	private String additionalDataName;
	private String additionalDataDesc;
	private String slNo;


	public AdditionalOrderData toModel(AdditionalOrderDataRequestDTO addtionalOrderDataRequestDTO) {
		// TODO Auto-generated method stub
		AdditionalOrderData addtionalOrderData = new AdditionalOrderData();
		addtionalOrderData.setId(addtionalOrderDataRequestDTO.getId());
		addtionalOrderData.setAdditionalDataValue(addtionalOrderDataRequestDTO.getAdditionalDataValue());
		addtionalOrderData.setAdditionalDataName(addtionalOrderDataRequestDTO.getAdditionalDataName());
		addtionalOrderData.setAdditionalDataDesc(addtionalOrderDataRequestDTO.getAdditionalDataDesc());
		addtionalOrderData.setSlNo(addtionalOrderDataRequestDTO.getSlNo());

		return addtionalOrderData;
	}

}
