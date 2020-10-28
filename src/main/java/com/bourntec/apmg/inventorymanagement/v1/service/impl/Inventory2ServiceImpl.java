package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.Inventory2;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.Inventory2RequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.Inventory2ResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.Inventory2Repository;
import com.bourntec.apmg.inventorymanagement.v1.service.Inventory2Service;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for inventory2
 * 
 * @author Nince
 *
 */
@Service(value = "Inventory2ServiceImpl")
public class Inventory2ServiceImpl implements Inventory2Service {

	private static final Logger logger = LogManager.getLogger(Inventory2ServiceImpl.class);

	@Autowired
	Inventory2Repository inventory2Repository;

	/**
	 * Method saves a Inventory2
	 */
	
	@Override
	public Inventory2ResponseDTO saveInventory2(Inventory2RequestDTO inventory2RequestDTO) {
		logger.info("Entering saveInventory2", inventory2RequestDTO);

		Inventory2ResponseDTO inventory2ResponsetDTO = new Inventory2ResponseDTO();

		try {
			Inventory2 inventory2 = inventory2RequestDTO.toModel(inventory2RequestDTO);
			Inventory2 invObj = inventory2Repository.save(inventory2);
			if (invObj != null) {
				logger.info("Inventory2 Details is saved");
				BeanUtils.copyProperties(invObj, inventory2ResponsetDTO);
				inventory2ResponsetDTO.setResponseMessage("Inventory2 is saved Successfully");
			} else {
				logger.info("Inventory2 is not saved in DB");
				inventory2ResponsetDTO.setResponseMessage("Inventory2 is not saved");
			}
		}

		catch (Exception e) {
			logger.error("Inventory2ServiceImpl saveInventory2 failed" + e);

			throw e;
		}
		return inventory2ResponsetDTO;
	}
	/**
	 * Method that updates a Inventory2
	 */
	@Override
	public Inventory2ResponseDTO updateInventory2(String itemCode, Inventory2RequestDTO inventory2RequestDTO) {
		logger.info("Entering updateInventory2", inventory2RequestDTO);
		Inventory2ResponseDTO inventory2Responsedto = new Inventory2ResponseDTO();

		try {
			Optional<Inventory2> inventory2List = inventory2Repository.findById(itemCode);
			if(inventory2List.isPresent()) {
				
				Inventory2 inventory2Obj = inventory2RequestDTO.toModel(inventory2RequestDTO);

				inventory2Obj.setItemCode(itemCode);

				Inventory2 savedInventory2 = inventory2Repository.save(inventory2Obj);
				logger.info("Inventory2 Details is updated");

				BeanUtils.copyProperties(savedInventory2, inventory2Responsedto);
				inventory2Responsedto.setResponseMessage("Inventory2 is updated Successfully");
			}
			else {
				logger.info("The Inventory2 doesn't exists!!!");
				throw new ResourceNotFoundException("Requested Inventory2 with"+itemCode+"Not Exists");
			}
			
			logger.info("Exiting updateInventory2");
		} 
		catch (Exception e) {
			logger.error(" Inventory2ServiceImpl updateInventory2  failed" + e);

			throw e;
		}
		return inventory2Responsedto;
	}
	
	/**
	 * Retrieval of Inventory2 object based on requested id
	 */
	@Override
	public Inventory2ResponseDTO getById(String itemCode) {
		logger.info("Entering getById in Inventory2ServiceImpl  {}", itemCode);

		Inventory2ResponseDTO inventory2Responsedto = new Inventory2ResponseDTO();
		try {

			Optional<Inventory2> inventory2Obj = inventory2Repository.findById(itemCode);
			if(inventory2Obj.isPresent()) {
				Inventory2 inventory2 = inventory2Obj.get();
				BeanUtils.copyProperties(inventory2, inventory2Responsedto);
			}
			else {
				throw new ResourceNotFoundException("Requested Inventory2 with "+itemCode+" is not exist");
			}

			logger.info("Exiting getById  in Inventory2ServiceImpl {}", itemCode);
		} 
		catch (Exception e) {
			logger.error("Inventory2ServiceImpl getById failed" + e);
			throw e;
		}
		return inventory2Responsedto;
	}
	
