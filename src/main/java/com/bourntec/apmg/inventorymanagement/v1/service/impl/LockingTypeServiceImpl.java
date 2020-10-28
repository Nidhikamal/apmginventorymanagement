package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.InventoryRank;
import com.bourntec.apmg.entity.LockingType;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryRankRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.LockingTypeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryRankResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.LockingTypeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.LockingTypeRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.LockingTypeService;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for LockingType
 * 
 * @author Srijini
 *
 */
@Service(value = "LockingTypeServiceImpl")
public class LockingTypeServiceImpl implements LockingTypeService {

	private static final Logger logger = LogManager.getLogger(LockingTypeServiceImpl.class);

	@Autowired
	private LockingTypeRepository lockingTypeRepository;

	/**
	 * @author naveen This is the main method which is used to save Locking codes
	 */

	@Override
	public LockingTypeResponseDTO saveLockingTypes(LockingTypeRequestDTO lockingTypesRequestDTO) {
		LockingTypeResponseDTO lockingTypeResponseDTO = new LockingTypeResponseDTO();
		try {
			LockingType lockingType = lockingTypesRequestDTO.toModel(lockingTypesRequestDTO);
			LockingType lockingTypeObject = lockingTypeRepository.save(lockingType);
			logger.info(" LockingType Data saved successfully");
			BeanUtils.copyProperties(lockingTypeObject, lockingTypeResponseDTO);

		} catch (Exception e) {
			logger.error("Save: LockingType " + e);
			throw e;
		}
		return lockingTypeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to update LockingType
	 *         codes
	 */

	@Override
	public LockingTypeResponseDTO updateLockingType(Long id, LockingTypeRequestDTO lockingTypeRequestDTO) {
		Optional<LockingType> lockingType = lockingTypeRepository.findById(id);
		LockingTypeResponseDTO lockingTypeResponseDTO = new LockingTypeResponseDTO();

		try {
			if (lockingType == null) {
				logger.info("The LockingType doesn't exists!!!");
				lockingTypeResponseDTO.setResponseMessage("The LockingType doesn't exists");
			} else {

				LockingType labourCharges = lockingTypeRequestDTO.toModel(lockingTypeRequestDTO);

				labourCharges.setId(id);
				LockingType labour = lockingTypeRepository.save(labourCharges);
				logger.info("LockingType Details is updated");

				BeanUtils.copyProperties(labour, lockingTypeResponseDTO);
				lockingTypeResponseDTO.setResponseMessage("LockingType is updated in DB");
			}
		} catch (Exception e) {
			logger.error("update: LockingType " + e);

			throw e;
		}
		return lockingTypeResponseDTO;
	}

	/**
	 * This method findLockingTypesById
	 * 
	 * @param lockingTypeId
	 * @return LockingTypeResponseDTO
	 * @throws Exception
	 */

	@Override
	public LockingTypeResponseDTO findLockingTypesById(Long lockingTypeId) {
		LockingTypeResponseDTO lockingTypeResponseDTO = new LockingTypeResponseDTO();

		try {
			Optional<LockingType> lockTopye = lockingTypeRepository.findById(lockingTypeId);
			BeanUtils.copyProperties(lockTopye.get(), lockingTypeResponseDTO);
		} catch (Exception e) {
			logger.error(" lockingTypeId failed" + e);
			throw e;
		}
		return lockingTypeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to get al
	 *         LockingTypeDetais
	 */

	@Override
	public List<LockingTypeResponseDTO> findAllLockingTypes() {

		List<LockingTypeResponseDTO> lockResponseDTOs = new ArrayList<LockingTypeResponseDTO>();
		try {
			List<LockingType> lockTypeList = lockingTypeRepository.findAll();
			for (LockingType lockType : lockTypeList) {
				LockingTypeResponseDTO lockResponseDTO = new LockingTypeResponseDTO();
				BeanUtils.copyProperties(lockType, lockResponseDTO);
				lockResponseDTOs.add(lockResponseDTO);

			}
		} catch (Exception e) {
			logger.error(" findAllLockingTypes failed" + e);

			throw e;
		}
		return lockResponseDTOs;

	}

	/**
	 * This API delete an LockType object.
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public LockingTypeResponseDTO deleteLockingType(Long id) {
		try {
			lockingTypeRepository.deleteById(id);
		} catch (Exception e) {
			logger.error(" lockingtype deletion fialed: " + e);
		}
		return null;
	}

	/**
	 * This API search on LockType object.
	 * @param lockingTypeRequestDTO
	 * @return
	 * @throws Exception
	 */

	
	public List<LockingTypeResponseDTO> searchLockingType(LockingTypeRequestDTO shapeRequestDTO) throws Exception {
		logger.info("Entering For fetching all lockingtype");
		List<LockingTypeResponseDTO> memoManifestResponseDTOList = new ArrayList<LockingTypeResponseDTO>();
		try {
			List<LockingType> sizeList = findByCriteria(shapeRequestDTO);
			if (sizeList != null && !sizeList.isEmpty()) {
				sizeList.stream().forEach((MemoManifest) -> {
					LockingTypeResponseDTO sizeResponseDTO = new LockingTypeResponseDTO();
					BeanUtils.copyProperties(MemoManifest, sizeResponseDTO);
					memoManifestResponseDTOList.add(sizeResponseDTO);
				});

			} 
			else {
				logger.info("lockingtype Data not found");
				throw new ResourceNotFoundException("lockingtype Data not found ");
			}
			
		}
		catch(Exception e) {
			logger.error("lockingtypekDataServiceImpl  failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all manifests");
		return memoManifestResponseDTOList;
	}
	
	private List<LockingType> findByCriteria(LockingTypeRequestDTO shapeRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for lockingtype Data ");
		
		GenericSpesification<LockingType> genericSpesification = new GenericSpesification<LockingType>();
		try {
			if (shapeRequestDTO.getId() != null) {
				genericSpesification
						.add(new SearchCriteria("id", shapeRequestDTO.getId(), SearchOperation.EQUAL));
			}
			if (shapeRequestDTO.getDescription() != null && !shapeRequestDTO.getDescription().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("description", shapeRequestDTO.getDescription(), SearchOperation.MATCH));
			}
			if (shapeRequestDTO.getCategory() != null && !shapeRequestDTO.getCategory().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("category", shapeRequestDTO.getCategory(), SearchOperation.MATCH));
			}	
			return lockingTypeRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("MemoManifestServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}

}
