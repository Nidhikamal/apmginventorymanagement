package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.AdditionalOrderData;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.AdditionalOrderDataRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.AdditionalOrderDataResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.AdditionalOrderDataRepository;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.inventorymanagement.v1.service.AdditionalOrderDataService;

/**
 * 
 * Service class implementation for AddtionalOrderDataServiceImpl
 * 
 * @author Srijini
 *
 */
@Service(value = "AdditionalOrderDataServiceImpl")
public class AdditionalOrderDataServiceImpl implements AdditionalOrderDataService {

	private static final Logger logger = LogManager.getLogger(AdditionalOrderDataServiceImpl.class);

	@Autowired
	private AdditionalOrderDataRepository additionalOrderDataRepository;

	/**
	 * @author naveen This is the main method which is used to get all
	 *         ShapeMaintainancedetails
	 */
	@Override
	public List<AdditionalOrderDataResponseDTO> findAllSizeMainatinence() throws Exception {

		List<AdditionalOrderDataResponseDTO> lockResponseDTOs = new ArrayList<AdditionalOrderDataResponseDTO>();
		try {
			List<AdditionalOrderData> lockTypeList = additionalOrderDataRepository.findAll();
			for (AdditionalOrderData lockType : lockTypeList) {
				AdditionalOrderDataResponseDTO lockResponseDTO = new AdditionalOrderDataResponseDTO();
				BeanUtils.copyProperties(lockType, lockResponseDTO);
				lockResponseDTOs.add(lockResponseDTO);

			}
		} catch (Exception e) {
			logger.error("inventory control service findAllSizeMainatinence failed" + e);

			throw e;
		}
		return lockResponseDTOs;

	}

