Create Database Lab6

Use Lab6

Create Table Class
(
	ClassCode varchar(10) primary key,
	HeadTeacher varchar(30) not null,
	Room varchar(30) Default 1,
	TimeSlot varchar(30) check (TimeSlot in ('G','I','L','M')),
	CloseDate datetime check (YEAR(CloseDate) < YEAR (GETDATE()))
)

Create Table Student
(
	RollNo varchar(10) primary key,
	ClassCode varchar(10) References Class(ClassCode),
	FullName varchar(30),
	Male bit Default 1,
	BirthDate datetime not null check (YEAR(BirthDate) < YEAR (GETDATE()) -18),
	Address varchar(30) not null,
	Provice char(2) not null,
	Email varchar(30) not null check (Email like '%@%.%')
)

Create Table Subject
(
	SubjectCode varchar(10) primary key,
	SubjectName varchar(40) not null,
	WTest bit not null,
	PTest bit not null,
	WTest_per smallint not null,
	PTest_per smallint not null
)

Create Table Mark
(
	RollNo varchar(10) not null References Student(RollNo),
	SubjectCode varchar(10) not null References Subject(SubjectCode),
	WMark float(8) not null check(WMark >= 0 and WMark <= 100),
	PMark float(8) not null check(PMark >= 0 and PMark <= 100),
	Mark float(8) not null check(Mark >= 0 and Mark <= 100)
	constraint mark_primary_key Primary key (RollNo,SubjectCode)
)

----------------------------------------------------------------------------------------------

--1:
Insert Into Class Values
('C0808L','TuNN','Class 3','L','2004-6-6 ')
Insert Into Class Values
('C0808G','HungPN','Class 2','G','2002-6-6 ')
Insert Into Class Values
('T0806L','DuyDT','Class 3','L','2004-6-6' )
Insert Into Class Values
('T0809I','HaiLH','Class 3','I','2006-10-10 ')
Insert Into Class Values
('T0809G','HaoPT','Class 3','G','2004-4-4' )
Insert Into Class Values
('T0810G','HaiLH','Class 2','G','2003-5-6' )
Insert Into Class Values
('T0812G','ManhVQ','Class 1','G','10/10/2006' )

Go
Insert Into Student Values
('B00123','C0808L','HaiLH','0',1988-8-4,'Vinh Phuc','VP','HaiLH@fpt.vn')
Insert Into Student Values
('B00124','C0808L','DungTV','1',1986-12-27,'Ha Nam','HN','DungTV@fpt.com.vn')
Insert Into Student Values
('B00125','C0808L','Do Huong','0',1988-6-15,'Ha Noi','HN','HuongDTLt@fpt.vn')
Insert Into Student Values
('B00126','C0808L','HungNV','1',1987-6-27,'Hai Phong','HP','Haopt@yahoo.com')
Go
Insert Into Student Values
('B00127','T0809G','HaoPT','1',1987-6-27,'Bac Ninh','BN','Haopt@fpt.vn')
Insert Into Student Values
('B00128','T0809G','HaoPT','1',1987-6-27,'Bac Ninh','BN','Haopt@fdfd.vn')
Insert Into Student Values
('B00129','T0810G','bbbPT','1',1987-6-27,'Bac Ninh','BN','Haopt@dfsa.vn')
Insert Into Student Values
('B00130','T0810G','aaaPT','1',1987-6-27,'Bac Ninh','BN','Haopt@aa.vn')
Go
Insert Into Subject Values
('CF','Computer Fundation',1,0,80,25)
Insert Into Subject Values
('C','Program C',1,1,99,25)
Insert Into Subject Values
('HDJ','***HDJ**',1,1,99,25)
Insert Into Subject Values
('RDBMS','Database design',1,1,99,25)
Insert Into Subject Values
('JBE','Learning Java by Example',1,1,99,25)
Go
Insert Into Mark Values
('B00123','CF',64,0,64)
Insert Into Mark Values
('B00123','C',68,76,72)
Insert Into Mark Values
('B00123','HDJ',51,68,59)
Insert Into Mark Values
('B00123','RDBMS',41,90,76)
Insert Into Mark Values
('B00123','JBE',56,76,64)

