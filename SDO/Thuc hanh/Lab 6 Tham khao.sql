--Tao insert trigger
create trigger insert1 on lop
for insert--Khai bao trigger insert
as
begin
 declare @tenlop nvarchar(40);
set @dem = (select sohs from inserted) 
if (@dem <= 15)
 begin
   print 'Khong du SV de tao lop'
   rollback transaction
 end
else
 print 'Da insert thanh cong'
end


insert into lop
values ('L006','Tieng Anh',17)

drop trigger insert1


create trigger insert2 on lop
for insert--Khai bao trigger insert
as
begin
 declare @tenlop nvarchar(40);
set @tenlop = (select tenlop from inserted) 
if exists(select * from lop where tenlop = @tenlop)
 begin
   print 'Ten lop da co'
   rollback transaction
 end
else
 print 'Da insert thanh cong'
end




alter table lop disable trigger insert2

alter table lop enable trigger insert2
sp_helptext 'insert2'
select * from sys.triggers

alter table lop disable trigger all

insert into lop
values ('L071','Tieng Anh',18)

select * from sys.triggers

--alter database c0610k_test1 disable trigger all

sp_helptext insert2


--create update trigger

create trigger update1 on student
for update
as
begin
 if update(rn)
 begin
print 'Khong the thay doi ma hoc sinh'
rollback tran
end
end

drop trigger update1 

update student
set rn=35
where rn=30



--create delete trigger
create trigger delete1 on lop
for delete
as
begin
declare @ten nchar(40);
set @ten = (select tenlop from deleted)
if @ten = 'Toan'
 begin
  print 'Khong xoa duoc'
  rollback  tran
  end
else
 print 'DA XOA THANH CONG'
end
drop trigger delete1


delete from lop
where tenlop = 'Toan'

sp_helptext 'tg1'
drop trigger tg1

--create after trigger
create trigger after1 on lop
after delete
as
begin
 declare @dem int
set @dem = (select count(*) as 'so luong'  from deleted)
print 'Co'+cast(@dem as nchar(4)) + 'lop da bi xoa'
select * from deleted
select * from lop
end

delete from lop
where sohs <= 20


disable trigger after1 on lop




create trigger xoahs1 on lop
for delete
as
begin
declare @malop nchar(10), @sohs int
declare cur cursor fast_forward for
select malop, sohs from deleted
--set @dem =1
open cur
fetch next from cur
into @malop, @sohs
while @@fetch_status =0
begin
		if (@sohs >=23)
			begin
				print 'Khohng the xoa lop'+@malop+'vi so hoc sinh lon hon hoac bang 23'
				rollback tran
            end
			fetch next from cur into @malop, @sohs
			set @dem = @dem +1

--print 'dem la'+cast(@dem as nchar(10))
end
	close cur
deallocate cur	
	end


drop trigger xoahs1

select * from sys.triggers

disable trigger delete1 on lop

delete from lop where sohs <=24

select * from lop

--DDL trigger
create trigger create_permission_1 on database
for create_table
as
begin
print 'You are not allowed'
rollback tran
end

create table ho (ma int, ten int)

select * from sys.triggers where name='create_permission'


disable trigger create_permission on database

disable trigger all on database
disable trigger all on lop

disable trigger xoahs1 on lop


drop trigger update1


SELECT definition FROM sys.sql_modules sm
 INNER JOIN sys.triggers t ON sm.object_id = t.object_id
 WHERE t.name='Create_Permission'

declare mycursor cursor fast_forward for select * from lop

open mycursor
fetch next from mycursor
into



create view myview1 as
select lop.malop as code from lop, student
where lop.malop =student.malop


CREATE TRIGGER Delete_AccType ON myview1
INSTEAD OF DELETE
AS
BEGIN
DELETE FROM lop WHERE malop IN 
			(SELECT code FROM deleted)
DELETE FROM student WHERE malop IN 
			(SELECT code FROM deleted)
END


delete from myview1 where code = 'l01'




--Tao create trigger
create trigger trg_create
on database 
for create_table
as
begin
print 'Khong co quyen tao bang tren CSDL nay'
rollback tran
end 

select * from sys.triggers

create table hs1(ma nchar(10), diem int)


enable trigger trg_create on database


sp_helptext 'xoa'

alter table student
enable trigger xoa

disable trigger xoa on student


create trigger trg_alter
on database 
for alter_table
as
begin
print 'Khong co quyen sua tren CSDL nay'
rollback tran
end 

alter table student
add  sports nchar(10)


create trigger trg_drop
on database 
for drop_table
as
begin
print 'Khong co quyen xoa tren CSDL nay'
rollback tran
end 

drop table subject


--Tao mot trigget thuc hien viec
--da xoa 1 lop thi phai xoa luon tat ca hoc sinh thuoc lop do

create view view1 
as 
select lop.malop as code from lop, student
where lop.malop = student.malop


drop view view1


create trigger xoanhieubang on view1
instead of delete
as
 begin
--xoa cac lop trong bang LOP ma co malop thuoc bang deleted

delete from student where malop in (select code from deleted) 
delete from LOP where malop in (select code from deleted)
 
print 'Da xoa du lieu o trong ca hai bang'

end

drop trigger xoanhieubang on view1

disable trigger all on database
disable trigger all on student


select * from sys.triggers



delete from view1
where code = 'l01'