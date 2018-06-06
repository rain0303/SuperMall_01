package bean;

/**
 * 会员管理
 */
import java.io.Serializable;

public class Vipinfo implements Serializable {
	private int vipid;
	private String vipname;
	private String vipsex;
	private String vipcut;
	private Exception NumberFormatException;

	public int getVipid() {
		return vipid;
	}

	public void setVipid(int vipid) {
		this.vipid = vipid;
	}

	public String getVipname() {
		return vipname;
	}

	public void setVipname(String vipname) {
		this.vipname = vipname;
	}

	public String getVipsex() {
		return vipsex;
	}

	public void setVipsex(String vipsex) {
		this.vipsex = vipsex;
	}

	public String getVipcut() {
		return vipcut;
	}

	public void setVipcut(String vipcut) {
		this.vipcut = vipcut;
	}

}
