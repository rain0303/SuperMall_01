package service;

import java.util.ArrayList;

import dao.EmpDao;
import bean.Emp;

/***
 * empԱ�����ҵ�������
 * 
 * @author Administrator
 * 
 */

public class EmpService {
	EmpDao empDao = new EmpDao();

	public ArrayList<Emp> getEmpInfo() throws Exception {

		return empDao.getEmp();
	}

}
