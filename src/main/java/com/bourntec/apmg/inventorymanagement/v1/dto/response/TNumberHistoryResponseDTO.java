/**
 * 
 */
package com.bourntec.apmg.inventorymanagement.v1.dto.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Srijini
 *
 */
@Getter
@Setter
public class TNumberHistoryResponseDTO {

	private Long id;

	private Long tno;

	private String userId;

	private String action;

	Date createdDate;

	private String responseMessage;

}
