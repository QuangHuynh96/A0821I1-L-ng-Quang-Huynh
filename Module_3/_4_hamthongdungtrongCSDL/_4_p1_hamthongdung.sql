use studentmanagement;

-- Hiển thị số lượng sinh viên ở từng nơi
select address, count(studentId) as so_luong 
from student
group by address;

select * from mark;

-- Tính điểm trung bình các môn học của mỗi học viên 
select student.studentId, student.studentName, avg(mark)
from student join mark on student.studentId = mark.studentId
group by student.studentName, student.studentId;

-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
select student.studentId, student.studentName, avg(mark) as avgpoit
from student join mark on student.studentId = mark.studentId
group by student.studentName, student.studentId
having avgpoit > 15;

-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
select student.studentId, student.studentName, avg(mark) as avgpoit
from student join mark on student.studentId = mark.studentId
group by student.studentName, student.studentId
having avg(mark) >= all(
select avg(mark) 
from mark 
group by mark.studentId
);


