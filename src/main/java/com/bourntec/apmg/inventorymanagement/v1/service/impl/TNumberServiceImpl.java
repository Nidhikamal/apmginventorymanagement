package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.TNumber;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.TNumberRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TNumberResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.TNumberRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.TNumberService;
import com.bourntec.apmg.inventorymanagement.v1.utils.DateUtils;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for TNumberService
 * 
 * @author Srijini
 *
 */
@Service(value = "TNumberServiceImpl")
public class TNumberServiceImpl implements TNumberService {

	private static final Logger logger = LogManager.getLogger(TNumberServiceImpl.class);

	@Autowired
	private TNumberRepository tNumberRepository;

	/**
	 * Method for fetch all TNumber
	 */
	@Override
	public List<TNumberResponseDTO> findAllTNumbers() throws Exception {
		logger.info("Entering for fetching all tnumer  data..");
		List<TNumberResponseDTO> responseDTOList = new ArrayList<TNumberResponseDTO>();
		try {
			List<TNumber> tNumber = tNumberRepository.findAll();
			if (tNumber != null && !tNumber.isEmpty()) {
				tNumber.forEach(obj -> {
					TNumberResponseDTO responseDTO = new TNumberResponseDTO();
					responseDTO = convertByteArrayToString(obj);
					BeanUtils.copyProperties(obj, responseDTO);
					responseDTOList.add(responseDTO);
				});
			} else {
				TNumberResponseDTO responseDTO = new TNumberResponseDTO();
				responseDTO.setResponseMessage("Requested TNumber is not exist");
				responseDTOList.add(responseDTO);
			}
		} catch (Exception e) {
			logger.error("TNumberServiceImpl getAll failed: " + e);
		}
		return responseDTOList;
	}

	/**
	 * method for fet a tnumber
	 */
	@Override
	public TNumberResponseDTO getTNumberById(Long id) throws Exception {
		logger.info("Entering getTNumberById ..");
		TNumberResponseDTO responseDTO = new TNumberResponseDTO();
		try {
			Optional<TNumber> tNumberOptional = tNumberRepository.findById(id);
			if (tNumberOptional.isPresent()) {
				TNumber data = tNumberOptional.get();
				responseDTO = convertByteArrayToString(data);
				BeanUtils.copyProperties(data, responseDTO);
				responseDTO.setResponseMessage("TNumbers fetch successfully");
			} else {
				logger.error("TNumber doesn't exist");
				responseDTO.setResponseMessage("TNumbers doesn't exist");
			}
		} catch (BeansException e) {
			logger.error("TNumberServiceImpl getTNumberById failed: " + e);
		}
		return responseDTO;
	}

	/***
	 * method for save tnumber
	 */
	@Override
	public TNumberResponseDTO saveTNumbers(TNumberRequestDTO tNumberRequestDTO) throws Exception {
		logger.info("Entering save ..");
		TNumberResponseDTO responseDTO = new TNumberResponseDTO();
		try {
			TNumber tNumber = tNumberRequestDTO.toModel(tNumberRequestDTO);
			TNumber number = tNumberRepository.save(tNumber);
			if (number != null) {
				responseDTO = convertByteArrayToString(number);
				BeanUtils.copyProperties(number, responseDTO);
				logger.info("TNumbers saved successfully");
				responseDTO.setResponseMessage("TNumbers saved successfully");
			} else {
				responseDTO.setResponseMessage("Failed to save TNumbers");
				logger.error("Failed to save TNumbers ");
			}
		} catch (Exception e) {
			logger.error("TNumberServiceImpl saveTNumbers failed: " + e);
		}
		return responseDTO;
	}

	@Override
	public List<TNumberResponseDTO> findTNumberByCriteria(TNumberRequestDTO tNumberRequestDTO) throws Exception {
		logger.info("Entering for fetching all tnumer  data..");
		List<TNumberResponseDTO> responseDTOList = new ArrayList<TNumberResponseDTO>();
		try {
			List<TNumber> tNumber = findByCriteria(tNumberRequestDTO);
			if (tNumber != null && !tNumber.isEmpty()) {
				tNumber.forEach(obj -> {
					TNumberResponseDTO responseDTO = new TNumberResponseDTO();
					responseDTO = convertByteArrayToString(obj);
					BeanUtils.copyProperties(obj, responseDTO);
					responseDTOList.add(responseDTO);
				});
			} else {
				TNumberResponseDTO responseDTO = new TNumberResponseDTO();
				responseDTO.setResponseMessage("Requested TNumber is not exist");
				responseDTOList.add(responseDTO);
			}
		} catch (Exception e) {
			logger.error("TNumberServiceImpl getAll failed: " + e);
		}
		return responseDTOList;
	}

