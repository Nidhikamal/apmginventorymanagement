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

import com.bourntec.apmg.entity.TNumberHistory;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.TNumberHistoryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TNumberHistoryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.TNumberHistoryRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.TNumberHistoryService;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for TNumberHistoryService
 * 
 * @author Srijini
 *
 */
@Service(value = "TNumberHistoryServiceImpl")
public class TNumberHistoryServiceImpl implements TNumberHistoryService {

	private static final Logger logger = LogManager.getLogger(TNumberHistoryServiceImpl.class);

	@Autowired
	private TNumberHistoryRepository tNumberHistoryRepository;

	/**
	 * Method for fetch all TNumberHistory
	 */
	@Override
	public List<TNumberHistoryResponseDTO> findAllTNumberHistorys() throws Exception {
		logger.info("Entering for fetching all tnumer History data..");
		List<TNumberHistoryResponseDTO> keywordResponseDTOList = new ArrayList<TNumberHistoryResponseDTO>();
		try {
			List<TNumberHistory> tNumberHistory = tNumberHistoryRepository.findAll();
			if (tNumberHistory != null && !tNumberHistory.isEmpty()) {
				tNumberHistory.forEach(obj -> {
					TNumberHistoryResponseDTO keywordResponseDTO = new TNumberHistoryResponseDTO();
					BeanUtils.copyProperties(obj, keywordResponseDTO);
					keywordResponseDTOList.add(keywordResponseDTO);
				});
			} else {
				TNumberHistoryResponseDTO keywordResponseDTO = new TNumberHistoryResponseDTO();
				keywordResponseDTO.setResponseMessage("Requested TNumberHistory is not exist");
				keywordResponseDTOList.add(keywordResponseDTO);
			}
		} catch (Exception e) {
			logger.error("TNumberHistoryServiceImpl getAll failed: " + e);
		}
		return keywordResponseDTOList;
	}

	/**
	 * method for fet a TNumberHistory
	 */
	@Override
	public TNumberHistoryResponseDTO getTNumberHistoryById(Long id) throws Exception {
		logger.info("Entering getTNumberHistoryById ..");
		TNumberHistoryResponseDTO keywordResponseDTO = new TNumberHistoryResponseDTO();
		try {
			Optional<TNumberHistory> tNumberKeywordOptional = tNumberHistoryRepository.findById(id);
			if (tNumberKeywordOptional.isPresent()) {
				TNumberHistory data = tNumberKeywordOptional.get();
				BeanUtils.copyProperties(data, keywordResponseDTO);
				keywordResponseDTO.setResponseMessage("TNumberHistorys fetch successfully");
			} else {
				logger.error("TNumberHistory doesn't exist");
				keywordResponseDTO.setResponseMessage("TNumberHistorys doesn't exist");
			}
		} catch (BeansException e) {
			logger.error("TNumberHistoryServiceImpl getTNumberHistoryById failed: " + e);
		}
		return keywordResponseDTO;
	}

	/***
	 * method for save TNumberHistory
	 */
	@Override
	public TNumberHistoryResponseDTO saveTNumberHistorys(TNumberHistoryRequestDTO tNumberKeywordRequestDTO)
			throws Exception {
		logger.info("Entering save ..");
		TNumberHistoryResponseDTO keywordResponseDTO = new TNumberHistoryResponseDTO();
		try {
			TNumberHistory tNumberKeyword = tNumberKeywordRequestDTO.toModel(tNumberKeywordRequestDTO);
			TNumberHistory numberKeyword = tNumberHistoryRepository.save(tNumberKeyword);
			if (numberKeyword != null) {
				BeanUtils.copyProperties(numberKeyword, keywordResponseDTO);
				logger.info("TNumberHistorys saved successfully");
				keywordResponseDTO.setResponseMessage("TNumberHistorys saved successfully");
			} else {
				keywordResponseDTO.setResponseMessage("Failed to save TNumberHistorys");
				logger.error("Failed to save TNumberHistorys ");
			}
		} catch (Exception e) {
			logger.error("TNumberHistoryServiceImpl saveTNumberHistorys failed: " + e);
		}
		return keywordResponseDTO;
	}

	@Override
	public List<TNumberHistoryResponseDTO> findTNumberHistoryByCriteria(
			TNumberHistoryRequestDTO tNumberKeywordRequestDTO) throws Exception {
		logger.info("Entering for fetching all tnumer History data..");
		List<TNumberHistoryResponseDTO> keywordResponseDTOList = new ArrayList<TNumberHistoryResponseDTO>();
		try {
			List<TNumberHistory> tNumberHistory = findByCriteria(tNumberKeywordRequestDTO);
			if (tNumberHistory != null && !tNumberHistory.isEmpty()) {
				tNumberHistory.forEach(obj -> {
					TNumberHistoryResponseDTO keywordResponseDTO = new TNumberHistoryResponseDTO();
					BeanUtils.copyProperties(obj, keywordResponseDTO);
					keywordResponseDTOList.add(keywordResponseDTO);
				});
			} else {
				TNumberHistoryResponseDTO keywordResponseDTO = new TNumberHistoryResponseDTO();
				keywordResponseDTO.setResponseMessage("Requested TNumberHistory is not exist");
				keywordResponseDTOList.add(keywordResponseDTO);
			}
		} catch (Exception e) {
			logger.error("TNumberHistoryServiceImpl getAll failed: " + e);
		}
		return keywordResponseDTOList;
	}

