create database  exam;

-- ---------------------------------------------------------------------------------------------
create table BenhAn(
idBenhAn int not null auto_increment primary key,
idBenhNhan int,
ngayNhapVien datetime,
ngayRaVien datetime,
lyDoNhapVien varchar(100),
foreign key (idBenhNhan) references BenhNhan(idBenhNhan),
delete_flag boolean default true
);

create table BenhNhan(
idBenhNhan int not null auto_increment primary key,
ten varchar(45),
delete_flag boolean default true
);

insert into BenhNhan (ten)
values 	('Nguyen Van A'),
 	('Nguyen Van B'),
 	('Nguyen Van C');
    
insert into BenhAn(idBenhNhan, ngayNhapVien, NgayRaVien, lyDoNhapVien)
values 	(1, '2016-11-7', '2019-11-7', 'ung thu gan giai doan cuoi'),
 	(2, '2016-11-7', '2019-11-7', 'suy than'),
 	(3, '2016-11-7', '2019-11-7', 'covid19');
		
	




select * from BenhAn
left join BenhNhan on BenhNhan.idBenhNhan = BenhAn.idBenhNhan
 where BenhAn.delete_flag = true;
 
 select * from benhAn where delete_flag = true;