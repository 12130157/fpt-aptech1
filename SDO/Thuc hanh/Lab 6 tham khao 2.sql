use master
go
if not exists(select * from sys.databases where name = 'Aptech')
create database Aptech
on primary
(
	name =Aptech,
	filename="C:\Program Files\Microsoft SQL Server\MSSQL.1\MSSQL\Data\aptech.mdf",
	size=10,
	maxsize=50,
	filegrowth=20mb
)
log on
(
	name=Aptech_log,
	filename="C:\Program Files\Microsoft SQL Server\MSSQL.1\MSSQL\Data\aptech_log.log"
)
go
use Aptech
go
--tao bang !
create table Class
(
	ClassCode	varchar(10) primary key,
	HeadTeacher varchar(30),
	Room		varchar(30),
	TimeSlot	varchar(30),
	CloseDate	datetime
)
go

create table Student
(
	RollNo		varchar(10) primary key,
	ClassCode	varchar(10) references Class(ClassCode),
	FullName	varchar(30),
	Male		bit,
	BirthDate	datetime,
	Address		varchar(30),
	Province	char(2),
	Email		varchar(30) check (Email like '%@%.%')
)
go
create table Subject
(
	SubjectCode	varchar(10) primary key,
	SubjectName	varchar(30),
	WTest		bit,
	PTest		bit,
	WTest_Per	smallint,
	PTest_per	int
)
create table Mark
(
	RollNo		varchar(10) references Student(RollNo),
	SubjectCode	varchar(10) references Subject(SubjectCode),
	WMark		float(8) check(WMark>=0 and WMark <=100),
	PMark		float(8)check(PMark>=0 and PMark <=100),
	Mark		float(8)check(Mark>=0 and Mark <=100),
	constraint PK_Mark primary key(RollNo,SubjectCode)
)
go
--cau 1
insert into class values
('C0808L','TuNN','Class 3','L','2011-6-6 ')
insert into class values
('C0808G','HungPN','Class 2','G','2010-6-6 ')
insert into class values
('T0806L','DuyDT','Class 3','L','2011-6-6' )
insert into class values
('T0809I','HaiLH','Class 3','I','2006-10-10 ')
insert into class values
('T0809G','HaoPT','Class 3','G','2004-4-4' )
insert into class values
('T0810G','HaiLH','Class 2','G','2003-5-6' )
insert into class values
('T0812G','manhVQ','Class 1','G','10/10/2006' )

go
insert into student values
('B00333','C0808L','HaiLH','0',1988-8-4,'Vinh Phuc','VP','HaiLH@fpt.vn')
insert into student values
('B00312','C0808L','DungTV','1',1986-12-27,'Ha Nam','HN','DungTV@fpt.com.vn')
insert into student values
('B00324','C0808L','Do Huong','0',1988-6-15,'Ha Noi','HN','HuongDTLt@fpt.vn')
insert into student values
('B00325','C0808L','HungNV','1',1987-6-27,'Hai Phong','HP','Haopt@yahoo.com')
go
insert into student values
('B00777','T0809G','HaoPT','1',1987-6-27,'Bac Ninh','BN','Haopt@fpt.vn')
insert into student values
('B00888','T0809G','HaoPT','1',1987-6-27,'Bac Ninh','BN','Haopt@fdfd.vn')
insert into student values
('B00999','T0810G','bbbPT','1',1987-6-27,'Bac Ninh','BN','Haopt@dfsa.vn')
insert into student values
('B00101','T0810G','aaaPT','1',1987-6-27,'Bac Ninh','BN','Haopt@aa.vn')
go
insert into subject values
('CF','Computer Fundation',1,0,80,25)
insert into subject values
('C','Program C',1,1,99,25)
insert into subject values
('HDJ','***HDJ**',1,1,99,25)
insert into subject values
('RDBMS','Database design',1,1,99,25)
insert into subject values
('JBE','Learning Java by Example',1,1,99,25)
go
insert into mark values
('B00777','CF',64,0,64)
insert into mark values
('B00777','C',68,76,72)
insert into mark values
('B00777','HDJ',51,68,59)
insert into mark values
('B00321','RDBMS',41,90,76)
insert into mark values
('B00321','JBE',56,76,64)

