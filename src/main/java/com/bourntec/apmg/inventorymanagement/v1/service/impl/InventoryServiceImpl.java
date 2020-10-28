package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bourntec.apmg.entity.AdditionalOrderData;
import com.bourntec.apmg.entity.CodeClarity;
import com.bourntec.apmg.entity.CodeClasp;
import com.bourntec.apmg.entity.CodesColor;
import com.bourntec.apmg.entity.CodesCountry;
import com.bourntec.apmg.entity.CodesMaterial;
import com.bourntec.apmg.entity.CodesSetting;
import com.bourntec.apmg.entity.CodesShapes;
import com.bourntec.apmg.entity.CollectionKeyword;
import com.bourntec.apmg.entity.CountrySetup;
import com.bourntec.apmg.entity.InvUnitCharge;
import com.bourntec.apmg.entity.Inventory1;
import com.bourntec.apmg.entity.Inventory2;
import com.bourntec.apmg.entity.InventoryAlternate;
import com.bourntec.apmg.entity.InventoryCategory;
import com.bourntec.apmg.entity.InventoryFindings;
import com.bourntec.apmg.entity.InventoryMaterialsUsed;
import com.bourntec.apmg.entity.InventoryPriceHistory;
import com.bourntec.apmg.entity.InventoryRank;
import com.bourntec.apmg.entity.InventoryStockHistory;
import com.bourntec.apmg.entity.LibraryItem;
import com.bourntec.apmg.entity.LockingType;
import com.bourntec.apmg.entity.ProductKeywords;
import com.bourntec.apmg.entity.TypeData;
import com.bourntec.apmg.entity.VendorItemMatch;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.AdditionalOrderDataRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodeClarityRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodeClaspRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesColorRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesCountryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesMaterailRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesSettingRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesShapeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CollectionKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CountrySetupRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InvUnitChargeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.Inventory1RequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryAlternateRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryCategoryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryFindingsRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryMaterialsRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryRankRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.LibraryItemRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.LockingTypeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.ProductKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.TypeDataRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.VendorItemMatchRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.AdditionalOrderDataResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodeClarityResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodeClaspResponsetDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesColorResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesCountryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesMaterialResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesSettingResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesShapeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CollectionKeywordResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CountrySetupResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CustomManfStoneResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvCategoryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvUnitChargeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.Inventory1ResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryAlternateResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryFindingsResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryRankResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.LibraryItemResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.LockingTypeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.ProductKeywordsResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TypeDataResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.VendorItemMatchResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.repository.AdditionalOrderDataRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.CodeClarityRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.CodeClaspRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.CodesColorRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.CodesCountryRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.CodesMaterailRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.CodesSettingRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.CodesShapeRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.CollectionKeywordRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.CollectionSubKeywordRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.CountrySetupRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.CustomManfStoneRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.ImageItemRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.InvUnitChargeRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.Inventory1Repository;
import com.bourntec.apmg.inventorymanagement.v1.repository.Inventory2Repository;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryAlternateRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryCategoryRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryFindingsRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryMaterialsUsedRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryPriceHistoryRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryRankRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryStockHistoryRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.LockingTypeRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.ProductKeywordsRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.TypeDataRepository;
import com.bourntec.apmg.inventorymanagement.v1.repository.VendorItemMatchRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.ImageUplodeOption;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryService;
import com.bourntec.apmg.inventorymanagement.v1.utils.DBConstant;
import com.bourntec.apmg.inventorymanagement.v1.utils.DateUtils;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for inventory
 * 
 * @author Naveen Radakrishnan
 *
 */
@Deprecated
@Service(value = "InventoryServiceImpl")
public class InventoryServiceImpl implements InventoryService {

	private static final Logger logger = LogManager.getLogger(InventoryServiceImpl.class);

	@Autowired
	private LockingTypeRepository lockingTypeRepository;

	@Autowired

	private CodesShapeRepository codeShapeRepository;
	@Autowired

	private AdditionalOrderDataRepository additionalOrderDataRepository;
	@Autowired

	private CodesCountryRepository codesCountryRepository;
	@Autowired

	private CodeClarityRepository codeClarityRepository;
	@Autowired

	private CodeClaspRepository codeClaspRepository;
	@Autowired

	private CodesSettingRepository codeSettingRepository;

	@Autowired
	CodesColorRepository codesColorRepo;

	@Autowired
	CodesMaterailRepository codesMaterialRepo;

	@Autowired
	InvUnitChargeRepository invUnitChargeRepo;

	@Autowired
	CollectionKeywordRepository collectionKeywordRepo;

	@Autowired
	CollectionSubKeywordRepository collectionSubKeywordRepo;

	@Autowired
	CountrySetupRepository countrySetupRepo;

	@Autowired
	InventoryCategoryRepository invCatRepo;

	@Autowired
	InventoryRankRepository invRankRepo;

	@Autowired
	TypeDataRepository typeDataRepo;

	@Autowired
	Inventory1Repository inventoryRepo;

	@Autowired
	Inventory2Repository inventory2Repo;

	@Autowired
	InventoryMaterialsUsedRepository invMatRepo;

	@Autowired
	InventoryFindingsRepository inventoryFindingsRepository;

	@Autowired
	InventoryStockHistoryRepository invstockHistoryRepo;

	@Autowired
	InventoryPriceHistoryRepository invPriceRepo;

	@Autowired
	VendorItemMatchRepository vendorItemMatchRepository;

	@Autowired
	ProductKeywordsRepository productKeywordsRepository;

	@Autowired
	InventoryAlternateRepository inventoryAlternateRepository;
	
	@Autowired
	ImageItemRepository imageItemRepository;
	
	@Autowired
	ImageUplodeOption imageUplodeOption;
	
	@Autowired
	CustomManfStoneRepository customManfStoneRepository;

	/**
	 * @author naveen This is the main method which is used to save Locking codes
	 */

