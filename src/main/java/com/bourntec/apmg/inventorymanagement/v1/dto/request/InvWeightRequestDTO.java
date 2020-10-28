package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InvWeight;
import lombok.Getter;
import lombok.Setter;

/**
 * Request DTO for InvWeightRequestDTO
 * @author Vidya
 *
 */

@Getter
@Setter
@Validated

public class InvWeightRequestDTO {

	@NotBlank(message="Please enter itemCode")
	@Size(min = 1, max = 15, message = "Job No must be between 1 and 15 characters")
	private String itemCode;
	private String waxType;
	private String injectingTime;
	private String vaccum;
	private String pressure;
	private String tumblingTime;
	private Double wtIn10k;
	private Double wtIn14k;
	private Double wtIn18k;
	private Double wtInPt;
	private String config;
	private String locking;

	public InvWeight toModel(InvWeightRequestDTO invWeightRequestDTO ) {

		InvWeight invWeight = new InvWeight();

		try {
			if (invWeightRequestDTO.getItemCode() != null) {
				invWeight.setItemCode(invWeightRequestDTO.getItemCode());
			}
			if (invWeightRequestDTO.getWaxType() != null && !invWeightRequestDTO.getWaxType().isEmpty()) {
				invWeight.setWaxType(invWeightRequestDTO.getWaxType());
			}
			if (invWeightRequestDTO.getInjectingTime() != null && !invWeightRequestDTO.getInjectingTime().isEmpty()) {
				invWeight.setInjectingTime(invWeightRequestDTO.getInjectingTime());
			}
			if (invWeightRequestDTO.getVaccum() != null && !invWeightRequestDTO.getVaccum().isEmpty()) {
				invWeight.setVaccum(invWeightRequestDTO.getVaccum());
			}	
			if (invWeightRequestDTO.getPressure() != null && !invWeightRequestDTO.getPressure().isEmpty()) {
				invWeight.setPressure(invWeightRequestDTO.getPressure());
			}	
			if (invWeightRequestDTO.getTumblingTime() != null && !invWeightRequestDTO.getTumblingTime().isEmpty()) {
				invWeight.setTumblingTime(invWeightRequestDTO.getInjectingTime());
			}	
			
			if (invWeightRequestDTO.getWtIn10k() != null) {
				invWeight.setWtIn10k(invWeightRequestDTO.getWtIn10k());
			}
			if (invWeightRequestDTO.getWtIn14k() != null) {
				invWeight.setWtIn14k(invWeightRequestDTO.getWtIn14k());
			}
			if (invWeightRequestDTO.getWtIn18k() != null) {
				invWeight.setWtIn18k(invWeightRequestDTO.getWtIn18k());
			}
			if (invWeightRequestDTO.getWtInPt() != null) {
				invWeight.setWtInPt(invWeightRequestDTO.getWtInPt());
			}
			if (invWeightRequestDTO.getConfig() != null && !invWeightRequestDTO.getConfig().isEmpty()) {
				invWeight.setConfig(invWeightRequestDTO.getConfig());
			}	
			if (invWeightRequestDTO.getLocking() != null && !invWeightRequestDTO.getLocking().isEmpty()) {
				invWeight.setLocking(invWeightRequestDTO.getLocking());
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invWeight;

	}

}
