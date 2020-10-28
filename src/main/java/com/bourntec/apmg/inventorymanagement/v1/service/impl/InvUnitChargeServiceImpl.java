package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.InvUnitCharge;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InvUnitChargeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvUnitChargeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.repository.InvUnitChargeRepository;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.inventorymanagement.v1.service.InvUnitChargeService;

/**
 * 
 * Service class implementation for InvTypeServiceImpl
 * 
 * @author Nince
 *
 */
@Service(value = "InvUnitChargeServiceImpl")
public class InvUnitChargeServiceImpl implements InvUnitChargeService {


	private static final Logger logger = LogManager.getLogger(InvUnitChargeServiceImpl.class);

	@Autowired
	InvUnitChargeRepository invUnitChargeRepository;

	/**
	 * Method saves a Inv Unit Charge
	 */
	
	@Override
	public InvUnitChargeResponseDTO saveInvUnitCharge(InvUnitChargeRequestDTO manifestRequestDTO) {
		logger.info("Entering saveMemoManifest", manifestRequestDTO);

		InvUnitChargeResponseDTO invUnitChargeResponsetDTO = new InvUnitChargeResponseDTO();

		try {
			InvUnitCharge invUnitCharge = manifestRequestDTO.toModel(manifestRequestDTO);
			InvUnitCharge invUnit = invUnitChargeRepository.save(invUnitCharge);
			if (invUnit != null) {
				logger.info("Inv Unit Charge Details is saved");
				BeanUtils.copyProperties(invUnit, invUnitChargeResponsetDTO);
				invUnitChargeResponsetDTO.setResponseMessage("Inv Unit Charge is saved Successfully");
			} else {
				logger.info("Inv Unit Charge is not saved in DB");
				invUnitChargeResponsetDTO.setResponseMessage("Inv Unit Charge is not saved");
			}
		}

		catch (Exception e) {
			logger.error("InvUnitChargeServiceImpl saveInvUnitCharge failed" + e);

			throw e;
		}
		return invUnitChargeResponsetDTO;
	}
	/**
	 * Method that updates a Memo Manifest
	 */
	@Override
	public InvUnitChargeResponseDTO updateInvUnitCharge(String unitCharge, InvUnitChargeRequestDTO invUnitChargeRequestDTO) {
		logger.info("Entering updateInvUnitCharge", invUnitChargeRequestDTO);
		InvUnitChargeResponseDTO invUnitChargeResponsedto = new InvUnitChargeResponseDTO();

		try {
			Optional<InvUnitCharge> unitChargeList = invUnitChargeRepository.findById(unitCharge);
			if(unitChargeList.isPresent()) {
				
				InvUnitCharge unitChargeObj = invUnitChargeRequestDTO.toModel(invUnitChargeRequestDTO);

				unitChargeObj.setUnitCharge(unitCharge);

				InvUnitCharge saveInvUnitCharget = invUnitChargeRepository.save(unitChargeObj);
				logger.info("Inv Unit Charge Details is updated");

				BeanUtils.copyProperties(saveInvUnitCharget, invUnitChargeResponsedto);
				invUnitChargeResponsedto.setResponseMessage("Inv Unit Charge is updated Successfully");
			}
			else {
				logger.info("The Inv Unit Charge doesn't exists!!!");
				throw new ResourceNotFoundException("Requested Inv Unit Charge with"+unitCharge+"Not Exists");
			}
			
			logger.info("Exiting updateInvUnitCharge");
		} 
		catch (Exception e) {
			logger.error(" InvUnitChargeServiceImpl updateInvUnitCharge  failed" + e);

			throw e;
		}
		return invUnitChargeResponsedto;
	}
	
	/**
	 * Retrieval of Inv Unit CHarge object based on requested unitCharge
	 */
	@Override
	public InvUnitChargeResponseDTO getById(String unitCharge) {
		logger.info("Entering getById in InvUnitChargeServiceImpl  {}", unitCharge);

		InvUnitChargeResponseDTO unitChargeResponsedto = new InvUnitChargeResponseDTO();
		try {

			Optional<InvUnitCharge> memoManifestObj = invUnitChargeRepository.findById(unitCharge);
			if(memoManifestObj.isPresent()) {
				InvUnitCharge invUnitChargeObj = memoManifestObj.get();
				BeanUtils.copyProperties(invUnitChargeObj, unitChargeResponsedto);
			}
			else {
				throw new ResourceNotFoundException("Requested Memo Manifest with "+unitCharge+" is not exist");
			}

			logger.info("Exiting getById  in InvUnitChargeServiceImpl {}", unitCharge);
		} 
		catch (Exception e) {
			logger.error("InvUnitChargeServiceImpl getById failed" + e);
			throw e;
		}
		return unitChargeResponsedto;
	}
	
