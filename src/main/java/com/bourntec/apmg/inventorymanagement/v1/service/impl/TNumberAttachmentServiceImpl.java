package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.TNumberAttachment;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.TNumberAttachmentRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TNumberAttachmentResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.TNumberAttachmentRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.TNumberAttachmentService;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for TNumberAttachmentService
 * 
 * @author Srijini
 *
 */
@Service(value = "TNumberAttachmentServiceImpl")
public class TNumberAttachmentServiceImpl implements TNumberAttachmentService {

	private static final Logger logger = LogManager.getLogger(TNumberAttachmentServiceImpl.class);

	@Autowired
	private TNumberAttachmentRepository tNumberAttachmentRepository;

	/**
	 * Method for fetch all TNumberAttachment
	 */
	@Override
	public List<TNumberAttachmentResponseDTO> findAllTNumberAttachments() throws Exception {
		logger.info("Entering for fetching all tnumer Attachment data..");
		List<TNumberAttachmentResponseDTO> keywordResponseDTOList = new ArrayList<TNumberAttachmentResponseDTO>();
		try {
			List<TNumberAttachment> tNumberAttachment = tNumberAttachmentRepository.findAll();
			if (tNumberAttachment != null && !tNumberAttachment.isEmpty()) {
				tNumberAttachment.forEach(obj -> {
					TNumberAttachmentResponseDTO keywordResponseDTO = new TNumberAttachmentResponseDTO();
					BeanUtils.copyProperties(obj, keywordResponseDTO);
					keywordResponseDTOList.add(keywordResponseDTO);
				});
			} else {
				TNumberAttachmentResponseDTO keywordResponseDTO = new TNumberAttachmentResponseDTO();
				keywordResponseDTO.setResponseMessage("Requested TNumberAttachment is not exist");
				keywordResponseDTOList.add(keywordResponseDTO);
			}
		} catch (Exception e) {
			logger.error("TNumberAttachmentServiceImpl getAll failed: " + e);
		}
		return keywordResponseDTOList;
	}

	/**
	 * method for fet a TNumberAttachment
	 */
	@Override
	public TNumberAttachmentResponseDTO getTNumberAttachmentById(Long id) throws Exception {
		logger.info("Entering getTNumberAttachmentById ..");
		TNumberAttachmentResponseDTO keywordResponseDTO = new TNumberAttachmentResponseDTO();
		try {
			Optional<TNumberAttachment> tNumberKeywordOptional = tNumberAttachmentRepository.findById(id);
			if (tNumberKeywordOptional.isPresent()) {
				TNumberAttachment data = tNumberKeywordOptional.get();
				BeanUtils.copyProperties(data, keywordResponseDTO);
				keywordResponseDTO.setResponseMessage("TNumberAttachments fetch successfully");
			} else {
				logger.error("TNumberAttachment doesn't exist");
				keywordResponseDTO.setResponseMessage("TNumberAttachments doesn't exist");
			}
		} catch (BeansException e) {
			logger.error("TNumberAttachmentServiceImpl getTNumberAttachmentById failed: " + e);
		}
		return keywordResponseDTO;
	}

	/***
	 * method for save TNumberAttachment
	 */
	@Override
	public TNumberAttachmentResponseDTO saveTNumberAttachments(TNumberAttachmentRequestDTO tNumberKeywordRequestDTO)
			throws Exception {
		logger.info("Entering save ..");
		TNumberAttachmentResponseDTO keywordResponseDTO = new TNumberAttachmentResponseDTO();
		try {
			TNumberAttachment tNumberKeyword = tNumberKeywordRequestDTO.toModel(tNumberKeywordRequestDTO);
			TNumberAttachment numberKeyword = tNumberAttachmentRepository.save(tNumberKeyword);
			if (numberKeyword != null) {
				BeanUtils.copyProperties(numberKeyword, keywordResponseDTO);
				logger.info("TNumberAttachments saved successfully");
				keywordResponseDTO.setResponseMessage("TNumberAttachments saved successfully");
			} else {
				keywordResponseDTO.setResponseMessage("Failed to save TNumberAttachments");
				logger.error("Failed to save TNumberAttachments ");
			}
		} catch (Exception e) {
			logger.error("TNumberAttachmentServiceImpl saveTNumberAttachments failed: " + e);
		}
		return keywordResponseDTO;
	}

