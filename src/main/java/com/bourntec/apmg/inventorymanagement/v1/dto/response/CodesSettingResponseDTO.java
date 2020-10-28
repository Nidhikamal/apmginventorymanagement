package com.bourntec.apmg.inventorymanagement.v1.dto.response;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesSettingRequestDTO;

public class CodesSettingResponseDTO extends CodesSettingRequestDTO{
	private String settingId;
    private String settingName;
    private String zoomImage;
    private String thumbImage;
    private String responseMessage;
	public String getSettingId() {
		return settingId;
	}
	public void setSettingId(String settingId) {
		this.settingId = settingId;
	}
	public String getSettingName() {
		return settingName;
	}
	public void setSettingName(String settingName) {
		this.settingName = settingName;
	}
	public String getZoomImage() {
		return zoomImage;
	}
	public void setZoomImage(String zoomImage) {
		this.zoomImage = zoomImage;
	}
	public String getThumbImage() {
		return thumbImage;
	}
	public void setThumbImage(String thumbImage) {
		this.thumbImage = thumbImage;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
}
