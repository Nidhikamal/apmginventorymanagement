package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CodesColor;
import com.bourntec.apmg.entity.CodesMaterial;
import com.bourntec.apmg.entity.CollectionKeyword;
import com.bourntec.apmg.entity.CountrySetup;
import com.bourntec.apmg.entity.InvUnitCharge;
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
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InvUnitChargeRequestDTO;
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
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvUnitChargeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.Inventory1ResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryFindingsResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryRankResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.LockingTypeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TypeDataResponseDTO;

public interface InventoryService {

	LockingTypeResponseDTO findLockingTypesById(Long lockingTypeId);

	List<LockingTypeResponseDTO> findAllLockingTypes();

	LockingTypeResponseDTO saveLockingTypes(LockingTypeRequestDTO lockingTypesRequestDTO);

	CodesShapeResponseDTO saveCodeShape(CodesShapeRequestDTO codeShapeRequestDTO);

	CodesShapeResponseDTO findShapecodeById(String shapeId);

	List<CodesShapeResponseDTO> findAllShapeId();

	AdditionalOrderDataResponseDTO saveSizeMaintainence(AdditionalOrderDataRequestDTO addtionalOrderDataRequestDTO);

	AdditionalOrderDataResponseDTO findSizeMainatinenceById(String additionalDataValue);

	List<AdditionalOrderDataResponseDTO> findAllSizeMainatinence();

	CodesCountryResponseDTO savecodeCountry(CodesCountryRequestDTO codesCountryRequestDTO);

	CodesCountryResponseDTO findcodeCountryById(String countryCode);

	List<CodesCountryResponseDTO> findAllCodesCountry();

	CodeClarityResponseDTO savecodeClarity(CodeClarityRequestDTO codesCountryRequestDTO);

	CodeClarityResponseDTO findCodeClarityById(String clarityId);

	List<CodeClarityResponseDTO> findAllCodeClarity();

	CodeClaspResponsetDTO savecodeClasp(CodeClaspRequestDTO codeClaspRequestDTO);

	CodeClaspResponsetDTO findByclaspId(String claspId);

	List<CodeClaspResponsetDTO> findAllodeClasp();

	CodesSettingResponseDTO savecodeSetting(CodesSettingRequestDTO codeSettingRequestDTO);

	CodesSettingResponseDTO findBycodeSetting(String settingId);

	List<CodesSettingResponseDTO> findAllCodeSettings();

	LockingTypeResponseDTO updateLockingType(Long id, LockingTypeRequestDTO lockingTypeRequestDTO);

	CodesShapeResponseDTO updateShapeMaintainance(String shapeId, CodesShapeRequestDTO codeShapeRequestDTO);

	AdditionalOrderDataResponseDTO updateSizeMaintainence(String additionalDataValue,
			AdditionalOrderDataRequestDTO addtionalOrderDataRequestDTO);

	CodesCountryResponseDTO updateStoneOrigin(String countryCode, CodesCountryRequestDTO codesCountryResponsetDTO);

	CodesColorResponseDTO findColorCodesById(String id);

	List<CodesColor> findAllColorCodes();

	CodesColorResponseDTO updateColorCodesById(String id, CodesColorRequestDTO codesColorReqDTO);

	CodesColorResponseDTO saveColorCodes(CodesColorRequestDTO codesColorReqDTO);

	CodesMaterialResponseDTO findMaterialCodesById(String id);

	List<CodesMaterial> findAllMaterialCodes();

	CodesMaterialResponseDTO updateMaterialCodesById(String id, CodesMaterailRequestDTO codesMaterialReqDTO);

	CodesMaterialResponseDTO saveMaterialCodes(CodesMaterailRequestDTO codesMaterialReqDTO);

	InvUnitChargeResponseDTO findInvUnitChargeById(String id);

	List<InvUnitCharge> findAllInvUnitCharge();

	InvUnitChargeResponseDTO updateInvUnitChargeById(String id, InvUnitChargeRequestDTO InvUnitChargeReqDTO);

