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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.TNumberAttachmentRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TNumberAttachmentResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.TNumberAttachmentService;

/**
 * Controller claas for TNumberAttachment
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/TNumberAttachment")
public class TNumberAttachmentController {

	@Autowired
	TNumberAttachmentService tNumberAttachmentService;

	/**
	 * This REST endpoint exposes for get all tNumberAttachment details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<TNumberAttachmentResponseDTO>> fetchAllData() throws Exception {

		List<TNumberAttachmentResponseDTO> allData = tNumberAttachmentService.findAllTNumberAttachments();
		return ResponseEntity.ok(allData);
	}

	/**
	 * This REST endpoint exposes for get tNumberAttachment by id
	 * detailsfindAllTNumberAttachments
	 * 
	 */
	@GetMapping("/{id}")
	public ResponseEntity<TNumberAttachmentResponseDTO> getTNumberAttachmentById(@PathVariable Long id)
			throws Exception {

		TNumberAttachmentResponseDTO allData = tNumberAttachmentService.getTNumberAttachmentById(id);
		return ResponseEntity.ok(allData);
	}

	/**
	 * Endpoint for save
	 * 
	 * @param TNumberAttachmentRequestDTO
	 * @return TNumberAttachmentResponseDTO
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<TNumberAttachmentResponseDTO> saveTNumberAttachments(
			@RequestBody TNumberAttachmentRequestDTO tNumberAttachmentRequestDTO) throws Exception {

		TNumberAttachmentResponseDTO savedrespData = tNumberAttachmentService
				.saveTNumberAttachments(tNumberAttachmentRequestDTO);

		return ResponseEntity.ok(savedrespData);

	}

	/**
	 * Endpoint for search
	 * 
	 * @param TNumberAttachmentRequestDTO
	 * @return List<TNumberAttachmentResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<TNumberAttachmentResponseDTO>> findTNumberAttachmentByCriteria(
			@RequestBody TNumberAttachmentRequestDTO tNumberAttachmentRequestDTO) throws Exception {

		List<TNumberAttachmentResponseDTO> responseDTO = tNumberAttachmentService
				.findTNumberAttachmentByCriteria(tNumberAttachmentRequestDTO);

		return ResponseEntity.ok(responseDTO);

	}

	/**
	 * Endpoint for updation
	 * 
	 * @param TNumberAttachmentRequestDTO
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<TNumberAttachmentResponseDTO> updateTNumberAttachments(
			@RequestBody TNumberAttachmentRequestDTO tNumberAttachmentRequestDTO, @PathVariable Long id) throws Exception {

		TNumberAttachmentResponseDTO updatedrespData = tNumberAttachmentService.updateTNumberAttachment(id,
				tNumberAttachmentRequestDTO);
		return ResponseEntity.ok(updatedrespData);
	}

	/**
	 * Endpoint for deletion
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	private ResponseEntity<TNumberAttachmentResponseDTO> deleteTNumberAttachmentById(@PathVariable("id") Long id)
			throws Exception {
		TNumberAttachmentResponseDTO responseDTO = tNumberAttachmentService.deleteTNumberAttachmentById(id);
		return ResponseEntity.ok(responseDTO);
	}

}