	@Override
	public LockingTypeResponseDTO saveLockingTypes(LockingTypeRequestDTO lockingTypesRequestDTO) {
		LockingTypeResponseDTO lockingTypeResponseDTO = new LockingTypeResponseDTO();
		try {
			LockingType lockingType = lockingTypesRequestDTO.toModel(lockingTypesRequestDTO);
			LockingType lockingTypeObject = lockingTypeRepository.save(lockingType);
			logger.info(" LockingType Data saved successfully");
			BeanUtils.copyProperties(lockingTypeObject, lockingTypeResponseDTO);

		} catch (Exception e) {
			logger.error("Save: LockingType " + e);
			throw e;
		}
		return lockingTypeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to update LockingType
	 *         codes
	 */

	@Override
	public LockingTypeResponseDTO updateLockingType(Long id, LockingTypeRequestDTO lockingTypeRequestDTO) {
		Optional<LockingType> lockingType = lockingTypeRepository.findById(id);
		LockingTypeResponseDTO lockingTypeResponseDTO = new LockingTypeResponseDTO();

		try {
			if (lockingType == null) {
				logger.info("The LockingType doesn't exists!!!");
				lockingTypeResponseDTO.setResponseMessage("The LockingType doesn't exists");
			} else {

				LockingType labourCharges = lockingTypeRequestDTO.toModel(lockingTypeRequestDTO);

				labourCharges.setId(id);
				LockingType labour = lockingTypeRepository.save(labourCharges);
				logger.info("LockingType Details is updated");

				BeanUtils.copyProperties(labour, lockingTypeResponseDTO);
				lockingTypeResponseDTO.setResponseMessage("LockingType is updated in DB");
			}
		} catch (Exception e) {
			logger.error("update: LockingType " + e);

			throw e;
		}
		return lockingTypeResponseDTO;
	}

	/**
	 * This method findLockingTypesById
	 * 
	 * @param lockingTypeId
	 * @return LockingTypeResponseDTO
	 * @throws Exception
	 */

	@Override
	public LockingTypeResponseDTO findLockingTypesById(Long lockingTypeId) {
		LockingTypeResponseDTO lockingTypeResponseDTO = new LockingTypeResponseDTO();

		try {
			Optional<LockingType> lockTopye = lockingTypeRepository.findById(lockingTypeId);
			BeanUtils.copyProperties(lockTopye.get(), lockingTypeResponseDTO);
		} catch (Exception e) {
			logger.error(" lockingTypeId failed" + e);
			throw e;
		}
		return lockingTypeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to get al
	 *         LockingTypeDetais
	 */

	@Override
	public List<LockingTypeResponseDTO> findAllLockingTypes() {

		List<LockingTypeResponseDTO> lockResponseDTOs = new ArrayList<LockingTypeResponseDTO>();
		try {
			List<LockingType> lockTypeList = lockingTypeRepository.findAll();
			for (LockingType lockType : lockTypeList) {
				LockingTypeResponseDTO lockResponseDTO = new LockingTypeResponseDTO();
				BeanUtils.copyProperties(lockType, lockResponseDTO);
				lockResponseDTOs.add(lockResponseDTO);

			}
		} catch (Exception e) {
			logger.error(" findAllLockingTypes failed" + e);

			throw e;
		}
		return lockResponseDTOs;

	}

	/**
	 * @author naveen This is the main method which is used to save CodeShape
	 */
	@Override
	public CodesShapeResponseDTO saveCodeShape(CodesShapeRequestDTO codeShapeRequestDTO) {
		CodesShapeResponseDTO codeShapeResponseDTO = new CodesShapeResponseDTO();
		try {
			CodesShapes codeShapes = codeShapeRequestDTO.toModel(codeShapeRequestDTO);
			CodesShapes lockingTypeObject = codeShapeRepository.save(codeShapes);
			logger.info(" CodeShape Data saved successfully");

			BeanUtils.copyProperties(lockingTypeObject, codeShapeResponseDTO);

		} catch (Exception e) {
			logger.error("Save: CodeShape " + e);
			throw e;
		}
		return codeShapeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to update CodeShape
	 */
	@Override
	public CodesShapeResponseDTO updateShapeMaintainance(String shapeId, CodesShapeRequestDTO codeShapeRequestDTO) {
		Optional<CodesShapes> codeShapes = codeShapeRepository.findById(shapeId);
		CodesShapeResponseDTO codeShapeResponseDTO = new CodesShapeResponseDTO();

		try {
			if (codeShapes == null) {
				logger.info("The CodeShapes doesn't exists!!!");
				codeShapeResponseDTO.setResponseMessage("The CodeShapes doesn't exists");
			} else {

				CodesShapes codeShapeDTOS = codeShapeRequestDTO.toModel(codeShapeRequestDTO);

				codeShapeDTOS.setShapeId(shapeId);
				;
				CodesShapes codeShapesEntity = codeShapeRepository.save(codeShapeDTOS);
				logger.info("CodeShapes Details is updated");

				BeanUtils.copyProperties(codeShapesEntity, codeShapeResponseDTO);
				codeShapeResponseDTO.setResponseMessage("CodeShapes is updated in DB");
			}
		} catch (Exception e) {
			logger.error("update: CodeShape " + e);

			throw e;
		}
		return codeShapeResponseDTO;
	}

	/**
	 * This method findShapecodeById
	 * 
	 * @param shapeId
	 * @return CodeShapeResponseDTO
	 * @throws Exception
	 */
	@Override
	public CodesShapeResponseDTO findShapecodeById(String shapeId) {
		CodesShapeResponseDTO lockingTypeResponseDTO = new CodesShapeResponseDTO();
		try {
			Optional<CodesShapes> lockTopye = codeShapeRepository.findById(shapeId);
			BeanUtils.copyProperties(lockTopye.get(), lockingTypeResponseDTO);
		} catch (Exception e) {

			logger.error(" findShapecodeById failed" + e);

			throw e;
		}
		return lockingTypeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to get all
	 *         ShapeMaintainancedetails
	 */
	@Override
	public List<CodesShapeResponseDTO> findAllShapeId() {

		List<CodesShapeResponseDTO> lockResponseDTOs = new ArrayList<CodesShapeResponseDTO>();
		try {
			List<CodesShapes> lockTypeList = codeShapeRepository.findAll();
			for (CodesShapes lockType : lockTypeList) {
				CodesShapeResponseDTO lockResponseDTO = new CodesShapeResponseDTO();
				BeanUtils.copyProperties(lockType, lockResponseDTO);
				lockResponseDTOs.add(lockResponseDTO);

			}
		} catch (Exception e) {
			logger.error(" findAllShapeId failed" + e);

			throw e;
		}
		return lockResponseDTOs;

	}

	/**
	 * @author naveen This is the main method which is used to save SizeMaintainence
	 *         codes
	 */
	@Override
	public AdditionalOrderDataResponseDTO saveSizeMaintainence(
			AdditionalOrderDataRequestDTO addtionalOrderDataRequestDTO) {
		AdditionalOrderDataResponseDTO codeShapeResponseDTO = new AdditionalOrderDataResponseDTO();
		try {
			AdditionalOrderData addtionalOrderData = addtionalOrderDataRequestDTO.toModel(addtionalOrderDataRequestDTO);
			AdditionalOrderData lockingTypeObject = additionalOrderDataRepository.save(addtionalOrderData);
			logger.info("sizeMaintainance Details is updated");

			BeanUtils.copyProperties(lockingTypeObject, codeShapeResponseDTO);
		} catch (Exception e) {
			logger.error("Save: sizeMaintainance " + e);
			throw e;
		}
		return codeShapeResponseDTO;
	}

	/**
	 * This method findSizeMainatinenceById
	 * 
	 * @param addtionalOrderData
	 * @return AddtionalOrderDataResponsetDTO
	 * @throws Exception
	 */
	@Override
	public AdditionalOrderDataResponseDTO findSizeMainatinenceById(String addtionalOrderData) {
		AdditionalOrderDataResponseDTO lockingTypeResponseDTO = new AdditionalOrderDataResponseDTO();
		try {
			//Optional<AdditionalOrderData> lockTopye = additionalOrderDataRepository.findById(addtionalOrderData);
			//BeanUtils.copyProperties(lockTopye.get(), lockingTypeResponseDTO);
		} catch (Exception e) {
			logger.error("inventory control service findSizeMainatinenceById failed" + e);
			throw e;
		}
		return lockingTypeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to get all
	 *         ShapeMaintainancedetails
	 */

	@Override
	public List<AdditionalOrderDataResponseDTO> findAllSizeMainatinence() {

		List<AdditionalOrderDataResponseDTO> lockResponseDTOs = new ArrayList<AdditionalOrderDataResponseDTO>();
		try {
			List<AdditionalOrderData> lockTypeList = additionalOrderDataRepository.findAll();
			for (AdditionalOrderData lockType : lockTypeList) {
				AdditionalOrderDataResponseDTO lockResponseDTO = new AdditionalOrderDataResponseDTO();
				BeanUtils.copyProperties(lockType, lockResponseDTO);
				lockResponseDTOs.add(lockResponseDTO);

			}
		} catch (Exception e) {
			logger.error("inventory control service findAllSizeMainatinence failed" + e);

			throw e;
		}
		return lockResponseDTOs;

	}

	/**
	 * @author naveen This is the main method which is used to save codeCountry
	 *         codes
	 */
	@Override
	public CodesCountryResponseDTO savecodeCountry(CodesCountryRequestDTO codesCountryRequestDTO) {
		CodesCountryResponseDTO codesCountryResponsetDTO = new CodesCountryResponseDTO();
		try {
			CodesCountry codesCountry = codesCountryRequestDTO.toModel(codesCountryRequestDTO);
			CodesCountry codesCountryObject = codesCountryRepository.save(codesCountry);
			BeanUtils.copyProperties(codesCountryObject, codesCountryResponsetDTO);
		} catch (Exception e) {
			logger.error("Save: codeCountry " + e);
			throw e;
		}
		return codesCountryResponsetDTO;
	}

	/**
	 * @author naveen This is the main method which findcodeCountryById codes
	 */
	@Override
	public CodesCountryResponseDTO findcodeCountryById(String countryCode) {
		CodesCountryResponseDTO codesCountryResponsetDTO = new CodesCountryResponseDTO();
		try {
			Optional<CodesCountry> lockTopye = codesCountryRepository.findById(countryCode);
			BeanUtils.copyProperties(lockTopye.get(), codesCountryResponsetDTO);
		} catch (Exception e) {
			logger.error("inventory control service findPaymentTermsById failed" + e);
			throw e;
		}
		return codesCountryResponsetDTO;
	}

	/**
	 * @author naveen This is the main method which is used to findAllCodesCountry
	 *         codes
	 */
	@Override
	public List<CodesCountryResponseDTO> findAllCodesCountry() {

		List<CodesCountryResponseDTO> codesCountryResponsetDTOs = new ArrayList<CodesCountryResponseDTO>();
		try {
			List<CodesCountry> lockTypeList = codesCountryRepository.findAll();
			for (CodesCountry lockType : lockTypeList) {
				CodesCountryResponseDTO lockResponseDTO = new CodesCountryResponseDTO();
				BeanUtils.copyProperties(lockType, lockResponseDTO);
				codesCountryResponsetDTOs.add(lockResponseDTO);

			}
		} catch (Exception e) {
			logger.error("inventory control service findAllCodesCountry failed" + e);

			throw e;
		}
		return codesCountryResponsetDTOs;

	}

	/**
	 * @author naveen This is the main method which is used to save codes clarity
	 */
	@Override
	public CodeClarityResponseDTO savecodeClarity(CodeClarityRequestDTO codeClarityRequestDTO) {
		CodeClarityResponseDTO codeClarityResponseDTO = new CodeClarityResponseDTO();
		try {
			CodeClarity codesCountry = codeClarityRequestDTO.toModel(codeClarityRequestDTO);
			CodeClarity codesCountryObject = codeClarityRepository.save(codesCountry);
			logger.info(" codeClarity( Data saved successfully");

			BeanUtils.copyProperties(codesCountryObject, codeClarityResponseDTO);
		} catch (Exception e) {
			logger.error("Save: codeclarity " + e);
			throw e;
		}
		return codeClarityResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to update Type Data by
	 *         clarityId
	 */
	@Override
	public CodeClarityResponseDTO findCodeClarityById(String clarityId) {
		CodeClarityResponseDTO codeClarityResponseDTO = new CodeClarityResponseDTO();
		try {
			Optional<CodeClarity> lockTopye = codeClarityRepository.findById(clarityId);
			BeanUtils.copyProperties(lockTopye.get(), codeClarityResponseDTO);
		} catch (Exception e) {
			System.out.println("inventory control service findByclarityId failed" + e);
			throw e;
		}
		return codeClarityResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used findAllCodeClarity
	 */

	@Override
	public List<CodeClarityResponseDTO> findAllCodeClarity() {

		List<CodeClarityResponseDTO> codeClarityResponseDTO = new ArrayList<CodeClarityResponseDTO>();
		try {
			List<CodeClarity> lockTypeList = codeClarityRepository.findAll();
			for (CodeClarity lockType : lockTypeList) {
				CodeClarityResponseDTO lockResponseDTO = new CodeClarityResponseDTO();
				BeanUtils.copyProperties(lockType, lockResponseDTO);
				codeClarityResponseDTO.add(lockResponseDTO);

			}
		} catch (Exception e) {
			logger.error("inventory control service findAllCodeClarity failed" + e);

			throw e;
		}
		return codeClarityResponseDTO;

	}

	/**
	 * @author naveen This is the main method which is used to save codeclasp
	 */
	@Override
	public CodeClaspResponsetDTO savecodeClasp(CodeClaspRequestDTO codeClaspRequestDTO) {
		CodeClaspResponsetDTO codeClaspResponsetDTO = new CodeClaspResponsetDTO();
		try {
			CodeClasp codesCountry = codeClaspRequestDTO.toModel(codeClaspRequestDTO);
			CodeClasp codesCountryObject = codeClaspRepository.save(codesCountry);
			logger.info(" codeclasp( Data saved successfully");

			BeanUtils.copyProperties(codesCountryObject, codeClaspResponsetDTO);
		} catch (Exception e) {
			logger.error("Save: codeclasp " + e);
			throw e;
		}
		return codeClaspResponsetDTO;
	}

	/**
	 * @author naveen This is the main method which is used to update Type Data by
	 *         claspId
	 */
	@Override

	public CodeClaspResponsetDTO findByclaspId(String claspId) {
		CodeClaspResponsetDTO codeClarityResponseDTO = new CodeClaspResponsetDTO();
		try {
			Optional<CodeClasp> lockTopye = codeClaspRepository.findById(claspId);
			BeanUtils.copyProperties(lockTopye.get(), codeClarityResponseDTO);
		} catch (Exception e) {
			logger.error("inventory control service findByclarityId failed" + e);
			throw e;
		}
		return codeClarityResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used findAllodeClasp
	 */
	@Override

	public List<CodeClaspResponsetDTO> findAllodeClasp() {

		List<CodeClaspResponsetDTO> codeClaspResponsetDTO = new ArrayList<CodeClaspResponsetDTO>();
		try {
			List<CodeClasp> lockTypeList = codeClaspRepository.findAll();
			for (CodeClasp lockType : lockTypeList) {
				CodeClaspResponsetDTO lockResponseDTO = new CodeClaspResponsetDTO();
				BeanUtils.copyProperties(lockType, lockResponseDTO);
				codeClaspResponsetDTO.add(lockResponseDTO);

			}
		} catch (Exception e) {
			logger.error("inventory control service findAllodeClasp failed" + e);

			throw e;
		}
		return codeClaspResponsetDTO;

	}

	/**
	 * @author naveen This is the main method which is used to save codesetting
	 */
	@Override
	public CodesSettingResponseDTO savecodeSetting(CodesSettingRequestDTO codeSettingRequestDTO) {
		CodesSettingResponseDTO codeClaspResponsetDTO = new CodesSettingResponseDTO();
		try {
			CodesSetting codesCountry = codeSettingRequestDTO.toModel(codeSettingRequestDTO);
			CodesSetting codesCountryObject = codeSettingRepository.save(codesCountry);
			logger.info(" codesettings( Data saved successfully");

			BeanUtils.copyProperties(codesCountryObject, codeClaspResponsetDTO);
		} catch (Exception e) {
			logger.error("Save: codesetting " + e);
			throw e;
		}
		return codeClaspResponsetDTO;
	}

	/**
	 * @author naveen This is the main method which is used to update Type Data by
	 *         settingId
	 */
	@Override
	public CodesSettingResponseDTO findBycodeSetting(String settingId) {
		CodesSettingResponseDTO codeSettingResponseDTO = new CodesSettingResponseDTO();
		try {
			Optional<CodesSetting> lockTopye = codeSettingRepository.findById(settingId);
			BeanUtils.copyProperties(lockTopye.get(), codeSettingResponseDTO);
		} catch (Exception e) {
			logger.error("inventory control service findBycodeSetting failed" + e);
			throw e;
		}
		return codeSettingResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used findAllCodeSettings
	 */

	public List<CodesSettingResponseDTO> findAllCodeSettings() {

		List<CodesSettingResponseDTO> codeSettingResponseDTO = new ArrayList<CodesSettingResponseDTO>();
		try {
			List<CodesSetting> codeSettingList = codeSettingRepository.findAll();
			for (CodesSetting lockType : codeSettingList) {
				CodesSettingResponseDTO lockResponseDTO = new CodesSettingResponseDTO();
				BeanUtils.copyProperties(lockType, lockResponseDTO);
				codeSettingResponseDTO.add(lockResponseDTO);

			}
		} catch (Exception e) {
			logger.error("inventory control service findAllCodeSettings failed" + e);

			throw e;
		}
		return codeSettingResponseDTO;

	}

	/**
	 * @author naveen This is the main method which is used to update
	 *         SizeMaintainence data
	 */
	@Override
	public AdditionalOrderDataResponseDTO updateSizeMaintainence(String additionalDataValue,
			AdditionalOrderDataRequestDTO addtionalOrderDataRequestDTO) {
		//Optional<AdditionalOrderData> addtionalOrderData = additionalOrderDataRepository.findById(additionalDataValue);
		AdditionalOrderDataResponseDTO addtionalOrderDataResponsetDTO = new AdditionalOrderDataResponseDTO();
		Optional<AdditionalOrderData> addtionalOrderData = null;
		try {
			if (addtionalOrderData == null) {
				logger.info("The AddtionalOrderDatavalue doesn't exists!!!");
				addtionalOrderDataResponsetDTO.setResponseMessage("The AddtionalOrderData doesn't exists");
			} else {

				AdditionalOrderData addtionalOrderDataDTOS = addtionalOrderDataRequestDTO
						.toModel(addtionalOrderDataRequestDTO);

				addtionalOrderDataDTOS.setAdditionalDataValue(additionalDataValue);
				AdditionalOrderData addtionalOrderDataEntity = additionalOrderDataRepository
						.save(addtionalOrderDataDTOS);
				logger.info("AddtionalOrderData Details is updated");

				BeanUtils.copyProperties(addtionalOrderDataEntity, addtionalOrderDataResponsetDTO);
				addtionalOrderDataResponsetDTO.setResponseMessage("AddtionalOrderData is updated in DB");
			}
		} catch (Exception e) {
			logger.error("update: AddtionalOrderData " + e);

			throw e;
		}
		return addtionalOrderDataResponsetDTO;
	}

	/**
	 * @author naveen This is the main method which is used to update stoneOrigin
	 *         data
	 */
	@Override
	public CodesCountryResponseDTO updateStoneOrigin(String countryCode,
			CodesCountryRequestDTO codesCountryRequestDTO) {

		Optional<CodesCountry> codesCountryrep = codesCountryRepository.findById(countryCode);
		CodesCountryResponseDTO codesCountryResponse = new CodesCountryResponseDTO();

		try {
			if (codesCountryrep == null) {
				logger.info("The countryCode doesn't exists!!!");
				codesCountryResponse.setResponseMessage("The countryCode doesn't exists");
			} else {

				CodesCountry codesCountryModel = codesCountryRequestDTO.toModel(codesCountryRequestDTO);

				codesCountryModel.setCountryCode(countryCode);
				CodesCountry codesCountryEntity = codesCountryRepository.save(codesCountryModel);
				logger.info("codesCountryEntity Details is updated");

				BeanUtils.copyProperties(codesCountryEntity, codesCountryResponse);
				codesCountryResponse.setResponseMessage("codesCountryEntity is updated in DB");
			}
		} catch (Exception e) {
			logger.error("update: CodesCountry " + e);
			throw e;
		}
		return codesCountryResponse;
	}

	/**
	 * @author amal This is the main method which is used to find color codes by Id
	 */

	public CodesColorResponseDTO findColorCodesById(String id) {
		CodesColorResponseDTO colorCodesRespDTO = new CodesColorResponseDTO();
		try {
			Optional<CodesColor> colorCodesOptional = codesColorRepo.findById(id);
			if (colorCodesOptional.isPresent()) {
				CodesColor colorCodes = colorCodesOptional.get();
				BeanUtils.copyProperties(colorCodes, colorCodesRespDTO);
			} else {
				logger.error("Color code doesn't exist!!!");
				colorCodesRespDTO.setResponseMessage("Color code not found");
			}
		} catch (Exception e) {
			System.out.println("Fetch:findColorCodesById " + e);
			throw e;
		}

		return colorCodesRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all color codes
	 */

	public List<CodesColor> findAllColorCodes() {
		return codesColorRepo.findAll();
	}

	/**
	 * @author amal This is the main method which is used to update color codes
	 */
	public CodesColorResponseDTO updateColorCodesById(String id, CodesColorRequestDTO codesColorReqDTO) {
		CodesColorResponseDTO colorCodesRespDTO = new CodesColorResponseDTO();
		try {
			Optional<CodesColor> colorCodesOptional = codesColorRepo.findById(id);
			if (colorCodesOptional.isPresent()) {
				CodesColor colorCodes = codesColorReqDTO.toModel(codesColorReqDTO);
				colorCodes.setColorId(id);
				CodesColor colorCodesEntity = codesColorRepo.save(colorCodes);
				if (colorCodesEntity != null) {
					BeanUtils.copyProperties(colorCodesEntity, colorCodesRespDTO);
					logger.info("Color Code  updated successfully");
				} else {
					logger.error("Color Code  updation failed");
				}
			} else {
				logger.error("Color code doesn't exist!!!");
				colorCodesRespDTO.setResponseMessage("Color code doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update: updateColorCodesById" + e);
			throw e;
		}

		return colorCodesRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to save color codes
	 */

	public CodesColorResponseDTO saveColorCodes(CodesColorRequestDTO codesColorReqDTO) {
		CodesColorResponseDTO colorCodesRespDTO = new CodesColorResponseDTO();
		try {
			CodesColor colorCodes = codesColorReqDTO.toModel(codesColorReqDTO);
			CodesColor colorCodesEntity = codesColorRepo.save(colorCodes);
			if (colorCodesEntity != null) {
				BeanUtils.copyProperties(colorCodesEntity, colorCodesRespDTO);
				logger.info("Color Code  saved successfully");
			} else {
				logger.error("Failed to save color codes");
			}

		} catch (Exception e) {
			logger.error("Save: saveColorCodes" + e);
			throw e;
		}

		return colorCodesRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get material codes by
	 *         id
	 */
	public CodesMaterialResponseDTO findMaterialCodesById(String id) {
		CodesMaterialResponseDTO materialCodesRespDTO = new CodesMaterialResponseDTO();
		try {
			Optional<CodesMaterial> materialCodesOptional = codesMaterialRepo.findById(id);
			if (materialCodesOptional.isPresent()) {
				CodesMaterial materialCodes = materialCodesOptional.get();
				BeanUtils.copyProperties(materialCodes, materialCodesRespDTO);
			} else {
				logger.info(" Material code doesn't exist");
				materialCodesRespDTO.setResponseMessage("Material  not found");
			}
		} catch (Exception e) {
			logger.error("Fetch: findMaterialCodesById" + e);
			throw e;
		}

		return materialCodesRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all material codes
	 */

	public List<CodesMaterial> findAllMaterialCodes() {
		return codesMaterialRepo.findAll();
	}

	/**
	 * @author amal This is the main method which is used to get material codes by
	 *         id
	 */
	public CodesMaterialResponseDTO updateMaterialCodesById(String id, CodesMaterailRequestDTO codesMaterialReqDTO) {
		CodesMaterialResponseDTO materialCodesRespDTO = new CodesMaterialResponseDTO();
		try {
			Optional<CodesMaterial> materialCodesOptional = codesMaterialRepo.findById(id);
			if (materialCodesOptional.isPresent()) {
				CodesMaterial materialCodes = codesMaterialReqDTO.toModel(codesMaterialReqDTO);
				materialCodes.setMaterialId(id);
				CodesMaterial materialCodesEntity = codesMaterialRepo.save(materialCodes);
				if (materialCodesEntity != null) {
					BeanUtils.copyProperties(materialCodesEntity, materialCodesRespDTO);
					logger.info("Material Codes  updated successfully");
				} else {
					logger.error("Material Codes  updation failed");
				}

			} else {
				logger.info("Material code doesn't exist");
				materialCodesRespDTO.setResponseMessage("Update Failed");
			}
		} catch (Exception e) {
			logger.error("Update: updateMaterialCodesById" + e);
			throw e;
		}

		return materialCodesRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to save material codes
	 */
	public CodesMaterialResponseDTO saveMaterialCodes(CodesMaterailRequestDTO codesMaterialReqDTO) {
		CodesMaterialResponseDTO materialCodesRespDTO = new CodesMaterialResponseDTO();
		try {
			CodesMaterial materialCodes = codesMaterialReqDTO.toModel(codesMaterialReqDTO);
			CodesMaterial materialCodesEntity = codesMaterialRepo.save(materialCodes);
			if (materialCodesEntity != null) {
				BeanUtils.copyProperties(materialCodesEntity, materialCodesRespDTO);
				logger.info("Material Codes  saved successfully");
			} else {
				logger.error("Failed to save material codes");
			}
		} catch (Exception e) {
			logger.error("Save saveMaterialCodes " + e);
			throw e;
		}

		return materialCodesRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get Unit Charge by id
	 */
	public InvUnitChargeResponseDTO findInvUnitChargeById(String id) {
		InvUnitChargeResponseDTO invUnitChargeRespDTO = new InvUnitChargeResponseDTO();
		try {
			Optional<InvUnitCharge> colorCodesOptional = invUnitChargeRepo.findById(id);
			if (colorCodesOptional.isPresent()) {
				InvUnitCharge invUnitCharge = colorCodesOptional.get();
				BeanUtils.copyProperties(invUnitCharge, invUnitChargeRespDTO);
			} else {
				logger.error(" Unit Charge doesn't exist");
				invUnitChargeRespDTO.setResponseMessage("Unit Charge not found");
			}
		} catch (Exception e) {
			logger.error("Fetch: findInvUnitChargeById" + e);
			throw e;
		}

		return invUnitChargeRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all Unit Charge
	 */

	public List<InvUnitCharge> findAllInvUnitCharge() {
		return invUnitChargeRepo.findAll();
	}

	/**
	 * @author amal This is the main method which is used to update Unit Charge by
	 *         id
	 */

	public InvUnitChargeResponseDTO updateInvUnitChargeById(String id, InvUnitChargeRequestDTO InvUnitChargeReqDTO) {
		InvUnitChargeResponseDTO savedInvUnitChargeRespDTO = new InvUnitChargeResponseDTO();
		try {
			Optional<InvUnitCharge> invunitChargeOptional = invUnitChargeRepo.findById(id);
			if (invunitChargeOptional.isPresent()) {
				InvUnitCharge invUnitCharge = InvUnitChargeReqDTO.toModel(InvUnitChargeReqDTO);
				invUnitCharge.setUnitCharge(id);
				InvUnitCharge invUnitChargeEntity = invUnitChargeRepo.save(invUnitCharge);
				if (invUnitChargeEntity != null) {
					BeanUtils.copyProperties(invUnitChargeEntity, savedInvUnitChargeRespDTO);
					logger.info("Unit Charge  updated successfully");
				} else {
					logger.error("Unit Charge  updation failed");
				}
			} else {
				logger.error(" Unit Charge doesn't exist");
				savedInvUnitChargeRespDTO.setResponseMessage("Unit Charge doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update: updateInvUnitChargeById " + e);
			throw e;
		}

		return savedInvUnitChargeRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to save Unit Charge by id
	 */

	public InvUnitChargeResponseDTO saveInvUnitCharge(InvUnitChargeRequestDTO invUnitChargeReqDTO) {
		InvUnitChargeResponseDTO invUnitChargeRespDTO = new InvUnitChargeResponseDTO();
		try {
			InvUnitCharge invUnit = invUnitChargeReqDTO.toModel(invUnitChargeReqDTO);
			InvUnitCharge invUnitEntity = invUnitChargeRepo.save(invUnit);
			if (invUnitEntity != null) {
				BeanUtils.copyProperties(invUnitEntity, invUnitChargeRespDTO);
				logger.info("Unit Charge  saved successfully");
			} else {
				logger.error("Failed to save Unit Charge");
			}
		} catch (Exception e) {
			logger.error("Save: saveInvUnitCharge " + e);
			throw e;
		}

		return invUnitChargeRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get Collection keyword
	 *         by id
	 */
	public CollectionKeywordResponseDTO findCollectionKeywordById(String id) {
		CollectionKeywordResponseDTO collectionKeywrdDTO = new CollectionKeywordResponseDTO();
		try {
			Optional<CollectionKeyword> keywrdsOptional = collectionKeywordRepo.findById(id);
			if (keywrdsOptional.isPresent()) {
				CollectionKeyword countrySetup = keywrdsOptional.get();

				BeanUtils.copyProperties(countrySetup, collectionKeywrdDTO);
			} else {
				logger.error(" Collection Keyword doesn't exist");
				collectionKeywrdDTO.setResponseMessage("Collection keyword not found");
			}
		} catch (Exception e) {
			logger.error("Fetch: findCollectionKeywordById " + e);
			throw e;
		}

		return collectionKeywrdDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all Collection
	 *         keywords
	 */

	public List<CollectionKeyword> findAllCollectionKeywords() {
		return collectionKeywordRepo.findAll();
	}

	/**
	 * @author amal This is the main method which is used to update Collection
	 *         keywords by id
	 */

	public CollectionKeywordResponseDTO updateCollectionKeywordsById(String id,
			CollectionKeywordRequestDTO keywordReqDTO) {
		CollectionKeywordResponseDTO savedKeyWrdespDTO = new CollectionKeywordResponseDTO();
		try {
			Optional<CollectionKeyword> keyWrdEntityOptional = collectionKeywordRepo.findById(id);
			if (keyWrdEntityOptional.isPresent()) {
				CollectionKeyword keyWrd = keywordReqDTO.toModel(keywordReqDTO);
				keyWrd.setKeyId(id);
				CollectionKeyword keyWrdEntity = collectionKeywordRepo.save(keyWrd);
				if (keyWrdEntity != null) {
					// Update subKey words
					/*
					 * List<CollectionSubKeyword> subKeywordList = keywordReqDTO.getSubKeyword(); if
					 * (subKeywordList != null && subKeywordList.size() > 0) {
					 * subKeywordList.forEach((subkeywordobj) -> {
					 * subkeywordobj.setCollectionKeyword(keyWrd); CollectionSubKeyword subkeyWord =
					 * collectionSubKeywordRepo.save(subkeywordobj);
					 * 
					 * }); }
					 */
					BeanUtils.copyProperties(keyWrdEntity, savedKeyWrdespDTO);
					logger.info(" Collection keyword updated successfully");
				} else {
					logger.error(" Collection keyword updation failed");
				}
			} else {
				logger.info(" Collection keyword doesn't exist");
				savedKeyWrdespDTO.setResponseMessage("Update Failed");
			}
		} catch (Exception e) {
			logger.error("Update: updateCollectionKeywordsById " + e);
			throw e;
		}

		return savedKeyWrdespDTO;
	}

	/**
	 * @author amal This is the main method which is used to save Collection
	 *         keywords
	 */

	public CollectionKeywordResponseDTO saveCollectionKeywords(CollectionKeywordRequestDTO keywordReqDTO) {
		CollectionKeywordResponseDTO collectionKeywrdDTO = new CollectionKeywordResponseDTO();
		try {
			CollectionKeyword keyword = keywordReqDTO.toModel(keywordReqDTO);
			CollectionKeyword keywordEntity = collectionKeywordRepo.save(keyword);
			// Saving subKey words
			if (keywordEntity != null) {
				/*
				 * List<CollectionSubKeyword> subKeywordList = keywordReqDTO.getSubKeyword(); if
				 * (subKeywordList != null && subKeywordList.size() > 0) {
				 * 
				 * subKeywordList.forEach((subkeywordobj) -> {
				 * subkeywordobj.setCollectionKeyword(keyword);
				 * 
				 * CollectionSubKeyword subkeyWord =
				 * collectionSubKeywordRepo.save(subkeywordobj);
				 * 
				 * });
				 * 
				 * }
				 */

				BeanUtils.copyProperties(keywordEntity, collectionKeywrdDTO);
				logger.info(" Collection keyword saved successfully");
			} else {
				logger.error(" Failed to save Collection keywords");
			}
		} catch (Exception e) {
			logger.error("Save: saveCollectionKeywords" + e);
			throw e;
		}

		return collectionKeywrdDTO;
	}

	/**
	 * @author amal This is the main method which is used to get Country Setup by
	 *         country code
	 */

	public CountrySetupResponseDTO findCountrySetupById(String id) {
		CountrySetupResponseDTO countryRespDTO = new CountrySetupResponseDTO();
		try {
			Optional<CountrySetup> colorCodesOptional = countrySetupRepo.findById(id);
			if (colorCodesOptional.isPresent()) {
				CountrySetup countrySetup = colorCodesOptional.get();
				BeanUtils.copyProperties(countrySetup, countryRespDTO);
			} else {
				logger.error(" Country Setup doesn't exist");
				countryRespDTO.setResponseMessage("Country Setup not found");
			}
		} catch (Exception e) {
			logger.error("Fetch: findCountrySetupById " + e);
			throw e;
		}

		return countryRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all Country Setups
	 */

	public List<CountrySetup> findCountrySetup() {
		return countrySetupRepo.findAll();
	}

	/**
	 * @author amal This is the main method which is used to update Country Setups
	 */
	public CountrySetupResponseDTO updateCountrySetupById(String countryCode,
			CountrySetupRequestDTO countrySetupReqDTO) {
		CountrySetupResponseDTO countrySetupRespDTO = new CountrySetupResponseDTO();
		try {
			Optional<CountrySetup> invunitChargeOptional = countrySetupRepo.findById(countryCode);
			if (invunitChargeOptional.isPresent()) {
				CountrySetup countrySetup = countrySetupReqDTO.toModel(countrySetupReqDTO);
				countrySetup.setCountryCode(countryCode);
				CountrySetup countrySetupEntity = countrySetupRepo.save(countrySetup);
				if (countrySetupEntity != null) {
					BeanUtils.copyProperties(countrySetupEntity, countrySetupRespDTO);
					logger.info(" Country Setup updated successfully");
				} else {
					logger.error(" Country Setup updation failed");
				}
			} else {
				logger.error(" Country Setup doesn't exist");
				countrySetupRespDTO.setResponseMessage("Country Setup doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update: updateCountrySetupById " + e);
			throw e;
		}

		return countrySetupRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to save Country Setups
	 */

	public CountrySetupResponseDTO saveCountrySetup(CountrySetupRequestDTO countrySetupReqDTO) {
		CountrySetupResponseDTO countryRespDTO = new CountrySetupResponseDTO();
		try {
			CountrySetup countrySetup = countrySetupReqDTO.toModel(countrySetupReqDTO);
			CountrySetup countrySetupEntity = countrySetupRepo.save(countrySetup);
			if (countrySetupEntity != null) {
				BeanUtils.copyProperties(countrySetupEntity, countryRespDTO);
				logger.info(" Country Setup saved successfully");
			} else {
				logger.error("Failed to save country setup");
			}
		} catch (Exception e) {
			logger.error("Save: saveCountrySetup " + e);
			throw e;
		}

		return countryRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get Inventory Category
	 *         by id
	 */

	public InvCategoryResponseDTO findInvCategoryById(String id) {
		InvCategoryResponseDTO invCategoryRespDTO = new InvCategoryResponseDTO();
		try {
			Optional<InventoryCategory> invCatOptional = invCatRepo.findById(id);
			if (invCatOptional.isPresent()) {
				InventoryCategory invCatCharge = invCatOptional.get();
				BeanUtils.copyProperties(invCatCharge, invCategoryRespDTO);
			} else {
				logger.info(" Inventory Category doesn't exist");
				invCategoryRespDTO.setResponseMessage("Inventory Category not found");
			}
		} catch (Exception e) {
			logger.error("Fetch Inventory Category " + e);
			throw e;
		}

		return invCategoryRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all Inventory
	 *         Categories
	 */
	public List<InventoryCategory> findAllInvCategories() {
		return invCatRepo.findAll();
	}

	/**
	 * @author amal This is the main method which is used to update Inventory
	 *         Categories
	 */
	public InvCategoryResponseDTO updateInvCategoryById(String category, InventoryCategoryRequestDTO invCatReqDTO) {
		InvCategoryResponseDTO invCatRespDTO = new InvCategoryResponseDTO();
		try {
			Optional<InventoryCategory> invCatOptional = invCatRepo.findById(category);
			if (invCatOptional.isPresent()) {
				InventoryCategory invCat = invCatReqDTO.toModel(invCatReqDTO);
				invCat.setCategory(category);
				InventoryCategory invcategoryupEntity = invCatRepo.save(invCat);
				if (invcategoryupEntity != null) {
					BeanUtils.copyProperties(invcategoryupEntity, invCatRespDTO);
					logger.info(" Inventory Category updated successfully");
				} else {
					logger.error(" Inventory Category updation failed");
				}
			} else {
				logger.error(" Inventory Category doesn't exist");
				invCatRespDTO.setResponseMessage(" Inventory Category doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update: updateInvCategoryById " + e);
			throw e;
		}

		return invCatRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to save Inventory
	 *         Categories
	 */

	public InvCategoryResponseDTO saveInvCategories(InventoryCategoryRequestDTO invCatReqDTO) {
		InvCategoryResponseDTO invCatRespDTO = new InvCategoryResponseDTO();
		try {
			InventoryCategory invCat = invCatReqDTO.toModel(invCatReqDTO);
			InventoryCategory invCatEntity = invCatRepo.save(invCat);
			if (invCatEntity != null) {
				BeanUtils.copyProperties(invCatEntity, invCatRespDTO);
				logger.info(" Inventory Category saved successfully");
			} else {
				logger.error(" Failed to save Inventory Category ");
			}
		} catch (Exception e) {
			logger.error("Save: saveInvCategories " + e);
			throw e;
		}

		return invCatRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get Inventory Rank by
	 *         id
	 */

	public InventoryRankResponseDTO findInvRankById(String id) {
		InventoryRankResponseDTO invRankRespDTO = new InventoryRankResponseDTO();
		try {
			Optional<InventoryRank> invRankOptional = invRankRepo.findById(id);
			if (invRankOptional.isPresent()) {
				InventoryRank invRankCharge = invRankOptional.get();
				BeanUtils.copyProperties(invRankCharge, invRankRespDTO);
			} else {
				logger.error(" Inventory Rank doesn't exist");
				invRankRespDTO.setResponseMessage("Inventory Rank not found");
			}
		} catch (Exception e) {
			logger.error("Fetch Inventory Rank " + e);
			throw e;
		}

		return invRankRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all Inventory Ranks
	 */
	public List<InventoryRank> findAllInvRanks() {
		return invRankRepo.findAll();
	}

	/**
	 * @author amal This is the main method which is used to update Inventory Ranks
	 *         by id
	 */

	public InventoryRankResponseDTO updateInvRankById(String rank, InventoryRankRequestDTO invRankReqDTO) {
		InventoryRankResponseDTO invRankResDTO = new InventoryRankResponseDTO();
		try {
			Optional<InventoryRank> invCatOptional = invRankRepo.findById(rank);
			if (invCatOptional.isPresent()) {
				InventoryRank invRank = invRankReqDTO.toModel(invRankReqDTO);
				invRank.setRank(rank);
				InventoryRank typeDataEntity = invRankRepo.save(invRank);
				if (typeDataEntity != null) {
					BeanUtils.copyProperties(typeDataEntity, invRankResDTO);
					logger.info(" Inventory Rank updated successfully");
				} else {
					logger.error("Inventory Rank updation failed");
				}
			} else {
				logger.error(" Inventory Rank doesn't exist");
				invRankResDTO.setResponseMessage("Inventory Rank doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update: updateInvRankById " + e);
			throw e;
		}

		return invRankResDTO;
	}

	/**
	 * @author amal This is the main method which is used to save Inventory Ranks
	 */

	public InventoryRankResponseDTO saveInvRanks(InventoryRankRequestDTO invRankReqDTO) {
		InventoryRankResponseDTO invRankRespDTO = new InventoryRankResponseDTO();
		try {
			InventoryRank invRank = invRankReqDTO.toModel(invRankReqDTO);
			InventoryRank invRankEntity = invRankRepo.save(invRank);
			if (invRankEntity != null) {
				BeanUtils.copyProperties(invRankEntity, invRankRespDTO);
				logger.info("Inventory Rank saved successfully");
			} else {
				logger.error("Failed to save Inventory Rank ");
			}
		} catch (Exception e) {
			logger.error("Save: saveInvRanks " + e);
			throw e;
		}

		return invRankRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get Inventory Ranks by
	 *         Id
	 */
	public TypeDataResponseDTO findTypeDataById(String id) {
		TypeDataResponseDTO typeDataRespDTO = new TypeDataResponseDTO();
		try {
			Optional<TypeData> typeDataOptional = typeDataRepo.findById(id);
			if (typeDataOptional.isPresent()) {
				TypeData typeData = typeDataOptional.get();
				BeanUtils.copyProperties(typeData, typeDataRespDTO);
			} else {
				logger.error(" Type Data doesn't exist");
				typeDataRespDTO.setResponseMessage("Type Data not found");
			}
		} catch (Exception e) {
			logger.error("Fetch Type Data " + e);
			throw e;
		}

		return typeDataRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all Type Data
	 */

	public List<TypeData> findAllTypeDatas() {
		return typeDataRepo.findAll();
	}

	/**
	 * @author amal This is the main method which is used to update Type Data by id
	 */
	public TypeDataResponseDTO updateTypeDataById(String unitCharge, TypeDataRequestDTO typeDataReqDTO) {
		TypeDataResponseDTO typeDataRespDTO = new TypeDataResponseDTO();
		try {
			Optional<TypeData> invCatOptional = typeDataRepo.findById(unitCharge);
			if (invCatOptional.isPresent()) {
				TypeData typeData = typeDataReqDTO.toModel(typeDataReqDTO);
				typeData.setUnitCharge(unitCharge);
				TypeData typeDataEntity = typeDataRepo.save(typeData);
				if (typeDataEntity != null) {
					BeanUtils.copyProperties(typeDataEntity, typeDataRespDTO);
					logger.info(" Type Data updated successfully");
				} else {
					logger.error(" Type Data updation failed");
				}
			} else {
				logger.error(" Type Data doesn't exist");
				typeDataRespDTO.setResponseMessage("Type Data doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update: updateTypeDataById " + e);
			throw e;
		}

		return typeDataRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to save Type Data
	 */

	public TypeDataResponseDTO saveTypeData(TypeDataRequestDTO typeDataReqDTO) {
		TypeDataResponseDTO typeDataRespDTO = new TypeDataResponseDTO();
		try {
			TypeData typeData = typeDataReqDTO.toModel(typeDataReqDTO);
			TypeData typeDataEntity = typeDataRepo.save(typeData);
			if (typeDataEntity != null) {
				BeanUtils.copyProperties(typeDataEntity, typeDataRespDTO);
				logger.info(" Type Data saved successfully");
			} else {
				logger.error("Failed to save Type Data ");
			}
		} catch (Exception e) {
			logger.error("Save: saveTypeData " + e);
			throw e;
		}

		return typeDataRespDTO;
	}

	/**
	 * @author naveen This is the main method which is used to update codeclarity
	 * 
	 * @return
	 */
	@Override
	public CodeClarityResponseDTO updateclaritymaintainance(String clarityId,
			CodeClarityRequestDTO codeClarityRequestDTO) {
		Optional<CodeClarity> clarityrepo = codeClarityRepository.findById(clarityId);
		CodeClarityResponseDTO codeClarityResponseDTO = new CodeClarityResponseDTO();

		try {
			if (clarityrepo == null) {
				logger.info("The clarityId doesn't exists!!!");
			} else {

				CodeClarity codeClarityDtos = codeClarityRequestDTO.toModel(codeClarityRequestDTO);

				codeClarityDtos.setClarityId(clarityId);
				;
				CodeClarity codeClarityEntity = codeClarityRepository.save(codeClarityDtos);
				logger.info("clarityDetails is updated");

				BeanUtils.copyProperties(codeClarityEntity, codeClarityResponseDTO);
			}
		} catch (Exception e) {
			logger.error("update: clarityDetails " + e);

			throw e;
		}
		return codeClarityResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to update codesetting
	 * 
	 * @return
	 */

	@Override
	public CodesSettingResponseDTO updatecodeSetting(String settingId, CodesSettingRequestDTO codeSettingRequestDTO) {
		Optional<CodesSetting> clarityrepo = codeSettingRepository.findById(settingId);
		CodesSettingResponseDTO codeSettingResponseDTO = new CodesSettingResponseDTO();

		try {
			if (clarityrepo == null) {
				logger.info("The codeSetting doesn't exists!!!");
			} else {

				CodesSetting codeSettingDtos = codeSettingRequestDTO.toModel(codeSettingRequestDTO);

				codeSettingDtos.setSettingId(settingId);

				CodesSetting codeSettingyEntity = codeSettingRepository.save(codeSettingDtos);
				logger.info("CodeSetting Entity is updated");

				BeanUtils.copyProperties(codeSettingyEntity, codeSettingResponseDTO);
			}
		} catch (Exception e) {
			logger.error("update: clarityDetails " + e);

			throw e;
		}
		return codeSettingResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to update codeclasp
	 * 
	 * @return
	 */
	@Override
	public CodeClaspResponsetDTO updatecodeclasp(String claspId, CodeClaspRequestDTO codeClaspRequestDTO) {
		Optional<CodeClasp> clsprepo = codeClaspRepository.findById(claspId);
		CodeClaspResponsetDTO codeClaspResponsetDTO = new CodeClaspResponsetDTO();

		try {
			if (clsprepo == null) {
				logger.info("The claspId doesn't exists!!!");
			} else {

				CodeClasp codeClaspDtomodel = codeClaspRequestDTO.toModel(codeClaspRequestDTO);

				codeClaspDtomodel.setClaspId(claspId);

				CodeClasp codeClaspEntity = codeClaspRepository.save(codeClaspDtomodel);
				logger.info("codeclaspDetails is updated");

				BeanUtils.copyProperties(codeClaspEntity, codeClaspResponsetDTO);
			}
		} catch (Exception e) {
			logger.error("update: codeclaspDetails " + e);

			throw e;
		}
		return codeClaspResponsetDTO;
	}

	/**
	 * AP-130 - > AP-238 Inventory Edit unit of measure finished jewelry -findings
	 * Method for list all finding of corresponding item
	 * 
	 * @param itemCode
	 * @return ResponseEntity<InventoryFindingsResponseDTO>
	 */
	@Override
	public List<InventoryFindingsResponseDTO> getItemFindings(String itemCode) throws Exception {
		List<InventoryFindingsResponseDTO> findingsResponseDTOList = new ArrayList<InventoryFindingsResponseDTO>();
		try {
			List<InventoryFindings> inventoryFindingsList = getInvItem(itemCode);
			inventoryFindingsList.stream().forEach((findings) -> {
				InventoryFindingsResponseDTO findingsResponseDTO = new InventoryFindingsResponseDTO();
				BeanUtils.copyProperties(findings, findingsResponseDTO);
				findingsResponseDTOList.add(findingsResponseDTO);
			});
		} catch (Exception e) {
			logger.error("Item Finding got an error: " + e.getMessage());

		}
		return findingsResponseDTOList;
	}

	private List<InventoryFindings> getInvItem(String itemCode) {
		InventoryFindings findingObj = new InventoryFindings();
		findingObj.setItemCode(itemCode);

		return inventoryFindingsRepository.findAll(Example.of(findingObj));
	}

	/**
	 * AP-130 - > AP-238 Inventory Edit unit of measure finished jewelry -findings
	 * Method for get finding
	 * 
	 * @param itemCode
	 * 
	 * @return ResponseEntity<Inventory1RespgetPricePerPieceonseDTO>
	 */
	@Override
	public InventoryFindingsResponseDTO getFindings(String mainItem, String itemCode) throws Exception {
		// Inventory1ResponseDTO responseDTO = new Inventory1ResponseDTO();
		InventoryFindingsResponseDTO findingsResponseDTO = new InventoryFindingsResponseDTO();
		try {
			Inventory1 inventory1Obj = new Inventory1();
			inventory1Obj.setItemCode(itemCode);
			inventory1Obj.setUnitCharge(DBConstant.FINDING);

			Optional<Inventory1> inventoryFindingsList = inventoryRepo.findOne(Example.of(inventory1Obj));
			if (inventoryFindingsList != null && inventoryFindingsList.isPresent()) {
				findingsResponseDTO = copyToFindings(mainItem, inventoryFindingsList.get());
			} else {
				throw new ResourceNotFoundException(ErrorCodes.ITEM_NOT_FOUND.getMessage());
			}

		} catch (BeansException e) {
			logger.error("Finding got an error: " + e.getMessage());
		}
		return findingsResponseDTO;
	}

	private InventoryFindingsResponseDTO copyToFindings(String mainItem, Inventory1 inventory1) {
		InventoryFindingsResponseDTO findingsResponseDTO = new InventoryFindingsResponseDTO();
		try {
			findingsResponseDTO.setItemCode(mainItem);
			findingsResponseDTO.setFindingId(inventory1.getItemCode());
			//findingsResponseDTO.setKarat(inventory1.getKarat());
			findingsResponseDTO.setMaterial(inventory1.getMaterial());
			findingsResponseDTO.setPieces(inventory1.getInStockP());
			//findingsResponseDTO.setPrice(inventory1.getCostPc());
			//findingsResponseDTO.setTotal(inventory1.getSalesPrice());// is there need to consider multi factor
			//findingsResponseDTO.setWtPiece(inventory1.getWtPiece());
		} catch (Exception e) {
			logger.error("Finding got an error: " + e.getMessage());
		}
		return findingsResponseDTO;
	}

	/**
	 * AP-130 - > AP-238 Inventory Edit unit of measure finished jewelry -findings
	 * Method for processing findings available piece
	 * 
	 * @param itemCode
	 * 
	 * @return ResponseEntity<Inventory1ResponseDTO>
	 */
	@Override
	public InventoryFindingsResponseDTO getPricePerPiece(String mainItem, String itemCode, int reqPiece)
			throws Exception {
		InventoryFindingsResponseDTO findingsResponseDTO = new InventoryFindingsResponseDTO();
		try {
			findingsResponseDTO = getFindings(mainItem, itemCode);
			if (findingsResponseDTO != null) {// check condition
				if (findingsResponseDTO.getPieces() < reqPiece) {
					throw new ResourceNotFoundException(
							ErrorCodes.EXCEED_LIMIT.getMessage() + findingsResponseDTO.getPieces());
				}
				findingsResponseDTO.setTotal(findingsResponseDTO.getPrice() * reqPiece);
			} else {
				throw new ResourceNotFoundException(ErrorCodes.ITEM_NOT_FOUND.getMessage());
			}

		} catch (BeansException e) {
			logger.error("Finding got an error: " + e.getMessage());
		}
		return findingsResponseDTO;
	}

	/**
	 * @author Srijini Save item findings 1. delete all findings of an item 2. save
	 *         item findings
	 */
	/**
	 * @author Srijini Save item findings 1. delete all findings of an item 2. save
	 *         item findings
	 */
	@Override
	@Transactional
	@Modifying
	public List<InventoryFindingsResponseDTO> saveFindings(List<InventoryFindingsRequestDTO> invReqDTOList)
			throws Exception {
		List<InventoryFindingsResponseDTO> findingsResponseDTOList = new ArrayList<InventoryFindingsResponseDTO>();
		try {
			if (invReqDTOList != null && !invReqDTOList.isEmpty()) {
				final String item = invReqDTOList.get(0).getItemCode();
				List<InventoryFindings> inventoryFindingsList = getInvItem(item);
				inventoryFindingsRepository.deleteAll(inventoryFindingsList);
				inventoryFindingsList = getFindingItem(invReqDTOList);
				List<InventoryFindings> findingList = inventoryFindingsRepository.saveAll(inventoryFindingsList);

				findingList.stream().forEach((findings) -> {
					InventoryFindingsResponseDTO findingsResponseDTO = new InventoryFindingsResponseDTO();
					BeanUtils.copyProperties(findings, findingsResponseDTO);
					findingsResponseDTO.setResponseMessage("Record : " + item + " updated successfully");// update
																											// currect
																											// msg
					findingsResponseDTOList.add(findingsResponseDTO);
				});

			} else {
				throw new ResourceNotFoundException(ErrorCodes.ITEM_NOT_FOUND.getMessage());
			}

		} catch (IllegalArgumentException e) {
			logger.error("Finding got an error: " + e.getMessage());
		}
		return findingsResponseDTOList;
	}

	private List<InventoryFindings> getFindingItem(List<InventoryFindingsRequestDTO> invReqDTOList) {
		List<InventoryFindings> inventoryFindings = new ArrayList<InventoryFindings>();
		try {
			invReqDTOList.forEach(finding -> {
				InventoryFindings findings = new InventoryFindings();
				findings.setItemCode(finding.getItemCode());
				findings.setFindingId(finding.getFindingId());
				findings.setKarat(finding.getKarat());
				findings.setMaterial(finding.getMaterial());
				findings.setPieces(finding.getPieces());
				findings.setPrice(finding.getPrice());
				findings.setTotal(finding.getTotal());
				findings.setWtPiece(finding.getWtPiece());
				inventoryFindings.add(findings);
			});
		} catch (Exception e) {
			logger.error("Exception while saving Finding : " + e.getMessage());
		}
		return inventoryFindings;
	}

	/* @Author:Vidya AP-124 - > Inventory General tab */
	/**
	 * @Author: Vidya This Api getting Size by categoryId
	 * @param categoryId
	 * @return ResponseEntity<Add>
	 */
	public List<AdditionalOrderDataResponseDTO> getSizeBycategoryById(String categoryId) throws Exception {
		List<AdditionalOrderDataResponseDTO> addtionalOrderDataResponseList = new ArrayList<AdditionalOrderDataResponseDTO>();

		try {
			/*
			 * List<AdditionalOrderData> addtionalOrderDataList =
			 * additionalOrderDataRepository .findSizeByCategory(categoryId); if
			 * (addtionalOrderDataList != null && addtionalOrderDataList.size() > 0) {
			 * addtionalOrderDataList.forEach((addtionalOrderData) -> {
			 * AdditionalOrderDataResponseDTO addtionalOrderDataResponsetDTO = new
			 * AdditionalOrderDataResponseDTO();
			 * BeanUtils.copyProperties(addtionalOrderData, addtionalOrderDataResponsetDTO);
			 * addtionalOrderDataResponseList.add(addtionalOrderDataResponsetDTO);
			 * 
			 * }); logger.info("getSizeBycategoryById" + categoryId); } else {
			 * logger.error(" Error getSizeBycategoryById " + categoryId);
			 * 
			 * }
			 */

		} catch (Exception e) {
			logger.error("error in getSizeBycategoryById" + e);
			throw e;
		}
		return addtionalOrderDataResponseList;
	}

	/**
	 * @Author: Vidya This REST endpoint getting Lock type for categoryId
	 * @param categoryId
	 * @return ResponseEntity<Add>
	 */

	public List<LockingTypeResponseDTO> getLockTypeBycategoryById(String categoryId) throws Exception {

		List<LockingTypeResponseDTO> lockResponseDTOs = new ArrayList<LockingTypeResponseDTO>();
		try {
			List<LockingType> lockTypeList = lockingTypeRepository.findLockingTypeByCategory(categoryId);
			if (lockTypeList != null && lockTypeList.size() > 0) {
				lockTypeList.forEach((lockType) -> {
					LockingTypeResponseDTO lockResponseDTO = new LockingTypeResponseDTO();
					BeanUtils.copyProperties(lockType, lockResponseDTO);
					lockResponseDTOs.add(lockResponseDTO);
				});
				logger.info("getLockTypeBycategoryById" + categoryId);
			} else {
				logger.error(" Error getLockTypeBycategoryById " + categoryId);
			}
		} catch (Exception e) {
			logger.error(" getLockTypeBycategoryById failed" + e);

			throw e;
		}
		return lockResponseDTOs;

	}

	/**
	 * @Author: Vidya This REST findInventoryById
	 * @param itemCode
	 * @return ResponseEntity
	 */

	public Inventory1ResponseDTO findInventoryById(String itemCode) throws Exception {
		Inventory1ResponseDTO inventory1Response = new Inventory1ResponseDTO();
		try {

			Optional<Inventory1> inventory1 = inventoryRepo.findById(itemCode);
			if (inventory1.isPresent()) {
				Inventory1 inventoryobj = inventory1.get();
				BeanUtils.copyProperties(inventoryobj, inventory1Response);
			} else {
				logger.error(" itemCode doesn't exist");
				inventory1Response.setResponseMessage("Item Not found");
			}
		} catch (Exception e) {
			logger.error("findInventoryById " + e);
			throw e;
		}

		return inventory1Response;
	}

	/**
	 * @author amal This is the main method which is used to save Inventory Data
	 */
	public Inventory1ResponseDTO saveInvetoryData(Inventory1RequestDTO inv1ReqDTO) {
		Inventory1ResponseDTO inv1RespDTO = new Inventory1ResponseDTO();
		try {

			logger.info("Going to save inventory");
			if (inv1ReqDTO.getItemCode() != null) {
			
				inv1ReqDTO=saveMaterialsforInventory(inv1ReqDTO);
				Inventory1 invEntity = inv1ReqDTO.toModel(inv1ReqDTO);
				Inventory2 inventory2 = null;//inv1ReqDTO.getInventory2();
				
			
				Inventory1 inventory1ReturnObj = inventoryRepo.save(invEntity);
				if (inventory2 != null) {
					Inventory2 inventory22 = inventory2Repo.save(inventory2);
				}
			
				// Babu added
				//List<VendorItemMatchRequestDTO> lstvendorItemMatchRequestDTO = inv1ReqDTO
				//		.getLstvendorItemMatchRequestDTO();
				//saveVendorItemMatch(lstvendorItemMatchRequestDTO, inv1ReqDTO.getItemCode());
				//ProductKeywordRequestDTO productKeywordRequestDTO = inv1ReqDTO.getProductKeywordRequestDTO();
				//saveProductKeywords(productKeywordRequestDTO, inv1ReqDTO.getItemCode());
				//List<InventoryAlternateRequestDTO> reqDTO = inv1ReqDTO.getInventoryAlternateRequestDTO();
				//saveInventoryAlternate(reqDTO, inv1ReqDTO.getItemCode());
				//List<LibraryItemRequestDTO> reqDTOlib = inv1ReqDTO.getLibraryItemRequestDTO();
				//saveLibraryItem(reqDTOlib, inv1ReqDTO.getItemCode());
				// End
				if (inventory1ReturnObj != null) {
					BeanUtils.copyProperties(inventory1ReturnObj, inv1RespDTO);
					logger.info(" save inventory successfully");
				} else {
					logger.error("save inventory  failed");
					inv1RespDTO.setResponseMessage("save inventory  failed");
				}
			}

			else {
				logger.error("Item not exsist in Inventory ");
				inv1RespDTO.setResponseMessage("Item not exsist in Inventory ,update inventory  failed");
			}

		} catch (Exception e) {
			logger.error("saveInvetoryData :service Impl " + e);

		}

		return inv1RespDTO;
	}

	public LibraryItemResponseDTO saveLibraryItem(List<LibraryItemRequestDTO> reqDTO, String itemCode)
			throws Exception {
		LibraryItemResponseDTO iibraryItemResponseDTO = new LibraryItemResponseDTO();

		try {
			for (LibraryItemRequestDTO libraryItemRequestDTO : reqDTO) {
				MultipartFile file = libraryItemRequestDTO.getFile();
				System.out.println("file ==========================" + file);
				String imageBase = "E:/uploads/inventory/";

				imageBase = imageBase + itemCode + "/";
				libraryItemRequestDTO.setItemCode(itemCode);

				String actualFilename = DateUtils.getCurrentTime() + "Actual_" + file.getOriginalFilename();
				libraryItemRequestDTO.setActualImage(imageBase + "/" + actualFilename);

				imageUplodeOption.actualImageUpload(imageBase, file, actualFilename);
				imageUplodeOption.shortImageUpload(imageBase, file, actualFilename);
				libraryItemRequestDTO.setShortImage(
						imageBase + "/" + DateUtils.getCurrentTime() + "Short_" + file.getOriginalFilename());
				LibraryItem libraryItem = libraryItemRequestDTO.toModel(libraryItemRequestDTO);

				LibraryItem libraryItemEntity = imageItemRepository.save(libraryItem);

			}
		} catch (Exception e) {
			logger.error("Save: library Data  error " + e);
			throw e;
		}

		return iibraryItemResponseDTO;
	}

	public InventoryAlternateResponseDTO saveInventoryAlternate(List<InventoryAlternateRequestDTO> reqDTO,
			String itemCode) {
		InventoryAlternateResponseDTO inventoryAlternateResponseDTO = new InventoryAlternateResponseDTO();
		try {
			for (InventoryAlternateRequestDTO inventoryAlternateRequestDTO : reqDTO) {
				if (inventoryAlternateRequestDTO.getItemCodeAlt() != null) {
					inventoryAlternateRequestDTO.setItemCode(itemCode);
					InventoryAlternate inventoryAlternate = inventoryAlternateRequestDTO
							.toModel(inventoryAlternateRequestDTO);
					InventoryAlternate inventoryAlternateEntity = inventoryAlternateRepository.save(inventoryAlternate);
					if (inventoryAlternateEntity != null) {
						BeanUtils.copyProperties(inventoryAlternateEntity, inventoryAlternateResponseDTO);
						logger.info(" Inventory Alternate Data saved successfully");
					} else {
						logger.error("Failed to save InventoryAlternate Data  ");
					}
				}
			}
		} catch (Exception e) {
			logger.error("Save: InventoryAlternate Data  error " + e);
			throw e;
		}

		return inventoryAlternateResponseDTO;
	}

	public ProductKeywordsResponseDTO saveProductKeywords(ProductKeywordRequestDTO productKeywordRequestDTO,
			String itemCode) {
		ProductKeywordsResponseDTO productKeywordsResponseDTO = new ProductKeywordsResponseDTO();
		try {
			ProductKeywords productKeywords = productKeywordRequestDTO.toModel(productKeywordRequestDTO);
			ProductKeywords productKeywordsEntity = productKeywordsRepository.save(productKeywords);
			if (productKeywordsEntity != null) {
				BeanUtils.copyProperties(productKeywordsEntity, productKeywordsResponseDTO);
				logger.info(" Product Keywords saved successfully");
			} else {
				logger.error("Failed to save  Product Keywords ");
			}
		} catch (Exception e) {
			logger.error("Save:  Product Keywords Data  error " + e);
			throw e;
		}

		return productKeywordsResponseDTO;
	}

	public VendorItemMatchResponseDTO saveVendorItemMatch(List<VendorItemMatchRequestDTO> lstvendorItemMatchRequestDTO,
			String itemCode) {
		VendorItemMatchResponseDTO vendorItemMatchResponseDTO = new VendorItemMatchResponseDTO();
		try {
			for (VendorItemMatchRequestDTO vendorItemMatchRequestDTO : lstvendorItemMatchRequestDTO) {
				if (vendorItemMatchRequestDTO.getVendorNo() != null) {
					VendorItemMatch vendorItemMatch = vendorItemMatchRequestDTO.toModel(vendorItemMatchRequestDTO);
					vendorItemMatch.setItemCode(itemCode);/// hard coded
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
	 * @Author: Vidya This REST updateInventory
	 * @param itemCode
	 * @return ResponseEntity
	 */

	public Inventory1ResponseDTO updateInventory(String itemCode, Inventory1RequestDTO inventory1RequestDTO)
			throws Exception {
		Inventory1ResponseDTO inventory1ResponseDTO = new Inventory1ResponseDTO();

		try {
			logger.info("Going to update inventory");

			Optional<Inventory1> inventoryObj = inventoryRepo.findById(itemCode);
			if (inventoryObj.isPresent()) {
				Inventory1 inventory1 = inventory1RequestDTO.toModel(inventory1ResponseDTO);

				inventory1.setItemCode(itemCode);
				Inventory2 inventory2 = null;//inventory1RequestDTO.getInventory2();
				if (inventory2 != null) {
			//		inventory2.setInventory1(inventory1);
				}
				
				
				List<InventoryMaterialsUsed> inventoryMatList = getInvMaterials(itemCode);
				invMatRepo.deleteAll(inventoryMatList);
				saveMaterialsforInventory(inventory1RequestDTO);// update materials
				Inventory1 inventory1response = inventoryRepo.save(inventory1);
				
				
				// Babu added 19/09
				// Inven alt
				//List<InventoryAlternate> invenAltList = inventoryAlternateRepository.findByItemCode(itemCode);
				///invenAltList.forEach((altObj) -> {
				//	inventoryAlternateRepository.delete(altObj);
				//});
				//List<InventoryAlternateRequestDTO> reqDTO = inventory1RequestDTO.getInventoryAlternateRequestDTO();
				//saveInventoryAlternate(reqDTO, itemCode);
				// VendorItem
				List<VendorItemMatch> vendItemList = vendorItemMatchRepository.findByItemCode(itemCode);
				vendItemList.forEach((vendObj) -> {
					vendorItemMatchRepository.delete(vendObj);
				});
				//List<VendorItemMatchRequestDTO> lstvendorItemMatchRequestDTO = inventory1RequestDTO
				//		.getLstvendorItemMatchRequestDTO();
				//saveVendorItemMatch(lstvendorItemMatchRequestDTO, itemCode);
				// prod key
				// Optional<ProductKeywords> prodkey =
				// productKeywordsRepository.findById(itemCode);
				productKeywordsRepository.deleteById(itemCode);
				//ProductKeywordRequestDTO productKeywordRequestDTO = inventory1RequestDTO.getProductKeywordRequestDTO();
				//saveProductKeywords(productKeywordRequestDTO, itemCode);
				// lib item
				List<LibraryItem> libItemist = imageItemRepository.findByItemCode(itemCode);
				libItemist.forEach((libObj) -> {
					imageItemRepository.delete(libObj);
				});
				//List<LibraryItemRequestDTO> reqDTOlib = inventory1RequestDTO.getLibraryItemRequestDTO();
				//saveLibraryItem(reqDTOlib, itemCode);
				// End

				if (inventory1response != null) {
					BeanUtils.copyProperties(inventory1, inventory1ResponseDTO);
					logger.info(" update inventory successfully");
				} else {
					logger.error("update inventory  failed");
					inventory1ResponseDTO.setResponseMessage("update inventory  failed");
				}
			}

			else {
				logger.error("Item not exsist in Inventory ");
				inventory1ResponseDTO.setResponseMessage("Item not exsist in Inventory ,update inventory  failed");
			}

		} catch (Exception e) {
			logger.error(" update inventory  failed" + e);
			throw e;
		}

		return inventory1ResponseDTO;
	}

	/**
	 * @Author: Vidya This method to updateInventory
	 * @param itemCode
	 * @return ResponseEntity
	 */

	@Transactional
	public Inventory1ResponseDTO updateInventoryStock(String itemCode, Inventory1RequestDTO inventory1RequestDTO)
			throws Exception {

		Inventory1ResponseDTO inventory1Response = new Inventory1ResponseDTO();
		try {
			if (inventory1RequestDTO != null) {
				Optional<Inventory1> inventory1 = inventoryRepo.findById(itemCode);
				if (inventory1.isPresent()) {
					Inventory1 inventory1Obj = inventory1.get();
					int stock = inventory1RequestDTO.getDummystock();

					InventoryStockHistory inventoryStockHistory = new InventoryStockHistory();
					inventoryStockHistory.setItemCode(itemCode);
					inventoryStockHistory.setNewPieces(stock);
					inventoryStockHistory.setOldPieces(inventory1Obj.getInStockP());
					inventoryStockHistory.setUnitCharge(inventory1Obj.getUnitCharge());
					inventoryStockHistory.setChangeDate(new Date());
					inventoryStockHistory.setChangeTime(new Date());
					inventoryStockHistory.setUserId("userId");
					inventoryRepo.updateStock(stock, itemCode);
					invstockHistoryRepo.save(inventoryStockHistory);
					logger.error("Stock updated");
					inventory1Response.setResponseMessage("Stock updated");
				}

				else {
					logger.error(" itemCode doesn't exist");
					inventory1Response.setResponseMessage("Item Not found");
				}
			}

		} catch (Exception e) {
			logger.error("updateInventoryStock " + e);
			throw e;
		}

		return inventory1Response;

	}

	/* @Author:Vidya AP-124 - > Inventory General tab end */

	/**
	 * @author amal This is the main method which is used to save Inventory
	 *         Materials Data
	 * @return Inventory1
	 */
	private Inventory1RequestDTO saveMaterialsforInventory(Inventory1RequestDTO inv1ReqDTO) {
		List<InventoryMaterialsRequestDTO> inventoryMaterialsList = null;//inv1ReqDTO.getInvMaterials();

		try {
			if (inventoryMaterialsList != null && inventoryMaterialsList.size() > 0) {
				logger.info("Saving inventory Materials details");
				// Get Gold material from material list
				List<InventoryMaterialsRequestDTO> goldMaterialUsed = inventoryMaterialsList.stream()
						.filter(i -> i.getMaterialId().equalsIgnoreCase("14ky")).collect(Collectors.toList());

				if (goldMaterialUsed != null && goldMaterialUsed.size() > 0) {
					// Save Gold material to inventory1 table
					Optional<InventoryMaterialsRequestDTO> inv1Mat = goldMaterialUsed.stream().findFirst();
					inv1ReqDTO.setMaterial(inv1Mat.get().getMaterialId());
					inv1ReqDTO.setKarat(inv1Mat.get().getKaratValue());
					inv1ReqDTO.setMaterialPrice(inv1Mat.get().getPrice());
					inventoryMaterialsList.remove(inv1Mat.get());
				} else {
					// Saving material to inventory1 table
					InventoryMaterialsRequestDTO inv1MatUsed = inventoryMaterialsList.stream().findFirst().get();
					if (inv1MatUsed != null) {
						inv1ReqDTO.setMaterial(inv1MatUsed.getMaterialId());
						inv1ReqDTO.setKarat(inv1MatUsed.getKaratValue());
						inv1ReqDTO.setMaterialPrice(inv1MatUsed.getPrice());
						inventoryMaterialsList.remove(inv1MatUsed);
					}

				}
				// Saving material to inventory_material_used table
				inventoryMaterialsList.forEach((matObj) -> {
					matObj.setItemCode(inv1ReqDTO.getItemCode());
//					invMatRepo.save(matObj);
				});
				List<InventoryMaterialsUsed> invMatList=setmaterialItem(inventoryMaterialsList);
				invMatRepo.saveAll(invMatList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inv1ReqDTO;

	}

	
	private List<InventoryMaterialsUsed> getInvMaterials(String itemCode) {
		InventoryMaterialsUsed matObj = new InventoryMaterialsUsed();
		matObj.setItemCode(itemCode);

		return invMatRepo.findAll(Example.of(matObj));
	}
	
	private List<InventoryMaterialsUsed>setmaterialItem(List<InventoryMaterialsRequestDTO> invReqDTOList) {
		List<InventoryMaterialsUsed> inventoryMaterialsList = new ArrayList<InventoryMaterialsUsed>();
		try {
			invReqDTOList.forEach(materials -> {
				InventoryMaterialsUsed matUsed = new InventoryMaterialsUsed();
				matUsed.setItemCode(materials.getItemCode());
				matUsed.setColor(materials.getColor());
				matUsed.setKaratValue(materials.getKarat());
				matUsed.setMaterialId(materials.getMaterialId());
				matUsed.setPrice(materials.getPrice());
				matUsed.setWeight(materials.getWeight());
				inventoryMaterialsList.add(matUsed);
			});
		} catch (Exception e) {
			logger.error("Exception while saving Finding : " + e.getMessage());
		}
		return inventoryMaterialsList;
	}
	
	/**
	 * @author amal This is the main method which is used to calculating Materials
	 *         price and weight by karat
	 * @return Inventory1ResponseDTO
	 */

	public Inventory1ResponseDTO getPriceandWeightfromKarat(Inventory1RequestDTO invReqDTO) {
		Inventory1ResponseDTO invRespDTO = new Inventory1ResponseDTO();
		try {
			List<InventoryMaterialsRequestDTO> invMatUsedList = null;//invReqDTO.getInvMaterials();

			Inventory1 inv1 = new Inventory1();

			invMatUsedList.forEach((matObj) -> {
				if (matObj.getMaterialId().equalsIgnoreCase("14KY")) {
					Double karat = 0d, weight = 0d, wt10k = 11.0, wt14k = 13.2, wt18k = 15.5, wt24k = 19.3,
							changeKarat = 0d;
					Double itemWt = 0d;
					weight = matObj.getWeight();
					karat = matObj.getKarat();
					changeKarat = matObj.getKaratValue();
					if (!changeKarat.equals(karat)) {
						if (changeKarat == 0.4250) {// 10K
							if (karat == 0.7500) { // 18K convert to 10K
								itemWt = wt10k / wt18k * weight;
							} else if (karat == 0.5850) { // 14K convert to 10K
								itemWt = wt10k / wt14k * weight;
							} else if (karat == 1.0000) { // 24K convert to 10K
								itemWt = wt10k / wt24k * weight;
							}
						} else if (changeKarat == 0.5850) {// 14K
							if (karat == 0.7500) { // 18K convert to 14K
								itemWt = wt14k / wt18k * weight;
							} else if (karat == 0.4250) { // 10K convert to 14K
								itemWt = wt14k / wt10k * weight;
							} else if (karat == 1.0000) { // 24K convert to 14K
								itemWt = wt14k / wt24k * weight;
							}
						} else if (changeKarat == 0.7500) {// 18K
							if (karat == 0.5850) { // 14K convert into 18K.
								itemWt = wt18k / wt14k * weight;
							} else if (karat == 0.4250) { // 10K convert into 18K.
								itemWt = wt18k / wt10k * weight;
							} else if (karat == 1.0000) { // 24K convert into 18K.
								itemWt = wt18k / wt24k * weight;
							}
						} else if (changeKarat == 1.0000) {// 22K
							itemWt = wt24k / wt14k * weight;// 14K convert into 24K.
							if (karat == 0.5850) { // 14K convert into 24K.
								itemWt = wt24k / wt14k * weight;
							} else if (karat == 0.4250) { // 10K convert into 24K.
								itemWt = wt24k / wt10k * weight;
							} else if (karat == 0.7500) { // 18K convert into 24K.
								itemWt = wt24k / wt18k * weight;
							}
						}
					} else {
						itemWt = weight;
					}
					matObj.setWeight(itemWt);
					matObj.setKarat(changeKarat);
				}
				Double materialPrice = findCostOfInventoryMaterial(matObj, invReqDTO.getBrandId());
				matObj.setPrice(materialPrice);

			});
			//invReqDTO.setInvMaterials(invMatUsedList);
			BeanUtils.copyProperties(invReqDTO, invRespDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to calculating Materials
	 *         price by weight
	 * @return Inventory1ResponseDTO
	 */
	public Inventory1ResponseDTO getPricefromWeight(Inventory1RequestDTO invReqDTO) {
		Inventory1ResponseDTO invRespDTO = new Inventory1ResponseDTO();

		try {
			Inventory1 inv1 = new Inventory1();

			List<InventoryMaterialsRequestDTO> invMatUsedList = null;//invReqDTO.getInvMaterials();
			invMatUsedList.forEach((matObj) -> {
				Double materialPrice = findCostOfInventoryMaterial(matObj, invReqDTO.getBrandId());
				matObj.setPrice(materialPrice);
			});
			//invReqDTO.setInvMaterials(invMatUsedList);
			BeanUtils.copyProperties(invReqDTO, invRespDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return invRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to calculating Materials
	 *         price by weight and karat
	 * @return price
	 */
	private Double findCostOfInventoryMaterial(InventoryMaterialsRequestDTO matObj, Long brandId) {
		double cost = 0d, currentRate = 0d, matKarat = 0d, matWeight = 0d;
		double price_24k, price_18k, price_14k, price_10k, platinum;
		// finding today's gold price
		if (brandId == 2l) {
			// calculate for chrysosbrand
		} else {
			/*
			 * if(goldPrHistory!=null){ currentRate=goldPrHistory.getChangePrice();
			 * 
			 * }
			 */
		}
		currentRate = 100;
		// finding price for a gram in different karats
		price_24k = currentRate / 31.1 * 0.999;
		price_18k = currentRate / 31.1 * 0.750;
		price_14k = currentRate / 31.1 * 0.585;
		price_10k = currentRate / 31.1 * 0.410;
		platinum = currentRate / 21.45;

		String material = matObj.getMaterialId();
		if (matObj.getKaratValue() != null) {
			matKarat = matObj.getKaratValue();
		}
		if (matObj.getWeight() != null) {
			matWeight = matObj.getWeight();
		}

		if (material != null && material.equalsIgnoreCase("14KY")) {// gold
			if (matKarat == 24 || matKarat == 1.0000) {
				cost = matWeight * price_24k;
			} else if (matKarat == 18 || matKarat == 0.7500) {
				cost = matWeight * price_18k;
			} else if (matKarat == 14 || matKarat == 0.5850) {
				cost = matWeight * price_14k;
			} else if (matKarat == 10 || matKarat == 0.4250) {
				cost = matWeight * price_10k;
			}
		} else if (material != null && material.equalsIgnoreCase("PLAT")) {// platinum
			cost = matWeight * platinum;// price not availbale
		} else if (material != null && material.equalsIgnoreCase("14K")) {// silver
			cost = matWeight;// price not availbale
		}
		return cost;
	}

	/**
	 * @author amal This is the main method which is used to calculating sales price
	 *         from cost Price
	 * @return Inventory1ResponseDTO
	 */

	public Inventory1ResponseDTO getPricefromItemCost(Inventory1RequestDTO invReqDTO) {
		Inventory1ResponseDTO invRespDTO = new Inventory1ResponseDTO();
		try {
			Inventory1 inv = invReqDTO.toModel(invReqDTO);
			boolean flag = false;
			if (inv != null && inv.getBrandId() != null) {
				if (inv.getBrandId() == 2) {
					flag = true;
				}
			} else {
				invRespDTO.setResponseMessage("Please select Brand");
			}
			if (inv.getCostPc() != null) {
				if (inv.getMultFactor() != null && inv.getMultFactor() > 0) {
					if (flag) {
						if (inv.getLabor() != null && inv.getLabor() > 0) {
							inv.setSalesPrice(
									inv.getCostPc() + (inv.getLabor() + (inv.getLabor() * inv.getMultFactor() / 100)));
							inv.setAvgDispPrc(inv.getSalesPrice() * 10);
						} else {
							inv.setLabor(0d);
							inv.setSalesPrice(inv.getCostPc());
							inv.setAvgDispPrc(inv.getSalesPrice() * 10);
						}
					} else {
						inv.setSalesPrice(inv.getCostPc() + (inv.getCostPc() * inv.getMultFactor() / 100));
						inv.setAvgDispPrc(inv.getSalesPrice() * 10);
					}
				} else {
					if (flag) {
						if (inv.getLabor() != null && inv.getLabor() > 0) {
							inv.setSalesPrice(inv.getCostPc() + inv.getLabor());
							inv.setAvgDispPrc(inv.getCostPc() * 10);
							inv.setMultFactor(0d);
						} else {
							inv.setSalesPrice(inv.getCostPc());
							inv.setAvgDispPrc(inv.getCostPc() * 10);
							inv.setMultFactor(0d);
							inv.setLabor(0d);
						}
					} else {
						inv.setSalesPrice(inv.getCostPc());
						inv.setAvgDispPrc(inv.getCostPc() * 10);
						inv.setMultFactor(0d);
					}
				}
			}
			BeanUtils.copyProperties(inv, invRespDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return invRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to calculating price from
	 *         sales price
	 * @return Inventory1ResponseDTO
	 */
	public Inventory1ResponseDTO getPricefromSalesPrice(Inventory1RequestDTO invReqDTO) {
		Inventory1ResponseDTO invRespDTO = new Inventory1ResponseDTO();
		try {
			Inventory1 inventory1 = invReqDTO.toModel(invReqDTO);
			boolean flag = false;
			if (inventory1 != null && inventory1.getBrandId() != null) {
				if (inventory1.getBrandId() == 2) {
					flag = true;
				}
			} else {
				invRespDTO.setResponseMessage("Please select brand");
			}
			if (flag) {
				if (inventory1.getLabor() != null && inventory1.getCostPc() != null
						&& inventory1.getSalesPrice() != null) {
					Double markUpAmount = (inventory1.getSalesPrice() - inventory1.getCostPc()) - inventory1.getLabor();
					if (inventory1.getSalesPrice().equals(inventory1.getCostPc())) {
						inventory1.setMultFactor(0d);
					} else {
						Double markUpPer = (markUpAmount * 100) / inventory1.getLabor();
						if (markUpPer > 0) {
							DecimalFormat format = new DecimalFormat("#.##");
							markUpPer = Double.valueOf(format.format(markUpPer));
							inventory1.setMultFactor(markUpPer);
						}
					}
					inventory1.setAvgDispPrc(inventory1.getSalesPrice() * 10);
				}
			} else {
				if (inventory1.getSalesPrice() != null && inventory1.getCostPc() != null) {
					Double markUpAmount = inventory1.getSalesPrice() - inventory1.getCostPc();
					if (inventory1.getSalesPrice().equals(inventory1.getCostPc())) {
						inventory1.setMultFactor(0d);
					} else {
						Double markUpPer = (markUpAmount * 100) / inventory1.getCostPc();
						if (markUpPer > 0) {
							DecimalFormat format = new DecimalFormat("#.##");
							markUpPer = Double.valueOf(format.format(markUpPer));
							inventory1.setMultFactor(markUpPer);
						}
					}
					inventory1.setAvgDispPrc(inventory1.getSalesPrice() * 10);
				}
			}
			BeanUtils.copyProperties(inventory1, invRespDTO);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return invRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to save price
	 * @return Inventory1ResponseDTO
	 */

	public Inventory1ResponseDTO saveInvetoryPrice(Inventory1RequestDTO invReqDTO) {
		Inventory1ResponseDTO invRespDTO = new Inventory1ResponseDTO();

		Double dbYourCost = 0d, dbMarkUp = 0d, dbSalesPrice = 0d, newYourCost = 0d, newMarkUp = 0d, newSalesPrice = 0d,
				newLabor = 0d, dbLabor = 0d;
		Optional<Inventory1> invObjOptional = inventoryRepo.findById(invReqDTO.getItemCode());
		if (invObjOptional.isPresent()) {
			Inventory1 invObj = invObjOptional.get();
			if (invObj != null) {
				dbYourCost = invObj.getCostPc();
				if (invObj.getMultFactor() != null && invObj.getMultFactor() > 0) {
					dbMarkUp = invObj.getMultFactor();
				}
				if (invObj.getSalesPrice() != null && invObj.getSalesPrice() > 0) {
					dbSalesPrice = invObj.getSalesPrice();
				}
				if (invObj.getLabor() != null && invObj.getLabor() > 0) {
					dbLabor = invObj.getLabor();
				}
				InventoryPriceHistory invPricehistory = new InventoryPriceHistory();
				invPricehistory.setItemCode(invReqDTO.getItemCode());
				invPricehistory.setUserId("");

				// invPricehistory.setChangeDate();
				// invPricehistory.setChangeTime();
				invPricehistory.setNewCostPrice(invReqDTO.getCostPc());
				invPricehistory.setNewMarkUp(invReqDTO.getMultFactor());
				invPricehistory.setNewSalesPrice(invReqDTO.getSalesPrice());
				invPricehistory.setOldCostPrice(dbYourCost);
				invPricehistory.setOldMarkUp(dbMarkUp);
				invPricehistory.setOldSalesPrice(dbSalesPrice);
				invPricehistory.setOldLabor(dbLabor);
				invPricehistory.setNewLabor(invReqDTO.getLabor());
				invObj.setCostPc(invReqDTO.getCostPc());
				invObj.setMultFactor(invReqDTO.getMultFactor());
				invObj.setSalesPrice(invReqDTO.getSalesPrice());
				invObj.setAvgDispPrc(invReqDTO.getSalesPrice() * 10);
				invObj.setLabor(invReqDTO.getLabor());
				// save old and new price in inventory history table

				invPriceRepo.save(invPricehistory);
				// save new price in inventory table

				inventoryRepo.save(invObj);
			}

		}

		return invRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get price history of
	 *         price
	 * @return Inventory1ResponseDTO
	 */
	public List<InventoryPriceHistory> getAllPriceHistoryofItem(String itemCode) {
		InventoryPriceHistory invPrice = new InventoryPriceHistory();
		invPrice.setItemCode(itemCode);

		List<InventoryPriceHistory> inventoryPriceHistoryList = invPriceRepo.findAll(Example.of(invPrice));
		return inventoryPriceHistoryList;
	}
	
	/***

	@Author:Srijini AP-130->AP-239
	Inventory Edit
	unit of
	measure finished*jewelry-Stones**
	End point for
	list all
	finding of
	corresponding item**

	@param itemCode
	 * @return ResponseEntity<List<CustomManfStoneResponseDTO>>
	 */
	@Override
	public List<CustomManfStoneResponseDTO> getItemStones(String itemCode) throws Exception{
		try {
			List<CustomManfStoneResponseDTO> customManfStones = customManfStoneRepository.getManfStone(itemCode);
			customManfStones.addAll(customManfStoneRepository.getMMStone(itemCode));
			customManfStones.addAll(customManfStoneRepository.getSmalltone(itemCode));
			return customManfStones;
		} catch (Exception e) {
			logger.error("Exception while getItemStones : " + e.getMessage());
		}
		return null;
	}
	
	
	
	
	

	@Override
	public List<Inventory1ResponseDTO> inventoryOrderSearch(Inventory1RequestDTO orderDataRequestDTO, int page,
			int size) {

		List<Inventory1ResponseDTO> dataReponseDTOList = new ArrayList<Inventory1ResponseDTO>();
		try {
			Page<Inventory1> pointSaleOrderDataList = 
					
					findiventoryOrderByCriteria(orderDataRequestDTO, page, size);

			if (pointSaleOrderDataList != null && !pointSaleOrderDataList.isEmpty()) {
				pointSaleOrderDataList.forEach((salesOrder) -> {
					Inventory1ResponseDTO dataReponseDTO = new Inventory1ResponseDTO();
					BeanUtils.copyProperties(salesOrder, dataReponseDTO);
					dataReponseDTOList.add(dataReponseDTO);

				});
			} else {
				throw new ResourceNotFoundException("no item found");
			}
		} catch (Exception e) {
			logger.error("Error at Sales order -> search" + e);
			throw new ResourceNotFoundException(e.getMessage());
		}
		return dataReponseDTOList;
	}

	/**
	 * This is the main method which is used to search user dynamically
	 * 
	 * @param CustDataRequestDTO
	 * @return List<CustData>
	 */
	public Page<Inventory1> findiventoryOrderByCriteria(Inventory1RequestDTO orderDataRequestDTO, int page, int size) {
		logger.info("Searching User ..");

		GenericSpesification<Inventory1> genericSpesification = new GenericSpesification<Inventory1>();

		Specification<Inventory1> specification = specificationforJoin(orderDataRequestDTO);

		if (orderDataRequestDTO.getItemCode() != null) {
			genericSpesification
					.add(new SearchCriteria("itemCode", orderDataRequestDTO.getItemCode(), SearchOperation.MATCH));
		} else if (orderDataRequestDTO.getUnitOfMesure() != null) {
			if (orderDataRequestDTO.getSearchItem() != null) {
				if (orderDataRequestDTO.getUnitCharge().equalsIgnoreCase("PIECES")) {
					genericSpesification.add(new SearchCriteria("unitCharge", orderDataRequestDTO.getUnitCharge(),
							SearchOperation.MATCH));
				}
			}
		} /*
			 * else if (orderDataRequestDTO.getInventoryCategory() != null) {
			 * List<InventoryCategory> categoryLIst =
			 * orderDataRequestDTO.getInventoryCategory(); List<String> s = new
			 * ArrayList<String>();
			 * 
			 * for (InventoryCategory invn : categoryLIst) { s.add(invn.getCategory()); }
			 * genericSpesification.add(new SearchCriteria("category", s,
			 * SearchOperation.IN));
			 * 
			 * }
			 * 
			 * else if (orderDataRequestDTO.getBrandDetails() != null) { List<String>
			 * brandDetailsList = orderDataRequestDTO.getBrandDetails(); List<String>
			 * brandDesc = new ArrayList<String>();
			 * 
			 * for (String brandDetails : brandDetailsList) { brandDesc.add(brandDetails); }
			 * genericSpesification.add(new SearchCriteria("brandId", brandDesc,
			 * SearchOperation.IN));
			 * 
			 * }
			 */
		specification.and(genericSpesification);
		return inventoryRepo.findAll(specification, PageRequest.of(page, size));

	}

	private Specification<Inventory1> specificationforJoin(Inventory1RequestDTO orderDataRequestDTO) {
		return new Specification<Inventory1>() {

			@Override
			public Predicate toPredicate(Root<Inventory1> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();

				if (orderDataRequestDTO.getUnitOfMesure() != null) {
					if (orderDataRequestDTO.getSearchItem() != null) {
						Join<Inventory1, Inventory2> jobJoin = root.join("inventory2", JoinType.INNER);

						predicates.add(criteriaBuilder
								.or(criteriaBuilder.equal(jobJoin.get("dept"), orderDataRequestDTO.getSearchItem())));
					}
				}
//				if (orderDataRequestDTO.getsDate() != null && orderDataRequestDTO.getEndDate() != null) {
//					predicates.add(criteriaBuilder.between(root.get("dateSaved"),
//							orderDataRequestDTO.getsDate(),
//							orderDataRequestDTO.getEndDate()));
//				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

			}
		};

	}
	
	
	
	
	
	
	
	
	
}
