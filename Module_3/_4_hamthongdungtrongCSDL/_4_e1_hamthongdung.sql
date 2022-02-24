use studentmanagement;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select subName, max(credit) 
from `subject`;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select *, max(mark)
from `subject` join mark on `subject`.subid = mark.subid;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select *, avg(mark) as 'Điểm TB các môn học'
from student join mark on student.studentID = mark.studentID
group by student.studentID
order by avg(mark) desc;