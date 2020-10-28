package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.InventorySubKeyword;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventorySubKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventorySubKeywordResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventorySubKeywordRepository;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.inventorymanagement.v1.service.InventorySubKeywordService;
/**
 * Service impl class for InventorySubKeyword
 * @author Nince
 *
 */
@Service(value = "InventorySubKeywordServiceImpl")
public class InventorySubKeywordServiceImpl implements InventorySubKeywordService {

	private static final Logger logger = LogManager.getLogger(InventorySubKeywordServiceImpl.class);

	@Autowired
	private InventorySubKeywordRepository inventorySubKeywordRepository;

	/**
	 * method to Fetching InventorySubKeyword details by id
	 */
	public InventorySubKeywordResponseDTO getInventorySubKeywordById(Long id) {
		InventorySubKeywordResponseDTO dataRespDTO = new InventorySubKeywordResponseDTO();
		try {
			logger.info("Entering getInventorySubKeyword ..");
			Optional<InventorySubKeyword> jobOptional = inventorySubKeywordRepository.findById(id);
			if (jobOptional.isPresent()) {
				InventorySubKeyword data = jobOptional.get();
				BeanUtils.copyProperties(data, dataRespDTO);
				dataRespDTO.setResponseMessage("Inventory Sub Keyword fetch successfully");
			} else {
				logger.error("Inventory Sub Keyword doesn't exist");
				dataRespDTO.setResponseMessage("Inventory Sub Keyword doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch: getInventoryKeywordById of InventoryKeywordServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;
	}

	/**
	 * method which is used to save InventorySubKeyword
	 */
	public InventorySubKeywordResponseDTO saveInventorySubKeyword(InventorySubKeywordRequestDTO inventorySubKeywordReqDTO) {
		logger.info("Save Inventory Sub Keyword details ..");
		InventorySubKeywordResponseDTO dataRespDTO = new InventorySubKeywordResponseDTO();
		try {
			InventorySubKeyword inventorySubKeywordData = inventorySubKeywordReqDTO.toModel(inventorySubKeywordReqDTO);
			InventorySubKeyword inventorySubKeywordDataEntity = inventorySubKeywordRepository.save(inventorySubKeywordData);
			if (inventorySubKeywordDataEntity != null) {
				BeanUtils.copyProperties(inventorySubKeywordDataEntity, dataRespDTO);
				logger.info("Inventory Sub Keyword saved successfully");
				dataRespDTO.setResponseMessage("Inventory Sub Keyword saved successfully");
			} else {
				dataRespDTO.setResponseMessage("Failed to save Inventory Sub Keyword");
				logger.error("Failed to save Inventory Sub Keyword");
			}
		} catch (Exception e) {
			logger.error("Saving saveInventorySubKeyword of InventorySubKeywordServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;

	}

	/**
	 * method which is used to update InventorySubKeyword
	 * 
	 */
	public InventorySubKeywordResponseDTO updateInventorySubKeyword(Long id, InventorySubKeywordRequestDTO inventorySubKeywordReqDTO) {
		logger.info("update Inventory Sub Keyword details ..");
		InventorySubKeywordResponseDTO inventorySubKeywordDataRespDTO = new InventorySubKeywordResponseDTO();
		try {
			Optional<InventorySubKeyword> inventorySubKeywordOptional = inventorySubKeywordRepository.findById(id);
			if (inventorySubKeywordOptional.isPresent()) {
				InventorySubKeyword inventorySubKeyword = inventorySubKeywordReqDTO.toModel(inventorySubKeywordReqDTO);
				inventorySubKeyword.setId(id);
				InventorySubKeyword dataEntity = inventorySubKeywordRepository.save(inventorySubKeyword);
				if (dataEntity != null) {
					BeanUtils.copyProperties(dataEntity, inventorySubKeywordDataRespDTO);
					inventorySubKeywordDataRespDTO.setResponseMessage("Inventory Keyword updated successfully");
					logger.info("Inventory Keyword updated successfully");
				} else {
					inventorySubKeywordDataRespDTO.setResponseMessage("Inventory Keyword updation failed");
					logger.info("Inventory Keyword updation failed");
				}
			} else {
				logger.info("Inventory Keyword doesn't exist");
				inventorySubKeywordDataRespDTO.setResponseMessage("Inventory Keyword doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update :updateInventoryKeyword of InventoryKeywordServiceImpl" + e);
			throw e;
		}

		return inventorySubKeywordDataRespDTO;
	}

	/**
	 * method which is used to get all Inventory Sub Keyword data
	 */
	public List<InventorySubKeywordResponseDTO> findAllInventorySubKeyword() {
		logger.info("Fetching all Inventory Sub Keyword data..");
		List<InventorySubKeywordResponseDTO> resDTOs = new ArrayList<>();
		List<InventorySubKeyword> inventorySubKeywordList = inventorySubKeywordRepository.findAll();
		for (InventorySubKeyword inventorySubKeyword : inventorySubKeywordList) {
			InventorySubKeywordResponseDTO responseDto =new InventorySubKeywordResponseDTO();
			BeanUtils.copyProperties(inventorySubKeyword, responseDto);
			resDTOs.add(responseDto);
		}
		return resDTOs;
	}

	/**
	 * method which is used to find InventorySubKeyword by criteria
	 */
	public List<InventorySubKeywordResponseDTO> findInventorySubKeywordByCriteria(
			InventorySubKeywordRequestDTO jobReqDTO) {
		GenericSpesification<InventorySubKeyword> genericSpesification = new GenericSpesification<InventorySubKeyword>();
		logger.info("Fetching Inventory Sub Keyword data by criteria ..");
		if (jobReqDTO.getId() != null) {
			genericSpesification.add(new SearchCriteria("id", jobReqDTO.getId(), SearchOperation.EQUAL));
		}
		if (jobReqDTO.getKeyId() != null && !jobReqDTO.getKeyId().isEmpty()) {
			genericSpesification.add(new SearchCriteria("keyId", jobReqDTO.getKeyId(), SearchOperation.MATCH));
		}
		if (jobReqDTO.getSubKeyId() != null && !jobReqDTO.getSubKeyId().isEmpty()) {
			genericSpesification.add(new SearchCriteria("subKeyId", jobReqDTO.getSubKeyId(), SearchOperation.MATCH));
		}
		if (jobReqDTO.getItemCode() != null && !jobReqDTO.getItemCode().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("itemCode", jobReqDTO.getItemCode(), SearchOperation.MATCH));
		}
		return inventorySubKeywordRepository.findAll(genericSpesification);
	}

	/**
	 * method which is used to delete InventoryKeyword by id
	 */

	public InventorySubKeywordResponseDTO deleteInventorySubKeywordById(Long id) {
		logger.info("Entering delete InventorySubKeyword", id);
		InventorySubKeywordResponseDTO dataRespDTO = new InventorySubKeywordResponseDTO();
		Optional<InventorySubKeyword> dataList = inventorySubKeywordRepository.findById(id);
		InventorySubKeyword inventorySubKeywordData = dataList.get();
		try {
			if (inventorySubKeywordData == null) {
				logger.info("The Inventory Sub Keyword doesn't exists!!!");
				dataRespDTO.setResponseMessage("The Inventory Sub Keyword doesn't exists!!!");
			} else {
				inventorySubKeywordRepository.delete(inventorySubKeywordData);
				dataRespDTO.setResponseMessage(" Inventory Sub Keyword deleted successfully");
			}
			logger.info("Exiting deleteInventorySubKeyword");
		} catch (Exception e) {
			logger.error("delete :deleteInventorySubKeywordById of InventorySubKeywordServiceImpl  " + e);
			throw e;
		}
		return dataRespDTO;
	}

}
