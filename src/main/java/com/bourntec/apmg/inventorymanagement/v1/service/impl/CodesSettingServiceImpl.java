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
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesSettingRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesSettingResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.CodesSettingRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.CodesSettingService;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for CodeSettingServiceImpl
 * 
 * @author Srijini
 *
 */
@Service(value = "CodesSettingServiceImpl")
public class CodesSettingServiceImpl implements CodesSettingService {

	private static final Logger logger = LogManager.getLogger(CodesSettingServiceImpl.class);

	@Autowired
	private CodesSettingRepository codeSettingRepository;

	/**
	 * @author naveen This is the main method which is used findAllCodeSettings
	 */

	public List<CodesSettingResponseDTO> findAllCodeSettings()throws Exception {
		logger.info("Entering getAll in CodesSettingServiceImpl  ..");
		
		List<CodesSettingResponseDTO> marketCodeResponseList = new ArrayList<CodesSettingResponseDTO>();;
		try {
				List<CodesSetting> settingsList = codeSettingRepository.findAll();
				if(settingsList != null && !settingsList.isEmpty()) {
						settingsList.forEach(settingObj -> {
						CodesSettingResponseDTO settingResponseDTO = new CodesSettingResponseDTO();
						BeanUtils.copyProperties(settingObj, settingResponseDTO);
						marketCodeResponseList.add(settingResponseDTO);
					});
				}
				
		}catch (Exception e) {
			logger.error("CodesSettingServiceImpl getAll failed" + e);
			throw e;
		}
		
		logger.info("Exiting getAll in CodesSettingServiceImpl  ..");
		return marketCodeResponseList;
	}

