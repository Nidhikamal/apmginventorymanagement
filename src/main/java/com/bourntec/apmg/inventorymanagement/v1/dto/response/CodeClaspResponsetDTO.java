package com.bourntec.apmg.inventorymanagement.v1.dto.response;

public class CodeClaspResponsetDTO {

	private String claspId;
    private String claspName;
    private String thumbImage;
    private String zoomImage;
    private String responseMessage;
    
	public String getClaspId() {
		return claspId;
	}
	public void setClaspId(String claspId) {
		this.claspId = claspId;
	}
	public String getClaspName() {
		return claspName;
	}
	public void setClaspName(String claspName) {
		this.claspName = claspName;
	}
	public String getThumbImage() {
		return thumbImage;
	}
	public void setThumbImage(String thumbImage) {
		this.thumbImage = thumbImage;
	}
	public String getZoomImage() {
		return zoomImage;
	}
	public void setZoomImage(String zoomImage) {
		this.zoomImage = zoomImage;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
}
