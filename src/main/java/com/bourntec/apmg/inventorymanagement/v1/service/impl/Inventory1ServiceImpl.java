package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.Inventory1;
import com.bourntec.apmg.entity.Inventory2;
import com.bourntec.apmg.entity.InventoryCategory;
import com.bourntec.apmg.entity.MarketCode;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.Inventory1RequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.Inventory1ResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.inventorymanagement.v1.repository.Inventory1Repository;
import com.bourntec.apmg.inventorymanagement.v1.service.Inventory1Service;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.inventorymanagement.v1.searchspec.SearchOperation;

/**
 * 
 * Service class implementation for inventory1
 * 
 * @author Srijini
 *
 */
@Service(value = "Inventory1ServiceImpl")
public class Inventory1ServiceImpl implements Inventory1Service {

	private static final Logger logger = LogManager.getLogger(Inventory1ServiceImpl.class);

	@Autowired
	Inventory1Repository inventoryRepo;

	/*
	 * @Override public List<Inventory1ResponseDTO>
	 * inventoryOrderSearch(Inventory1RequestDTO inventory1RequestDTO, int page, int
	 * size) throws Exception { List<Inventory1ResponseDTO> dataReponseDTOList = new
	 * ArrayList<Inventory1ResponseDTO>(); try { Page<Inventory1>
	 * pointSaleOrderDataList =
	 * 
	 * findiventoryOrderByCriteria(inventory1RequestDTO, page, size);
	 * 
	 * if (pointSaleOrderDataList != null && !pointSaleOrderDataList.isEmpty()) {
	 * pointSaleOrderDataList.forEach((salesOrder) -> { Inventory1ResponseDTO
	 * dataReponseDTO = new Inventory1ResponseDTO();
	 * BeanUtils.copyProperties(salesOrder, dataReponseDTO);
	 * dataReponseDTOList.add(dataReponseDTO);
	 * 
	 * }); } else { throw new ResourceNotFoundException("no item found"); } } catch
	 * (Exception e) { logger.error("Error at Sales order -> search" + e); throw new
	 * ResourceNotFoundException(e.getMessage()); } return dataReponseDTOList; }
	 */

	/**
	 * This is the main method which is used to search user dynamically
	 * 
	 * @param CustDataRequestDTO
	 * @return List<CustData>
	 */
	/*
	 * public Page<Inventory1> findiventoryOrderByCriteria(Inventory1RequestDTO
	 * orderDataRequestDTO, int page, int size) { logger.info("Searching User ..");
	 * 
	 * GenericSpesification<Inventory1> genericSpesification = new
	 * GenericSpesification<Inventory1>();
	 * 
	 * Specification<Inventory1> specification =
	 * specificationforJoin(orderDataRequestDTO);
	 * 
	 * if (orderDataRequestDTO.getItemCode() != null) { genericSpesification
	 * .add(new SearchCriteria("itemCode", orderDataRequestDTO.getItemCode(),
	 * SearchOperation.MATCH)); } else if (orderDataRequestDTO.getUnitOfMesure() !=
	 * null) { if (orderDataRequestDTO.getSearchItem() != null) { if
	 * (orderDataRequestDTO.getUnitCharge().equalsIgnoreCase("PIECES")) {
	 * genericSpesification.add(new SearchCriteria("unitCharge",
	 * orderDataRequestDTO.getUnitCharge(), SearchOperation.MATCH)); } } } else if
	 * (orderDataRequestDTO.getInventoryCategory() != null) {
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
	 * } specification.and(genericSpesification); return
	 * inventoryRepo.findAll(specification, PageRequest.of(page, size));
	 * 
	 * }
	 * 
	 * private Specification<Inventory1> specificationforJoin(Inventory1RequestDTO
	 * orderDataRequestDTO) { return new Specification<Inventory1>() {
	 * 
	 * @Override public Predicate toPredicate(Root<Inventory1> root,
	 * CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) { List<Predicate>
	 * predicates = new ArrayList<>();
	 * 
	 * if (orderDataRequestDTO.getUnitOfMesure() != null) { if
	 * (orderDataRequestDTO.getSearchItem() != null) { Join<Inventory1, Inventory2>
	 * jobJoin = root.join("inventory2", JoinType.INNER);
	 * 
	 * predicates.add(criteriaBuilder .or(criteriaBuilder.equal(jobJoin.get("dept"),
	 * orderDataRequestDTO.getSearchItem()))); } } if
	 * (orderDataRequestDTO.getsDate() != null && orderDataRequestDTO.getEndDate()
	 * != null) { predicates.add(criteriaBuilder.between(root.get("dateSaved"),
	 * orderDataRequestDTO.getsDate(), orderDataRequestDTO.getEndDate())); } return
	 * criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	 * 
	 * } };
	 * 
	 * }
	 */
	@Override
	public Inventory1ResponseDTO saveInvetoryData(Inventory1RequestDTO inv1ReqDTO) throws Exception {
		Inventory1ResponseDTO inv1RespDTO = new Inventory1ResponseDTO();
		try {

			logger.info("Going to save inventory");
			if (inv1ReqDTO.getItemCode() != null) {
				Inventory1 invEntity = inv1ReqDTO.toModel(inv1ReqDTO);
				invEntity.setDateSaved(new Date());
				Inventory1 inventory1ReturnObj = inventoryRepo.save(invEntity);

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
				inv1RespDTO.setResponseMessage("Item not exsist in Inventory ,save inventory  failed");
			}

		} catch (Exception e) {
			logger.error("saveInvetoryData :service Impl " + e);

		}

		return inv1RespDTO;
	}

