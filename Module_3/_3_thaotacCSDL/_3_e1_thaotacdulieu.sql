use studentmanagement;

select * from student where student.studentName like 'H%';

select * from class where class.startDate like '%12%';

select * from `subject` where credit>=3 and credit<=5;

update student set classId = 2 where student.studentName = 'Hung';
SET SQL_SAFE_UPDATES = 0;
select studentName, subName, mark from mark join subject on mark.subId = subject.subId join student on mark.studentId = student.studentId
order by mark desc, studentName asc;