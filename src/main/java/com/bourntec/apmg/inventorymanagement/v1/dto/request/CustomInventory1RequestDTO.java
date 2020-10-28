package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import java.util.Date;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.Inventory1;
import com.bourntec.apmg.entity.Inventory2;
import com.bourntec.apmg.entity.InventoryCategory;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * Class is used as a data transfer object for inventory  
 * 
 * @author Amal Chandra N A
 *
 */

@Getter
@Setter
@Validated
public class CustomInventory1RequestDTO {

	
	private String itemCode;
	private String description1;
	private Double inStockW;
	private Integer inStockP;
	private String unitCharge;
	private Double costPc;
	private Double multFactor;
	private Double salesPrice;
	private String tax;
	private String status;
	private String type;
	
	private String dummyPrint;
	private Double wtPiece;
	private Double avgDispPrc;
	private Date dateSaved;
	private Double goldPrice;
	private Integer inMemoP;
	private Double inMemoW;
	private Double karat;
	private Integer orderP;
	private Double orderW;
	private Integer confirmOrderP;
	private Double confirmOrderW;
	private String locationCode;
	private String databaseLocal;
	private String imagepath;
	private String category;
	private String productDescription;
	private String rank;
	private Double discountPercent;
	private Date discountStart;
	private Date discountEnd;
	private String jobNo;
	private Double reorderPc;
	private Double reorderWt;
	private String displayWeb;
	private Double excessOrderPc;
	private Double currentExOrdPc;
	private String excessOrderMsg;
	private String glSales;
	private String glSalesReturn;
	private String glSalesDiscount;
	private String glCostSold;
	private String glInventory;
	private String smallImage;
	private String largeImage;
	private String material;
	private String setting;
	private String drawNo;
	private String trayNo;
	private String packing;
	private String leadTime;
	private String designImage;
	private String certificate;
	private String image3;
	private String image4;
	private String image5;
	private String image6;
	private String image3Desc;
	private String image4Desc;
	private String image5Desc;
	private String image6Desc;
	private Integer brokenPieces;
	private Double materialPrice;
	private String appraisal;
	private Double labor;
	private Double thickness;
	private String sellingType;
	private Long lockingType;
	private Long brandId;
	private String limitedOrder;
	private Integer  dummystock;
	
	private List<InventoryCategory> inventoryCategory ;
	private Inventory2 inventory2;
	List<VendorItemMatchRequestDTO> lstvendorItemMatchRequestDTO;
	ProductKeywordRequestDTO productKeywordRequestDTO;
	List<InventoryAlternateRequestDTO> inventoryAlternateRequestDTO;
	List<LibraryItemRequestDTO> libraryItemRequestDTO;
	private List<InventoryMaterialsRequestDTO> invMaterials;
	private List<Double> karatDetails;
	private List<String> brandDetails;
	private String unitOfMesure;
	private String searchItem;
	private Date sDate;
	private Date endDate;
	
