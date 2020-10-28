package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CodesMaterial;
import com.bourntec.apmg.entity.CodesShapes;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesMaterailRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesMaterialResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.CodesMaterailRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.CodesMaterialService;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for CodesMaterialServiceImpl
 * 
 * @author Srijini
 *
 */
@Service(value = "CodesMaterialServiceImpl")
public class CodesMaterialServiceImpl implements CodesMaterialService {

	private static final Logger logger = LogManager.getLogger(CodesMaterialServiceImpl.class);

	@Autowired
	private CodesMaterailRepository codesMaterialRepo;

	/**
	 * @author amal This is the main method which is used to get material codes by
	 *         id
	 */
	public CodesMaterialResponseDTO findMaterialCodesById(String id) {
		CodesMaterialResponseDTO materialCodesRespDTO = new CodesMaterialResponseDTO();
		try {
			Optional<CodesMaterial> materialCodesOptional = codesMaterialRepo.findById(id);
			if (materialCodesOptional.isPresent()) {
				CodesMaterial materialCodes = materialCodesOptional.get();
				BeanUtils.copyProperties(materialCodes, materialCodesRespDTO);
			} else {
				logger.info(" Material code doesn't exist");
				materialCodesRespDTO.setResponseMessage("Material  not found");
			}
		} catch (Exception e) {
			logger.error("Fetch: findMaterialCodesById" + e);
			throw e;
		}

		return materialCodesRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all material codes
	 */

	public List<CodesMaterial> findAllMaterialCodes() {
		return codesMaterialRepo.findAll();
	}

	/**
	 * @author amal This is the main method which is used to get material codes by
	 *         id
	 */
	public CodesMaterialResponseDTO updateMaterialCodesById(String id, CodesMaterailRequestDTO codesMaterialReqDTO) {
		CodesMaterialResponseDTO materialCodesRespDTO = new CodesMaterialResponseDTO();
		try {
			Optional<CodesMaterial> materialCodesOptional = codesMaterialRepo.findById(id);
			if (materialCodesOptional.isPresent()) {
				CodesMaterial materialCodes = codesMaterialReqDTO.toModel(codesMaterialReqDTO);
				materialCodes.setMaterialId(id);
				CodesMaterial materialCodesEntity = codesMaterialRepo.save(materialCodes);
				if (materialCodesEntity != null) {
					BeanUtils.copyProperties(materialCodesEntity, materialCodesRespDTO);
					logger.info("Material Codes  updated successfully");
				} else {
					logger.error("Material Codes  updation failed");
				}

			} else {
				logger.info("Material code doesn't exist");
				materialCodesRespDTO.setResponseMessage("Update Failed");
			}
		} catch (Exception e) {
			logger.error("Update: updateMaterialCodesById" + e);
			throw e;
		}

		return materialCodesRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to save material codes
	 */
	public CodesMaterialResponseDTO saveMaterialCodes(CodesMaterailRequestDTO codesMaterialReqDTO) {
		CodesMaterialResponseDTO materialCodesRespDTO = new CodesMaterialResponseDTO();
		try {
			CodesMaterial materialCodes = codesMaterialReqDTO.toModel(codesMaterialReqDTO);
			CodesMaterial materialCodesEntity = codesMaterialRepo.save(materialCodes);
			if (materialCodesEntity != null) {
				BeanUtils.copyProperties(materialCodesEntity, materialCodesRespDTO);
				logger.info("Material Codes  saved successfully");
			} else {
				logger.error("Failed to save material codes");
			}
		} catch (Exception e) {
			logger.error("Save saveMaterialCodes " + e);
			throw e;
		}

		return materialCodesRespDTO;
	}

	@Override
	public CodesMaterialResponseDTO delete(String id) {
		codesMaterialRepo.deleteById(id);
		return null;
	}

	@Override
	public List<CodesMaterialResponseDTO> search(CodesMaterailRequestDTO requestDTO) {
GenericSpesification<CodesMaterial> genericSpesification = new GenericSpesification<CodesMaterial>();
		
		if(requestDTO.getMaterialId()!=null) {
			 genericSpesification.add(new SearchCriteria("materialId",requestDTO.getMaterialId(), SearchOperation.MATCH));
			}
			if(requestDTO.getMaterialName()!=null) {
	        genericSpesification.add(new SearchCriteria("materialName",requestDTO.getMaterialName(), SearchOperation.MATCH));
			}
			
		
		 return codesMaterialRepo.findAll(genericSpesification);
	}
}
