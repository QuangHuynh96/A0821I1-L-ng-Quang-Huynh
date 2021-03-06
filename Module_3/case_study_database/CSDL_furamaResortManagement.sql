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
 
 -- 1.	Th??m m???i th??ng tin cho t???t c??? c??c b???ng c?? trong CSDL ????? c?? th??? tho??? m??n c??c y??u c???u b??n d?????i.
-- v??? tr??.
insert into vi_tri (ten)
values ('Qu???n l??'), ('Nh??n vi??n');
-- select * from vi_tri;

-- tr??nh ?????.
insert into trinh_do (ten) 
values ('Trung c???p'), ('Cao ?????ng'), ('?????i h???c'), ('sau ?????i h???c');
-- select * from trinh_do;

-- b??? ph???n.
insert into bo_phan (ten)
values ('Sale Marketing'), ('H??nh ch??nh'), ('Ph???c v???'), ('Qu???n l??');
-- select * from bo_phan;

-- Nh??n vi??n
insert into nhan_vien (ten, ngay_sinh, cmnd, luong, so_dien_thoai, email, dia_chi, id_vi_tri, id_trinh_do, id_bo_phan)
values  ('Nguy???n V??n An', '1970-11-7', 456231786, 10000000, 0901234121, 'annguyen@gmail.com', '295 Nguy???n T???t Th??nh, ???? N???ng', 1, 3, 1),
		('L?? V??n B??nh', '1997-04-09', 654231234, 7000000, 0934212314, 'binhlv@gmail.com', '22 Y??n B??i, ???? N???ng', 1, 2, 2),
        ('H??? Th??? Y???n', '1995-12-12', 999231723, 14000000, 0412352315, 'thiyen@gmail.com', 'K234/11 ??i???n Bi??n Ph???, Gia Lai', 1, 3, 2),
        ('V?? C??ng To???n', '1980-04-04', 123231365, 17000000, 0374443232, 'toan0404@gmail.com', '77 Ho??ng Di???u, Qu???ng Tr???', 1, 4, 4),
        ('Nguy???n B???nh Ph??t', '1999-12-09', 454363232, 6000000, 0902341231, 'phatphat@gmail.com', '43 Y??n B??i, ???? N???ng', 2, 1, 1),
		('Kh??c Nguy???n An Nghi', '2000-11-08', 964542311, 7000000, 0978653213, 'annghi20@gmail.com', '294 Nguy???n T???t Th??nh, ???? N???ng', 2, 2, 3),
        ('Nguy???n H???u H??', '1993-01-01', 534323231, 8000000, 0941234553, 'nhh0101@gmail.com', '4 Nguy???n Ch?? Thanh, Hu???', 2, 3, 2),
        ('Nguy???n H?? ????ng', '1989-09-03', 234414123, 9000000, 0642123111, 'donghanguyen@gmail.com', '111 H??ng V????ng, H?? N???i', 2, 4, 4),
        ('T??ng Hoang', '1982-09-03', 256781231, 6000000, 0245144444, 'hoangtong@gmail.com', '213 H??m Nghi, ???? N???ng', 2, 4, 4),
        ('Nguy???n C??ng ?????o', '1994-01-08', 755434343, 8000000, 0988767111, 'nguyencongdao12@gmail.com', '6 Ho?? Kh??nh, ?????ng Nai', 2, 3, 2);
-- select * from nhan_vien;


-- lo???i kh??ch.
insert into loai_khach (ten)
values ('Diamond'), ('Platinium'), ('Gold'), ('Silver'),('Menber');
-- select * from loai_khach;

