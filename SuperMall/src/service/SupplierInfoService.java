package service;

import java.util.ArrayList;


import dao.GoodsInfoDao;
import dao.SupplierInfoDao;

import bean.Goodsinfo;

import bean.SupplierInfo;

/***
 * SupplierInfo�����̱��ҵ�������
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
//	 * ������Ʒ����ͬ�Աȳ�goodsid
//	 * @param supplierInfo
//	 * @return
//	 * @throws Exception
//	 */
//	public ArrayList<GoodsinfoSupplierinfo> getGoodsinfoSupplierinfo(GoodsinfoSupplierinfo goodsinfoSupplierinfo) throws Exception{
//		return supplierInfoDao.getGoodsinfoSupplierinfo(goodsinfoSupplierinfo);
//	}
	private GoodsInfoDao goodsInfoDao = new GoodsInfoDao();

	/**
	 * ��ӹ����̶���
	 * 
	 * @param supplierInfo
	 *            �����̶���
	 * @return boolean
	 * @throws Exception 
	 */
	public boolean addSupplierinfo(SupplierInfo supplierInfo) throws Exception {
		boolean flag = false;

		int count = supplierInfoDao.addSupplierinfo(supplierInfo);
		// ҵ��
		if (count > 0) {
			flag = true;
		}
		return flag;

	}

}
