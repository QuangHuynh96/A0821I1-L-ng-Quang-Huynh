use studentManagement;

insert into class (className, startDate, `status`)
values ('A1', '2008-12-20', 1), ('A2', '2008-12-22', 1), ('B3', current_date(), 0);

insert into student (studentName, address, phone, `status`, classId) 
values ('Hung', 'Ha noi', 0912113113, 1, 1), ('Manh', 'Ho Chi Minh', 0123123123, 0, 2);
insert into student (studentName, address, `status`, classId)
values ('Hoa', 'Hai phong', 1, 1);

insert into subject(subName, credit, `status`)
values ('CF', 5, 1), ('C', 6, 1), ('HDJ', 5, 1), ('RDBMS', 10, 1);

insert into mark( subId, studentId, mark, examTimes)
values (1,1,8,1),
(1,2,10,2),
(2,1,12,1);

select * from mark;