	/**
	 * Fetch all the Inventory2 in the DB
	 */
	@Override
	public List<Inventory2ResponseDTO> getAll() {
		logger.info("Entering getAll in Inventory2ServiceImpl  ..");
		
		List<Inventory2ResponseDTO> inventory2ResponseList = new ArrayList<Inventory2ResponseDTO>();;
		try {
				List<Inventory2> inventory2List = inventory2Repository.findAll();
				if(inventory2List != null && !inventory2List.isEmpty()) {
						inventory2List.forEach(inventory2 -> {
						Inventory2ResponseDTO inventory2Responsedto = new Inventory2ResponseDTO();
						BeanUtils.copyProperties(inventory2, inventory2Responsedto);
						inventory2ResponseList.add(inventory2Responsedto);
					});
				}
				else {
					throw new ResourceNotFoundException("Requested Inventory2 is not exist");
				}
				
		} 
		catch (Exception e) {
			logger.error("Inventory2ServiceImpl getAll failed" + e);
			throw e;
		}
		
		logger.info("Exiting getAll in Inventory2ServiceImpl  ..");
		return inventory2ResponseList;
	}
	
	/**
	 * Fetches Inventory2 objects in DB based on criteria
	 */
	@Override
	public List<Inventory2ResponseDTO> fetchByInventory2(Inventory2RequestDTO inventory2RequestDTO) throws Exception {
		logger.info("Entering For fetching all Inventory2");
		List<Inventory2ResponseDTO> inventory2ResponseDTOList = new ArrayList<Inventory2ResponseDTO>();
		try {
			List<Inventory2> inventory2List = findByCriteria(inventory2RequestDTO);
			if (inventory2List != null && !inventory2List.isEmpty()) {
				inventory2List.stream().forEach((inventory2) -> {
					Inventory2ResponseDTO inventory2ResponseDTO = new Inventory2ResponseDTO();
					BeanUtils.copyProperties(inventory2, inventory2ResponseDTO);
					inventory2ResponseDTOList.add(inventory2ResponseDTO);
				});

			} 
			else {
				logger.info("Inventory2 not found");
				throw new ResourceNotFoundException("Inventory2 not found ");
			}
			
		}
		catch(Exception e) {
			logger.error("Inventory2ServiceImpl  fetchByInventory2 failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all Inventory2s");
		return inventory2ResponseDTOList;
	}
		
	/**
	 * Crtieria builder for fetching Inventory2
	 * 
	 * @param inventory2RequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<Inventory2> findByCriteria(Inventory2RequestDTO inventory2RequestDTO) throws Exception {
		logger.info("Searching findByCriteria for Inventory2 ");
		
		GenericSpesification<Inventory2> genericSpesification = new GenericSpesification<Inventory2>();
		try {
			if (inventory2RequestDTO.getItemCode() != null && !inventory2RequestDTO.getItemCode().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("itemCode", inventory2RequestDTO.getItemCode(), SearchOperation.EQUAL));
			}
			if (inventory2RequestDTO.getStyleName() != null && !inventory2RequestDTO.getStyleName().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("styleName", inventory2RequestDTO.getStyleName(), SearchOperation.EQUAL));
			}
			if (inventory2RequestDTO.getStoneOrgin() != null && !inventory2RequestDTO.getStoneOrgin().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("stoneOrgin", inventory2RequestDTO.getStoneOrgin(), SearchOperation.EQUAL));
			}
			if (inventory2RequestDTO.getDescription2() != null && !inventory2RequestDTO.getDescription2().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("description2", inventory2RequestDTO.getDescription2(), SearchOperation.EQUAL));
			}
			if (inventory2RequestDTO.getSpecification() != null && !inventory2RequestDTO.getSpecification().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("specification", inventory2RequestDTO.getSpecification(), SearchOperation.EQUAL));
			}
			if (inventory2RequestDTO.getSpecification2() != null && !inventory2RequestDTO.getSpecification2().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("specification2", inventory2RequestDTO.getSpecification2(), SearchOperation.EQUAL));
			}
			return inventory2Repository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("Inventory2ServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}
	/**
	 * Deletes a Inventory2 from the DB
	 */
	@Override
	public Inventory2ResponseDTO deleteInventory2(String itemCode) {
		logger.info("Entering deleteInventory2  {}", itemCode);
		Inventory2ResponseDTO inventory2ResponseDTO = new Inventory2ResponseDTO();
		try {
			Optional<Inventory2> inventory2List = inventory2Repository.findById(itemCode);
			if(inventory2List.isPresent()) {
				Inventory2 inventory2 = inventory2List.get();
				inventory2Repository.delete(inventory2);
				inventory2ResponseDTO.setResponseMessage("Inventory2 deleted");
			}
			else {
				throw new ResourceNotFoundException("No Inventory2 Exists");
			}
			
			logger.info("Exiting deleteInventory2");
		} 
		catch (Exception e) {
			logger.error("Inventory2ServiceImpl deleteInventory2 failed" + e);
			throw e;
		}
		return inventory2ResponseDTO;
	}

}
