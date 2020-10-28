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

import com.bourntec.apmg.entity.TNumberKeyword;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.TNumberKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TNumberKeywordResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.TNumberKeywordRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.TNumberKeywordService;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for TNumberKeywordService
 * 
 * @author Srijini
 *
 */
@Service(value = "TNumberKeywordServiceImpl")
public class TNumberKeywordServiceImpl implements TNumberKeywordService {

	private static final Logger logger = LogManager.getLogger(TNumberAttachmentServiceImpl.class);

	@Autowired
	private TNumberKeywordRepository tNumberKeywordRepository;

	/**
	 * Method for fetch all TNumberKeywords
	 */
	@Override
	public List<TNumberKeywordResponseDTO> findAllTNumberKeywords() throws Exception {
		logger.info("Entering for fetching all tnumer Keywords data..");
		List<TNumberKeywordResponseDTO> keywordResponseDTOList = new ArrayList<TNumberKeywordResponseDTO>();
		try {
			List<TNumberKeyword> tNumberKeywords = tNumberKeywordRepository.findAll();
			if (tNumberKeywords != null && !tNumberKeywords.isEmpty()) {
				tNumberKeywords.forEach(obj -> {
					TNumberKeywordResponseDTO keywordResponseDTO = new TNumberKeywordResponseDTO();
					BeanUtils.copyProperties(obj, keywordResponseDTO);
					keywordResponseDTOList.add(keywordResponseDTO);
				});
			} else {
				TNumberKeywordResponseDTO keywordResponseDTO = new TNumberKeywordResponseDTO();
				keywordResponseDTO.setResponseMessage("Requested TNumber Keywords is not exist");
				keywordResponseDTOList.add(keywordResponseDTO);
			}
		} catch (Exception e) {
			logger.error("TNumberKeywordServiceImpl getAll failed: " + e);
		}
		return keywordResponseDTOList;
	}

	/**
	 * method for fet a TNumberKeyword
	 */
	@Override
	public TNumberKeywordResponseDTO getTNumberKeywordById(Long id) throws Exception {
		logger.info("Entering getTNumberKeywordById ..");
		TNumberKeywordResponseDTO keywordResponseDTO = new TNumberKeywordResponseDTO();
		try {
			Optional<TNumberKeyword> tNumberKeywordOptional = tNumberKeywordRepository.findById(id);
			if (tNumberKeywordOptional.isPresent()) {
				TNumberKeyword data = tNumberKeywordOptional.get();
				BeanUtils.copyProperties(data, keywordResponseDTO);
				keywordResponseDTO.setResponseMessage("TNumberKeywords fetch successfully");
			} else {
				logger.error("TNumber Keywords doesn't exist");
				keywordResponseDTO.setResponseMessage("TNumberKeywords doesn't exist");
			}
		} catch (BeansException e) {
			logger.error("TNumberKeywordServiceImpl getTNumberKeywordById failed: " + e);
		}
		return keywordResponseDTO;
	}

	/***
	 * method for save TNumberKeyword
	 */
	@Override
	public TNumberKeywordResponseDTO saveTNumberKeywords(TNumberKeywordRequestDTO tNumberKeywordRequestDTO)
			throws Exception {
		logger.info("Entering save ..");
		TNumberKeywordResponseDTO keywordResponseDTO = new TNumberKeywordResponseDTO();
		try {
			TNumberKeyword tNumberKeyword = tNumberKeywordRequestDTO.toModel(tNumberKeywordRequestDTO);
			TNumberKeyword numberKeyword = tNumberKeywordRepository.save(tNumberKeyword);
			if (numberKeyword != null) {
				BeanUtils.copyProperties(numberKeyword, keywordResponseDTO);
				logger.info("TNumberKeywords saved successfully");
				keywordResponseDTO.setResponseMessage("TNumberKeywords saved successfully");
			} else {
				keywordResponseDTO.setResponseMessage("Failed to save TNumberKeywords");
				logger.error("Failed to save TNumberKeywords ");
			}
		} catch (Exception e) {
			logger.error("TNumberKeywordServiceImpl saveTNumberKeywords failed: " + e);
		}
		return keywordResponseDTO;
	}

