package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.InventoryLibraryMaterial;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryLibraryMaterialRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryLibraryMaterialResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryLibraryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryLibraryMaterialRepository;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryLibraryMaterialService;

/**
 * Service impl class for InventoryLibraryMaterial
 * @author Vidya.p
 *
 */
@Service(value = "InventoryLibraryMaterialServiceImpl")
public class InventoryLibraryMaterialServiceImpl implements InventoryLibraryMaterialService {

	private static final Logger logger = LogManager.getLogger(InventoryLibraryMaterialServiceImpl.class);

	@Autowired
	private InventoryLibraryMaterialRepository invLibraryMaterialRepository;

	/**
	 * method to Fetching InventoryLibraryMaterial details by id
	 */
	public InventoryLibraryMaterialResponseDTO getInventoryLibraryMaterialById(Long id) {
		InventoryLibraryMaterialResponseDTO dataRespDTO = new InventoryLibraryMaterialResponseDTO();
		try {
			logger.info("Entering getInventoryLibraryMaterialById ..");
			Optional<InventoryLibraryMaterial> invOptional = invLibraryMaterialRepository.findById(id);
			if (invOptional.isPresent()) {
				InventoryLibraryMaterial data = invOptional.get();
				BeanUtils.copyProperties(data, dataRespDTO);
				dataRespDTO.setResponseMessage("InventoryLibraryMaterial fetch successfully");
			} else {
				logger.error("InventoryLibraryMaterial doesn't exist");
				dataRespDTO.setResponseMessage("InventoryLibraryMaterial doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch: getInventoryLibraryMaterialById of InventoryLibraryMaterialServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;
	}

	/**
	 * method which is used to save InventoryLibraryMaterial
	 */
	public InventoryLibraryMaterialResponseDTO saveInventoryLibraryMaterial(InventoryLibraryMaterialRequestDTO inventoryLibraryMaterialReqDTO) {
		logger.info("Save InventoryLibraryMaterial details ..");
		InventoryLibraryMaterialResponseDTO dataRespDTO = new InventoryLibraryMaterialResponseDTO();
		try {
			InventoryLibraryMaterial inventoryLibraryMaterial = inventoryLibraryMaterialReqDTO.toModel(inventoryLibraryMaterialReqDTO);
			InventoryLibraryMaterial inventoryLibraryFindingEntity = invLibraryMaterialRepository.save(inventoryLibraryMaterial);
			if (inventoryLibraryFindingEntity != null) {
				BeanUtils.copyProperties(inventoryLibraryFindingEntity, dataRespDTO);
				logger.info("InventoryLibraryMaterial saved successfully");
				dataRespDTO.setResponseMessage("InventoryLibraryMaterial saved successfully");
			} else {
				dataRespDTO.setResponseMessage("Failed to save InventoryLibraryMaterial");
				logger.error("Failed to save InventoryLibraryMaterial ");
			}
		} catch (Exception e) {
			logger.error("Saving saveInventoryLibraryMaterial of InventoryLibraryMaterialServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;

	}

	/**
	 * method which is used to update InventoryLibraryMaterial
	 * 
	 */
	public InventoryLibraryMaterialResponseDTO updateInventoryLibraryMaterial(Long id, InventoryLibraryMaterialRequestDTO jobReqDTO) {
		logger.info("update InventoryLibraryMaterial details ..");
		InventoryLibraryMaterialResponseDTO inventoryLibraryFindingRespDTO = new InventoryLibraryMaterialResponseDTO();
		try {
			Optional<InventoryLibraryMaterial> inventoryLibraryFindingOptional = invLibraryMaterialRepository.findById(id);
			if (inventoryLibraryFindingOptional.isPresent()) {
				InventoryLibraryMaterial inventoryLibraryMaterial = jobReqDTO.toModel(jobReqDTO);
				inventoryLibraryMaterial.setId(id);
				InventoryLibraryMaterial dataEntity = invLibraryMaterialRepository.save(inventoryLibraryMaterial);
				if (dataEntity != null) {
					BeanUtils.copyProperties(dataEntity, inventoryLibraryFindingRespDTO);
					inventoryLibraryFindingRespDTO.setResponseMessage("InventoryLibraryMaterial updated successfully");
					logger.info("InventoryLibraryMaterial updated successfully");
				} else {
					inventoryLibraryFindingRespDTO.setResponseMessage("InventoryLibraryMaterial updation failed");
					logger.info("InventoryLibraryMaterial updation failed");
				}
			} else {
				logger.info("InventoryLibraryMaterial doesn't exist");
				inventoryLibraryFindingRespDTO.setResponseMessage("InventoryLibraryMaterial doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update :updateInventoryLibraryMaterial of InventoryLibraryMaterialServiceImpl" + e);
			throw e;
		}

		return inventoryLibraryFindingRespDTO;
	}

	/**
	 * method which is used to get all InventoryLibraryMaterial data
	 */
	public List<InventoryLibraryMaterialResponseDTO> findAllInventoryLibraryMaterial() {
		logger.info("Entering for fetching all InventoryLibraryMaterial data..");
		
		List<InventoryLibraryMaterialResponseDTO> inventoryLibraryMaterialResponseList = new ArrayList<InventoryLibraryMaterialResponseDTO>();
		try {
				List<InventoryLibraryMaterial> keywordsList = invLibraryMaterialRepository.findAll();
				if(keywordsList != null && !keywordsList.isEmpty()) {
						keywordsList.forEach(jobProductObj -> {
						InventoryLibraryMaterialResponseDTO inventoryLibraryFindingResponseDTO = new InventoryLibraryMaterialResponseDTO();
						BeanUtils.copyProperties(jobProductObj, inventoryLibraryFindingResponseDTO);
						inventoryLibraryMaterialResponseList.add(inventoryLibraryFindingResponseDTO);
					});
				}else {
					logger.info("InventoryLibraryMaterial not found");
					InventoryLibraryMaterialResponseDTO inventoryLibraryResponseDTO = new InventoryLibraryMaterialResponseDTO();
					inventoryLibraryResponseDTO.setResponseMessage("InventoryLibraryMaterial not found");
					inventoryLibraryMaterialResponseList.add(inventoryLibraryResponseDTO);

				}
				
		} catch (Exception e) {
			logger.error("InventoryLibraryMaterialServiceImpl getAll failed" + e);
			throw e;
		}
		
		logger.info("Exiting getAll in InventoryLibraryMaterialServiceImpl  ..");
		return inventoryLibraryMaterialResponseList;
	}
	
	/**
	 * Fetches InventoryLibraryMaterial objects in DB based on criteria
	 */
	@Override
	public List<InventoryLibraryMaterialResponseDTO> findInventoryLibraryMaterialByCriteria(InventoryLibraryMaterialRequestDTO invWeightRequestDTO) throws Exception {
		logger.info("Entering For fetching all InventoryLibraryMaterial");
		List<InventoryLibraryMaterialResponseDTO> inventoryLibraryResponseDTOList = new ArrayList<InventoryLibraryMaterialResponseDTO>();
		try {
			List<InventoryLibraryMaterial> invList = findByCriteria(invWeightRequestDTO);
			if (invList != null && !invList.isEmpty()) {
				invList.stream().forEach((jobObj) -> {
					InventoryLibraryMaterialResponseDTO inventoryLibraryFindingResponseDTO = new InventoryLibraryMaterialResponseDTO();
					BeanUtils.copyProperties(jobObj, inventoryLibraryFindingResponseDTO);
					inventoryLibraryResponseDTOList.add(inventoryLibraryFindingResponseDTO);
				});
			} else {
				logger.info("InventoryLibraryMaterial not found");
				InventoryLibraryMaterialResponseDTO inventoryLibraryResponseDTO = new InventoryLibraryMaterialResponseDTO();
				inventoryLibraryResponseDTO.setResponseMessage("InventoryLibraryMaterial not found");
				inventoryLibraryResponseDTOList.add(inventoryLibraryResponseDTO);

			}
		}catch(Exception e) {
			logger.error("InventoryLibraryMaterialServiceImpl  findInventoryLibraryMaterialByCriteria failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all InventoryLibraryMaterial");
		return inventoryLibraryResponseDTOList;
	}
		
	/**
	 * Crtieria builder for fetching InventoryLibraryMaterial
	 * 
	 * @param InventoryLibraryMaterialRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<InventoryLibraryMaterial> findByCriteria(InventoryLibraryMaterialRequestDTO inventoryLibraryMaterialRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for InventoryLibraryMaterial ");
		
		GenericSpesification<InventoryLibraryMaterial> genericSpesification = new GenericSpesification<InventoryLibraryMaterial>();
		try {
			if (inventoryLibraryMaterialRequestDTO.getId() != null) {
				genericSpesification.add(new SearchCriteria("id", inventoryLibraryMaterialRequestDTO.getId(), SearchOperation.EQUAL));
			}
			if (inventoryLibraryMaterialRequestDTO.getKarat() != null) {
				genericSpesification.add(new SearchCriteria("karat", inventoryLibraryMaterialRequestDTO.getKarat(), SearchOperation.MATCH));
			}
			if (inventoryLibraryMaterialRequestDTO.getLibraryId() != null) {
				genericSpesification
						.add(new SearchCriteria("libraryId", inventoryLibraryMaterialRequestDTO.getLibraryId(), SearchOperation.MATCH));
			}
			
			if (inventoryLibraryMaterialRequestDTO.getMaterial() != null && !inventoryLibraryMaterialRequestDTO.getMaterial().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("material", inventoryLibraryMaterialRequestDTO.getMaterial(), SearchOperation.MATCH));
			}
			
			
			if (inventoryLibraryMaterialRequestDTO.getPrice() != null ) {
				genericSpesification
						.add(new SearchCriteria("price", inventoryLibraryMaterialRequestDTO.getPrice(), SearchOperation.MATCH));
			}
			
			
			if (inventoryLibraryMaterialRequestDTO.getWeight() != null ) {
				genericSpesification
						.add(new SearchCriteria("weight", inventoryLibraryMaterialRequestDTO.getWeight(), SearchOperation.MATCH));
			}
			
			if (inventoryLibraryMaterialRequestDTO.getColor() != null) {
				genericSpesification
						.add(new SearchCriteria("color", inventoryLibraryMaterialRequestDTO.getColor(), SearchOperation.MATCH));
			}
		
		
			return invLibraryMaterialRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("MemoManifestInventoryLibraryMaterialServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}
	
	
	/**
	 * method which is used to delete InventoryLibraryMaterial by id
	 */

	public InventoryLibraryMaterialResponseDTO deleteInventoryLibraryMaterialById(Long id) {
		logger.info("Entering delete InventoryLibraryMaterial", id);
		InventoryLibraryMaterialResponseDTO dataRespDTO = new InventoryLibraryMaterialResponseDTO();
		Optional<InventoryLibraryMaterial> dataList = invLibraryMaterialRepository.findById(id);
		InventoryLibraryMaterial inventoryLibraryMaterial = dataList.get();
		try {
			if (inventoryLibraryMaterial == null) {
				logger.info("The InventoryLibraryMaterial doesn't exists!!!");
				dataRespDTO.setResponseMessage("The InventoryLibraryMaterial doesn't exists!!!");
			} else {
				invLibraryMaterialRepository.delete(inventoryLibraryMaterial);
				dataRespDTO.setResponseMessage(" InventoryLibraryMaterial deleted successfully");
			}
			logger.info("Exiting deleteInventoryLibraryMaterial");
		} catch (Exception e) {
			logger.error("delete :deleteInventoryLibraryMaterialById of InventoryLibraryMaterialServiceImpl  " + e);
			throw e;
		}
		return dataRespDTO;
	}

	
}
