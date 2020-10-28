package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CodeClarity;
import com.bourntec.apmg.entity.CountrySetup;
import com.bourntec.apmg.entity.InventoryCategory;
import com.bourntec.apmg.entity.MarketCode;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodeClarityRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryCategoryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.MarketCodeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodeClarityResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CountrySetupResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvCategoryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.MarketCodeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryCategoryRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.InvCategoryService;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for InvCategoryServiceImpl
 * 
 * @author Srijini
 *
 */
@Service(value = "InvCategoryServiceImpl")
public class InvCategoryServiceImpl implements InvCategoryService {

	private static final Logger logger = LogManager.getLogger(InvCategoryServiceImpl.class);

	@Autowired
	private InventoryCategoryRepository invCatRepo;

	/**
	 * @author amal This is the main method which is used to get Inventory Category
	 *         by id
	 */

	public InvCategoryResponseDTO findInvCategoryById(String id) {
		InvCategoryResponseDTO invCategoryRespDTO = new InvCategoryResponseDTO();
		try {
			Optional<InventoryCategory> invCatOptional = invCatRepo.findById(id);
			if (invCatOptional.isPresent()) {
				InventoryCategory invCatCharge = invCatOptional.get();
				BeanUtils.copyProperties(invCatCharge, invCategoryRespDTO);
				invCategoryRespDTO.setResponseMessage("Inventory Category found");
			} else {
				logger.info(" Inventory Category doesn't exist");
				invCategoryRespDTO.setResponseMessage("Inventory Category not found");
			}
		} catch (Exception e) {
			logger.error("Fetch Inventory Category " + e);
			throw e;
		}

		return invCategoryRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all Inventory
	 *         Categories
	 */
	public List<InventoryCategory> findAllInvCategories() {
		return invCatRepo.findAll();
	}

	/**
	 * @author amal This is the main method which is used to update Inventory
	 *         Categories
	 */
	public InvCategoryResponseDTO updateInvCategoryById(String category, InventoryCategoryRequestDTO invCatReqDTO) {
		InvCategoryResponseDTO invCatRespDTO = new InvCategoryResponseDTO();
		try {
			Optional<InventoryCategory> invCatOptional = invCatRepo.findById(category);
			if (invCatOptional.isPresent()) {
				InventoryCategory invCat = invCatReqDTO.toModel(invCatReqDTO);
				invCat.setCategory(category);
				InventoryCategory invcategoryupEntity = invCatRepo.save(invCat);
				if (invcategoryupEntity != null) {
					BeanUtils.copyProperties(invcategoryupEntity, invCatRespDTO);
					invCatRespDTO.setResponseMessage(" Inventory Category updated successfully");
					logger.info(" Inventory Category updated successfully");
				} else {
					logger.error(" Inventory Category updation failed");
				}
			} else {
				logger.error(" Inventory Category doesn't exist");
				invCatRespDTO.setResponseMessage(" Inventory Category doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update: updateInvCategoryById " + e);
			throw e;
		}

		return invCatRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to save Inventory
	 *         Categories
	 */

	public InvCategoryResponseDTO saveInvCategories(InventoryCategoryRequestDTO invCatReqDTO) {
		InvCategoryResponseDTO invCatRespDTO = new InvCategoryResponseDTO();
		try {
			InventoryCategory invCat = invCatReqDTO.toModel(invCatReqDTO);
			InventoryCategory invCatEntity = invCatRepo.save(invCat);
			if (invCatEntity != null) {
				BeanUtils.copyProperties(invCatEntity, invCatRespDTO);
				invCatRespDTO.setResponseMessage("Inventory Category saved successfully");
				logger.info(" Inventory Category saved successfully");
			} else {
				logger.error(" Failed to save Inventory Category ");
			}
		} catch (Exception e) {
			logger.error("Save: saveInvCategories " + e);
			throw e;
		}

		return invCatRespDTO;
	}

	@Override
	public List<InvCategoryResponseDTO> search(InventoryCategoryRequestDTO requestDTO) throws Exception{
		List<InvCategoryResponseDTO> categoryResponseDTOs = new ArrayList<InvCategoryResponseDTO>();
		try {
			List<InventoryCategory> categoryList = findByCriteria(requestDTO);
			if (categoryList != null && !categoryList.isEmpty()) {
				categoryList
				.stream().forEach((marketCodeObj) -> {
					InvCategoryResponseDTO responseDTO = new InvCategoryResponseDTO();
					BeanUtils.copyProperties(marketCodeObj, responseDTO);
					categoryResponseDTOs.add(responseDTO);
				});

			} 
			else {
				logger.info("category not found");
				//throw new ResourceNotFoundException("category not found ");
			}
			
		}
		catch(Exception e) {
			logger.error("InvCategoryServiceImpl  search failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all category");
		return categoryResponseDTOs;
	}

	@Override
	public InvCategoryResponseDTO delete(String id) {
		logger.info("Entering to InventoryCategory deletion  {}", id);
		InvCategoryResponseDTO dataRespDTO = new InvCategoryResponseDTO();
		Optional<InventoryCategory> dataList = invCatRepo.findById(id);
		InventoryCategory InventoryCategory = dataList.get();
		try {
			if (InventoryCategory == null) {
				logger.info("The InventoryCategorydata doesn't exists!!!");
				dataRespDTO.setResponseMessage("The InventoryCategorydata doesn't exists!!!");
			} else {
				invCatRepo.delete(InventoryCategory);
				dataRespDTO.setResponseMessage(" InventoryCategorydata delete successfully");
			}
			logger.info("Exiting InventoryCategorydata");
		} catch (Exception e) {
			logger.error("delete :deleteInventoryCategorydataById of InventoryCategorydataServiceImpl " + e);
			throw e;
		}
		return dataRespDTO;
	}
	/**
	 * Crtieria builder for fetching Category details
	 * 
	 * @param InventoryCategoryRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<InventoryCategory> findByCriteria(InventoryCategoryRequestDTO codeRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for Market Code ");
		
		GenericSpesification<InventoryCategory> genericSpesification = new GenericSpesification<InventoryCategory>();
		try {
			if (codeRequestDTO.getUnitMeasure() != null && !codeRequestDTO.getUnitMeasure().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("unitMeasure", codeRequestDTO.getUnitMeasure(), SearchOperation.EQUAL));
			}
			if (codeRequestDTO.getCategory() != null && !codeRequestDTO.getCategory().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("category", codeRequestDTO.getCategory(), SearchOperation.EQUAL));
			}
			if (codeRequestDTO.getDesc1()!= null && !codeRequestDTO.getDesc1().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("desc1", codeRequestDTO.getDesc1(), SearchOperation.EQUAL));
			}
			if (codeRequestDTO.getLocationCode() != null && !codeRequestDTO.getLocationCode().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("locationCode", codeRequestDTO.getLocationCode(), SearchOperation.EQUAL));
			}
			if (codeRequestDTO.getSmallImage() != null && !codeRequestDTO.getSmallImage().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("smallImage", codeRequestDTO.getSmallImage(), SearchOperation.EQUAL));
			}
			if (codeRequestDTO.getLargeImage() != null && !codeRequestDTO.getLargeImage().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("largeImage", codeRequestDTO.getLargeImage(), SearchOperation.EQUAL));
			}
			if (codeRequestDTO.getHtsus() != null && !codeRequestDTO.getHtsus().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("htsus", codeRequestDTO.getHtsus(), SearchOperation.EQUAL));
			}
			if (codeRequestDTO.getPacking() != null && !codeRequestDTO.getPacking().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("packing", codeRequestDTO.getPacking(), SearchOperation.EQUAL));
			}
			return invCatRepo.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("InvCategoryServiceImpl " + 
					" findByCriteria failed" + e);
			throw e;
		}

	}
}
