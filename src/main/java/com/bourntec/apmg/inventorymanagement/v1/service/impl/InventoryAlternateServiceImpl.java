package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.InventoryAlternate;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryAlternateRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryAlternateResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryAlternateRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryAlternateService;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
@Service
public class InventoryAlternateServiceImpl implements InventoryAlternateService {
	private static final Logger logger = LogManager.getLogger(InventoryAlternateServiceImpl.class);

	@Autowired
	InventoryAlternateRepository inventoryAlternateRepository;

	/**
	 * Method saves a Memo Manifest
	 */
	
	@Override
	public InventoryAlternateResponseDTO saveInventoryAlternate(InventoryAlternateRequestDTO inventoryAlternatRequestDTO) {
		logger.info("Entering saveMemoManifest", inventoryAlternatRequestDTO);

		InventoryAlternateResponseDTO inventoryAlternatResponsetDTO = new InventoryAlternateResponseDTO();

		try {
			InventoryAlternate inventoryAlternat = inventoryAlternatRequestDTO.toModel(inventoryAlternatRequestDTO);
			InventoryAlternate Manifest = inventoryAlternateRepository.save(inventoryAlternat);
			if (Manifest != null) {
				logger.info("Inventory Alternate Details is saved");
				BeanUtils.copyProperties(Manifest, inventoryAlternatResponsetDTO);
				inventoryAlternatResponsetDTO.setResponseMessage("Inventory Alternate is saved Successfully");
			} else {
				logger.info("Inventory Alternate is not saved in DB");
				inventoryAlternatResponsetDTO.setResponseMessage("Inventory Alternate is not saved");
			}
		}

		catch (Exception e) {
			logger.error("InventoryAlternateServiceImpl saveInventoryAlternate failed" + e);

			throw e;
		}
		return inventoryAlternatResponsetDTO;
	}
	/**
	 * Method that updates a Inventory Alternate
	 */
	@Override
	public InventoryAlternateResponseDTO updateInventoryAlternate(Long id, InventoryAlternateRequestDTO manifestRequestDTO) {
		logger.info("Entering updateInventoryAlternate", manifestRequestDTO);
		InventoryAlternateResponseDTO inventoryAlternatResponsedto = new InventoryAlternateResponseDTO();

		try {
			Optional<InventoryAlternate> inventoryAlternatList = inventoryAlternateRepository.findById(id);
			if(inventoryAlternatList.isPresent()) {
				
				InventoryAlternate inventoryAlternatObj = manifestRequestDTO.toModel(manifestRequestDTO);

				inventoryAlternatObj.setId(id);

				InventoryAlternate savedinventoryAlternate = inventoryAlternateRepository.save(inventoryAlternatObj);
				logger.info("Inventory Alternate Details is updated");

				BeanUtils.copyProperties(savedinventoryAlternate, inventoryAlternatResponsedto);
				inventoryAlternatResponsedto.setResponseMessage("Memo Manifest is updated Successfully");
			}
			else {
				logger.info("The Inventory Alternate doesn't exists!!!");
				throw new ResourceNotFoundException("Requested Inventory Alternate with"+id+"Not Exists");
			}
			
			logger.info("Exiting updateInventoryAlternate");
		} 
		catch (Exception e) {
			logger.error(" InventoryAlternateServiceImpl updateInventoryAlternate  failed" + e);

			throw e;
		}
		return inventoryAlternatResponsedto;
	}
	
	/**
	 * Retrieval of Inventory Alternate object based on requested id
	 */
	@Override
	public InventoryAlternateResponseDTO getById(Long id) {
		logger.info("Entering getById in InventoryAlternateServiceImpl  {}", id);

		InventoryAlternateResponseDTO inventoryAlternatResponsedto = new InventoryAlternateResponseDTO();
		try {

			Optional<InventoryAlternate> inventoryAlternatObj = inventoryAlternateRepository.findById(id);
			if(inventoryAlternatObj.isPresent()) {
				InventoryAlternate inventoryAlternat = inventoryAlternatObj.get();
				BeanUtils.copyProperties(inventoryAlternat, inventoryAlternatResponsedto);
			}
			else {
				throw new ResourceNotFoundException("Requested Inventory Alternate with "+id+" is not exist");
			}

			logger.info("Exiting getById  in Inventory AlternateServiceImpl {}", id);
		} catch (Exception e) {
			logger.error("Inventory AlternateServiceImpl getById failed" + e);
			throw e;
		}
		return inventoryAlternatResponsedto;
	}
	
