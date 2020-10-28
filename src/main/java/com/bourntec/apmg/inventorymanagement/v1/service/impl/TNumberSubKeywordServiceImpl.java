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

import com.bourntec.apmg.entity.TNumberSubKeyword;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.TNumberSubKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TNumberSubKeywordResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.TNumberSubKeywordRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.TNumberSubKeywordService;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for TNumberSubKeywordServiceImpl
 * 
 * @author Srijini
 *
 */
@Service(value = "TNumberSubKeywordServiceImpl")
public class TNumberSubKeywordServiceImpl implements TNumberSubKeywordService {

	private static final Logger logger = LogManager.getLogger(TNumberSubKeywordServiceImpl.class);

	@Autowired
	private TNumberSubKeywordRepository tNumberSubKeywordRepository;

	/**
	 * Method for fetch all tnumberSubkeyword
	 */
	@Override
	public List<TNumberSubKeywordResponseDTO> findAllTNumberSubKeywords() throws Exception {
		logger.info("Entering for fetching all tnumer Keywords data..");
		List<TNumberSubKeywordResponseDTO> keywordResponseDTOList = new ArrayList<TNumberSubKeywordResponseDTO>();
		try {
			List<TNumberSubKeyword> tNumberSubKeywords = tNumberSubKeywordRepository.findAll();
			if (tNumberSubKeywords != null && !tNumberSubKeywords.isEmpty()) {
				tNumberSubKeywords.forEach(obj -> {
					TNumberSubKeywordResponseDTO keywordResponseDTO = new TNumberSubKeywordResponseDTO();
					BeanUtils.copyProperties(obj, keywordResponseDTO);
					keywordResponseDTOList.add(keywordResponseDTO);
				});
			} else {
				TNumberSubKeywordResponseDTO keywordResponseDTO = new TNumberSubKeywordResponseDTO();
				keywordResponseDTO.setResponseMessage("Requested TNumber Keywords is not exist");
				keywordResponseDTOList.add(keywordResponseDTO);
			}
		} catch (Exception e) {
			logger.error("TNumberSubKeywordServiceImpl getAll failed: " + e);
		}
		return keywordResponseDTOList;
	}

	/**
	 * method for fetch a tnumberSubkeyword
	 */
	@Override
	public TNumberSubKeywordResponseDTO getTNumberSubKeywordById(Long id) throws Exception {
		logger.info("Entering getTNumberSubKeywordById ..");
		TNumberSubKeywordResponseDTO keywordResponseDTO = new TNumberSubKeywordResponseDTO();
		try {
			Optional<TNumberSubKeyword> tNumberKeywordOptional = tNumberSubKeywordRepository.findById(id);
			if (tNumberKeywordOptional.isPresent()) {
				TNumberSubKeyword data = tNumberKeywordOptional.get();
				BeanUtils.copyProperties(data, keywordResponseDTO);
				keywordResponseDTO.setResponseMessage("TNumberSubKeywords fetch successfully");
			} else {
				logger.error("TNumberSubKeyword doesn't exist");
				keywordResponseDTO.setResponseMessage("TNumberSubKeywords doesn't exist");
			}
		} catch (BeansException e) {
			logger.error("TNumberSubKeywordServiceImpl getTNumberSubKeywordById failed: " + e);
		}
		return keywordResponseDTO;
	}

	/***
	 * method for save tnumberSubkeyword
	 */
	@Override
	public TNumberSubKeywordResponseDTO saveTNumberSubKeywords(TNumberSubKeywordRequestDTO tNumberKeywordRequestDTO)
			throws Exception {
		logger.info("Entering save ..");
		TNumberSubKeywordResponseDTO keywordResponseDTO = new TNumberSubKeywordResponseDTO();
		try {
			TNumberSubKeyword tNumberKeyword = tNumberKeywordRequestDTO.toModel(tNumberKeywordRequestDTO);
			TNumberSubKeyword numberKeyword = tNumberSubKeywordRepository.save(tNumberKeyword);
			if (numberKeyword != null) {
				BeanUtils.copyProperties(numberKeyword, keywordResponseDTO);
				logger.info("TNumberSubKeywords saved successfully");
				keywordResponseDTO.setResponseMessage("TNumberSubKeywords saved successfully");
			} else {
				keywordResponseDTO.setResponseMessage("Failed to save TNumberSubKeywords");
				logger.error("Failed to save TNumberSubKeyword ");
			}
		} catch (Exception e) {
			logger.error("TNumberSubKeywordServiceImpl saveTNumberSubKeywords failed: " + e);
		}
		return keywordResponseDTO;
	}

