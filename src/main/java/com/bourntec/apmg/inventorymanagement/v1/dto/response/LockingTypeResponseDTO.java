package com.bourntec.apmg.inventorymanagement.v1.dto.response;

public class LockingTypeResponseDTO {
	private Long id;

	private String description;
	private String category;
	private String image;
	/**
	 * property that is used to set the message
	 * in service when a particular action carried out in there
	 * for eg : when a user is not fetched, showing the user is not retrieved
	 * @TODO need to remove when exception module is implementd
	 */
	private String responseMessage;

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
