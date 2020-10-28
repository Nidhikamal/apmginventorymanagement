package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InvWeight;
import com.bourntec.apmg.entity.InventoryLibrary;
import com.fasterxml.jackson.annotation.JsonFormat;

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

public class InventoryLibraryRequestDTO {	
	private Long id;
	@NotBlank(message="Please enter style")
	@Size(min = 1, max = 15, message = "Style must be between 1 and 15 characters")
	private String style;
	@NotBlank(message="Please enter jobNo")
	@Size(min = 1, max = 15, message = "itemCode must be between 1 and 15 characters")
	private String itemCode;

	private String jobNo;

	private String smallImage;

	private String largeImage;

	private Double total;

	private Double markUp;

	private Double size;

	private String webyn;

	private String subCategory;

	private String location;

	private String videoFile;

	private String specification;

	private Double retialPrice;

	private String variantSize;

	private Double variantCost;

	private Double materialCost;

	private Double stoneCost;

	private Double retailMarkUp;

	private Double laborCost;

	private String labor;

	private String description;
	
	private Double leadTime;

	private String displayOnApollo;	

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;

	private String retailImage;
	
	
	
	


	public InventoryLibrary toModel(InventoryLibraryRequestDTO inventoryLibraryRequestDTO ) {

		InventoryLibrary inventoryLibrary = new InventoryLibrary();

		try {
			if (inventoryLibraryRequestDTO.getId() != null) {
				inventoryLibrary.setId(inventoryLibraryRequestDTO.getId());
			}
			if (inventoryLibraryRequestDTO.getStyle() != null) {
				inventoryLibrary.setStyle(inventoryLibraryRequestDTO.getStyle());
			}
			if (inventoryLibraryRequestDTO.getItemCode() != null && !inventoryLibraryRequestDTO.getItemCode().isEmpty()) {
				inventoryLibrary.setItemCode(inventoryLibraryRequestDTO.getItemCode());
			}
			if (inventoryLibraryRequestDTO.getJobNo() != null && !inventoryLibraryRequestDTO.getJobNo().isEmpty()) {
				inventoryLibrary.setJobNo(inventoryLibraryRequestDTO.getJobNo());
			}
			if (inventoryLibraryRequestDTO.getSmallImage() != null && !inventoryLibraryRequestDTO.getSmallImage().isEmpty()) {
				inventoryLibrary.setSmallImage(inventoryLibraryRequestDTO.getSmallImage());
			}	
			if (inventoryLibraryRequestDTO.getLargeImage() != null && !inventoryLibraryRequestDTO.getLargeImage().isEmpty()) {
				inventoryLibrary.setLargeImage(inventoryLibraryRequestDTO.getLargeImage());
			}	
			if (inventoryLibraryRequestDTO.getTotal() != null ) {
				inventoryLibrary.setTotal(inventoryLibraryRequestDTO.getTotal());
			}	
			
			if (inventoryLibraryRequestDTO.getMarkUp() != null) {
				inventoryLibrary.setMarkUp(inventoryLibraryRequestDTO.getMarkUp());
			}
			if (inventoryLibraryRequestDTO.getSize() != null) {
				inventoryLibrary.setSize(inventoryLibraryRequestDTO.getSize());
			}
			if (inventoryLibraryRequestDTO.getWebyn() != null&&!inventoryLibraryRequestDTO.getWebyn().isEmpty()) {
				inventoryLibrary.setWebyn(inventoryLibraryRequestDTO.getWebyn());
			}
			if (inventoryLibraryRequestDTO.getSubCategory() != null&&inventoryLibraryRequestDTO.getSubCategory().isEmpty()) {
				inventoryLibrary.setSubCategory(inventoryLibraryRequestDTO.getSubCategory());
			}
			if (inventoryLibraryRequestDTO.getLocation() != null && !inventoryLibraryRequestDTO.getLocation().isEmpty()) {
				inventoryLibrary.setLocation(inventoryLibraryRequestDTO.getLocation());
			}	
			if (inventoryLibraryRequestDTO.getVideoFile() != null && !inventoryLibraryRequestDTO.getVideoFile().isEmpty()) {
				inventoryLibrary.setVideoFile(inventoryLibraryRequestDTO.getVideoFile());
			}
			if (inventoryLibraryRequestDTO.getSpecification() != null && !inventoryLibraryRequestDTO.getSpecification().isEmpty()) {
				inventoryLibrary.setSpecification(inventoryLibraryRequestDTO.getSpecification());
			}	
			
			if (inventoryLibraryRequestDTO.getRetialPrice() != null) {
				inventoryLibrary.setRetialPrice(inventoryLibraryRequestDTO.getRetialPrice());
			}	
			
			if (inventoryLibraryRequestDTO.getVariantSize() != null && !inventoryLibraryRequestDTO.getVariantSize().isEmpty()) {
				inventoryLibrary.setVariantSize(inventoryLibraryRequestDTO.getVariantSize());
			}
			if (inventoryLibraryRequestDTO.getVariantCost() != null ) {
				inventoryLibrary.setVariantCost(inventoryLibraryRequestDTO.getVariantCost());
			}
			
			if (inventoryLibraryRequestDTO.getMaterialCost() != null ) {
				inventoryLibrary.setMaterialCost(inventoryLibraryRequestDTO.getMaterialCost());
			}
			
			if (inventoryLibraryRequestDTO.getRetailMarkUp() != null ) {
				inventoryLibrary.setRetailMarkUp(inventoryLibraryRequestDTO.getRetailMarkUp());
			}

			if (inventoryLibraryRequestDTO.getLaborCost() != null ) {
				inventoryLibrary.setLaborCost(inventoryLibraryRequestDTO.getLaborCost());
			}
			
			if (inventoryLibraryRequestDTO.getLabor() != null && !inventoryLibraryRequestDTO.getLabor().isEmpty()) {
				inventoryLibrary.setLabor(inventoryLibraryRequestDTO.getLabor());
			}	
			if (inventoryLibraryRequestDTO.getDescription() != null && !inventoryLibraryRequestDTO.getDescription().isEmpty()) {
				inventoryLibrary.setDescription(inventoryLibraryRequestDTO.getDescription());
			}	
			if (inventoryLibraryRequestDTO.getLeadTime() != null ) {
				inventoryLibrary.setLeadTime(inventoryLibraryRequestDTO.getLeadTime());
			}	
			if (inventoryLibraryRequestDTO.getDisplayOnApollo() != null && !inventoryLibraryRequestDTO.getDisplayOnApollo().isEmpty()) {
				inventoryLibrary.setDisplayOnApollo(inventoryLibraryRequestDTO.getDisplayOnApollo());
			}	
			
			if (inventoryLibraryRequestDTO.getCreatedDate() != null) {
				inventoryLibrary.setCreatedDate(inventoryLibraryRequestDTO.getCreatedDate());
			}	
			
			if (inventoryLibraryRequestDTO.getStoneCost() != null) {
				inventoryLibrary.setStoneCost(inventoryLibraryRequestDTO.getStoneCost());
			}	
						
			if (inventoryLibraryRequestDTO.getRetailImage() != null && !inventoryLibraryRequestDTO.getRetailImage().isEmpty()) {
				inventoryLibrary.setRetailImage(inventoryLibraryRequestDTO.getRetailImage());
			}	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventoryLibrary;

	}

}
