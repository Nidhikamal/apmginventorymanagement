package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.InventoryLibrary;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryLibraryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvWeightResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryLibraryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryLibraryRepository;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryLibraryService;

/**
 * Service impl class for InventoryLibrary
 * @author Vidya.p
 *
 */
@Service(value = "InventoryLibraryServiceImpl")
public class InventoryLibraryServiceImpl implements InventoryLibraryService {

	private static final Logger logger = LogManager.getLogger(InventoryLibraryServiceImpl.class);

	@Autowired
	private InventoryLibraryRepository invLibraryRepository;

	/**
	 * method to Fetching InventoryLibrary details by id
	 */
	public InventoryLibraryResponseDTO getInventoryLibraryById(Long id) {
		InventoryLibraryResponseDTO dataRespDTO = new InventoryLibraryResponseDTO();
		try {
			logger.info("Entering getInventoryLibraryById ..");
			Optional<InventoryLibrary> invOptional = invLibraryRepository.findById(id);
			if (invOptional.isPresent()) {
				InventoryLibrary data = invOptional.get();
				BeanUtils.copyProperties(data, dataRespDTO);
				dataRespDTO.setResponseMessage("InventoryLibrary fetch successfully");
			} else {
				logger.error("InventoryLibrary doesn't exist");
				dataRespDTO.setResponseMessage("InventoryLibrary doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch: getInventoryLibraryById of InventoryLibraryServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;
	}

	/**
	 * method which is used to save InventoryLibrary
	 */
	public InventoryLibraryResponseDTO saveInventoryLibrary(InventoryLibraryRequestDTO inWeightReqDTO) {
		logger.info("Save InventoryLibrary details ..");
		InventoryLibraryResponseDTO dataRespDTO = new InventoryLibraryResponseDTO();
		try {
			InventoryLibrary InventoryLibrary = inWeightReqDTO.toModel(inWeightReqDTO);
			InventoryLibrary InventoryLibraryEntity = invLibraryRepository.save(InventoryLibrary);
			if (InventoryLibraryEntity != null) {
				BeanUtils.copyProperties(InventoryLibraryEntity, dataRespDTO);
				logger.info("InventoryLibrary saved successfully");
				dataRespDTO.setResponseMessage("InventoryLibrary saved successfully");
			} else {
				dataRespDTO.setResponseMessage("Failed to save InventoryLibrary");
				logger.error("Failed to save InventoryLibrary ");
			}
		} catch (Exception e) {
			logger.error("Saving saveInventoryLibrary of InventoryLibraryServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;

	}

	/**
	 * method which is used to update InventoryLibrary
	 * 
	 */
	public InventoryLibraryResponseDTO updateInventoryLibrary(Long id, InventoryLibraryRequestDTO jobReqDTO) {
		logger.info("update InventoryLibrary details ..");
		InventoryLibraryResponseDTO InventoryLibraryRespDTO = new InventoryLibraryResponseDTO();
		try {
			Optional<InventoryLibrary> inWeightOptional = invLibraryRepository.findById(id);
			if (inWeightOptional.isPresent()) {
				InventoryLibrary inWeight = jobReqDTO.toModel(jobReqDTO);
				inWeight.setId(id);
				InventoryLibrary dataEntity = invLibraryRepository.save(inWeight);
				if (dataEntity != null) {
					BeanUtils.copyProperties(dataEntity, InventoryLibraryRespDTO);
					InventoryLibraryRespDTO.setResponseMessage("InventoryLibrary updated successfully");
					logger.info("InventoryLibrary updated successfully");
				} else {
					InventoryLibraryRespDTO.setResponseMessage("InventoryLibrary updation failed");
					logger.info("InventoryLibrary updation failed");
				}
			} else {
				logger.info("InventoryLibrary doesn't exist");
				InventoryLibraryRespDTO.setResponseMessage("InventoryLibrary doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update :updateInventoryLibrary of InventoryLibraryServiceImpl" + e);
			throw e;
		}

		return InventoryLibraryRespDTO;
	}

	/**
	 * method which is used to get all InventoryLibrary data
	 */
	public List<InventoryLibraryResponseDTO> findAllInventoryLibrary() {
		logger.info("Entering for fetching all InventoryLibrary data..");
		
		List<InventoryLibraryResponseDTO> inventoryLibraryResponseDTOList = new ArrayList<InventoryLibraryResponseDTO>();
		try {
				List<InventoryLibrary> keywordsList = invLibraryRepository.findAll();
				if(keywordsList != null && !keywordsList.isEmpty()) {
						keywordsList.forEach(jobProductObj -> {
						InventoryLibraryResponseDTO InventoryLibraryResponseDTO = new InventoryLibraryResponseDTO();
						BeanUtils.copyProperties(jobProductObj, InventoryLibraryResponseDTO);
						inventoryLibraryResponseDTOList.add(InventoryLibraryResponseDTO);
					});
				}else {
					InventoryLibraryResponseDTO inventoryLibraryResponseDTO = new InventoryLibraryResponseDTO();
					inventoryLibraryResponseDTO.setResponseMessage("InventoryLibrary not found");
					inventoryLibraryResponseDTOList.add(inventoryLibraryResponseDTO);
				}
				
		} catch (Exception e) {
			logger.error("InventoryLibraryServiceImpl getAll failed" + e);
			throw e;
		}
		
		logger.info("Exiting getAll in InventoryLibraryServiceImpl  ..");
		return inventoryLibraryResponseDTOList;
	}
	
	/**
	 * Fetches InventoryLibrary objects in DB based on criteria
	 */
	@Override
	public List<InventoryLibraryResponseDTO> findInventoryLibraryByCriteria(InventoryLibraryRequestDTO invRequestDTO) throws Exception {
		logger.info("Entering For fetching all InventoryLibrary");
		List<InventoryLibraryResponseDTO> inventoryLibraryResponseDTOList = new ArrayList<InventoryLibraryResponseDTO>();
		try {
			List<InventoryLibrary> invList = findByCriteria(invRequestDTO);
			if (invList != null && !invList.isEmpty()) {
				invList.stream().forEach((jobObj) -> {
					InventoryLibraryResponseDTO inventoryLibraryResponseDTO = new InventoryLibraryResponseDTO();
					BeanUtils.copyProperties(jobObj, inventoryLibraryResponseDTO);
					inventoryLibraryResponseDTOList.add(inventoryLibraryResponseDTO);
				});
				
			} else {
				logger.info("InventoryLibrary not found");

			
				InventoryLibraryResponseDTO inventoryLibraryResponseDTO = new InventoryLibraryResponseDTO();
				inventoryLibraryResponseDTO.setResponseMessage("InventoryLibrary not found");
				inventoryLibraryResponseDTOList.add(inventoryLibraryResponseDTO);
			
			
			}
		}catch(Exception e) {
			logger.error("InventoryLibraryServiceImpl  findInventoryLibraryByCriteria failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all InventoryLibrary");
		return inventoryLibraryResponseDTOList;
	}
		
	/**
	 * Crtieria builder for fetching InventoryLibrary
	 * 
	 * @param InventoryLibraryRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<InventoryLibrary> findByCriteria(InventoryLibraryRequestDTO InventoryLibraryRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for InventoryLibrary ");
		
		GenericSpesification<InventoryLibrary> genericSpesification = new GenericSpesification<InventoryLibrary>();
		try {
			if (InventoryLibraryRequestDTO.getItemCode() != null) {
				genericSpesification.add(new SearchCriteria("itemCode", InventoryLibraryRequestDTO.getItemCode(), SearchOperation.EQUAL));
			}
			if (InventoryLibraryRequestDTO.getJobNo() != null && !InventoryLibraryRequestDTO.getJobNo().isEmpty()) {
				genericSpesification.add(new SearchCriteria("jobNo", InventoryLibraryRequestDTO.getJobNo(), SearchOperation.MATCH));
			}
			if (InventoryLibraryRequestDTO.getStyle() != null && !InventoryLibraryRequestDTO.getStyle().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("style", InventoryLibraryRequestDTO.getStyle(), SearchOperation.MATCH));
			}
			
			if (InventoryLibraryRequestDTO.getSpecification() != null && !InventoryLibraryRequestDTO.getSpecification().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("specification", InventoryLibraryRequestDTO.getSpecification(), SearchOperation.MATCH));
			}
			
			
			if (InventoryLibraryRequestDTO.getLeadTime() != null ) {
				genericSpesification
						.add(new SearchCriteria("leadTime", InventoryLibraryRequestDTO.getLeadTime(), SearchOperation.MATCH));
			}
			
			
			if (InventoryLibraryRequestDTO.getLocation() != null ) {
				genericSpesification
						.add(new SearchCriteria("location", InventoryLibraryRequestDTO.getLocation(), SearchOperation.MATCH));
			}
			
			if (InventoryLibraryRequestDTO.getCreatedDate() != null) {
				genericSpesification
						.add(new SearchCriteria("createdDate", InventoryLibraryRequestDTO.getCreatedDate(), SearchOperation.MATCH));
			}
			
			if (InventoryLibraryRequestDTO.getDescription() != null && !InventoryLibraryRequestDTO.getDescription().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("description", InventoryLibraryRequestDTO.getDescription(), SearchOperation.MATCH));
			}
			
			if (InventoryLibraryRequestDTO.getTotal() != null ) {
				genericSpesification
						.add(new SearchCriteria("total", InventoryLibraryRequestDTO.getTotal(), SearchOperation.MATCH));
			}
			
			if (InventoryLibraryRequestDTO.getWebyn() != null ) {
				genericSpesification
						.add(new SearchCriteria("webyn", InventoryLibraryRequestDTO.getWebyn(), SearchOperation.MATCH));
			}
			
			if (InventoryLibraryRequestDTO.getDisplayOnApollo() != null && !InventoryLibraryRequestDTO.getDisplayOnApollo().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("displayOnApollo", InventoryLibraryRequestDTO.getDisplayOnApollo(), SearchOperation.MATCH));
			}
			return invLibraryRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("MemoManifestInventoryLibraryServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}
	
	
	/**
	 * method which is used to delete InventoryLibrary by id
	 */

	public InventoryLibraryResponseDTO deleteInventoryLibraryById(Long id) {
		logger.info("Entering delete InventoryLibrary", id);
		InventoryLibraryResponseDTO dataRespDTO = new InventoryLibraryResponseDTO();
		Optional<InventoryLibrary> dataList = invLibraryRepository.findById(id);
		InventoryLibrary InventoryLibrary = dataList.get();
		try {
			if (InventoryLibrary == null) {
				logger.info("The InventoryLibrary doesn't exists!!!");
				dataRespDTO.setResponseMessage("The InventoryLibrary doesn't exists!!!");
			} else {
				invLibraryRepository.delete(InventoryLibrary);
				dataRespDTO.setResponseMessage(" InventoryLibrary deleted successfully");
			}
			logger.info("Exiting deleteInventoryLibrary");
		} catch (Exception e) {
			logger.error("delete :deleteInventoryLibraryById of InventoryLibraryServiceImpl  " + e);
			throw e;
		}
		return dataRespDTO;
	}

}
