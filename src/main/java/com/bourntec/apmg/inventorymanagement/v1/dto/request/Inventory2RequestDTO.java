package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.Inventory2;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * Class is used as a data transfer object for inventory2  
 * 
 * @author Nince
 *
 */

@Getter
@Setter
@Validated
public class Inventory2RequestDTO {

	
	private String itemCode;
	private String description2;
	private String specification;
	private String specification2;
	private String location;
	private Double purchaseW;
	private Integer purchaseP;
	private Double soldW;
	private Integer soldP;
	private Double returnW;
	private Integer returnP;
	private Double karat;
	private String tableKarat;
	private String vendor1;
	private String vendor2;
	private String VCode1;
	private String VCode2;
	private String dept;
	private Integer inOrderP;
	private Double inOrderW;
	private String locationCode;
	private String email;
	private String tagColor;
	private String inscribe;
	private String billEntry;
	private String countryCode;
	private Integer memoP;
	private Double memoW;
	private Integer memoReturnP;
	private Double memoReturnW;
	private String stoneOrgin;
	private String styleName;
	
	public Inventory2 toModel(Inventory2RequestDTO inventory2RequestDTO) {
		Inventory2 inventory2 = new Inventory2();
		
		try {
			if(inventory2RequestDTO.getItemCode() != null && !inventory2RequestDTO.getItemCode().isEmpty()) {
				inventory2.setItemCode(inventory2RequestDTO.getItemCode().trim());
			}
			if(inventory2RequestDTO.getDescription2() != null && !inventory2RequestDTO.getDescription2().isEmpty()) {
				inventory2.setDescription2(inventory2RequestDTO.getDescription2().trim());
			}
			if(inventory2RequestDTO.getSpecification() != null && !inventory2RequestDTO.getSpecification().isEmpty()) {
				inventory2.setSpecification(inventory2RequestDTO.getSpecification().trim());
			}
			if(inventory2RequestDTO.getSpecification2() != null && !inventory2RequestDTO.getSpecification2().isEmpty()) {
				inventory2.setSpecification2(inventory2RequestDTO.getSpecification2().trim());
			}
			if(inventory2RequestDTO.getLocation() != null && !inventory2RequestDTO.getLocation().isEmpty()) {
				inventory2.setLocation(inventory2RequestDTO.getLocation().trim());
			}
			if(inventory2RequestDTO.getPurchaseW() != null) {
				inventory2.setPurchaseW(inventory2RequestDTO.getPurchaseW());
			}
			if(inventory2RequestDTO.getPurchaseP() != null) {
				inventory2.setPurchaseP(inventory2RequestDTO.getPurchaseP());
			}
			if(inventory2RequestDTO.getSoldW() != null) {
				inventory2.setSoldW(inventory2RequestDTO.getSoldW());
			}
			if(inventory2RequestDTO.getSoldP() != null) {
				inventory2.setSoldP(inventory2RequestDTO.getSoldP());
			}
			if(inventory2RequestDTO.getReturnW() != null) {
				inventory2.setReturnW(inventory2RequestDTO.getReturnW());
			}
			if(inventory2RequestDTO.getReturnP() != null) {
				inventory2.setReturnP(inventory2RequestDTO.getReturnP());
			}
			if(inventory2RequestDTO.getKarat() != null ) {
				inventory2.setKarat(inventory2RequestDTO.getKarat());
			}
			if(inventory2RequestDTO.getTableKarat() != null && !inventory2RequestDTO.getTableKarat().isEmpty()) {
				inventory2.setTableKarat(inventory2RequestDTO.getTableKarat().trim());
			}
			if(inventory2RequestDTO.getVendor1() != null && !inventory2RequestDTO.getVendor1().isEmpty()) {
				inventory2.setVendor1(inventory2RequestDTO.getVendor1().trim());
			}
			if(inventory2RequestDTO.getVendor2() != null && !inventory2RequestDTO.getVendor2().isEmpty()) {
				inventory2.setVendor2(inventory2RequestDTO.getVendor2().trim());
			}
			if(inventory2RequestDTO.getVCode1() != null && !inventory2RequestDTO.getVCode1().isEmpty()) {
				inventory2.setVCode1(inventory2RequestDTO.getVCode1().trim());
			}
			if(inventory2RequestDTO.getVCode2() != null && !inventory2RequestDTO.getVCode2().isEmpty()) {
				inventory2.setVCode2(inventory2RequestDTO.getVCode2().trim());
			}
			if(inventory2RequestDTO.getDept() != null && !inventory2RequestDTO.getDept().isEmpty()) {
				inventory2.setDept(inventory2RequestDTO.getDept().trim());
			}
			if(inventory2RequestDTO.getInOrderP() != null) {
				inventory2.setInOrderP(inventory2RequestDTO.getInOrderP());
			}
			if(inventory2RequestDTO.getInOrderW() != null) {
				inventory2.setInOrderW(inventory2RequestDTO.getInOrderW());
			}
			if(inventory2RequestDTO.getLocationCode() != null && !inventory2RequestDTO.getLocationCode().isEmpty()) {
				inventory2.setLocationCode(inventory2RequestDTO.getLocationCode().trim());
			}
			if(inventory2RequestDTO.getEmail() != null && !inventory2RequestDTO.getEmail().isEmpty()) {
				inventory2.setEmail(inventory2RequestDTO.getEmail().trim());
			}
			if(inventory2RequestDTO.getTagColor() != null && !inventory2RequestDTO.getTagColor().isEmpty()) {
				inventory2.setTagColor(inventory2RequestDTO.getTagColor().trim());
			}
			if(inventory2RequestDTO.getInscribe() != null && !inventory2RequestDTO.getInscribe().isEmpty()) {
				inventory2.setInscribe(inventory2RequestDTO.getInscribe().trim());
			}
			if(inventory2RequestDTO.getBillEntry() != null && !inventory2RequestDTO.getBillEntry().isEmpty()) {
				inventory2.setBillEntry(inventory2RequestDTO.getBillEntry().trim());
			}
			if(inventory2RequestDTO.getCountryCode() != null && !inventory2RequestDTO.getCountryCode().isEmpty()) {
				inventory2.setCountryCode(inventory2RequestDTO.getCountryCode().trim());
			}
			if(inventory2RequestDTO.getMemoP() != null) {
				inventory2.setMemoP(inventory2RequestDTO.getMemoP());
			}
			if(inventory2RequestDTO.getMemoW() != null) {
				inventory2.setMemoW(inventory2RequestDTO.getMemoW());
			}
			if(inventory2RequestDTO.getMemoReturnP() != null) {
				inventory2.setMemoReturnP(inventory2RequestDTO.getMemoReturnP());
			}
			if(inventory2RequestDTO.getMemoReturnW() != null) {
				inventory2.setMemoReturnW(inventory2RequestDTO.getMemoReturnW());
			}
			if(inventory2RequestDTO.getStoneOrgin() != null && !inventory2RequestDTO.getStoneOrgin().isEmpty()) {
				inventory2.setStoneOrgin(inventory2RequestDTO.getStoneOrgin().trim());
			}
			if(inventory2RequestDTO.getStyleName() != null && !inventory2RequestDTO.getStyleName().isEmpty()) {
				inventory2.setStyleName(inventory2RequestDTO.getStyleName().trim());
			}	
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return inventory2;

	}
}
