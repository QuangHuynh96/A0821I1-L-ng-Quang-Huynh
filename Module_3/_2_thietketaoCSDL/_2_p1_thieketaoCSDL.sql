create database oder_Form_Management;
use oder_Form_Management;

create table credit(
id int not null auto_increment primary key,
name varchar(50) not null,
address varchar(150) not null,
phone int not null
);

create table product(
id int not null primary key auto_increment,
name varchar(50) not null
);

create table invoiceInport (
id int not null auto_increment primary key,
date datetime not null
);

create table invoiceExport (
id int not null auto_increment primary key,
date datetime not null
);

create table `order`(
id int not null primary key,
date datetime not null,
creditId int,
foreign key(creditId) references credit(id)
);

create table product_order (
productId int,
orderId int,
primary key(productId, orderId),
foreign key(productId) references product(id),
foreign key(orderId) references `order`(id)
);

create table product_invoiceInport (
productId int,
invoiceInportId int,
price int not null,
amount int not null,
primary key(productId,invoiceInportId),
foreign key(productId) references product(id),
foreign key(invoiceInportId) references invoiceInport(id)
);

create table product_invoiceExport (
productId int,
invoiceExportId int,
price int not null,
amount int not null,
primary key(productId,invoiceExportId),
foreign key(productId) references product(id),
foreign key(invoiceExportId) references invoiceExport(id)
);

