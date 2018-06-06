package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.GoodsInfoDao;
import bean.Goodsinfo;

/**
 * goodsinfo业务服务类
 * 
 * @author Administrator
 * 
 */
public class GoodsinfoServer {
	// 成员
	private GoodsInfoDao goodsInfoDao = new GoodsInfoDao();
	/****
	 * 采购的添加商品数量方法
	 */
	public int addGoodsInfo1(Goodsinfo goodsinfo) throws Exception {


	return goodsInfoDao.addgoodsInfo1(goodsinfo);
		

	}

	/**
	 * 采购后的信息修改
	 * @param goodsinfo
	 * @return
	 * @throws Exception 
	 */
	public boolean updategoodsInfo1(Goodsinfo goodsinfo) throws Exception {
		boolean flag = false;

		int count = goodsInfoDao.updategoodsInfo1(goodsinfo);
		// 业务
		if (count > 0) {
			flag = true;
		}
		return flag;

	}



	

	/**
	 * 采购后的信息核对
	 * @param goodsinfo
	 * @return
	 * @throws Exception 
	 */
	public Goodsinfo getgoodsInfo1(Goodsinfo goodsinfo) throws Exception {
		
		return  goodsInfoDao.getGoodsinfo1(goodsinfo);
		

	}
	
	/**
	 * 添加用户对象
	 * 
	 * @param goodsinfo
	 *            用户对象
	 * @return boolean
	 * @throws Exception 
	 */
	
	public boolean addgoodsInfo(Goodsinfo goodsinfo) throws Exception {
		boolean flag = false;

		int count = goodsInfoDao.addgoodsInfo(goodsinfo);
		// 业务
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
		// 业务
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
		// 业务
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
