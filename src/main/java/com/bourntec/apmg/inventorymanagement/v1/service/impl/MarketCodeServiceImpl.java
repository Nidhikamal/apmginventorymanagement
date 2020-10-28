package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.MarketCode;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.MarketCodeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.MarketCodeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.MarketCodeRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.MarketCodeService;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for MarketCodeServiceImpl
 * 
 * @author Nince
 *
 */
@Service(value = "MarketCodeServiceImpl")
public class MarketCodeServiceImpl implements MarketCodeService {


	private static final Logger logger = LogManager.getLogger(MarketCodeServiceImpl.class);

	@Autowired
	MarketCodeRepository marketCodeRepository;

	/**
	 * Method to saves a Market Code
	 */
	
	@Override
	public MarketCodeResponseDTO saveMarketCode(MarketCodeRequestDTO marketCodeRequestDTO) {
		logger.info("Entering saveMarketCode", marketCodeRequestDTO);

		MarketCodeResponseDTO marketCodeResponsetDTO = new MarketCodeResponseDTO();

		try {
			MarketCode marketCode = marketCodeRequestDTO.toModel(marketCodeRequestDTO);
			MarketCode marketObj = marketCodeRepository.save(marketCode);
			if (marketObj != null) {
				logger.info("Market Code Details is saved");
				BeanUtils.copyProperties(marketObj, marketCodeResponsetDTO);
				marketCodeResponsetDTO.setResponseMessage("Market Code is saved Successfully");
			} else {
				logger.info("Market Code is not saved in DB");
				marketCodeResponsetDTO.setResponseMessage("Market Code is not saved");
			}
		}

		catch (Exception e) {
			logger.error("MarketCodeServiceImpl saveInvUnitCharge failed" + e);

			throw e;
		}
		return marketCodeResponsetDTO;
	}
	/**
	 * Method that updates a Market Code
	 */
	@Override
	public MarketCodeResponseDTO updateMarketCode(String marketCode, MarketCodeRequestDTO marketCodeRequestDTO) {
		logger.info("Entering updateMarketCode", marketCodeRequestDTO);
		MarketCodeResponseDTO marketCodeResponseDTO = new MarketCodeResponseDTO();

		try {
			Optional<MarketCode> unitChargeList = marketCodeRepository.findById(marketCode);
			if(unitChargeList.isPresent()) {
				
				MarketCode marketCodeObj = marketCodeRequestDTO.toModel(marketCodeRequestDTO);

				marketCodeObj.setMarketCode(marketCode);

				MarketCode saveMarketCodeTarget = marketCodeRepository.save(marketCodeObj);
				logger.info("Market Code Details is updated");

				BeanUtils.copyProperties(saveMarketCodeTarget, marketCodeResponseDTO);
				marketCodeResponseDTO.setResponseMessage("Market Code is updated Successfully");
			}
			else {
				logger.info("The Market Code doesn't exists!!!");
				throw new ResourceNotFoundException("Requested Market Code with"+marketCode+"Not Exists");
			}
			
			logger.info("Exiting updateMarketCode");
		} 
		catch (Exception e) {
			logger.error(" MarketCodeServiceImpl updateMarketCode  failed" + e);

			throw e;
		}
		return marketCodeResponseDTO;
	}
	
	/**
	 * Retrieval of Market Code object based on requested marketCode
	 */
	@Override
	public MarketCodeResponseDTO getById(String marketCode) {
		logger.info("Entering getById in MarketCodeServiceImpl  {}", marketCode);

		MarketCodeResponseDTO marketCodeResponseDTO = new MarketCodeResponseDTO();
		try {

			Optional<MarketCode> marketCodeObj = marketCodeRepository.findById(marketCode);
			if(marketCodeObj.isPresent()) {
				MarketCode marketObject = marketCodeObj.get();
				BeanUtils.copyProperties(marketObject, marketCodeResponseDTO);
			}
			else {
				marketCodeResponseDTO.setResponseMessage("Requested Market Code with "+marketCode+" is not exist");
			}

			logger.info("Exiting getById  in MarketCodeServiceImpl {}", marketCode);
		} 
		catch (Exception e) {
			logger.error("MarketCodeServiceImpl getById failed" + e);
			throw e;
		}
		return marketCodeResponseDTO;
	}
	
