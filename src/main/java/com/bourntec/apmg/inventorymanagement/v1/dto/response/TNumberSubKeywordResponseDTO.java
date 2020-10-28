/**
 * 
 */
package com.bourntec.apmg.inventorymanagement.v1.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Srijini
 *
 */
@Getter
@Setter
public class TNumberSubKeywordResponseDTO {
	
	private Long id;

	private Long tno;

	private String keyId;

	private String subKeyId;

	private String responseMessage;

}
