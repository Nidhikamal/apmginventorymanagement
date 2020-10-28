package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import com.bourntec.apmg.entity.LibraryItem;

/**
 * 
 * Class is used as a ProductKeywordRequest object for inventory  
 * 
 * @author Babu V
 *
 */
@Validated
public class LibraryItemRequestDTO {

	private Integer libraryId;
	private String itemCode;
	private String shortImage;
	private String actualImage;
	private MultipartFile file;
	
	
	


	public MultipartFile getFile() {
		return file;
	}



	public void setFile(MultipartFile file) {
		this.file = file;
	}



	public Integer getLibraryId() {
		return libraryId;
	}



	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}



	public String getItemCode() {
		return itemCode;
	}



	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}



	public String getShortImage() {
		return shortImage;
	}



	public void setShortImage(String shortImage) {
		this.shortImage = shortImage;
	}



	public String getActualImage() {
		return actualImage;
	}



	public void setActualImage(String actualImage) {
		this.actualImage = actualImage;
	}



	public LibraryItem toModel(LibraryItemRequestDTO libraryItemRequestDTO) {
		LibraryItem libraryItem = new LibraryItem();
		
		try {
			libraryItem.setLibraryId(libraryItemRequestDTO.getLibraryId());
			libraryItem.setItemCode(libraryItemRequestDTO.getItemCode());
			libraryItem.setShortImage(libraryItemRequestDTO.getShortImage());
			libraryItem.setActualImage(libraryItemRequestDTO.getActualImage());
			
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return libraryItem;

	}
}
