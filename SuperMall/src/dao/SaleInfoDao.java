package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Goodsinfo;
import bean.SaleInfo;

import db.DbUtil;

public class SaleInfoDao {
	

	/**
	 * ��״ͼ��ѯ
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
				// ��ӵ�����
				saleinfos.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}

		return saleinfos;
	}
	
	/**
	 * ����ͼ��ѯ
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
				// ��ӵ�����
				saleinfos.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}

		return saleinfos;
	}
	
	
	/**
	 * ��ȡ�����û�����
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
				// ��ӵ�����
				saleinfos.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}

		return saleinfos;
	}
	
	
	/**
	 * 
	 * ɾ������
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
			// e.printStackTrace(); ��ǰ���������쳣
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}
		return count;
	}

	/**
	 * �����û�������Ϣ��ѯ
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
			// ���ò���
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
				// ��ӵ�����
				saleinfos.add(s);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}

		return saleinfos;
	}
	
	/**
	 * ����û�����
	 * 
	 * @param goodsinfo
	 *            �û�����
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
			// e.printStackTrace(); ��ǰ���������쳣
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}
		return count;
	}
	
	/**
	 * �µ��������
	 * 
	 * @param goodsinfo
	 *            �û�����
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
			// e.printStackTrace(); ��ǰ���������쳣
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}

		return count;
	}

}
