package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.InventoryMaterialsUsed;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryMaterialsRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryMaterialsResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryMaterialsUsedRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryMaterialsUsedService;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;

/**
 * 
 * Service class implementation for InventoryMaterialsUsedServiceImpl
 * 
 * @author Srijini
 *
 */
@Service(value = "InventoryMaterialsUsedServiceImpl")
public class InventoryMaterialsUsedServiceImpl implements InventoryMaterialsUsedService {

	private static final Logger logger = LogManager.getLogger(InventoryMaterialsUsedServiceImpl.class);

	@Autowired
	private InventoryMaterialsUsedRepository inventoryMaterialsUsedRepository;

	@Override
	public InventoryMaterialsResponseDTO saveMamaterial(List<InventoryMaterialsRequestDTO> lstvendorItemMatchRequestDTO)
			throws Exception {

		InventoryMaterialsResponseDTO vendorItemMatchResponseDTO = new InventoryMaterialsResponseDTO();
		try {
			for (InventoryMaterialsRequestDTO vendorItemMatchRequestDTO : lstvendorItemMatchRequestDTO) {
				if (vendorItemMatchRequestDTO.getItemCode() != null) {
					InventoryMaterialsUsed vendorItemMatch = vendorItemMatchRequestDTO.toModel(vendorItemMatchRequestDTO);
					// vendorItemMatch.setItemCode(itemCode);/// hard coded
					InventoryMaterialsUsed vendorItemMatchEntity = inventoryMaterialsUsedRepository.save(vendorItemMatch);
					if (vendorItemMatchEntity != null) {
						BeanUtils.copyProperties(vendorItemMatchEntity, vendorItemMatchResponseDTO);
						vendorItemMatchResponseDTO.setResponseMessage("InventoryMaterials saved successfully .");
						logger.info(" InventoryMaterials saved successfully");// vendor no chk

					} else {
						logger.error("Failed to save InventoryMaterials  ");
					}
				}
			}
		} catch (Exception e) {
			logger.error("Save: InventoryMaterials error " + e);
			throw e;
		}

		return vendorItemMatchResponseDTO;
	}

	@Override
	public InventoryMaterialsResponseDTO updateInventoryMaterials(
			List<InventoryMaterialsRequestDTO> lstinventoryMaterialsRequestDTO, String itemCode) throws Exception {
		
		List<InventoryMaterialsUsed> inventoryMatList = fetchAllInventoryMaterialsUsedByItemcode(itemCode);
		inventoryMaterialsUsedRepository.deleteAll(inventoryMatList);
		InventoryMaterialsResponseDTO inventoryMaterialsResponseDTO=saveMamaterial(lstinventoryMaterialsRequestDTO);// update materials
		if (inventoryMaterialsResponseDTO != null) {
			inventoryMaterialsResponseDTO.setResponseMessage("InventoryMaterials updated successfully.");
		} else {
			inventoryMaterialsResponseDTO.setResponseMessage("InventoryMaterials Match not updated .");

		}
		return inventoryMaterialsResponseDTO;
		
	}

	@Override
	public List<InventoryMaterialsUsed> fetchAllInventoryMaterialsUsedByItemcode(String itemCode) {
		return inventoryMaterialsUsedRepository.findByItemCode(itemCode);
	}
	
	
	@Override
	public InventoryMaterialsResponseDTO delete(Long id) throws Exception {
		logger.info("Entering deleteInventoryMaterialsUsed  {}", id);
		InventoryMaterialsResponseDTO materialResponseDTO = new InventoryMaterialsResponseDTO();
		try {
			Optional<InventoryMaterialsUsed> materialesList = inventoryMaterialsUsedRepository.findById(id);
			if(materialesList.isPresent()) {
				InventoryMaterialsUsed materialObj = materialesList.get();
				inventoryMaterialsUsedRepository.delete(materialObj);
				materialResponseDTO.setResponseMessage("Inventory Materials Used deleted");
			} else {
				throw new ResourceNotFoundException("Inventory Materials Used Exists");
			}
			
			logger.info("Exiting deleteInventoryMaterialsUsed");
		} 
		catch (Exception e) {
			logger.error("InventoryMaterialsUsedServiceImpl deleteInventoryMaterialsUsed failed" + e);
			throw e;
		}
		return materialResponseDTO;
	}
}