	/**
	 * Fetch all the Memo Manifest in the DB
	 */
	@Override
	public List<InvUnitChargeResponseDTO> getAll() {
		logger.info("Entering getAll in InvUnitChargeServiceImpl  ..");
		
		List<InvUnitChargeResponseDTO> unitChargeResponseList = new ArrayList<InvUnitChargeResponseDTO>();;
		try {
				List<InvUnitCharge> unitChargeList = invUnitChargeRepository.findAll();
				if(unitChargeList != null && !unitChargeList.isEmpty()) {
						unitChargeList.forEach(unitCharge -> {
							InvUnitChargeResponseDTO memoManifestResponsedto = new InvUnitChargeResponseDTO();
						BeanUtils.copyProperties(unitCharge, memoManifestResponsedto);
						unitChargeResponseList.add(memoManifestResponsedto);
					});
				}
				else {
					throw new ResourceNotFoundException("Requested Memo Manifest is not exist");
				}
				
		} 
		catch (Exception e) {
			logger.error("InvUnitChargeServiceImpl getAll failed" + e);
			throw e;
		}
		
		logger.info("Exiting getAll in InvUnitChargeServiceImpl  ..");
		return unitChargeResponseList;
	}
	
	/**
	 * Fetches Memo Manifest objects in DB based on criteria
	 */
	@Override
	public List<InvUnitChargeResponseDTO> fetchByInvUnitCharge(InvUnitChargeRequestDTO unitChargeRequestDTO) throws Exception {
		logger.info("Entering For fetching all unit charge");
		List<InvUnitChargeResponseDTO> unitChargeResponseDTOList = new ArrayList<InvUnitChargeResponseDTO>();
		try {
			List<InvUnitCharge> unitChargeList = findByCriteria(unitChargeRequestDTO);
			if (unitChargeList != null && !unitChargeList.isEmpty()) {
				unitChargeList.stream().forEach((unitChargeObj) -> {
					InvUnitChargeResponseDTO unitChargeResponseDTO = new InvUnitChargeResponseDTO();
					BeanUtils.copyProperties(unitChargeObj, unitChargeResponseDTO);
					unitChargeResponseDTOList.add(unitChargeResponseDTO);
				});

			} 
			else {
				logger.info("Inv Unit Charge not found");
				throw new ResourceNotFoundException(" Inv Unit Charge not found ");
			}
			
		}
		catch(Exception e) {
			logger.error("InvUnitChargeServiceImpl  fetchByInvUnitCharge failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all inv unit charge");
		return unitChargeResponseDTOList;
	}
		
	/**
	 * Crtieria builder for fetching Memo Manifest
	 * 
	 * @param unitChargeRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<InvUnitCharge> findByCriteria(InvUnitChargeRequestDTO unitChargeRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for Inv Unit Charge ");
		
		GenericSpesification<InvUnitCharge> genericSpesification = new GenericSpesification<InvUnitCharge>();
		try {
			if (unitChargeRequestDTO.getUnitCharge() != null && !unitChargeRequestDTO.getUnitCharge().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("unitCharge", unitChargeRequestDTO.getUnitCharge(), SearchOperation.EQUAL));
			}
			if (unitChargeRequestDTO.getUnitDesc() != null && !unitChargeRequestDTO.getUnitDesc().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("unitDesc", unitChargeRequestDTO.getUnitDesc(), SearchOperation.EQUAL));
			}
			
			return invUnitChargeRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("InvUnitChargeServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}
	/**
	 * Deletes a Memo Manifest from the DB
	 */
	@Override
	public InvUnitChargeResponseDTO deleteInvUnitCharge(String unitCharge) {
		logger.info("Entering deleteInvUnitCharge  {}", unitCharge);
		InvUnitChargeResponseDTO invUnitChargeResponseDTO = new InvUnitChargeResponseDTO();
		try {
			Optional<InvUnitCharge> unitChargeList = invUnitChargeRepository.findById(unitCharge);
			if(unitChargeList.isPresent()) {
				InvUnitCharge unitChargeObj = unitChargeList.get();
				invUnitChargeRepository.delete(unitChargeObj);
				invUnitChargeResponseDTO.setResponseMessage("Inv Unit Charge deleted");
			}
			else {
				throw new ResourceNotFoundException("No Inv Unit Charge Exists");
			}
			
			logger.info("Exiting deleteInvUnitCharge");
		} 
		catch (Exception e) {
			logger.error("InvUnitChargeServiceImpl deleteMemoManifest failed" + e);
			throw e;
		}
		return invUnitChargeResponseDTO;
	}


}