-- kh??ch h??ng
insert into khach_hang(id_loai_khach, ten, ngay_sinh, gioi_tinh, cmnd, so_dien_thoai, email, dia_chi)
values 	(5, 'Nguy???n Th??? H??o', '1970-11-07', 0, 643431213, 0945423362, 'thihao07@gmail.com', '23 Nguy???n Ho??ng, ???? N???ng'),
		(3, 'Ph???m Xu??n Di???u', '1992-08-08', 1, 865342123, 0954333333, 'xuandieu92@gmail.com', 'K77/22 Th??i Phi??n, Qu???ng Tr???'),
        (1, 'Tr????ng ????nh Ngh???', '1990-02-27', 1, 488645199, 0373213122, 'nghenhan2702@gmail.com', 'K323/12 ??ng ??ch Khi??m, Vinh'),
        (1, 'D????ng V??n Quan', '1981-07-08', 1, 543432111, 0490039241, 'duongquan@gmail.com', 'K453/12 L?? L???i, ???? N???ng'),
        (4, 'Ho??ng Tr???n Nhi Nhi', '1995-12-09', 0, 795453345, 0312345678, 'nhinhi123@gmail.com', '224 L?? Th??i T???, Gia Lai'),
        (4, 'T??n N??? M???c Ch??u', '2005-12-06', 0, 732434215, 0988888844, 'tonnuchau@gmail.com', '37 Y??n Th???, ???? N???ng'),
        (1, 'Nguy???n M??? Kim', '1984-04-08', 0, 856453123, 0912345698, 'kimcuong84@gmail.com', 'K123/45 L?? L???i, H??? Ch?? Minh'),
        (3, 'Nguy???n Th??? H??o', '1999-04-08', 0, 965656433, 0763212345, 'haohao99@gmail.com', '55 Nguy???n V??n Linh, Kon Tum'),
        (1, 'Tr???n ?????i Danh', '1994-07-01', 1, 432341235, 0643343433, 'danhhai99@gmail.com', '24 L?? Th?????ng Ki???t, Qu???ng Ng??i'),
        (2, 'Nguy???n T??m ?????c', '1989-07-01', 1, 344343432, 0987654321, 'dactam@gmail.com', '22 Ng?? Quy???n, ???? N???ng');
select * from khach_hang;
select * from khach_hang where id = 1;
select * from khach_hang where ten like '%Huynh';


-- ki???u thu??.
insert into kieu_thue(ten)
values ('year'), ('month'), ('day'), ('hour');
-- select * from kieu_thue;

-- lo???i d???ch v???
insert into loai_dich_vu(ten)
values ('Villa'), ('House'), ('Room');
-- select * from loai_dich_vu;

-- d???ch v???
insert into dich_vu(id_kieu_thue, id_loai_dich_vu, ten, dien_tich, chi_phi_thue, so_nguoi_toi_da, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang)
values 	(3, 1, 'Villa Beach Front', 25000, 10000000, 10, 'vip', 'c?? h??? b??i', 500, 4),
		(2, 2, 'House Princess 01', 14000, 5000000, 7, 'vip', 'c?? th??m b???p n?????ng', null, 3),
        (4, 3, 'Room Twin 01', 5000, 1000000, 2, 'normal', 'c?? tivi', null, null),
        (3, 1, 'Villa No Beach Front', 22000, 9000000, 8, 'normal', 'c?? h??? b??i', 300, 3),
        (3, 2, 'House Princess 02', 10000, 4000000, 5, 'normal', 'c?? th??m b???p n?????ng', null, 2),
        (4, 3, 'Room Twin 02', 3000, 900000, 2, 'normal', 'c?? tivi', null, null);
-- select * from dich_vu;

