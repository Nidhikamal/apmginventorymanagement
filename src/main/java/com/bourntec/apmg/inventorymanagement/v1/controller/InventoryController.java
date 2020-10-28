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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.entity.CodesColor;
import com.bourntec.apmg.entity.CodesMaterial;
import com.bourntec.apmg.entity.CollectionKeyword;
import com.bourntec.apmg.entity.CountrySetup;
import com.bourntec.apmg.entity.InventoryCategory;
import com.bourntec.apmg.entity.InventoryPriceHistory;
import com.bourntec.apmg.entity.InventoryRank;
import com.bourntec.apmg.entity.TypeData;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.AdditionalOrderDataRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodeClarityRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodeClaspRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesSettingRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesShapeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesColorRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesCountryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesMaterailRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CollectionKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CountrySetupRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.Inventory1RequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryCategoryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryFindingsRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryRankRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.LockingTypeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.TypeDataRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.AdditionalOrderDataResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodeClarityResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodeClaspResponsetDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesSettingResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesShapeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesColorResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesCountryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesMaterialResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CollectionKeywordResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CountrySetupResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CustomManfStoneResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvCategoryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.Inventory1ResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryFindingsResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryRankResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.LockingTypeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TypeDataResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryService;

/**
 * @author Srijini T.S
 *
 */