	InvUnitChargeResponseDTO saveInvUnitCharge(InvUnitChargeRequestDTO invUnitChargeReqDTO);

	CollectionKeywordResponseDTO findCollectionKeywordById(String id);

	List<CollectionKeyword> findAllCollectionKeywords();

	CollectionKeywordResponseDTO updateCollectionKeywordsById(String id, CollectionKeywordRequestDTO keywordReqDTO);

	CollectionKeywordResponseDTO saveCollectionKeywords(CollectionKeywordRequestDTO keywordReqDTO);

	CountrySetupResponseDTO findCountrySetupById(String id);

	List<CountrySetup> findCountrySetup();

	CountrySetupResponseDTO updateCountrySetupById(String id, CountrySetupRequestDTO countrySetupReqDTO);

	CountrySetupResponseDTO saveCountrySetup(CountrySetupRequestDTO countrySetupReqDTO);

	InvCategoryResponseDTO findInvCategoryById(String id);

	List<InventoryCategory> findAllInvCategories();

	InvCategoryResponseDTO updateInvCategoryById(String id, InventoryCategoryRequestDTO invCatReqDTO);

	InvCategoryResponseDTO saveInvCategories(InventoryCategoryRequestDTO invCatReqDTO);

	InventoryRankResponseDTO findInvRankById(String id);

	List<InventoryRank> findAllInvRanks();

	InventoryRankResponseDTO updateInvRankById(String id, InventoryRankRequestDTO invRankReqDTO);

	InventoryRankResponseDTO saveInvRanks(InventoryRankRequestDTO invRankReqDTO);

	TypeDataResponseDTO findTypeDataById(String id);

	List<TypeData> findAllTypeDatas();

	TypeDataResponseDTO updateTypeDataById(String id, TypeDataRequestDTO typeDataReqDTO);

	TypeDataResponseDTO saveTypeData(TypeDataRequestDTO typeDataReqDTO);

	Inventory1ResponseDTO saveInvetoryData(Inventory1RequestDTO inv1ReqDTO);

	/*
	 * Inventory1ResponseDTO getByitemcode(String itemCode);
	 * 
	 * List<Inventory1> findByCondition(Inventory1RequestDTO invReqDTO);
	 */

	CodeClarityResponseDTO updateclaritymaintainance(String clarityId, CodeClarityRequestDTO codeClarityRequestDTO);

	CodeClaspResponsetDTO updatecodeclasp(String claspId, CodeClaspRequestDTO codeClaspRequestDTO);

	CodesSettingResponseDTO updatecodeSetting(String settingId, CodesSettingRequestDTO codeSettingRequestDTO);

	List<InventoryFindingsResponseDTO> getItemFindings(String itemCode) throws Exception;

	InventoryFindingsResponseDTO getFindings(String mainItem, String finding) throws Exception;

	InventoryFindingsResponseDTO getPricePerPiece(String mainItem, String itemCode, int reqPiece) throws Exception;

	List<InventoryFindingsResponseDTO> saveFindings(List<InventoryFindingsRequestDTO> invReqDTO) throws Exception;

    Inventory1ResponseDTO getPriceandWeightfromKarat(Inventory1RequestDTO invReqDTO);
	
	Inventory1ResponseDTO getPricefromWeight(Inventory1RequestDTO invReqDTO);
	
	Inventory1ResponseDTO getPricefromItemCost(Inventory1RequestDTO invReqDTO);
	
	Inventory1ResponseDTO getPricefromSalesPrice(Inventory1RequestDTO invReqDTO);
	
	Inventory1ResponseDTO saveInvetoryPrice(Inventory1RequestDTO invReqDTO);
	
	List<InventoryPriceHistory> getAllPriceHistoryofItem(String itemCode);

	List<CustomManfStoneResponseDTO> getItemStones(String itemCode) throws Exception;

	List<Inventory1ResponseDTO> inventoryOrderSearch(Inventory1RequestDTO orderDataRequestDTO, int page, int size);
	
	
	


}
