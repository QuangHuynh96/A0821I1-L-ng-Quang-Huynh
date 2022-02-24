use sellingmanager;

insert into customer (name, age)
values('Minh Quan', 10), ('Ngọc Anh', 20), ('Hong Ha', 50);

insert into `order` (cID, date, totalprice)
values (1, '2006-3-21', null), (2, '2006-3-23', null), (1, '2006-3-16', null);

insert into product (Name, price)
values ('May giat', 3), ( 'Tu lanh', 5), ('Dieu hoa', 7), ('Quat', 1), ('Bep dien', 2);

insert into orderdetail(oID,pID,odQTY) 
values (1,1,3), (1,3,7), (1,4,2), (2,1,1), (3,1,8), (2,5,4), (2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select oID, `date`, price from orderdetail join `order` on orderdetail.oID = `order`.id join product on orderdetail.pID = product.id;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
 select customer.name, product.name as product_name, count(product.id) as amount from customer
 join `order` on customer.id = `order`.cID
 join orderdetail on `order`.id = orderdetail.oID 
 join product on orderdetail.pID = product.id group by product.name, customer.name;
 
 -- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào 
select name from customer where not exists (
select `order`.id 
from `order` 
where customer.id = `order`.cID);
 
--  Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
--  Giá bán của từng loại được tính = odQTY*pPrice)
select `order`.id as 'mã hóa đơn', `order`.date as 'ngày', sum(odQTY * Price) as 'giá hóa đơn'
from `order` join orderdetail on `order`.id = orderdetail.oID join product on orderdetail.pID = product.id
group by `order`.id;