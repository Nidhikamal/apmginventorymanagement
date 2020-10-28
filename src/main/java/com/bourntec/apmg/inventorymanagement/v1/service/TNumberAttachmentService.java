package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.TNumberAttachmentRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TNumberAttachmentResponseDTO;

public interface TNumberAttachmentService {

	List<TNumberAttachmentResponseDTO> findAllTNumberAttachments() throws Exception;

	TNumberAttachmentResponseDTO getTNumberAttachmentById(Long id) throws Exception;

	TNumberAttachmentResponseDTO saveTNumberAttachments(TNumberAttachmentRequestDTO tNumberKeywordRequestDTO) throws Exception;

	List<TNumberAttachmentResponseDTO> findTNumberAttachmentByCriteria(TNumberAttachmentRequestDTO tNumberKeywordRequestDTO)
			throws Exception;

	TNumberAttachmentResponseDTO updateTNumberAttachment(Long id, TNumberAttachmentRequestDTO tNumberKeywordRequestDTO)
			throws Exception;

	TNumberAttachmentResponseDTO deleteTNumberAttachmentById(Long id) throws Exception;

}
