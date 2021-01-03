package beans;

import com.oracle.wls.shaded.org.apache.xpath.operations.String;

public class phanquyen {
	private int maquyen;
	private String tenquyen;
	public phanquyen() {
	}
	public phanquyen(int maquyen, String tenquyen) {
		super();
		this.maquyen = maquyen;
		this.tenquyen = tenquyen;
	}
	public int getmaquyen() {
		return maquyen;
	}
	public void setmaquyen(int maquyen) {
		this.maquyen = maquyen;
	}
	public String gettenquyen() {
		return tenquyen;
	}
	public void settenquyen(String tenquyen ) {
		this.tenquyen = tenquyen;
	}
}
