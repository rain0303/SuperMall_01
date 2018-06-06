package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Goodsinfo;
import bean.SaleInfo;

import db.DbUtil;

public class SaleInfoDao {
	

	/**
	 * 饼状图查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<SaleInfo> getPieSaleInfo() throws Exception {
		ArrayList<SaleInfo> saleinfos = new ArrayList<SaleInfo>();
		String sql = "select  b.goodsName , sum(a.goodsNum) " +
				"from saleinfo AS a ,goodsinfo AS b " +
				"where a.goodsid = b.goodsid " +
				"group by b.goodsName ";
		ResultSet rs = DbUtil.executeQuery(sql, null);
		try {
			while (rs.next()) {
				SaleInfo s = new SaleInfo();
//				s.setSaleid(rs.getInt("saleid"));
				s.setGoodsName(rs.getString("goodsName"));
				s.setGoodsNum(rs.getInt("sum(a.goodsNum)"));
				// 添加到集合
				saleinfos.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// 方法的调用者 <=>Exception 项目 自定义异常类型
			throw new Exception("数据操作异常");
		}

		return saleinfos;
	}
	
	/**
	 * 折线图查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<SaleInfo> getCategorySaleInfo() throws Exception {
		ArrayList<SaleInfo> saleinfos = new ArrayList<SaleInfo>();
		String sql ="select saleDate , sum(saleProfit) from saleinfo group by saleDate";
		ResultSet rs = DbUtil.executeQuery(sql, null);
		try {
			while (rs.next()) {
				SaleInfo s = new SaleInfo();
				s.setSaleDate(rs.getDate("saleDate"));
				s.setSaleProfit(rs.getDouble("sum(saleProfit)"));
				// 添加到集合
				saleinfos.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// 方法的调用者 <=>Exception 项目 自定义异常类型
			throw new Exception("数据操作异常");
		}

		return saleinfos;
	}
	
	
	/**
	 * 获取所有用户集合
	 * 
	 * @return ArrayList<Saleinfo>
	 * @throws Exception
	 */
	
	public ArrayList<SaleInfo> getSaleInfo() throws Exception {
		ArrayList<SaleInfo> saleinfos = new ArrayList<SaleInfo>();
		String sql = "select a.saleid,a.empid,a.goodsid,b.goodsname,a.goodsNum,a.vipid,a.saleProfit,a.saleDate from saleinfo AS a ,goodsinfo AS b where a.goodsid = b.goodsid ";
		ResultSet rs = DbUtil.executeQuery(sql, null);

		try {
			while (rs.next()) {
				SaleInfo s = new SaleInfo();
				s.setSaleid(rs.getInt("saleId"));
				s.setEmpid(rs.getInt("empId"));
				s.setGoodsid(rs.getInt("goodsId"));
				s.setGoodsName(rs.getString("goodsName"));
				s.setVipid(rs.getInt("vipId"));
				s.setGoodsNum(rs.getInt("goodsNum"));
				s.setSaleProfit(rs.getDouble("saleProfit"));
				s.setSaleDate(rs.getDate("saleDate"));
				// 添加到集合
				saleinfos.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// 方法的调用者 <=>Exception 项目 自定义异常类型
			throw new Exception("数据操作异常");
		}

		return saleinfos;
	}
	
	
	/**
	 * 
	 * 删除操作
	 */
	public int DeleteSaleInfo(SaleInfo saleInfo) throws Exception {
		int count = 0;
		// sql

		try {
			String sql = "DELETE FROM Saleinfo where saleId=?";
			ArrayList<Object> paramrs = new ArrayList<Object>();
			paramrs.add(saleInfo.getSaleid());
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
	 * 根据用户对象信息查询
	 * @param Saleinfo 
	 * @return ArrayList<Saleinfo>
	 * @throws Exception
	 */
	public ArrayList<SaleInfo> selectSaleinfo(SaleInfo saleinfo)
			throws Exception {
		ArrayList<SaleInfo> saleinfos = new ArrayList<SaleInfo>();

		StringBuffer sql = new StringBuffer(
		"select a.saleid,a.empid,a.goodsid,b.goodsname,a.goodsNum,a.vipid,a.saleProfit,a.saleDate from saleinfo AS a ,goodsinfo AS b where a.goodsid = b.goodsid  ");

		ArrayList<Object> paramrs = new ArrayList<Object>();
		if (saleinfo.getSaleid() != 0) {
			sql.append(" and saleId=? ");
			// 设置参数
			paramrs.add(saleinfo.getSaleid());
		}
		// null ""
		if (saleinfo.getSaleDate()!=null) {
			sql.append(" and saleDate = ? ");
			paramrs.add(saleinfo.getSaleDate() );
		}


		ResultSet rs = DbUtil.executeQuery(sql.toString(), paramrs);

		try {
			while (rs.next()) {
				SaleInfo s = new SaleInfo();
				s.setSaleid(rs.getInt("saleId"));
				s.setEmpid(rs.getInt("empId"));
				s.setGoodsid(rs.getInt("goodsId"));
				s.setGoodsName(rs.getString("goodsName"));
				s.setVipid(rs.getInt("vipId"));
				s.setGoodsNum(rs.getInt("goodsNum"));
				s.setSaleProfit(rs.getDouble("saleProfit"));
				s.setSaleDate(rs.getDate("saleDate"));
				// 添加到集合
				saleinfos.add(s);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// 方法的调用者 <=>Exception 项目 自定义异常类型
			throw new Exception("数据操作异常");
		}

		return saleinfos;
	}
	
	/**
	 * 添加用户方法
	 * 
	 * @param goodsinfo
	 *            用户对象
	 * @return int
	 * @throws Exception
	 */
	public int addsaleInfo(SaleInfo saleinfo) throws Exception {
		int count = 0;
		// sql

		try {
			String sql = "insert into saleinfo (vipid,empid,goodsid,goodsNum,saleDate,saleProfit) values(?,?,?,?,?,?)";
			ArrayList<Object> paramrs = new ArrayList<Object>();
			paramrs.add(saleinfo.getVipid());
			paramrs.add(saleinfo.getEmpid());
			paramrs.add(saleinfo.getGoodsid());
			paramrs.add(saleinfo.getGoodsNum());
			paramrs.add(saleinfo.getSaleDate());
			paramrs.add(saleinfo.getSaleProfit());
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
	 * 下单后库存减少
	 * 
	 * @param goodsinfo
	 *            用户对象
	 * @return int
	 * @throws Exception
	 */
	public int updategoodsStock(SaleInfo saleinfo) throws Exception {
		int count = 0;
		// sql
		try {
			String sql = "update  goodsinfo set goodsStock = goodsStock - ? where goodsid=?";
			ArrayList<Object> paramrs = new ArrayList<Object>();
			paramrs.add(saleinfo.getGoodsNum());
			paramrs.add(saleinfo.getGoodsid());
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
