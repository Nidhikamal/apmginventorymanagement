package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CollectionSubKeyword;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CollectionSubKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CollectionSubKeywordResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.repository.CollectionSubKeywordRepository;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.inventorymanagement.v1.service.CollectionSubKeywordService;

/**
 * 
 * Service class implementation for CollectionSubKeywordServiceImpl
 * 
 * @author Srijini
 *
 */
@Service(value = "CollectionSubKeywordServiceImpl")
public class CollectionSubKeywordServiceImpl implements CollectionSubKeywordService {

	private static final Logger logger = LogManager.getLogger(CollectionSubKeywordServiceImpl.class);

	@Autowired
	CollectionSubKeywordRepository collectionSubKeywordRepo;

	/**
	 * @author amal This is the main method which is used to save Collection sub
	 *         keywords
	 */

	public CollectionSubKeywordResponseDTO saveCollectionSubKeywords(
			CollectionSubKeywordRequestDTO subKeywordReqDTOList) throws Exception {
		CollectionSubKeywordResponseDTO collectionKeywrdDTO = new CollectionSubKeywordResponseDTO();
		
		try {
			//if (subKeywordReqDTOList != null && subKeywordReqDTOList.size() > 0) {
				//subKeywordReqDTOList.forEach((subkeywordobj) -> {
					CollectionSubKeyword collectionSubKeyword = subKeywordReqDTOList.toModel(subKeywordReqDTOList);
					CollectionSubKeyword subkeyWord = collectionSubKeywordRepo.save(collectionSubKeyword);
					BeanUtils.copyProperties(subkeyWord, collectionKeywrdDTO);
					//collectionKeywrdDTOList.add(collectionKeywrdDTO);
					collectionKeywrdDTO.setResponseMessage("CollectionSubKeyword is saved in DB");
			//	});
			//}
			logger.info(" Collection keyword saved successfully");

		} catch (Exception e) {
			logger.error("Save: saveCollectionKeywords" + e);
			throw e;
		}

		return collectionKeywrdDTO;
	}

	@Override
	public List<CollectionSubKeywordResponseDTO> getAll() {
		List<CollectionSubKeywordResponseDTO> responseDTOs = new ArrayList<CollectionSubKeywordResponseDTO>();
		try {
			List<CollectionSubKeyword> subKeywordList = collectionSubKeywordRepo.findAll();
			responseDTOs = getResponseList(subKeywordList);
		} catch (Exception e) {
			logger.error("Error at subkeyword fetxhing :" + e);
		}
		return responseDTOs;
	}

	private List<CollectionSubKeywordResponseDTO> getResponseList(List<CollectionSubKeyword> subKeywordList) {
		List<CollectionSubKeywordResponseDTO> responseDTOs = new ArrayList<CollectionSubKeywordResponseDTO>();
		try {
			if (subKeywordList != null && !subKeywordList.isEmpty()) {
				subKeywordList.forEach(subKey -> {
					CollectionSubKeywordResponseDTO subKeywordResponseDTO = new CollectionSubKeywordResponseDTO();
					BeanUtils.copyProperties(subKey, subKeywordResponseDTO);
					responseDTOs.add(subKeywordResponseDTO);
				});
			}
		} catch (Exception e) {
			logger.error("Error at subkeyword fetching :" + e);
		}
		return responseDTOs;
	}

	@Override
	public CollectionSubKeywordResponseDTO getById(String subKeyId) {
		CollectionSubKeywordResponseDTO subKeywordResponseDTO = new CollectionSubKeywordResponseDTO();
		try {
			Optional<CollectionSubKeyword> subKeywordList = collectionSubKeywordRepo.findBySubKeyId(subKeyId);
			if (subKeywordList != null && subKeywordList.isPresent()) {
				BeanUtils.copyProperties(subKeywordList.get(), subKeywordResponseDTO);
			}
		} catch (Exception e) {
			logger.error("Error at subkeyword fetxhing :" + e);
		}
		return subKeywordResponseDTO;
	}

	@Override
	public List<CollectionSubKeywordResponseDTO> search(CollectionSubKeywordRequestDTO subKeywordRequestDTOs, int page,
			int size) {
		List<CollectionSubKeywordResponseDTO> responseDTOs = new ArrayList<CollectionSubKeywordResponseDTO>();
		try {
			Page<CollectionSubKeyword> subKeywordList = findSubKeywordByCriteria(subKeywordRequestDTOs, page, size);
			if (subKeywordList != null && !subKeywordList.isEmpty()) {
				responseDTOs = getResponseList(subKeywordList.toList());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseDTOs;
	}

	/**
	 * This is the main method which is used to search PassAccessList dynamically
	 * 
	 * @param PassModuleOptionListRequestDTO
	 * @return Page<PassModuleOptionList>
	 */

	public Page<CollectionSubKeyword> findSubKeywordByCriteria(CollectionSubKeywordRequestDTO subKeywordRequestDTO,
			int page, int size) throws Exception {
		logger.info("Searching PassTable ..");
		GenericSpesification<CollectionSubKeyword> genericSpesification = new GenericSpesification<CollectionSubKeyword>();
		try {
			if (subKeywordRequestDTO.getKeyId() != null) {
				genericSpesification
						.add(new SearchCriteria("keyId", subKeywordRequestDTO.getKeyId(), SearchOperation.EQUAL));
			} else if (subKeywordRequestDTO.getSubKeyName() != null) {
				genericSpesification.add(
						new SearchCriteria("subKeyName", subKeywordRequestDTO.getSubKeyName(), SearchOperation.EQUAL));
			}

			return collectionSubKeywordRepo.findAll(genericSpesification, PageRequest.of(page, size));

		} catch (Exception e) {
			throw new ResourceNotFoundException(ErrorCodes.SEARCH_FAILED.getMessage());
		}

	}

	
	@Override
	public CollectionSubKeywordResponseDTO updateSubKey(String subKeyId, CollectionSubKeywordRequestDTO collectionSubKeywordRequestDTO) {
		Optional<CollectionSubKeyword> clsprepo = collectionSubKeywordRepo.findById(subKeyId);
		CollectionSubKeywordResponseDTO collectionSubKeywordResponseDTO = new CollectionSubKeywordResponseDTO();

		try {
			if (clsprepo == null) {
				logger.info("The SubKey doesn't exists!!!");
			} else {

				CollectionSubKeyword collectionmodel = collectionSubKeywordRequestDTO.toModel(collectionSubKeywordRequestDTO);

				collectionmodel.setSubKeyId(subKeyId);

				CollectionSubKeyword collectionSubKeyword = collectionSubKeywordRepo.save(collectionmodel);
				logger.info("collection SubKeyword is updated");

				BeanUtils.copyProperties(collectionSubKeyword, collectionSubKeywordResponseDTO);
			}
		} catch (Exception e) {
			logger.error("update: collectionSubKeyword " + e);

			throw e;
		}
		return collectionSubKeywordResponseDTO;
	}
}
