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
import com.bourntec.apmg.entity.InventoryStoneVariant;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryLibraryStoneRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryStoneVariantRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryStoneVariantResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryStoneVariantRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryStoneVariantService;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
/**
 * Service impl class for InventoryStoneVariant
 * @author AMAL
 *
 */
@Service(value = "InventoryStoneVariantServiceImpl")
public class InventoryStoneVariantServiceImpl implements InventoryStoneVariantService {

	private static final Logger logger = LogManager.getLogger(InventoryStoneVariantServiceImpl.class);

	@Autowired
	private InventoryStoneVariantRepository inventoryStoneVariantRepository;
	/**
	 * method to Fetching InventoryStoneVariant details by id
	 */
	public InventoryStoneVariantResponseDTO getInventoryStoneVariantById(Long id) {
		InventoryStoneVariantResponseDTO dataRespDTO = new InventoryStoneVariantResponseDTO();
		try {
			logger.info("Entering getInventoryStoneVariantById ..");
			Optional<InventoryStoneVariant> invStoneVariantOptional = inventoryStoneVariantRepository.findById(id);
			if (invStoneVariantOptional.isPresent()) {
				InventoryStoneVariant data = invStoneVariantOptional.get();
				BeanUtils.copyProperties(data, dataRespDTO);
				dataRespDTO.setResponseMessage("Inventory Stone Variants  fetched successfully");
			} else {
				logger.error("Inventory Stone Variants doesn't exist");
				dataRespDTO.setResponseMessage("Inventory Stone Variants doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch: getInventoryStoneVariantById of InventoryStoneVariantServiceImpl :" + e);
			throw e;
		}
		return dataRespDTO;
	}
	public List<InventoryStoneVariantResponseDTO> findAllInventoryStoneVariants() {
		logger.info("Entering for fetching all Inventory Stone Variants data..");
		
		List<InventoryStoneVariantResponseDTO> invStoneVariantResponseList = new ArrayList<InventoryStoneVariantResponseDTO>();
		try {
			List<InventoryStoneVariant> stoneList = inventoryStoneVariantRepository.findAll();
			if (stoneList != null && !stoneList.isEmpty()) {
				stoneList.forEach(stoneObj -> {
					InventoryStoneVariantResponseDTO invStoneVariantResponseDTO = new InventoryStoneVariantResponseDTO();
					BeanUtils.copyProperties(stoneObj, invStoneVariantResponseDTO);
					invStoneVariantResponseList.add(invStoneVariantResponseDTO);
				});
				
			} else {
				InventoryStoneVariantResponseDTO invStoneVariantResponseDTO = new InventoryStoneVariantResponseDTO();
				invStoneVariantResponseDTO.setResponseMessage("Requested Inventory Stone Variants does not exist");
				invStoneVariantResponseList.add(invStoneVariantResponseDTO);
			}
		} catch (Exception e) {
			logger.error("InventoryStoneVariantServiceImpl getAll failed" + e);
			throw e;
		}
		logger.info("Exiting getAll in InventoryStoneVariantServiceImpl  ..");
		return invStoneVariantResponseList;
	}
	public InventoryStoneVariantResponseDTO saveInventoryStoneVariant(
			InventoryStoneVariantRequestDTO dataReqDTO) {
		logger.info("Save Inventory Stone Variants details ..");
		InventoryStoneVariantResponseDTO dataRespDTO = new InventoryStoneVariantResponseDTO();
		try {
			InventoryStoneVariant invStoneVariantData = dataReqDTO.toModel(dataReqDTO);
			InventoryStoneVariant stoneDataEntity = inventoryStoneVariantRepository.save(invStoneVariantData);
			if (stoneDataEntity != null) {
				BeanUtils.copyProperties(stoneDataEntity, dataRespDTO);
				logger.info("Inventory Stone Variants saved successfully");
				dataRespDTO.setResponseMessage("Inventory Stone Variants saved successfully");
			} else {
				dataRespDTO.setResponseMessage("Failed to save Inventory Stone Variants");
				logger.error("Failed to save Inventory Stone Variants ");
			}
		} catch (Exception e) {
			logger.error("Saving saveInventoryStoneVariant of saveInventoryStoneVariantServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;

	}
	public InventoryStoneVariantResponseDTO updateInventoryStoneVariant(Long id,
			InventoryStoneVariantRequestDTO dataReqDTO) {
		logger.info("update Inventory Stone Variants details ..");
		InventoryStoneVariantResponseDTO invlibSmallStoneDataRespDTO = new InventoryStoneVariantResponseDTO();
		try {
			Optional<InventoryStoneVariant> invStoneVariantsOptional = inventoryStoneVariantRepository.findById(id);
			if (invStoneVariantsOptional.isPresent()) {
				InventoryStoneVariant invStoneVariants = dataReqDTO.toModel(dataReqDTO);
				invStoneVariants.setId(id);
				InventoryStoneVariant dataEntity = inventoryStoneVariantRepository.save(invStoneVariants);
				if (dataEntity != null) {
					BeanUtils.copyProperties(dataEntity, invlibSmallStoneDataRespDTO);
					invlibSmallStoneDataRespDTO.setResponseMessage("Inventory Stone Variants updated successfully");
					logger.info("Inventory Stone Variants updated successfully");
				} else {
					invlibSmallStoneDataRespDTO.setResponseMessage("Inventory Stone Variants updation failed");
					logger.info("Inventory Stone Variants updation failed");
				}
			} else {
				logger.info("Inventory Stone Variants doesn't exist");
				invlibSmallStoneDataRespDTO.setResponseMessage("Inventory Stone Variants doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update :updateInventoryStoneVariant of updateInventoryStoneVariantServiceImpl" + e);
			throw e;
		}

		return invlibSmallStoneDataRespDTO;
	}

	public List<InventoryStoneVariantResponseDTO> findInventoryStoneVariantByCriteria(
			InventoryStoneVariantRequestDTO dataReqDTO) throws Exception {
		logger.info("Entering For fetching all Inventory Stone Variants");
		List<InventoryStoneVariantResponseDTO> invStoneVariantResponseDTOList = new ArrayList<InventoryStoneVariantResponseDTO>();
		InventoryStoneVariantResponseDTO invStoneVariantResponseDTO = new InventoryStoneVariantResponseDTO();
		try {
			List<InventoryStoneVariant> stoneList = findByCriteria(dataReqDTO);
			if (stoneList != null && !stoneList.isEmpty()) {
				stoneList.stream().forEach((stoneObj) -> {
					
					BeanUtils.copyProperties(stoneObj, invStoneVariantResponseDTO);
					invStoneVariantResponseDTOList.add(invStoneVariantResponseDTO);
				});
			} else {
				logger.info("Inventory Stone Variants not found");
				invStoneVariantResponseDTO.setResponseMessage("Inventory Stone Variants not found");
				invStoneVariantResponseDTOList.add(invStoneVariantResponseDTO);
			}
		} catch (Exception e) {
			logger.error("InventoryStoneVariantImpl  findInventoryStoneVariantByCriteria failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all Inventory Stone Variants");
		return invStoneVariantResponseDTOList;
	}

	public InventoryStoneVariantResponseDTO deleteInventoryStoneVariantById(Long id) {
		logger.info("Entering delete InventoryStoneVariant", id);
		InventoryStoneVariantResponseDTO dataRespDTO = new InventoryStoneVariantResponseDTO();
	
		try {
			Optional<InventoryStoneVariant> dataList = inventoryStoneVariantRepository.findById(id);
			if(dataList.isPresent()){
			InventoryStoneVariant stoneData = dataList.get();
			inventoryStoneVariantRepository.delete(stoneData);
			dataRespDTO.setResponseMessage("  Inventory Stone Variants deleted successfully");
			} else {
				logger.info("The Inventory Stone Variants doesn't exists!!!");
				dataRespDTO.setResponseMessage("The Inventory Stone Variants doesn't exists!!!");
			}
			logger.info("Exiting deleteInventoryStoneVariant");
		} catch (Exception e) {
			logger.error("delete :InventoryStoneVariant of InventoryStoneVariantServiceImpl  " + e);
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
	private List<InventoryStoneVariant> findByCriteria(InventoryStoneVariantRequestDTO stoneRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for InventoryStoneVariant ");

		GenericSpesification<InventoryStoneVariant> genericSpesification = new GenericSpesification<InventoryStoneVariant>();
		try {
			if (stoneRequestDTO.getId() != null) {
				genericSpesification.add(new SearchCriteria("id", stoneRequestDTO.getId(), SearchOperation.EQUAL));
			}
			if (stoneRequestDTO.getItemCode() != null && !stoneRequestDTO.getItemCode().isEmpty()) {
				genericSpesification.add(new SearchCriteria("itemCode", stoneRequestDTO.getItemCode(), SearchOperation.EQUAL));
			}
			if (stoneRequestDTO.getPieces() != null && stoneRequestDTO.getPieces()>0) {
				genericSpesification
						.add(new SearchCriteria("pieces", stoneRequestDTO.getPieces(), SearchOperation.EQUAL));
			}

			return inventoryStoneVariantRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("InventoryStoneVariant findByCriteria failed" + e);
			throw e;
		}

	}

}
