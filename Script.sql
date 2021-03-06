	
/*
						I. Phần 1. Tạo CSDL và nhập liệu
*/
CREATE DATABASE QuanLyCuaHangThuCung
GO
USE QuanLyCuaHangThuCung

/*
USE master
DROP DATABASE QuanLyCuaHangThuCung
*/


/*
--------------------------------------TẠO BẢNG--------------------------------------
------------------------------------------------------------------------------------
1. NHANVIEN			-	Nhân viên
2. TAIKHOAN			-	Tài khoản
3. CHUCVU			-	Chức vụ
4. LOAI				-	Loài
5. GIONG			-	Giống thú cưng
6. THUCUNG			-	Thú cưng
7. SANPHAM			-	Sản phẩm
8. HOADON			-	Hóa đơn
9. CTHDTHUCUNG		-	Chi tiết hóa đơn thú cưng
10. CTHDSANPHAM		-	Chi tiết hóa đơn
11. KHUYENMAI		-	Khuyến mãi (mã giảm giá)
12. KHACHHANG		-	Thông tin khách hàng
*/


CREATE TABLE NHANVIEN(
	MANV VARCHAR(5) NOT NULL,
	HOTEN NVARCHAR(50),
	GIOITINH NVARCHAR(3),
	NGAYSINH DATE,
	DIACHI NVARCHAR(200),
	SDT VARCHAR(12) NOT NULL UNIQUE,
	CHUCVU VARCHAR(10), 
	LUONG INT,
	CMND VARCHAR(10) NOT NULL UNIQUE,
	CONSTRAINT PK_NHANVIEN PRIMARY KEY (MANV)
)

CREATE TABLE TAIKHOAN(	
	MANV VARCHAR(5),
	TENTK VARCHAR(50) NOT NULL,
	MATKHAU VARCHAR(50) NOT NULL,
	CONSTRAINT PK_TAIKHOAN PRIMARY KEY (TENTK)
)

CREATE TABLE CHUCVU(
	MACV VARCHAR(10) NOT NULL,
	DIENGIAI NVARCHAR(100)
	CONSTRAINT PK_CHUCVU PRIMARY KEY (MACV)
)

CREATE TABLE LOAI( 
	MALOAI VARCHAR(5) NOT NULL,
	TENLOAI NVARCHAR(20),
	CONSTRAINT PK_LOAI PRIMARY KEY (MALOAI)
)

CREATE TABLE GIONG(
	MAGIONG VARCHAR(10) NOT NULL,
	MALOAI VARCHAR(5),
	TENGIONG NVARCHAR(50),
	MOTA NVARCHAR(500)
	CONSTRAINT PK_GIONG PRIMARY KEY (MAGIONG)
)

CREATE TABLE THUCUNG
(
	MATC VARCHAR(5) NOT NULL,
	MAGIONG VARCHAR (10),
	DONGIA INT,
	CONSTRAINT PK_THUCUNG PRIMARY KEY (MATC)
)

CREATE TABLE SANPHAM(
	MASP VARCHAR(5) NOT NULL,
	LOAI VARCHAR(5),
	TENSP NVARCHAR(100),
	DONGIA INT,
	SL INT,
	CONSTRAINT PK_SANPHAM PRIMARY KEY (MASP)
)

CREATE TABLE HOADON(
	MAHD VARCHAR(10) NOT NULL,
	NGUOILAPHD VARCHAR(5),
	NGAYLAP DATETIME,
	MAKH VARCHAR(5),
	MAKM VARCHAR(10),
	CONSTRAINT PK_HOADON PRIMARY KEY (MAHD)
)

CREATE TABLE CTHOADONTHUCUNG(
	MAHD VARCHAR(10) NOT NULL,
	STT INT NOT NULL,
	MATC VARCHAR(5),
	SOLUONG INT,
	DONGIA INT,
	CONSTRAINT PK_CTHOADONTHUCUNG PRIMARY KEY (MAHD, STT)
)

CREATE TABLE CTHOADONSANPHAM(
	MAHD VARCHAR(10) NOT NULL,
	STT INT NOT NULL,
	MASP VARCHAR(5),
	SOLUONG INT,
	DONGIA INT,
	CONSTRAINT PK_CTHOADONSANPHAM PRIMARY KEY (MAHD, STT)
)