	/**
	 * Crtieria builder for fetching TNumbers
	 * 
	 * @param TNumberRequestDTO
	 * @return
	 * @throws Exception
	 */
	private List<TNumber> findByCriteria(TNumberRequestDTO requestDTO) throws Exception {
		logger.info("Searching findByCriteria for TNumber ");

		GenericSpesification<TNumber> genericSpesification = new GenericSpesification<TNumber>();
		try {
			if (requestDTO.getTno() != null) {
				genericSpesification.add(new SearchCriteria("tno", requestDTO.getTno(), SearchOperation.EQUAL));
			}
			if (requestDTO.getStatus() != null) {
				genericSpesification.add(new SearchCriteria("status", requestDTO.getStatus(), SearchOperation.EQUAL));
			}
			if (requestDTO.getStyleNo() != null) {
				genericSpesification.add(new SearchCriteria("styleNo", requestDTO.getStyleNo(), SearchOperation.MATCH));
			}
			if (requestDTO.getDesignerId() != null) {
				genericSpesification
						.add(new SearchCriteria("designerId", requestDTO.getDesignerId(), SearchOperation.EQUAL));
			}
			if (requestDTO.getCadId() != null) {// for cad designer
				genericSpesification.add(new SearchCriteria("cadId", requestDTO.getCadId(), SearchOperation.EQUAL));
			}
			if (requestDTO.getTdate() != null) {
				genericSpesification
						.add(new SearchCriteria("tdate", requestDTO.getTdate(), SearchOperation.GREATER_THAN_EQUAL));
			}
			if (requestDTO.getEndDate() != null) {
				genericSpesification
						.add(new SearchCriteria("endDate", requestDTO.getEndDate(), SearchOperation.LESS_THAN_EQUAL));
			}
			if (requestDTO.getBrandId() != null) {
				genericSpesification.add(new SearchCriteria("brandId", requestDTO.getBrandId(), SearchOperation.EQUAL));
			}
			if (requestDTO.getCustNo() != null) {
				genericSpesification.add(new SearchCriteria("custNo", requestDTO.getCustNo(), SearchOperation.EQUAL));
			}

			return tNumberRepository.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("TNumberServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}

	/***
	 * method for update tnumber
	 */
	@Override
	public TNumberResponseDTO updateTNumber(Long id, TNumberRequestDTO tNumberRequestDTO) throws Exception {
		logger.info("Entering update ..");
		TNumberResponseDTO responseDTO = new TNumberResponseDTO();
		try {
			Optional<TNumber> tNumberOptional = tNumberRepository.findById(id);
			if (tNumberOptional.isPresent()) {
				TNumber tNumber = tNumberRequestDTO.toModel(tNumberRequestDTO);
				tNumberRequestDTO.setTno(id);
				TNumber number = tNumberRepository.save(tNumber);
				if (number != null) {
					responseDTO = convertByteArrayToString(number);
					BeanUtils.copyProperties(number, responseDTO);
					logger.info("TNumbers updated successfully");
					responseDTO.setResponseMessage("TNumbers updated successfully");
				} else {
					responseDTO.setResponseMessage("Failed to update TNumbers");
					logger.error("Failed to save TNumbers  ");
				}
			} else {
				logger.error("TNumber doesn't exist");
				responseDTO.setResponseMessage("TNumbers doesn't exist");
			}
		} catch (Exception e) {
			logger.error("TNumberServiceImpl updateTNumbers failed: " + e);
		}
		return responseDTO;
	}

	/**
	 * delete tnumber by id
	 */
	@Override
	public TNumberResponseDTO deleteTNumberById(Long id) throws Exception {
		logger.info("Entering delete ..");
		TNumberResponseDTO responseDTO = new TNumberResponseDTO();
		try {
			Optional<TNumber> tNumberOptional = tNumberRepository.findById(id);
			if (!tNumberOptional.isPresent()) {
				logger.error("TNumbers doesn't exist");
				responseDTO.setResponseMessage("TNumbers doesn't exist");
				return responseDTO;
			}
			TNumber dataRespDTO = tNumberOptional.get();
			if (dataRespDTO == null) {
				logger.info("The TNumbers doesn't exists!!!");
				responseDTO.setResponseMessage("The TNumbers doesn't exists!!!");
			} else {
				tNumberRepository.delete(dataRespDTO);
				responseDTO.setResponseMessage(" TNumbers deleted successfully");
			}
		} catch (Exception e) {
			logger.error("delete :deleteTNumberById of TNumberServiceImpl  " + e);
		}
		logger.info("Exiting delete tNumber");
		return responseDTO;
	}

	/** Method for converting bytearray to string */
	private TNumberResponseDTO convertByteArrayToString(TNumber tNumber) {
		TNumberResponseDTO responseDTO = new TNumberResponseDTO();
		try {
			if (tNumber.getNotes() != null) {
				responseDTO.setNotes(new String(tNumber.getNotes()));
			}
			if (tNumber.getDesignerNote() != null) {
				responseDTO.setDesignerNote(new String(tNumber.getDesignerNote()));
			}
			if (tNumber.getCadNote() != null) {
				responseDTO.setCadNote(new String(tNumber.getCadNote()));
			}
			if (tNumber.getCadNote1() != null) {
				responseDTO.setCadNote1(new String(tNumber.getCadNote1()));
			}
			if (tNumber.getRenderNote() != null) {
				responseDTO.setRenderNote(new String(tNumber.getRenderNote()));
			}
//			if (tNumber.getTdate() != null) {
//				responseDTO.setTdate(DateUtils.convertDatetoUTC(tNumber.getTdate()));
//			}
//			if (tNumber.getCadDate1() != null) {
//				responseDTO.setCadDate1(DateUtils.convertDatetoUTC(tNumber.getCadDate1()));
//			}
//			if (tNumber.getDesignDate() != null) {
//				responseDTO.setDesignDate(DateUtils.convertDatetoUTC(tNumber.getDesignDate()));
//			}
//			if (tNumber.getRenderDate() != null) {
//				responseDTO.setRenderDate(DateUtils.convertDatetoUTC(tNumber.getRenderDate()));
//			}
		} catch (Exception e) {
			logger.error("error in TNumberServiceImpl on convertByteArrayToString: " + e);
		}
		return responseDTO;

	}

}
