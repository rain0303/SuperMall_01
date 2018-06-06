package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DbUtil;
import bean.Goodsinfo;

/**
 * goodsinfo表的数据操作类
 * 
 * @author Administrator
 * 
 */
public class GoodsInfoDao {
	public Goodsinfo getGoodsinfo1(Goodsinfo goodsinfo) throws Exception {
		Goodsinfo u = null;
		StringBuffer sql = new StringBuffer(
				"select * from goodsinfo where goodsName=?");
		ArrayList<Object> paramrs = new ArrayList<Object>();
		paramrs.add(goodsinfo.getGoodsName());


		ResultSet rs = DbUtil.executeQuery(sql.toString(), paramrs);
		try {
			while (rs.next()) {
				u = new Goodsinfo();
				u.setGoodsName(rs.getString("goodsName"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// 方法的调用者 <=>Exception 项目 自定义异常类型
			throw new Exception("数据操作异常");
		}

		return u;

	}
	

	
	/*****
	 * 采购商品后修改商品数量到商品表
	 */
	public int updateGoodsInfo1(Goodsinfo goodsinfo) throws Exception {
		int count = 0;
		// sql
		try {
			String sql = "update  goodsinfo set goodsStock=? where goodsid=?";
			ArrayList<Object> paramrs = new ArrayList<Object>();
			paramrs.add(goodsinfo.getGoodsStock());
			paramrs.add(goodsinfo.getGoodsId());
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
	 * 采购后的修改商品信息
	 * 
	 * @param goodsinfo
	 *            商品对象
	 * @return int
	 * @throws Exception
	 */
	public int updategoodsInfo1(Goodsinfo goodsinfo) throws Exception {
		int count = 0;
		// sql
		try {
			String sql = "update  goodsinfo set goodsStock=goodsStock+? where goodsName=?";
			ArrayList<Object> paramrs = new ArrayList<Object>();
			paramrs.add(goodsinfo.getGoodsStock());
			paramrs.add(goodsinfo.getGoodsName());
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
	 * 根据采购订单添加商品信息
	 * 
	 * @param goodsinfo
	 *            用户对象
	 * @return int
	 * @throws Exception
	 */
	public int addgoodsInfo1(Goodsinfo goodsinfo) throws Exception {
		int count = 0;
		// sql

		try {
			String sql = "insert into goodsinfo (goodsCategoryId,goodsName,goodsCPrice,goodsPrice,goodsStock,goodsPhoto) values(?,?,?,?,?,?)";
			ArrayList<Object> paramrs = new ArrayList<Object>();
			paramrs.add(goodsinfo.getGoodsCategoryId());
			paramrs.add(goodsinfo.getGoodsName());
			paramrs.add(goodsinfo.getGoodsCPrice());
			paramrs.add(goodsinfo.getGoodsPrice());
			paramrs.add(goodsinfo.getGoodsStock());
			paramrs.add(goodsinfo.getGoodsPhoto());
		
			count = DbUtil.executeUpdate(sql, paramrs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace(); 当前方法处理异常
			// 方法的调用者 <=>Exception 项目 自定义异常类型
			throw new Exception("数据操作异常");
		}
		return count;
	}
	
	
	
	
	public Goodsinfo getGoodsinfo(Goodsinfo goodsinfo) throws Exception {
		Goodsinfo u = null;
		// 动态查询
		// 1 关于变量默认值
		// 2 动态条件
		// 3 细节 大量处理字符窜拼接
		/*
		 * String 3种场景 1 final String 字符窜常量池 <=>复用 常量 字符窜+变量 字符窜+字符窜 2
		 * StringBuilder,StringBuffer(线程安全) 字符窜缓存 效率 3 String s=new String()
		 * 字符工具类
		 */
		StringBuffer sql = new StringBuffer(
				"select * from goodsinfo where goodsName=?");
		ArrayList<Object> paramrs = new ArrayList<Object>();
		paramrs.add(goodsinfo.getGoodsName());


		ResultSet rs = DbUtil.executeQuery(sql.toString(), paramrs);
		try {
			while (rs.next()) {
				u = new Goodsinfo();
//				u.setGoodsId(Integer.parseInt(rs.getString("goodsid")));
//				u.setGoodsCategoryId(Integer.parseInt(rs.getString("goodsCategoryId")));
				u.setGoodsName(rs.getString("goodsName"));
//				u.setGoodsCPrice(rs.getDouble("goodsCPrice"));
//				u.setGoodsPrice(rs.getDouble("goodsPrice"));
//				
//				u.setGoodsStock(rs.getInt("goodsStock"));
//				u.setGoodsPhoto(rs.getString("goodsPhoto"));
				
				
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// 方法的调用者 <=>Exception 项目 自定义异常类型
			throw new Exception("数据操作异常");
		}

		return u;

	}
	

	/**
	 * 根据用户信息查找用户对象
	 * 
	 * @param goodsinfo
	 *            用户对象
	 * @return goodsinfo
	 * @throws Exception
	 */
	public Goodsinfo getgoodsinfo(Goodsinfo goodsinfo) throws Exception {
		Goodsinfo u = null;
		// 动态查询
		// 1 关于变量默认值
		// 2 动态条件
		// 3 细节 大量处理字符窜拼接
		/*
		 * String 3种场景 1 final String 字符窜常量池 <=>复用 常量 字符窜+变量 字符窜+字符窜 2
		 * StringBuilder,StringBuffer(线程安全) 字符窜缓存 效率 3 String s=new String()
		 * 字符工具类
		 */
		StringBuffer sql = new StringBuffer(
				"select a.goodsid,a.goodsphoto,a.goodsname,b.goodsCategoryname,a.goodsCPrice,a.goodsPrice,a.goodsstock from goodsinfo AS a ,goodscategoryinfo AS b where a.goodsCategoryId=b.goodsCategoryId");
		ArrayList<Object> paramrs = new ArrayList<Object>();
		if (goodsinfo.getGoodsId() != 0) {
			sql.append(" and goodsid=? ");
			// 设置参数
			paramrs.add(goodsinfo.getGoodsId());
		}
		if (goodsinfo.getGoodsPhoto()!=null) {
			sql.append(" and goodsphoto=? ");
			paramrs.add(goodsinfo.getGoodsPhoto());
		}
		// null ""
		if (goodsinfo.getGoodsName()!=null) {
			sql.append(" and goodsname=? ");
			paramrs.add(goodsinfo.getGoodsName());
		}
		if (goodsinfo.getGoodsStock() != 0) {
			sql.append(" and goodsstock=? ");
			// 设置参数
			paramrs.add(goodsinfo.getGoodsStock());
		}

		ResultSet rs = DbUtil.executeQuery(sql.toString(), paramrs);
		try {
			while (rs.next()) {
				u = new Goodsinfo();
				u.setGoodsId(rs.getInt("goodsid"));
				u.setGoodsName(rs.getString("goodsname"));
				u.setGoodsCategoryName(rs.getString("goodsCategoryName"));
				u.setGoodsCPrice(rs.getDouble("goodsCPrice"));
				u.setGoodsPrice(rs.getDouble("goodsPrice"));
				u.setGoodsPhoto(rs.getString("goodsPhoto"));
				u.setGoodsStock(rs.getInt("goodsStock"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// 方法的调用者 <=>Exception 项目 自定义异常类型
			throw new Exception("数据操作异常");
		}

		return u;

	}

	/**
	 * 获取所有用户集合
	 * 
	 * @return ArrayList<goodsinfo>
	 * @throws Exception
	 */
	public ArrayList<Goodsinfo> getgoodsinfo() throws Exception {
		ArrayList<Goodsinfo> goodsinfos = new ArrayList<Goodsinfo>();
		String sql = "select a.goodsid,a.goodsphoto,a.goodsname,b.goodsCategoryname,a.goodsCPrice,a.goodsPrice,a.goodsstock from goodsinfo AS a ,goodscategoryinfo AS b where a.goodsCategoryId=b.goodsCategoryId";

		ResultSet rs = DbUtil.executeQuery(sql, null);

		try {
			while (rs.next()) {
				Goodsinfo u = new Goodsinfo();
				u.setGoodsId(rs.getInt("goodsid"));
				u.setGoodsName(rs.getString("goodsname"));
				u.setGoodsCategoryName(rs.getString("goodsCategoryName"));
				u.setGoodsCPrice(rs.getDouble("goodsCPrice"));
				u.setGoodsPrice(rs.getDouble("goodsPrice"));
				u.setGoodsPhoto(rs.getString("goodsPhoto"));
				u.setGoodsStock(rs.getInt("goodsStock"));
				// 添加到集合
				goodsinfos.add(u);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// 方法的调用者 <=>Exception 项目 自定义异常类型
			throw new Exception("数据操作异常");
		}

		return goodsinfos;
	}

	/**
	 * 根据用户对象信息查询
	 * 
	 * @param goodsinfo
	 *            用户对象
	 * @return ArrayList<goodsinfo>
	 * @throws Exception
	 */
	public ArrayList<Goodsinfo> selectgoodsinfo(Goodsinfo goodsinfo)
			throws Exception {
		ArrayList<Goodsinfo> goodsinfos = new ArrayList<Goodsinfo>();

		StringBuffer sql = new StringBuffer(
				"select a.goodsid,a.goodsphoto,a.goodsname,b.goodsCategoryname,a.goodsCPrice,a.goodsPrice,a.goodsstock from goodsinfo AS a ,goodscategoryinfo AS b where a.goodsCategoryId=b.goodsCategoryId");
		ArrayList<Object> paramrs = new ArrayList<Object>();
		if (goodsinfo.getGoodsId() != 0) {
			sql.append(" and goodsid=? ");
			// 设置参数
			paramrs.add(goodsinfo.getGoodsId());
		}
		// null ""
		if (!goodsinfo.getGoodsName().equals("")) {
			sql.append(" and goodsname like ? ");
			paramrs.add("%" + goodsinfo.getGoodsName() + "%");
		}


		ResultSet rs = DbUtil.executeQuery(sql.toString(), paramrs);

		try {
			while (rs.next()) {
				Goodsinfo u = new Goodsinfo();
				u.setGoodsId(rs.getInt("goodsid"));
				u.setGoodsName(rs.getString("goodsname"));
				u.setGoodsCategoryName(rs.getString("goodsCategoryName"));
				u.setGoodsCPrice(rs.getDouble("goodsCPrice"));
				u.setGoodsPrice(rs.getDouble("goodsPrice"));
				u.setGoodsPhoto(rs.getString("goodsPhoto"));
				u.setGoodsStock(rs.getInt("goodsStock"));
				// 添加到集合
				goodsinfos.add(u);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// 方法的调用者 <=>Exception 项目 自定义异常类型
			throw new Exception("数据操作异常");
		}

		return goodsinfos;
	}

	/**
	 * 修改用户方法
	 * 
	 * @param goodsinfo
	 *            用户对象
	 * @return int
	 * @throws Exception
	 */
	public int updategoodsInfo(Goodsinfo goodsinfo) throws Exception {
		int count = 0;
		// sql
		try {
			String sql = "update  goodsinfo set goodsname=? where goodsid=?";
			ArrayList<Object> paramrs = new ArrayList<Object>();
			paramrs.add(goodsinfo.getGoodsName());
			paramrs.add(goodsinfo.getGoodsId());
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
	 * 添加用户方法
	 * 
	 * @param goodsinfo
	 *            用户对象
	 * @return int
	 * @throws Exception
	 */
	public int addgoodsInfo(Goodsinfo goodsinfo) throws Exception {
		int count = 0;
		// sql

		try {
			String sql = "insert into goodsinfo (goodsname) values(?)";
			ArrayList<Object> paramrs = new ArrayList<Object>();
			paramrs.add(goodsinfo.getGoodsName());

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

	public int DeleteGoodsInfo(Goodsinfo goodsinfo) throws Exception {
		int count = 0;
		// sql

		try {
			String sql = "DELETE FROM goodsinfo where goodsid=?";
			ArrayList<Object> paramrs = new ArrayList<Object>();
			paramrs.add(goodsinfo.getGoodsId());
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
