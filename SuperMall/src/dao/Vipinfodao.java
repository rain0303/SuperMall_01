package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import db.DbUtil;
import bean.Vipinfo;

public class Vipinfodao {
	/**
	 * 获取所有会员信息
	 * 
	 * @return ArrayList<Vipinfo>
	 * @throws Exception
	 */
	public ArrayList<Vipinfo> getAllVipinfo() throws Exception {
		ArrayList<Vipinfo> vipinfos = new ArrayList<Vipinfo>();
		try {
			String sql = "select vipid,vipname,vipsex,vipcut from vipinfo";
			ResultSet rs = DbUtil.executeQuery(sql, null);

			while (rs.next()) {
				Vipinfo vipinfo = new Vipinfo();
				vipinfo.setVipid(rs.getInt("vipid"));
				vipinfo.setVipname(rs.getString("vipname"));
				vipinfo.setVipsex(rs.getString("vipsex"));
				vipinfo.setVipcut(rs.getString("vipcut"));

				vipinfos.add(vipinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("数据操作异常");
		}
		return vipinfos;
	}

	/**
	 * 增
	 * 
	 * @param vipinfo
	 * @return int
	 * @throws Exception
	 */

	public int addVipinfo(Vipinfo vipinfo) throws Exception {
		int count = 0;
		try {
		
				String sql = "insert into vipinfo (vipname,vipsex,vipcut) values(?,?,?)";
				ArrayList<Object> paramrs = new ArrayList<Object>();
				paramrs.add(vipinfo.getVipname());
				paramrs.add(vipinfo.getVipsex());
				paramrs.add(vipinfo.getVipcut());

				count = DbUtil.executeUpdate(sql, paramrs);
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("数据操作异常");
		}
		return count;
	}

	/**
	 * 删
	 * 
	 * @param vipinfo
	 * @return
	 */

	public int deleteVipinfo(Vipinfo vipinfo) throws Exception {
		int count = 0;
		// sql

		try {
			String sql = "DELETE FROM vipinfo where vipid=?";
			ArrayList<Object> paramrs = new ArrayList<Object>();
			paramrs.add(vipinfo.getVipid());
			// JDBC
			count = DbUtil.executeUpdate(sql, paramrs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace(); 当前方法处理异常
			// 方法的调用者 <=>Exception 项目 自定义异常类型
			throw new Exception("数据操作异常");
		}
		return count;
	}

	/**
	 * 改
	 * 
	 * @param vipinfo
	 * @return int
	 * @throws Exception
	 */
	public int updateVipinfo(Vipinfo vipinfo) throws Exception {
		int count = 0;
		try {
			String sql = "update vipinfo set vipname=? ,vipsex=? ,vipcut=? where vipid=?";
			ArrayList<Object> paramrs = new ArrayList<Object>();

			paramrs.add(vipinfo.getVipname());
			paramrs.add(vipinfo.getVipsex());
			paramrs.add(vipinfo.getVipcut());
			paramrs.add(vipinfo.getVipid());
			count = DbUtil.executeUpdate(sql, paramrs);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			throw new Exception("数据操作异常");
		}
		return count;
	}

	/**
	 * 查
	 * 
	 * @param vipinfo
	 * @return Vipinfo
	 * @throws Exception
	 */
	public ArrayList<Vipinfo> getVipinfo(Vipinfo vipinfo) throws Exception {
		ArrayList<Vipinfo> vipinfos = new ArrayList<Vipinfo>();
		StringBuffer sql = new StringBuffer(
				"select vipid,vipname,vipsex,vipcut from vipinfo where 1=1");
		ArrayList<Object> paramrs = new ArrayList<Object>();
		if (vipinfo.getVipid() != 0) {
			sql.append(" and vipid=? ");
			paramrs.add(vipinfo.getVipid());
		}

		if (!vipinfo.getVipname().equals("")) {
			sql.append(" and vipname like ? ");
			paramrs.add("%" + vipinfo.getVipname() + "%");
		}

		
		if (vipinfo.getVipsex() != null) {

			sql.append(" and vipsex=? ");
			paramrs.add(vipinfo.getVipsex());
		}

		if (vipinfo.getVipcut() != null) {
			sql.append(" and vipcut=? ");
			paramrs.add(vipinfo.getVipcut());
		}


		ResultSet rs = DbUtil.executeQuery(sql.toString(), paramrs);
		try {
			while (rs.next()) {
				vipinfo = new Vipinfo();
				vipinfo.setVipid(rs.getInt("vipid"));
				vipinfo.setVipname(rs.getString("vipname"));
				vipinfo.setVipsex(rs.getString("vipsex"));
				vipinfo.setVipcut(rs.getString("vipcut"));
				vipinfos.add(vipinfo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("数据操作异常");
		}
		return vipinfos;
	}
	public Vipinfo getVipinfo2(Vipinfo vipinfo) throws Exception {
		Vipinfo vipinfos=new Vipinfo();
		StringBuffer sql = new StringBuffer(
				"select vipid,vipname,vipsex,vipcut from vipinfo where 1=1");
		ArrayList<Object> paramrs = new ArrayList<Object>();
		if (vipinfo.getVipid() != 0) {
			sql.append(" and vipid=? ");
			paramrs.add(vipinfo.getVipid());
		}
		


		ResultSet rs = DbUtil.executeQuery(sql.toString(), paramrs);
		try {
			while (rs.next()) {
//				vipinfo = new Vipinfo();
				vipinfos.setVipid(rs.getInt("vipid"));
				vipinfos.setVipname(rs.getString("vipname"));
				vipinfos.setVipsex(rs.getString("vipsex"));
				vipinfos.setVipcut(rs.getString("vipcut"));
			

				break;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("数据操作异常");
		}
		return vipinfos;
	}
}
