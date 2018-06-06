package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.EmpInfoDao;
import bean.Empinfo;;

/**
 * userinfo业务服务类
 * 
 * @author Administrator
 * 
 */
public class EmpinfoServer {
	// 成员
	private EmpInfoDao empInfoDao = new EmpInfoDao();

	
	public Empinfo getEmpInfo(Empinfo empinfo) throws Exception {
		

		return  empInfoDao.getEmpinfo(empinfo);

	}
	
	public boolean addEmpinfo(Empinfo empinfo) throws Exception{
		boolean res=false;
		int count;
		try {
			count=empInfoDao.addEmpinfo(empinfo);
			if(count==1){
				res=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
//	/**
//	 * 删除
//	 */
//	public boolean deleteEmpinfo(Empinfo empinfo) throws Exception{
//		boolean res=false;
//		int count;
//		try {
//			count=empinfodao.deleteEmpinfo(empinfo);
//			if(count>0){
//				res=true;
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return res;
//		
//	}
	/**
	 * 改
	 */
	public boolean updateEmpinfo(Empinfo empinfo,Empinfo empinfo2) throws Exception{
		boolean res=false;
		int count;
		try {
			count=empInfoDao.updateEmpinfo(empinfo,empinfo2);
			if(count>0){
				res=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	/**
	 * 查
	 */
	public ArrayList<Empinfo> selectEmpinfo(Empinfo empinfo) throws Exception{
		ArrayList<Empinfo> res=new ArrayList<Empinfo>();
		try {
			res=empInfoDao.selectEmpinfo(empinfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	public Empinfo selectEmpinfo2(Empinfo empinfo) throws Exception{
		Empinfo res=new Empinfo();
		try {
			res=empInfoDao.selectEmpinfo2(empinfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	/**
	 * 全部查询
	 */
	public ArrayList<Empinfo> selectAllEmpinfo() throws Exception{
		ArrayList<Empinfo> res=new ArrayList<Empinfo>();
		try {
			res=empInfoDao.selectAllEmpinfo();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	
}
