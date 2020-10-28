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
public class TNumberAttachmentResponseDTO {

	private Long id;

	private Long tno;

	private String fileid;

	private String type;

	private String responseMessage;

}
