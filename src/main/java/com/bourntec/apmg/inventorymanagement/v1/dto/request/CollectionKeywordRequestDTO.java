package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.CollectionKeyword;
import com.bourntec.apmg.entity.CollectionSubKeyword;

/**
 * 
 * Class is used as a data transfer object for materail codes 
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
public class CollectionKeywordRequestDTO {

	
	private String keyId;
	private String keyName;
	

	public CollectionKeyword toModel(CollectionKeywordRequestDTO collectionKeyWordRequestDTO) {
		CollectionKeyword collectionKeyword = new CollectionKeyword();
		
		try {
			collectionKeyword.setKeyId(collectionKeyWordRequestDTO.getKeyId());
			collectionKeyword.setKeyName(collectionKeyWordRequestDTO.getKeyName());
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return collectionKeyword;

	}

	
	public String getKeyId() {
		return keyId;
	}


	public String getKeyName() {
		return keyName;
	}


	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}


	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	
}