	@Override
	public List<TNumberKeywordResponseDTO> findTNumberKeywordByCriteria(TNumberKeywordRequestDTO tNumberKeywordRequestDTO)
			throws Exception {
		logger.info("Entering for fetching all tnumer Keywords data..");
		List<TNumberKeywordResponseDTO> keywordResponseDTOList = new ArrayList<TNumberKeywordResponseDTO>();
		try {
			List<TNumberKeyword> tNumberKeywords = findByCriteria(tNumberKeywordRequestDTO);
			if (tNumberKeywords != null && !tNumberKeywords.isEmpty()) {
				tNumberKeywords.forEach(obj -> {
					TNumberKeywordResponseDTO keywordResponseDTO = new TNumberKeywordResponseDTO();
					BeanUtils.copyProperties(obj, keywordResponseDTO);
					keywordResponseDTOList.add(keywordResponseDTO);
				});
			} else {
				TNumberKeywordResponseDTO keywordResponseDTO = new TNumberKeywordResponseDTO();
				keywordResponseDTO.setResponseMessage("Requested TNumber Keywords is not exist");
				keywordResponseDTOList.add(keywordResponseDTO);
			}
		} catch (Exception e) {
			logger.error("TNumberKeywordServiceImpl getAll failed: " + e);
		}
		return keywordResponseDTOList;
	}

	/**
	 * Crtieria builder for fetching TNumberKeywords
	 * 
	 * @param TNumberKeywordRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<TNumberKeyword> findByCriteria(TNumberKeywordRequestDTO keywordRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for TNumberKeywords ");

		GenericSpesification<TNumberKeyword> genericSpesification = new GenericSpesification<TNumberKeyword>();
		try {
			if (keywordRequestDTO.getId() != null) {
				genericSpesification.add(new SearchCriteria("id", keywordRequestDTO.getId(), SearchOperation.EQUAL));
			}
			if (keywordRequestDTO.getKeyId() != null) {
				genericSpesification
						.add(new SearchCriteria("keyId", keywordRequestDTO.getKeyId(), SearchOperation.MATCH));
			}
			if (keywordRequestDTO.getTno() != null) {
				genericSpesification.add(new SearchCriteria("tno", keywordRequestDTO.getTno(), SearchOperation.EQUAL));
			}

			return tNumberKeywordRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("TNumberKeywordServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}

	/***
	 * method for update TNumberKeyword
	 */
	@Override
	public TNumberKeywordResponseDTO updateTNumberKeyword(Long id, TNumberKeywordRequestDTO tNumberKeywordRequestDTO)
			throws Exception {
		logger.info("Entering update ..");
		TNumberKeywordResponseDTO keywordResponseDTO = new TNumberKeywordResponseDTO();
		try {
			Optional<TNumberKeyword> tNumberKeywordOptional = tNumberKeywordRepository.findById(id);
			if (tNumberKeywordOptional.isPresent()) {
				TNumberKeyword tNumberKeyword = tNumberKeywordRequestDTO.toModel(tNumberKeywordRequestDTO);
				tNumberKeywordRequestDTO.setId(id);
				TNumberKeyword numberKeyword = tNumberKeywordRepository.save(tNumberKeyword);
				if (numberKeyword != null) {
					BeanUtils.copyProperties(numberKeyword, keywordResponseDTO);
					logger.info("TNumberKeywords updated successfully");
					keywordResponseDTO.setResponseMessage("TNumberKeywords updated successfully");
				} else {
					keywordResponseDTO.setResponseMessage("Failed to update TNumberKeywords");
					logger.error("Failed to save TNumberKeywords Keywords ");
				}
			} else {
				logger.error("TNumber Keywords doesn't exist");
				keywordResponseDTO.setResponseMessage("TNumberKeywords doesn't exist");
			}
		} catch (Exception e) {
			logger.error("TNumberKeywordServiceImpl updateTNumberKeywords failed: " + e);
		}
		return keywordResponseDTO;
	}

	/**
	 * delete tnumber by id
	 */
	@Override
	public TNumberKeywordResponseDTO deleteTNumberKeywordById(Long id) throws Exception {
		logger.info("Entering delete ..");
		TNumberKeywordResponseDTO keywordResponseDTO = new TNumberKeywordResponseDTO();
		try {
			Optional<TNumberKeyword> tNumberKeywordOptional = tNumberKeywordRepository.findById(id);
			if (!tNumberKeywordOptional.isPresent()) {
				logger.error("TNumberKeywords doesn't exist");
				keywordResponseDTO.setResponseMessage("TNumberKeywords doesn't exist");
				return keywordResponseDTO;
			}
			TNumberKeyword dataRespDTO = tNumberKeywordOptional.get();
			if (dataRespDTO == null) {
				logger.info("The TNumberKeywords doesn't exists!!!");
				keywordResponseDTO.setResponseMessage("The TNumberKeywords doesn't exists!!!");
			} else {
				tNumberKeywordRepository.delete(dataRespDTO);
				keywordResponseDTO.setResponseMessage(" TNumberKeywords deleted successfully");
			}
		} catch (Exception e) {
			logger.error("delete :deleteTNumberKeywordById of TNumberKeywordServiceImpl  " + e);
		}
		logger.info("Exiting delete TNumberKeywords");
		return keywordResponseDTO;
	}

}
