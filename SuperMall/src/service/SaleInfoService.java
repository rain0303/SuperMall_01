package service;

import java.util.ArrayList;

import bean.SaleInfo;
import dao.SaleInfoDao;

public class SaleInfoService {

	// ��Ա
	private SaleInfoDao saleInfoDao = new SaleInfoDao();

	/**
	 * ɾ��
	 * 
	 * @param SaleInfo
	 * @return
	 */
	public boolean deletegoodsInfo(SaleInfo saleInfo) throws Exception {
		boolean flag = false;
		int count = saleInfoDao.DeleteSaleInfo(saleInfo);
		// ҵ��
		if (count > 0) {
			flag = true;
		}
		return flag;

	}

	/**
	 * ��ѯ����
	 * 
	 * @param userinfo
	 * @return
	 * @throws Exception
	 */
	public ArrayList<SaleInfo> getSaleInfo() throws Exception {

		return saleInfoDao.getSaleInfo();

	}

	/**
	 * ��״ͼ��ѯ
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<SaleInfo> getPieSaleInfo() throws Exception {

		return saleInfoDao.getPieSaleInfo();

	}
	/**
	 * ����ͼ��ѯ
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<SaleInfo> getCategorySaleInfo() throws Exception {

		return saleInfoDao.getCategorySaleInfo();

	}

	/**
	 * ����û�����
	 * 
	 * @param goodsinfo
	 *            �û�����
	 * @return boolean
	 * @throws Exception
	 */
	public boolean addsaleInfo(SaleInfo saleinfo) throws Exception {
		boolean flag = false;

		int count = saleInfoDao.addsaleInfo(saleinfo);
		// ҵ��
		if (count > 0) {
			flag = true;
		}
		return flag;

	}

	/**
	 * ��ѯ
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
	 * ���ٿ��
	 * 
	 * @param goodsinfo
	 * @return
	 * @throws Exception 
	 */
	public boolean updategoodsStock(SaleInfo saleinfo) throws Exception {
		boolean flag = false;

		int count = saleInfoDao.updategoodsStock(saleinfo);
		// ҵ��
		if (count > 0) {
			flag = true;
		}
		return flag;

	}

}