Insert Into Mark Values
('B00124','CF',64,0,64)
Insert Into Mark Values
('B00124','C',68,76,72)
Insert Into Mark Values
('B00124','HDJ',51,68,59)
Insert Into Mark Values
('B00124','RDBMS',41,90,76)
Insert Into Mark Values
('B00124','JBE',56,76,65)

Go
Insert Into Mark Values
('B00125','CF',64,53,24)
Insert Into Mark Values
('B00125','C',68,76,10)
Insert Into Mark Values
('B00125','HDJ',51,68,21)
Insert Into Mark Values
('B00125','RDBMS',41,90,14)

Insert Into Mark Values
('B00126','CF',64,0,64)
Insert Into Mark Values
('B00126','C',68,76,72)
Insert Into Mark Values
('B00126','HDJ',51,68,59)
Insert Into Mark Values
('B00126','RDBMS',41,90,76)

Insert Into Mark Values
('B00127','CF',64,0,64)
Insert Into Mark Values
('B00127','C',68,76,72)
Insert Into Mark Values
('B00127','HDJ',51,68,59)
Insert Into Mark Values
('B00127','RDBMS',41,90,76)

Insert Into Mark Values
('B00128','CF',64,0,64)
Insert Into Mark Values
('B00128','C',68,76,72)
Insert Into Mark Values
('B00128','HDJ',51,68,59)
Insert Into Mark Values
('B00128','RDBMS',41,90,76)

--2:
Create view Lab6_2
as
select * From Student where
((select count(RollNo) from Mark where Mark.RollNo=Student.RollNo))>=2


--3:
Create view Lab6_3
as
select * From Student where
((select count(RollNo) from Mark where Mark.RollNo=Student.RollNo and Mark.Mark>=10))=0
and ((select count(RollNo) from Mark where Mark.RollNo=Student.RollNo and Mark.Mark<10))>0

--4:
Create view Lab6_4
as
select Student.RollNo, Class.HeadTeacher,Student.FullName, Student.Address,Student.Email 
From Student,Class where Class.ClassCode=Student.ClassCode and Class.TimeSlot='G'

--5:
Create Proc Lab6_5
@SubjectCode varchar(10),
@SubjectName varchar(40),
@WTest bit,
@PTest bit,
@WTest_per Smallint,
@PTest_per Smallint
As
Insert into Subject Values
(@SubjectCode, @SubjectName, @WTest, @PTest, @WTest_per, @PTest_per)

--6:
Create Proc Lab6_6
As
Select * From Student
Where  exists(Select * From Class 
Where Student.ClassCode=Class.ClassCode and 
datediff(day,CloseDate,getdate())<=30 and datediff(day,CloseDate,getdate())>=0)

--7:
Create Proc Lab6_7
As
Select * from Class where TimeSlot='G' and ((Select count(Student.ClassCode) From Student 
Where Class.ClassCode=Student.ClassCode)>=15)

--8:
Create Proc Lab6_8
@Min int,
@Max int
As
Select * From Student 
where exists(Select Mark from Mark where Student.RollNo=Mark.RollNo and Mark.Mark between @Min and @Max)
and not exists(Select Mark from Mark where Student.RollNo=Mark.RollNo and Mark.Mark not between @Min and @Max)

--9:
Create Proc Lab6_9
@ClassCode varchar(10)
As
Select * From Mark
Where exists(Select * From Student Where Mark.RollNo = Student.RollNo and Student.ClassCode = @ClassCode)

--10:
Create Trigger Lab6_10
on Subject
For Insert 
As
Begin
	Declare @SubjectName nvarchar
	set @SubjectName = (select SubjectName from Inserted) 
	If exists(select * from Subject where SubjectName = @SubjectName)
	Begin
		Print 'Ten lop da co'
		Rollback 
		Transaction
	End
	
	Else
		Print 'Da insert thanh cong'
End

Insert into Subject values (10, 'CF', 1,1,1,1)

--11:

Create Trigger Lab6_11
on Student
For Update
As
Begin
	If exists(Select * From inserted Where len(Province)>2)
	Begin
		Print 'Province cant exceed 2 character'
		Rollback
	End
End

--12:

Create Trigger Lab6_12
On Class
For Insert
As
Begin
If not exists(Select * From inserted Where substring(TimeSlot,len(TimeSlot),1) in ('G','I','L','M'))
	Begin
		Print 'The last character in TimeSlot must match one of the following values : G,I,L,M'
		Rollback
	End
End