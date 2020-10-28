package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CollectionKeyword;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CollectionKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CollectionKeywordResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.CollectionKeywordRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.CollectionKeywordService;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for CollectionKeywordServiceImpl
 * 
 * @author Srijini
 *
 */
@Service(value = "CollectionKeywordServiceImpl")
public class CollectionKeywordServiceImpl implements CollectionKeywordService {

	private static final Logger logger = LogManager.getLogger(CollectionKeywordServiceImpl.class);

	@Autowired
	private CollectionKeywordRepository collectionKeywordRepo;

	/**
	 * @author amal This is the main method which is used to get Collection keyword
	 *         by id
	 */
	public CollectionKeywordResponseDTO findCollectionKeywordById(String id) throws Exception {
		CollectionKeywordResponseDTO collectionKeywrdDTO = new CollectionKeywordResponseDTO();
		try {
			Optional<CollectionKeyword> keywrdsOptional = collectionKeywordRepo.findById(id);
			if (keywrdsOptional.isPresent()) {
				CollectionKeyword countrySetup = keywrdsOptional.get();
				BeanUtils.copyProperties(countrySetup, collectionKeywrdDTO);
				collectionKeywrdDTO.setResponseMessage("Collection keyword found");
			} else {
				logger.error(" Collection Keyword doesn't exist");
				collectionKeywrdDTO.setResponseMessage("Collection keyword not found");
			}
		} catch (Exception e) {
			logger.error("Fetch: findCollectionKeywordById " + e);
			throw e;
		}

		return collectionKeywrdDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all Collection
	 *         keywords
	 */

	public List<CollectionKeyword> findAllCollectionKeywords() throws Exception {
		return collectionKeywordRepo.findAll();
	}

	/**
	 * @author amal This is the main method which is used to update Collection
	 *         keywords by id
	 */

	public CollectionKeywordResponseDTO updateCollectionKeywordsById(String id,
			CollectionKeywordRequestDTO keywordReqDTO) throws Exception {
		CollectionKeywordResponseDTO savedKeyWrdespDTO = new CollectionKeywordResponseDTO();
		try {
			Optional<CollectionKeyword> keyWrdEntityOptional = collectionKeywordRepo.findById(id);
			if (keyWrdEntityOptional.isPresent()) {
				CollectionKeyword keyWrd = keywordReqDTO.toModel(keywordReqDTO);
				keyWrd.setKeyId(id);
				CollectionKeyword keyWrdEntity = collectionKeywordRepo.save(keyWrd);
				BeanUtils.copyProperties(keyWrdEntity, savedKeyWrdespDTO);
				savedKeyWrdespDTO.setResponseMessage(" Collection keyword is updated in DB");

			} else {
				logger.info(" Collection keyword doesn't exist");
				savedKeyWrdespDTO.setResponseMessage("Update Failed");
			}
		} catch (Exception e) {
			logger.error("Update: updateCollectionKeywordsById " + e);
			throw e;
		}

		return savedKeyWrdespDTO;
	}

	/**
	 * @author amal This is the main method which is used to save Collection
	 *         keywords
	 */

	public CollectionKeywordResponseDTO saveCollectionKeywords(CollectionKeywordRequestDTO keywordReqDTO) {
		CollectionKeywordResponseDTO collectionKeywrdDTO = new CollectionKeywordResponseDTO();
		try {
			CollectionKeyword keyword = keywordReqDTO.toModel(keywordReqDTO);
			CollectionKeyword keywordEntity = collectionKeywordRepo.save(keyword);
			BeanUtils.copyProperties(keywordEntity, collectionKeywrdDTO);
			collectionKeywrdDTO.setResponseMessage(" save collectionKeywrd Successfully");
		} catch (Exception e) {
			logger.error("Save: saveCollectionKeywords" + e);
			throw e;
		}

		return collectionKeywrdDTO;
	}
	 
	@Override
	public CollectionKeywordResponseDTO delete(String id) throws Exception {
		logger.info("Entering to collectionKeywrd deletion  {}", id);
		CollectionKeywordResponseDTO dataRespDTO = new CollectionKeywordResponseDTO();
		Optional<CollectionKeyword> dataList = collectionKeywordRepo.findById(id);
		CollectionKeyword CountrySetupdata = dataList.get();
		try {
			if (CountrySetupdata == null) {
				logger.info("The collectionKeywrd doesn't exists!!!");
				dataRespDTO.setResponseMessage("The collectionKeywrd doesn't exists!!!");
			} else {
				collectionKeywordRepo.delete(CountrySetupdata);
				dataRespDTO.setResponseMessage(" collectionKeywrd delete successfully");
			}
			logger.info("Exiting collectionKeywrd");
		} catch (Exception e) {
			logger.error("delete :deletecollectionKeywrddataById of collectionKeywrdServiceImpl " + e);
			throw e;
		}
		return dataRespDTO; 
	}

	@Override
	public List<CollectionKeywordResponseDTO> search(CollectionKeywordRequestDTO shapeRequestDTO) throws Exception {
		logger.info("Entering For fetching all CollectionKeyword");
		List<CollectionKeywordResponseDTO> CollectionKeywordResponseDTO = new ArrayList<CollectionKeywordResponseDTO>();
		try {
			List<CollectionKeyword> CollectionKeywords = findByCriteria(shapeRequestDTO);
			if (CollectionKeywords != null && !CollectionKeywords.isEmpty()) {
				CollectionKeywords.stream().forEach((MemoManifest) -> {
					CollectionKeywordResponseDTO CollectionKeywordResponseDTOs = new CollectionKeywordResponseDTO();
					BeanUtils.copyProperties(MemoManifest, CollectionKeywordResponseDTOs);
					CollectionKeywordResponseDTO.add(CollectionKeywordResponseDTOs);
				});

			} 
			else {
				logger.info("CollectionKeyword not found");
				throw new ResourceNotFoundException(" CollectionKeyword not found ");
			}
			
		}
		catch(Exception e) {
			logger.error("CollectionKeywordServiceImpl search failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all manifests");
		return CollectionKeywordResponseDTO;
	 
	}
	private List<CollectionKeyword> findByCriteria(CollectionKeywordRequestDTO sizeRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for CollectionKeyword ");
		
		GenericSpesification<CollectionKeyword> genericSpesification = new GenericSpesification<CollectionKeyword>();
		try {
			if (sizeRequestDTO.getKeyId() != null && !sizeRequestDTO.getKeyId().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("keyId", sizeRequestDTO.getKeyId(), SearchOperation.MATCH));
			}
			if (sizeRequestDTO.getKeyName() != null && !sizeRequestDTO.getKeyName().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("keyName", sizeRequestDTO.getKeyName(), SearchOperation.MATCH));
			}
			 
			return collectionKeywordRepo.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("MemoManifestServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}
	 
}
