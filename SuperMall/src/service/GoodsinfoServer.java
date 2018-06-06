package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.GoodsInfoDao;
import bean.Goodsinfo;

/**
 * goodsinfoҵ�������
 * 
 * @author Administrator
 * 
 */
public class GoodsinfoServer {
	// ��Ա
	private GoodsInfoDao goodsInfoDao = new GoodsInfoDao();
	/****
	 * �ɹ��������Ʒ��������
	 */
	public int addGoodsInfo1(Goodsinfo goodsinfo) throws Exception {


	return goodsInfoDao.addgoodsInfo1(goodsinfo);
		

	}

	/**
	 * �ɹ������Ϣ�޸�
	 * @param goodsinfo
	 * @return
	 * @throws Exception 
	 */
	public boolean updategoodsInfo1(Goodsinfo goodsinfo) throws Exception {
		boolean flag = false;

		int count = goodsInfoDao.updategoodsInfo1(goodsinfo);
		// ҵ��
		if (count > 0) {
			flag = true;
		}
		return flag;

	}



	

	/**
	 * �ɹ������Ϣ�˶�
	 * @param goodsinfo
	 * @return
	 * @throws Exception 
	 */
	public Goodsinfo getgoodsInfo1(Goodsinfo goodsinfo) throws Exception {
		
		return  goodsInfoDao.getGoodsinfo1(goodsinfo);
		

	}
	
	/**
	 * ����û�����
	 * 
	 * @param goodsinfo
	 *            �û�����
	 * @return boolean
	 * @throws Exception 
	 */
	
	public boolean addgoodsInfo(Goodsinfo goodsinfo) throws Exception {
		boolean flag = false;

		int count = goodsInfoDao.addgoodsInfo(goodsinfo);
		// ҵ��
		if (count > 0) {
			flag = true;
		}
		return flag;

	}

	/**
	 * 
	 * @param goodsinfo
	 * @return
	 * @throws Exception 
	 */
	public boolean updategoodsInfo(Goodsinfo goodsinfo) throws Exception {
		boolean flag = false;

		int count = goodsInfoDao.updategoodsInfo(goodsinfo);
		// ҵ��
		if (count > 0) {
			flag = true;
		}
		return flag;

	}

	/**
	 * 
	 * @param goodsinfo
	 * @return
	 */
	public boolean deletegoodsInfo(Goodsinfo goodsinfo) throws Exception{
		boolean flag = false;
		int count = goodsInfoDao.DeleteGoodsInfo(goodsinfo);
		// ҵ��
		if (count > 0) {
			flag = true;
		}
		return flag;

	}
	/**
	 * 
	 * @param goodsinfo
	 * @return
	 * @throws Exception 
	 */
	public ArrayList<Goodsinfo>  getgoodsInfo() throws Exception {
		
		return goodsInfoDao.getgoodsinfo();
	}

	/**
	 * 
	 * @param goodsinfo
	 * @return
	 * @throws Exception 
	 */
	public Goodsinfo getgoodsInfo(Goodsinfo goodsinfo) throws Exception {
		
		return  goodsInfoDao.getgoodsinfo(goodsinfo);
		

	}
	
	public ArrayList<Goodsinfo> selectgoodsinfo(Goodsinfo goodsinfo) throws Exception
	{
		return goodsInfoDao.selectgoodsinfo(goodsinfo);
	}
}
