create database scoretestmanagement;
use scoretestmanagement;
create table student(
idStudent varchar(20) primary key,
`name` varchar(50),
birtday datetime,
class varchar(20),
GT varchar(20)
);
create table subjects(
idsubjects varchar(20) primary key,
namesubjects varchar(50),
idteacher varchar(20)
);
create table score(
idstudent varchar(20),
idsubjects varchar(20),
score int,
datetest datetime,
primary key subjects(idstudent,idsubjects),
foreign key (idstudent) references student(idstudent),
foreign key (idsubjects) references subjects(idsubjects)
);
create table teacher(
idteacher varchar(20) primary key,
nameteacher varchar(50),
phonenumber varchar(10)
);
alter table subjects add  constraint FidteacherK_id foreign key ( idteacher) references teacher(idteacher);