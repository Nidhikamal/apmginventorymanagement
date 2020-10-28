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
import com.bourntec.apmg.entity.LockingType;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesShapeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.LockingTypeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesCountryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesCountryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.LockingTypeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.CodesCountryRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.StoneOriginService;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for StoneOriginServiceImpl
 * 
 * @author Srijini
 *
 */
@Service(value = "StoneOriginServiceImpl")
public class StoneOriginServiceImpl implements StoneOriginService {

	private static final Logger logger = LogManager.getLogger(StoneOriginServiceImpl.class);

	@Autowired
	private CodesCountryRepository codesCountryRepository;

	/**
	 * @author naveen This is the main method which is used to findAllCodesCountry
	 *         codes
	 */
	@Override
	public List<CodesCountryResponseDTO> findAllCodesCountry() throws Exception {

		List<CodesCountryResponseDTO> codesCountryResponsetDTOs = new ArrayList<CodesCountryResponseDTO>();
		try {
			List<CodesCountry> lockTypeList = codesCountryRepository.findAll();
			for (CodesCountry lockType : lockTypeList) {
				CodesCountryResponseDTO lockResponseDTO = new CodesCountryResponseDTO();
				BeanUtils.copyProperties(lockType, lockResponseDTO);
				codesCountryResponsetDTOs.add(lockResponseDTO);

			}
		} catch (Exception e) {
			logger.error("inventory control service findAllCodesCountry failed" + e);

			throw e;
		}
		return codesCountryResponsetDTOs;

	}

	/**
	 * @author naveen This is the main method which findcodeCountryById codes
	 */
	@Override
	public CodesCountryResponseDTO findcodeCountryById(String countryCode) throws Exception {
		CodesCountryResponseDTO codesCountryResponsetDTO = new CodesCountryResponseDTO();
		try {
			Optional<CodesCountry> lockTopye = codesCountryRepository.findById(countryCode);
			
			if(lockTopye.isPresent()) {
				BeanUtils.copyProperties(lockTopye.get(), codesCountryResponsetDTO);
				codesCountryResponsetDTO.setResponseMessage("Stone Origin data exits.");
			}
			else {
				codesCountryResponsetDTO.setResponseMessage("Stone Origin data not found.");
			}
		} catch (Exception e) {
			logger.error("inventory control service findPaymentTermsById failed" + e);
			throw e;
		}
		return codesCountryResponsetDTO;
	}

	/**
	 * @author naveen This is the main method which is used to save codeCountry
	 *         codes
	 */
	@Override
	public CodesCountryResponseDTO savecodeCountry(CodesCountryRequestDTO codesCountryRequestDTO) throws Exception {
		CodesCountryResponseDTO codesCountryResponsetDTO = new CodesCountryResponseDTO();
		try {
			CodesCountry codesCountry = codesCountryRequestDTO.toModel(codesCountryRequestDTO);
			CodesCountry codesCountryObject = codesCountryRepository.save(codesCountry);
			BeanUtils.copyProperties(codesCountryObject, codesCountryResponsetDTO);
			codesCountryResponsetDTO.setResponseMessage("countryCode saved successfully");
		} catch (Exception e) {
			logger.error("Save: codeCountry " + e);
			throw e;
		}
		return codesCountryResponsetDTO;
	}

	/**
	 * @author naveen This is the main method which is used to update stoneOrigin
	 *         data
	 */
	@Override
	public CodesCountryResponseDTO updateStoneOrigin(String countryCode,
			CodesCountryRequestDTO codesCountryRequestDTO) {

		Optional<CodesCountry> codesCountryrep = codesCountryRepository.findById(countryCode);
		CodesCountryResponseDTO codesCountryResponse = new CodesCountryResponseDTO();

		try {
			if (codesCountryrep == null) {
				logger.info("The countryCode doesn't exists!!!");
				codesCountryResponse.setResponseMessage("The countryCode doesn't exists");
			} else {

				CodesCountry codesCountryModel = codesCountryRequestDTO.toModel(codesCountryRequestDTO);

				codesCountryModel.setCountryCode(countryCode);
				CodesCountry codesCountryEntity = codesCountryRepository.save(codesCountryModel);
				logger.info("codesCountryEntity Details is updated");

				BeanUtils.copyProperties(codesCountryEntity, codesCountryResponse);
				codesCountryResponse.setResponseMessage("codesCountryEntity is updated in DB");
			}
		} catch (Exception e) {
			logger.error("update: CodesCountry " + e);
			throw e;
		}
		return codesCountryResponse;
	}

	@Override
	public CodesCountryResponseDTO delete(String id) throws Exception {
		codesCountryRepository.deleteById(id);
		return null;
	}

	@Override
	public List<CodesCountryResponseDTO> search(CodesCountryRequestDTO shapeRequestDTO) throws Exception {
		logger.info("Entering For fetching all CodesCountry");
		List<CodesCountryResponseDTO> memoManifestResponseDTOList = new ArrayList<CodesCountryResponseDTO>();
		try {
			List<CodesCountry> sizeList = findByCriteria(shapeRequestDTO);
			if (sizeList != null && !sizeList.isEmpty()) {
				sizeList.stream().forEach((MemoManifest) -> {
					CodesCountryResponseDTO sizeResponseDTO = new CodesCountryResponseDTO();
					BeanUtils.copyProperties(MemoManifest, sizeResponseDTO);
					memoManifestResponseDTOList.add(sizeResponseDTO);
				});

			} 
			else {
				logger.info("CodesCountry Data not found");
				throw new ResourceNotFoundException("CodesCountry Data not found ");
			}
			
		}
		catch(Exception e) {
			logger.error("CodesCountry search  failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all manifests");
		return memoManifestResponseDTOList;
	}
	private List<CodesCountry> findByCriteria(CodesCountryRequestDTO shapeRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for CodesCountry Data ");
		
		GenericSpesification<CodesCountry> genericSpesification = new GenericSpesification<CodesCountry>();
		try {
			if (shapeRequestDTO.getCountryCode() != null) {
				genericSpesification
						.add(new SearchCriteria("countryCode", shapeRequestDTO.getCountryCode(), SearchOperation.EQUAL));
			}
			if (shapeRequestDTO.getCountryName() != null && !shapeRequestDTO.getCountryName().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("countryName", shapeRequestDTO.getCountryName(), SearchOperation.MATCH));
			}
			 
			return codesCountryRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("MemoManifestServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}
}
