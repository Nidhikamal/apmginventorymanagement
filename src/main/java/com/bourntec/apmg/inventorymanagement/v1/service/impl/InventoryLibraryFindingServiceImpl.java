package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.InventoryLibraryFinding;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryLibraryFindingRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryLibraryFindingResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryLibraryFindingRepository;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryLibraryFindingService;

/**
 * Service impl class for InventoryLibraryFinding
 * @author Vidya.p
 *
 */
@Service(value = "InventoryLibraryFindingServiceImpl")
public class InventoryLibraryFindingServiceImpl implements InventoryLibraryFindingService {

	private static final Logger logger = LogManager.getLogger(InventoryLibraryFindingServiceImpl.class);

	@Autowired
	private InventoryLibraryFindingRepository invLibraryRepository;

	/**
	 * method to Fetching InventoryLibraryFinding details by id
	 */
	public InventoryLibraryFindingResponseDTO getInventoryLibraryFindingById(Long id) {
		InventoryLibraryFindingResponseDTO inventoryLibraryFindingResponseDTO = new InventoryLibraryFindingResponseDTO();
		try {
			logger.info("Entering getInventoryLibraryFindingById ..");
			Optional<InventoryLibraryFinding> invOptional = invLibraryRepository.findById(id);
			if (invOptional.isPresent()) {
				InventoryLibraryFinding data = invOptional.get();
				BeanUtils.copyProperties(data, inventoryLibraryFindingResponseDTO);
				inventoryLibraryFindingResponseDTO.setResponseMessage("InventoryLibraryFinding fetch successfully");
			} else {
				logger.error("InventoryLibraryFinding doesn't exist");
				inventoryLibraryFindingResponseDTO.setResponseMessage("InventoryLibraryFinding doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch: getInventoryLibraryFindingById of InventoryLibraryFindingServiceImpl :" + e);
			throw e;
		}

		return inventoryLibraryFindingResponseDTO;
	}

	/**
	 * method which is used to save InventoryLibraryFinding
	 */
	public InventoryLibraryFindingResponseDTO saveInventoryLibraryFinding(InventoryLibraryFindingRequestDTO inventoryLibraryFindingReqDTO) {
		logger.info("Save InventoryLibraryFinding details ..");
		InventoryLibraryFindingResponseDTO dataRespDTO = new InventoryLibraryFindingResponseDTO();
		try {
			InventoryLibraryFinding inventoryLibraryFinding = inventoryLibraryFindingReqDTO.toModel(inventoryLibraryFindingReqDTO);
			InventoryLibraryFinding inventoryLibraryFindingEntity = invLibraryRepository.save(inventoryLibraryFinding);
			if (inventoryLibraryFindingEntity != null) {
				BeanUtils.copyProperties(inventoryLibraryFindingEntity, dataRespDTO);
				logger.info("InventoryLibraryFinding saved successfully");
				dataRespDTO.setResponseMessage("InventoryLibraryFinding saved successfully");
			} else {
				dataRespDTO.setResponseMessage("Failed to save InventoryLibraryFinding");
				logger.error("Failed to save InventoryLibraryFinding ");
			}
		} catch (Exception e) {
			logger.error("Saving saveInventoryLibraryFinding of InventoryLibraryFindingServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;

	}

	/**
	 * method which is used to update InventoryLibraryFinding
	 * 
	 */
	public InventoryLibraryFindingResponseDTO updateInventoryLibraryFinding(Long id, InventoryLibraryFindingRequestDTO jobReqDTO) {
		logger.info("update InventoryLibraryFinding details ..");
		InventoryLibraryFindingResponseDTO inventoryLibraryFindingRespDTO = new InventoryLibraryFindingResponseDTO();
		try {
			Optional<InventoryLibraryFinding> inventoryLibraryFindingOptional = invLibraryRepository.findById(id);
			if (inventoryLibraryFindingOptional.isPresent()) {
				InventoryLibraryFinding inventoryLibraryFinding = jobReqDTO.toModel(jobReqDTO);
				inventoryLibraryFinding.setId(id);
				InventoryLibraryFinding dataEntity = invLibraryRepository.save(inventoryLibraryFinding);
				if (dataEntity != null) {
					BeanUtils.copyProperties(dataEntity, inventoryLibraryFindingRespDTO);
					inventoryLibraryFindingRespDTO.setResponseMessage("InventoryLibraryFinding updated successfully");
					logger.info("InventoryLibraryFinding updated successfully");
				} else {
					inventoryLibraryFindingRespDTO.setResponseMessage("InventoryLibraryFinding updation failed");
					logger.info("InventoryLibraryFinding updation failed");
				}
			} else {
				logger.info("InventoryLibraryFinding doesn't exist");
				inventoryLibraryFindingRespDTO.setResponseMessage("InventoryLibraryFinding doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update :updateInventoryLibraryFinding of InventoryLibraryFindingServiceImpl" + e);
			throw e;
		}

		return inventoryLibraryFindingRespDTO;
	}

	/**
	 * method which is used to get all InventoryLibraryFinding data
	 */
	public List<InventoryLibraryFindingResponseDTO> findAllInventoryLibraryFinding() {
		logger.info("Entering for fetching all InventoryLibraryFinding data..");
		
		List<InventoryLibraryFindingResponseDTO> inventoryLibraryFindingResponseList = new ArrayList<InventoryLibraryFindingResponseDTO>();
		try {
				List<InventoryLibraryFinding> keywordsList = invLibraryRepository.findAll();
				if(keywordsList != null && !keywordsList.isEmpty()) {
						keywordsList.forEach(jobProductObj -> {
						InventoryLibraryFindingResponseDTO inventoryLibraryFindingResponseDTO = new InventoryLibraryFindingResponseDTO();
						BeanUtils.copyProperties(jobProductObj, inventoryLibraryFindingResponseDTO);
						inventoryLibraryFindingResponseList.add(inventoryLibraryFindingResponseDTO);
					});
				}
					else {
						
						InventoryLibraryFindingResponseDTO inventoryLibraryFindingResponseDTO = new InventoryLibraryFindingResponseDTO();
						inventoryLibraryFindingResponseDTO.setResponseMessage("InventoryLibraryFinding not found");
						inventoryLibraryFindingResponseList.add(inventoryLibraryFindingResponseDTO);
					}
				
				
		} catch (Exception e) {
			logger.error("InventoryLibraryFindingServiceImpl getAll failed" + e);
			throw e;
		}
		
		logger.info("Exiting getAll in InventoryLibraryFindingServiceImpl  ..");
		return inventoryLibraryFindingResponseList;
	}
	
	/**
	 * Fetches InventoryLibraryFinding objects in DB based on criteria
	 */
	@Override
	public List<InventoryLibraryFindingResponseDTO> findInventoryLibraryFindingByCriteria(InventoryLibraryFindingRequestDTO invWeightRequestDTO) throws Exception {
		logger.info("Entering For fetching all InventoryLibraryFinding");
		List<InventoryLibraryFindingResponseDTO> inventoryLibraryFindingResponseList = new ArrayList<InventoryLibraryFindingResponseDTO>();
		try {
			List<InventoryLibraryFinding> invList = findByCriteria(invWeightRequestDTO);
			if (invList != null && !invList.isEmpty()) {
				invList.stream().forEach((jobObj) -> {
					InventoryLibraryFindingResponseDTO inventoryLibraryFindingResponseDTO = new InventoryLibraryFindingResponseDTO();
					BeanUtils.copyProperties(jobObj, inventoryLibraryFindingResponseDTO);
					inventoryLibraryFindingResponseList.add(inventoryLibraryFindingResponseDTO);
				});
			} else {
				logger.info("InventoryLibraryFinding not found");

				
				InventoryLibraryFindingResponseDTO inventoryLibraryFindingResponseDTO = new InventoryLibraryFindingResponseDTO();
				inventoryLibraryFindingResponseDTO.setResponseMessage("InventoryLibraryFinding not found");
				inventoryLibraryFindingResponseList.add(inventoryLibraryFindingResponseDTO);
			
			}
		}catch(Exception e) {
			logger.error("InventoryLibraryFindingServiceImpl  findInventoryLibraryFindingByCriteria failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all InventoryLibraryFinding");
		return inventoryLibraryFindingResponseList;
	}
		
	/**
	 * Crtieria builder for fetching InventoryLibraryFinding
	 * 
	 * @param InventoryLibraryFindingRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<InventoryLibraryFinding> findByCriteria(InventoryLibraryFindingRequestDTO inventoryLibraryFindingRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for InventoryLibraryFinding ");
		
		GenericSpesification<InventoryLibraryFinding> genericSpesification = new GenericSpesification<InventoryLibraryFinding>();
		try {
			if (inventoryLibraryFindingRequestDTO.getItemCode() != null) {
				genericSpesification.add(new SearchCriteria("itemCode", inventoryLibraryFindingRequestDTO.getItemCode(), SearchOperation.EQUAL));
			}
			if (inventoryLibraryFindingRequestDTO.getLibraryId() != null) {
				genericSpesification.add(new SearchCriteria("libraryId", inventoryLibraryFindingRequestDTO.getLibraryId(), SearchOperation.MATCH));
			}
			if (inventoryLibraryFindingRequestDTO.getKarat() != null) {
				genericSpesification
						.add(new SearchCriteria("karat", inventoryLibraryFindingRequestDTO.getKarat(), SearchOperation.MATCH));
			}
			
			if (inventoryLibraryFindingRequestDTO.getMaterial() != null && !inventoryLibraryFindingRequestDTO.getMaterial().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("material", inventoryLibraryFindingRequestDTO.getMaterial(), SearchOperation.MATCH));
			}
			
			
			if (inventoryLibraryFindingRequestDTO.getPieces() != null ) {
				genericSpesification
						.add(new SearchCriteria("pieces", inventoryLibraryFindingRequestDTO.getPieces(), SearchOperation.MATCH));
			}
			
			
			if (inventoryLibraryFindingRequestDTO.getPrice() != null ) {
				genericSpesification
						.add(new SearchCriteria("location", inventoryLibraryFindingRequestDTO.getPrice(), SearchOperation.MATCH));
			}
			
			if (inventoryLibraryFindingRequestDTO.getTotal() != null) {
				genericSpesification
						.add(new SearchCriteria("total", inventoryLibraryFindingRequestDTO.getTotal(), SearchOperation.MATCH));
			}
			
			if (inventoryLibraryFindingRequestDTO.getWtPiece()!= null) {
				genericSpesification
						.add(new SearchCriteria("WtPiece", inventoryLibraryFindingRequestDTO.getWtPiece(), SearchOperation.MATCH));
			}
			
		
			return invLibraryRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("InventoryLibraryFindingServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}
	
	
	/**
	 * method which is used to delete InventoryLibraryFinding by id
	 */

	public InventoryLibraryFindingResponseDTO deleteInventoryLibraryFindingById(Long id) {
		logger.info("Entering delete InventoryLibraryFinding", id);
		InventoryLibraryFindingResponseDTO dataRespDTO = new InventoryLibraryFindingResponseDTO();
		Optional<InventoryLibraryFinding> dataList = invLibraryRepository.findById(id);
		InventoryLibraryFinding inventoryLibraryFinding = dataList.get();
		try {
			if (inventoryLibraryFinding == null) {
				logger.info("The InventoryLibraryFinding doesn't exists!!!");
				dataRespDTO.setResponseMessage("The InventoryLibraryFinding doesn't exists!!!");
			} else {
				invLibraryRepository.delete(inventoryLibraryFinding);
				dataRespDTO.setResponseMessage(" InventoryLibraryFinding deleted successfully");
			}
			logger.info("Exiting deleteInventoryLibraryFinding");
		} catch (Exception e) {
			logger.error("delete :deleteInventoryLibraryFindingById of InventoryLibraryFindingServiceImpl  " + e);
			throw e;
		}
		return dataRespDTO;
	}

}
