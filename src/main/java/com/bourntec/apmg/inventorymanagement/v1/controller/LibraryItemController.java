package com.bourntec.apmg.inventorymanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.LibraryItemRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.LibraryItemResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.LibraryItemService;

/**
 * @author Babu
 * Reading and writing library images
 *
 */
@RestController(value = "LibraryItemController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/libraryitem")
public class LibraryItemController {

	@Autowired
	LibraryItemService inventoryService;

	@PostMapping("")
	public ResponseEntity<LibraryItemResponseDTO> saveLibraryItemResponse(
			@RequestBody List<LibraryItemRequestDTO> reqDTO) throws Exception {
		LibraryItemResponseDTO respDTO = inventoryService.saveLibraryItem(reqDTO);
		return ResponseEntity.ok(respDTO);

	}

	@PutMapping("/{itemCode}")
	public ResponseEntity<Object> updateLibraryItem(@RequestBody List<LibraryItemRequestDTO> reqDTO,
			@PathVariable String itemCode) throws Exception {

		LibraryItemResponseDTO libraryItemResponseDTO = inventoryService.updateLibraryItem(reqDTO, itemCode);
		return ResponseEntity.ok(libraryItemResponseDTO);
	}

	@GetMapping("/{itemId}")
	public ResponseEntity<List<LibraryItemResponseDTO>> getLibraryItemById(@PathVariable String itemId)
			throws Exception {

		List<LibraryItemResponseDTO> libraryItemResponseDTO = inventoryService.getLibraryItemById(itemId);
		return ResponseEntity.ok(libraryItemResponseDTO);
	}

	@GetMapping("/thumb/{libId}")
	public ResponseEntity<byte[]> getActyualImage(@PathVariable int libId) throws Exception {

		byte[] imageArray = inventoryService.readActualImage(libId);
		return ResponseEntity.ok(imageArray);
	}

}
