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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InvUnitChargeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvUnitChargeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InvUnitChargeService;

/**
 * 
 * @author Nince
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/invunitcharge")
public class InvUnitChargeController {

	@Autowired
	InvUnitChargeService invUnitChargeService;
	/**
	 * This API saves a Memo Manifest
	 * 
	 * @param InvUnitChargeRequestDTO
	 * 
	 * @return
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<InvUnitChargeResponseDTO> saveInvUnitCharge(
			@RequestBody InvUnitChargeRequestDTO invUnitChargeRequestdto) throws Exception {
		InvUnitChargeResponseDTO invUnitChargeResponsedto = invUnitChargeService.saveInvUnitCharge(invUnitChargeRequestdto);
		return ResponseEntity.ok(invUnitChargeResponsedto);
	}

	/**
	 * This API updates a Memo Manifest
	 * 
	 * @param unitCharge
	 * @param InvUnitChargeRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{unitCharge}")
	public ResponseEntity<InvUnitChargeResponseDTO> updateMemoManifest(@PathVariable String unitCharge,
			@RequestBody InvUnitChargeRequestDTO invUnitChargeRequestdto) throws Exception {
		InvUnitChargeResponseDTO invUnitChargeResponsedto = invUnitChargeService.updateInvUnitCharge(unitCharge, invUnitChargeRequestdto);
		return ResponseEntity.ok(invUnitChargeResponsedto);
	}

	/**
	 * This API fetches Inv Unit Charge according to {unitCharge}
	 * 
	 * @param unitCharge
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{unitCharge}")
	public ResponseEntity<InvUnitChargeResponseDTO> getById(@PathVariable String unitCharge)
			throws Exception {
		InvUnitChargeResponseDTO invUnitChargeResponsedto = invUnitChargeService.getById(unitCharge);
		return ResponseEntity.ok(invUnitChargeResponsedto);
	}

	/**
	 * This API fetches all Memo Manifests.
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("")
	public ResponseEntity<List<InvUnitChargeResponseDTO>> getAll() throws Exception {
		List<InvUnitChargeResponseDTO> invUnitChargeResponseList = invUnitChargeService.getAll();
		return ResponseEntity.ok(invUnitChargeResponseList);
	}

	/**
	 * REST endpoint exposes the search interface for searching a Inv Unit Charge
	 * dynamically
	 * 
	 * @param InvUnitChargeRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<InvUnitChargeResponseDTO>> fetchByMemoManifest(
			@RequestBody InvUnitChargeRequestDTO invUnitChargeRequestdto) throws Exception {

		List<InvUnitChargeResponseDTO> invUnitChargeResponseList = invUnitChargeService.fetchByInvUnitCharge(invUnitChargeRequestdto);

		return ResponseEntity.ok(invUnitChargeResponseList);
	}

	/**
	 * This API delete a Memo Manifest
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<InvUnitChargeResponseDTO> deleteMemoManifest(@PathVariable String unitCharge) {
		InvUnitChargeResponseDTO invUnitChargeResponse = invUnitChargeService.deleteInvUnitCharge(unitCharge);
		return ResponseEntity.ok(invUnitChargeResponse);
	}
}