CREATE TABLE KHUYENMAI(
	MAKM VARCHAR(10) NOT NULL,
	GIATRIKM INT , 
	NGAYBD DATETIME,
	NGAYKT DATETIME,
	CONSTRAINT PK_KHUYENMAI PRIMARY KEY (MAKM)
)

CREATE TABLE KHACHHANG(
	MAKH VARCHAR (5) NOT NULL,
	HOTEN NVARCHAR(50),
	GIOITINH NVARCHAR(3),
	NGAYSINH DATE,
	DIACHI NVARCHAR(200),
	SDT VARCHAR(12) NOT NULL UNIQUE,
	CMND VARCHAR(10) NOT NULL UNIQUE,
	CONSTRAINT PK_KHACHHANG PRIMARY KEY (MAKH)
)

--------------------------------------TẠO RÀNG BUỘC KHÓA NGOẠI
ALTER TABLE TAIKHOAN ADD CONSTRAINT FK_TAIKHOAN_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN (MANV)

ALTER TABLE HOADON ADD CONSTRAINT FK_HOADON_NHANVIEN FOREIGN KEY (NGUOILAPHD) REFERENCES NHANVIEN (MANV)
ALTER TABLE HOADON ADD CONSTRAINT FK_HOADON_KHACHHANG FOREIGN KEY (MAKH) REFERENCES KHACHHANG(MAKH)
ALTER TABLE HOADON ADD CONSTRAINT FK_HOADON_KHUYENMAI FOREIGN KEY (MAKM) REFERENCES KHUYENMAI (MAKM)

ALTER TABLE CTHOADONTHUCUNG ADD CONSTRAINT FK_CTHOADONTHUCUNG_HOADON FOREIGN KEY (MAHD) REFERENCES HOADON (MAHD)
ALTER TABLE CTHOADONTHUCUNG ADD CONSTRAINT FK_CTHOADONTHUCUNG_THUCUNG FOREIGN KEY (MATC) REFERENCES THUCUNG(MATC)

ALTER TABLE CTHOADONSANPHAM ADD CONSTRAINT FK_CTHOADONSANPHAM_HOADON FOREIGN KEY (MAHD) REFERENCES HOADON (MAHD)
ALTER TABLE CTHOADONSANPHAM ADD CONSTRAINT FK_CTHOADONSANPHAM_SANPHAM FOREIGN KEY (MASP) REFERENCES SANPHAM(MASP)

ALTER TABLE THUCUNG ADD CONSTRAINT FK_THUCUNG_GIONG FOREIGN KEY (MAGIONG) REFERENCES GIONG (MAGIONG)

ALTER TABLE GIONG ADD CONSTRAINT FK_GIONG_MALOAI FOREIGN KEY (MALOAI) REFERENCES LOAI(MALOAI)

ALTER TABLE NHANVIEN ADD CONSTRAINT FK_NHANVIEN_CHUCVU FOREIGN KEY(CHUCVU) REFERENCES CHUCVU(MACV)

ALTER TABLE	SANPHAM ADD CONSTRAINT FK_SANPHAM_LOAI FOREIGN KEY (LOAI) REFERENCES LOAI(MALOAI) 


------------------------------------------ DỮ LIỆU MẪU------------------------------------

INSERT INTO LOAI VALUES
('DOG', N'Chó'),
('CAT', N'Mèo'),
('HAMS', N'Chuột hamster')