	@Override
	public List<TNumberSubKeywordResponseDTO> findTNumberSubKeywordByCriteria(TNumberSubKeywordRequestDTO tNumberKeywordRequestDTO)
			throws Exception {
		logger.info("Entering for fetching all tnumer Keywords data..");
		List<TNumberSubKeywordResponseDTO> keywordResponseDTOList = new ArrayList<TNumberSubKeywordResponseDTO>();
		try {
			List<TNumberSubKeyword> tNumberKeywords = findByCriteria(tNumberKeywordRequestDTO);
			if (tNumberKeywords != null && !tNumberKeywords.isEmpty()) {
				tNumberKeywords.forEach(obj -> {
					TNumberSubKeywordResponseDTO keywordResponseDTO = new TNumberSubKeywordResponseDTO();
					BeanUtils.copyProperties(obj, keywordResponseDTO);
					keywordResponseDTOList.add(keywordResponseDTO);
				});
			} else {
				TNumberSubKeywordResponseDTO keywordResponseDTO = new TNumberSubKeywordResponseDTO();
				keywordResponseDTO.setResponseMessage("Requested TNumber Keywords is not exist");
				keywordResponseDTOList.add(keywordResponseDTO);
			}
		} catch (Exception e) {
			logger.error("TNumberSubKeywordServiceImpl getAll failed: " + e);
		}
		return keywordResponseDTOList;
	}

	/**
	 * Crtieria builder for fetching TNumberSubKeywords
	 * 
	 * @param TNumberSubKeywordRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<TNumberSubKeyword> findByCriteria(TNumberSubKeywordRequestDTO keywordRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for TNumberSubKeyword ");

		GenericSpesification<TNumberSubKeyword> genericSpesification = new GenericSpesification<TNumberSubKeyword>();
		try {
			if (keywordRequestDTO.getId() != null) {
				genericSpesification.add(new SearchCriteria("id", keywordRequestDTO.getId(), SearchOperation.EQUAL));
			}
			if (keywordRequestDTO.getKeyId() != null) {
				genericSpesification
						.add(new SearchCriteria("keyId", keywordRequestDTO.getKeyId(), SearchOperation.MATCH));
			}
			if (keywordRequestDTO.getSubKeyId() != null) {
				genericSpesification
						.add(new SearchCriteria("subKeyId", keywordRequestDTO.getSubKeyId(), SearchOperation.MATCH));
			}
			if (keywordRequestDTO.getTno() != null) {
				genericSpesification.add(new SearchCriteria("tno", keywordRequestDTO.getTno(), SearchOperation.EQUAL));
			}
			
			return tNumberSubKeywordRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("TNumberSubKeywordServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}

	/***
	 * method for update tnumberSubkeyword
	 */
	@Override
	public TNumberSubKeywordResponseDTO updateTNumberSubKeyword(Long id, TNumberSubKeywordRequestDTO tNumberKeywordRequestDTO)
			throws Exception {
		logger.info("Entering update ..");
		TNumberSubKeywordResponseDTO keywordResponseDTO = new TNumberSubKeywordResponseDTO();
		try {
			Optional<TNumberSubKeyword> tNumberKeywordOptional = tNumberSubKeywordRepository.findById(id);
			if (tNumberKeywordOptional.isPresent()) {
				TNumberSubKeyword tNumberKeyword = tNumberKeywordRequestDTO.toModel(tNumberKeywordRequestDTO);
				tNumberKeywordRequestDTO.setId(id);
				TNumberSubKeyword numberKeyword = tNumberSubKeywordRepository.save(tNumberKeyword);
				if (numberKeyword != null) {
					BeanUtils.copyProperties(numberKeyword, keywordResponseDTO);
					logger.info("TNumberSubKeywords updated successfully");
					keywordResponseDTO.setResponseMessage("TNumberSubKeywords updated successfully");
				} else {
					keywordResponseDTO.setResponseMessage("Failed to update TNumberSubKeywords");
					logger.error("Failed to save TNumberSubKeyword ");
				}
			} else {
				logger.error("TNumberSubKeyword doesn't exist");
				keywordResponseDTO.setResponseMessage("TNumberSubKeywords doesn't exist");
			}
		} catch (Exception e) {
			logger.error("TNumberSubKeywordServiceImpl updateTNumberSubKeywords failed: " + e);
		}
		return keywordResponseDTO;
	}

	/**
	 * delete tnumberSubkeyword by id
	 */
	@Override
	public TNumberSubKeywordResponseDTO deleteTNumberSubKeywordById(Long id) throws Exception {
		logger.info("Entering delete ..");
		TNumberSubKeywordResponseDTO keywordResponseDTO = new TNumberSubKeywordResponseDTO();
		try {
			Optional<TNumberSubKeyword> tNumberKeywordOptional = tNumberSubKeywordRepository.findById(id);
			if (!tNumberKeywordOptional.isPresent()) {
				logger.error("TNumberSubKeywords doesn't exist");
				keywordResponseDTO.setResponseMessage("TNumberSubKeywords doesn't exist");
				return keywordResponseDTO;
			}
			TNumberSubKeyword dataRespDTO = tNumberKeywordOptional.get();
			if (dataRespDTO == null) {
				logger.info("The TNumberSubKeywords doesn't exists!!!");
				keywordResponseDTO.setResponseMessage("The TNumberSubKeywords doesn't exists!!!");
			} else {
				tNumberSubKeywordRepository.delete(dataRespDTO);
				keywordResponseDTO.setResponseMessage(" TNumberSubKeywords deleted successfully");
			}
		} catch (Exception e) {
			logger.error("delete :deleteTNumberSubKeywordById of TNumberSubKeywordServiceImpl  " + e);
		}
		logger.info("Exiting delete TNumberSubKeyword");
		return keywordResponseDTO;
	}

}
