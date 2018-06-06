package db;

import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

/**
 * java �������ݿ� ������<=>�����ع�<=>���� jdbc
 * 
 * @author Administrator
 * 
 */
public class DbUtil {
	// JDBC 3�������(���)
	// static ���� ��������:��������ʱ���Զ���ʼ����ֻ���ʼ1��
	private static Connection con = null;// ���Ӷ���
	private static PreparedStatement psmt = null;// Ԥ�����������
	private static ResultSet rs = null;// ���������

	/**
	 * ��ȡ���Ӷ���
	 * 
	 * @return Connection
	 */
	public static Connection getConnetion() {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("config.properties"));
			Class.forName(properties.getProperty("driverName"));
			con = DriverManager.getConnection(properties.getProperty("url"),
					properties.getProperty("user"),
					properties.getProperty("password"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	/**
	 * ��ȡԤ�����������
	 * 
	 * @param sql
	 *            ���
	 * @return PreparedStatement
	 */
	public static PreparedStatement getPreparedStatement(String sql) {
		con = getConnetion();
		try {
			psmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return psmt;
	}

	/**
	 * ��ȡ���������
	 * 
	 * @param sql
	 *            ���
	 * @return ResultSet
	 */
	public static ResultSet getResultSet(String sql) {
		try {
			psmt = getPreparedStatement(sql);

			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	// insert,update,delete
	// ? ? ? �������� ��ͳһ ��̬�� ����ArrayList<Object>
	// �������������� ��ͳһ Object
	// ˼·

	/**
	 * ִ��sql��䷵����Ӱ������
	 * 
	 * @param sql
	 *            ��� ֧��insert,update,delete
	 * @param paramrs
	 *            ���������б�
	 * @return int
	 */
	public static int executeUpdate(String sql, ArrayList<Object> paramrs) {
		int count = 0;
		try {
			getPreparedStatement(sql);
			// ���ò���
			for (int i = 0; i < paramrs.size(); i++) {
				// 1 �����±� 2 ��������������
				// ϸ�� �±�
				psmt.setObject(i + 1, paramrs.get(i));

			}
			// ִ��
			count = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// �ر���Դ
			closeAll();

		}

		return count;
	}

	/**
	 * ִ�� sql��䷵�ؽ����
	 * 
	 * @param sql
	 *            ��� ֧�� select
	 * @param paramrs
	 *            ���������б�
	 * @return ResultSet
	 */
	public static ResultSet executeQuery(String sql, ArrayList<Object> paramrs) {
		getPreparedStatement(sql);
		try {
			// ϸ��
			if (paramrs != null) {
				// ���ò���
				// ���ò���
				for (int i = 0; i < paramrs.size(); i++) {
					// 1 �����±� 2 ��������������
					// ϸ�� �±�
					psmt.setObject(i + 1, paramrs.get(i));

				}
			}

			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;

	}

	//

	public static void closeAll() {
		try {
			if (psmt != null) {
				psmt.close();
			}
			if (con != null) {

				con.close();

			}
			if (rs != null) {
				rs.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
