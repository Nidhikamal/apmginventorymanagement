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
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodeClarityRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodeClarityResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.repository.CodeClarityRepository;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.inventorymanagement.v1.service.ClarityMaintainanceService;

/**
 * 
 * Service class implementation for ClarityMaintainanceService
 * 
 * @author Srijini
 *
 */
@Service(value = "ClarityMaintainanceService")
public class ClarityMaintainanceServiceImpl implements ClarityMaintainanceService {

	private static final Logger logger = LogManager.getLogger(ClarityMaintainanceService.class);

	@Autowired
	private CodeClarityRepository codeClarityRepository;

	/**
	 * @author naveen This is the main method which is used findAllCodeClarity
	 */

	@Override
	public List<CodeClarityResponseDTO> findAllCodeClarity() {

		List<CodeClarityResponseDTO> codeClarityResponseDTO = new ArrayList<CodeClarityResponseDTO>();
		try {
			List<CodeClarity> lockTypeList = codeClarityRepository.findAll();
			for (CodeClarity lockType : lockTypeList) {
				CodeClarityResponseDTO lockResponseDTO = new CodeClarityResponseDTO();
				BeanUtils.copyProperties(lockType, lockResponseDTO);
				codeClarityResponseDTO.add(lockResponseDTO);

			}
		} catch (Exception e) {
			logger.error("inventory control service findAllCodeClarity failed" + e);

			throw e;
		}
		return codeClarityResponseDTO;

	}

	/**
	 * @author naveen This is the main method which is used to update Type Data by
	 *         clarityId
	 */
	@Override
	public CodeClarityResponseDTO findCodeClarityById(String clarityId) {
		CodeClarityResponseDTO codeClarityResponseDTO = new CodeClarityResponseDTO();
		try {
			Optional<CodeClarity> lockTopye = codeClarityRepository.findById(clarityId);
			if(lockTopye.isPresent()) {
				BeanUtils.copyProperties(lockTopye.get(), codeClarityResponseDTO);
				codeClarityResponseDTO.setResponseMessage("Code Clarity found");
			}
			else {
				codeClarityResponseDTO.setResponseMessage("Code Clarity not found");
			}
		} catch (Exception e) {
			System.out.println("inventory control service findByclarityId failed" + e);
			throw e;
		}
		return codeClarityResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to save codes clarity
	 */
	@Override
	public CodeClarityResponseDTO savecodeClarity(CodeClarityRequestDTO codeClarityRequestDTO) {
		CodeClarityResponseDTO codeClarityResponseDTO = new CodeClarityResponseDTO();
		try {
			CodeClarity codesCountry = codeClarityRequestDTO.toModel(codeClarityRequestDTO);
			CodeClarity codesCountryObject = codeClarityRepository.save(codesCountry);
			logger.info(" codeClarity( Data saved successfully");

			BeanUtils.copyProperties(codesCountryObject, codeClarityResponseDTO);
		} catch (Exception e) {
			logger.error("Save: codeclarity " + e);
			throw e;
		}
		return codeClarityResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to update codeclarity
	 * 
	 * @return
	 */
	@Override
	public CodeClarityResponseDTO updateclaritymaintainance(String clarityId,
			CodeClarityRequestDTO codeClarityRequestDTO) throws Exception {
		Optional<CodeClarity> clarityrepo = codeClarityRepository.findById(clarityId);
		CodeClarityResponseDTO codeClarityResponseDTO = new CodeClarityResponseDTO();

		try {
			if (clarityrepo == null) {
				logger.info("The clarityId doesn't exists!!!");
			} else {

				CodeClarity codeClarityDtos = codeClarityRequestDTO.toModel(codeClarityRequestDTO);

				codeClarityDtos.setClarityId(clarityId);
				;
				CodeClarity codeClarityEntity = codeClarityRepository.save(codeClarityDtos);
				logger.info("clarityDetails is updated");

				BeanUtils.copyProperties(codeClarityEntity, codeClarityResponseDTO);
			}
		} catch (Exception e) {
			logger.error("update: clarityDetails " + e);

			throw e;
		}
		return codeClarityResponseDTO;
	}

	@Override
	public CodeClarityResponseDTO delete(String id) throws Exception {
		codeClarityRepository.deleteById(id);
		return null;
	}

	@Override
	public List<CodeClarityResponseDTO> search(CodeClarityRequestDTO shapeRequestDTO) throws Exception {
		logger.info("Entering For fetching all CodeClarity");
		List<CodeClarityResponseDTO> CodeClarityResponseDTOList = new ArrayList<CodeClarityResponseDTO>();
		try {
			List<CodeClarity> sizeList = findByCriteria(shapeRequestDTO);
			if (sizeList != null && !sizeList.isEmpty()) {
				sizeList.stream().forEach((MemoManifest) -> {
					CodeClarityResponseDTO sizeResponseDTO = new CodeClarityResponseDTO();
					BeanUtils.copyProperties(MemoManifest, sizeResponseDTO);
					CodeClarityResponseDTOList.add(sizeResponseDTO);
				});

			} 
			else {
				logger.info("CodeClarity not found");
				throw new ResourceNotFoundException(" CodeClarity not found ");
			}
			
		}
		catch(Exception e) {
			logger.error("CodeClarityServiceImpl  searchSizeMaintance failed" + e);
			throw e;
		}
		logger.info("Exiting after fetching all CodeClarity");
		return CodeClarityResponseDTOList;

	}
	private List<CodeClarity> findByCriteria(CodeClarityRequestDTO sizeRequestDTO) throws Exception {
		logger.info("Searching findByCriteria for CodeClarity ");
		
		GenericSpesification<CodeClarity> genericSpesification = new GenericSpesification<CodeClarity>();
		try {
			if (sizeRequestDTO.getClarityId() != null && !sizeRequestDTO.getClarityId().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("clarityId", sizeRequestDTO.getClarityId(), SearchOperation.MATCH));
			}
			if (sizeRequestDTO.getClarityName() != null && !sizeRequestDTO.getClarityName().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("clarityName", sizeRequestDTO.getClarityName(), SearchOperation.MATCH));
			}
						return codeClarityRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("MemoManifestServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}

}