	/**
	 * Crtieria builder for fetching TNumberHistorys
	 * 
	 * @param TNumberHistoryRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<TNumberHistory> findByCriteria(TNumberHistoryRequestDTO HistoryRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for TNumberHistory ");

		GenericSpesification<TNumberHistory> genericSpesification = new GenericSpesification<TNumberHistory>();
		try {
			if (HistoryRequestDTO.getId() != null) {
				genericSpesification.add(new SearchCriteria("id", HistoryRequestDTO.getId(), SearchOperation.EQUAL));
			}
			if (HistoryRequestDTO.getUserId() != null) {
				genericSpesification
						.add(new SearchCriteria("userId", HistoryRequestDTO.getUserId(), SearchOperation.MATCH));
			}
			if (HistoryRequestDTO.getAction() != null) {
				genericSpesification
						.add(new SearchCriteria("action", HistoryRequestDTO.getAction(), SearchOperation.MATCH));
			}

			if (HistoryRequestDTO.getCreatedDate() != null) {
				genericSpesification.add(
						new SearchCriteria("createdDate", HistoryRequestDTO.getCreatedDate(), SearchOperation.GREATER_THAN_EQUAL));
			}

			if (HistoryRequestDTO.getTno() != null) {
				genericSpesification.add(new SearchCriteria("tno", HistoryRequestDTO.getTno(), SearchOperation.EQUAL));
			}

			return tNumberHistoryRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("TNumberHistoryServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}

	/***
	 * method for update TNumberHistory
	 */
	@Override
	public TNumberHistoryResponseDTO updateTNumberHistory(Long id, TNumberHistoryRequestDTO tNumberKeywordRequestDTO)
			throws Exception {
		logger.info("Entering update ..");
		TNumberHistoryResponseDTO keywordResponseDTO = new TNumberHistoryResponseDTO();
		try {
			Optional<TNumberHistory> tNumberKeywordOptional = tNumberHistoryRepository.findById(id);
			if (tNumberKeywordOptional.isPresent()) {
				TNumberHistory tNumberKeyword = tNumberKeywordRequestDTO.toModel(tNumberKeywordRequestDTO);
				tNumberKeywordRequestDTO.setId(id);
				TNumberHistory numberKeyword = tNumberHistoryRepository.save(tNumberKeyword);
				if (numberKeyword != null) {
					BeanUtils.copyProperties(numberKeyword, keywordResponseDTO);
					logger.info("TNumberHistorys updated successfully");
					keywordResponseDTO.setResponseMessage("TNumberHistorys updated successfully");
				} else {
					keywordResponseDTO.setResponseMessage("Failed to update TNumberHistorys");
					logger.error("Failed to save TNumberHistorys History ");
				}
			} else {
				logger.error("TNumberHistory doesn't exist");
				keywordResponseDTO.setResponseMessage("TNumberHistorys doesn't exist");
			}
		} catch (Exception e) {
			logger.error("TNumberHistoryServiceImpl updateTNumberHistorys failed: " + e);
		}
		return keywordResponseDTO;
	}

	/**
	 * delete TNumberHistory by id
	 */
	@Override
	public TNumberHistoryResponseDTO deleteTNumberHistoryById(Long id) throws Exception {
		logger.info("Entering delete ..");
		TNumberHistoryResponseDTO keywordResponseDTO = new TNumberHistoryResponseDTO();
		try {
			Optional<TNumberHistory> tNumberKeywordOptional = tNumberHistoryRepository.findById(id);
			if (!tNumberKeywordOptional.isPresent()) {
				logger.error("TNumberHistorys doesn't exist");
				keywordResponseDTO.setResponseMessage("TNumberHistorys doesn't exist");
				return keywordResponseDTO;
			}
			TNumberHistory dataRespDTO = tNumberKeywordOptional.get();
			if (dataRespDTO == null) {
				logger.info("The TNumberHistorys doesn't exists!!!");
				keywordResponseDTO.setResponseMessage("The TNumberHistorys doesn't exists!!!");
			} else {
				tNumberHistoryRepository.delete(dataRespDTO);
				keywordResponseDTO.setResponseMessage(" TNumberHistorys deleted successfully");
			}
		} catch (Exception e) {
			logger.error("delete :deleteTNumberHistoryById of TNumberHistoryServiceImpl  " + e);
		}
		logger.info("Exiting delete tNumberHistory");
		return keywordResponseDTO;
	}

}
