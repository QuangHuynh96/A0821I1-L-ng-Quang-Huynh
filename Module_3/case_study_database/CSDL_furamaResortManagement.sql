create database furamaResortManagement;
use furamaResortManagement;

 create table vi_tri (
 id int not null auto_increment primary key,
 ten varchar(45) not null
 );
 
  create table trinh_do(
 id int not null auto_increment primary key,
 ten varchar(45) not null
 );
 
   create table bo_phan(
 id int not null auto_increment primary key,
 ten varchar(45) not null
 );
 
  create table loai_khach (
 id int not null auto_increment primary key,
 ten varchar(45) not null
 );
 
  create table loai_dich_vu (
 id int not null auto_increment primary key,
 ten varchar(45) not null
 );
 
 create table dich_vu_di_kem (
 id int not null auto_increment primary key,
 ten varchar(45) not null,
 gia double,
 don_vi varchar(10) ,
 trang_thai varchar(45)
 );
 
  create table kieu_thue (
 id int not null auto_increment primary key,
 ten varchar(45) not null
 );
 
 
 create table nhan_vien (
 id int not null auto_increment primary key,
 ten varchar(45) not null,
 ngay_sinh date,
 cmnd int,
 luong int,
 so_dien_thoai varchar(45),
 email varchar(45) ,
 dia_chi varchar(45) ,
 id_vi_tri int,
 id_trinh_do int,
 id_bo_phan int,
 foreign key (id_vi_tri) references vi_tri (id),
 foreign key (id_trinh_do) references trinh_do (id),
 foreign key (id_bo_phan) references bo_phan (id)
 );
 
 create table khach_hang(
 id int not null auto_increment primary key,
 id_loai_khach int,
 ten varchar(45),
 ngay_sinh date,
 gioi_tinh bit default 1,
 cmnd varchar(45) ,
 so_dien_thoai varchar(45) ,
 email varchar(45) ,
 dia_chi varchar(45) ,
 foreign key(id_loai_khach) references loai_khach(id)
 );
 
 
 create table dich_vu (
 id int not null auto_increment primary key,
 id_kieu_thue int,
 id_loai_dich_vu int,
 ten varchar(45) ,
 dien_tich int ,
 chi_phi_thue double ,
 so_nguoi_toi_da int ,
 tieu_chuan_phong varchar(45) ,
 mo_ta_tien_nghi_khac varchar(45),
 dien_tich_ho_boi int,
 so_tang int,
 foreign key (id_kieu_thue) references kieu_thue(id),
 foreign key (id_loai_dich_vu) references loai_dich_vu(id)
 );
 
 create table hop_dong (
 id int not null auto_increment primary key,
 id_nhan_vien int,
 id_khach_hang int,
 id_dich_vu int,
 ngay_lam_hop_dong datetime ,
 ngay_ket_thuc datetime ,
 tien_dat_coc double ,
 foreign key(id_nhan_vien) references nhan_vien (id),
 foreign key(id_khach_hang) references khach_hang (id),
 foreign key(id_dich_vu) references dich_vu(id)
 );
 
 create table hop_dong_chi_tiet (
 id int not null auto_increment primary key,
 id_hop_dong int,
 id_dich_vu_di_kem int ,
 so_luong int,
 foreign key(id_hop_dong) references hop_dong(id),
 foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id)
 );
 
 -- 1.	Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thoả mãn các yêu cầu bên dưới.
-- vị trí.
insert into vi_tri (ten)
values ('Quản lí'), ('Nhân viên');
-- select * from vi_tri;

-- trình độ.
insert into trinh_do (ten) 
values ('Trung cấp'), ('Cao đẳng'), ('Đại học'), ('sau Đại học');
-- select * from trinh_do;

-- bộ phận.
insert into bo_phan (ten)
values ('Sale Marketing'), ('Hành chính'), ('Phục vụ'), ('Quản lí');
-- select * from bo_phan;

