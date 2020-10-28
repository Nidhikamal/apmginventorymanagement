/**
 * 
 */
package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.TNumberSubKeyword;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Srijini
 *
 */
@Validated
@Getter
@Setter
public class TNumberSubKeywordRequestDTO {

	private Long id;

	private Long tno;
	
	@Size( max = 3, message = "key id is atmost 3 characters")
	private String keyId;
	
	@Size( max = 3, message = "subKeyId is atmost 3 characters")
	private String subKeyId;

	public TNumberSubKeyword toModel(TNumberSubKeywordRequestDTO subKeywordRequestDTO) {
		TNumberSubKeyword subKeyword = new TNumberSubKeyword();

		try {
			subKeyword.setId(subKeywordRequestDTO.getId());
			subKeyword.setTno(subKeywordRequestDTO.getTno());
			subKeyword.setKeyId(subKeywordRequestDTO.getKeyId());
			subKeyword.setSubKeyId(subKeywordRequestDTO.getSubKeyId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subKeyword;
	}

}
