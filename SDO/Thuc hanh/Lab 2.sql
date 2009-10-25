Create Database Lab2

Use Lab2

Create Table PhongBan
(
	MaPB int not null primary key,
	TenPhong nvarchar(30) not null
)

Create Table NhanVien
(
	MaNV int primary key,
	TenNV nvarchar(30) not null,
	NgaySinh datetime not null check (YEAR(NgaySinh) < YEAR (GETDATE()) - 18),
	GioiTinh bit Default 1,
	SoCMT int not null unique check (len(SoCMT)<10),
	DiaChi nvarchar(50) not null,
	NgayVaoLam datetime check (YEAR(NgayVaoLam) < YEAR (GETDATE())),
	MaPB int References PhongBan(MaPB)
)

Create Table LuongDa
(
	MaDA int not null,
	MaNV int not null References NhanVien(MaNV),
	NgayNhan datetime check (YEAR(NgayNhan) < YEAR (GETDATE())),
	SoTien money
	Primary key (MaDA,MaNV)
)
--------------------------------------

--1:
CREATE NONCLUSTERED INDEX nonClusterdIndex 
	ON NhanVien(MaNV)

--2: Tạo index bằng cách "cài đè" index mới lên index cũ đã có.

Exec sp_helpindex 'PhongBan'
 
CREATE UNIQUE CLUSTERED INDEX PK__PhongBan__7C8480AE
	ON PhongBan(MaPB)
	WITH ( 
	Pad_index = ON,  
	FILLFACTOR= 70, 
	DROP_EXISTING = ON 
	)

--3:

Exec sp_helpindex 'NhanVien'