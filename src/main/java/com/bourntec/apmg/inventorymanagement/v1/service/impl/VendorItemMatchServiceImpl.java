package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.VendorItemMatch;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.VendorItemMatchRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.VendorItemMatchResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.VendorItemMatchRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.VendorItemMatchService;
import com.bourntec.apmg.inventorymanagement.v1.service.fiegnclient.UsermanagementFeignClient;

@Service
public class VendorItemMatchServiceImpl implements VendorItemMatchService {
	private static final Logger logger = LogManager.getLogger(InventoryFindingsServiceImpl.class);

	@Autowired
	UsermanagementFeignClient usermanagementFeignClient;
	@Autowired
	VendorItemMatchRepository vendorItemMatchRepository;

	@Override
	public VendorItemMatchResponseDTO saveInvetoryData(List<VendorItemMatchRequestDTO> lstvendorItemMatchRequestDTO)
			throws Exception {

		VendorItemMatchResponseDTO vendorItemMatchResponseDTO = new VendorItemMatchResponseDTO();
		try {
			for (VendorItemMatchRequestDTO vendorItemMatchRequestDTO : lstvendorItemMatchRequestDTO) {
				if (vendorItemMatchRequestDTO.getVendorNo() != null) {
					VendorItemMatch vendorItemMatch = vendorItemMatchRequestDTO.toModel(vendorItemMatchRequestDTO);
					// vendorItemMatch.setItemCode(itemCode);/// hard coded
					VendorItemMatch vendorItemMatchEntity = vendorItemMatchRepository.save(vendorItemMatch);
					if (vendorItemMatchEntity != null) {
						BeanUtils.copyProperties(vendorItemMatchEntity, vendorItemMatchResponseDTO);
						logger.info(" Vendor Item match Data saved successfully");// vendor no chk

					} else {
						logger.error("Failed to save Item match Data  ");
					}
				}
			}
		} catch (Exception e) {
			logger.error("Save: Item match Data  error " + e);
			throw e;
		}

		return vendorItemMatchResponseDTO;
	}

	/**
	 * @author Babu
	 */
	@Override
	public VendorItemMatchResponseDTO updateVendorItemMatch(
			List<VendorItemMatchRequestDTO> lstvendorItemMatchRequestDTO, String itemCode) throws Exception {
		List<VendorItemMatch> vendItemList = vendorItemMatchRepository.findByItemCode(itemCode);
		vendItemList.forEach((vendObj) -> {
			vendorItemMatchRepository.delete(vendObj);
		});
		VendorItemMatchResponseDTO vendorItemMatchResponseDTO = saveInvetoryData(lstvendorItemMatchRequestDTO);
		if (vendorItemMatchResponseDTO != null) {
			vendorItemMatchResponseDTO.setResponseMessage("VendorItem Match updated successfully.");
		} else {
			vendorItemMatchResponseDTO.setResponseMessage("VendorItem Match not updated .");

		}
		return vendorItemMatchResponseDTO;
	}

	/**
	 * @author Babu
	 */
	@Override
	public List<VendorItemMatch> fetchAllVendorItemMatchByItemcode(String itemCode) {
		try {
			Object list = usermanagementFeignClient.findStatecodeById("gg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vendorItemMatchRepository.findByItemCode(itemCode);
	}

}
