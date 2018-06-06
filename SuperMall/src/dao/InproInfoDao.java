package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Goodsinfo;
import bean.InproInfo;
import db.DbUtil;

/***
 * inproinfo表的数据操作类
 * 
 * @author Administrator
 * 
 */

public class InproInfoDao {

	/**
	 * 获取所有用户集合
	 * 
	 * @return ArrayList<InproInfo>
	 * @throws Exception
	 */
	public ArrayList<InproInfo> getInproInfo() throws Exception {
		ArrayList<InproInfo> inproInfos = new ArrayList<InproInfo>();
		String sql = "select  proId, prodate, Did, goodsName,goodsNum,remark,empId from inproinfo ";

		ResultSet rs = DbUtil.executeQuery(sql, null);

		try {
			while (rs.next()) {
				InproInfo i = new InproInfo();
				i.setProId(rs.getInt("proId"));
				i.setProdate(rs.getDate("prodate"));
				i.setDid(rs.getInt("did"));
				i.setGoodsName(rs.getString("goodsName"));
				i.setGoodsNum(rs.getInt("goodsNum"));
				i.setRemark(rs.getString("remark"));
				i.setEmpId(rs.getInt("empId"));
				// 添加到集合
				inproInfos.add(i);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// 方法的调用者 <=>Exception 项目 自定义异常类型
			throw new Exception("数据操作异常");
		}

		return inproInfos;
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
				"select goodsid,goodsname from goodsinfo where 1=1");
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
		 * 
		 * 删除操作
		 */
		public int DeleteInproInfo(InproInfo inproInfo) throws Exception {
			int count = 0;
			// sql

			try {
				String sql = "DELETE FROM InproInfo where proId=?";
				ArrayList<Object> paramrs = new ArrayList<Object>();
				paramrs.add(inproInfo.getProId());
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
	 * 修改用户方法
	 * 
	 * @param goodsinfo
	 *            用户对象
	 * @return int
	 * @throws Exception
	 */
	 public int updateInproInfo(InproInfo inproInfo) throws Exception {
	 int count = 0;
	 // sql
	 try {
	 String sql = "update  inproinfo set goodsNum=?,remark=? where proId=?";
	 ArrayList<Object> paramrs = new ArrayList<Object>();
	 paramrs.add(inproInfo.getGoodsNum());
	 paramrs.add(inproInfo.getRemark());
	 paramrs.add(inproInfo.getProId());
	
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
	 * 添加订单方法
	 * 
	 * @param goodsinfo
	 *            订单信息
	 * @return int
	 * @throws Exception
	 */
	public int addInproInfo(InproInfo inproInfo) throws Exception {
		int count = 0;
		try {
			String sql = "insert into inproInfo (proId,prodate,Did,goodsName,goodsNum,remark,empId) values(?,?,?,?,?,?,?)";
			ArrayList<Object> paramrs = new ArrayList<Object>();
			paramrs.add(inproInfo.getProId());
			paramrs.add(inproInfo.getProdate());
			paramrs.add(inproInfo.getDid());
			paramrs.add(inproInfo.getGoodsName());
			paramrs.add(inproInfo.getGoodsNum());
			paramrs.add(inproInfo.getRemark());
			paramrs.add(inproInfo.getEmpId());
		

			// JDBC
			count = DbUtil.executeUpdate(sql, paramrs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace(); 当前方法处理异常
			// 方法的调用者 <=>Exception 项目 自定义异常类型
			e.printStackTrace();
		}
		return count;
	}

}
