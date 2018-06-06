package bean;
/***
 * ÷∞‘±¿‡
 * @author Administrator
 *
 */

public class Emp {
	private int empid;
	private String empname;
	private String empsex;
	private String empage;
	private String empadd;
	private String emptel;
	private String empjob;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpsex() {
		return empsex;
	}
	public void setEmpsex(String empsex) {
		this.empsex = empsex;
	}
	public String getEmpage() {
		return empage;
	}
	public void setEmpage(String empage) {
		this.empage = empage;
	}
	public String getEmpadd() {
		return empadd;
	}
	public void setEmpadd(String empadd) {
		this.empadd = empadd;
	}
	public String getEmptel() {
		return emptel;
	}
	public void setEmptel(String emptel) {
		this.emptel = emptel;
	}
	public String getEmpjob() {
		return empjob;
	}
	public void setEmpjob(String empjob) {
		this.empjob = empjob;
	}
	@Override
	public String toString() {
		return "empid=" +this.getEmpid()+"empname=" +this.getEmpname()+"empsex="
				+this.getEmpsex()+"empage=" +this.getEmpage()+" empadd=" +this.getEmpadd()
				+"emptel=" +this.getEmptel();
	}
	
	

}