@Deprecated
@RestController(value = "InventoryController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v3")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;

	/**
	 * This API creates new LockType object
	 * 
	 * @param LockingTypeRequestDTO
	 * @return ResponseEntity<LockingTypeResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("/lockingtype")
	public ResponseEntity<LockingTypeResponseDTO> saveLockingTypes(
			@RequestBody LockingTypeRequestDTO lockingTypesRequestDTO) throws Exception {
		LockingTypeResponseDTO LockingTypesResponseDTO = inventoryService.saveLockingTypes(lockingTypesRequestDTO);
		return ResponseEntity.ok(LockingTypesResponseDTO);
	}

	/**
	 * This API updtes an LockType object.
	 * 
	 * @param id
	 * @param LockingTypeRequestDTO
	 * @return ResponseEntity<LockingTypeResponseDTO>
	 * @throws Exception
	 */

	@PutMapping("/lockingtype/{id}")
	public ResponseEntity<LockingTypeResponseDTO> updateLockingType(@PathVariable Long id,
			@RequestBody LockingTypeRequestDTO lockingTypeRequestDTO) throws Exception {
		LockingTypeResponseDTO lockingTypeResponseDTO = inventoryService.updateLockingType(id, lockingTypeRequestDTO);
		return ResponseEntity.ok(lockingTypeResponseDTO);
	}

	/**
	 * This API fetches LockType object.
	 * 
	 * @param lockingTypeId
	 * @return ResponseEntity<LockingTypeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/lockingtype/{lockingTypeId}")
	public ResponseEntity<LockingTypeResponseDTO> findLockingTypeById(@PathVariable Long lockingTypeId)
			throws Exception {
		LockingTypeResponseDTO LockingTypesResponseDTO = inventoryService.findLockingTypesById(lockingTypeId);
		return ResponseEntity.ok(LockingTypesResponseDTO);
	}

	/**
	 * This API fetch all LockingType.
	 * 
	 * @return<List<LockingTypeResponseDTO>>
	 * @throws Exception
	 */

	@GetMapping("/lockingtype")
	public ResponseEntity<List<LockingTypeResponseDTO>> findAllLockingTypes() throws Exception {
		List<LockingTypeResponseDTO> lockingTypesResponseDTOList = inventoryService.findAllLockingTypes();
		return ResponseEntity.ok(lockingTypesResponseDTOList);
	}

	/**
	 * This API creates new ShapeMaintainance object
	 * 
	 * @param CodesShapeRequestDTO
	 * @return ResponseEntity<CodeShapeResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("/shapemaintainance")
	public ResponseEntity<CodesShapeResponseDTO> saveCodeShape(@RequestBody CodesShapeRequestDTO codeShapeRequestDTO)
			throws Exception {
		CodesShapeResponseDTO codeShapeResponseDTO = inventoryService.saveCodeShape(codeShapeRequestDTO);
		return ResponseEntity.ok(codeShapeResponseDTO);
	}

	/**
	 * This API updates an CodeShapeMaintainanceshape object.
	 * 
	 * @param id
	 * @param CodesShapeRequestDTO
	 * @return ResponseEntity<CodeShapeResponseDTO>
	 * @throws Exception
	 */

	@PutMapping("/shapemaintainance/{shapeId}")
	public ResponseEntity<CodesShapeResponseDTO> updateShapeMaintainance(@PathVariable String shapeId,
			@RequestBody CodesShapeRequestDTO codeShapeRequestDTO) throws Exception {
		CodesShapeResponseDTO codeShapeResponseDTO = inventoryService.updateShapeMaintainance(shapeId,
				codeShapeRequestDTO);
		return ResponseEntity.ok(codeShapeResponseDTO);
	}

	/**
	 * This API fetches ShapeMaintainance object.
	 * 
	 * @param userId
	 * @return ResponseEntity<CodeShapeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/shapemaintainance/{shapeId}")
	public ResponseEntity<CodesShapeResponseDTO> findShapecodeById(@PathVariable String shapeId) throws Exception {
		CodesShapeResponseDTO codeShapeResponseDTO = inventoryService.findShapecodeById(shapeId);
		return ResponseEntity.ok(codeShapeResponseDTO);
	}

	/**
	 * This API finAll new ShapeMaintainance object
	 * 
	 * @return ResponseEntity<CodeShapeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/shapemaintainance")
	public ResponseEntity<List<CodesShapeResponseDTO>> findAllShapeCode() throws Exception {
		List<CodesShapeResponseDTO> codeShapeResponseDTOList = inventoryService.findAllShapeId();
		return ResponseEntity.ok(codeShapeResponseDTOList);
	}

	/**
	 * This API creates new SizeMaintainence object
	 * 
	 * @param AdditionalOrderDataRequestDTO
	 * @return ResponseEntity<AddtionalOrderDataResponsetDTO>
	 * @throws Exception
	 */

	@PostMapping("/sizemaintainence")
	public ResponseEntity<AdditionalOrderDataResponseDTO> saveSizeMaintainence(
			@RequestBody AdditionalOrderDataRequestDTO addtionalOrderDataRequestDTO) throws Exception {
		AdditionalOrderDataResponseDTO addtionalOrderDataResponsetDTO = inventoryService
				.saveSizeMaintainence(addtionalOrderDataRequestDTO);
		return ResponseEntity.ok(addtionalOrderDataResponsetDTO);
	}

	/**
	 * This API updates an SizeMaintainence object.
	 * 
	 * @param additionalDataValue
	 * @param AdditionalOrderDataRequestDTO
	 * @return ResponseEntity<AddtionalOrderDataResponsetDTO>
	 * @throws Exception
	 */

	@PutMapping("/sizemaintainence/{additionalDataValue}")
	public ResponseEntity<AdditionalOrderDataResponseDTO> updateSizeMaintainence(
			@PathVariable String additionalDataValue,
			@RequestBody AdditionalOrderDataRequestDTO addtionalOrderDataRequestDTO) throws Exception {
		AdditionalOrderDataResponseDTO addtionalOrderDataResponsetDTO = inventoryService
				.updateSizeMaintainence(additionalDataValue, addtionalOrderDataRequestDTO);
		return ResponseEntity.ok(addtionalOrderDataResponsetDTO);
	}

	/**
	 * This API fetch an SizeMainatinence object.
	 * 
	 * @param userId
	 * @return ResponseEntity<AddtionalOrderDataResponsetDTO>
	 * @throws Exception
	 */

	@GetMapping("/sizemaintainence/{additionalDataValue}")
	public ResponseEntity<AdditionalOrderDataResponseDTO> findSizeMainatinenceById(
			@PathVariable String additionalDataValue) throws Exception {
		AdditionalOrderDataResponseDTO addtionalOrderDataResponsetDTO = inventoryService
				.findSizeMainatinenceById(additionalDataValue);
		return ResponseEntity.ok(addtionalOrderDataResponsetDTO);
	}

	/**
	 * This API fetches allSizeMaintainence details
	 * 
	 * @return List<AddtionalOrderDataResponsetDTO
	 * @throws Exception
	 */
	@GetMapping("/sizemaintainence")
	public ResponseEntity<List<AdditionalOrderDataResponseDTO>> findAllSizeMainatinence() throws Exception {
		List<AdditionalOrderDataResponseDTO> addtionalOrderDataResponsetDTOList = inventoryService
				.findAllSizeMainatinence();
		return ResponseEntity.ok(addtionalOrderDataResponsetDTOList);
	}

	/**
	 * This API creates new StoneOrigin object
	 * 
	 * @param CountryRequestDTO
	 * @return ResponseEntity<CodesCountryResponsetDTO>
	 * @throws Exception
	 */
	@PostMapping("/stoneorigin")
	public ResponseEntity<CodesCountryResponseDTO> savecodeCountry(
			@RequestBody CodesCountryRequestDTO codesCountryRequestDTO) throws Exception {
		CodesCountryResponseDTO codesCountryResponsetDTO = inventoryService.savecodeCountry(codesCountryRequestDTO);
		return ResponseEntity.ok(codesCountryResponsetDTO);
	}

	/**
	 * This API updates an StoneOrigin object.
	 * 
	 * @param countryCode
	 * @param CodesCountryRequestDTO
	 * @return ResponseEntity<CodesCountryResponsetDTO>
	 * @throws Exception
	 */

	@PutMapping("/stoneorigin/{countryCode}")
	public ResponseEntity<CodesCountryResponseDTO> updateStoneOrigin(@PathVariable String countryCode,
			@RequestBody CodesCountryRequestDTO codesCountryRequestDTO) throws Exception {
		CodesCountryResponseDTO codesCountryResponsetDTO = inventoryService.updateStoneOrigin(countryCode,
				codesCountryRequestDTO);
		return ResponseEntity.ok(codesCountryResponsetDTO);
	}

	/**
	 * This API fetches StoneOrigin object.
	 * 
	 * @param countryCode
	 * @return ResponseEntity<CountrycodeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/stoneorigin/{countryCode}")
	public ResponseEntity<CodesCountryResponseDTO> findcodeCountryById(@PathVariable String countryCode)
			throws Exception {
		CodesCountryResponseDTO codesCountryResponsetDTO = inventoryService.findcodeCountryById(countryCode);
		return ResponseEntity.ok(codesCountryResponsetDTO);
	}

	/**
	 * This API fetches all StoneOriginDetails.
	 * 
	 * @return <List<CodesCountryResponsetDTO>
	 * @throws Exception
	 */

	@GetMapping("/stoneorigin")
	public ResponseEntity<List<CodesCountryResponseDTO>> findAllCodesCountry() throws Exception {
		List<CodesCountryResponseDTO> codesCountryResponsetDTODTOList = inventoryService.findAllCodesCountry();
		return ResponseEntity.ok(codesCountryResponsetDTODTOList);
	}

	/**
	 * This API creates new clarityMaintainance object
	 * 
	 * @param CodeClarityRequestDTO
	 * @return ResponseEntity<CodeClarityResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("/claritymaintainance")
	public ResponseEntity<CodeClarityResponseDTO> savecodeClarity(
			@RequestBody CodeClarityRequestDTO codesCountryRequestDTO) throws Exception {
		CodeClarityResponseDTO codeClarityResponseDTO = inventoryService.savecodeClarity(codesCountryRequestDTO);
		return ResponseEntity.ok(codeClarityResponseDTO);
	}

	/**
	 * This API finds CodeClarity By Id
	 * 
	 * @param clarityId
	 * @return ResponseEntity<CodeClarityResponseDTO>
	 * @throws Exception
	 */

	/**
	 * This API updates an StoneOrigin object.
	 * 
	 * @param countryCode
	 * @param CodesCountryRequestDTO
	 * @return ResponseEntity<CodesCountryResponsetDTO>
	 * @throws Exception
	 */

	@PutMapping("/claritymaintainance/{clarityId}")
	public ResponseEntity<CodeClarityResponseDTO> updateclaritymaintainance(@PathVariable String clarityId,
			@RequestBody CodeClarityRequestDTO codeClarityRequestDTO) throws Exception {
		CodeClarityResponseDTO codeClarityResponseDTO = inventoryService.updateclaritymaintainance(clarityId,
				codeClarityRequestDTO);
		return ResponseEntity.ok(codeClarityResponseDTO);
	}

	@GetMapping("/claritymaintainance/{clarityId}")
	public ResponseEntity<CodeClarityResponseDTO> findCodeClarityById(@PathVariable String clarityId) throws Exception {
		CodeClarityResponseDTO codeClarityResponseDTO = inventoryService.findCodeClarityById(clarityId);
		return ResponseEntity.ok(codeClarityResponseDTO);
	}

	/**
	 * This API findAll clarityMaintainance details
	 * 
	 * @return ResponseEntity<CodeShapeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/claritymaintainance")
	public ResponseEntity<List<CodeClarityResponseDTO>> findAllCodeClarity() throws Exception {
		List<CodeClarityResponseDTO> addtionalOrderDataResponsetDTOList = inventoryService.findAllCodeClarity();
		return ResponseEntity.ok(addtionalOrderDataResponsetDTOList);
	}

	/**
	 * This API fetches all StoneOriginDetails.
	 * 
	 * @return <List<CodesCountryResponsetDTO>
	 * @throws Exception
	 */

	@PostMapping("/claspmaintainance")
	public ResponseEntity<CodeClaspResponsetDTO> savecodeClasp(@RequestBody CodeClaspRequestDTO codeClaspRequestDTO)
			throws Exception {
		CodeClaspResponsetDTO codeClaspResponsetDTO = inventoryService.savecodeClasp(codeClaspRequestDTO);
		return ResponseEntity.ok(codeClaspResponsetDTO);
	}

	/**
	 * This API fetches all StoneOriginDetails.
	 * 
	 * @return <List<CodesCountryResponsetDTO>
	 * @throws Exception
	 */

	@PutMapping("/claspmaintainance/{claspId}")
	public ResponseEntity<CodeClaspResponsetDTO> updatecodeclasp(@PathVariable String claspId,
			@RequestBody CodeClaspRequestDTO codeClaspRequestDTO) throws Exception {
		CodeClaspResponsetDTO codeClaspResponsetDTO = inventoryService.updatecodeclasp(claspId, codeClaspRequestDTO);
		return ResponseEntity.ok(codeClaspResponsetDTO);
	}

	/**
	 * This API fetches claspManitainance By claspId
	 * 
	 * @param Id
	 * @return ResponseEntity<CodeClaspResponsetDTO>
	 * @throws Exception
	 */

	@GetMapping("/claspmaintainance/{claspId}")
	public ResponseEntity<CodeClaspResponsetDTO> findByclaspId(@PathVariable String claspId) throws Exception {
		CodeClaspResponsetDTO codeClarityResponseDTO = inventoryService.findByclaspId(claspId);
		return ResponseEntity.ok(codeClarityResponseDTO);
	}

	/**
	 * This API fetches all claspMaintainanceDetails
	 * 
	 * @param Id
	 * @return List<CodeClaspResponsetDTO
	 * @throws Exception
	 */

	@GetMapping("/claspmaintainance")
	public ResponseEntity<List<CodeClaspResponsetDTO>> findAllCodeClasp() throws Exception {
		List<CodeClaspResponsetDTO> addtionalOrderDataResponsetDTOList = inventoryService.findAllodeClasp();
		return ResponseEntity.ok(addtionalOrderDataResponsetDTOList);
	}

	/**
	 * This API creates new settingDetails object
	 * 
	 * @param CodesSettingRequestDTO
	 * @return ResponseEntity<CodeSettingResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("/settingdetails")
	public ResponseEntity<CodesSettingResponseDTO> savecodeSetting(
			@RequestBody CodesSettingRequestDTO codeSettingRequestDTO) throws Exception {
		CodesSettingResponseDTO codeClaspResponsetDTO = inventoryService.savecodeSetting(codeSettingRequestDTO);
		return ResponseEntity.ok(codeClaspResponsetDTO);
	}

	/**
	 * This API updated new settingDetails object
	 * 
	 * @param CodesSettingRequestDTO
	 * @return ResponseEntity<CodeSettingResponseDTO>
	 * @throws Exception
	 */

	@PutMapping("/settingdetails/{settingId}")
	public ResponseEntity<CodesSettingResponseDTO> updatecodeSetting(@PathVariable String settingId,
			@RequestBody CodesSettingRequestDTO codeSettingRequestDTO) throws Exception {
		CodesSettingResponseDTO codeClaspResponsetDTO = inventoryService.updatecodeSetting(settingId,
				codeSettingRequestDTO);
		return ResponseEntity.ok(codeClaspResponsetDTO);
	}

	/**
	 * This API fetches by settingId
	 * 
	 * @param settingId
	 * @return ResponseEntity<CodeSettingResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/settingdetails/{settingId}")
	public ResponseEntity<CodesSettingResponseDTO> findBycodeSetting(@PathVariable String settingId) throws Exception {
		CodesSettingResponseDTO codeClarityResponseDTO = inventoryService.findBycodeSetting(settingId);
		return ResponseEntity.ok(codeClarityResponseDTO);
	}

	/**
	 * This API fetches all settingDetails
	 * 
	 * @return List<CodeSettingResponseDTO
	 * @throws Exception
	 */

	@GetMapping("/codesetting")
	public ResponseEntity<List<CodesSettingResponseDTO>> findAllCodeSettings() throws Exception {
		List<CodesSettingResponseDTO> codeSettingResponseDTOList = inventoryService.findAllCodeSettings();
		return ResponseEntity.ok(codeSettingResponseDTOList);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for returning
	 *          all color codes
	 * @param
	 * @return ResponseEntity,List<CodesColor>
	 */
	@GetMapping("/colorcodes")
	public ResponseEntity<List<CodesColor>> fetchAllColorCodes() throws Exception {

		List<CodesColor> allColorCodes = inventoryService.findAllColorCodes();
		return ResponseEntity.ok(allColorCodes);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for returning
	 *          color code by id
	 * @param colorId
	 * @return ResponseEntity<CodesColorResponseDTO>
	 */

	@GetMapping("/colorcodes/{colorId}")
	public ResponseEntity<CodesColorResponseDTO> fetchByColorId(@PathVariable String colorId) throws Exception {

		CodesColorResponseDTO selectedColorCodes = inventoryService.findColorCodesById(colorId);

		return ResponseEntity.ok(selectedColorCodes);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          Color codes
	 * @param
	 * @return ResponseEntity<CodesColorResponseDTO>
	 */

	@PostMapping("/colorcodes")
	public ResponseEntity<CodesColorResponseDTO> saveColorCodes(@RequestBody CodesColorRequestDTO codesColorReqDTO)
			throws Exception {

		CodesColorResponseDTO savedColorCodesRespDTO = inventoryService.saveColorCodes(codesColorReqDTO);

		return ResponseEntity.ok(savedColorCodesRespDTO);

	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for updating
	 *          color code by Id
	 * @param CodesColorRequestDTO,colorId
	 * @return ResponseEntity<CodesColorResponseDTO>
	 */

	@PutMapping("/colorcodes/{colorId}")
	public ResponseEntity<Object> updateColorCodes(@RequestBody CodesColorRequestDTO codesColorReqDTO,
			@PathVariable String colorId) throws Exception {

		CodesColorResponseDTO updatedColorCodesResDTO = inventoryService.updateColorCodesById(colorId,
				codesColorReqDTO);
		return ResponseEntity.ok(updatedColorCodesResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for returning
	 *          all material codes
	 * @param
	 * @return ResponseEntity List<CodesMaterial>
	 */
	@GetMapping("/materialcodes")
	public ResponseEntity<List<CodesMaterial>> fetchAllMaterialCodes() throws Exception {

		List<CodesMaterial> allMaterialCodes = inventoryService.findAllMaterialCodes();
		return ResponseEntity.ok(allMaterialCodes);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for returning
	 *          Material Codes by id
	 * @param materialId
	 * @return ResponseEntity<CodesMaterialResponseDTO>
	 */

	@GetMapping("/materialcodes/{materialId}")
	public ResponseEntity<CodesMaterialResponseDTO> fetchByMaterialId(@PathVariable String materialId)
			throws Exception {

		CodesMaterialResponseDTO selectedMaterialCodes = inventoryService.findMaterialCodesById(materialId);

		return ResponseEntity.ok(selectedMaterialCodes);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          Materail Codes
	 * @param CodesMaterailRequestDTO
	 * @return ResponseEntity<CodesMaterialResponseDTO>
	 */

	@PostMapping("/materialcodes")
	public ResponseEntity<CodesMaterialResponseDTO> saveMaterailCodes(
			@RequestBody CodesMaterailRequestDTO codesMaterialReqDTO) throws Exception {

		CodesMaterialResponseDTO savedMaterailCodesRespDTO = inventoryService.saveMaterialCodes(codesMaterialReqDTO);

		return ResponseEntity.ok(savedMaterailCodesRespDTO);

	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for updating
	 *          materail codes by Material Id
	 * @param CodesMaterailRequestDTO,materialId
	 * @return ResponseEntity<CodesMaterialResponseDTO>
	 */

	@PutMapping("/materialcodes/{materialId}")
	public ResponseEntity<Object> updateMaterialCodes(@RequestBody CodesMaterailRequestDTO codesMaterialReqDTO,
			@PathVariable String materialId) throws Exception {

		CodesMaterialResponseDTO updatedMaterialCodesResDTO = inventoryService.updateMaterialCodesById(materialId,
				codesMaterialReqDTO);
		return ResponseEntity.ok(updatedMaterialCodesResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for updating
	 *          CountrySetup by country Id
	 * @param
	 * @return ResponseEntity<List<CountrySetup>>
	 */

	@GetMapping("/countrysetup")
	public ResponseEntity<List<CountrySetup>> fetchAllCountrySetups() throws Exception {

		List<CountrySetup> allCountrySetups = inventoryService.findCountrySetup();
		return ResponseEntity.ok(allCountrySetups);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for returning
	 *          countrySetup by id
	 * @param countryCode
	 * @return ResponseEntity<CountrySetupResponseDTO>
	 */

	@GetMapping("/countrysetup/{countryCode}")
	public ResponseEntity<CountrySetupResponseDTO> fetchByCountryId(@PathVariable String countryCode) throws Exception {

		CountrySetupResponseDTO selectedCountryCodes = inventoryService.findCountrySetupById(countryCode);

		return ResponseEntity.ok(selectedCountryCodes);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          countrySetUps
	 * @param CountrySetupRequestDTO
	 * @return ResponseEntity<CountrySetupResponseDTO>
	 */

	@PostMapping("/countrysetup")
	public ResponseEntity<CountrySetupResponseDTO> saveCountrySetup(
			@RequestBody CountrySetupRequestDTO countrySetupReqDTO) throws Exception {

		CountrySetupResponseDTO savedCountryRespDTO = inventoryService.saveCountrySetup(countrySetupReqDTO);

		return ResponseEntity.ok(savedCountryRespDTO);

	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for updating
	 *          countrySet up by Id
	 * @param CountrySetupRequestDTO,countryId
	 * @return ResponseEntity<CountrySetupResponseDTO>
	 */

	@PutMapping("/countrysetup/{countryCode}")
	public ResponseEntity<Object> updateCountrySetup(@RequestBody CountrySetupRequestDTO countrySetupReqDTO,
			@PathVariable String countryCode) throws Exception {

		CountrySetupResponseDTO updatedCountrySetupResDTO = inventoryService.updateCountrySetupById(countryCode,
				countrySetupReqDTO);
		return ResponseEntity.ok(updatedCountrySetupResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for getting all
	 *          Inventory Category
	 * @param CountrySetupRequestDTO,countryId
	 * @return ResponseEntity<CountrySetupResponseDTO>
	 */

	@GetMapping("/invcategory")
	public ResponseEntity<List<InventoryCategory>> fetchAllInventoryCategories() throws Exception {

		List<InventoryCategory> allInvCats = inventoryService.findAllInvCategories();
		return ResponseEntity.ok(allInvCats);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for returning
	 *          invCategories by id
	 * @param category
	 * @return ResponseEntity<InvCategoryResponseDTO>
	 */

	@GetMapping("/invcategory/{category}")
	public ResponseEntity<InvCategoryResponseDTO> fetchByCategoryId(@PathVariable String category) throws Exception {

		InvCategoryResponseDTO selectedInvCats = inventoryService.findInvCategoryById(category);

		return ResponseEntity.ok(selectedInvCats);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          inventory category
	 * @param InventoryCategoryRequestDTO
	 * @return ResponseEntity<InvCategoryResponseDTO>
	 */

	@PostMapping("/invcategory")
	public ResponseEntity<InvCategoryResponseDTO> saveCountrySetup(
			@RequestBody InventoryCategoryRequestDTO invCatReqDTO) throws Exception {

		InvCategoryResponseDTO invCatRespDTO = inventoryService.saveInvCategories(invCatReqDTO);

		return ResponseEntity.ok(invCatRespDTO);

	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for updating
	 *          brand by Id
	 * @param InventoryCategoryRequestDTO, category
	 * @return ResponseEntity<CountrySetupResponseDTO>
	 */

	@PutMapping("/invcategory/{category}")
	public ResponseEntity<InvCategoryResponseDTO> updateInvCat(@RequestBody InventoryCategoryRequestDTO invCatReqDTO,
			@PathVariable String category) throws Exception {

		InvCategoryResponseDTO invCategoryResDTO = inventoryService.updateInvCategoryById(category, invCatReqDTO);
		return ResponseEntity.ok(invCategoryResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for getting all
	 *          inventory Ranks by Id
	 * @param
	 * @return ResponseEntity<InventoryRank>
	 */

	@GetMapping("/invrank")
	public ResponseEntity<List<InventoryRank>> fetchAllInventoryRanks() throws Exception {

		List<InventoryRank> allInvRanks = inventoryService.findAllInvRanks();
		return ResponseEntity.ok(allInvRanks);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for returning
	 *          inventory rank by id
	 * @param rank
	 * @return ResponseEntity<InventoryRankResponseDTO>
	 */

	@GetMapping("/invrank/{rank}")
	public ResponseEntity<InventoryRankResponseDTO> fetchByRank(@PathVariable String rank) throws Exception {

		InventoryRankResponseDTO invRankResDTO = inventoryService.findInvRankById(rank);

		return ResponseEntity.ok(invRankResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          Inventory rank
	 * @param InventoryRankRequestDTO
	 * @return ResponseEntity<InventoryRankResponseDTO>
	 */

	@PostMapping("/invrank")
	public ResponseEntity<InventoryRankResponseDTO> saveInvrank(@RequestBody InventoryRankRequestDTO invRankReqDTO)
			throws Exception {

		InventoryRankResponseDTO invRankResDTO = inventoryService.saveInvRanks(invRankReqDTO);

		return ResponseEntity.ok(invRankResDTO);

	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for updating
	 *          Inventory rank by Id
	 * @param InventoryRankRequestDTO,rank
	 * @return ResponseEntity<CountrySetupResponseDTO>
	 */

	@PutMapping("/invrank/{rank}")
	public ResponseEntity<InventoryRankResponseDTO> updateInvRank(@RequestBody InventoryRankRequestDTO invRankReqDTO,
			@PathVariable String rank) throws Exception {

		InventoryRankResponseDTO invRankResDTO = inventoryService.updateInvRankById(rank, invRankReqDTO);
		return ResponseEntity.ok(invRankResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for getting all
	 *          TypeData
	 * @param
	 * @return ResponseEntity<InventoryRank>
	 */
	@GetMapping("/typedata")
	public ResponseEntity<List<TypeData>> fetchAllTypeDatas() throws Exception {

		List<TypeData> alltypedatas = inventoryService.findAllTypeDatas();
		return ResponseEntity.ok(alltypedatas);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for returning
	 *          TypeData by typeCode
	 * @param typeCode
	 * @return ResponseEntity<TypeDataResponseDTO>
	 */

	@GetMapping("/typedata/{typeCode}")
	public ResponseEntity<TypeDataResponseDTO> fetchByTypeCode(@PathVariable String typeCode) throws Exception {

		TypeDataResponseDTO typeDataResDTO = inventoryService.findTypeDataById(typeCode);

		return ResponseEntity.ok(typeDataResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          TypeData
	 * @param
	 * @return ResponseEntity<TypeDataResponseDTO>
	 */

	@PostMapping("/typedata")
	public ResponseEntity<TypeDataResponseDTO> saveTypeData(@RequestBody TypeDataRequestDTO typeDataReqDTO)
			throws Exception {

		TypeDataResponseDTO typeDataResDTO = inventoryService.saveTypeData(typeDataReqDTO);

		return ResponseEntity.ok(typeDataResDTO);

	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for updating
	 *          TypeData by Id
	 * @param TypeDataRequestDTO,typeCode
	 * @return ResponseEntity<CountrySetupResponseDTO>
	 */

	@PutMapping("/typedata/{typeCode}")
	public ResponseEntity<TypeDataResponseDTO> updateTypeData(@RequestBody TypeDataRequestDTO typeDataReqDTO,
			@PathVariable String typeCode) throws Exception {

		TypeDataResponseDTO typeDataResDTO = inventoryService.updateTypeDataById(typeCode, typeDataReqDTO);
		return ResponseEntity.ok(typeDataResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          CollectionKeyword
	 * @param
	 * @return ResponseEntity<CollectionKeywordResponseDTO>
	 */

	@PostMapping("/collectionkeyword")
	public ResponseEntity<CollectionKeywordResponseDTO> saveCollectionKeywords(
			@RequestBody CollectionKeywordRequestDTO keywordReqDTO) throws Exception {

		CollectionKeywordResponseDTO keywordResDTO = inventoryService.saveCollectionKeywords(keywordReqDTO);

		return ResponseEntity.ok(keywordResDTO);

	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          CollectionKeyword
	 * @param CollectionKeywordRequestDTO,keyId
	 * @return ResponseEntity<CollectionKeywordResponseDTO>
	 */

	@PutMapping("/collectionkeyword/{keyId}")
	public ResponseEntity<Object> updateKeywords(@RequestBody CollectionKeywordRequestDTO keywordReqDTO,
			@PathVariable String keyId) throws Exception {

		CollectionKeywordResponseDTO keywordResDTO = inventoryService.updateCollectionKeywordsById(keyId,
				keywordReqDTO);
		return ResponseEntity.ok(keywordResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for getting all
	 *          CollectionKeywords
	 * @param
	 * @return ResponseEntity<CollectionKeywordResponseDTO>
	 */

	@GetMapping("/collectionkeyword")
	public ResponseEntity<List<CollectionKeyword>> fetchAllCollectionKeywords() throws Exception {

		List<CollectionKeyword> allKeywords = inventoryService.findAllCollectionKeywords();
		return ResponseEntity.ok(allKeywords);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for getting
	 *          CollectionKeyword by Id
	 * @param keyWrd
	 * @return ResponseEntity<CollectionKeywordResponseDTO>
	 */

	@GetMapping("/collectionkeyword/{keyWrd}")
	public ResponseEntity<CollectionKeywordResponseDTO> fetchCollectionKeywordById(@PathVariable String keyWrd)
			throws Exception {

		CollectionKeywordResponseDTO keywordResDTO = inventoryService.findCollectionKeywordById(keyWrd);
		return ResponseEntity.ok(keywordResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          Inventory
	 * @param
	 * @return ResponseEntity<Inventory1ResponseDTO>
	 */

	@PostMapping("/inventory")
	public ResponseEntity<Inventory1ResponseDTO> saveinventory(@RequestBody Inventory1RequestDTO invReqDTO)
			throws Exception {

		Inventory1ResponseDTO invRespDTO = inventoryService.saveInvetoryData(invReqDTO);

		return ResponseEntity.ok(invRespDTO);

	}

	/**
	 * @Author:Srijini AP-130 - > AP-238 Inventory Edit unit of measure finished
	 *                 jewelry -findings
	 * 
	 *                 End point for list all finding of corresponding item
	 * 
	 * @param itemCode
	 * @return ResponseEntity<List<InventoryFindingsResponseDTO>>
	 */
	@GetMapping("/inventory/findings/{itemCode}")
	public ResponseEntity<List<InventoryFindingsResponseDTO>> getItemFindings(@PathVariable String itemCode)
			throws Exception {

		List<InventoryFindingsResponseDTO> findingsResponseDTO = inventoryService.getItemFindings(itemCode);
		return ResponseEntity.ok(findingsResponseDTO);

	}

	/**
	 * @Author:Srijini AP-130 - > AP-238 Inventory Edit unit of measure finished
	 *                 jewelry -findings
	 * 
	 *                 End point for get finding of id
	 * 
	 * @param itemCode
	 * @return ResponseEntity<InventoryFindingsResponseDTO>
	 */
	@GetMapping("/inventory/findings/{mainItem}/{itemCode}")
	public ResponseEntity<InventoryFindingsResponseDTO> getFindings(@PathVariable String mainItem,
			@PathVariable String itemCode) throws Exception {

		InventoryFindingsResponseDTO findingsResponseDTO = inventoryService.getFindings(mainItem, itemCode);
		return ResponseEntity.ok(findingsResponseDTO);

	}

	/**
	 * @Author:Srijini AP-130 - > AP-238 Inventory Edit unit of measure finished
	 *                 jewelry -findings
	 * 
	 *                 End point for get available piece details of findings
	 * 
	 * @param itemCode
	 * 
	 * @param reqPiece
	 * @return ResponseEntity<InventoryFindingsResponseDTO>
	 */
	@GetMapping("/inventory/findings/{mainItem}/{itemCode}/{reqPiece}")
	public ResponseEntity<InventoryFindingsResponseDTO> getPricePerPiece(@PathVariable String mainItem,
			@PathVariable String itemCode, @PathVariable int reqPiece) throws Exception {

		InventoryFindingsResponseDTO findingsResponseDTO = inventoryService.getPricePerPiece(mainItem, itemCode,
				reqPiece);
		return ResponseEntity.ok(findingsResponseDTO);

	}

	/**
	 * @Author:Srijini AP-130 - > AP-239 Inventory Edit unit of measure finished
	 *                 jewelry - Stones
	 * 
	 *                 End point for list all finding of corresponding item
	 * 
	 * @param itemCode
	 * @return ResponseEntity<List<CustomManfStoneResponseDTO>>
	 */
	@GetMapping("/inventory/stone/{itemCode}")
	public ResponseEntity<List<CustomManfStoneResponseDTO>> getItemStones(@PathVariable String itemCode)
			throws Exception {

		List<CustomManfStoneResponseDTO> findingsResponseDTO = inventoryService.getItemStones(itemCode);
		return ResponseEntity.ok(findingsResponseDTO);

	}

	/**
	 * @Author:Srijini This REST endpoint for saving findings of item
	 * @param
	 * @return ResponseEntity<List<InventoryFindingsResponseDTO>>
	 */
	@PostMapping("/inventory/savefindings")
	public ResponseEntity<List<InventoryFindingsResponseDTO>> saveFindings(
			@RequestBody List<InventoryFindingsRequestDTO> invReqDTO) throws Exception {

		List<InventoryFindingsResponseDTO> responseDTO = inventoryService.saveFindings(invReqDTO);
		return ResponseEntity.ok(responseDTO);

	}

	/**
	 * @Author: Amal This REST endpoint exposes the ajax call for getting material
	 *          price and weight by karat
	 * @param
	 * @return ResponseEntity<Inventory1ResponseDTO>
	 */

	@GetMapping("/inventory/getweightnpricebykarat")
	public ResponseEntity<Inventory1ResponseDTO> getMatPricenWieght(@RequestBody Inventory1RequestDTO invReqDTO)
			throws Exception {

		Inventory1ResponseDTO inv1ResDTO = inventoryService.getPriceandWeightfromKarat(invReqDTO);
		return ResponseEntity.ok(inv1ResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the ajax call for getting material
	 *          price by weight
	 * @param
	 * @return ResponseEntity<Inventory1ResponseDTO>
	 */

	@GetMapping("/inventory/getpricebyweight")
	public ResponseEntity<Inventory1ResponseDTO> getPriceByWeight(@RequestBody Inventory1RequestDTO invReqDTO)
			throws Exception {

		Inventory1ResponseDTO inv1ResDTO = inventoryService.getPricefromWeight(invReqDTO);
		return ResponseEntity.ok(inv1ResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the ajax call for getting material
	 *          price by weight
	 * @param
	 * @return ResponseEntity<Inventory1ResponseDTO>
	 */

	@GetMapping("/inventory/getpricebyitemcost")
	public ResponseEntity<Inventory1ResponseDTO> getPriceByItemCost(@RequestBody Inventory1RequestDTO invReqDTO)
			throws Exception {

		Inventory1ResponseDTO inv1ResDTO = inventoryService.getPricefromItemCost(invReqDTO);
		return ResponseEntity.ok(inv1ResDTO);
	}

	@GetMapping("/inventory/getpricebysalesprice")
	public ResponseEntity<Inventory1ResponseDTO> getPriceBySalesPrice(@RequestBody Inventory1RequestDTO invReqDTO)
			throws Exception {

		Inventory1ResponseDTO inv1ResDTO = inventoryService.getPricefromSalesPrice(invReqDTO);
		return ResponseEntity.ok(inv1ResDTO);
	}

	@PutMapping("/inventory/updateprice")
	public ResponseEntity<Inventory1ResponseDTO> saveInventoryPrice(@RequestBody Inventory1RequestDTO invReqDTO)
			throws Exception {

		Inventory1ResponseDTO inv1ResDTO = inventoryService.saveInvetoryPrice(invReqDTO);
		return ResponseEntity.ok(inv1ResDTO);
	}

	@GetMapping("/inventory/getpricehostory/{itemCode}")
	public ResponseEntity<List<InventoryPriceHistory>> getInventoryPriceHistory(@PathVariable String itemCode)
			throws Exception {

		List<InventoryPriceHistory> priceHistoryList = inventoryService.getAllPriceHistoryofItem(itemCode);
		return ResponseEntity.ok(priceHistoryList);
	}
	
	


	/**
	 * @author naveen AP 139-AP240 Sales order search Method for Simple search
	 * 
	 * @param PointSaleOrderDataRequestDTO
	 * @return List<PointSaleOrderDataReponseDTO>
	 * @throws Exception
	 */
	@GetMapping("/search")
	public ResponseEntity<List<Inventory1ResponseDTO>> salesOrderSearch(
			@RequestBody Inventory1RequestDTO orderDataRequestDTO,@RequestParam int page,
			@RequestParam int size) throws Exception {

		List<Inventory1ResponseDTO> orderDataList = inventoryService
				.inventoryOrderSearch(orderDataRequestDTO,page,size);

		/*
		 * List<PointSaleOrderDataReponseDTO> orderDataList =
		 * salesOrderService.salesOrderSearch(orderDataRequestDTO, page, size);
		 */
		return ResponseEntity.ok(orderDataList);
	}
	
	
	
	
	
	

}
