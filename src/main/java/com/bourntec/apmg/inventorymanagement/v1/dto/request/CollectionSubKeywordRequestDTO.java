package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.CollectionSubKeyword;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Class is used as a data transfer object for materail codes
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
@Getter
@Setter
public class CollectionSubKeywordRequestDTO {

	private String subKeyId;

	private String keyId;
	private String subKeyName;

	public CollectionSubKeyword toModel(CollectionSubKeywordRequestDTO subKeywordRequestDTO) {
		CollectionSubKeyword collectionSubkeyword = new CollectionSubKeyword();

		try {
			collectionSubkeyword.setSubKeyId(subKeywordRequestDTO.getSubKeyId());
			collectionSubkeyword.setSubKeyName(subKeywordRequestDTO.getSubKeyName());
			collectionSubkeyword.setKeyId(subKeywordRequestDTO.getKeyId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return collectionSubkeyword;

	}

}
