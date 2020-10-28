package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.InventoryMarket;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryMarketRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryMarketResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryMarketRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryMarketService;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
/**
 * Service impl class for InventoryMarket
 * @author Nince
 *
 */
@Service(value = "InventoryMarketServiceImpl")
public class InventoryMarketServiceImpl implements InventoryMarketService {

	private static final Logger logger = LogManager.getLogger(InventoryMarketServiceImpl.class);

	@Autowired
	private InventoryMarketRepository inventoryMarketRepository;

	/**
	 * method to Fetching InventoryMarket details by id
	 */
	public InventoryMarketResponseDTO getInventoryMarketById(Long id) {
		InventoryMarketResponseDTO dataRespDTO = new InventoryMarketResponseDTO();
		try {
			logger.info("Entering getInventoryMarketById ..");
			Optional<InventoryMarket> jobOptional = inventoryMarketRepository.findById(id);
			if (jobOptional.isPresent()) {
				InventoryMarket data = jobOptional.get();
				BeanUtils.copyProperties(data, dataRespDTO);
				dataRespDTO.setResponseMessage("Inventory Market fetch successfully");
			} else {
				logger.error("Inventory Market doesn't exist");
				dataRespDTO.setResponseMessage("Inventory Market doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch: getInventoryMarketById of InventoryMarketServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;
	}

	/**
	 * method which is used to save InventoryMarket
	 */
	public InventoryMarketResponseDTO saveInventoryMarket(InventoryMarketRequestDTO inventoryMarketReqDTO) {
		logger.info("Save Inventory Market details ..");
		InventoryMarketResponseDTO dataRespDTO = new InventoryMarketResponseDTO();
		try {
			InventoryMarket inventoryMarketData = inventoryMarketReqDTO.toModel(inventoryMarketReqDTO);
			InventoryMarket inventoryMarketDataEntity = inventoryMarketRepository.save(inventoryMarketData);
			if (inventoryMarketDataEntity != null) {
				BeanUtils.copyProperties(inventoryMarketDataEntity, dataRespDTO);
				logger.info("Inventory Market saved successfully");
				dataRespDTO.setResponseMessage("Inventory Market saved successfully");
			} else {
				dataRespDTO.setResponseMessage("Failed to save Inventory Market");
				logger.error("Failed to save Inventory Market");
			}
		} catch (Exception e) {
			logger.error("Saving saveInventoryMarket of InventoryMarketServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;

	}

	/**
	 * method which is used to update InventoryMarket
	 * 
	 */
	public InventoryMarketResponseDTO updateInventoryMarket(Long id, InventoryMarketRequestDTO inventoryMarketReqDTO) {
		logger.info("update Inventory Market details ..");
		InventoryMarketResponseDTO inventoryMarketDataRespDTO = new InventoryMarketResponseDTO();
		try {
			Optional<InventoryMarket> inventoryMarketOptional = inventoryMarketRepository.findById(id);
			if (inventoryMarketOptional.isPresent()) {
				InventoryMarket inventoryMarket = inventoryMarketReqDTO.toModel(inventoryMarketReqDTO);
				inventoryMarket.setId(id);
				InventoryMarket dataEntity = inventoryMarketRepository.save(inventoryMarket);
				if (dataEntity != null) {
					BeanUtils.copyProperties(dataEntity, inventoryMarketDataRespDTO);
					inventoryMarketDataRespDTO.setResponseMessage("Inventory Market updated successfully");
					logger.info("Inventory Market updated successfully");
				} else {
					inventoryMarketDataRespDTO.setResponseMessage("Inventory Market updation failed");
					logger.info("Inventory Market updation failed");
				}
			} else {
				logger.info("Inventory Market doesn't exist");
				inventoryMarketDataRespDTO.setResponseMessage("Inventory Market doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update :updateInventoryMarket of InventoryMarketServiceImpl" + e);
			throw e;
		}

		return inventoryMarketDataRespDTO;
	}

	/**
	 * method which is used to get all Inventory Market data
	 */
	public List<InventoryMarketResponseDTO> findAllInventoryMarket() {
		logger.info("Fetching all Inventory Market data..");
		List<InventoryMarketResponseDTO> resDTOs = new ArrayList<>();
		List<InventoryMarket> inventoryMarketList = inventoryMarketRepository.findAll();
		for (InventoryMarket inventoryMarket : inventoryMarketList) {
			InventoryMarketResponseDTO responseDto =new InventoryMarketResponseDTO();
			BeanUtils.copyProperties(inventoryMarket, responseDto);
			resDTOs.add(responseDto);
		}
		return resDTOs;
	}

	/**
	 * method which is used to find InventoryMarket by criteria
	 */
	public List<InventoryMarketResponseDTO> findInventoryMarketByCriteria(
			InventoryMarketRequestDTO jobReqDTO) {
		GenericSpesification<InventoryMarket> genericSpesification = new GenericSpesification<InventoryMarket>();
		logger.info("Fetching Inventory Market data by criteria ..");
		if (jobReqDTO.getId() != null) {
			genericSpesification.add(new SearchCriteria("id", jobReqDTO.getId(), SearchOperation.EQUAL));
		}
		if (jobReqDTO.getMarketCode() != null && !jobReqDTO.getMarketCode().isEmpty()) {
			genericSpesification.add(new SearchCriteria("marketCode", jobReqDTO.getMarketCode(), SearchOperation.MATCH));
		}
		if (jobReqDTO.getItemCode() != null && !jobReqDTO.getItemCode().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("itemCode", jobReqDTO.getItemCode(), SearchOperation.MATCH));
		}
		if (jobReqDTO.getLocationCode() != null && !jobReqDTO.getLocationCode().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("locationCode", jobReqDTO.getLocationCode(), SearchOperation.MATCH));
		}
		return inventoryMarketRepository.findAll(genericSpesification);
	}

	/**
	 * method which is used to delete InventoryMarket by id
	 */

	public InventoryMarketResponseDTO deleteInventoryMarketById(Long id) {
		logger.info("Entering delete InventoryMarket", id);
		InventoryMarketResponseDTO dataRespDTO = new InventoryMarketResponseDTO();
		Optional<InventoryMarket> dataList = inventoryMarketRepository.findById(id);
		InventoryMarket inventoryMarketData = dataList.get();
		try {
			if (inventoryMarketData == null) {
				logger.info("The Inventory Market doesn't exists!!!");
				dataRespDTO.setResponseMessage("The Inventory Market doesn't exists!!!");
			} else {
				inventoryMarketRepository.delete(inventoryMarketData);
				dataRespDTO.setResponseMessage(" Inventory Market deleted successfully");
			}
			logger.info("Exiting deleteInventoryMarket");
		} catch (Exception e) {
			logger.error("delete :deleteInventoryMarketById of InventoryMarketServiceImpl  " + e);
			throw e;
		}
		return dataRespDTO;
	}
}
