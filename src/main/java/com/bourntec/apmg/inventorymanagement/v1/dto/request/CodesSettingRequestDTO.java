package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import com.bourntec.apmg.entity.CodesSetting;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodesSettingRequestDTO {
	private String settingId;
	private String settingName;
	private String zoomImage;
	private String thumbImage;
	
	public CodesSetting toModel(CodesSettingRequestDTO codeSettingRequestDTO) {

		CodesSetting cs = new CodesSetting();
		if(codeSettingRequestDTO.getSettingId() != null && !codeSettingRequestDTO.getSettingId().isEmpty()) {
			cs.setSettingId(codeSettingRequestDTO.getSettingId());
		}
		if(codeSettingRequestDTO.getSettingName() != null && !codeSettingRequestDTO.getSettingName().isEmpty()) {
			cs.setSettingName(codeSettingRequestDTO.getSettingName());
		}
		if(codeSettingRequestDTO.getThumbImage() != null && !codeSettingRequestDTO.getThumbImage().isEmpty()) {
			cs.setThumbImage(codeSettingRequestDTO.getThumbImage());
		}
		if(codeSettingRequestDTO.getZoomImage() != null && !codeSettingRequestDTO.getZoomImage().isEmpty()) {
			cs.setZoomImage(codeSettingRequestDTO.getZoomImage());
		}
		
		return cs;
	}

}
