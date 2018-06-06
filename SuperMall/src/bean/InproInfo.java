package bean;

import java.util.Date;

/****
 * 进货表类
 * @author Administrator
 *
 */
public class InproInfo {
	private int proId;
	private Date prodate;
	private int Did;
	private String goodsName;
	private int goodsNum;
	private int empId;
	private String remark;
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public Date getProdate() {
		return prodate;
	}
	public void setProdate(Date prodate) {
		this.prodate = prodate;
	}
	public int getDid() {
		return Did;
	}
	public void setDid(int did) {
		Did = did;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	


}
