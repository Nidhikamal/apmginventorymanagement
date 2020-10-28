package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CodeClasp;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodeClaspRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodeClaspResponsetDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.CodeClaspRepository;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.inventorymanagement.v1.service.CodeClaspService;

/**
 * 
 * Service class implementation for CodeClaspServiceImpl
 * 
 * @author Srijini
 *
 */
@Service(value = "CodeClaspServiceImpl")
public class CodeClaspServiceImpl implements CodeClaspService {

	private static final Logger logger = LogManager.getLogger(CodeClaspServiceImpl.class);

	@Autowired
	private CodeClaspRepository codeClaspRepository;

	/**
	 * @author naveen This is the main method which is used findAllodeClasp
	 */
	@Override

	public List<CodeClaspResponsetDTO> findAllodeClasp() {

		List<CodeClaspResponsetDTO> codeClaspResponsetDTO = new ArrayList<CodeClaspResponsetDTO>();
		try {
			List<CodeClasp> lockTypeList = codeClaspRepository.findAll();
			for (CodeClasp lockType : lockTypeList) {
				CodeClaspResponsetDTO lockResponseDTO = new CodeClaspResponsetDTO();
				BeanUtils.copyProperties(lockType, lockResponseDTO);
				codeClaspResponsetDTO.add(lockResponseDTO);

			}
		} catch (Exception e) {
			logger.error("inventory control service findAllodeClasp failed" + e);

			throw e;
		}
		return codeClaspResponsetDTO;

	}

	/**
	 * @author naveen This is the main method which is used to update Type Data by
	 *         claspId
	 */
	@Override
	public CodeClaspResponsetDTO findByclaspId(String claspId) {
		CodeClaspResponsetDTO codeClarityResponseDTO = new CodeClaspResponsetDTO();
		try {
			Optional<CodeClasp> lockTopye = codeClaspRepository.findById(claspId);
			if(lockTopye.isPresent()) {
			BeanUtils.copyProperties(lockTopye.get(), codeClarityResponseDTO);
			codeClarityResponseDTO.setResponseMessage("Code clasp data found");

			}
			else {
				codeClarityResponseDTO.setResponseMessage("Code clasp data not found");
			}
		} catch (Exception e) {
			logger.error("inventory control service findByclarityId failed" + e);
			throw e;
		}
		return codeClarityResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to save codeclasp
	 */
	@Override
	public CodeClaspResponsetDTO savecodeClasp(CodeClaspRequestDTO codeClaspRequestDTO) {
		CodeClaspResponsetDTO codeClaspResponsetDTO = new CodeClaspResponsetDTO();
		try {
			CodeClasp codesCountry = codeClaspRequestDTO.toModel(codeClaspRequestDTO);
			CodeClasp codesCountryObject = codeClaspRepository.save(codesCountry);
			logger.info(" codeclasp( Data saved successfully");

			BeanUtils.copyProperties(codesCountryObject, codeClaspResponsetDTO);
		} catch (Exception e) {
			logger.error("Save: codeclasp " + e);
			throw e;
		}
		return codeClaspResponsetDTO;
	}

	/**
	 * @author naveen This is the main method which is used to update codeclasp
	 * 
	 * @return
	 */
	@Override
	public CodeClaspResponsetDTO updatecodeclasp(String claspId, CodeClaspRequestDTO codeClaspRequestDTO) {
		Optional<CodeClasp> clsprepo = codeClaspRepository.findById(claspId);
		CodeClaspResponsetDTO codeClaspResponsetDTO = new CodeClaspResponsetDTO();

		try {
			if (clsprepo == null) {
				logger.info("The claspId doesn't exists!!!");
			} else {

				CodeClasp codeClaspDtomodel = codeClaspRequestDTO.toModel(codeClaspRequestDTO);

				codeClaspDtomodel.setClaspId(claspId);

				CodeClasp codeClaspEntity = codeClaspRepository.save(codeClaspDtomodel);
				logger.info("codeclaspDetails is updated");

				BeanUtils.copyProperties(codeClaspEntity, codeClaspResponsetDTO);
			}
		} catch (Exception e) {
			logger.error("update: codeclaspDetails " + e);

			throw e;
		}
		return codeClaspResponsetDTO;
	}

	@Override
	public CodeClaspResponsetDTO delete(String id) throws Exception {
		codeClaspRepository.deleteById(id);
		return null;
	}

	@Override
	public List<CodeClasp> search(CodeClaspRequestDTO shapeRequestDTO) throws Exception {
		GenericSpesification<CodeClasp> genericSpesification = new GenericSpesification<CodeClasp>();

		if (shapeRequestDTO.getClaspId() != null) {
			genericSpesification
					.add(new SearchCriteria("claspId", shapeRequestDTO.getClaspId(), SearchOperation.MATCH));
		}
		if (shapeRequestDTO.getClaspName() != null) {
			genericSpesification
					.add(new SearchCriteria("claspName", shapeRequestDTO.getClaspName(), SearchOperation.MATCH));
		}
		return codeClaspRepository.findAll(genericSpesification);
	}
}
