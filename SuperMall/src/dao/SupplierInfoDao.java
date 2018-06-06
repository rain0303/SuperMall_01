package dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

import db.DbUtil;

import bean.Emp;
import bean.Goodsinfo;

import bean.SupplierInfo;

/***
 * SupplierInfo表的数据操作类
 * 
 * @author Administrator
 * 
 */

public class SupplierInfoDao {

	public ArrayList<SupplierInfo> selectSupplierInfo(Goodsinfo goodsinfo)
			throws Exception {
		ArrayList<SupplierInfo> supplierInfos = new ArrayList<SupplierInfo>();

		StringBuffer sql = new StringBuffer(
				"SELECT  did,dname,dtel,demail,dadd,goodsName,goodsCategoryId,goodspictures from supplierinfo  where 1=1 ");
		ResultSet rs = null;
		if (goodsinfo != null) {
			ArrayList<Object> paramrs = new ArrayList<Object>();

			if (!goodsinfo.getGoodsName().equals("")) {
				sql.append("and goodsName like ? ");
				paramrs.add("%" + goodsinfo.getGoodsName() + "%");

			}

			rs = DbUtil.executeQuery(sql.toString(), paramrs);
		} else {
			rs = DbUtil.executeQuery(sql.toString(), null);
		}

		try {
			while (rs.next()) {
				SupplierInfo s = new SupplierInfo();

				s.setDid(rs.getInt("did"));
				s.setDname(rs.getString("dname"));
				s.setDtel(rs.getString("dtel"));
				s.setDemail(rs.getString("demail"));
				s.setDadd(rs.getString("dadd"));
				s.setGoodsName(rs.getString("goodsName"));
				s.setGoodsCategoryId(rs.getInt("goodsCategoryId"));
				s.setGoodspictures(rs.getString("goodspictures"));
				supplierInfos.add(s);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// 方法的调用者 <=>Exception 项目 自定义异常类型
			throw new Exception("数据操作异常");
		}

		return supplierInfos;
	}



	/****
	 * 添加供货商信息
	 * 
	 * @param supplierinfo
	 * @return
	 * @throws Exception
	 */
	public int addSupplierinfo(SupplierInfo supplierInfo) throws Exception {
		int count = 0;
		// sql

		try {
			String sql = "insert into supplierInfo (did,dname,Dtel,Demail,Dadd,goodsName,goodsCategoryId,goodspictures) values(?,?,?,?,?,?,?,?)";
			ArrayList<Object> paramrs = new ArrayList<Object>();
			paramrs.add(supplierInfo.getDid());
			paramrs.add(supplierInfo.getDname());
			paramrs.add(supplierInfo.getDtel());
			paramrs.add(supplierInfo.getDemail());
			paramrs.add(supplierInfo.getDadd());
			paramrs.add(supplierInfo.getGoodsName());
			paramrs.add(supplierInfo.getGoodsCategoryId());
			paramrs.add(supplierInfo.getGoodspictures());

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

}