	/**
	 * Fetch all the Market Code in the DB
	 */
	@Override
	public List<MarketCodeResponseDTO> getAll() {
		logger.info("Entering getAll in MarketCodeServiceImpl  ..");
		
		List<MarketCodeResponseDTO> marketCodeResponseList = new ArrayList<MarketCodeResponseDTO>();;
		try {
				List<MarketCode> marketCodeList = marketCodeRepository.findAll();
				if(marketCodeList != null && !marketCodeList.isEmpty()) {
						marketCodeList.forEach(marketCodeObj -> {
							MarketCodeResponseDTO marketCodeResponseDTO = new MarketCodeResponseDTO();
						BeanUtils.copyProperties(marketCodeObj, marketCodeResponseDTO);
						marketCodeResponseList.add(marketCodeResponseDTO);
					});
				}
				/*
				 * else { throw new
				 * ResourceNotFoundException("Requested Market Code is not exist"); }
				 */
				
		}catch (Exception e) {
			logger.error("MarketCodeServiceImpl getAll failed" + e);
			throw e;
		}
		
		logger.info("Exiting getAll in MarketCodeServiceImpl  ..");
		return marketCodeResponseList;
	}
	
	/**
	 * Fetches Memo Manifest objects in DB based on criteria
	 */
	@Override
	public List<MarketCodeResponseDTO> fetchByMarketCode(MarketCodeRequestDTO marketCodeRequestDTO) throws Exception {
		logger.info("Entering For fetching all Market Code");
		List<MarketCodeResponseDTO> unitChargeResponseDTOList = new ArrayList<MarketCodeResponseDTO>();
		try {
			List<MarketCode> marketCodeList = findByCriteria(marketCodeRequestDTO);
			if (marketCodeList != null && !marketCodeList.isEmpty()) {
				marketCodeList.stream().forEach((marketCodeObj) -> {
					MarketCodeResponseDTO marketCodeResponseDTO = new MarketCodeResponseDTO();
					BeanUtils.copyProperties(marketCodeObj, marketCodeResponseDTO);
					unitChargeResponseDTOList.add(marketCodeResponseDTO);
				});

			} 
			else {
				logger.info("Market Code not found");
				throw new ResourceNotFoundException("Market Code not found ");
			}
			
		}
		catch(Exception e) {
			logger.error("MarketCodeServiceImpl  fetchByMarketCode failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all Market Code");
		return unitChargeResponseDTOList;
	}
		
	/**
	 * Crtieria builder for fetching Market Code
	 * 
	 * @param marketCodeRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<MarketCode> findByCriteria(MarketCodeRequestDTO marketCodeRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for Market Code ");
		
		GenericSpesification<MarketCode> genericSpesification = new GenericSpesification<MarketCode>();
		try {
			if (marketCodeRequestDTO.getMarketCode() != null && !marketCodeRequestDTO.getMarketCode().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("marketCode", marketCodeRequestDTO.getMarketCode(), SearchOperation.EQUAL));
			}
			if (marketCodeRequestDTO.getMarketName() != null && !marketCodeRequestDTO.getMarketName().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("marketName", marketCodeRequestDTO.getMarketName(), SearchOperation.EQUAL));
			}
			if (marketCodeRequestDTO.getDesc1() != null && !marketCodeRequestDTO.getDesc1().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("desc1", marketCodeRequestDTO.getDesc1(), SearchOperation.EQUAL));
			}
			if (marketCodeRequestDTO.getLocationCode() != null && !marketCodeRequestDTO.getLocationCode().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("locationCode", marketCodeRequestDTO.getLocationCode(), SearchOperation.EQUAL));
			}
			return marketCodeRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("MarketCodeServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}
	/**
	 * Deletes a Market Code from the DB
	 */
	@Override
	public MarketCodeResponseDTO deleteMarketCode(String marketCode) {
		logger.info("Entering deleteMarketCode  {}", marketCode);
		MarketCodeResponseDTO marketCodeResponseDTO = new MarketCodeResponseDTO();
		try {
			Optional<MarketCode> marketCodeList = marketCodeRepository.findById(marketCode);
			if(marketCodeList.isPresent()) {
				MarketCode marketCodeObj = marketCodeList.get();
				marketCodeRepository.delete(marketCodeObj);
				marketCodeResponseDTO.setResponseMessage("Market Code deleted");
			}
			else {
				throw new ResourceNotFoundException("No Market Code Exists");
			}
			
			logger.info("Exiting deleteMarketCode");
		} 
		catch (Exception e) {
			logger.error("MarketCodeServiceImpl deleteMarketCode failed" + e);
			throw e;
		}
		return marketCodeResponseDTO;
	}


}
