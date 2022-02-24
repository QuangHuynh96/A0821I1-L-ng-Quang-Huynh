use studentmanagement;

select * from student;

select * from student where status = true;

select * from subject where credit < 10;

select * from student join class on student.classId = class.classId where class.className = 'A1';

select * from student join mark on student.studentId = mark.studentId join subject on mark.subId = subject.subId where subject.subName = 'CF';