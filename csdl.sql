
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
	SDT VARCHAR(12),
	CHUCVU VARCHAR(10), 
	LUONG INT,
	CMND VARCHAR(10),
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
	NGAYLAP DATETIME,
	NGUOILAPHD VARCHAR(5),
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
	TENKH NVARCHAR(50),
	DIACHI NVARCHAR(200),
	SDT VARCHAR(12),
	CMND VARCHAR(10),
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
('001', 'ANGORA', 5000000),
('002', 'BEAR', 90000),
('003', 'CAMPBELL', 70000),
('004', 'HUSKY', 7000000),
('005', 'GOLDEN', 6000000),
('006', 'BRITISHSHH', 5000000)

INSERT INTO SANPHAM VALUES
('001', 'DOG', N'Thức ăn cho chó Royal Canin 500g', 115000, 50),
('002', 'DOG', N'Thức ăn cho chó lớn Iskhan Sentitive 1.2kg', 175000, 40),
('003', 'DOG', N'Thức ăn cho chó Pedigee Beef 1.5kg', 105000, 30),
('004', 'DOG', N'Bát thức ăn nhựa Ferplat 20x19x6cm', 125000, 50),
('005', 'CAT', N'Thức ăn khô cho mèo Royal 2kg', 335000, 30),
('006', 'CAT', N'Thức ăn kho cho mèo Home Cat 1.5kg', 200000, 50),
('007', 'CAT', N'Bát thức ăn CAT hình cá 13x4x12cm', 180000, 50),
('008', 'HAMS', N'Thức ăn trộn thường 350g', 20000, 100),
('009', 'HAMS', N'Bánh quy protein tổng hợp 300g', 15000, 100),
('010', 'HAMS', N'Bánh quy mài răng chó hamster 200g', 15000, 40),
('011', 'HAMS', N'Hạt hướng dương 500g', 20000, 50),
('012', 'HAMS', N'Chuồng laphong mica lớn', 130000, 5),
('013', 'HAMS', N'Lồng banh chạy cho hamster', 300000, 5)


Insert Into CHUCVU Values
('CHCH',N'Chủ cửa hàng'),
('NVBH',N'Nhân viên'),
('NVKH',N'Nhân viên kho')

Insert into NHANVIEN Values
('NV001',N'Võ Anh Tuấn',N'Nam','1/1/1990',N'Củ Chi','0987628348','CHCH','1246766','1234587683'),
('NV002',N'Võ Anh Tèo',N'Nam','1/2/1992',N'Mỹ Tho','0987628348','NVBH','12467606','1234587628'),
('NV003',N'Võ Thi Nở',N'Nữ','6/1/1995',N'Pháp','0987628348','NVKH','12467696','1234582768')

Insert into TAIKHOAN Values
('NV001','NV001','voanhtuan'),
('NV002','NV002','voanhteo'),
('NV003','NV003','vothino')



select *from LOAI
select *from GIONG
select *from THUCUNG
select *from SANPHAM
select *from NHANVIEN
select *from TAIKHOAN

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

create proc deleteNhanVien @manv varchar(5)
as
begin
	delete from NHANVIEN 
	where MANV = @manv
end

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

create proc deleteTaiKhoan @manv varchar(5)
as
begin
	delete from TAIKHOAN
	where MANV = @manv 
end

create proc findTaiKhoan @tentk varchar(50)
as
begin
	select * 
	from TAIKHOAN
	where TENTK = @tentk
end


create proc insertLoai @maloai varchar(5), @tenloai nvarchar(20)
as
begin
	insert into Loai values
	(@maloai, @tenloai)
end


create proc deleteLoai @maloai varchar(5)
as
begin
	delete from LOAI
	where MALOAI = @maloai
end

create proc insertGiong @magiong varchar(10), @maloai varchar(5), @tengiong nvarchar(50), @mota nvarchar(500)
as 
begin 
	insert into GIONG values
	(@magiong,@maloai,@tengiong,@mota)
end

create proc deleteGiong @magiong varchar (10)
as
begin
	delete from GIONG
	where MAGIONG = @magiong
end

create proc insertThuCung @matc varchar(5), @magiong varchar(10), @dongia int
as
begin
	insert into THUCUNG  values
	(@matc,@magiong,@dongia)
end

create proc deleteThuCung @matc varchar(5)
as
begin
	delete from THUCUNG
	where MATC = @matc
end

create proc insertSanPham @masp varchar(5),@loai varchar(5),@tensp varchar(100), @dongia int, @soluong int
as
begin 
	insert into SANPHAM values
	(@masp,@loai,@tensp,@dongia,@soluong)
end

create proc deleteSanPham @masp varchar(5)
as
begin
	delete from SANPHAM
	where MASP = @masp
end


create proc insertKhachHang @makh varchar(5), @tenkh nvarchar(50), @diachi nvarchar(200), @sdt varchar(12), @cmnd varchar(10)
as
begin
	insert into KHACHHANG values
	(@makh,@tenkh,@diachi,@sdt,@cmnd)

end

create proc deleteKhachHang @makh varchar(5)
as
begin
	delete from KHACHHANG 
	where MAKH = @makh
end

create proc insertKhuyenMai @makm varchar(10), @giatrikm int, @ngaybt date, @ngaykt date
as
begin
	insert into KHUYENMAI values
	(@makm,@giatrikm,@ngaybt,@ngaykt) 
end

create proc deleteKhuyenMai @makm varchar(10)
as
begin
	delete from KHUYENMAI
	where MAKM = @makm
end


create proc updateUserInfo @manv varchar(5), @hoten nvarchar(50), @gioitinh nvarchar(5), @ngaysinh date, @diachi nvarchar(200),
@sdt varchar(12), @cmnd varchar(10)
as
begin 
	Update NHANVIEN
	Set HOTEN = @hoten, GIOITINH = @gioitinh, NGAYSINH = @ngaysinh, DIACHI = @diachi, SDT = @sdt, CMND = @cmnd 
	Where MANV = @manv
end

create proc getExtendedNhanVien
as
	begin
		Select nv.*,tk.TENTK,tk.MATKHAU
		From NHANVIEN nv, TAIKHOAN tk
		Where nv.MANV = tk.MANV
	end
go



select *from LOAI
select *from GIONG
select *from THUCUNG
select *from SANPHAM
select *from NHANVIEN
select *from TAIKHOAN
