-- b1: tạo CSDL.
create database demo;
use demo;

-- b2: tạo bảng products.
create table products(
id int not null auto_increment primary key,
product_code int,
product_name varchar(50),
product_price int,
product_amount int,
product_desciption varchar(150),
product_status boolean
);

-- add dữ liệu.
insert into products(product_code, product_name, product_price, product_amount, product_desciption, product_status)
values (001, 'iphone', 700, 100, 'điện thoại iphone', 1 ),
(002, 'tablet', 1000, 50, 'máy tính bảng', 1 ),
(003,'macbook', 1500, 75, 'laptop macbook', 1);

select *
from products
where product_code = 50;

-- b3: tạo index.
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create unique index index_product_code on products(product_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create unique index index_Composite on products(product_name, product_price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào.
explain select *
from products
where product_code = 002;

explain select *
from products
where product_name = 'tablet' and product_price = 1000;


-- * So sánh câu truy vấn trước và sau khi tạo index.
-- trước khi tạo index câu lệnh explain cho kết quả type = all.
-- sau khi tạo index explain cho kết quả type = const.

-- b4: tạo view.
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view product as
select  product_Code, prproductoduct_Name, product_Price, product_Status
from products;

-- sửa đổi view.
create or replace view product as
select product_Name, product_Price, product_Status
from products
where product_Status = 1;

-- test view.
select * from product;

-- xóa view.
drop view product;

-- b5: Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product:
delimiter //
create procedure select_all_product()
begin
select * from products;
end //
delimiter; 

-- Tạo store procedure thêm một sản phẩm mới:
delimiter $$
create procedure add_new_product(
in code int,
in name varchar(50),
in price int,
in amount int,
in desciption varchar(150),
in status boolean
)
begin
insert into products (product_code, product_name, product_price, product_amount, product_desciption, product_status)
values (code, name, price, amount, desciption, status );
end 
// delimiter;

-- Tạo store procedure sửa thông tin sản phẩm theo id:
delimiter $$
create procedure update_for_id(
in id int,
in code int,
in name varchar(50),
in price int,
in amount int,
in desciption varchar(150),
in status boolean
)
begin
update pdoducts
set
product_code = code,
product_name = name,
product_price = price,
product_amount = amount,
product_desciption = desciption,
product_status = status
WHERE products.id = id;
end $$
delimiter;

-- Tạo store procedure xoá sản phẩm theo id.
delimiter $$
create procedure delete_for_id(id int)
begin
delete from products
where products.id = id;
end $$
delimiter ;