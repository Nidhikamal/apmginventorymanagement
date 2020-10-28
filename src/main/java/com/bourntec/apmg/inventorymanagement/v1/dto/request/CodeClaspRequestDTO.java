package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import com.bourntec.apmg.entity.CodeClasp;

public class CodeClaspRequestDTO {

	private String claspId;
	private String claspName;
	private String thumbImage;
	private String zoomImage;

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

	public CodeClasp toModel(CodeClaspRequestDTO codeClaspRequestDTO) {
		CodeClasp c = new CodeClasp();
		c.setClaspId(codeClaspRequestDTO.getClaspId());
		c.setClaspName(codeClaspRequestDTO.getClaspName());
		c.setThumbImage(codeClaspRequestDTO.getThumbImage());
		c.setZoomImage(codeClaspRequestDTO.getZoomImage());
		return c;
	}
}