	@Override
	public List<TNumberAttachmentResponseDTO> findTNumberAttachmentByCriteria(
			TNumberAttachmentRequestDTO tNumberKeywordRequestDTO) throws Exception {
		logger.info("Entering for fetching all tnumer Attachment data..");
		List<TNumberAttachmentResponseDTO> keywordResponseDTOList = new ArrayList<TNumberAttachmentResponseDTO>();
		try {
			List<TNumberAttachment> tNumberAttachment = findByCriteria(tNumberKeywordRequestDTO);
			if (tNumberAttachment != null && !tNumberAttachment.isEmpty()) {
				tNumberAttachment.forEach(obj -> {
					TNumberAttachmentResponseDTO keywordResponseDTO = new TNumberAttachmentResponseDTO();
					BeanUtils.copyProperties(obj, keywordResponseDTO);
					keywordResponseDTOList.add(keywordResponseDTO);
				});
			} else {
				TNumberAttachmentResponseDTO keywordResponseDTO = new TNumberAttachmentResponseDTO();
				keywordResponseDTO.setResponseMessage("Requested TNumberAttachment is not exist");
				keywordResponseDTOList.add(keywordResponseDTO);
			}
		} catch (Exception e) {
			logger.error("TNumberAttachmentServiceImpl getAll failed: " + e);
		}
		return keywordResponseDTOList;
	}

	/**
	 * Crtieria builder for fetching TNumberAttachments
	 * 
	 * @param TNumberAttachmentRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<TNumberAttachment> findByCriteria(TNumberAttachmentRequestDTO attachmentRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for TNumberAttachment ");

		GenericSpesification<TNumberAttachment> genericSpesification = new GenericSpesification<TNumberAttachment>();
		try {
			if (attachmentRequestDTO.getId() != null) {
				genericSpesification.add(new SearchCriteria("id", attachmentRequestDTO.getId(), SearchOperation.EQUAL));
			}
			if (attachmentRequestDTO.getFileid() != null) {
				genericSpesification
						.add(new SearchCriteria("fileid", attachmentRequestDTO.getFileid(), SearchOperation.MATCH));
			}
			if (attachmentRequestDTO.getType() != null) {
				genericSpesification
						.add(new SearchCriteria("type", attachmentRequestDTO.getType(), SearchOperation.MATCH));
			}
			if (attachmentRequestDTO.getTno() != null) {
				genericSpesification
						.add(new SearchCriteria("tno", attachmentRequestDTO.getTno(), SearchOperation.EQUAL));
			}

			return tNumberAttachmentRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("TNumberAttachmentServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}

	/***
	 * method for update TNumberAttachment
	 */
	@Override
	public TNumberAttachmentResponseDTO updateTNumberAttachment(Long id,
			TNumberAttachmentRequestDTO tNumberKeywordRequestDTO) throws Exception {
		logger.info("Entering update ..");
		TNumberAttachmentResponseDTO keywordResponseDTO = new TNumberAttachmentResponseDTO();
		try {
			Optional<TNumberAttachment> tNumberKeywordOptional = tNumberAttachmentRepository.findById(id);
			if (tNumberKeywordOptional.isPresent()) {
				TNumberAttachment tNumberKeyword = tNumberKeywordRequestDTO.toModel(tNumberKeywordRequestDTO);
				tNumberKeywordRequestDTO.setId(id);
				TNumberAttachment numberKeyword = tNumberAttachmentRepository.save(tNumberKeyword);
				if (numberKeyword != null) {
					BeanUtils.copyProperties(numberKeyword, keywordResponseDTO);
					logger.info("TNumberAttachments updated successfully");
					keywordResponseDTO.setResponseMessage("TNumberAttachments updated successfully");
				} else {
					keywordResponseDTO.setResponseMessage("Failed to update TNumberAttachments");
					logger.error("Failed to save TNumberAttachments Attachment ");
				}
			} else {
				logger.error("TNumberAttachment doesn't exist");
				keywordResponseDTO.setResponseMessage("TNumberAttachments doesn't exist");
			}
		} catch (Exception e) {
			logger.error("TNumberAttachmentServiceImpl updateTNumberAttachments failed: " + e);
		}
		return keywordResponseDTO;
	}

	/**
	 * delete TNumberAttachment by id
	 */
	@Override
	public TNumberAttachmentResponseDTO deleteTNumberAttachmentById(Long id) throws Exception {
		logger.info("Entering delete ..");
		TNumberAttachmentResponseDTO keywordResponseDTO = new TNumberAttachmentResponseDTO();
		try {
			Optional<TNumberAttachment> tNumberKeywordOptional = tNumberAttachmentRepository.findById(id);
			if (!tNumberKeywordOptional.isPresent()) {
				logger.error("TNumberAttachments doesn't exist");
				keywordResponseDTO.setResponseMessage("TNumberAttachments doesn't exist");
				return keywordResponseDTO;
			}
			TNumberAttachment dataRespDTO = tNumberKeywordOptional.get();
			if (dataRespDTO == null) {
				logger.info("The TNumberAttachments doesn't exists!!!");
				keywordResponseDTO.setResponseMessage("The TNumberAttachments doesn't exists!!!");
			} else {
				tNumberAttachmentRepository.delete(dataRespDTO);
				keywordResponseDTO.setResponseMessage(" TNumberAttachments deleted successfully");
			}
		} catch (Exception e) {
			logger.error("delete :deleteTNumberAttachmentById of TNumberAttachmentServiceImpl  " + e);
		}
		logger.info("Exiting delete tNumberAttachment");
		return keywordResponseDTO;
	}

}