INSERT INTO GIONG VALUES
('HUSKY', 'DOG', N'Chó Husky', N'Chó Husky là một giống chó tuyết có nguồn gốc từ Sibir, Nga.\n 
Husky có vẻ đẹp quyến rũ, thân hình dũng mãnh, sức khỏe dẻo dai phi thường.
Là giống chó hiền lành, rất tình cảm, hay tò mò, ưa vận động, rất thích người và đặc biệt thân thiện với trẻ em. 
Ở Việt Nam, chó Husky rất được yêu thích và được săn đón bởi đông đảo những người yêu chó.'),

('CORGI', 'DOG', N'Chó Corgi', N'Chó Corgi là một giống chó nhỏ, chân ngắn nhưng thân dài, đuôi cụt và một đôi tai lớn.
Corgi có vẻ ngoài đáng yêu, cặp mông hình trái tim tạo nên nét quyến rũ và đã tạo nên cơn sốt ngắm mông Corgi.  
Là giống chó rất thông minh, biết vâng lời, có bản năng bảo vệ, rất tận tâm với chủ và thân thiện với trẻ em. 
Chúng rất điềm tĩnh, trung thành và đáng yêu, song rất cảnh giác trước người lạ.'),

('GOLDEN', 'DOG', N'Chó Golden Retriever', N'Chó Golden Retriever là một giống chó săn thượng hạng đến từ Scotland.
Golden có bộ lông vàng mượt khá sang trọng, khuôn mặt thường xuyên cười vui vẻ, tuy nhiên, lúc buồn lại tỏ vẻ đáng thương rõ ràng.
Là giống chó rất thông minh, dễ huấn luyện, luôn biết cách làm hài lòng chủ nhân và thích vui chơi cùng mọi người.
Golden rất điềm tĩnh, hiền lành và tình cảm, lại rất nhanh nhẹn và năng động.'),

('BRITISHSHH', 'CAT', N'Mèo Anh lông ngắn', N'Mèo Anh lông ngắn là một giống mèo cảnh có nguồn gốc từ Anh.
Chúng sở hữu một thân hình vô cùng mập mạp đáng yêu, nổi bật với khuôn mặt tròn và bộ lông màu xám xanh cổ điển và một cái đuôi to.
Tính cách của chúng tuy khá lười biếng tuy nhiên lại phù hợp với những người bận rộn không có quá nhiều thời gian và không đòi hỏi chủ nhân của chúng phải chải chuốt vệ sinh thường xuyên.'),

('ANGORA', 'CAT', N'Mèo Nga lông dài', N'Mèo Nga lông dài thực chất có nguồn gốc là giống mèo Angora Turkish, có xuất xứ từ Thổ Nhĩ Kỳ.
Mèo Nga sở hữu bộ lông dài trắng muốt như tuyết tuyệt đẹp, tuy nhiên không xù, thân hình nhỏ gọn, thanh thoát và quý phái.
Tính tình thông minh, linh hoạt, quấn chủ và hiền lành, mèo Nga được xem như loại mèo toàn diện nhất.'),

('SIAMESE', 'CAT', N'Mèo Xiêm', N'Mèo Xiêm là niềm tự hào của người Thái trong suốt nhiều thế kỷ.
Mèo Xiêm mang dáng vẻ thanh thoát, đôi chân cao và nhỏ nhắn cùng những bước đi uyển chuyển quý tộc.
Bộ lông rất ngắn nhưng khá dày và ôm sát cơ thể, lông thường có màu vàng kem.
Nổi bật nhất chính là phần lông ngay khuôn mặt, bàn chân, tai và đuôi thường có màu đậm hơn trên toàn cơ thể.
Chúng rất quấn chủ và thích chơi với chủ, khi một mình, chúng có thể tự chơi và ít khi nằm một chỗ.'),

('BEAR', 'HAMS', N'Hamster Bear', N'Hamster Bear, hay còn gọi là Hamster Syrian (được phát hiện lần đầu tiên tại Syria).
Hamster Bear là loài được yêu thích nhất ở Việt Nam cũng như trên thế giới hiện nay.
Lông hamster Bear thường có màu trắng, vàng, nâu đỏ...
Chúng có thân hình mập mạp, dễ nuôi, hiền lành và rất thân thiện, phù hợp cho trẻ em.
Nhưng với các cá thể hamster khác chúng có thể trở nên hung dữ và hiếu chiến.'),

('ROBOROVSKI', 'HAMS', N'Hamster Robo', N'Hamster Robo, là giống chuột đồng Mông Cổ.
Hamster Robo thường có màu trắng, nâu, bạch kim....
Là dòng nhỏ nhất nhưng lại khỏe mạnh nhất trong các loài hamster.
Do có kích thước nhỏ, Robo rất nhút nhát, hay bị giật mình. Sẽ phải mất khá lâu để bé Robo có thể quen và chơi đùa tự nhiên với bạn.
Trong trường hợp cảm thấy bị đe dọa, Robo có thể lăn đùng ra, nằm bất động để giả chết.'),

('WWHITE', 'HAMS', N'Hamster Winter White', N'Hamster Winter White, thường được gọi ngắn gọn là WW, là giống chuột đồng Siberia.
WW có rất nhiều màu sắc, phổ biến nhất là trắng, xám, vàng chanh, sọc nâu...
WW rất hiền, có thể nuôi cùng các bé Hamster khác, chúng cũng rất dạn người nên bạn dễ dàng bồng bế, vuốt ve.
Tuy nhiên WW khá nhút nhát với người lạ, thường co rúm lại như cục bông khi có người lạ nhiệt tình thái quá. 
Thậm chí có thể giả chết khi cảm thấy bị đe dọa, nhất là khi bị giật mình do có những âm thanh lớn.'),

('CAMPBELL', 'HAMS', N'Hamster Campbell', N'Hamster Campbell là giống chuột đồng Mông Cổ.
Hamster Campbell thường có màu trắng, đen, xám, sóc...
Là một con vật đáng yêu và sống hòa đồng với đồng loại nếu được ghép ở chung từ nhỏ. Khi đã lớn chúng khó lòng chấp nhận kẻ lạ xâm nhập vào lãnh thổ.
Chúng thường dữ hơn các loại khác, nên khó bắt bế hơn, và có thể cắn nếu cảm thấy sợ hãi hay bị đe doạ.
Chúng vẫn là thú nuôi tốt, tính tình hoạt bát năng động nhưng bạn cần có kinh nghiệm nuôi và trẻ em thì cần có sự hướng dẫn và giám sát.')

INSERT INTO THUCUNG VALUES
('TC001', 'ANGORA', 500000),
('TC002', 'BEAR', 9000),
('TC003', 'CAMPBELL', 7000),
('TC004', 'HUSKY', 700000),
('TC005', 'GOLDEN', 600000),
('TC006', 'BRITISHSHH', 500000)

INSERT INTO SANPHAM VALUES
('SP001', 'DOG', N'Thức ăn cho chó Royal Canin 500g', 115000, 50),
('SP002', 'DOG', N'Thức ăn cho chó lớn Iskhan Sentitive 1.2kg', 175000, 40),
('SP003', 'DOG', N'Thức ăn cho chó Pedigee Beef 1.5kg', 105000, 30),
('SP004', 'DOG', N'Bát thức ăn nhựa Ferplat 20x19x6cm', 125000, 50),
('SP005', 'CAT', N'Thức ăn khô cho mèo Royal 2kg', 335000, 30),
('SP006', 'CAT', N'Thức ăn khô cho mèo Home Cat 1.5kg', 200000, 50),
('SP007', 'CAT', N'Bát thức ăn CAT hình cá 13x4x12cm', 180000, 50),
('SP008', 'HAMS', N'Thức ăn trộn thường 350g', 20000, 100),
('SP009', 'HAMS', N'Bánh quy protein tổng hợp 300g', 15000, 100),
('SP010', 'HAMS', N'Bánh quy mài răng chó hamster 200g', 15000, 40),
('SP011', 'HAMS', N'Hạt hướng dương 500g', 20000, 50),
('SP012', 'HAMS', N'Chuồng laphong mica lớn', 130000, 5),
('SP013', 'HAMS', N'Lồng banh chạy cho hamster', 300000, 5)

Insert Into CHUCVU Values
('CHCH',N'Chủ cửa hàng'),
('NVBH',N'Nhân viên'),
('NVKH',N'Nhân viên kho')

Insert into NHANVIEN Values
('NV001',N'Võ Anh Tuấn',N'Nam','1/1/1990',N'Củ Chi','0987667890','CHCH',10000000,'291150800'),
('NV002',N'Võ Anh Tèo',N'Nam','1/2/1992',N'Mỹ Tho','0987678901','NVBH',5000000,'291150850'),
('NV003',N'Võ Thi Nở',N'Nữ','6/1/1995',N'Pháp','0987689012','NVKH',4500000,'291150900')

Insert into TAIKHOAN Values
('NV001','NV001','voanhtuan'),
('NV002','NV002','voanhteo'),
('NV003','NV003','vothino')


INSERT INTO KHACHHANG VALUES
('KH001',N'ABC',N'Nam','1/1/1990',N'Củ Chi','0987612345','291150550'),
('KH002',N'XYZ',N'Nam','1/2/1992',N'Mỹ Tho','0987623456','291150600'),
('KH003',N'YJK',N'Nữ','6/1/1995',N'Pháp','0987634567','291150700')

INSERT INTO KHUYENMAI VALUES
('NOEL2017', 30000, '12/20/2017', '12/31/2017'),
('TET2018', 50000, '1/1/2018', '1/10/2018')


INSERT INTO HOADON VALUES
('001', 'NV002', '12/24/2017', 'KH001', 'NOEL2017'),
('002', 'NV002', '12/29/2017', 'KH002', NULL),
('003', 'NV002', '1/2/2018', 'KH003', 'TET2018'),
('004', 'NV002', '1/2/2018', NULL, NULL)

INSERT INTO CTHOADONSANPHAM VALUES
('001', 1, 'SP001', 1, 115000),
('001', 2, 'SP004', 1, 125000),
('002', 1, 'SP008', 2, 20000), 
('002', 2, 'SP011', 2, 20000),
('002', 3, 'SP012', 1, 13000),
('003', 1, 'SP006', 1, 200000),
('004', 1, 'SP009', 1, 15000),
('004', 2, 'SP011', 2, 20000)

INSERT INTO CTHOADONTHUCUNG VALUES
('002', 1, 'TC002', 1, 90000),
('004', 1, 'TC003', 1, 70000) 

select *from LOAI
select *from GIONG
select *from THUCUNG
select *from SANPHAM
select *from NHANVIEN
select *from TAIKHOAN
select *from CHUCVU
select *from HOADON
select *from KHACHHANG
select *from KHUYENMAI
select *from CTHOADONSANPHAM
select *from CTHOADONTHUCUNG

create proc tim_tai_khoan @tentk varchar(50), @matkhau varchar (50)
as
	begin
		Select *
		From TAIKHOAN tk
		Where tk.TENTK = @tentk and tk.MATKHAU = @matkhau
	end
go

create proc tim_nhan_vien_theo_manv @manv VARCHAR(5)
as
	begin
		Select *
		From NHANVIEN nv
		Where nv.MANV = @manv
	end
go

create proc getAllNhanVien
as
begin
	Select * From NHANVIEN
end
go

create proc insertNhanVien @manv varchar(5), @hoten nvarchar(50), @gioitinh nvarchar(5), @ngaysinh date, @diachi nvarchar(200),
@sdt varchar(12), @chucvu varchar(10), @luong int, @cmnd varchar(10)
as
begin 
	Insert into NHANVIEN values
		(@manv, @hoten, @gioitinh, @ngaysinh, @diachi, @sdt, @chucvu, @luong, @cmnd)
end
go

create proc deleteNhanVien @manv varchar(5)
as
begin
	delete from NHANVIEN 
	where MANV = @manv
end
go

create proc findNhanVienByMANV @manv VARCHAR(5)
as
	begin
		Select *
		From NHANVIEN nv
		Where nv.MANV = @manv
	end
go

create proc insertTaiKhoan @manv varchar(5), @tentk varchar(50), @matkhau varchar(50)
as
begin
	Insert into TAIKHOAN values
	(@manv,@tentk,@matkhau)
end
go

create proc deleteTaiKhoan @manv varchar(5)
as
begin
	delete from TAIKHOAN
	where MANV = @manv 
end
go

create proc findTaiKhoan @tentk varchar(50)
as
begin
	select * 
	from TAIKHOAN
	where TENTK = @tentk
end
go

create proc insertLoai @maloai varchar(5), @tenloai nvarchar(20)
as
begin
	insert into Loai values
	(@maloai, @tenloai)
end
go

create proc deleteLoai @maloai varchar(5)
as
begin
	delete from LOAI
	where MALOAI = @maloai
end
go

create proc insertGiong @magiong varchar(10), @maloai varchar(5), @tengiong nvarchar(50), @mota nvarchar(500)
as 
begin 
	insert into GIONG values
	(@magiong,@maloai,@tengiong,@mota)
end
go

create proc deleteGiong @magiong varchar (10)
as
begin
	delete from GIONG
	where MAGIONG = @magiong
end
go

create proc insertThuCung @matc varchar(5), @magiong varchar(10), @dongia int
as
begin
	insert into THUCUNG  values
	(@matc,@magiong,@dongia)
end
go

create proc deleteThuCung @matc varchar(5)
as
begin
	delete from THUCUNG
	where MATC = @matc
end
go

create proc insertSanPham @masp varchar(5),@loai varchar(5),@tensp varchar(100), @dongia int, @soluong int
as
begin 
	insert into SANPHAM values
	(@masp,@loai,@tensp,@dongia,@soluong)
end
go

create proc deleteSanPham @masp varchar(5)
as
begin
	delete from SANPHAM
	where MASP = @masp
end
go

create proc insertKhachHang @makh varchar(5), @tenkh nvarchar(50), @gioitinh nvarchar(5), @ngaysinh date, @diachi nvarchar(200), @sdt varchar(12), @cmnd varchar(10)
as
begin
	insert into KHACHHANG values
	(@makh,@tenkh,@gioitinh, @ngaysinh, @diachi,@sdt,@cmnd)

end
go

create proc deleteKhachHang @makh varchar(5)
as
begin
	delete from KHACHHANG 
	where MAKH = @makh
end
go

create proc insertKhuyenMai @makm varchar(10), @giatrikm int, @ngaybd date, @ngaykt date
as
begin
	insert into KHUYENMAI values
	(@makm,@giatrikm,@ngaybd,@ngaykt) 
end
go

create proc deleteKhuyenMai @makm varchar(10)
as
begin
	delete from KHUYENMAI
	where MAKM = @makm
end
go

create proc updateUserInfo @manv varchar(5), @hoten nvarchar(50), @gioitinh nvarchar(5), @ngaysinh date, @diachi nvarchar(200),
@sdt varchar(12), @cmnd varchar(10)
as
begin 
	Update NHANVIEN
	Set HOTEN = @hoten, GIOITINH = @gioitinh, NGAYSINH = @ngaysinh, DIACHI = @diachi, SDT = @sdt, CMND = @cmnd 
	Where MANV = @manv
end
go



create proc getExtendedNhanVien
as
	begin
		Select nv.*,tk.TENTK,tk.MATKHAU
		From NHANVIEN nv, TAIKHOAN tk
		Where nv.MANV = tk.MANV
	end
go

create proc lay_danh_sach_vat_nuoi
as
	begin
		SELECT TENLOAI, MALOAI
		From LOAI 
	end
go

create proc lay_danh_sach_vat_nuoi_theo_ma_giong @magiong VARCHAR(10)
as
	begin
		SELECT MATC, DONGIA
		From THUCUNG
		where MAGIONG = @magiong
	end 
go

create proc lay_danh_sach_vat_nuoi_theo_loai @maloai VARCHAR(5)
as
	begin
		SELECT G.MALOAI, T.MAGIONG, T.MATC, T.DONGIA
		FROM GIONG G JOIN THUCUNG T ON G.MAGIONG = T.MAGIONG
		WHERE G.MALOAI = @maloai
	end
go

create proc lay_danh_sach_giong_vat_nuoi @maloai VARCHAR(5)
as
	begin
		SELECT TENGIONG, MAGIONG, MOTA
		From GIONG
		Where MALOAI = @maloai
	end
go

create proc lay_danh_sach_san_pham_theo_loai @maloai VARCHAR(5)
as
	begin
		SELECT MASP, TENSP, DONGIA, SL
		From SANPHAM
		Where LOAI = @maloai
	end
go

create proc lay_danh_sach_san_pham_theo_loai_DK @maloai VARCHAR(5), @name NVARCHAR(100)
as
	begin
		SELECT MASP, TENSP, DONGIA, SL
		From SANPHAM
		Where LOAI = @maloai and TENSP like @name
	end
go


CREATE PROC sua_thu_cung @maTC VARCHAR(5), @donGia INT
AS
	BEGIN
		UPDATE THUCUNG
		SET DONGIA = @donGia
		WHERE MATC = @maTC
	END
GO

--sua_thu_cung '200', 1000

CREATE PROC xoa_thu_cung @maTC VARCHAR(5)
AS
	BEGIN
		DELETE FROM THUCUNG
		WHERE MATC = @maTC
	END
GO
--xoa_thu_cung '200'

-- Sản phẩm
CREATE PROC sua_san_pham @maSP VARCHAR(5), @tenSP NVARCHAR(100), @donGia INT
AS
	BEGIN
		UPDATE SANPHAM
		SET TENSP = @tenSP, DONGIA = @donGia
		WHERE MASP = @maSP
	END
GO

CREATE PROC them_san_pham @maSP VARCHAR(5), @soluong INT
AS
	BEGIN
		UPDATE SANPHAM
		SET SL = SL + @soluong
		WHERE MASP = @maSP
	END
GO

--them_san_pham '100', 50

CREATE PROC xoa_san_pham @maSP VARCHAR(5)
AS
	BEGIN
		DELETE FROM SANPHAM
		WHERE MASP = @maSP
	END
GO

select *from LOAI
select *from GIONG
select *from THUCUNG
select *from SANPHAM
select *from NHANVIEN
select *from TAIKHOAN
select *from KHACHHANG


create proc updateKhachHangInfo @makh varchar(5), @hoten nvarchar(50), @gioitinh nvarchar(5), @ngaysinh date, @diachi nvarchar(200), 
@sdt varchar(12), @cmnd varchar(10)
as
begin 
	Update KHACHHANG
	Set HOTEN = @hoten, GIOITINH = @gioitinh, NGAYSINH = @ngaysinh, DIACHI = @diachi, SDT = @sdt, CMND = @cmnd 
	Where MAKH = @makh
end
go

create proc checkKhachHangExist @makh varchar(5)
as
begin 
	Select count(*) as Result
	From KHACHHANG
	Where MAKH = @makh
end
go

--updateKhachHangInfo 'KH001', N'ABC', N'Nam', '12/11/1997', N'Chu Chi', '1234567890', '029374678' 
--checkKhachHangExist 'KH004'

create proc getAllHoaDon
as
begin
	SELECT *
	FROM HOADON
end
go

create proc getHoaDon @ngaybd datetime, @ngaykt datetime
as
begin 
	SELECT *
	FROM HOADON
	WHERE @ngaybd <= NGAYLAP AND NGAYLAP <= @ngaykt
end
go

create proc getCTHDSP @maHD varchar(10)
as
begin
	SELECT *
	FROM CTHOADONSANPHAM
	WHERE MAHD = @maHD
end
go

create proc getCTHDTC @maHD varchar(10)
as
begin
	SELECT *
	FROM CTHOADONTHUCUNG
	WHERE MAHD = @maHD
end
go

create proc getTongTienHDSP @maHD varchar(10)
as
begin
	SELECT SUM(SOLUONG*DONGIA)as TONG
	FROM CTHOADONSANPHAM
	WHERE MAHD = @maHD
end
go

create proc getTongTienHDTC @maHD varchar(10)
as
begin
	SELECT SUM(SOLUONG*DONGIA)as TONG
	FROM CTHOADONTHUCUNG
	WHERE MAHD = @maHD
end
go

create proc XuatHoaDon @NgayBD VARCHAR(50), @NgayKT VARCHAR(50)
as
	begin
		Select temp.MAHD, temp.NGUOILAPHD, temp.NGAYLAP, temp.MAKH, temp.MAKM, SUM(temp.Tong) TONG
		from
			(Select hd.*, SUM(ctsp.DONGIA*ctsp.SOLUONG ) Tong
			From HOADON hd join CTHOADONSANPHAM ctsp on hd.MAHD = ctsp.MAHD
			Where hd.NGAYLAP >= @NgayBD and hd.NGAYLAP <= @NgayKT
			group by hd.MAHD, hd.NGUOILAPHD, hd.NGAYLAP, hd.MAKH, hd.MAKM
			UNION
			Select hd.*, SUM(cttc.DONGIA*cttc.SOLUONG) Tong
			From HOADON hd join CTHOADONTHUCUNG cttc on hd.MAHD = cttc.MAHD
			Where hd.NGAYLAP >= @NgayBD and hd.NGAYLAP <= @NgayKT
			group by hd.MAHD, hd.NGUOILAPHD, hd.NGAYLAP, hd.MAKH, hd.MAKM
			
			UNION
			SELECT hd.*, -k.GIATRIKM Tong
			FROM HOADON hd join KHUYENMAI k on hd.MAKM = k.MAKM
			Where hd.NGAYLAP >= @NgayBD and hd.NGAYLAP <= @NgayKT
			
			) temp
		group by temp.MAHD, temp.NGUOILAPHD, temp.NGAYLAP, temp.MAKH, temp.MAKM
	end
go
--XuatHoaDon '12/30/2017', '2/2/2018'

create proc XuatDanhSachSanPhamDaBan @ngayBD varchar(50), @ngayKT varchar(50)
as
	begin
		SELECT SP.TENSP, SUM(CTSP.SOLUONG) SOLUONG
		FROM CTHOADONSANPHAM CTSP JOIN SANPHAM SP ON CTSP.MASP = SP.MASP
		WHERE EXISTS (	SELECT *
						FROM HOADON HD
						WHERE HD.NGAYLAP >= @ngayBD AND HD.NGAYLAP <= @ngayKT
							AND HD.MAHD = CTSP.MAHD)
		GROUP BY SP.TENSP
	end
go
--XuatDanhSachSanPhamDaBan '12/30/2017', '2/2/2018'

create proc XuatDanhSachThuCungDaBan @ngayBD varchar(50), @ngayKT varchar(50)
as
	begin
		SELECT G.TENGIONG, SUM(CTTC.SOLUONG) SOLUONG
		FROM (CTHOADONTHUCUNG CTTC JOIN THUCUNG TC ON CTTC.MATC = TC.MATC) JOIN GIONG G ON TC.MAGIONG = G.MAGIONG 
		WHERE EXISTS (	SELECT *
						FROM HOADON HD
						WHERE HD.NGAYLAP >= @ngayBD AND HD.NGAYLAP <= @ngayKT
							AND HD.MAHD = CTTC.MAHD
						)
		GROUP BY G.TENGIONG
	end
go
--XuatDanhSachThuCungDaBan '12/20/2017', '2/2/2018'

create proc TimKiemNhanVienTheoHoTen @hoten nvarchar(50)
as
	begin
		Select nv.*,tk.TENTK,tk.MATKHAU
		From NHANVIEN nv, TAIKHOAN tk
		Where nv.MANV = tk.MANV and nv.HOTEN like @hoten
	end
go


create proc TimKiemNhanVienTheoMaNV @manv varchar(5)
as
	begin
		Select nv.*,tk.TENTK,tk.MATKHAU
		From NHANVIEN nv, TAIKHOAN tk
		Where nv.MANV = tk.MANV and nv.MANV like @manv
	end
go

create proc TimKiemNhanVienTheoCMND @CMND varchar(10)
as
	begin
		Select nv.*,tk.TENTK,tk.MATKHAU
		From NHANVIEN nv, TAIKHOAN tk
		Where nv.MANV = tk.MANV and nv.CMND like @CMND
	end
go

create proc TimKiemNhanVienTheoTenTK @tentk varchar(50)
as
	begin
		Select nv.*,tk.TENTK,tk.MATKHAU
		From NHANVIEN nv, TAIKHOAN tk
		Where nv.MANV = tk.MANV and tk.TENTK = @tentk
	end
go

TimKiemNhanVienTheoTenTK  N'%Nở%'

create proc XemChiTietHoaDon @maHD varchar(10)
as
	begin
		SELECT SP.TENSP TEN, CTSP.SOLUONG, CTSP.DONGIA
		FROM CTHOADONSANPHAM CTSP JOIN SANPHAM SP ON CTSP.MASP = SP.MASP
		WHERE CTSP.MAHD = @maHD
		UNION
		SELECT G.TENGIONG TEN, CTTC.SOLUONG, CTTC.DONGIA
		FROM CTHOADONTHUCUNG CTTC JOIN THUCUNG TC ON CTTC.MATC = TC.MATC JOIN GIONG G ON TC.MAGIONG = G.MAGIONG
		WHERE CTTC.MAHD = @maHD
	end
go

create proc TimKhachHangbyMaKH @maKH varchar(5)
as
	begin
		SELECT *
		FROM KHACHHANG
		WHERE MAKH = @maKH
	end
go

TimKhachHangbyMaKH '001'
XemChiTietHoaDon '001'


create proc newMaHD
as
	begin
		SELECT COUNT(*) + 1 MAHD
		FROM HOADON
	end
go


