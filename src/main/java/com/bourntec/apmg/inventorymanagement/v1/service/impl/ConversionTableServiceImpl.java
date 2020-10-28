package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.ConversionTable;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.ConversionTableResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.ConversionTableRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.ConversionTableService;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;

/**
 * 
 * Service class implementation for ConversionTableServiceImpl
 * 
 * @author Nince
 *
 */
@Service(value = "ConversionTableServiceImpl")
public class ConversionTableServiceImpl implements ConversionTableService {


	private static final Logger logger = LogManager.getLogger(ConversionTableServiceImpl.class);

	@Autowired
	ConversionTableRepository conversionTableRepository;

		
	/**
	 * Retrieval of Market Code object based on requested marketCode
	 */
	@Override
	public ConversionTableResponseDTO getById(String karatValue) {
		logger.info("Entering getById in ConversionTableServiceImpl  {}", karatValue);

		ConversionTableResponseDTO conversionTableResponseDTO = new ConversionTableResponseDTO();
		try {

			Optional<ConversionTable> conversionTableObj = conversionTableRepository.findById(karatValue);
			if(conversionTableObj.isPresent()) {
				ConversionTable conversionTableObject = conversionTableObj.get();
				BeanUtils.copyProperties(conversionTableObject, conversionTableResponseDTO);
			}
			else {
				throw new ResourceNotFoundException("Requested Conversion Table with "+karatValue+" is not exist");
			}

			logger.info("Exiting getById  in ConversionTableServiceImpl {}", karatValue);
		} 
		catch (Exception e) {
			logger.error("ConversionTableServiceImpl getById failed" + e);
			throw e;
		}
		return conversionTableResponseDTO;
	}
	
	/**
	 * Fetch all the Market Code in the DB
	 */
	@Override
	public List<ConversionTableResponseDTO> getAll() {
		logger.info("Entering getAll in ConversionTableServiceImpl  ..");
		
		List<ConversionTableResponseDTO> conversionTableResponseList = new ArrayList<ConversionTableResponseDTO>();;
		try {
				List<ConversionTable> conversionTableList = conversionTableRepository.findAll();
				if(conversionTableList != null && !conversionTableList.isEmpty()) {
						conversionTableList.forEach(conversionTableObj -> {
							ConversionTableResponseDTO conversionTableResponseDTO = new ConversionTableResponseDTO();
						BeanUtils.copyProperties(conversionTableObj, conversionTableResponseDTO);
						conversionTableResponseList.add(conversionTableResponseDTO);
					});
				}
				else {
					throw new ResourceNotFoundException("Requested Conversion Table is not exist");
				}
				
		}catch (Exception e) {
			logger.error("ConversionTableServiceImpl getAll failed" + e);
			throw e;
		}
		
		logger.info("Exiting getAll in ConversionTableServiceImpl  ..");
		return conversionTableResponseList;
	}
}
