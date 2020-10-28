package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.InventoryLibrarySmallStone;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryLibrarySmallStoneRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryLibrarySmallStoneResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryLibrarySmallStoneRepository;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryLibrarySmallStoneService;
/**
 * Service impl class for InventoryLibrarySmallStone
 * @author AMAL
 *
 */
@Service(value = "InventoryLibrarySmallStoneServiceImpl")
public class InventoryLibrarySmallStoneServiceImpl implements InventoryLibrarySmallStoneService {

	private static final Logger logger = LogManager.getLogger(InventoryLibrarySmallStoneServiceImpl.class);

	@Autowired
	private InventoryLibrarySmallStoneRepository inventoryLibrarySmallStoneRepository;
	/**
	 * method to Fetching InventoryLibrarySmallStone details by id
	 */
	public InventoryLibrarySmallStoneResponseDTO getInventoryLibrarySmallStoneById(Long id) {
		InventoryLibrarySmallStoneResponseDTO dataRespDTO = new InventoryLibrarySmallStoneResponseDTO();
		try {
			logger.info("Entering getInventoryLibrarySmallStoneById ..");
			Optional<InventoryLibrarySmallStone> libSmallStonesOptional = inventoryLibrarySmallStoneRepository.findById(id);
			if (libSmallStonesOptional.isPresent()) {
				InventoryLibrarySmallStone data = libSmallStonesOptional.get();
				BeanUtils.copyProperties(data, dataRespDTO);
				dataRespDTO.setResponseMessage("Inventory library small stones  fetched successfully");
			} else {
				logger.error("Inventory library small stones doesn't exist");
				dataRespDTO.setResponseMessage("Inventory library small stones doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch: getInventoryLibrarySmallStoneById of InventoryLibrarySmallStoneServiceImpl :" + e);
			throw e;
		}
		return dataRespDTO;
	}
	public List<InventoryLibrarySmallStoneResponseDTO> findAllInventoryLibrarySmallStones() {
		logger.info("Entering for fetching all inventory Library small stones data..");
		
		List<InventoryLibrarySmallStoneResponseDTO> invLibSmallStoneResponseList = new ArrayList<InventoryLibrarySmallStoneResponseDTO>();
		try {
			List<InventoryLibrarySmallStone> stoneList = inventoryLibrarySmallStoneRepository.findAll();
			if (stoneList != null && !stoneList.isEmpty()) {
				stoneList.forEach(stoneObj -> {
					InventoryLibrarySmallStoneResponseDTO invLibSmallStoneResponseDTO = new InventoryLibrarySmallStoneResponseDTO();
					BeanUtils.copyProperties(stoneObj, invLibSmallStoneResponseDTO);
					invLibSmallStoneResponseList.add(invLibSmallStoneResponseDTO);
				});
				
			} else {
				InventoryLibrarySmallStoneResponseDTO invLibSmallStoneResponseDTO = new InventoryLibrarySmallStoneResponseDTO();
				invLibSmallStoneResponseDTO.setResponseMessage("Requested Inventory library small stone does not exist");
				invLibSmallStoneResponseList.add(invLibSmallStoneResponseDTO);
			}
		} catch (Exception e) {
			logger.error("InventoryLibrarySmallStoneServiceImpl getAll failed" + e);
			throw e;
		}
		logger.info("Exiting getAll in InventoryLibrarySmallStoneServiceImpl  ..");
		return invLibSmallStoneResponseList;
	}
	public InventoryLibrarySmallStoneResponseDTO saveInventoryLibrarySmallStone(
			InventoryLibrarySmallStoneRequestDTO dataReqDTO) {
		logger.info("Save Inventory Library small stones details ..");
		InventoryLibrarySmallStoneResponseDTO dataRespDTO = new InventoryLibrarySmallStoneResponseDTO();
		try {
			InventoryLibrarySmallStone smallStoneData = dataReqDTO.toModel(dataReqDTO);
			InventoryLibrarySmallStone stoneDataEntity = inventoryLibrarySmallStoneRepository.save(smallStoneData);
			if (stoneDataEntity != null) {
				BeanUtils.copyProperties(stoneDataEntity, dataRespDTO);
				logger.info("inventory Library small stones saved successfully");
				dataRespDTO.setResponseMessage("inventory Library small stones saved successfully");
			} else {
				dataRespDTO.setResponseMessage("Failed to save inventory Library small stones");
				logger.error("Failed to save Inventory Library small stones ");
			}
		} catch (Exception e) {
			logger.error("Saving saveInventoryLibrarySmallStone of saveInventoryLibrarySmallStoneServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;

	}
	public InventoryLibrarySmallStoneResponseDTO updateInventoryLibrarySmallStone(Long id,
			InventoryLibrarySmallStoneRequestDTO dataReqDTO) {
		logger.info("update Inventory Library small stones details ..");
		InventoryLibrarySmallStoneResponseDTO invlibSmallStoneDataRespDTO = new InventoryLibrarySmallStoneResponseDTO();
		try {
			Optional<InventoryLibrarySmallStone> smallStonesOptional = inventoryLibrarySmallStoneRepository.findById(id);
			if (smallStonesOptional.isPresent()) {
				InventoryLibrarySmallStone smallStones = dataReqDTO.toModel(dataReqDTO);
				smallStones.setId(id);
				InventoryLibrarySmallStone dataEntity = inventoryLibrarySmallStoneRepository.save(smallStones);
				if (dataEntity != null) {
					BeanUtils.copyProperties(dataEntity, invlibSmallStoneDataRespDTO);
					invlibSmallStoneDataRespDTO.setResponseMessage("Inventory Library small stones updated successfully");
					logger.info("Inventory Library small stones updated successfully");
				} else {
					invlibSmallStoneDataRespDTO.setResponseMessage("Inventory Library small stones updation failed");
					logger.info("Inventory Library small stones updation failed");
				}
			} else {
				logger.info("Inventory Library small stones doesn't exist");
				invlibSmallStoneDataRespDTO.setResponseMessage("Inventory Library small stones doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update :updateInventoryLibrarySmallStone of updateInventoryLibrarySmallStoneServiceImpl" + e);
			throw e;
		}

		return invlibSmallStoneDataRespDTO;
	}

	public List<InventoryLibrarySmallStoneResponseDTO> findInventoryLibrarySmallStoneByCriteria(
			InventoryLibrarySmallStoneRequestDTO dataReqDTO) throws Exception {
		logger.info("Entering For fetching all Inventory Library small stones");
		List<InventoryLibrarySmallStoneResponseDTO> invLibSmallStoneResponseDTOList = new ArrayList<InventoryLibrarySmallStoneResponseDTO>();
		
		try {
			List<InventoryLibrarySmallStone> stoneList = findByCriteria(dataReqDTO);
			if (stoneList != null && !stoneList.isEmpty()) {
				stoneList.stream().forEach((stoneObj) -> {
					InventoryLibrarySmallStoneResponseDTO invLibSmallStoneResponseDTO = new InventoryLibrarySmallStoneResponseDTO();
					BeanUtils.copyProperties(stoneObj, invLibSmallStoneResponseDTO);
					invLibSmallStoneResponseDTOList.add(invLibSmallStoneResponseDTO);
				});
			} else {
				InventoryLibrarySmallStoneResponseDTO invLibSmallStoneResponseDTO = new InventoryLibrarySmallStoneResponseDTO();
				logger.info("Inventory library small stone not found");
				invLibSmallStoneResponseDTO.setResponseMessage("Inventory library small stone not found");
				invLibSmallStoneResponseDTOList.add(invLibSmallStoneResponseDTO);
			}
		} catch (Exception e) {
			logger.error("InventoryLibrarySmallStoneImpl  findInventoryLibrarySmallStoneByCriteria failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all Inventory library small stones");
		return invLibSmallStoneResponseDTOList;
	}

	public InventoryLibrarySmallStoneResponseDTO deleteInventoryLibrarySmallStoneById(Long id) {
		logger.info("Entering delete InventoryLibrarySmallStone", id);
		InventoryLibrarySmallStoneResponseDTO dataRespDTO = new InventoryLibrarySmallStoneResponseDTO();
	
		try {
			Optional<InventoryLibrarySmallStone> dataList = inventoryLibrarySmallStoneRepository.findById(id);
			if(dataList.isPresent()){
			InventoryLibrarySmallStone stoneData = dataList.get();
			inventoryLibrarySmallStoneRepository.delete(stoneData);
			dataRespDTO.setResponseMessage("  Inventory library small stone deleted successfully");
			} else {
				logger.info("The Inventory library small stone doesn't exists!!!");
				dataRespDTO.setResponseMessage("The Inventory library small stone doesn't exists!!!");
			}
			logger.info("Exiting deleteInventoryLibrarySmallStone");
		} catch (Exception e) {
			logger.error("delete :InventoryLibrarySmallStone of InventoryLibrarySmallStoneServiceImpl  " + e);
			throw e;
		}
		return dataRespDTO;
	}

	
	
	/**
	 * Crtieria builder for fetching InventoryLibrarySmallStone
	 * 
	 * @param InventoryLibrarySmallStoneRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<InventoryLibrarySmallStone> findByCriteria(InventoryLibrarySmallStoneRequestDTO stoneRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for InventoryLibrarySmallStone ");

		GenericSpesification<InventoryLibrarySmallStone> genericSpesification = new GenericSpesification<InventoryLibrarySmallStone>();
		try {
			if (stoneRequestDTO.getId() != null) {
				genericSpesification.add(new SearchCriteria("id", stoneRequestDTO.getId(), SearchOperation.EQUAL));
			}
			if (stoneRequestDTO.getItemCode() != null && !stoneRequestDTO.getItemCode().isEmpty()) {
				genericSpesification.add(new SearchCriteria("itemCode", stoneRequestDTO.getItemCode(), SearchOperation.EQUAL));
			}
			if (stoneRequestDTO.getLibraryId() != null && stoneRequestDTO.getLibraryId()>0) {
				genericSpesification
						.add(new SearchCriteria("libraryId", stoneRequestDTO.getLibraryId(), SearchOperation.EQUAL));
			}
			if (stoneRequestDTO.getPieces() != null && stoneRequestDTO.getPieces()>0) {
				genericSpesification
						.add(new SearchCriteria("pieces", stoneRequestDTO.getPieces(), SearchOperation.EQUAL));
			}

			return inventoryLibrarySmallStoneRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("InventoryLibrarySmallStone findByCriteria failed" + e);
			throw e;
		}

	}
}
