package com.bourntec.apmg.inventorymanagement.v1.dto.request;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.Inventory1;
import com.bourntec.apmg.entity.InventoryCategory;
import com.bourntec.apmg.entity.InventoryMaterialsUsed;
import com.bourntec.apmg.entity.VendorItemMatch;

/**
 * 
 * Class is used as a Vendor item Match object for inventory  
 * 
 * @author Babu V
 *
 */
@Validated
public class VendorItemMatchRequestDTO {

	private String vendorCode;
	private String itemCode;
	private String vendorNo;
	private String locatioCoode;
	private String desc1;
	private Double minOrderQty;
	private Double ecoOrderQty;
	private Double avgLeadDays;
	
	
	
	public VendorItemMatch toModel(VendorItemMatchRequestDTO vendorItemMatchRequestDTO) {
		VendorItemMatch vendorItemMatch = new VendorItemMatch();
		
		try {
			vendorItemMatch.setVendorCode(vendorItemMatchRequestDTO.getVendorCode());
			vendorItemMatch.setItemCode(vendorItemMatchRequestDTO.getItemCode());
			vendorItemMatch.setVendorNo(vendorItemMatchRequestDTO.getVendorNo());
			vendorItemMatch.setLocatioCoode(vendorItemMatchRequestDTO.getLocatioCoode());
			vendorItemMatch.setDesc1(vendorItemMatchRequestDTO.getDesc1());
			vendorItemMatch.setMinOrderQty(vendorItemMatchRequestDTO.getMinOrderQty());
			vendorItemMatch.setEcoOrderQty(vendorItemMatchRequestDTO.getEcoOrderQty());
			vendorItemMatch.setAvgLeadDays(vendorItemMatchRequestDTO.getAvgLeadDays());
			
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return vendorItemMatch;

	}



	public String getVendorCode() {
		return vendorCode;
	}



	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}



	public String getItemCode() {
		return itemCode;
	}



	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}



	public String getVendorNo() {
		return vendorNo;
	}



	public void setVendorNo(String vendorNo) {
		this.vendorNo = vendorNo;
	}



	public String getLocatioCoode() {
		return locatioCoode;
	}



	public void setLocatioCoode(String locatioCoode) {
		this.locatioCoode = locatioCoode;
	}



	public String getDesc1() {
		return desc1;
	}



	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}



	public Double getMinOrderQty() {
		return minOrderQty;
	}



	public void setMinOrderQty(Double minOrderQty) {
		this.minOrderQty = minOrderQty;
	}



	public Double getEcoOrderQty() {
		return ecoOrderQty;
	}



	public void setEcoOrderQty(Double ecoOrderQty) {
		this.ecoOrderQty = ecoOrderQty;
	}



	public Double getAvgLeadDays() {
		return avgLeadDays;
	}



	public void setAvgLeadDays(Double avgLeadDays) {
		this.avgLeadDays = avgLeadDays;
	}
	
}
