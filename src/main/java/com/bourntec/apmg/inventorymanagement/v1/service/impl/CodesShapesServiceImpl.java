package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CodesSetting;
import com.bourntec.apmg.entity.CodesShapes;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesShapeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesSettingResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesShapeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.CodesShapeRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.CodesShapesService;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for CodeShapesServiceImpl
 * ShapeMaintainace
 * @author Srijini
 *
 */
@Service(value = "CodesShapesServiceImpl")
public class CodesShapesServiceImpl implements CodesShapesService {

	private static final Logger logger = LogManager.getLogger(CodesShapesServiceImpl.class);

	@Autowired
	private CodesShapeRepository codeShapeRepository;

	/**
	 * @author naveen This is the main method which is used to get all
	 *         ShapeMaintainancedetails
	 */
	@Override
	public List<CodesShapeResponseDTO> findAllShapeId()  throws Exception{

		List<CodesShapeResponseDTO> lockResponseDTOs = new ArrayList<CodesShapeResponseDTO>();
		try {
			List<CodesShapes> lockTypeList = codeShapeRepository.findAll();
			for (CodesShapes lockType : lockTypeList) {
				CodesShapeResponseDTO lockResponseDTO = new CodesShapeResponseDTO();
				BeanUtils.copyProperties(lockType, lockResponseDTO);
				lockResponseDTOs.add(lockResponseDTO);

			}
		} catch (Exception e) {
			logger.error(" findAllShapeId failed" + e);

			throw e;
		}
		return lockResponseDTOs;

	}

	
	/**
	 * This method findShapecodeById
	 * 
	 * @param shapeId
	 * @return CodeShapeResponseDTO
	 * @throws Exception
	 */
	@Override
	public CodesShapeResponseDTO findShapecodeById(String shapeId)  throws Exception{
		CodesShapeResponseDTO lockingTypeResponseDTO = new CodesShapeResponseDTO();
		try {
			Optional<CodesShapes> lockTopye = codeShapeRepository.findById(shapeId);
			if(lockTopye.isPresent()) {
				BeanUtils.copyProperties(lockTopye.get(), lockingTypeResponseDTO);
				lockingTypeResponseDTO.setResponseMessage("Codes shape found");
			}
			else {
				lockingTypeResponseDTO.setResponseMessage("Codes shape not found");
			}
		} catch (Exception e) {

			logger.error(" findShapecodeById failed" + e);

			throw e;
		}
		return lockingTypeResponseDTO;
	}
	
	/**
	 * @author naveen This is the main method which is used to save CodeShape
	 */
	@Override
	public CodesShapeResponseDTO saveCodeShape(CodesShapeRequestDTO codeShapeRequestDTO) throws Exception {
		CodesShapeResponseDTO codeShapeResponseDTO = new CodesShapeResponseDTO();
		try {
			CodesShapes codeShapes = codeShapeRequestDTO.toModel(codeShapeRequestDTO);
			CodesShapes lockingTypeObject = codeShapeRepository.save(codeShapes);
			logger.info(" CodeShape Data saved successfully");

			BeanUtils.copyProperties(lockingTypeObject, codeShapeResponseDTO);

		} catch (Exception e) {
			logger.error("Save: CodeShape " + e);
			throw e;
		}
		return codeShapeResponseDTO;
	}
	
	/**
	 * @author naveen This is the main method which is used to update CodeShape
	 */
	@Override
	public CodesShapeResponseDTO updateShapeMaintainance(String shapeId, CodesShapeRequestDTO codeShapeRequestDTO)  throws Exception{
		Optional<CodesShapes> codeShapes = codeShapeRepository.findById(shapeId);
		CodesShapeResponseDTO codeShapeResponseDTO = new CodesShapeResponseDTO();

		try {
			if (codeShapes == null) {
				logger.info("The CodeShapes doesn't exists!!!");
				codeShapeResponseDTO.setResponseMessage("The CodeShapes doesn't exists");
			} else {

				CodesShapes codeShapeDTOS = codeShapeRequestDTO.toModel(codeShapeRequestDTO);

				codeShapeDTOS.setShapeId(shapeId);
				;
				CodesShapes codeShapesEntity = codeShapeRepository.save(codeShapeDTOS);
				logger.info("CodeShapes Details is updated");

				BeanUtils.copyProperties(codeShapesEntity, codeShapeResponseDTO);
				codeShapeResponseDTO.setResponseMessage("CodeShapes is updated in DB");
			}
		} catch (Exception e) {
			logger.error("update: CodeShape " + e);

			throw e;
		}
		return codeShapeResponseDTO;
	}
	
	@Override
	public CodesShapeResponseDTO deleteShapeMaintance(String id)  throws Exception{
		codeShapeRepository.deleteById(id);
		CodesShapeResponseDTO codesShapeResponseDTO =new CodesShapeResponseDTO();
		codesShapeResponseDTO.setResponseMessage("Deleted Successfully");
		 return codesShapeResponseDTO;
	}

	@Override
	public List<CodesShapes> searchShapeMaintance(CodesShapeRequestDTO shapeRequestDTO)  throws Exception{
GenericSpesification<CodesShapes> genericSpesification = new GenericSpesification<CodesShapes>();
		
		if(shapeRequestDTO.getShapeId()!=null) {
			 genericSpesification.add(new SearchCriteria("shapeId",shapeRequestDTO.getShapeId(), SearchOperation.MATCH));
			}
			if(shapeRequestDTO.getShapeName()!=null) {
	        genericSpesification.add(new SearchCriteria("shapeName",shapeRequestDTO.getShapeName(), SearchOperation.MATCH));
			}
			
		
		 return codeShapeRepository.findAll(genericSpesification);
	}

}
