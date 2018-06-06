package service;

import java.util.ArrayList;

import bean.SaleInfo;
import dao.SaleInfoDao;

public class SaleInfoService {

	// 成员
	private SaleInfoDao saleInfoDao = new SaleInfoDao();

	/**
	 * 删除
	 * 
	 * @param SaleInfo
	 * @return
	 */
	public boolean deletegoodsInfo(SaleInfo saleInfo) throws Exception {
		boolean flag = false;
		int count = saleInfoDao.DeleteSaleInfo(saleInfo);
		// 业务
		if (count > 0) {
			flag = true;
		}
		return flag;

	}

	/**
	 * 查询所有
	 * 
	 * @param userinfo
	 * @return
	 * @throws Exception
	 */
	public ArrayList<SaleInfo> getSaleInfo() throws Exception {

		return saleInfoDao.getSaleInfo();

	}

	/**
	 * 饼状图查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<SaleInfo> getPieSaleInfo() throws Exception {

		return saleInfoDao.getPieSaleInfo();

	}
	/**
	 * 折线图查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<SaleInfo> getCategorySaleInfo() throws Exception {

		return saleInfoDao.getCategorySaleInfo();

	}

	/**
	 * 添加用户对象
	 * 
	 * @param goodsinfo
	 *            用户对象
	 * @return boolean
	 * @throws Exception
	 */
	public boolean addsaleInfo(SaleInfo saleinfo) throws Exception {
		boolean flag = false;

		int count = saleInfoDao.addsaleInfo(saleinfo);
		// 业务
		if (count > 0) {
			flag = true;
		}
		return flag;

	}

	/**
	 * 查询
	 * 
	 * @param saleinfo
	 * @return
	 * @throws Exception
	 */
	public ArrayList<SaleInfo> selectSaleinfo(SaleInfo saleinfo)
			throws Exception {
		return saleInfoDao.selectSaleinfo(saleinfo);
	}
	

	/**
	 * 减少库存
	 * 
	 * @param goodsinfo
	 * @return
	 * @throws Exception 
	 */
	public boolean updategoodsStock(SaleInfo saleinfo) throws Exception {
		boolean flag = false;

		int count = saleInfoDao.updategoodsStock(saleinfo);
		// 业务
		if (count > 0) {
			flag = true;
		}
		return flag;

	}

}
