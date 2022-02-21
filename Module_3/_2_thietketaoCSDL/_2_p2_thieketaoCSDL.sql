create database sellingManager;
use sellingManager;

create table customer(
ID int not null auto_increment primary key,
name varchar(50) not null,
age int
);

create table product(
ID int not null auto_increment primary key,
Name varchar(50) not null,
price int not null
);

create table `order` (
ID int not null auto_increment primary key,
cID int,
date datetime not null,
totalprice int not null,
foreign key(cID) references customer(ID)
);

create table orderDetail(
pID int,
oID int,
odQTY int, 
primary key (pID,oID),
foreign key(pID) references product(ID),
foreign key(oID) references `order`(ID)
);