package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.Inventory1;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CustomInventory1RequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryMaterialsRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CustomInventory1ResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.CustomInventory1Service;

/**
 * 
 * Service class implementation for CustomInventory1ServiceImpl
 * 
 * @author Srijini
 *
 */
@Service(value = "CustomInventory1ServiceImpl")
public class CustomInventory1ServiceImpl implements CustomInventory1Service {

	private static final Logger logger = LogManager.getLogger(CustomInventory1ServiceImpl.class);

	@Override
	public CustomInventory1ResponseDTO getPriceandWeightfromKarat(CustomInventory1RequestDTO invReqDTO) throws Exception {
		CustomInventory1ResponseDTO invRespDTO = new CustomInventory1ResponseDTO();
		try {
			List<InventoryMaterialsRequestDTO> invMatUsedList = invReqDTO.getInvMaterials();

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
			invReqDTO.setInvMaterials(invMatUsedList);
			BeanUtils.copyProperties(invReqDTO, invRespDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to calculating Materials
	 *         price by weight
	 * @return CustomInventory1ResponseDTO
	 */
	@Override
	public CustomInventory1ResponseDTO getPricefromWeight(CustomInventory1RequestDTO invReqDTO) throws Exception {
		CustomInventory1ResponseDTO invRespDTO = new CustomInventory1ResponseDTO();

		try {
			Inventory1 inv1 = new Inventory1();

			List<InventoryMaterialsRequestDTO> invMatUsedList = invReqDTO.getInvMaterials();
			invMatUsedList.forEach((matObj) -> {
				Double materialPrice = findCostOfInventoryMaterial(matObj, invReqDTO.getBrandId());
				matObj.setPrice(materialPrice);
			});
			invReqDTO.setInvMaterials(invMatUsedList);
			BeanUtils.copyProperties(invReqDTO, invRespDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return invRespDTO;
	}

	@Override
	public CustomInventory1ResponseDTO getPricefromItemCost(CustomInventory1RequestDTO invReqDTO) throws Exception {
		CustomInventory1ResponseDTO invRespDTO = new CustomInventory1ResponseDTO();
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
	 * @return CustomInventory1ResponseDTO
	 */
	@Override
	public CustomInventory1ResponseDTO getPricefromSalesPrice(CustomInventory1RequestDTO invReqDTO) throws Exception {
		CustomInventory1ResponseDTO invRespDTO = new CustomInventory1ResponseDTO();
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
	 * @author amal This is the main method which is used to calculating Materials
	 *         price by weight and karat
	 * @return price
	 */
	private Double findCostOfInventoryMaterial(InventoryMaterialsRequestDTO matObj, Long brandId) {
		double cost = 0d, currentRate = 0d, matKarat = 0d, matWeight = 0d;
		double price_24k, price_18k, price_14k, price_10k, platinum;
		// finding today's gold price
		if (brandId !=null && brandId == 2l) {
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

}
