package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import com.bourntec.apmg.entity.LockingType;

public class LockingTypeRequestDTO {

	private String description;
	private String category;
	private String image;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LockingType toModel(LockingTypeRequestDTO lockingTypesRequestDTO) {
		LockingType lockingType = new LockingType();
		lockingType.setCategory(lockingTypesRequestDTO.getCategory());
		lockingType.setDescription(lockingTypesRequestDTO.getDescription());
		lockingType.setImage(lockingTypesRequestDTO.getImage());
		lockingType.setId(lockingTypesRequestDTO.getId());
		return lockingType;
	}

}
