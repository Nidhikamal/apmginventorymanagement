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

import com.bourntec.apmg.entity.CodeClasp;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodeClaspRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodeClaspResponsetDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.CodeClaspService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/claspmaintainance")
public class CodeClaspController {
	@Autowired
	CodeClaspService codeClaspService;

	/**
	 * This API fetches all claspMaintainanceDetails *
	 * 
	 * @param Id
	 * @return List<CodeClaspResponsetDTO
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<CodeClaspResponsetDTO>> findAllCodeClasp() throws Exception {
		List<CodeClaspResponsetDTO> addtionalOrderDataResponsetDTOList = codeClaspService.findAllodeClasp();
		return ResponseEntity.ok(addtionalOrderDataResponsetDTOList);
	}

	/**
	 * This API fetches claspManitainance By claspId
	 * 
	 * @param Id
	 * @return ResponseEntity<CodeClaspResponsetDTO>
	 * @throws Exception
	 */

	@GetMapping("/{claspId}")
	public ResponseEntity<CodeClaspResponsetDTO> findByclaspId(@PathVariable String claspId) throws Exception {
		CodeClaspResponsetDTO codeClarityResponseDTO = codeClaspService.findByclaspId(claspId);
		return ResponseEntity.ok(codeClarityResponseDTO);
	}

	/**
	 * This API fetches all StoneOriginDetails.
	 * 
	 * @return <List<CodesCountryResponsetDTO>
	 * @throws Exception
	 */

	@PostMapping("")
	public ResponseEntity<CodeClaspResponsetDTO> savecodeClasp(@RequestBody CodeClaspRequestDTO codeClaspRequestDTO)
			throws Exception {
		CodeClaspResponsetDTO codeClaspResponsetDTO = codeClaspService.savecodeClasp(codeClaspRequestDTO);
		return ResponseEntity.ok(codeClaspResponsetDTO);
	}

	/**
	 * This API fetches all StoneOriginDetails.
	 * 
	 * @return <List<CodesCountryResponsetDTO>
	 * @throws Exception
	 */

	@PutMapping("/{claspId}")
	public ResponseEntity<CodeClaspResponsetDTO> updatecodeclasp(@PathVariable String claspId,
			@RequestBody CodeClaspRequestDTO codeClaspRequestDTO) throws Exception {
		CodeClaspResponsetDTO codeClaspResponsetDTO = codeClaspService.updatecodeclasp(claspId, codeClaspRequestDTO);
		return ResponseEntity.ok(codeClaspResponsetDTO);
	}

	/**
	 * This API delete an claspMaintainanceDetails
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<CodeClaspResponsetDTO> deleteShapeMaintance(@PathVariable String id) throws Exception {
		CodeClaspResponsetDTO responsetDTO = codeClaspService.delete(id);
		return ResponseEntity.ok(responsetDTO);
	}

	/**
	 * This API search on StoneOrigin object.
	 * 
	 * @param CodeShapeRequestDTO
	 * @return List<CodeClaspResponsetDTO>
	 * @throws Exception
	 */

	@PostMapping("/search")
	public ResponseEntity<List<CodeClasp>> searchShapeMaintance(
			@RequestBody CodeClaspRequestDTO claspRequestDTO) throws Exception {
		List<CodeClasp> responsetDTO = codeClaspService.search(claspRequestDTO);
		return ResponseEntity.ok(responsetDTO);
	}
}
