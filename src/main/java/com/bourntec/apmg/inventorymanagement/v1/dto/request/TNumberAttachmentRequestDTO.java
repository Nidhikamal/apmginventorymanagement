/**
 * 
 */
package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.TNumberAttachment;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Srijini
 *
 */
@Validated
@Getter
@Setter
public class TNumberAttachmentRequestDTO {

	private Long id;

	private Long tno;

	private String fileid;

	private String type;

	public TNumberAttachment toModel(TNumberAttachmentRequestDTO tNumberAttachmentRequestDTO) {
		TNumberAttachment tNumberAttachment = new TNumberAttachment();

		try {
			tNumberAttachment.setId(tNumberAttachmentRequestDTO.getId());
			tNumberAttachment.setTno(tNumberAttachmentRequestDTO.getTno());
			tNumberAttachment.setFileid(tNumberAttachmentRequestDTO.getFileid());
			tNumberAttachment.setType(tNumberAttachmentRequestDTO.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tNumberAttachment;
	}

}
