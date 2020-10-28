package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CodeClasp;
import com.bourntec.apmg.entity.InventoryFindings;
import com.bourntec.apmg.entity.InventorySummary;
import com.bourntec.apmg.entity.VendorItemMatch;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryFindingsRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventorySummaryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.VendorItemMatchRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodeClaspResponsetDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryFindingsResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventorySummaryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryFindingsRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventorySummaryRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryFindingsService;
import com.bourntec.apmg.inventorymanagement.v1.service.InventorySummaryService;
/**
 * 
 * @author Babu
 *
 */
@Service
public class InventorySummaryServiceImpl implements InventorySummaryService {
	private static final Logger logger = LogManager.getLogger(InventorySummaryServiceImpl.class);

	@Autowired
	InventorySummaryRepository inventorySummaryRepository;

	/**
	 * 
	 * @param itemCode
	 * @return ResponseEntity<InventorySummaryResponseDTO>
	 */
	@Override
	public InventorySummaryResponseDTO getItemSummary(String itemCode) throws Exception {
		InventorySummaryResponseDTO inventorySummaryResponseDTO = new InventorySummaryResponseDTO();
		try {
			InventorySummary inventorySummary = inventorySummaryRepository.findByItemCode(itemCode);
			BeanUtils.copyProperties(inventorySummary, inventorySummaryResponseDTO);
		} catch (Exception e) {
			logger.error("Item Summary got an error: " + e.getMessage());

		}
		return inventorySummaryResponseDTO;
	}

	@Override
	public InventorySummaryResponseDTO saveSummary(InventorySummaryRequestDTO invReqDTO) throws Exception {
		InventorySummaryResponseDTO inventorySummaryResponseDTO = new InventorySummaryResponseDTO();
		try {
			InventorySummary inventorySummary = invReqDTO.toModel(invReqDTO);
			InventorySummary inventorySummaryObj = inventorySummaryRepository.save(inventorySummary);
			logger.info(" saveSummary( Data saved successfully");

			BeanUtils.copyProperties(inventorySummaryObj, inventorySummaryResponseDTO);
		} catch (Exception e) {
			logger.error("Save: saveSummary " + e);
			throw e;
		}
		return inventorySummaryResponseDTO;
		}

	@Override
	public InventorySummaryResponseDTO updateSummary(InventorySummaryRequestDTO invReqDTO, String itemCode)
			throws Exception {
		InventorySummaryResponseDTO inventorySummaryResponseDTO = new InventorySummaryResponseDTO();

		InventorySummary inventorySummary = inventorySummaryRepository.findByItemCode(itemCode);
		inventorySummaryRepository.delete(inventorySummary);
		return inventorySummaryResponseDTO = saveSummary(invReqDTO);
	}
	
	}