	@Override
	public Inventory1 findByInvItemId(String invId) throws Exception {
		Inventory1 inventory1 = new Inventory1();
		try {
			Optional<Inventory1> inventory1List = inventoryRepo.findById(invId);
			if (inventory1List != null && inventory1List.isPresent()) {
				inventory1 = inventory1List.get();
			}

		} catch (BeansException e) {
			throw e;
		}
		return inventory1;
	}

	@Override
	@Transactional
	public Inventory1ResponseDTO updateInv(String invId, Inventory1RequestDTO reqDTO) throws Exception {
		Inventory1 inventory1 = new Inventory1();
		try {
			inventory1 = reqDTO.toModel(reqDTO);
			inventoryRepo.save(inventory1);
		} catch (Exception e) {
			logger.error("updateInv :service Impl " + e);
			throw e;
		}
		return null;
	}

	@Override
	public List<Inventory1> inventory1Search(Inventory1RequestDTO inventory1RequestDTO)
			throws Exception {
		GenericSpesification<Inventory1> genericSpesification = new GenericSpesification<Inventory1>();
		try {
			if (inventory1RequestDTO.getItemCode() != null && !inventory1RequestDTO.getItemCode().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("itemCode", inventory1RequestDTO.getItemCode(), SearchOperation.EQUAL));
			}
			if (inventory1RequestDTO.getUnitCharge() != null && !inventory1RequestDTO.getUnitCharge().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("unitCharge", inventory1RequestDTO.getUnitCharge(), SearchOperation.MATCH));
			}
			if (inventory1RequestDTO.getAppraisal() != null && !inventory1RequestDTO.getAppraisal().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("appraisal", inventory1RequestDTO.getAppraisal(), SearchOperation.MATCH));
			}
			if (inventory1RequestDTO.getAvgDispPrc() != null ) {
				genericSpesification
						.add(new SearchCriteria("avgDispPrc", inventory1RequestDTO.getAvgDispPrc(), SearchOperation.EQUAL));
			}
			if (inventory1RequestDTO.getBrandId() != null ) {
				genericSpesification
						.add(new SearchCriteria("brandId", inventory1RequestDTO.getBrandId(), SearchOperation.EQUAL));
			}
			if (inventory1RequestDTO.getBrokenPieces() != null ) {
				genericSpesification
						.add(new SearchCriteria("brokenPieces", inventory1RequestDTO.getBrokenPieces(), SearchOperation.EQUAL));
			}
			if (inventory1RequestDTO.getCategory() != null && !inventory1RequestDTO.getCategory().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("category", inventory1RequestDTO.getCategory(), SearchOperation.MATCH));
			}
			if (inventory1RequestDTO.getCertificate() != null && !inventory1RequestDTO.getCertificate().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("certificate", inventory1RequestDTO.getCertificate(), SearchOperation.MATCH));
			}
			if (inventory1RequestDTO.getConfirmOrderP() != null) {
				genericSpesification
						.add(new SearchCriteria("confirmOrderP", inventory1RequestDTO.getConfirmOrderP(), SearchOperation.EQUAL));
			}
			if (inventory1RequestDTO.getConfirmOrderW() != null) {
				genericSpesification
						.add(new SearchCriteria("confirmOrderW", inventory1RequestDTO.getConfirmOrderW(), SearchOperation.EQUAL));
			}
			if (inventory1RequestDTO.getCostPc() != null ) {
				genericSpesification
						.add(new SearchCriteria("costPc", inventory1RequestDTO.getCostPc(), SearchOperation.EQUAL));
			}
			if (inventory1RequestDTO.getCurrentExOrdPc() != null) {
				genericSpesification
						.add(new SearchCriteria("currentExOrdPc", inventory1RequestDTO.getCurrentExOrdPc(), SearchOperation.EQUAL));
			}
			if (inventory1RequestDTO.getDatabaseLocal() != null && !inventory1RequestDTO.getDatabaseLocal().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("databaseLocal", inventory1RequestDTO.getDatabaseLocal(), SearchOperation.MATCH));
			}
			if (inventory1RequestDTO.getDateSaved() != null ) {
				genericSpesification
						.add(new SearchCriteria("dateSaved", inventory1RequestDTO.getDateSaved(), SearchOperation.EQUAL));
			}
			if (inventory1RequestDTO.getDescription1() != null && !inventory1RequestDTO.getDescription1().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("description1", inventory1RequestDTO.getDescription1(), SearchOperation.MATCH));
			}
			if (inventory1RequestDTO.getDesignImage() != null && !inventory1RequestDTO.getDesignImage().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("designImage", inventory1RequestDTO.getDesignImage(), SearchOperation.MATCH));
			}
			if (inventory1RequestDTO.getDiscountEnd() != null ) {
				genericSpesification
						.add(new SearchCriteria("discountEnd", inventory1RequestDTO.getDiscountEnd(), SearchOperation.EQUAL));
			}
			if (inventory1RequestDTO.getDiscountPercent() != null ) {
				genericSpesification
						.add(new SearchCriteria("discountPercent", inventory1RequestDTO.getDiscountPercent(), SearchOperation.EQUAL));
			}
			if (inventory1RequestDTO.getDiscountStart() != null ) {
				genericSpesification
						.add(new SearchCriteria("discountStart", inventory1RequestDTO.getDiscountStart(), SearchOperation.EQUAL));
			}
			if (inventory1RequestDTO.getDisplayWeb() != null && !inventory1RequestDTO.getDisplayWeb().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("displayWeb", inventory1RequestDTO.getDisplayWeb(), SearchOperation.MATCH));
			}
			if (inventory1RequestDTO.getDrawNo() != null && !inventory1RequestDTO.getDrawNo().isEmpty()) {
				genericSpesification
						.add(new SearchCriteria("drawNo", inventory1RequestDTO.getDrawNo(), SearchOperation.MATCH));
			}
			
			return inventoryRepo.findAll(genericSpesification);

		} catch (Exception e) {
			logger.error("MarketCodeServiceImpl findByCriteria failed" + e);
			throw e;
		}

	}
}
