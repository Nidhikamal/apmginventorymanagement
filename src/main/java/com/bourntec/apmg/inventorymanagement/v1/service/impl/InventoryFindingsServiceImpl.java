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

import com.bourntec.apmg.entity.InventoryFindings;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryFindingsRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryFindingsResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryFindingsRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryFindingsService;

@Service
public class InventoryFindingsServiceImpl implements InventoryFindingsService {
	private static final Logger logger = LogManager.getLogger(InventoryFindingsServiceImpl.class);

	@Autowired
	InventoryFindingsRepository inventoryFindingsRepository;

	/**
	 * AP-130 - > AP-238 Inventory Edit unit of measure finished jewelry -findings
	 * Method for list all finding of corresponding item
	 * 
	 * @param itemCode
	 * @return ResponseEntity<InventoryFindingsResponseDTO>
	 */
	@Override
	public List<InventoryFindingsResponseDTO> getItemFindings(String itemCode) throws Exception {
		List<InventoryFindingsResponseDTO> findingsResponseDTOList = new ArrayList<InventoryFindingsResponseDTO>();
		try {
			List<InventoryFindings> inventoryFindingsList = getInvItem(itemCode);
			inventoryFindingsList.stream().forEach((findings) -> {
				InventoryFindingsResponseDTO findingsResponseDTO = new InventoryFindingsResponseDTO();
				BeanUtils.copyProperties(findings, findingsResponseDTO);
				findingsResponseDTOList.add(findingsResponseDTO);
			});
		} catch (Exception e) {
			logger.error("Item Finding got an error: " + e.getMessage());

		}
		return findingsResponseDTOList;
	}

	private List<InventoryFindings> getInvItem(String itemCode) {
		InventoryFindings findingObj = new InventoryFindings();
		findingObj.setItemCode(itemCode);

		return inventoryFindingsRepository.findAll(Example.of(findingObj));
	}

	/**
	 * @author Srijini Save item findings 1. delete all findings of an item 2. save
	 *         item findings
	 */
	/**
	 * @author Srijini Save item findings 1. delete all findings of an item 2. save
	 *         item findings
	 */
	@Override
	@Transactional
	@Modifying
	public List<InventoryFindingsResponseDTO> saveFindings(List<InventoryFindingsRequestDTO> invReqDTOList)
			throws Exception {
		List<InventoryFindingsResponseDTO> findingsResponseDTOList = new ArrayList<InventoryFindingsResponseDTO>();
		try {
			if (invReqDTOList != null && !invReqDTOList.isEmpty()) {
				final String item = invReqDTOList.get(0).getItemCode();
				List<InventoryFindings> inventoryFindingsList = getInvItem(item);
				inventoryFindingsRepository.deleteAll(inventoryFindingsList);
				inventoryFindingsList = getFindingItem(invReqDTOList);
				List<InventoryFindings> findingList = inventoryFindingsRepository.saveAll(inventoryFindingsList);

				findingList.stream().forEach((findings) -> {
					InventoryFindingsResponseDTO findingsResponseDTO = new InventoryFindingsResponseDTO();
					BeanUtils.copyProperties(findings, findingsResponseDTO);
					findingsResponseDTO.setResponseMessage("Record : " + item + " updated successfully");// update
																											// currect
																											// msg
					findingsResponseDTOList.add(findingsResponseDTO);
				});

			} else {
				throw new ResourceNotFoundException(ErrorCodes.ITEM_NOT_FOUND.getMessage());
			}

		} catch (IllegalArgumentException e) {
			logger.error("Finding got an error: " + e.getMessage());
		}
		return findingsResponseDTOList;
	}

	private List<InventoryFindings> getFindingItem(List<InventoryFindingsRequestDTO> invReqDTOList) {
		List<InventoryFindings> inventoryFindings = new ArrayList<InventoryFindings>();
		try {
			invReqDTOList.forEach(finding -> {
				InventoryFindings findings = finding.toModel(finding);

				inventoryFindings.add(findings);
			});
		} catch (Exception e) {
			logger.error("Exception while saving Finding : " + e.getMessage());
		}
		return inventoryFindings;
	}
}
