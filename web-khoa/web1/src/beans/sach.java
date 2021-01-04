package beans;


public class sach {
	private int masach;
	private String linkbia;
	private String tensach;
	private String chitiet;
	private String theloai;
	
	public sach() {
	}
	public sach(int masach, String linkbia, String tensach, String chitiet, String theloai) {
		super();
		this.masach = masach;
		this.linkbia = linkbia;
		this.tensach = tensach;
		this.chitiet = chitiet;
		this.theloai =theloai;
	}
	public int getmasach() {
		return masach;
	}

	public void setmasach(int masach) {
		this.masach = masach;
	}
	public String getlinkbia() {
		return linkbia;
	}
	public void setlinkbia(String linkbia) {
		this.linkbia = linkbia;
	}
	public String gettensach() {
		return tensach;
	}
	public void settensach(String tensach) {
		this.tensach = tensach;
	}
	public String getchitiet()
	{
		return chitiet;
	}
	public void setchitiet(String chitiet)
	{
		this.chitiet=chitiet;
	}
	public String gettheloai()
	{
		return theloai;
	}
	public void settheloai(String theloai)
	{
		this.theloai=theloai;
	}
}

