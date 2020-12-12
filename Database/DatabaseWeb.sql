CREATE DATABASE WebThuVien
GO
USE WebThuVien
GO
CREATE TABLE CuonSach(
	MaSach INT NOT NULL PRIMARY KEY,
	LinkBia NVARCHAR (MAX),
	TenSach NVARCHAR (MAX),
	ChiTiet NVARCHAR (MAX)
)
GO
CREATE TABLE PhanQuyen(
	MaQuyen INT NOT NULL PRIMARY KEY,
	Quyen NVARCHAR (MAX)
)
GO
CREATE TABLE NguoiDung(
	MaNguoiDung INT NOT NULL PRIMARY KEY,
	HoTen NVARCHAR (MAX),
	DiaChi NVARCHAR (MAX),
	Email NVARCHAR (MAX),
	TaiKhoan NVARCHAR (MAX),
	MatKhau NVARCHAR (MAX),
	MaQuyen INT,
	FOREIGN KEY (MaQuyen) REFERENCES PhanQuyen(MaQuyen) 
)
GO
