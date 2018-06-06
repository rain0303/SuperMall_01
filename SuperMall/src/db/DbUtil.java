package db;

import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

/**
 * java 操作数据库 工具类<=>代码重构<=>复用 jdbc
 * 
 * @author Administrator
 * 
 */
public class DbUtil {
	// JDBC 3三大对象(组件)
	// static 场景 生命周期:程序启动时，自动初始化，只会初始1次
	private static Connection con = null;// 连接对象
	private static PreparedStatement psmt = null;// 预编译命令对象
	private static ResultSet rs = null;// 结果集对象

	/**
	 * 获取连接对象
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
	 * 获取预编译命令对象
	 * 
	 * @param sql
	 *            语句
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
	 * 获取结果集对象
	 * 
	 * @param sql
	 *            语句
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
	// ? ? ? 参数个数 不统一 动态性 集合ArrayList<Object>
	// 参数的数据类型 不统一 Object
	// 思路

	/**
	 * 执行sql语句返回受影响行数
	 * 
	 * @param sql
	 *            语句 支持insert,update,delete
	 * @param paramrs
	 *            参数集合列表
	 * @return int
	 */
	public static int executeUpdate(String sql, ArrayList<Object> paramrs) {
		int count = 0;
		try {
			getPreparedStatement(sql);
			// 设置参数
			for (int i = 0; i < paramrs.size(); i++) {
				// 1 参数下标 2 参数的数据类型
				// 细节 下标
				psmt.setObject(i + 1, paramrs.get(i));

			}
			// 执行
			count = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
			closeAll();

		}

		return count;
	}

	/**
	 * 执行 sql语句返回结果集
	 * 
	 * @param sql
	 *            语句 支持 select
	 * @param paramrs
	 *            参数集合列表
	 * @return ResultSet
	 */
	public static ResultSet executeQuery(String sql, ArrayList<Object> paramrs) {
		getPreparedStatement(sql);
		try {
			// 细节
			if (paramrs != null) {
				// 设置参数
				// 设置参数
				for (int i = 0; i < paramrs.size(); i++) {
					// 1 参数下标 2 参数的数据类型
					// 细节 下标
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
