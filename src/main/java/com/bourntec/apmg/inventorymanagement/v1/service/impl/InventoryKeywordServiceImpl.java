package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.InventoryKeyword;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryKeywordResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryKeywordRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryKeywordService;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
/**
 * Service impl class for InventoryKeyword
 * @author Nince
 *
 */
@Service(value = "InventoryKeywordServiceImpl")
public class InventoryKeywordServiceImpl implements InventoryKeywordService {

	private static final Logger logger = LogManager.getLogger(InventoryKeywordServiceImpl.class);

	@Autowired
	private InventoryKeywordRepository nventoryKeywordRepository;

	/**
	 * method to Fetching InventoryKeyword details by id
	 */
	public InventoryKeywordResponseDTO getInventoryKeywordById(Long id) {
		InventoryKeywordResponseDTO dataRespDTO = new InventoryKeywordResponseDTO();
		try {
			logger.info("Entering getInventoryKeywordById ..");
			Optional<InventoryKeyword> jobOptional = nventoryKeywordRepository.findById(id);
			if (jobOptional.isPresent()) {
				InventoryKeyword data = jobOptional.get();
				BeanUtils.copyProperties(data, dataRespDTO);
				dataRespDTO.setResponseMessage("Inventory Keyword fetch successfully");
			} else {
				logger.error("Inventory Keyword doesn't exist");
				dataRespDTO.setResponseMessage("Inventory Keyword doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch: getInventoryKeywordById of InventoryKeywordServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;
	}

	/**
	 * method which is used to save InventoryKeyword
	 */
	public InventoryKeywordResponseDTO saveInventoryKeyword(InventoryKeywordRequestDTO inventoryKeywordReqDTO) {
		logger.info("Save Inventory Keyword details ..");
		InventoryKeywordResponseDTO dataRespDTO = new InventoryKeywordResponseDTO();
		try {
			InventoryKeyword inventoryKeywordData = inventoryKeywordReqDTO.toModel(inventoryKeywordReqDTO);
			InventoryKeyword inventoryKeywordDataEntity = nventoryKeywordRepository.save(inventoryKeywordData);
			if (inventoryKeywordDataEntity != null) {
				BeanUtils.copyProperties(inventoryKeywordDataEntity, dataRespDTO);
				logger.info("Inventory Keyword saved successfully");
				dataRespDTO.setResponseMessage("Inventory Keyword saved successfully");
			} else {
				dataRespDTO.setResponseMessage("Failed to save Inventory Keyword");
				logger.error("Failed to save Inventory Keyword");
			}
		} catch (Exception e) {
			logger.error("Saving saveInventoryKeyword of InventoryKeywordServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;

	}

	/**
	 * method which is used to update InventoryKeyword
	 * 
	 */
	public InventoryKeywordResponseDTO updateInventoryKeyword(Long id, InventoryKeywordRequestDTO inventoryKeywordReqDTO) {
		logger.info("update Inventory Keyword details ..");
		InventoryKeywordResponseDTO inventoryKeywordDataRespDTO = new InventoryKeywordResponseDTO();
		try {
			Optional<InventoryKeyword> inventoryKeywordOptional = nventoryKeywordRepository.findById(id);
			if (inventoryKeywordOptional.isPresent()) {
				InventoryKeyword inventoryKeyword = inventoryKeywordReqDTO.toModel(inventoryKeywordReqDTO);
				inventoryKeyword.setId(id);
				InventoryKeyword dataEntity = nventoryKeywordRepository.save(inventoryKeyword);
				if (dataEntity != null) {
					BeanUtils.copyProperties(dataEntity, inventoryKeywordDataRespDTO);
					inventoryKeywordDataRespDTO.setResponseMessage("Inventory Keyword updated successfully");
					logger.info("Inventory Keyword updated successfully");
				} else {
					inventoryKeywordDataRespDTO.setResponseMessage("Inventory Keyword updation failed");
					logger.info("Inventory Keyword updation failed");
				}
			} else {
				logger.info("Inventory Keyword doesn't exist");
				inventoryKeywordDataRespDTO.setResponseMessage("Inventory Keyword doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update :updateInventoryKeyword of InventoryKeywordServiceImpl" + e);
			throw e;
		}

		return inventoryKeywordDataRespDTO;
	}

	/**
	 * method which is used to get all Inventory Keyword data
	 */
	public List<InventoryKeywordResponseDTO> findAllInventoryKeyword() {
		logger.info("Fetching all Inventory Keyword data..");
		List<InventoryKeywordResponseDTO> resDTOs = new ArrayList<>();
		List<InventoryKeyword> inventoryKeywordList = nventoryKeywordRepository.findAll();
		for (InventoryKeyword inventoryKeyword : inventoryKeywordList) {
			InventoryKeywordResponseDTO responseDto =new InventoryKeywordResponseDTO();
			BeanUtils.copyProperties(inventoryKeyword, responseDto);
			resDTOs.add(responseDto);
		}
		return resDTOs;
	}

	/**
	 * method which is used to find InventoryKeyword by criteria
	 */
	public List<InventoryKeywordResponseDTO> findInventoryKeywordByCriteria(
			InventoryKeywordRequestDTO jobReqDTO) {
		GenericSpesification<InventoryKeyword> genericSpesification = new GenericSpesification<InventoryKeyword>();
		logger.info("Fetching Inventory Keyword data by criteria ..");
		if (jobReqDTO.getId() != null) {
			genericSpesification.add(new SearchCriteria("id", jobReqDTO.getId(), SearchOperation.EQUAL));
		}
		if (jobReqDTO.getKeyId() != null && !jobReqDTO.getKeyId().isEmpty()) {
			genericSpesification.add(new SearchCriteria("keyId", jobReqDTO.getKeyId(), SearchOperation.MATCH));
		}
		if (jobReqDTO.getItemCode() != null && !jobReqDTO.getItemCode().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("itemCode", jobReqDTO.getItemCode(), SearchOperation.MATCH));
		}
		return nventoryKeywordRepository.findAll(genericSpesification);
	}

	/**
	 * method which is used to delete InventoryKeyword by id
	 */

	public InventoryKeywordResponseDTO deleteInventoryKeywordById(Long id) {
		logger.info("Entering delete InventoryKeyword", id);
		InventoryKeywordResponseDTO dataRespDTO = new InventoryKeywordResponseDTO();
		Optional<InventoryKeyword> dataList = nventoryKeywordRepository.findById(id);
		InventoryKeyword inventoryKeywordData = dataList.get();
		try {
			if (inventoryKeywordData == null) {
				logger.info("The Inventory Keyword doesn't exists!!!");
				dataRespDTO.setResponseMessage("The Inventory Keyword doesn't exists!!!");
			} else {
				nventoryKeywordRepository.delete(inventoryKeywordData);
				dataRespDTO.setResponseMessage(" Inventory Keyword deleted successfully");
			}
			logger.info("Exiting deleteInventoryKeyword");
		} catch (Exception e) {
			logger.error("delete :deleteInventoryKeywordById of InventoryKeywordServiceImpl  " + e);
			throw e;
		}
		return dataRespDTO;
	}
}
