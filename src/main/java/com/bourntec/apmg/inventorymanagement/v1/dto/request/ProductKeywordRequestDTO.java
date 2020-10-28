package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.ProductKeywords;

/**
 * 
 * Class is used as a ProductKeywordRequest object for inventory  
 * 
 * @author Babu V
 *
 */
@Validated
public class ProductKeywordRequestDTO {

	public Integer getKeyUid() {
		return keyUid;
	}



	public void setKeyUid(Integer keyUid) {
		this.keyUid = keyUid;
	}



	public String getKeywordId() {
		return keywordId;
	}



	public void setKeywordId(String keywordId) {
		this.keywordId = keywordId;
	}



	public String getItemCode() {
		return itemCode;
	}



	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}



	public String getKeywordDesc() {
		return keywordDesc;
	}



	public void setKeywordDesc(String keywordDesc) {
		this.keywordDesc = keywordDesc;
	}



	private Integer keyUid;
	private String keywordId;
	private String itemCode;
	private String keywordDesc;
	
	
	
	public ProductKeywords toModel(ProductKeywordRequestDTO productKeywordRequestDTO) {
		ProductKeywords productKeywords = new ProductKeywords();
		
		try {
			productKeywords.setKeyUid(productKeywordRequestDTO.getKeyUid());
			productKeywords.setKeywordId(productKeywordRequestDTO.getKeywordId());
			productKeywords.setItemCode(productKeywordRequestDTO.getItemCode());
			productKeywords.setKeywordDesc(productKeywordRequestDTO.getKeywordDesc());
			
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return productKeywords;

	}
}