-- Nhân viên
insert into nhan_vien (ten, ngay_sinh, cmnd, luong, so_dien_thoai, email, dia_chi, id_vi_tri, id_trinh_do, id_bo_phan)
values  ('Nguyễn Văn An', '1970-11-7', 456231786, 10000000, 0901234121, 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', 1, 3, 1),
		('Lê Văn Bình', '1997-04-09', 654231234, 7000000, 0934212314, 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2),
        ('Hồ Thị Yến', '1995-12-12', 999231723, 14000000, 0412352315, 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2),
        ('Võ Công Toản', '1980-04-04', 123231365, 17000000, 0374443232, 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4),
        ('Nguyễn Bỉnh Phát', '1999-12-09', 454363232, 6000000, 0902341231, 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1),
		('Khúc Nguyễn An Nghi', '2000-11-08', 964542311, 7000000, 0978653213, 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3),
        ('Nguyễn Hữu Hà', '1993-01-01', 534323231, 8000000, 0941234553, 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),
        ('Nguyễn Hà Đông', '1989-09-03', 234414123, 9000000, 0642123111, 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4),
        ('Tòng Hoang', '1982-09-03', 256781231, 6000000, 0245144444, 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),
        ('Nguyễn Công Đạo', '1994-01-08', 755434343, 8000000, 0988767111, 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2);
-- select * from nhan_vien;


-- loại khách.
insert into loai_khach (ten)
values ('Diamond'), ('Platinium'), ('Gold'), ('Silver'),('Menber');
-- select * from loai_khach;

-- khách hàng
insert into khach_hang(id_loai_khach, ten, ngay_sinh, gioi_tinh, cmnd, so_dien_thoai, email, dia_chi)
values 	(5, 'Nguyễn Thị Hào', '1970-11-07', 0, 643431213, 0945423362, 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng'),
		(3, 'Phạm Xuân Diệu', '1992-08-08', 1, 865342123, 0954333333, 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị'),
        (1, 'Trương Đình Nghệ', '1990-02-27', 1, 488645199, 0373213122, 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh'),
        (1, 'Dương Văn Quan', '1981-07-08', 1, 543432111, 0490039241, 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng'),
        (4, 'Hoàng Trần Nhi Nhi', '1995-12-09', 0, 795453345, 0312345678, 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai'),
        (4, 'Tôn Nữ Mộc Châu', '2005-12-06', 0, 732434215, 0988888844, 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng'),
        (1, 'Nguyễn Mỹ Kim', '1984-04-08', 0, 856453123, 0912345698, 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh'),
        (3, 'Nguyễn Thị Hào', '1999-04-08', 0, 965656433, 0763212345, 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum'),
        (1, 'Trần Đại Danh', '1994-07-01', 1, 432341235, 0643343433, 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi'),
        (2, 'Nguyễn Tâm Đắc', '1989-07-01', 1, 344343432, 0987654321, 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng');
-- select * from khach_hang;

-- kiểu thuê.
insert into kieu_thue(ten)
values ('year'), ('month'), ('day'), ('hour');
-- select * from kieu_thue;

-- loại dịch vụ
insert into loai_dich_vu(ten)
values ('Villa'), ('House'), ('Room');
-- select * from loai_dich_vu;

-- dịch vụ
insert into dich_vu(id_kieu_thue, id_loai_dich_vu, ten, dien_tich, chi_phi_thue, so_nguoi_toi_da, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang)
values 	(3, 1, 'Villa Beach Front', 25000, 10000000, 10, 'vip', 'có hồ bơi', 500, 4),
		(2, 2, 'House Princess 01', 14000, 5000000, 7, 'vip', 'có thêm bếp nướng', null, 3),
        (4, 3, 'Room Twin 01', 5000, 1000000, 2, 'normal', 'có tivi', null, null),
        (3, 1, 'Villa No Beach Front', 22000, 9000000, 8, 'normal', 'có hồ bơi', 300, 3),
        (3, 2, 'House Princess 02', 10000, 4000000, 5, 'normal', 'có thêm bếp nướng', null, 2),
        (4, 3, 'Room Twin 02', 3000, 900000, 2, 'normal', 'có tivi', null, null);
-- select * from dich_vu;

-- dịch vụ đi kèm.
insert into dich_vu_di_kem (ten, gia, don_vi, trang_thai)
values 	('Karaoke', 10000, 'giờ', 'tiện nghi, hiện đại'),
		('thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
        ('thuê xe đạp', 10000, 'giờ', 'tốt'),
        ('Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
        ('Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
        ('Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');
-- select * from dich_vu_di_kem;

-- hợp đồng
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc)
values 	(3, 1, 3, '2020-12-08', '2020-12-08', 0),
		(7, 3, 1, '2020-07-14', '2020-07-21', 200000),
        (3, 4, 2, '2021-03-15', '2021-03-17', 50000),
        (7, 5, 5, '2021-01-14', '2021-01-18', 100000),
        (7, 2, 6, '2021-07-14', '2021-07-15', 0),
        (7, 7, 6, '2021-06-01', '2021-06-03', 0),
        (7, 4, 4, '2021-09-02', '2021-09-05', 100000),
        (3, 4, 1, '2021-06-17', '2021-06-18', 0),
        (3, 4, 3, '2020-11-19', '2020-11-19', 0),
        (10, 3, 5, '2021-04-25', '2021-04-25', 0),
        (2, 2, 1, '2020-12-08', '2020-12-08', 0),
        (7, 10, 1, '2021-05-25', '2021-05-27', 0);
-- select * from hop_dong;

-- hợp đông chi tiết
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong)
values 	(2,4,5),
		(2,5,8),
        (2,6,15),
        (3,1,1),
        (3,2,11),
        (1,3,1),
        (1,2,2),
        (12,2,2);
-- select * from hop_dong_chi_tiet;

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên 
-- bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * 
from nhan_vien
where ( ten like 'H%') or (ten like 'K%') or (ten like 'T%')
and  (length(ten)  <= 15); 

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi
--  và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * 
from khach_hang
where ngay_sinh between '1972-00-00' and '2004-00-00' 
and (dia_chi like '%Đà Nẵng') or (dia_chi like '%Quảng Trị');

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”. 
select khach_hang.ten, count(id_khach_hang) as so_lan_dat_phong
from hop_dong join khach_hang on khach_hang.id = hop_dong.id_khach_hang
join loai_khach on khach_hang.id_loai_khach = loai_khach.id
where loai_khach.ten = 'Diamond'
group by id_khach_hang
order by so_lan_dat_phong asc;

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá,
--  với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet)
--  cho tất cả các khách hàng đã từng đặt phòng. 
-- (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select id_khach_hang as 'id', khach_hang.ten as 'khách hàng', loai_khach.ten as 'loại khách', hop_dong.id as 'mã hợp đồng', dich_vu.ten as 'dịch vụ',
ngay_lam_hop_dong, ngay_ket_thuc, dich_vu.chi_phi_thue + sum(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia) as tong_tien 
from 
khach_hang
left join loai_khach on loai_khach.id = khach_hang.id_loai_khach
left join hop_dong on khach_hang.id = hop_dong.id_khach_hang
left join dich_vu on hop_dong.id_dich_vu = dich_vu.id
left join hop_dong_chi_tiet on hop_dong.id = hop_dong_chi_tiet.id_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.id = hop_dong_chi_tiet.id_dich_vu_di_kem
group by hop_dong.id
order by id asc;

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).

select dv.id, dv.ten, dv.dien_tich, dv.chi_phi_thue, ldv.ten as loai_dich_vu
from dich_vu dv join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id;
