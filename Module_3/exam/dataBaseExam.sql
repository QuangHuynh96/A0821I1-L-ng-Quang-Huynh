create database exam;

create table Auther(
id_author int not null auto_increment primary key,
name varchar(45) not null,
nick_name varchar(45),
address varchar(100), 
delete_flag boolean default true
);

create table Book(
id_book int not null auto_increment primary key,
`name` varchar(45) not null,
price double,
id_auther int,
foreign key (id_auther) references auther(id_author),
delete_flag boolean default true
);

insert into Auther (`name`, nick_name, address)
values 	('quang huynh 1', 'beeway_1', 'Da nang'),
		('quang huynh 2', 'beeway_2', 'Da nang'),
		('quang huynh 3', 'beeway_3', 'Da nang');
insert into Book (`name`, price, id_auther)
values 	('quang huynh 1', 500, 1),
		('quang huynh 2', 500, 2),
		('quang huynh 3', 1000, 3);
		
select * from book where delete_flag = true;

select * from auther where delete_flag = true and id_author = 1;

select * from book
left join auther on auther.id_author = book.id_auther
 where book.name like '%%' and auther.name like '%%' and book.delete_flag = true;
 
select * from auther
where name like '%%' and nick_name like '%%' and address like '%%' and delete_flag = true;