	/**
	 * @author naveen This is the main method which is used to update Type Data by
	 *         settingId
	 */
	@Override
	public CodesSettingResponseDTO findBycodeSetting(String settingId) throws Exception{
		logger.info("Entering getById in CodesSettingServiceImpl  {}", settingId);

		CodesSettingResponseDTO codeSettingResponseDTO = new CodesSettingResponseDTO();
		try {

			Optional<CodesSetting> codesSetting = codeSettingRepository.findById(settingId);
			if(codesSetting.isPresent()) {
				CodesSetting settingObject = codesSetting.get();
				BeanUtils.copyProperties(settingObject, codeSettingResponseDTO);
			}else {
				logger.error("Codes settings doesn't exist");
				codeSettingResponseDTO.setResponseMessage("Code settings doesn't exist");
			}

			logger.info("Exiting getById  in CodesSettingServiceImpl {}", settingId);
		} 
		catch (Exception e) {
			logger.error("CodesSettingServiceImpl getById failed" + e);
			throw e;
		}
		return codeSettingResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to save codesetting
	 */
	@Override
	public CodesSettingResponseDTO savecodeSetting(CodesSettingRequestDTO codeSettingRequestDTO) throws Exception{

		logger.info("Entering savecodeSetting", codeSettingRequestDTO);

		CodesSettingResponseDTO codesSettingResponsetDTO = new CodesSettingResponseDTO();

		try {
			CodesSetting codesSetting = codeSettingRequestDTO.toModel(codeSettingRequestDTO);
			CodesSetting codesSettingObj = codeSettingRepository.save(codesSetting);
			if (codesSettingObj != null) {
				logger.info("Codes Setting Details is saved");
				BeanUtils.copyProperties(codesSettingObj, codesSettingResponsetDTO);
				codesSettingResponsetDTO.setResponseMessage("Codes Setting is saved Successfully");
			} else {
				logger.info("Codes Setting is not saved in DB");
				codesSettingResponsetDTO.setResponseMessage("Codes Setting is not saved");
			}
		}

		catch (Exception e) {
			logger.error("CodesSettingServiceImpl saveInvUnitCharge failed" + e);

			throw e;
		}
		return codesSettingResponsetDTO;
	}
	
	/**
	 * @author naveen This is the main method which is used to update codesetting
	 * 
	 * @return
	 */

	@Override
	public CodesSettingResponseDTO updatecodeSetting(String settingId, CodesSettingRequestDTO codeSettingRequestDTO) throws Exception{

		logger.info("Entering updatecodeSetting", codeSettingRequestDTO);
		CodesSettingResponseDTO marketCodeResponseDTO = new CodesSettingResponseDTO();

		try {
			Optional<CodesSetting> unitChargeList = codeSettingRepository.findById(settingId);
			if(unitChargeList.isPresent()) {
				
				CodesSetting settingObj = codeSettingRequestDTO.toModel(codeSettingRequestDTO);

				settingObj.setSettingId(settingId);

				CodesSetting saveMarketCodeTarget = codeSettingRepository.save(settingObj);
				logger.info("Codes Setting Details is updated");

				BeanUtils.copyProperties(saveMarketCodeTarget, marketCodeResponseDTO);
				marketCodeResponseDTO.setResponseMessage("Codes Setting is updated Successfully");
			}
			else {
				logger.info("The Codes Setting doesn't exists!!!");
				throw new ResourceNotFoundException("Requested Market Code with"+settingId+"Not Exists");
			}
			
			logger.info("Exiting updatecodeSetting");
		} 
		catch (Exception e) {
			logger.error(" CodesSettingServiceImpl updatecodeSetting  failed" + e);

			throw e;
		}
		return marketCodeResponseDTO;
	}

	@Override
	public CodesSettingResponseDTO delete(String id) throws Exception {
		logger.info("Entering delete  {}", id);
		CodesSettingResponseDTO marketCodeResponseDTO = new CodesSettingResponseDTO();
		try {
			Optional<CodesSetting> settingsList = codeSettingRepository.findById(id);
			if(settingsList.isPresent()) {
				CodesSetting marketCodeObj = settingsList.get();
				codeSettingRepository.delete(marketCodeObj);
				marketCodeResponseDTO.setResponseMessage("Codes Setting deleted");
			}
			else {
				throw new ResourceNotFoundException("No Codes Setting Exists");
			}
			
			logger.info("Exiting delete");
		} 
		catch (Exception e) {
			logger.error("CodesSettingServiceImpl delete failed" + e);
			throw e;
		}
		return marketCodeResponseDTO;
	
	}
	
	
	@Override
	public List<CodesSettingResponseDTO> search(CodesSettingRequestDTO codesSettingRequestDTO) throws Exception {
		logger.info("Entering For fetching all Codes Setting");
		List<CodesSettingResponseDTO> settingResponseDTOList = new ArrayList<CodesSettingResponseDTO>();
		try {
			List<CodesSetting> settingList = findByCriteria(codesSettingRequestDTO);
			if (settingList != null && !settingList.isEmpty()) {
				settingList.stream().forEach((settingObj) -> {
					CodesSettingResponseDTO settingResponseDTO = new CodesSettingResponseDTO();
					BeanUtils.copyProperties(settingObj, settingResponseDTO);
					settingResponseDTOList.add(settingResponseDTO);
				});
			} 
			else {
				logger.info("Codes Setting not found");
				throw new ResourceNotFoundException("Codes Setting not found ");
			}
		}catch(Exception e) {
			logger.error("CodesSettingServiceImpl  search failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all Codes Setting");
		return settingResponseDTOList;
	}
		
	/**
	 * Crtieria builder for fetching Market Code
	 * 
	 * @param settingRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<CodesSetting> findByCriteria(CodesSettingRequestDTO settingRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for Codes Setting ");
		
		GenericSpesification<CodesSetting> genericSpesification = new GenericSpesification<CodesSetting>();
		try {
			if(settingRequestDTO.getSettingId() != null && !settingRequestDTO.getSettingId().isEmpty()) {
				 genericSpesification.add(new SearchCriteria("settingId",settingRequestDTO.getSettingId(), SearchOperation.MATCH));
			}
			if(settingRequestDTO.getSettingName() != null && !settingRequestDTO.getSettingName().isEmpty()) {
		        genericSpesification.add(new SearchCriteria("settingName",settingRequestDTO.getSettingName(), SearchOperation.MATCH));
			}
			 return codeSettingRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("MarketCodeServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}
}
