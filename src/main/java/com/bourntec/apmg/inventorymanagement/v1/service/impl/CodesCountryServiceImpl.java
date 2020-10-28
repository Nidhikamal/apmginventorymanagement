package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CodesCountry;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesCountryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesCountryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.CodesCountryRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.CodesCountryService;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
/**
 * Service impl class for CodesCountry
 * @author Nince
 *
 */
@Service(value = "CodesCountryServiceImpl")
public class CodesCountryServiceImpl implements CodesCountryService {

	private static final Logger logger = LogManager.getLogger(CodesCountryServiceImpl.class);

	@Autowired
	private CodesCountryRepository codesCountryRepository;

	/**
	 * method to Fetching CodesCountry details by id
	 */
	public CodesCountryResponseDTO getCodesCountryByCountryCode(String countryCode) {
		CodesCountryResponseDTO dataRespDTO = new CodesCountryResponseDTO();
		try {
			logger.info("Entering getCodesCountryByCountryCode ..");
			Optional<CodesCountry> jobOptional = codesCountryRepository.findById(countryCode);
			if (jobOptional.isPresent()) {
				CodesCountry data = jobOptional.get();
				BeanUtils.copyProperties(data, dataRespDTO);
				dataRespDTO.setResponseMessage("Codes Country fetch successfully");
			} else {
				logger.error("Codes Country doesn't exist");
				dataRespDTO.setResponseMessage("Codes Country doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch: getCodesCountryByCountryCode of CodesCountryServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;
	}

	/**
	 * method which is used to save CodesCountry
	 */
	public CodesCountryResponseDTO saveCodesCountry(CodesCountryRequestDTO codesCountryReqDTO) {
		logger.info("Save Codes Country details ..");
		CodesCountryResponseDTO dataRespDTO = new CodesCountryResponseDTO();
		try {
			CodesCountry codesCountryData = codesCountryReqDTO.toModel(codesCountryReqDTO);
			CodesCountry codesCountryDataEntity = codesCountryRepository.save(codesCountryData);
			if (codesCountryDataEntity != null) {
				BeanUtils.copyProperties(codesCountryDataEntity, dataRespDTO);
				logger.info("Codes Country saved successfully");
				dataRespDTO.setResponseMessage("Codes Country saved successfully");
			} else {
				dataRespDTO.setResponseMessage("Failed to save Codes Country");
				logger.error("Failed to save Codes Country");
			}
		} catch (Exception e) {
			logger.error("Saving saveCodesCountry of CodesCountryServiceImpl :" + e);
			throw e;
		}

		return dataRespDTO;

	}

	/**
	 * method which is used to update CodesCountry
	 * 
	 */
	public CodesCountryResponseDTO updateCodesCountry(String countryCode, CodesCountryRequestDTO countryCodeReqDTO) {
		logger.info("update Codes Country details ..");
		CodesCountryResponseDTO codesCountryDataRespDTO = new CodesCountryResponseDTO();
		try {
			Optional<CodesCountry> inventoryKeywordOptional = codesCountryRepository.findById(countryCode);
			if (inventoryKeywordOptional.isPresent()) {
				CodesCountry codesCountry = countryCodeReqDTO.toModel(countryCodeReqDTO);
				codesCountry.setCountryCode(countryCode);
				CodesCountry dataEntity = codesCountryRepository.save(codesCountry);
				if (dataEntity != null) {
					BeanUtils.copyProperties(dataEntity, codesCountryDataRespDTO);
					codesCountryDataRespDTO.setResponseMessage("Codes Country updated successfully");
					logger.info("Codes Country updated successfully");
				} else {
					codesCountryDataRespDTO.setResponseMessage("Codes Country updation failed");
					logger.info("Codes Country updation failed");
				}
			} else {
				logger.info("Codes Country doesn't exist");
				codesCountryDataRespDTO.setResponseMessage("Codes Country doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update :updateCodesCountry of CodesCountryServiceImpl" + e);
			throw e;
		}

		return codesCountryDataRespDTO;
	}

	/**
	 * method which is used to get all Codes Country data
	 */
	public List<CodesCountryResponseDTO> findAllCodesCountry() {
		logger.info("Fetching all Codes Country data..");
		List<CodesCountryResponseDTO> resDTOs = new ArrayList<>();
		List<CodesCountry> codesCountryList = codesCountryRepository.findAll();
		for (CodesCountry codesCountry : codesCountryList) {
			CodesCountryResponseDTO responseDto =new CodesCountryResponseDTO();
			BeanUtils.copyProperties(codesCountry, responseDto);
			resDTOs.add(responseDto);
		}
		return resDTOs;
	}

	/**
	 * method which is used to find CodesCountry by criteria
	 */
	public List<CodesCountryResponseDTO> findCodesCountryByCriteria(
			CodesCountryRequestDTO jobReqDTO) {
		GenericSpesification<CodesCountry> genericSpesification = new GenericSpesification<CodesCountry>();
		logger.info("Fetching Codes Country data by criteria ..");
		if (jobReqDTO.getCountryCode() != null && !jobReqDTO.getCountryCode().isEmpty()) {
			genericSpesification.add(new SearchCriteria("countryCode", jobReqDTO.getCountryCode(), SearchOperation.MATCH));
		}
		if (jobReqDTO.getCountryName() != null && !jobReqDTO.getCountryName().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("countryName", jobReqDTO.getCountryName(), SearchOperation.MATCH));
		}
		return codesCountryRepository.findAll(genericSpesification);
	}

	/**
	 * method which is used to delete CodesCountry by countryCode
	 */

	public CodesCountryResponseDTO deleteCodesCountryByCountryCode(String countryCode) {
		logger.info("Entering delete CodesCountry", countryCode);
		CodesCountryResponseDTO dataRespDTO = new CodesCountryResponseDTO();
		Optional<CodesCountry> dataList = codesCountryRepository.findById(countryCode);
		CodesCountry codesCountryData = dataList.get();
		try {
			if (codesCountryData == null) {
				logger.info("The Codes Country doesn't exists!!!");
				dataRespDTO.setResponseMessage("The Codes Country doesn't exists!!!");
			} else {
				codesCountryRepository.delete(codesCountryData);
				dataRespDTO.setResponseMessage("Codes Country deleted successfully");
			}
			logger.info("Exiting deleteCodesCountry");
		} catch (Exception e) {
			logger.error("delete :deleteCodesCountryByCountryCode of CodesCountryServiceImpl  " + e);
			throw e;
		}
		return dataRespDTO;
	}
}
