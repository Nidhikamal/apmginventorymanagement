package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.InvStyleName;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InvStyleNameRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvStyleNameResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.InvStyleNameRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.InvStyleNameService;

/**
 * 
 * Service class implementation for inventory
 * 
 * @author Naveen Radakrishnan
 *
 */
@Service(value = "InvStyleNameServiceImpl")

public class InvStyleNameServiceImpl implements  InvStyleNameService {

	private static final Logger logger = LogManager.getLogger(InvStyleNameServiceImpl.class);

	
	@Autowired
	InvStyleNameRepository invStyleNameRepository;
	/**
	 * This method saveStyleName
	 * @param InvStyleNameRequestDTO
	 * @return InvStyleNameResponseDTO
	 * @throws Exception 
	 */

	public InvStyleNameResponseDTO saveStyleName(InvStyleNameRequestDTO reqDTO) throws Exception {
		

		InvStyleNameResponseDTO  notificationResponseDTO = new InvStyleNameResponseDTO ();
		try {
			logger.info("Going to save invStyleName Details");			
			InvStyleName invStyleName = reqDTO.toModel(reqDTO);
			InvStyleName invStyleNamesentity=invStyleNameRepository.save(invStyleName);
			if(invStyleNamesentity!=null){
				BeanUtils.copyProperties(invStyleNamesentity, notificationResponseDTO);
				logger.info("invStyleName saved successfully");
				notificationResponseDTO.setResponseMessage("Success");
			}
			else{
				notificationResponseDTO.setResponseMessage("Failed");
				logger.error("Failed to save invStyleName ");
			}
		}
		catch (Exception e) {
			logger.error("InvStyleNameServiceImpl:Saving invStyleName" + e);
			throw e;
		}
		return notificationResponseDTO;




	
	}


	/**
	 * This method updateStyleName
	 * @param InvStyleNameRequestDTO
	 * @return InvStyleNameResponseDTO
	 * @throws Exception 
	 */



	public InvStyleNameResponseDTO updateStyleName(InvStyleNameRequestDTO invStyleNameRequestDTO, String styleId) throws Exception {

		InvStyleNameResponseDTO  savedsRespDTO = new InvStyleNameResponseDTO ();
		try {
			Optional<InvStyleName> invStyleNameOptional = invStyleNameRepository.findById(styleId);
			if (invStyleNameOptional.isPresent()) {
				InvStyleName invStyleName = invStyleNameRequestDTO.toModel(invStyleNameRequestDTO);
				invStyleName.setStyleId(styleId);
				InvStyleName entity = invStyleNameRepository.save(invStyleName);
				if (entity != null) {
					BeanUtils.copyProperties(entity, savedsRespDTO);
					savedsRespDTO.setResponseMessage("Success");
					logger.info("InvStyleName invStyleName updated successfully");
				} else {
					savedsRespDTO.setResponseMessage("Failed");
					logger.info("InvStyleName invStyleName updation failed");
				}
			} else {
				logger.info("InvStyleName invStyleName doesn't exist");
				savedsRespDTO.setResponseMessage("InvStyleName s doesn't exist");
			}
		} catch (Exception e) {
			logger.error("InvStyleNameServiceImpl:Update :InvStyleName invStyleName" + e);
			throw e;
		}

		return savedsRespDTO;
	
	}

	/**
	 * This method getStyleNameById
	 * @param styleId
	 * @return InvStyleNameResponseDTO
	 * @throws Exception 
	 */



	public InvStyleNameResponseDTO getStyleNameById(String styleId)  throws Exception{			

		InvStyleNameResponseDTO invStyleNameDetails = new InvStyleNameResponseDTO ();
		try {
			logger.info("Fetching ping details..");
			Optional<InvStyleName> invStyleNameOptional =invStyleNameRepository.findById(styleId);
			if (invStyleNameOptional.isPresent()) {
				InvStyleName entity = invStyleNameOptional.get();
				BeanUtils.copyProperties(entity, invStyleNameDetails);
			} else {
				logger.error("InvStyleName  doesn't exist");
				invStyleNameDetails.setResponseMessage("Failed");
			}
		} catch (Exception e) {
			logger.error("InvStyleNameServiceImpl:Fetch: getBrandById" + e);
			throw e;
		}

		return invStyleNameDetails;

	 
	}

	/**
	 * This method findAllinvStyleName
	 * @return List<InvStyleNameResponseDTO>
	 * @throws Exception 
	 */

	public List<InvStyleNameResponseDTO> findAllinvStyleName() throws Exception {
		logger.info(" Going to find All invStyleName");

		List<InvStyleNameResponseDTO> invStyleNameResponseDTOs = new ArrayList<InvStyleNameResponseDTO >();
		try {
			List<InvStyleName> invStyleNameList= invStyleNameRepository.findAll();
			for (InvStyleName invStyleName : invStyleNameList) {
				InvStyleNameResponseDTO invStyleNameResponseDTO = new InvStyleNameResponseDTO ();
				BeanUtils.copyProperties(invStyleName,invStyleNameResponseDTO);
				invStyleNameResponseDTOs.add(invStyleNameResponseDTO);

			}
			logger.info("Find All invStyleName");	
		} catch (Exception e) {
			logger.error("InvStyleNameServiceImpl:invStyleName  failed" + e);
			throw e;

		}
		return invStyleNameResponseDTOs;


	}

	/**
	 * This method deleteStyleName
	 * @throws Exception 
	 */
	
	public void deleteStyleName(String styleId) throws Exception {
		logger.info("Entering deletetyleName  {}", styleId);

		Optional<InvStyleName> custList = invStyleNameRepository.findById(styleId);
		InvStyleName invStyleName = custList.get();
		try {
			if (invStyleName == null) {
				logger.info("The styleName doesn't exists!!!");
			} else {
				invStyleNameRepository.delete(invStyleName);
			}
			logger.info("Exiting deletestyleName");
		} catch (Exception e) {
			throw e;
		}

	}
}
