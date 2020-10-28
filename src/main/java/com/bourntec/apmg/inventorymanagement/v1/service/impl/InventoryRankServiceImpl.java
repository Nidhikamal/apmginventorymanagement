package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.AdditionalOrderData;
import com.bourntec.apmg.entity.CountrySetup;
import com.bourntec.apmg.entity.InventoryRank;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.AdditionalOrderDataRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CountrySetupRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryRankRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.AdditionalOrderDataResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CountrySetupResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryRankResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryRankRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryRankService;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for InventoryRankServiceImpl
 * 
 * @author Srijini
 *
 */
@Service(value = "InventoryRankServiceImpl")
public class InventoryRankServiceImpl implements InventoryRankService {

	private static final Logger logger = LogManager.getLogger(InventoryRankServiceImpl.class);

	@Autowired
	private InventoryRankRepository invRankRepo;

	/**
	 * @author amal This is the main method which is used to get Inventory Rank by
	 *         id
	 */

	public InventoryRankResponseDTO findInvRankById(String id)  throws Exception{
		InventoryRankResponseDTO invRankRespDTO = new InventoryRankResponseDTO();
		try {
			Optional<InventoryRank> invRankOptional = invRankRepo.findById(id);
			if (invRankOptional.isPresent()) {
				InventoryRank invRankCharge = invRankOptional.get();
				BeanUtils.copyProperties(invRankCharge, invRankRespDTO);
				invRankRespDTO.setResponseMessage("Inventory Rank found");
			} else {
				logger.error(" Inventory Rank doesn't exist");
				invRankRespDTO.setResponseMessage("Inventory Rank not found");
			}
		} catch (Exception e) {
			logger.error("Fetch Inventory Rank " + e);
			throw e;
		}

		return invRankRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all Inventory Ranks
	 */
	public List<InventoryRank> findAllInvRanks()  throws Exception{
		return invRankRepo.findAll();
	}

	/**
	 * @author amal This is the main method which is used to update Inventory Ranks
	 *         by id
	 */

	public InventoryRankResponseDTO updateInvRankById(String rank, InventoryRankRequestDTO invRankReqDTO)  throws Exception{
		InventoryRankResponseDTO invRankResDTO = new InventoryRankResponseDTO();
		try {
			Optional<InventoryRank> invCatOptional = invRankRepo.findById(rank);
			if (invCatOptional.isPresent()) {
				InventoryRank invRank = invRankReqDTO.toModel(invRankReqDTO);
				invRank.setRank(rank);
				InventoryRank typeDataEntity = invRankRepo.save(invRank);
				if (typeDataEntity != null) {
					BeanUtils.copyProperties(typeDataEntity, invRankResDTO);
					invRankResDTO.setResponseMessage("Inventory Rank updated successfully");
					logger.info(" Inventory Rank updated successfully");
				} else {
					logger.error("Inventory Rank updation failed");
				}
			} else {
				logger.error(" Inventory Rank doesn't exist");
				invRankResDTO.setResponseMessage("Inventory Rank doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update: updateInvRankById " + e);
			throw e;
		}

		return invRankResDTO;
	}

	/**
	 * @author amal This is the main method which is used to save Inventory Ranks
	 */

	public InventoryRankResponseDTO saveInvRanks(InventoryRankRequestDTO invRankReqDTO)  throws Exception{
		InventoryRankResponseDTO invRankRespDTO = new InventoryRankResponseDTO();
		try {
			InventoryRank invRank = invRankReqDTO.toModel(invRankReqDTO);
			InventoryRank invRankEntity = invRankRepo.save(invRank);
			if (invRankEntity != null) {
				BeanUtils.copyProperties(invRankEntity, invRankRespDTO);
				invRankRespDTO.setResponseMessage("Inventory Rank saved successfully");
				logger.info("Inventory Rank saved successfully");
			} else {
				logger.error("Failed to save Inventory Rank ");
			}
		} catch (Exception e) {
			logger.error("Save: saveInvRanks " + e);
			throw e;
		}

		return invRankRespDTO;
	}

	@Override
	public InventoryRankResponseDTO delete(String id) throws Exception {
			logger.info("Entering to InventoryRank deletion  {}", id);
			InventoryRankResponseDTO dataRespDTO = new InventoryRankResponseDTO();
			Optional<InventoryRank> dataList = invRankRepo.findById(id);
			InventoryRank InventoryRank = dataList.get();
			try {
				if (InventoryRank == null) {
					logger.info("The InventoryRank doesn't exists!!!");
					dataRespDTO.setResponseMessage("The InventoryRank doesn't exists!!!");
				} else {
					invRankRepo.delete(InventoryRank);
					dataRespDTO.setResponseMessage(" InventoryRank delete successfully");
				}
				logger.info("Exiting CountrySetupdata");
			} catch (Exception e) {
				logger.error("delete :deleteInventoryRankdataById of InventoryRankServiceImpl " + e);
				throw e;
			}
			return dataRespDTO;
		}
	@Override
		public List<InventoryRankResponseDTO> search(InventoryRankRequestDTO shapeRequestDTO) throws Exception {
			logger.info("Entering For fetching all InventoryRank");
			List<InventoryRankResponseDTO> memoManifestResponseDTOList = new ArrayList<InventoryRankResponseDTO>();
			try {
				List<InventoryRank> sizeList = findByCriteria(shapeRequestDTO);
				if (sizeList != null && !sizeList.isEmpty()) {
					sizeList.stream().forEach((MemoManifest) -> {
						InventoryRankResponseDTO sizeResponseDTO = new InventoryRankResponseDTO();
						BeanUtils.copyProperties(MemoManifest, sizeResponseDTO);
						memoManifestResponseDTOList.add(sizeResponseDTO);
					});

				} 
				else {
					logger.info("Inventory Rank Data not found");
					throw new ResourceNotFoundException("Inventory Rank Data not found ");
				}
				
			}
			catch(Exception e) {
				logger.error("InventoryRankDataServiceImpl  failed" + e);
				throw e;
			}
			logger.info("Exiting after fetching all manifests");
			return memoManifestResponseDTOList;
		}
	
	private List<InventoryRank> findByCriteria(InventoryRankRequestDTO shapeRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for Inventory Rank Data ");
		
		GenericSpesification<InventoryRank> genericSpesification = new GenericSpesification<InventoryRank>();
		try {
			if (shapeRequestDTO.getRank() != null && !shapeRequestDTO.getRank().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("rank", shapeRequestDTO.getRank(), SearchOperation.MATCH));
			}
			if (shapeRequestDTO.getDesc1() != null && !shapeRequestDTO.getDesc1().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("desc1", shapeRequestDTO.getDesc1(), SearchOperation.MATCH));
			}
			if (shapeRequestDTO.getLocationCode() != null && !shapeRequestDTO.getLocationCode().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("locationCode", shapeRequestDTO.getLocationCode(), SearchOperation.MATCH));
			}	
			return invRankRepo.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("MemoManifestServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}
	
	}


