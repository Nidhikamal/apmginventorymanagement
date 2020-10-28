package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.TypeData;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.TypeDataRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TypeDataResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.TypeDataRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.TypeDataService;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for InvTypeServiceImpl
 * 
 * @author Srijini
 *
 */
@Service(value = "TypeDataServiceImpl")
public class TypeDataServiceImpl implements TypeDataService {

	private static final Logger logger = LogManager.getLogger(TypeDataServiceImpl.class);

	@Autowired
	private TypeDataRepository typeDataRepo;

	/**
	 * @author amal This is the main method which is used to get Inventory Ranks by
	 *         Id
	 */
	public TypeDataResponseDTO findTypeDataById(String id) {
		TypeDataResponseDTO typeDataRespDTO = new TypeDataResponseDTO();
		try {
			Optional<TypeData> typeDataOptional = typeDataRepo.findById(id);
			if (typeDataOptional.isPresent()) {
				TypeData typeData = typeDataOptional.get();
				BeanUtils.copyProperties(typeData, typeDataRespDTO);
			} else {
				logger.error(" Type Data doesn't exist");
				typeDataRespDTO.setResponseMessage("Type Data not found");
			}
		} catch (Exception e) {
			logger.error("Fetch Type Data " + e);
			throw e;
		}

		return typeDataRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all Type Data
	 */

	public List<TypeData> findAllTypeDatas() {
		return typeDataRepo.findAll();
	}

	/**
	 * @author amal This is the main method which is used to update Type Data by id
	 */
	public TypeDataResponseDTO updateTypeDataById(String type, TypeDataRequestDTO typeDataReqDTO) {
		TypeDataResponseDTO typeDataRespDTO = new TypeDataResponseDTO();
		try {
			Optional<TypeData> invCatOptional = typeDataRepo.findById(type);
			if (invCatOptional.isPresent()) {
				TypeData typeData = typeDataReqDTO.toModel(typeDataReqDTO);
				typeData.setTypeCode(type);
				TypeData typeDataEntity = typeDataRepo.save(typeData);
				if (typeDataEntity != null) {
					BeanUtils.copyProperties(typeDataEntity, typeDataRespDTO);
					logger.info(" Type Data updated successfully");
				} else {
					logger.error(" Type Data updation failed");
				}
			} else {
				logger.error(" Type Data doesn't exist");
				typeDataRespDTO.setResponseMessage("Type Data doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update: updateTypeDataById " + e);
			throw e;
		}

		return typeDataRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to save Type Data
	 */

	public TypeDataResponseDTO saveTypeData(TypeDataRequestDTO typeDataReqDTO) {
		TypeDataResponseDTO typeDataRespDTO = new TypeDataResponseDTO();
		try {
			TypeData typeData = typeDataReqDTO.toModel(typeDataReqDTO);
			TypeData typeDataEntity = typeDataRepo.save(typeData);
			if (typeDataEntity != null) {
				BeanUtils.copyProperties(typeDataEntity, typeDataRespDTO);
				logger.info(" Type Data saved successfully");
			} else {
				logger.error("Failed to save Type Data ");
			}
		} catch (Exception e) {
			logger.error("Save: saveTypeData " + e);
			throw e;
		}

		return typeDataRespDTO;
	}

	
	@Override
	public TypeDataResponseDTO delete(String id) throws Exception {

		logger.info("Entering deleteTypeData  {}", id);
		TypeDataResponseDTO dataRespDTO = new TypeDataResponseDTO();
		Optional<TypeData> dataList = typeDataRepo.findById(id);
		TypeData typeDataObj = dataList.get();
		try {
			if (typeDataObj == null) {
				logger.info("The TypeData doesn't exists!!!");
				dataRespDTO.setResponseMessage("The TypeData doesn't exists!!!");
			} else {
				typeDataRepo.delete(typeDataObj);
				dataRespDTO.setResponseMessage(" TypeData delete successfully");
			}
			logger.info("Exiting deleteTypeData");
		} catch (Exception e) {
			logger.error("delete :deleteMemoBillingById of MemoBillingServiceImpl " + e);
			throw e;
		}
		return dataRespDTO;
	
	}

	@Override
	public List<TypeDataResponseDTO> search(TypeDataRequestDTO typeDataRequestDTO) throws Exception {
		logger.info("Entering For fetching all Type Data");
		List<TypeDataResponseDTO> typeDataResponseDTOList = new ArrayList<TypeDataResponseDTO>();
		try {
			List<TypeData> typeDataList = findByCriteria(typeDataRequestDTO);
			if (typeDataList != null && !typeDataList.isEmpty()) {
				typeDataList.stream().forEach((typeDataObj) -> {
					TypeDataResponseDTO typeDataResponseDTO = new TypeDataResponseDTO();
					BeanUtils.copyProperties(typeDataObj, typeDataResponseDTO);
					typeDataResponseDTOList.add(typeDataResponseDTO);
				});
			} 
//			else {
//				logger.info("Type Data not found");
//				throw new ResourceNotFoundException("Type Data not found ");
//			}
		}
		catch(Exception e) {
			logger.error("TypeDataServiceImpl  search failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all Type Data");
		return typeDataResponseDTOList;
	}
	
	private List<TypeData> findByCriteria(TypeDataRequestDTO typeDataRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for Market Code ");
		
		GenericSpesification<TypeData> genericSpesification = new GenericSpesification<TypeData>();
		try {
			if (typeDataRequestDTO.getTypeName() != null && !typeDataRequestDTO.getTypeName().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("typeName", typeDataRequestDTO.getTypeName(), SearchOperation.EQUAL));
			}
			if (typeDataRequestDTO.getLocationCode() != null && !typeDataRequestDTO.getLocationCode().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("locationCode", typeDataRequestDTO.getLocationCode(), SearchOperation.EQUAL));
			}
			if (typeDataRequestDTO.getUnitCharge() != null && !typeDataRequestDTO.getUnitCharge().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("unitCharge", typeDataRequestDTO.getUnitCharge(), SearchOperation.EQUAL));
			}
			if (typeDataRequestDTO.getCategory() != null && !typeDataRequestDTO.getCategory().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("category", typeDataRequestDTO.getCategory(), SearchOperation.EQUAL));
			}
			if (typeDataRequestDTO.getDisplayWeb() != null && !typeDataRequestDTO.getDisplayWeb().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("displayWeb", typeDataRequestDTO.getDisplayWeb(), SearchOperation.EQUAL));
			}
			return typeDataRepo.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("TypeDataServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}
}