	/**
	 * Fetch all the Inventory Alternate in the DB
	 */
	@Override
	public List<InventoryAlternateResponseDTO> getAll() {
		logger.info("Entering getAll in MemoManifestServiceImpl  ..");
		
		List<InventoryAlternateResponseDTO> inventoryAlternatResponseList = new ArrayList<InventoryAlternateResponseDTO>();;
		try {
				List<InventoryAlternate> inventoryAlternatList = inventoryAlternateRepository.findAll();
				if(inventoryAlternatList != null && !inventoryAlternatList.isEmpty()) {
						inventoryAlternatList.forEach(inventoryAlternat -> {
							InventoryAlternateResponseDTO inventoryAlternatResponsedto = new InventoryAlternateResponseDTO();
						BeanUtils.copyProperties(inventoryAlternat, inventoryAlternatResponsedto);
						inventoryAlternatResponseList.add(inventoryAlternatResponsedto);
					});
				}else {
					throw new ResourceNotFoundException("Requested Inventory Alternate is not exist");
				}
				
		} catch (Exception e) {
			logger.error("InventoryAlternateServiceImpl getAll failed" + e);
			throw e;
		}
		
		logger.info("Exiting getAll in InventoryAlternateServiceImpl  ..");
		return inventoryAlternatResponseList;
	}
	
	/**
	 * Fetches Inventory Alternate objects in DB based on criteria
	 */
	@Override
	public List<InventoryAlternateResponseDTO> fetchByInventoryAlternate(InventoryAlternateRequestDTO inventoryAlternatRequestDTO) throws Exception {
		logger.info("Entering For fetching all Inventory Alternate");
		List<InventoryAlternateResponseDTO> memoManifestResponseDTOList = new ArrayList<InventoryAlternateResponseDTO>();
		try {
			List<InventoryAlternate> inventoryAlternatList = findByCriteria(inventoryAlternatRequestDTO);
			if (inventoryAlternatList != null && !inventoryAlternatList.isEmpty()) {
				inventoryAlternatList.stream().forEach((inventoryAlternat) -> {
					InventoryAlternateResponseDTO inventoryAlternatResponseDTO = new InventoryAlternateResponseDTO();
					BeanUtils.copyProperties(inventoryAlternat, inventoryAlternatResponseDTO);
					memoManifestResponseDTOList.add(inventoryAlternatResponseDTO);
				});

			} else {
				InventoryAlternateResponseDTO inventoryAlternatResponseDTO = new InventoryAlternateResponseDTO();
				inventoryAlternatResponseDTO.setResponseMessage("Inventory Alternate not found");
				memoManifestResponseDTOList.add(inventoryAlternatResponseDTO);
				logger.info("Inventory Alternate not found");
				//throw new ResourceNotFoundException(" Inventory Alternate not found ");
			}
		}catch(Exception e) {
			logger.error("InventoryAlternateServiceImpl  fetchByInventoryAlternate failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all InventoryAlternates");
		return memoManifestResponseDTOList;
	}
		
	/**
	 * Crtieria builder for fetching Inventory Alternate
	 * 
	 * @param InventoryAlternateRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<InventoryAlternate> findByCriteria(InventoryAlternateRequestDTO inventoryAlternateRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for Inventory Alternate ");
		
		GenericSpesification<InventoryAlternate> genericSpesification = new GenericSpesification<InventoryAlternate>();
		try {
			if (inventoryAlternateRequestDTO.getItemCode() != null && !inventoryAlternateRequestDTO.getItemCode().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("itemCode", inventoryAlternateRequestDTO.getItemCode(), SearchOperation.EQUAL));
			}
			if (inventoryAlternateRequestDTO.getItemCodeAlt() != null && !inventoryAlternateRequestDTO.getItemCodeAlt().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("itemCodeAlt", inventoryAlternateRequestDTO.getItemCodeAlt(), SearchOperation.EQUAL));
			}
			if (inventoryAlternateRequestDTO.getDesc1() != null && !inventoryAlternateRequestDTO.getDesc1().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("desc1", inventoryAlternateRequestDTO.getDesc1(), SearchOperation.EQUAL));
			}
			return inventoryAlternateRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("InventoryAlternateServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}
	/**
	 * Deletes a Inventory Alternate from the DB
	 */
	@Override
	public InventoryAlternateResponseDTO deleteInventoryAlternate(Long id) {
		logger.info("Entering deleteInventoryAlternate  {}", id);
		InventoryAlternateResponseDTO inventoryAlternateResponseDTO = new InventoryAlternateResponseDTO();
		try {
			Optional<InventoryAlternate> inventoryAlternateList = inventoryAlternateRepository.findById(id);
			if(inventoryAlternateList.isPresent()) {
				InventoryAlternate inventoryAlternateObj = inventoryAlternateList.get();
				inventoryAlternateRepository.delete(inventoryAlternateObj);
				inventoryAlternateResponseDTO.setResponseMessage("Inventory Alternate deleted");
			}
			else {
				throw new ResourceNotFoundException("No Inventory Alternate Exists");
			}
			
			logger.info("Exiting deleteInventoryAlternate");
		} 
		catch (Exception e) {
			logger.error("InventoryAlternateServiceImpl deleteInventoryAlternate failed" + e);
			throw e;
		}
		return inventoryAlternateResponseDTO;
	}

}
