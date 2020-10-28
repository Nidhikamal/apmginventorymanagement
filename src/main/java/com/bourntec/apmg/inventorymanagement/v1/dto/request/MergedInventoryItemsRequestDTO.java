package com.bourntec.apmg.inventorymanagement.v1.dto.request;
 
import org.springframework.validation.annotation.Validated;
 

@Validated
public class MergedInventoryItemsRequestDTO {
	
	private Long id;
	private String itemCode;
    private String jobNo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getJobNo() {
		return jobNo;
	}
	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}
    
}	 