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
		this.manguoidung = manguoidung;
		this.hoten = hoten;
		this.diachi = diachi;
		this.email = email;
		this.taikhoan= taikhoan;
		this.matkhau = matkhau;
		this.maquyen = maquyen;
	}
	public int getmanguoidung() {
		return manguoidung;
	}

	public void setmanguoidung(int ma) {
		this.manguoidung = ma;
	}
	public String gethoten() {
		return hoten;
	}
	public void sethoten(String hoten) {
		this.hoten = hoten;
	}
	public String getdiachi() {
		return diachi;
	}
	public void setdiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getemail()
	{
		return email;
	}
	public void setemail(String email)
	{
		this.email=email;
	}
	public String gettaikhoan()
	{
		return taikhoan;
	}
	public void settaikhoan(String taikhoan)
	{
		this.taikhoan=taikhoan;
	}
	public String getmatkhau()
	{
		return matkhau;
	}
	public void setmatkhau(String matkhau)
	{
		this.matkhau=matkhau;
	}
	public int getmaquyen()
	{
		return maquyen;
	}
	public void setmaquyen(int maquyen)
	{
		this.maquyen= maquyen;
	}
}

