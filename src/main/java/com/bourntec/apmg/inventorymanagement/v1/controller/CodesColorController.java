package com.bourntec.apmg.inventorymanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.entity.CodesColor;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesColorRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesColorResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.CodeColorService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/colorcodes")
public class CodesColorController {
	@Autowired
	CodeColorService codeColorService;

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for returning
	 *          all color codes
	 * @param
	 * @return ResponseEntity,List<CodesColor>
	 */
	@GetMapping("")
	public ResponseEntity<List<CodesColor>> fetchAllColorCodes() throws Exception {

		List<CodesColor> allColorCodes = codeColorService.findAllColorCodes();
		return ResponseEntity.ok(allColorCodes);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for returning
	 *          color code by id
	 * @param colorId
	 * @return ResponseEntity<CodesColorResponseDTO>
	 */

	@GetMapping("/{colorId}")
	public ResponseEntity<CodesColorResponseDTO> fetchByColorId(@PathVariable String colorId) throws Exception {

		CodesColorResponseDTO selectedColorCodes = codeColorService.findColorCodesById(colorId);

		return ResponseEntity.ok(selectedColorCodes);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          Color codes
	 * @param
	 * @return ResponseEntity<CodesColorResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<CodesColorResponseDTO> saveColorCodes(@RequestBody CodesColorRequestDTO codesColorReqDTO)
			throws Exception {

		CodesColorResponseDTO savedColorCodesRespDTO = codeColorService.saveColorCodes(codesColorReqDTO);

		return ResponseEntity.ok(savedColorCodesRespDTO);

	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for updating
	 *          color code by Id
	 * @param CodesColorRequestDTO,colorId
	 * @return ResponseEntity<CodesColorResponseDTO>
	 */

	@PutMapping("/{colorId}")
	public ResponseEntity<Object> updateColorCodes(@RequestBody CodesColorRequestDTO codesColorReqDTO,
			@PathVariable String colorId) throws Exception {

		CodesColorResponseDTO updatedColorCodesResDTO = codeColorService.updateColorCodesById(colorId,
				codesColorReqDTO);
		return ResponseEntity.ok(updatedColorCodesResDTO);
	}

	/**
	 * This API delete an StoneOrigin object.
	 * 
	 * @param id
	 * @return CodesCountryResponsetDTO
	 * @throws Exception
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<CodesColorResponseDTO> deleteShapeMaintance(@PathVariable String id) throws Exception {
		CodesColorResponseDTO responsetDTO = codeColorService.delete(id);
		return ResponseEntity.ok(responsetDTO);
	}

	/**
	 * This API search on StoneOrigin object.
	 * 
	 * @param CodeShapeRequestDTO
	 * @return List<CodesCountryResponsetDTO>
	 * @throws Exception
	 */

	@PostMapping("/search")
	public ResponseEntity<List<CodesColorResponseDTO>> searchShapeMaintance(
			@RequestBody CodesColorRequestDTO requestDTO) throws Exception {
		List<CodesColorResponseDTO> responsetDTO = codeColorService.search(requestDTO);
		return ResponseEntity.ok(responsetDTO);
	}
}