-- d???ch v??? ??i k??m.
insert into dich_vu_di_kem (ten, gia, don_vi, trang_thai)
values 	('Karaoke', 10000, 'gi???', 'ti???n nghi, hi???n ?????i'),
		('thu?? xe m??y', 10000, 'chi???c', 'h???ng 1 xe'),
        ('thu?? xe ?????p', 10000, 'gi???', 't???t'),
        ('Buffet bu???i s??ng', 15000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng'),
        ('Buffet bu???i tr??a', 90000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng'),
        ('Buffet bu???i t???i', 16000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng');
-- select * from dich_vu_di_kem;

-- h???p ?????ng
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

-- h???p ????ng chi ti???t
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

-- 2.	Hi???n th??? th??ng tin c???a t???t c??? nh??n vi??n c?? trong h??? th???ng c?? t??n 
-- b???t ?????u l?? m???t trong c??c k?? t??? ???H???, ???T??? ho???c ???K??? v?? c?? t???i ??a 15 k?? t???.
select * 
from nhan_vien
where ( ten like 'H%') or (ten like 'K%') or (ten like 'T%')
and  (length(ten)  <= 15); 

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 3.	Hi???n th??? th??ng tin c???a t???t c??? kh??ch h??ng c?? ????? tu???i t??? 18 ?????n 50 tu???i
--  v?? c?? ?????a ch??? ??? ??????? N???ng??? ho???c ???Qu???ng Tr??????.
select * 
from khach_hang
where ngay_sinh between '1972-00-00' and '2004-00-00' 
and (dia_chi like '%???? N???ng') or (dia_chi like '%Qu???ng Tr???');

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 4.	?????m xem t????ng ???ng v???i m???i kh??ch h??ng ???? t???ng ?????t ph??ng bao nhi??u l???n. 
-- K???t qu??? hi???n th??? ???????c s???p x???p t??ng d???n theo s??? l???n ?????t ph??ng c???a kh??ch h??ng. 
-- Ch??? ?????m nh???ng kh??ch h??ng n??o c?? T??n lo???i kh??ch h??ng l?? ???Diamond???. 
select khach_hang.ten, count(id_khach_hang) as so_lan_dat_phong
from hop_dong join khach_hang on khach_hang.id = hop_dong.id_khach_hang
join loai_khach on khach_hang.id_loai_khach = loai_khach.id
where loai_khach.ten = 'Diamond'
group by id_khach_hang
order by so_lan_dat_phong asc;

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 5.	Hi???n th??? ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (V???i t???ng ti???n ???????c t??nh theo c??ng th???c nh?? sau: Chi Ph?? Thu?? + S??? L?????ng * Gi??,
--  v???i S??? L?????ng v?? Gi?? l?? t??? b???ng dich_vu_di_kem, hop_dong_chi_tiet)
--  cho t???t c??? c??c kh??ch h??ng ???? t???ng ?????t ph??ng. 
-- (nh???ng kh??ch h??ng n??o ch??a t???ng ?????t ph??ng c??ng ph???i hi???n th??? ra).
select id_khach_hang as 'id', khach_hang.ten as 'kh??ch h??ng', loai_khach.ten as 'lo???i kh??ch', hop_dong.id as 'm?? h???p ?????ng', dich_vu.ten as 'd???ch v???',
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

-- 6.	Hi???n th??? ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
-- c???a t???t c??? c??c lo???i d???ch v??? ch??a t???ng ???????c kh??ch h??ng th???c hi???n ?????t t??? qu?? 1 c???a n??m 2021 (Qu?? 1 l?? th??ng 1, 2, 3).

select dv.id, dv.ten as Ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten as loai_dich_vu, hd.ngay_lam_hop_dong 
from dich_vu dv 
join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id
join hop_dong hd on dv.id = hd.id_dich_vu
where hd.ngay_lam_hop_dong not between cast('2021-01-01 00:00:00' as datetime) and cast('2021-03-31 00:00:00' as datetime)
group by dv.id;

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 7.	Hi???n th??? th??ng tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
-- c???a t???t c??? c??c lo???i d???ch v??? ???? t???ng ???????c kh??ch h??ng ?????t ph??ng trong n??m 2020 nh??ng ch??a t???ng ???????c kh??ch h??ng ?????t ph??ng trong n??m 2021. 

select dv.id, dv.ten as ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten as ten_loai_dich_vu, hd.ngay_lam_hop_dong
from dich_vu dv
join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id
join hop_dong hd on dv.id = hd.id_dich_vu
where (hd.ngay_lam_hop_dong between cast('2020-01-01 00:00:00' as datetime) and cast('2020-12-31 00:00:00' as datetime))
and   (hd.ngay_lam_hop_dong not between cast('2021-01-01 00:00:00' as datetime) and cast('2021-12-31 00:00:00' as datetime))
group by dv.ten;

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 8.	Hi???n th??? th??ng tin ho_ten kh??ch h??ng c?? trong h??? th???ng, v???i y??u c???u ho_ten kh??ng tr??ng nhau.

-- c??ch 1 t???o view c???t t??n v?? c???t s??? l???n tr??ng l???p
create view ds_khach_hang as 
select ten, count(ten) as trung_lap 
from khach_hang
group by ten;
-- select view
select ten from ds_khach_hang
where trung_lap < 2;

-- c??ch 2 g???p c??ch 1 th??nh chung m???t l???nh seclect
select ten, count(ten) trung_lap
from khach_hang
group by ten
having trung_lap <2;

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 9. Th???c hi???n th???ng k?? doanh thu theo th??ng, ngh??a l?? t????ng ???ng v???i m???i th??ng trong n??m 2021
--  th?? s??? c?? bao nhi??u kh??ch h??ng th???c hi???n ?????t ph??ng.

select month(ngay_lam_hop_dong) as thang, count(month(ngay_lam_hop_dong)) as so_luong_hop_dong
from hop_dong
where year(ngay_lam_hop_dong) = 2021
group by month(ngay_lam_hop_dong)
order by month(ngay_lam_hop_dong) asc;

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 10.	Hi???n th??? th??ng tin t????ng ???ng v???i t???ng h???p ?????ng th?? ???? s??? d???ng bao nhi??u d???ch v??? ??i k??m.
-- K???t qu??? hi???n th??? bao g???m 
-- ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem 
-- so_luong_dich_vu_di_kem (???????c t??nh d???a tr??n vi???c sum so_luong ??? dich_vu_di_kem).

select hd.id as ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, sum(hdct.so_luong) as so_luong_dich_vu_di_kem 
from hop_dong hd
left join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id
group by hd.id;

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 11.	Hi???n th??? th??ng tin c??c d???ch v??? ??i k??m ???? ???????c s??? d???ng
-- b???i nh???ng kh??ch h??ng c?? ten_loai_khach l??
--  ???Diamond??? v?? c?? dia_chi ??? ???Vinh??? ho???c ???Qu???ng Ng??i???.
 
select dvdk.id, dvdk.ten
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on hdct.id_dich_vu_di_kem = dvdk.id
join hop_dong hd on hdct.id_hop_dong = hd.id
join khach_hang kh on kh.id = hd.id_khach_hang
join loai_khach lk on lk.id = kh.id_loai_khach
where lk.ten = 'Diamond' and (kh.dia_chi like '%Vinh' or kh.dia_chi like '%Qu???ng Ng??i')
order by dvdk.id asc;

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 12.	Hi???n th??? th??ng tin
-- ma_hop_dong, ho_ten (nh??n vi??n), ho_ten (kh??ch h??ng), so_dien_thoai (kh??ch h??ng), ten_dich_vu, so_luong_dich_vu_di_kem
-- (???????c t??nh d???a tr??n vi???c sum so_luong ??? dich_vu_di_kem), tien_dat_coc 
-- c???a t???t c??? c??c d???ch v??? ???? t???ng ???????c kh??ch h??ng ?????t v??o 3 th??ng cu???i n??m 2020
-- nh??ng ch??a t???ng ???????c kh??ch h??ng ?????t v??o 6 th??ng ?????u n??m 2021.

select hd.id as 'M?? h???p ?????ng', nv.ten as 'T??n nh??n vi??n', kh.ten as 'T??n kh??ch h??ng',hd.ngay_lam_hop_dong, kh.so_dien_thoai, dv.ten as 'T??n d???ch v???',
 sum(hdct.so_luong) as so_luong_dich_vu_di_kem
from hop_dong hd
join nhan_vien nv on nv.id = hd.id_nhan_vien
join khach_hang kh on kh.id = hd.id_khach_hang
join dich_vu dv on dv.id = hd.id_dich_vu
join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id
join dich_vu_di_kem dvdk on dvdk.id = hdct.id_dich_vu_di_kem
where (hd.ngay_lam_hop_dong between cast('2020-10-01 00:00:00' as datetime) and cast('2020-12-31 00:00:00' as datetime))
and   (hd.ngay_lam_hop_dong not between cast('2021-01-01 00:00:00' as datetime) and cast('2021-06-31 00:00:00' as datetime))
group by hd.id;

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 13.	Hi???n th??? th??ng tin c??c D???ch v??? ??i k??m ???????c s??? d???ng nhi???u nh???t b???i c??c Kh??ch h??ng ???? ?????t ph??ng.
-- (L??u ?? l?? c?? th??? c?? nhi???u d???ch v??? c?? s??? l???n s??? d???ng nhi???u nh?? nhau).

select  dvdk.ten as ten_dich_vu, count(ten) as 's??? h???p ?????ng ?????t', sum(hdct.so_luong) as tong_so_luong_dich_vu_di_kem
from hop_dong hd
left join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id
left join dich_vu_di_kem dvdk on dvdk.id = hdct.id_dich_vu_di_kem
group by dvdk.ten
having tong_so_luong_dich_vu_di_kem >= 10;

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 14.	Hi???n th??? th??ng tin t???t c??? c??c D???ch v??? ??i k??m ch??? m???i ???????c s??? d???ng m???t l???n duy nh???t.
-- Th??ng tin hi???n th??? bao g???m ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung 
-- (???????c t??nh d???a tr??n vi???c count c??c ma_dich_vu_di_kem).

select hd.id as ma_hop_dong, dv.ten, dvdk.ten, count(dvdk.ten) as so_lan_su_dung
from hop_dong hd
left join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id
left join dich_vu_di_kem dvdk on dvdk.id = hdct.id_dich_vu_di_kem
left join dich_vu dv on dv.id = hd.id_dich_vu
group by dvdk.ten
having so_lan_su_dung = 1 ;

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 15.	Hi???n thi th??ng tin c???a t???t c??? nh??n vi??n bao g???m 
-- ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi
-- m???i ch??? l???p ???????c t???i ??a 3 h???p ?????ng t??? n??m 2020 ?????n 2021.

select nv.id as ma_nhan_vien, nv.ten, td.ten as ten_trinh_do, bp.ten as ten_bo_phan, nv.so_dien_thoai,
 nv.dia_chi, count(nv.id) as so_luong_hd, year(hd.ngay_lam_hop_dong) as nam_lam_hop_dong
from nhan_vien nv
join hop_dong hd on hd.id_nhan_vien = nv.id
left join trinh_do td on td.id = nv.id_trinh_do
left join bo_phan bp on bp.id = nv.id_bo_phan
group by nv.id
having
so_luong_hd <= 3 and ( nam_lam_hop_dong between 2020 and 2021);

-----------------------------------------------------------------------------------------------------------------------------------------------------
SET SQL_SAFE_UPDATES = 0;
-- 16.	X??a nh???ng Nh??n vi??n ch??a t???ng l???p ???????c h???p ?????ng n??o t??? n??m 2019 ?????n n??m 2021.
delete  
from nhan_vien
where not exists (
select hop_dong.id_nhan_vien
from hop_dong
where year(hop_dong.ngay_lam_hop_dong) between 2019 and 2021 and hop_dong.id_nhan_vien = nhan_vien.id
);
-- check table nhan_vien
select * 
from nhan_vien;

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 17.	C???p nh???t th??ng tin nh???ng kh??ch h??ng c?? ten_loai_khach t??? Platinum l??n Diamond,
 -- ch??? c???p nh???t nh???ng kh??ch h??ng ???? t???ng ?????t ph??ng 
 -- v???i T???ng Ti???n thanh to??n trong n??m 2021 l?? l???n h??n 10.000.000 VN??.
 
 update khach_hang
 set id_loai_khach = 1
 where exists (
	select khach_hang.id , khach_hang.ten, khach_hang.id_loai_khach,
	dich_vu.chi_phi_thue + sum(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia) as tong_tien 
	from 
	hop_dong
	left join khach_hang on khach_hang.id = hop_dong.id_khach_hang
    left join loai_khach on loai_khach.id = khach_hang.id_loai_khach
	left join dich_vu on hop_dong.id_dich_vu = dich_vu.id
	left join hop_dong_chi_tiet on hop_dong.id = hop_dong_chi_tiet.id_hop_dong
	left join dich_vu_di_kem on dich_vu_di_kem.id = hop_dong_chi_tiet.id_dich_vu_di_kem
	group by hop_dong.id
	having tong_tien > 10000000 and khach_hang.id_loai_khach = 2
	order by id asc
    );

-----------------------------------------------------------------------------------------------------------------------------------------------------

-- 18.	X??a nh???ng kh??ch h??ng c?? h???p ?????ng tr?????c n??m 2021 (ch?? ?? r??ng bu???c gi???a c??c b???ng).
delete khach_hang, hop_dong, hop_dong_chi_tiet
from khach_hang
join hop_dong on hop_dong.id_khach_hang = khach_hang.id
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id
where not exists(select hop_dong.id from hop_dong where year(hop_dong.ngay_lam_hop_dong) > '2021' and hop_dong.id_khach_hang = khach_hang.id);