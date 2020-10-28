/**
 * 
 */
package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.TNumberKeyword;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Srijini
 *
 */
@Validated
@Getter
@Setter
public class TNumberKeywordRequestDTO {

	private Long id;

	private Long tno;

	@Size( max = 3, message = "key id is atmost 3 characters")
	private String keyId;

	public TNumberKeyword toModel(TNumberKeywordRequestDTO tNumberKeywordRequestDTO) {
		TNumberKeyword tNumberKeyword = new TNumberKeyword();

		try {
			tNumberKeyword.setId(tNumberKeywordRequestDTO.getId());
			tNumberKeyword.setTno(tNumberKeywordRequestDTO.getTno());
			tNumberKeyword.setKeyId(tNumberKeywordRequestDTO.getKeyId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tNumberKeyword;
	}

}