	public Inventory1 toModel(CustomInventory1RequestDTO inventory1RequestDTO) {
		Inventory1 inv1 = new Inventory1();
		
		try {
			inv1.setAppraisal(inventory1RequestDTO.getAppraisal());
			inv1.setAvgDispPrc(inventory1RequestDTO.getAvgDispPrc());
			inv1.setBrandId(inventory1RequestDTO.getBrandId());
			inv1.setBrokenPieces(inventory1RequestDTO.getBrokenPieces());
			inv1.setCategory(inventory1RequestDTO.getCategory());
			inv1.setCertificate(inventory1RequestDTO.getCertificate());
			inv1.setConfirmOrderP(inventory1RequestDTO.getConfirmOrderP());
			inv1.setConfirmOrderW(inventory1RequestDTO.getCostPc());
			inv1.setCostPc(inventory1RequestDTO.getCostPc());
			inv1.setCurrentExOrdPc(inventory1RequestDTO.getCurrentExOrdPc());
			inv1.setDatabaseLocal(inventory1RequestDTO.getDatabaseLocal());
			inv1.setDateSaved(inventory1RequestDTO.getDateSaved());
			inv1.setDescription1(inventory1RequestDTO.getDescription1());
			inv1.setDesignImage(inventory1RequestDTO.getDesignImage());
			inv1.setDiscountEnd(inventory1RequestDTO.getDiscountEnd());
			inv1.setDiscountPercent(inventory1RequestDTO.getDiscountPercent());
			inv1.setDiscountStart(inventory1RequestDTO.getDiscountStart());
			inv1.setDisplayWeb(inventory1RequestDTO.getDisplayWeb());
			inv1.setDrawNo(inventory1RequestDTO.getDrawNo());
			inv1.setDummyPrint(inventory1RequestDTO.getDummyPrint());
			inv1.setExcessOrderMsg(inventory1RequestDTO.getExcessOrderMsg());
			inv1.setExcessOrderPc(inventory1RequestDTO.getExcessOrderPc());
			inv1.setGlCostSold(inventory1RequestDTO.getGlCostSold());
			inv1.setGlInventory(inventory1RequestDTO.getGlInventory());
			inv1.setGlSales(inventory1RequestDTO.getGlSales());
			inv1.setGlSalesDiscount(inventory1RequestDTO.getGlSalesDiscount());
			inv1.setGoldPrice(inventory1RequestDTO.getGoldPrice());
			inv1.setImage3(inventory1RequestDTO.getImage3());
			inv1.setImage3Desc(inventory1RequestDTO.getImage3Desc());
			inv1.setImage4(inventory1RequestDTO.getImage4());
			inv1.setImage4Desc(inventory1RequestDTO.getImage4Desc());
			inv1.setImage5(inventory1RequestDTO.getImage5());
			inv1.setImage5Desc(inventory1RequestDTO.getImage5Desc());
			inv1.setImage6(inventory1RequestDTO.getImage6());
			inv1.setImage6Desc(inventory1RequestDTO.getImage6Desc());
			inv1.setImagepath(inventory1RequestDTO.getImagepath());
			inv1.setInMemoP(inventory1RequestDTO.getInMemoP());
			inv1.setInMemoW(inventory1RequestDTO.getInMemoW());
			inv1.setInStockP(inventory1RequestDTO.getInStockP());
			inv1.setInStockW(inventory1RequestDTO.getInStockW());
			inv1.setItemCode(inventory1RequestDTO.getItemCode());
			inv1.setJobNo(inventory1RequestDTO.getJobNo());
			inv1.setKarat(inventory1RequestDTO.getKarat());
			inv1.setLabor(inventory1RequestDTO.getLabor());
			inv1.setLargeImage(inventory1RequestDTO.getLargeImage());
			inv1.setLeadTime(inventory1RequestDTO.getLeadTime());
			inv1.setLimitedOrder(inventory1RequestDTO.getLimitedOrder());
			inv1.setLocationCode(inventory1RequestDTO.getLocationCode());
			inv1.setLockingType(inventory1RequestDTO.getLockingType());
			inv1.setMaterial(inventory1RequestDTO.getMaterial());
			inv1.setMaterialPrice(inventory1RequestDTO.getMaterialPrice());
			inv1.setMultFactor(inventory1RequestDTO.getMultFactor());
			inv1.setOrderP(inventory1RequestDTO.getOrderP());
			inv1.setOrderW(inventory1RequestDTO.getOrderW());
			inv1.setPacking(inventory1RequestDTO.getPacking());
			inv1.setProductDescription(inventory1RequestDTO.getProductDescription());
			inv1.setRank(inventory1RequestDTO.getRank());
			inv1.setReorderPc(inventory1RequestDTO.getReorderPc());
			inv1.setReorderWt(inventory1RequestDTO.getReorderWt());
			inv1.setSalesPrice(inventory1RequestDTO.getSalesPrice());
			inv1.setSellingType(inventory1RequestDTO.getSellingType());
			inv1.setSetting(inventory1RequestDTO.getSetting());
			inv1.setSmallImage(inventory1RequestDTO.getSmallImage());
			inv1.setStatus(inventory1RequestDTO.getStatus());
			inv1.setTax(inventory1RequestDTO.getTax());
			inv1.setThickness(inventory1RequestDTO.getThickness());
			inv1.setTrayNo(inventory1RequestDTO.getTrayNo());
			inv1.setType(inventory1RequestDTO.getType());
			inv1.setUnitCharge(inventory1RequestDTO.getUnitCharge());
			inv1.setWtPiece(inventory1RequestDTO.getWtPiece());			
			
			
			
			
			
			
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return inv1;

	}
}