	/**
	 * This method findSizeMainatinenceById
	 * 
	 * @param addtionalOrderData
	 * @return AddtionalOrderDataResponsetDTO
	 * @throws Exception
	 */
	@Override
	public AdditionalOrderDataResponseDTO findSizeMainatinenceById(Long id) throws Exception {
		AdditionalOrderDataResponseDTO lockingTypeResponseDTO = new AdditionalOrderDataResponseDTO();
		try {
			Optional<AdditionalOrderData> lockTopye = additionalOrderDataRepository.findById(id);
			BeanUtils.copyProperties(lockTopye.get(), lockingTypeResponseDTO);
		} catch (Exception e) {
			logger.error("inventory control service findSizeMainatinenceById failed" + e);
			throw e;
		}
		return lockingTypeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to save SizeMaintainence
	 *         codes
	 */
	@Override
	public AdditionalOrderDataResponseDTO saveSizeMaintainence(
			AdditionalOrderDataRequestDTO addtionalOrderDataRequestDTO) throws Exception {
		AdditionalOrderDataResponseDTO codeShapeResponseDTO = new AdditionalOrderDataResponseDTO();
		try {
			AdditionalOrderData addtionalOrderData = addtionalOrderDataRequestDTO.toModel(addtionalOrderDataRequestDTO);
			AdditionalOrderData lockingTypeObject = additionalOrderDataRepository.save(addtionalOrderData);
			logger.info("sizeMaintainance Details is updated");

			BeanUtils.copyProperties(lockingTypeObject, codeShapeResponseDTO);
		} catch (Exception e) {
			logger.error("Save: sizeMaintainance " + e);
			throw e;
		}
		return codeShapeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to update
	 *         SizeMaintainence data
	 */
	@Override
	public AdditionalOrderDataResponseDTO updateSizeMaintainence(Long id,
			AdditionalOrderDataRequestDTO addtionalOrderDataRequestDTO) {
		Optional<AdditionalOrderData> addtionalOrderData = additionalOrderDataRepository.findById(id);
		AdditionalOrderDataResponseDTO addtionalOrderDataResponsetDTO = new AdditionalOrderDataResponseDTO();

		try {
			if (addtionalOrderData == null) {
				logger.info("The AddtionalOrderDatavalue doesn't exists!!!");
				addtionalOrderDataResponsetDTO.setResponseMessage("The AddtionalOrderData doesn't exists");
			} else {

				AdditionalOrderData addtionalOrderDataDTOS = addtionalOrderDataRequestDTO
						.toModel(addtionalOrderDataRequestDTO);

				addtionalOrderDataDTOS.setId(id);
				AdditionalOrderData addtionalOrderDataEntity = additionalOrderDataRepository
						.save(addtionalOrderDataDTOS);
				logger.info("AddtionalOrderData Details is updated");

				BeanUtils.copyProperties(addtionalOrderDataEntity, addtionalOrderDataResponsetDTO);
				addtionalOrderDataResponsetDTO.setResponseMessage("AddtionalOrderData is updated in DB");
			}
		} catch (Exception e) {
			logger.error("update: AddtionalOrderData " + e);

			throw e;
		}
		return addtionalOrderDataResponsetDTO;
	}

	@Override
	public AdditionalOrderDataResponseDTO deleteShapeMaintance(Long id) throws Exception {
		additionalOrderDataRepository.deleteById(id);
		return null;
	}
	
	
	
	/**
	 * Fetches Memo Manifest objects in DB based on criteria
	 */
	@Override
	public List<AdditionalOrderDataResponseDTO> searchSizeMaintance(AdditionalOrderDataRequestDTO sizeRequestDTO) throws Exception {
		logger.info("Entering For fetching all AdditionalOrderData");
		List<AdditionalOrderDataResponseDTO> memoManifestResponseDTOList = new ArrayList<AdditionalOrderDataResponseDTO>();
		try {
			List<AdditionalOrderData> sizeList = findByCriteria(sizeRequestDTO);
			if (sizeList != null && !sizeList.isEmpty()) {
				sizeList.stream().forEach((MemoManifest) -> {
					AdditionalOrderDataResponseDTO sizeResponseDTO = new AdditionalOrderDataResponseDTO();
					BeanUtils.copyProperties(MemoManifest, sizeResponseDTO);
					memoManifestResponseDTOList.add(sizeResponseDTO);
				});

			} 
			/*
			 * else { logger.info("Additional Order Data not found"); throw new
			 * ResourceNotFoundException(" Additional Order Data not found "); }
			 */
			
		}
		catch(Exception e) {
			logger.error("AdditionalOrderDataServiceImpl  searchSizeMaintance failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all manifests");
		return memoManifestResponseDTOList;
	}
		
	/**
	 * Crtieria builder for fetching Additional Order Data
	 * 
	 * @param sizeRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<AdditionalOrderData> findByCriteria(AdditionalOrderDataRequestDTO sizeRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for Additional Order Data ");
		
		GenericSpesification<AdditionalOrderData> genericSpesification = new GenericSpesification<AdditionalOrderData>();
		try {
			if (sizeRequestDTO.getAdditionalDataName() != null && !sizeRequestDTO.getAdditionalDataName().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("additionalDataName", sizeRequestDTO.getAdditionalDataName(), SearchOperation.MATCH));
			}
			if (sizeRequestDTO.getAdditionalDataDesc() != null && !sizeRequestDTO.getAdditionalDataDesc().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("additionalDataDesc", sizeRequestDTO.getAdditionalDataDesc(), SearchOperation.MATCH));
			}
			if (sizeRequestDTO.getAdditionalDataValue() != null && !sizeRequestDTO.getAdditionalDataValue().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("additionalDataValue", sizeRequestDTO.getAdditionalDataValue(), SearchOperation.MATCH));
			}
			if (sizeRequestDTO.getId() != null) {
				genericSpesification
						.add(new SearchCriteria("id", sizeRequestDTO.getId(), SearchOperation.EQUAL));
			}
			return additionalOrderDataRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("MemoManifestServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}
	
}