insert into mark values
('B00333','CF',64,0,64)
insert into mark values
('B00333','C',68,76,72)
insert into mark values
('B00333','HDJ',51,68,59)
insert into mark values
('B00333','RDBMS',41,90,76)
insert into mark values
('B00333','JBE',56,76,65)



go
insert into mark values
('B00777','CF',64,53,24)
insert into mark values
('B00777','C',68,76,10)
insert into mark values
('B00777','HDJ',51,68,21)
insert into mark values
('B00777','RDBMS',41,90,14)

insert into mark values
('B00888','CF',64,0,64)
insert into mark values
('B00888','C',68,76,72)
insert into mark values
('B00888','HDJ',51,68,59)
insert into mark values
('B00888','RDBMS',41,90,76)

insert into mark values
('B00999','CF',64,0,64)
insert into mark values
('B00999','C',68,76,72)
insert into mark values
('B00999','HDJ',51,68,59)
insert into mark values
('B00999','RDBMS',41,90,76)

insert into mark values
('B00101','CF',64,0,64)
insert into mark values
('B00101','C',68,76,72)
insert into mark values
('B00101','HDJ',51,68,59)
insert into mark values
('B00101','RDBMS',41,90,76)
--cau 2
create view view2
as
select * from Student where
	(select count(RollNo) from Mark
	where Student.RollNo=Mark.RollNo)>=2
go
--cau 3
create view View3
as
select * from Student where
	((select count(RollNo) from Mark
	where Student.RollNo=Mark.RollNo and Mark.Mark>=10)=0)
	and ((select count(RollNo) from Mark
	where Student.RollNo=Mark.RollNo and Mark.Mark<10)>0)
go
--cau 4
create view View4
as
select * from Student 
where exists(select * from Class
		where Student.ClassCode=Class.ClassCode and Class.TimeSlot like 'G')
go
--cau 5
create proc sp_insertSubject
@subCode varchar(10),
@subName varchar(30),
@wT bit,
@pT bit,
@wTP smallint,
@pTP int
as
insert into Subject values(@subCode,@subName,@wT,@pT,@wTP,@pTP)
go
--cau 6
create proc sp_displayStudent
as
select * from Student
where  exists(select * from Class 
where Student.ClassCode=Class.ClassCode and 
datediff(day,CloseDate,getdate())<=30 and datediff(day,CloseDate,getdate())>=0)
go
--select  datediff(day,'2/14/1990',getdate())
--cau 7
create proc sp_displayClass
as
select * from Class
where substring(ClassCode,len(ClassCode),1) like 'G' and 
(select count(ClassCode) from Student 
where Student.ClassCode=Class.ClassCode)>=15
--cau 8
create proc sp_displayStudent8
@min float(8),
@max float(8)
as
begin
select * from student
where (exists(select RollNo from Mark where Student.RollNo = Mark.RollNo and (Mark.Mark between @min and @max))) and 
	  (not exists(select Mark from Mark where Student.RollNo = Mark.RollNo and (Mark not between @min and @max) ))
end
go
--cau 9
create proc sp_displayMark
@ClassCode varchar(10)
as
select * from Mark
where exists(select * from Student where Mark.RollNo = Student.RollNo and Student.ClassCode = @ClassCode)
--cau 10
create trigger insertSubject
on Subject
for insert
as
begin
	if exists (select * from Subject,inserted where Subject.SubjectName=inserted.SubjectName)
	begin
		print '2 Subject cant have the same name'
		rollback
	end
end
--cau 11
create trigger updateStudent
on Student
for update
as
begin
	if exists(select * from inserted where len(Province)>2)
	begin
		print 'Province cant exceed 2 character'
		rollback
	end
end
--cau 12
create trigger insertClass
on Class
for insert
as
begin
	if not exists(select * from inserted where substring(TimeSlot,len(TimeSlot),1) in ('G','I','L','M'))
	begin
		print 'The last character in TimeSlot must match one of the following values : G,I,L,M'
		rollback
	end
end
