package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.InventoryLibraryStone;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryLibraryStoneRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryLibraryStoneResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryLibraryStoneRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryLibraryStoneService;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
/**
 * Service impl class for InventoryLibraryStone
 * @author AMAL
 *
 */
@Service(value = "InventoryLibraryStoneServiceImpl")
public class InventoryLibraryStoneServiceImpl implements InventoryLibraryStoneService {

	private static final Logger logger = LogManager.getLogger(InventoryLibraryStoneServiceImpl.class);

	@Autowired
	private InventoryLibraryStoneRepository inventoryLibraryStoneRepository;
	/**
	 * method to Fetching InventoryLibraryStone details by id
	 */
	public InventoryLibraryStoneResponseDTO getInventoryLibraryStoneById(Long id) {
		InventoryLibraryStoneResponseDTO dataRespDTO = new InventoryLibraryStoneResponseDTO();
		try {
			logger.info("Entering getInventoryLibraryStoneById ..");
			Optional<InventoryLibraryStone> libSmallStonesOptional = inventoryLibraryStoneRepository.findById(id);
			if (libSmallStonesOptional.isPresent()) {
				InventoryLibraryStone data = libSmallStonesOptional.get();
				BeanUtils.copyProperties(data, dataRespDTO);
				dataRespDTO.setResponseMessage("Inventory library stones  fetched successfully");
			} else {
				logger.error("Inventory library stones doesn't exist");
				dataRespDTO.setResponseMessage("Inventory library stones doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch: getInventoryLibraryStoneById of InventoryLibraryStoneServiceImpl :" + e);
			throw e;
		}
		return dataRespDTO;
	}
	public List<InventoryLibraryStoneResponseDTO> findAllInventoryLibraryStones() {
		logger.info("Entering for fetching all inventory Library small stones data..");
		
		List<InventoryLibraryStoneResponseDTO> invLibSmallStoneResponseList = new ArrayList<InventoryLibraryStoneResponseDTO>();
		try {
			List<InventoryLibraryStone> stoneList = inventoryLibraryStoneRepository.findAll();
			if (stoneList != null && !stoneList.isEmpty()) {
				stoneList.forEach(stoneObj -> {
					InventoryLibraryStoneResponseDTO invLibSmallStoneResponseDTO = new InventoryLibraryStoneResponseDTO();
					BeanUtils.copyProperties(stoneObj, invLibSmallStoneResponseDTO);
					invLibSmallStoneResponseList.add(invLibSmallStoneResponseDTO);
				});
				
			} else {
				InventoryLibraryStoneResponseDTO invLibSmallStoneResponseDTO = new InventoryLibraryStoneResponseDTO();
				invLibSmallStoneResponseDTO.setResponseMessage("Requested Inventory library stone does not exist");
				invLibSmallStoneResponseList.add(invLibSmallStoneResponseDTO);
			}
		} catch (Exception e) {
			logger.error("InventoryLibraryStoneServiceImpl getAll failed" + e);
			throw e;
		}
		logger.info("Exiting getAll in InventoryLibraryStoneServiceImpl  ..");
		return invLibSmallStoneResponseList;
	}
	public InventoryLibraryStoneResponseDTO saveInventoryLibraryStone(
			InventoryLibraryStoneRequestDTO dataReqDTO) {
		logger.info("Save Inventory Library small stones details ..");
		InventoryLibraryStoneResponseDTO dataRespDTO = new InventoryLibraryStoneResponseDTO();
		try {
			InventoryLibraryStone smallStoneData = dataReqDTO.toModel(dataReqDTO);
			InventoryLibraryStone stoneDataEntity = inventoryLibraryStoneRepository.save(smallStoneData);
			if (stoneDataEntity != null) {
				BeanUtils.copyProperties(stoneDataEntity, dataRespDTO);
				logger.info("inventory Library small stones saved successfully");
				dataRespDTO.setResponseMessage("inventory Library small stones saved successfully");
			} else {
				dataRespDTO.setResponseMessage("Failed to save inventory Library small stones");
				logger.error("Failed to save Inventory Library small stones ");
			}
		} catch (Exception e) {
			logger.error("Saving saveInventoryLibraryStone of saveInventoryLibraryStoneServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;

	}
	public InventoryLibraryStoneResponseDTO updateInventoryLibraryStone(Long id,
			InventoryLibraryStoneRequestDTO dataReqDTO) {
		logger.info("update Inventory Library small stones details ..");
		InventoryLibraryStoneResponseDTO invlibSmallStoneDataRespDTO = new InventoryLibraryStoneResponseDTO();
		try {
			Optional<InventoryLibraryStone> smallStonesOptional = inventoryLibraryStoneRepository.findById(id);
			if (smallStonesOptional.isPresent()) {
				InventoryLibraryStone smallStones = dataReqDTO.toModel(dataReqDTO);
				smallStones.setId(id);
				InventoryLibraryStone dataEntity = inventoryLibraryStoneRepository.save(smallStones);
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
			logger.error("Update :updateInventoryLibraryStone of updateInventoryLibraryStoneServiceImpl" + e);
			throw e;
		}

		return invlibSmallStoneDataRespDTO;
	}

	public List<InventoryLibraryStoneResponseDTO> findInventoryLibraryStoneByCriteria(
			InventoryLibraryStoneRequestDTO dataReqDTO) throws Exception {
		logger.info("Entering For fetching all Inventory Library small stones");
		List<InventoryLibraryStoneResponseDTO> invLibSmallStoneResponseDTOList = new ArrayList<InventoryLibraryStoneResponseDTO>();
		
		try {
			List<InventoryLibraryStone> stoneList = findByCriteria(dataReqDTO);
			if (stoneList != null && !stoneList.isEmpty()) {
				stoneList.stream().forEach((stoneObj) -> {
					InventoryLibraryStoneResponseDTO invLibSmallStoneResponseDTO = new InventoryLibraryStoneResponseDTO();
					BeanUtils.copyProperties(stoneObj, invLibSmallStoneResponseDTO);
					invLibSmallStoneResponseDTOList.add(invLibSmallStoneResponseDTO);
				});
			} else {
				InventoryLibraryStoneResponseDTO invLibSmallStoneResponseDTO = new InventoryLibraryStoneResponseDTO();
				logger.info("Inventory library stone not found");
				invLibSmallStoneResponseDTO.setResponseMessage("Inventory library stone not found");
				invLibSmallStoneResponseDTOList.add(invLibSmallStoneResponseDTO);
			}
		} catch (Exception e) {
			logger.error("InventoryLibraryStoneImpl  findInventoryLibraryStoneByCriteria failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all Inventory library stones");
		return invLibSmallStoneResponseDTOList;
	}

	public InventoryLibraryStoneResponseDTO deleteInventoryLibraryStoneById(Long id) {
		logger.info("Entering delete InventoryLibraryStone", id);
		InventoryLibraryStoneResponseDTO dataRespDTO = new InventoryLibraryStoneResponseDTO();
	
		try {
			Optional<InventoryLibraryStone> dataList = inventoryLibraryStoneRepository.findById(id);
			if(dataList.isPresent()){
			InventoryLibraryStone stoneData = dataList.get();
			inventoryLibraryStoneRepository.delete(stoneData);
			dataRespDTO.setResponseMessage("  Inventory library stone deleted successfully");
			} else {
				logger.info("The Inventory library stone doesn't exists!!!");
				dataRespDTO.setResponseMessage("The Inventory library stone doesn't exists!!!");
			}
			logger.info("Exiting deleteInventoryLibraryStone");
		} catch (Exception e) {
			logger.error("delete :InventoryLibraryStone of InventoryLibraryStoneServiceImpl  " + e);
			throw e;
		}
		return dataRespDTO;
	}
	/**
	 * Crtieria builder for fetching InventoryLibraryStone
	 * 
	 * @param InventoryLibraryStoneRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<InventoryLibraryStone> findByCriteria(InventoryLibraryStoneRequestDTO stoneRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for InventoryLibraryStone ");

		GenericSpesification<InventoryLibraryStone> genericSpesification = new GenericSpesification<InventoryLibraryStone>();
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

			return inventoryLibraryStoneRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("InventoryLibraryStone findByCriteria failed" + e);
			throw e;
		}

	}

}
