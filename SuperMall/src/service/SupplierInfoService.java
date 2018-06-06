package service;

import java.util.ArrayList;


import dao.GoodsInfoDao;
import dao.SupplierInfoDao;

import bean.Goodsinfo;

import bean.SupplierInfo;

/***
 * SupplierInfo供货商表的业务操作类
 * 
 * @author Administrator
 * 
 */

public class SupplierInfoService {
	SupplierInfoDao supplierInfoDao = new SupplierInfoDao();

	public ArrayList<SupplierInfo> getSupplierInfos(Goodsinfo goodsinfo)
			throws Exception {
		return supplierInfoDao.selectSupplierInfo(goodsinfo);

	}
//	/***
//	 * 根据商品名相同对比出goodsid
//	 * @param supplierInfo
//	 * @return
//	 * @throws Exception
//	 */
//	public ArrayList<GoodsinfoSupplierinfo> getGoodsinfoSupplierinfo(GoodsinfoSupplierinfo goodsinfoSupplierinfo) throws Exception{
//		return supplierInfoDao.getGoodsinfoSupplierinfo(goodsinfoSupplierinfo);
//	}
	private GoodsInfoDao goodsInfoDao = new GoodsInfoDao();

	/**
	 * 添加供货商对象
	 * 
	 * @param supplierInfo
	 *            供货商对象
	 * @return boolean
	 * @throws Exception 
	 */
	public boolean addSupplierinfo(SupplierInfo supplierInfo) throws Exception {
		boolean flag = false;

		int count = supplierInfoDao.addSupplierinfo(supplierInfo);
		// 业务
		if (count > 0) {
			flag = true;
		}
		return flag;

	}

}
