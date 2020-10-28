package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CodesShapes;
import com.bourntec.apmg.entity.InventoryRank;
import com.bourntec.apmg.entity.InventoryStockHistory;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryRankRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryStockHistoryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesShapeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryRankResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryStockHistoryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryRankRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryStockHistoryRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryRankService;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryStockHistoryService;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation 
 * 
 * @author Babu
 *
 */
@Service(value = "InventoryStockHistoryServiceImpl")
public class InventoryStockHistoryServiceImpl implements InventoryStockHistoryService {

	private static final Logger logger = LogManager.getLogger(InventoryStockHistoryServiceImpl.class);

	@Autowired
	private InventoryStockHistoryRepository invRepo;

	/**
	 * @author Babu
	 */

	public InventoryStockHistoryResponseDTO findInventoryStockHistoryById(String id)  throws Exception{
		InventoryStockHistoryResponseDTO invRespDTO = new InventoryStockHistoryResponseDTO();
		try {
			Optional<InventoryStockHistory> invOptional = invRepo.findById(id);
			if (invOptional.isPresent()) {
				InventoryStockHistory invCharge = invOptional.get();
				BeanUtils.copyProperties(invCharge, invRespDTO);
			} else {
				logger.error(" Inventory Stocks doesn't exist");
				invRespDTO.setResponseMessage("Inventory Stocks not found");
			}
		} catch (Exception e) {
			logger.error("Fetch Inventory Stock " + e);
			throw e;
		}

		return invRespDTO;
	}

	/**
	 * @author Babu
	 */
	public List<InventoryStockHistory> findAllInventoryStockHistory()  throws Exception{
		return invRepo.findAll();
	}

	/**
	 * @author Babu
	 */

	public InventoryStockHistoryResponseDTO updateInventoryStockHistory(String id, InventoryStockHistoryRequestDTO invReqDTO)  throws Exception{
		InventoryStockHistoryResponseDTO invResDTO = new InventoryStockHistoryResponseDTO();
		try {
			Optional<InventoryStockHistory> invCatOptional = invRepo.findById(id);
			if (invCatOptional.isPresent()) {
				InventoryStockHistory inv = invReqDTO.toModel(invReqDTO);
				inv.setId(Long.valueOf(id));
				InventoryStockHistory typeDataEntity = invRepo.save(inv);
				if (typeDataEntity != null) {
					BeanUtils.copyProperties(typeDataEntity, invResDTO);
					logger.info(" Inventory Stock updated successfully");
				} else {
					logger.error("Inventory Stock updation failed");
				}
			} else {
				logger.error(" Inventory Stock doesn't exist");
				invResDTO.setResponseMessage("Inventory Stock doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update: updateInvStockById " + e);
			throw e;
		}

		return invResDTO;
	}

	/**
	 * @author Babu
	 */

	public InventoryStockHistoryResponseDTO saveInventoryStockHistory(InventoryStockHistoryRequestDTO invReqDTO)  throws Exception{
		InventoryStockHistoryResponseDTO invRespDTO = new InventoryStockHistoryResponseDTO();
		try {
			InventoryStockHistory inv = invReqDTO.toModel(invReqDTO);
			InventoryStockHistory invEntity = invRepo.save(inv);
			if (invEntity != null) {
				BeanUtils.copyProperties(invEntity, invRespDTO);
				logger.info("Inventory Stock saved successfully");
			} else {
				logger.error("Failed to Stock Inventory save ");
			}
		} catch (Exception e) {
			logger.error("Save: saveInvStocks " + e);
			throw e;
		}

		return invRespDTO;
	}

	@Override
	public InventoryStockHistoryResponseDTO delete(String id) throws Exception {
		invRepo.deleteById(id);
		InventoryStockHistoryResponseDTO responseDTO =new InventoryStockHistoryResponseDTO();
		responseDTO.setResponseMessage("Deleted Successfully");
		 return responseDTO;
	}

	@Override
	public List<InventoryStockHistory> search(InventoryStockHistoryRequestDTO requestDTO) throws Exception {
GenericSpesification<InventoryStockHistory> genericSpesification = new GenericSpesification<InventoryStockHistory>();
		
		if(requestDTO.getItemCode()!=null) {
			 genericSpesification.add(new SearchCriteria("itemCode",requestDTO.getItemCode(), SearchOperation.MATCH));
			}
			if(requestDTO.getId()!=null) {
	        genericSpesification.add(new SearchCriteria("id",requestDTO.getId(), SearchOperation.EQUAL));
			}
			
		
		 return invRepo.findAll(genericSpesification);
	}

}
