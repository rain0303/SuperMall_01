package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import db.DbUtil;
import bean.Empinfo;;

/**
 * userinfo������ݲ�����
 * 
 * @author Administrator
 * 
 */
public class EmpInfoDao {

	/**
	 * �����û���Ϣ�����û�����
	 * 
	 * @param userinfo
	 *            �û�����
	 * @return Userinfo
	 * @throws Exception
	 */
	public int addEmpinfo(Empinfo empinfo) throws Exception {
		int count=0;
		try {
			String sql="insert into empinfo (empId,empName,empPwd,empSex,empAge,empAdd,empTel,empJob) values(?,?,?,?,?,?,?,?)";
			ArrayList<Object> paramrs=new ArrayList<Object>();
			paramrs.add(empinfo.getEmpid());
			paramrs.add(empinfo.getEmpName());
			paramrs.add(empinfo.getEmpPwd());
			paramrs.add(empinfo.getEmpSex());
			paramrs.add(empinfo.getEmpAge());
			paramrs.add(empinfo.getEmpAdd());
			paramrs.add(empinfo.getEmpTel());
			paramrs.add(empinfo.getEmpJob());
			count = DbUtil.executeUpdate(sql, paramrs);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
		
	}
	
	public Empinfo getEmpinfo(Empinfo empinfo) throws Exception {
		Empinfo u = null;
		// ��̬��ѯ
		// 1 ���ڱ���Ĭ��ֵ
		// 2 ��̬����
		// 3 ϸ�� ���������ַ���ƴ��
		/*
		 * String 3�ֳ��� 1 final String �ַ��ܳ����� <=>���� ���� �ַ���+���� �ַ���+�ַ��� 2
		 * StringBuilder,StringBuffer(�̰߳�ȫ) �ַ��ܻ��� Ч�� 3 String s=new String()
		 * �ַ�������
		 */
		StringBuffer sql = new StringBuffer(
				"select empid,empName,empPwd,empjob from empinfo where 1=1");
		ArrayList<Object> paramrs = new ArrayList<Object>();
		if (empinfo.getEmpid() != 0) {
			sql.append(" and empid=? ");
			// ���ò���
			paramrs.add(empinfo.getEmpid());
		}
		// null ""
		if (!empinfo.getEmpName().equals("")) {
			sql.append(" and empName=? ");
			paramrs.add(empinfo.getEmpName());
		}
		if (!empinfo.getEmpPwd().isEmpty()) {
			sql.append(" and empPwd=? ");
			paramrs.add(empinfo.getEmpPwd());
		}
		if (!empinfo.getEmpJob().isEmpty()) {
			sql.append(" and empjob=? ");
			paramrs.add(empinfo.getEmpJob());
		}
		
		ResultSet rs = DbUtil.executeQuery(sql.toString(), paramrs);
		try {
			while (rs.next()) {
				u = new Empinfo();
				u.setEmpid(rs.getInt("empid"));
				u.setEmpName(rs.getString("empName"));
				u.setEmpPwd(rs.getString("empPwd"));
				u.setEmpJob(rs.getString("empJob"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}

		return u;

	}

	/**
	 * ��ȡ�����û�����
	 * 
	 * @return ArrayList<Userinfo>
	 * @throws Exception
	 */
	public int updateEmpinfo(Empinfo empinfo,Empinfo empinfo2)throws Exception {
		int count=0;
		try {
			StringBuffer sql1=new StringBuffer("update empinfo set ");
			ArrayList<Object> paramrs=new ArrayList<Object>();
			
			if (empinfo.getEmpName()!=null) {
				sql1.append(" empName=? ,");
				paramrs.add(empinfo.getEmpName());
			}
			if (empinfo.getEmpPwd()!=null) {
				sql1.append(" empPwd=? ,");
				paramrs.add(empinfo.getEmpPwd());
			}
			if (empinfo.getEmpSex()!=null) {
				sql1.append(" empSex=? ,");
				paramrs.add(empinfo.getEmpSex());
			}
			if (empinfo.getEmpAge() != 0) {
				sql1.append(" empAge=? ,");
				
				paramrs.add(empinfo.getEmpAge());
			}
			if (empinfo.getEmpAdd()!=null) {
				sql1.append(" empAdd=? ,");
				paramrs.add(empinfo.getEmpAdd());
			}
			if (empinfo.getEmpTel()!=null) {
				sql1.append(" empTel=? ,");
				paramrs.add(empinfo.getEmpTel());
			}
			if (empinfo.getEmpJob()!=null) {
				sql1.append(" empJob=? ,");
				paramrs.add(empinfo.getEmpJob());
			}
			int index=sql1.lastIndexOf(",");
			sql1=sql1.deleteCharAt(index);
			StringBuffer sql=new StringBuffer("where 1=1 ");
			sql=sql1.append(sql);
			if (empinfo2.getEmpid() != 0) {
				sql.append(" and empId=? ");
				paramrs.add(empinfo2.getEmpid());
			}
			count = DbUtil.executeUpdate(sql.toString(), paramrs);	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	/**
	 * ��
	 */
	public ArrayList<Empinfo> selectEmpinfo(Empinfo empinfo)throws Exception {
		ArrayList<Empinfo> empinfos=new ArrayList<Empinfo>();
		try {
			StringBuffer sql=new StringBuffer("select empId,empName,empPwd,empSex,empAge,empAdd,empTel,empJob from empinfo where 1=1");
			ArrayList<Object> paramrs = new ArrayList<Object>();
			if (empinfo.getEmpid() != 0) {
				sql.append(" and empId=? ");
				// ���ò���
				paramrs.add(empinfo.getEmpid());
			}
			if (empinfo.getEmpName()!=null) {
				sql.append(" and empName=? ");
				paramrs.add(empinfo.getEmpName());
			}
			if (empinfo.getEmpPwd()!=null) {
				sql.append(" and empPwd=? ");
				paramrs.add(empinfo.getEmpPwd());
			}
			if (empinfo.getEmpSex()!=null) {
				sql.append(" and empSex=? ");
				paramrs.add(empinfo.getEmpSex());
			}
			if (empinfo.getEmpAge() != 0) {
				sql.append(" and empAge=? ");
				
				paramrs.add(empinfo.getEmpAge());
			}
			if (empinfo.getEmpAdd()!=null) {
				sql.append(" and empAdd=? ");
				paramrs.add(empinfo.getEmpAdd());
			}
			if (empinfo.getEmpTel()!=null) {
				sql.append(" and empTel=? ");
				paramrs.add(empinfo.getEmpTel());
			}
			if (empinfo.getEmpJob()!=null) {
				sql.append(" and empJob=? ");
				paramrs.add(empinfo.getEmpJob());
			}

			ResultSet res = DbUtil.executeQuery(sql.toString(), paramrs);
			while(res.next()){
				Empinfo empinfo1=new Empinfo();
				empinfo1.setEmpid(res.getInt("empId"));
				empinfo1.setEmpName(res.getString("empName"));
				empinfo1.setEmpPwd(res.getString("empPwd"));
				empinfo1.setEmpSex(res.getString("empSex"));
				empinfo1.setEmpAge(res.getInt("empAge"));
				empinfo1.setEmpAdd(res.getString("empAdd"));
				empinfo1.setEmpTel(res.getString("empTel"));
				empinfo1.setEmpJob(res.getString("empJob"));
				empinfos.add(empinfo1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empinfos;
		
	}
	/**
	 * ��
	 */
	public Empinfo selectEmpinfo2(Empinfo empinfo)throws Exception {
		Empinfo empinfos=null;
		try {
			StringBuffer sql=new StringBuffer("select empId,empName,empPwd,empSex,empAge,empAdd,empTel,empJob from empinfo where 1=1");
			ArrayList<Object> paramrs = new ArrayList<Object>();
			if (empinfo.getEmpid() != 0) {
				sql.append(" and empId=? ");
				// ���ò���
				paramrs.add(empinfo.getEmpid());
			}
			if (empinfo.getEmpName()!=null) {
				sql.append(" and empName=? ");
				paramrs.add(empinfo.getEmpName());
			}
			if (empinfo.getEmpPwd()!=null) {
				sql.append(" and empPwd=? ");
				paramrs.add(empinfo.getEmpPwd());
			}
			if (empinfo.getEmpSex()!=null) {
				sql.append(" and empSex=? ");
				paramrs.add(empinfo.getEmpSex());
			}
			if (empinfo.getEmpAge() != 0) {
				sql.append(" and empAge=? ");
				
				paramrs.add(empinfo.getEmpAge());
			}
			if (empinfo.getEmpAdd()!=null) {
				sql.append(" and empAdd=? ");
				paramrs.add(empinfo.getEmpAdd());
			}
			if (empinfo.getEmpTel()!=null) {
				sql.append(" and empTel=? ");
				paramrs.add(empinfo.getEmpTel());
			}
			if (empinfo.getEmpJob()!=null) {
				sql.append(" and empJob=? ");
				paramrs.add(empinfo.getEmpJob());
			}


			ResultSet res = DbUtil.executeQuery(sql.toString(), paramrs);
			while(res.next()){
				empinfos=new Empinfo();
				empinfos.setEmpid(res.getInt("empId"));
				empinfos.setEmpName(res.getString("empName"));
				empinfos.setEmpPwd(res.getString("empPwd"));
				empinfos.setEmpSex(res.getString("empSex"));
				empinfos.setEmpAge(res.getInt("empAge"));
				empinfos.setEmpAdd(res.getString("empAdd"));
				empinfos.setEmpTel(res.getString("empTel"));
				empinfos.setEmpJob(res.getString("empJob"));
				
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empinfos;
		
	}
	/**
	 * ȫ����ѯ
	 */
public ArrayList<Empinfo> selectAllEmpinfo()throws Exception {
	ArrayList<Empinfo> empinfos=new ArrayList<Empinfo>();
	
	try {
		String sql="select empId,empName,empPwd,empSex,empAge,empAdd,empTel,empJob from empinfo";
		ResultSet res=DbUtil.getResultSet(sql);
		while(res.next()){
			Empinfo empinfo=new Empinfo();
			empinfo.setEmpid(res.getInt("empId"));
			empinfo.setEmpName(res.getString("empName"));
			empinfo.setEmpPwd(res.getString("empPwd"));
			empinfo.setEmpSex(res.getString("empSex"));
			empinfo.setEmpAge(res.getInt("empAge"));
			empinfo.setEmpAdd(res.getString("empAdd"));
			empinfo.setEmpTel(res.getString("empTel"));
			empinfo.setEmpJob(res.getString("empJob"));
			empinfos.add(empinfo);



		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return empinfos;
	

}
}
