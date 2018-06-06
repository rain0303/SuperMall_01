package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import db.DbUtil;

import bean.Emp;

/***
 *emp表的数据操作类
 * @author Administrator
 *
 */

public class EmpDao {
	public ArrayList<Emp> getEmp() throws SQLException{
		ArrayList<Emp> emps = new ArrayList<Emp>();
		String sql="SELECT empid,empname,empsex,empadd,emptel,empjob FROM empinfo where empJob='采购员'";
		ResultSet rs =DbUtil.executeQuery(sql,null);
		try {
			while(rs.next()){
				Emp e = new Emp();
				e.setEmpid(rs.getInt("empid"));
				e.setEmpname(rs.getString("empname"));
				e.setEmpsex(rs.getString("empsex"));
				e.setEmptel(rs.getString("emptel"));
				e.setEmpjob(rs.getString("empjob"));
				emps.add(e);
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return emps;
	}

}
