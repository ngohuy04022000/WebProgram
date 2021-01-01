package beans;


public class user {
	private int manguoidung;
	private String hoten;
	private String diachi;
	private String email;
	private String taikhoan;
	private String matkhau;
	private int maquyen;
	
	public user() {
	}
	public user(int manguoidung, String hoten, String diachi, String email,String taikhoan, String matkhau, int maquyen) {
		super();
		this.setManguoidung(manguoidung);
		this.setHoten(hoten);
		this.setDiachi(diachi);
		this.setEmail(email);
		this.setTaikhoan(taikhoan);
		this.setMatkhau(matkhau);
		this.setMaquyen(maquyen);
	}
	public int getManguoidung() {
		return manguoidung;
	}
	public void setManguoidung(int manguoidung) {
		this.manguoidung = manguoidung;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public int getMaquyen() {
		return maquyen;
	}
	public void setMaquyen(int maquyen) {
		this.maquyen = maquyen;
	}

}

