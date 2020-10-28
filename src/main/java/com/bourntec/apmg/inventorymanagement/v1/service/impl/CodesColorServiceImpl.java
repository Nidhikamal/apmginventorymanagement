package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CodesColor;
import com.bourntec.apmg.entity.CodesShapes;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesColorRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesColorResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.CodesColorRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.CodeColorService;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for CodesColorServiceImpl
 * 
 * @author Srijini
 *
 */
@Service(value = "CodesColorServiceImpl")
public class CodesColorServiceImpl implements CodeColorService {

	private static final Logger logger = LogManager.getLogger(CodesColorServiceImpl.class);

	@Autowired
	private CodesColorRepository codesColorRepo;

	/**
	 * @author amal This is the main method which is used to get all color codes
	 */

	public List<CodesColor> findAllColorCodes() throws Exception{
		return codesColorRepo.findAll();
	}

	/**
	 * @author amal This is the main method which is used to find color codes by Id
	 */

	public CodesColorResponseDTO findColorCodesById(String id) throws Exception{
		CodesColorResponseDTO colorCodesRespDTO = new CodesColorResponseDTO();
		try {
			Optional<CodesColor> colorCodesOptional = codesColorRepo.findById(id);
			if (colorCodesOptional.isPresent()) {
				CodesColor colorCodes = colorCodesOptional.get();
				BeanUtils.copyProperties(colorCodes, colorCodesRespDTO);
			} else {
				logger.error("Color code doesn't exist!!!");
				colorCodesRespDTO.setResponseMessage("Color code not found");
			}
		} catch (Exception e) {
			System.out.println("Fetch:findColorCodesById " + e);
			throw e;
		}

		return colorCodesRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to save color codes
	 */

	public CodesColorResponseDTO saveColorCodes(CodesColorRequestDTO codesColorReqDTO) throws Exception{
		CodesColorResponseDTO colorCodesRespDTO = new CodesColorResponseDTO();
		try {
			CodesColor colorCodes = codesColorReqDTO.toModel(codesColorReqDTO);
			CodesColor colorCodesEntity = codesColorRepo.save(colorCodes);
			if (colorCodesEntity != null) {
				BeanUtils.copyProperties(colorCodesEntity, colorCodesRespDTO);
				logger.info("Color Code  saved successfully");
			} else {
				logger.error("Failed to save color codes");
			}

		} catch (Exception e) {
			logger.error("Save: saveColorCodes" + e);
			throw e;
		}

		return colorCodesRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to update color codes
	 */
	public CodesColorResponseDTO updateColorCodesById(String id, CodesColorRequestDTO codesColorReqDTO) throws Exception{
		CodesColorResponseDTO colorCodesRespDTO = new CodesColorResponseDTO();
		try {
			Optional<CodesColor> colorCodesOptional = codesColorRepo.findById(id);
			if (colorCodesOptional.isPresent()) {
				CodesColor colorCodes = codesColorReqDTO.toModel(codesColorReqDTO);
				colorCodes.setColorId(id);
				CodesColor colorCodesEntity = codesColorRepo.save(colorCodes);
				if (colorCodesEntity != null) {
					BeanUtils.copyProperties(colorCodesEntity, colorCodesRespDTO);
					logger.info("Color Code  updated successfully");
				} else {
					logger.error("Color Code  updation failed");
				}
			} else {
				logger.error("Color code doesn't exist!!!");
				colorCodesRespDTO.setResponseMessage("Color code doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update: updateColorCodesById" + e);
			throw e;
		}

		return colorCodesRespDTO;
	}

	@Override
	public CodesColorResponseDTO delete(String id) throws Exception {
		codesColorRepo.deleteById(id);
		return null;
	}

	@Override
	public List<CodesColorResponseDTO> search(CodesColorRequestDTO requestDTO) throws Exception{
GenericSpesification<CodesColor> genericSpesification = new GenericSpesification<CodesColor>();
		
		if(requestDTO.getColorId()!=null) {
			 genericSpesification.add(new SearchCriteria("colorId",requestDTO.getColorId(), SearchOperation.MATCH));
			}
			if(requestDTO.getColorName()!=null) {
	        genericSpesification.add(new SearchCriteria("colorName",requestDTO.getColorName(), SearchOperation.MATCH));
			}
			if(requestDTO.getUnitCharge()!=null) {
		        genericSpesification.add(new SearchCriteria("unitCharge",requestDTO.getUnitCharge(), SearchOperation.MATCH));
				}
			
		
		 return codesColorRepo.findAll(genericSpesification);
	}
}
