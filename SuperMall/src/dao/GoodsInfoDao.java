package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DbUtil;
import bean.Goodsinfo;

/**
 * goodsinfo������ݲ�����
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
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}

		return u;

	}
	

	
	/*****
	 * �ɹ���Ʒ���޸���Ʒ��������Ʒ��
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
			// e.printStackTrace(); ��ǰ���������쳣
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}

		return count;
	}

	/**
	 * �ɹ�����޸���Ʒ��Ϣ
	 * 
	 * @param goodsinfo
	 *            ��Ʒ����
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
			// e.printStackTrace(); ��ǰ���������쳣
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}

		return count;
	}

	/**
	 * ���ݲɹ����������Ʒ��Ϣ
	 * 
	 * @param goodsinfo
	 *            �û�����
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
			// e.printStackTrace(); ��ǰ���������쳣
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}
		return count;
	}
	
	
	
	
	public Goodsinfo getGoodsinfo(Goodsinfo goodsinfo) throws Exception {
		Goodsinfo u = null;
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
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}

		return u;

	}
	

	/**
	 * �����û���Ϣ�����û�����
	 * 
	 * @param goodsinfo
	 *            �û�����
	 * @return goodsinfo
	 * @throws Exception
	 */
	public Goodsinfo getgoodsinfo(Goodsinfo goodsinfo) throws Exception {
		Goodsinfo u = null;
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
				"select a.goodsid,a.goodsphoto,a.goodsname,b.goodsCategoryname,a.goodsCPrice,a.goodsPrice,a.goodsstock from goodsinfo AS a ,goodscategoryinfo AS b where a.goodsCategoryId=b.goodsCategoryId");
		ArrayList<Object> paramrs = new ArrayList<Object>();
		if (goodsinfo.getGoodsId() != 0) {
			sql.append(" and goodsid=? ");
			// ���ò���
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
			// ���ò���
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
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}

		return u;

	}

	/**
	 * ��ȡ�����û�����
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
				// ��ӵ�����
				goodsinfos.add(u);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}

		return goodsinfos;
	}

	/**
	 * �����û�������Ϣ��ѯ
	 * 
	 * @param goodsinfo
	 *            �û�����
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
			// ���ò���
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
				// ��ӵ�����
				goodsinfos.add(u);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}

		return goodsinfos;
	}

	/**
	 * �޸��û�����
	 * 
	 * @param goodsinfo
	 *            �û�����
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
			// e.printStackTrace(); ��ǰ���������쳣
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}

		return count;
	}

	/**
	 * ����û�����
	 * 
	 * @param goodsinfo
	 *            �û�����
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
			// e.printStackTrace(); ��ǰ���������쳣
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
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
			// e.printStackTrace(); ��ǰ���������쳣
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}
		return count;
	}

}
