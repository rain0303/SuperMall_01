package service;

import dao.Vipinfodao;
import bean.Vipinfo;
import java.util.ArrayList;

public class VipinfoServer {
	/**
	 * 全部查询
	 */
	public ArrayList<Vipinfo> getAllVipinfo() throws Exception {
		ArrayList<Vipinfo> res = new ArrayList<Vipinfo>();

		res = vipinfodao.getAllVipinfo();

		return res;

	}

	private Vipinfodao vipinfodao = new Vipinfodao();

	/**
	 * 增
	 * 
	 * @param vipinfo
	 * @return boolean
	 * @throws Exception
	 */

	public boolean addVipinfo(Vipinfo vipinfo) throws Exception {
		boolean flag = false;
		int count;

		count = vipinfodao.addVipinfo(vipinfo);
		if (count > 0) {
			flag = true;
		}

		return flag;
	}

	/**
	 * 删
	 * 
	 * @param vipinfo
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteVipinfo(Vipinfo vipinfo) throws Exception {
		boolean flag = false;
		int count = vipinfodao.deleteVipinfo(vipinfo);
		if (count > 0) {
			flag = true;
		}
		return flag;

	}

	/**
	 * 改
	 * 
	 * @param vipinfo
	 * @return boolean
	 * @throws Exception
	 */
	public boolean updateVipinfo(Vipinfo vipinfo) throws Exception {
		boolean flag = false;
		int count = vipinfodao.updateVipinfo(vipinfo);

		if (count > 0) {
			flag = true;
		}

		return flag;
	}

	/**
	 * 查
	 * 
	 * @param userinfo
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Vipinfo> getVipinfo(Vipinfo vipinfo) throws Exception {
		ArrayList<Vipinfo> res = new ArrayList<Vipinfo>();

		res = vipinfodao.getVipinfo(vipinfo);

		return res;

	}
	public Vipinfo getVipinfo2(Vipinfo vipinfo) throws Exception{
		Vipinfo res=new Vipinfo();
		try {
			res=vipinfodao.getVipinfo2(vipinfo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
}
