package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.InvWeight;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InvWeightRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvWeightResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.InvWeightRepository;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.inventorymanagement.v1.service.InvWeightService;

/**
 * Service impl class for InvWeight
 * @author VitemCodeya.p
 *
 */
@Service(value = "InvWeightServiceImpl")
public class InvWeightServiceImpl implements InvWeightService {

	private static final Logger logger = LogManager.getLogger(InvWeightServiceImpl.class);

	@Autowired
	private InvWeightRepository invWeightRepository;

	/**
	 * method to Fetching InvWeight details by itemCode
	 */
	public InvWeightResponseDTO getInvWeightById(String itemCode) {
		InvWeightResponseDTO dataRespDTO = new InvWeightResponseDTO();
		try {
			logger.info("Entering getInvWeightById ..");
			Optional<InvWeight> jobOptional = invWeightRepository.findById(itemCode);
			if (jobOptional.isPresent()) {
				InvWeight data = jobOptional.get();
				BeanUtils.copyProperties(data, dataRespDTO);
				dataRespDTO.setResponseMessage("InvWeight fetch successfully");
			} else {
				logger.error("InvWeight doesn't exist");
				dataRespDTO.setResponseMessage("InvWeight doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch: getInvWeightById of InvWeightServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;
	}

	/**
	 * method which is used to save InvWeight
	 */
	public InvWeightResponseDTO saveInvWeight(InvWeightRequestDTO inWeightReqDTO) {
		logger.info("Save InvWeight details ..");
		InvWeightResponseDTO dataRespDTO = new InvWeightResponseDTO();
		try {
			InvWeight invWeightData = inWeightReqDTO.toModel(inWeightReqDTO);
			InvWeight invWeightDataEntity = invWeightRepository.save(invWeightData);
			if (invWeightDataEntity != null) {
				BeanUtils.copyProperties(invWeightDataEntity, dataRespDTO);
				logger.info("InvWeight saved successfully");
				dataRespDTO.setResponseMessage("InvWeight saved successfully");
			} else {
				dataRespDTO.setResponseMessage("Failed to save InvWeight");
				logger.error("Failed to save InvWeight ");
			}
		} catch (Exception e) {
			logger.error("Saving saveInvWeight of InvWeightServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;

	}

	/**
	 * method which is used to update InvWeight
	 * 
	 */
	public InvWeightResponseDTO updateInvWeight(String itemCode, InvWeightRequestDTO jobReqDTO) {
		logger.info("update InvWeight details ..");
		InvWeightResponseDTO invWeightDataRespDTO = new InvWeightResponseDTO();
		try {
			Optional<InvWeight> inWeightOptional = invWeightRepository.findById(itemCode);
			if (inWeightOptional.isPresent()) {
				InvWeight inWeight = jobReqDTO.toModel(jobReqDTO);
				inWeight.setItemCode(itemCode);
				InvWeight dataEntity = invWeightRepository.save(inWeight);
				if (dataEntity != null) {
					BeanUtils.copyProperties(dataEntity, invWeightDataRespDTO);
					invWeightDataRespDTO.setResponseMessage("InvWeight updated successfully");
					logger.info("InvWeight updated successfully");
				} else {
					invWeightDataRespDTO.setResponseMessage("InvWeight updation failed");
					logger.info("InvWeight updation failed");
				}
			} else {
				logger.info("InvWeight doesn't exist");
				invWeightDataRespDTO.setResponseMessage("InvWeight doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update :updateInvWeight of InvWeightServiceImpl" + e);
			throw e;
		}

		return invWeightDataRespDTO;
	}

	/**
	 * method which is used to get all InvWeight data
	 */
	public List<InvWeightResponseDTO> findAllInvWeight() {
		logger.info("Entering for fetching all InvWeight data..");
		
		List<InvWeightResponseDTO> inWeightResponseList = new ArrayList<InvWeightResponseDTO>();
		try {
				List<InvWeight> keywordsList = invWeightRepository.findAll();
				if(keywordsList != null && !keywordsList.isEmpty()) {
						keywordsList.forEach(jobProductObj -> {
						InvWeightResponseDTO inWeightResponseDTO = new InvWeightResponseDTO();
						BeanUtils.copyProperties(jobProductObj, inWeightResponseDTO);
						inWeightResponseList.add(inWeightResponseDTO);
					});
				}else {
					
					InvWeightResponseDTO inWeightResponseDTO = new InvWeightResponseDTO();
					inWeightResponseDTO.setResponseMessage("InvWeight not found");
					inWeightResponseList.add(inWeightResponseDTO);
				}
					
				
		} catch (Exception e) {
			logger.error("InvWeightServiceImpl getAll failed" + e);
			throw e;
		}
		
		logger.info("Exiting getAll in InvWeightServiceImpl  ..");
		return inWeightResponseList;
	}
	
	/**
	 * Fetches InvWeight objects in DB based on criteria
	 */
	
	public List<InvWeightResponseDTO> findInvWeightByCriteria(InvWeightRequestDTO invWeightRequestDTO) throws Exception {
		logger.info("Entering For fetching all InvWeight");
		List<InvWeightResponseDTO> invWeightResponseDTOList = new ArrayList<InvWeightResponseDTO>();
		try {
			List<InvWeight> jobsList = findByCriteria(invWeightRequestDTO);
			if (jobsList != null && !jobsList.isEmpty()) {
				jobsList.stream().forEach((jobObj) -> {
					InvWeightResponseDTO inWeightResponseDTO = new InvWeightResponseDTO();
					BeanUtils.copyProperties(jobObj, inWeightResponseDTO);
					invWeightResponseDTOList.add(inWeightResponseDTO);
				});
			} else {
				logger.info("InvWeight not found");
	

				
				InvWeightResponseDTO inWeightResponseDTO = new InvWeightResponseDTO();
				inWeightResponseDTO.setResponseMessage("InvWeight not found");
				invWeightResponseDTOList.add(inWeightResponseDTO);
			
			
				
			}
		}catch(Exception e) {
			logger.error("InvWeightServiceImpl  findInvWeightByCriteria failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all InvWeight");
		return invWeightResponseDTOList;
	}
		
	/**
	 * Crtieria builder for fetching InvWeight
	 * 
	 * @param InvWeightRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<InvWeight> findByCriteria(InvWeightRequestDTO InvWeightRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for InvWeight ");
		
		GenericSpesification<InvWeight> genericSpesification = new GenericSpesification<InvWeight>();
		try {
			if (InvWeightRequestDTO.getItemCode() != null) {
				genericSpesification.add(new SearchCriteria("itemCode", InvWeightRequestDTO.getItemCode(), SearchOperation.EQUAL));
			}
			if (InvWeightRequestDTO.getWaxType() != null && !InvWeightRequestDTO.getWaxType().isEmpty()) {
				genericSpesification.add(new SearchCriteria("waxType", InvWeightRequestDTO.getWaxType(), SearchOperation.MATCH));
			}
			if (InvWeightRequestDTO.getLocking() != null && !InvWeightRequestDTO.getLocking().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("locking", InvWeightRequestDTO.getLocking(), SearchOperation.MATCH));
			}
			
			if (InvWeightRequestDTO.getWtIn14k() != null) {
				genericSpesification
						.add(new SearchCriteria("wtIn14k", InvWeightRequestDTO.getWtIn14k(), SearchOperation.MATCH));
			}
			
			
			if (InvWeightRequestDTO.getWtIn18k() != null) {
				genericSpesification
						.add(new SearchCriteria("wtIn18k", InvWeightRequestDTO.getWtIn18k(), SearchOperation.MATCH));
			}
			
			if (InvWeightRequestDTO.getWtIn10k() != null) {
				genericSpesification
						.add(new SearchCriteria("wtIn10k", InvWeightRequestDTO.getWtIn10k(), SearchOperation.MATCH));
			}
			
			return invWeightRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("MemoManifestInvWeightServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}
	
	
	/**
	 * method which is used to delete InvWeight by itemCode
	 */

	public InvWeightResponseDTO deleteInvWeightById(String itemCode) {
		logger.info("Entering delete InvWeight", itemCode);
		InvWeightResponseDTO dataRespDTO = new InvWeightResponseDTO();
		Optional<InvWeight> dataList = invWeightRepository.findById(itemCode);
		InvWeight invWeightData = dataList.get();
		try {
			if (invWeightData == null) {
				logger.info("The InvWeight doesn't exists!!!");
				dataRespDTO.setResponseMessage("The InvWeight doesn't exists!!!");
			} else {
				invWeightRepository.delete(invWeightData);
				dataRespDTO.setResponseMessage(" InvWeight deleted successfully");
			}
			logger.info("Exiting deleteInvWeight");
		} catch (Exception e) {
			logger.error("delete :deleteInvWeightById of InvWeightServiceImpl  " + e);
			throw e;
		}
		return dataRespDTO;
	}

}
