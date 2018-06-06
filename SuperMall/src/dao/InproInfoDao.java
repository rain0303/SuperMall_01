package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Goodsinfo;
import bean.InproInfo;
import db.DbUtil;

/***
 * inproinfo������ݲ�����
 * 
 * @author Administrator
 * 
 */

public class InproInfoDao {

	/**
	 * ��ȡ�����û�����
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
				// ��ӵ�����
				inproInfos.add(i);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			throw new Exception("���ݲ����쳣");
		}

		return inproInfos;
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
				"select goodsid,goodsname from goodsinfo where 1=1");
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
		 * 
		 * ɾ������
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
				// e.printStackTrace(); ��ǰ���������쳣
				// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
				throw new Exception("���ݲ����쳣");
			}
			return count;
		}

	/**
	 * �޸��û�����
	 * 
	 * @param goodsinfo
	 *            �û�����
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
	 // e.printStackTrace(); ��ǰ���������쳣
	 // �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
	 throw new Exception("���ݲ����쳣");
	 }
	
	 return count;
	 }

	/**
	 * ��Ӷ�������
	 * 
	 * @param goodsinfo
	 *            ������Ϣ
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
			// e.printStackTrace(); ��ǰ���������쳣
			// �����ĵ����� <=>Exception ��Ŀ �Զ����쳣����
			e.printStackTrace();
		}
		return count;
	}

}
