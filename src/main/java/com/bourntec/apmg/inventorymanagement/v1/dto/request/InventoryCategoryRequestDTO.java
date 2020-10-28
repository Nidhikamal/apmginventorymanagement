package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InventoryCategory;
import com.bourntec.apmg.entity.TypeData;

/**
 * 
 * Class is used as a data transfer object for materail codes 
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
public class InventoryCategoryRequestDTO {

	
	private String category;
	private String desc1;
	private String locationCode;
	private String smallImage;
	private String largeImage;
	private String htsus;
	private String unitMeasure;
	private String packing;
	private List<TypeData> typeDataList;

	
	public List<TypeData> getTypeDataList() {
		return typeDataList;
	}

	public void setTypeDataList(List<TypeData> typeDataList) {
		this.typeDataList = typeDataList;
	}

	
	
	public InventoryCategory toModel(InventoryCategoryRequestDTO invCategoryRequestDTO) {
		InventoryCategory invCat = new InventoryCategory();
		
		try {
			invCat.setCategory(invCategoryRequestDTO.getCategory());
			invCat.setDesc1(invCategoryRequestDTO.getDesc1());
			invCat.setHtsus(invCategoryRequestDTO.getHtsus());
			invCat.setLargeImage(invCategoryRequestDTO.getLargeImage());
			invCat.setLocationCode(invCategoryRequestDTO.getLocationCode());
			invCat.setPacking(invCategoryRequestDTO.getPacking());
			invCat.setSmallImage(invCategoryRequestDTO.getSmallImage());
			invCat.setUnitMeasure(invCategoryRequestDTO.getUnitMeasure());
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return invCat;

	}


	public String getCategory() {
		return category;
	}


	public String getDesc1() {
		return desc1;
	}


	public String getLocationCode() {
		return locationCode;
	}


	public String getSmallImage() {
		return smallImage;
	}


	public String getLargeImage() {
		return largeImage;
	}


	public String getHtsus() {
		return htsus;
	}


	

	public String getPacking() {
		return packing;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}


	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}


	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}


	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}


	public void setHtsus(String htsus) {
		this.htsus = htsus;
	}


	


	public void setPacking(String packing) {
		this.packing = packing;
	}


	public String getUnitMeasure() {
		return unitMeasure;
	}


	public void setUnitMeasure(String unitMeasure) {
		this.unitMeasure = unitMeasure;
	}


	

	
}
