/**
 * 
 */
package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import java.util.Date;

import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.TNumberHistory;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Srijini
 *
 */
@Validated
@Getter
@Setter
public class TNumberHistoryRequestDTO {

	private Long id;

	private Long tno;

	private String userId;
	
	@Size( max = 1, message = "key id is atmost 1 characters")
	private String action;
	
	Date createdDate;

	public TNumberHistory toModel(TNumberHistoryRequestDTO tNumberHistoryRequestDTO) {
		TNumberHistory tNumberHistory = new TNumberHistory();

		try {
			tNumberHistory.setId(tNumberHistoryRequestDTO.getId());
			tNumberHistory.setTno(tNumberHistoryRequestDTO.getTno());
			tNumberHistory.setUserId(tNumberHistoryRequestDTO.getUserId());
			tNumberHistory.setAction(tNumberHistoryRequestDTO.getAction());
			tNumberHistory.setCreatedDate(tNumberHistoryRequestDTO.getCreatedDate());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tNumberHistory;
	}

}
