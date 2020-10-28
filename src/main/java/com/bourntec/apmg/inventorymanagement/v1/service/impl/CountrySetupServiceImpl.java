package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CountrySetup;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CountrySetupRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CountrySetupResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.repository.CountrySetupRepository;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.inventorymanagement.v1.service.CountrySetupService;

/**
 * 
 * Service class implementation for CountrySetupServiceImpl
 * 
 * @author Srijini
 *
 */
@Service(value = "CountrySetupServiceImpl")
public class CountrySetupServiceImpl implements CountrySetupService {

	private static final Logger logger = LogManager.getLogger(CountrySetupServiceImpl.class);

	@Autowired
	private CountrySetupRepository countrySetupRepo;

	/**
	 * @author amal This is the main method which is used to get Country Setup by
	 *         country code
	 */

	public CountrySetupResponseDTO findCountrySetupById(String id) {
		CountrySetupResponseDTO countryRespDTO = new CountrySetupResponseDTO();
		try {
			Optional<CountrySetup> colorCodesOptional = countrySetupRepo.findById(id);
			if (colorCodesOptional.isPresent()) {
				CountrySetup countrySetup = colorCodesOptional.get();
				BeanUtils.copyProperties(countrySetup, countryRespDTO);
				countryRespDTO.setResponseMessage("Country Setup found");
			} else {
				logger.error(" Country Setup doesn't exist");
				countryRespDTO.setResponseMessage("Country Setup not found");
			}
		} catch (Exception e) {
			logger.error("Fetch: findCountrySetupById " + e);
			throw e;
		}

		return countryRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all Country Setups
	 */

	public List<CountrySetup> findCountrySetup() {
		return countrySetupRepo.findAll();
	}

	/**
	 * @author amal This is the main method which is used to update Country Setups
	 */
	public CountrySetupResponseDTO updateCountrySetupById(String countryCode,
			CountrySetupRequestDTO countrySetupReqDTO) {
		CountrySetupResponseDTO countrySetupRespDTO = new CountrySetupResponseDTO();
		try {
			Optional<CountrySetup> invunitChargeOptional = countrySetupRepo.findById(countryCode);
			if (invunitChargeOptional.isPresent()) {
				CountrySetup countrySetup = countrySetupReqDTO.toModel(countrySetupReqDTO);
				countrySetup.setCountryCode(countryCode);
				CountrySetup countrySetupEntity = countrySetupRepo.save(countrySetup);
				if (countrySetupEntity != null) {
					BeanUtils.copyProperties(countrySetupEntity, countrySetupRespDTO);
					countrySetupRespDTO.setResponseMessage("Country Setup updated successfully");
					logger.info(" Country Setup updated successfully");
				} else {
					logger.error(" Country Setup updation failed");
				}
			} else {
				logger.error(" Country Setup doesn't exist");
				countrySetupRespDTO.setResponseMessage("Country Setup doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update: updateCountrySetupById " + e);
			throw e;
		}

		return countrySetupRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to save Country Setups
	 */

	public CountrySetupResponseDTO saveCountrySetup(CountrySetupRequestDTO countrySetupReqDTO) {
		CountrySetupResponseDTO countryRespDTO = new CountrySetupResponseDTO();
		try {
			CountrySetup countrySetup = countrySetupReqDTO.toModel(countrySetupReqDTO);
			CountrySetup countrySetupEntity = countrySetupRepo.save(countrySetup);
			if (countrySetupEntity != null) {
				BeanUtils.copyProperties(countrySetupEntity, countryRespDTO);
				countryRespDTO.setResponseMessage("Country Setup saved successfully");
				logger.info(" Country Setup saved successfully");
			} else {
				logger.error("Failed to save country setup");
			}
		} catch (Exception e) {
			logger.error("Save: saveCountrySetup " + e);
			throw e;
		}

		return countryRespDTO;
	}

	@Override
	public CountrySetupResponseDTO delete(String id) {
		logger.info("Entering to CountrySetup deletion  {}", id);
		CountrySetupResponseDTO dataRespDTO = new CountrySetupResponseDTO();
		Optional<CountrySetup> dataList = countrySetupRepo.findById(id);
		CountrySetup CountrySetupdata = dataList.get();
		try {
			if (CountrySetupdata == null) {
				logger.info("The CountrySetupdata doesn't exists!!!");
				dataRespDTO.setResponseMessage("The CountrySetupdata doesn't exists!!!");
			} else {
				countrySetupRepo.delete(CountrySetupdata);
				dataRespDTO.setResponseMessage(" CountrySetupdata delete successfully");
			}
			logger.info("Exiting CountrySetupdata");
		} catch (Exception e) {
			logger.error("delete :deleteCountrySetupdataById of CountrySetupServiceImpl " + e);
			throw e;
		}
		return dataRespDTO;
	}
 	 
	@Override
	public List<CountrySetupResponseDTO> search(CountrySetupRequestDTO shapeRequestDTO) throws Exception {
		logger.info("Entering For fetching all CountrySetup");
		List<CountrySetupResponseDTO> memoManifestResponseDTOList = new ArrayList<CountrySetupResponseDTO>();
		try {
			List<CountrySetup> sizeList = findByCriteria(shapeRequestDTO);
			if (sizeList != null && !sizeList.isEmpty()) {
				sizeList.stream().forEach((MemoManifest) -> {
					CountrySetupResponseDTO sizeResponseDTO = new CountrySetupResponseDTO();
					BeanUtils.copyProperties(MemoManifest, sizeResponseDTO);
					memoManifestResponseDTOList.add(sizeResponseDTO);
				});

			} 
			else {
				logger.info("CountrySetup Data not found");
				throw new ResourceNotFoundException("CountrySetup Data not found ");
			}
			
		}
		catch(Exception e) {
			logger.error("CountrySetupDataServiceImpl  failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all manifests");
		return memoManifestResponseDTOList;
	}
	
	private List<CountrySetup> findByCriteria(CountrySetupRequestDTO shapeRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for CountrySetup Data ");
		
		GenericSpesification<CountrySetup> genericSpesification = new GenericSpesification<CountrySetup>();
		try {
			if (shapeRequestDTO.getCountryCode() != null && !shapeRequestDTO.getCountryCode().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("countryCode", shapeRequestDTO.getCountryCode(), SearchOperation.EQUAL));
			}
			if (shapeRequestDTO.getCountryName() != null && !shapeRequestDTO.getCountryName().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("countryName", shapeRequestDTO.getCountryName(), SearchOperation.MATCH));
			}
			 	
			return countrySetupRepo.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("MemoManifestServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}
}
