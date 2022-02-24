create database furamaResortManagement;
use furamaResortManagement;

 create table location (
 id int not null auto_increment primary key,
 name varchar(45) not null
 );
 
  create table `level`(
 id int not null auto_increment primary key,
 name varchar(45) not null
 );
 
   create table part(
 id int not null auto_increment primary key,
 name varchar(45) not null
 );
 
  create table customer_Type (
 id int not null auto_increment primary key,
 name varchar(45) not null
 );
 
  create table service_Type (
 id int not null auto_increment primary key,
 name varchar(45) not null
 );
 
 create table Accompanied_Service (
 id int not null auto_increment primary key,
 name varchar(45) not null,
 price double not null,
 unit varchar(10) not null,
 status varchar(45)
 );
 
  create table rental_Type (
 id int not null auto_increment primary key,
 name varchar(45) not null
 );
 
 
 create table employee (
 id int not null auto_increment primary key,
 fullname varchar(45) not null,
 birtday date not null,
 id_Card int not null,
 salary int not null,
 phoneNumber varchar(45) not null,
 email varchar(45) not null,
 address varchar(45) not null,
 location_Id int,
 level_Id int,
 part_Id int,
 foreign key (location_Id) references location (id),
 foreign key (level_Id) references `level` (id),
 foreign key (part_Id) references part (id)
 );
 
 create table customer(
 id int not null auto_increment primary key,
 customer_Type_Id int,
 fullname varchar(45) not null,
 birtday date not null,
 gender bit default 1,
 id_Card varchar(45) not null,
 phoneNumber varchar(45) not null,
 email varchar(45) not null,
 address varchar(45) not null,
 foreign key(customer_Type_Id) references customer_Type(id)
 );
 
 
 create table service (
 id int not null auto_increment primary key,
 rental_Type_Id int,
 service_Type_Id int,
 `name` varchar(45) not null,
 area int not null,
 rental_Costs double not null,
 max_Member int not null,
 room_Standard varchar(45) not null,
 description_More varchar(45),
 pool_Area int,
 floor_Number int,
 foreign key (rental_Type_Id) references rental_Type(id),
 foreign key (service_Type_Id) references service_Type(id)
 );
 
 create table contract (
 id int not null auto_increment primary key,
 employee_Id int,
 customer_Id int,
 service_Id int,
 start_Day datetime not null,
 end_Day datetime not null,
 deposit double not null,
 foreign key(employee_Id) references employee (id),
 foreign key(customer_Id) references customer (id),
 foreign key(service_Id) references service (id)
 );
 
 create table detailed_Contract (
 id int not null auto_increment primary key,
 contract_Id int,
 Accompanied_Service_Id int ,
 amount int not null,
 foreign key(contract_Id) references contract(id),
 foreign key(Accompanied_Service_Id) references Accompanied_Service(id)
 );