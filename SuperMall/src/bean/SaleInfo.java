package bean;

import java.io.Serializable;
import java.util.*;

public class SaleInfo implements Serializable{
	/**
	 * 售货表构造方法
	 */
	
	private int saleid;
	private int goodsid;
	private int empid;
	private int goodsNum;
	private Date saleDate;
	private int vipid;
	private String goodsName;
	private double saleProfit;
	public double getSaleProfit() {
		return saleProfit;
	}
	public void setSaleProfit(double saleProfit) {
		this.saleProfit = saleProfit;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getSaleid() {
		return saleid;
	}
	public void setSaleid(int saleid) {
		this.saleid = saleid;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public int getVipid() {
		return vipid;
	}
	public void setVipid(int vipid) {
		this.vipid = vipid;
	}

}
