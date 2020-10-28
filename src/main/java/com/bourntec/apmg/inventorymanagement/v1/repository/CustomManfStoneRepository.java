package com.bourntec.apmg.inventorymanagement.v1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bourntec.apmg.inventorymanagement.v1.dto.response.CustomManfStoneResponseDTO;

/**
 * @author Srijini
 *
 */
@Repository
public class CustomManfStoneRepository {

	@PersistenceContext
	private EntityManager entityManager;
	/**
	 * @Author:Srijini AP-130 - > AP-239 Inventory Edit unit of measure finished
	 *                 jewelry - Stones
	 * 
	 *                 End point for list all finding of corresponding item
	 * 
	 * @param itemCode
	 * @return ResponseEntity<List<CustomManfStoneResponseDTO>>
	 */
	public List<CustomManfStoneResponseDTO> getManfStone(String jobNo) {
		String manfStoneQry = "SELECT mss.itemCode as itemCode "
				+ ",inv2.specification as specification,"
				+ "inv1.salesPrice as salesPrice,ic.desc1 as desc1,cs.shapeName as shape,ccr.colorName as color, "
				+ "cc.clarityName as clarity,cst.settingName as setting," 
				
				+ "coalesce(mnf.noPcInP,0) as mntPcs,"
				+ "CAST(coalesce(mss.noStoneInP/(coalesce(mnf.noPcInP,0)),0)AS int) as pieces,"
				+ "coalesce(mss.noStoneInW/coalesce(mnf.noPcInP,0),0) as weight,"
				
				+ "ccon.countryName  as locationCode " 
				+ "FROM ManfStone mss "
				+ "inner join Manufacture mnf on mnf.jobNo=mss.jobNo "
				+ "left join InvStone ins on ins.itemCode=mss.itemCode "
				+ "left join CodeClarity cc on cc.clarityId=ins.stoneClarity "
				+ "left join CodesColor ccr on ccr.colorId=ins.stoneColor "
				+ "left join CodesShapes cs on cs.shapeId=ins.stoneShape "
				+ "left join Inventory2 inv2 on inv2.itemCode=mss.itemCode "
				+ "left join Inventory1 inv1 on inv1.itemCode=mss.itemCode "
				+ "left join CodesSetting cst on cst.settingId=inv1.setting "
				+ "left join InventoryCategory ic on ic.category=inv1.category "
				+ "left join CodesCountry ccon on ccon.countryCode=inv2.stoneOrgin " 
				+ "where mss.jobNo='" + jobNo
				+ "' order by mss.itemCode asc";
		Query query = entityManager.createQuery(manfStoneQry);
		return query.getResultList();
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
	public List<CustomManfStoneResponseDTO> getMMStone(String jobNo) {
		String manfStoneQry = "SELECT mss.itemCode as itemCode,inv2.specification as specification,"
				+ "inv1.salesPrice as salesPrice,ic.desc1 as desc1,cs.shapeName as shape,ccr.colorName as color, "
				+ "cc.clarityName as clarity,cst.settingName as setting,"
				+ "coalesce(mnf.noPcInP,0) as mntPcs,"
				+ "CAST(coalesce(mss.pieces/(coalesce(mnf.noPcInP,0)),0)AS int) as pieces,"
				+ "coalesce(mss.weight/coalesce(mnf.noPcInP,0),0) as weight, "
				+ "ccon.countryName as locationCode "
				+ ",mss.stoneId as stoneId "
				+ "FROM ManufactureMMStone mss "
				+ "inner join Manufacture mnf on mnf.jobNo=mss.jobNo "
				+ "left join InvStone ins on ins.itemCode=mss.itemCode "
				+ "left join CodeClarity cc on cc.clarityId=ins.stoneClarity "
				+ "left join CodesColor ccr on ccr.colorId=ins.stoneColor "
				+ "left join CodesShapes cs on cs.shapeId=ins.stoneShape "
				+ "left join Inventory2 inv2 on inv2.itemCode=mss.itemCode "
				+ "left join Inventory1 inv1 on inv1.itemCode=mss.itemCode "
				+ "left join CodesSetting cst on cst.settingId=inv1.setting "
				+ "left join InventoryCategory ic on ic.category=inv1.category "
				+ "left join CodesCountry ccon on ccon.countryCode=inv2.stoneOrgin " 
				+ "where mss.jobNo='" + jobNo
				+ "' order by mss.itemCode asc ";
		Query query = entityManager.createQuery(manfStoneQry);
		return query.getResultList();
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
	public List<CustomManfStoneResponseDTO> getSmalltone(String itemCode) {
		String manfStoneQry = "SELECT mss.itemCode as itemCode,mss.stoneId as stoneId,inv2.specification as specification,"
				+ "inv1.salesPrice as salesPrice,ic.desc1 as desc1,cs.shapeName as shape,ccr.colorName as color, "
				+ "cc.clarityName as clarity,cst.settingName as setting,"

				+ "coalesce(mnf.noPcInP,0) as mntPcs,"
				+ "CAST(coalesce(mss.pieces/(coalesce(mnf.noPcInP,0)),0)AS int) as pieces,"
				+ "coalesce(mss.weight/coalesce(mnf.noPcInP,0),0) as weight, "

				+ "ccon.countryName  as locationCode "
				+ "FROM ManufactureSmallStone mss "
				+ "inner join Manufacture mnf on mnf.jobNo=mss.jobNo "
				+ "left join InvStone ins on ins.itemCode=mss.itemCode "
				+ "left join CodeClarity cc on cc.clarityId=ins.stoneClarity "
				+ "left join CodesColor ccr on ccr.colorId=ins.stoneColor "
				+ "left join CodesShapes cs on cs.shapeId=ins.stoneShape "
				+ "left join Inventory2 inv2 on inv2.itemCode=mss.itemCode "
				+ "left join Inventory1 inv1 on inv1.itemCode=mss.itemCode "
				+ "left join CodesSetting cst on cst.settingId=inv1.setting "
				+ "left join InventoryCategory ic on ic.category=inv1.category "
				+ "left join CodesCountry ccon on ccon.countryCode=inv2.stoneOrgin " 
				+ "where mss.jobNo='" + itemCode
				+ "' order by mss.itemCode asc ";
		Query query = entityManager.createQuery(manfStoneQry);
		return query.getResultList();
	}
}
