package service;

import java.util.ArrayList;

import bean.Goodsinfo;
import bean.InproInfo;
import dao.GoodsInfoDao;
import dao.InproInfoDao;

/***
 * InproInfo表的业务服务类
 * @author Administrator
 *
 */

public class InproInfoService {
	private InproInfoDao inproInfoDao = new InproInfoDao();

	/**
	 * 添加订单信息
	 * 
	 * @param inproInfo
	 *            用户对象
	 * @return boolean
	 * @throws Exception 
	 */
	public boolean addInproInfo(InproInfo inproInfo) throws Exception {
		boolean flag = false;

		int count = inproInfoDao.addInproInfo(inproInfo);
		// 业务
		if (count > 0) {
			flag = true;
		}
		return flag;

	}
	/**
	 * 删除订单信息
	 * @param SaleInfo
	 * @return
	 */
	public boolean deleteInproInfo(InproInfo inproInfo) throws Exception{
		boolean flag = false;
		int count = inproInfoDao.DeleteInproInfo(inproInfo);
		// 业务
		if (count > 0) {
			flag = true;
		}
		return flag;

	}


	/**修改订单信息
	 * 
	 * @param inproInfo
	 * @return
	 * @throws Exception 
	 */
	public boolean updateInproInfo(InproInfo inproInfo) throws Exception {
		boolean flag = false;

		int count = inproInfoDao.updateInproInfo(inproInfo);
		// 业务
		if (count > 0) {
			flag = true;
		}
		return flag;

	}

	
//
//	/**
//	 * 
//	 * @param goodsinfo
//	 * @return
//	 * @throws Exception 
//	 */
//	public ArrayList<Goodsinfo>  getgoodsInfo() throws Exception {
//		
//		return goodsInfoDao.getgoodsinfo();
//	}

	/**
	 * 根据商家编号得到商品编号
	 * @param goodsinfo
	 * @return
	 * @throws Exception 
	 */
//	public InproInfo getInproInfo(InproInfo inproInfo) throws Exception {
//		
//		return  inproInfoDao.getinproInfo(inproInfo);
//		
//
//	}
	/**
	 * 
	 * @param goodsinfo
	 * @return
	 * @throws Exception 
	 */
	public ArrayList<InproInfo>  getInproInfo() throws Exception {
		
		return inproInfoDao.getInproInfo();
	}

//	
//	public ArrayList<Goodsinfo> selectgoodsinfo(Goodsinfo goodsinfo) throws Exception
//	{
//		return goodsInfoDao.selectgoodsinfo(goodsinfo);
//	}
//	

}
