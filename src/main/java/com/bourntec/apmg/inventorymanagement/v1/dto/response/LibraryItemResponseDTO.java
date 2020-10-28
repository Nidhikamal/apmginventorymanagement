package com.bourntec.apmg.inventorymanagement.v1.dto.response; 
import com.bourntec.apmg.inventorymanagement.v1.dto.request.LibraryItemRequestDTO;




/**
 * DTO class for sending the response
 *  
 * @author babu V
 *
 */

public class LibraryItemResponseDTO extends LibraryItemRequestDTO{

	
	
	/**
	 * property that is used to set the message
	 * in service when a particular action carried out in there
	 * for eg : when a inventory1 is not fetched, showing the material codes is not retrieved
	 * @TODO need to remove when exception module is implementd
	 */
	private String responseMessage;
    private byte[] shortImageArray;
    private byte[] actualImageArray;
	private String itemCode;
	private Integer libraryId; 
	

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Integer getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}

	public byte[] getShortImageArray() {
		return shortImageArray;
	}

	public void setShortImageArray(byte[] shortImageArray) {
		this.shortImageArray = shortImageArray;
	}

	public byte[] getActualImageArray() {
		return actualImageArray;
	}

	public void setActualImageArray(byte[] actualImageArray) {
		this.actualImageArray = actualImageArray;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public LibraryItemResponseDTO() {

	}
}
