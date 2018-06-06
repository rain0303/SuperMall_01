package service;

import java.util.ArrayList;

import bean.Goodsinfo;
import bean.InproInfo;
import dao.GoodsInfoDao;
import dao.InproInfoDao;

/***
 * InproInfo���ҵ�������
 * @author Administrator
 *
 */

public class InproInfoService {
	private InproInfoDao inproInfoDao = new InproInfoDao();

	/**
	 * ��Ӷ�����Ϣ
	 * 
	 * @param inproInfo
	 *            �û�����
	 * @return boolean
	 * @throws Exception 
	 */
	public boolean addInproInfo(InproInfo inproInfo) throws Exception {
		boolean flag = false;

		int count = inproInfoDao.addInproInfo(inproInfo);
		// ҵ��
		if (count > 0) {
			flag = true;
		}
		return flag;

	}
	/**
	 * ɾ��������Ϣ
	 * @param SaleInfo
	 * @return
	 */
	public boolean deleteInproInfo(InproInfo inproInfo) throws Exception{
		boolean flag = false;
		int count = inproInfoDao.DeleteInproInfo(inproInfo);
		// ҵ��
		if (count > 0) {
			flag = true;
		}
		return flag;

	}


	/**�޸Ķ�����Ϣ
	 * 
	 * @param inproInfo
	 * @return
	 * @throws Exception 
	 */
	public boolean updateInproInfo(InproInfo inproInfo) throws Exception {
		boolean flag = false;

		int count = inproInfoDao.updateInproInfo(inproInfo);
		// ҵ��
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
	 * �����̼ұ�ŵõ���Ʒ���
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
