Create Database Lab4

Use Lab4

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
	PTest_per int not null
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

----------------------------------------------------------------------

--1:
CREATE PROCEDURE Lab4_1 
AS 
Select * From Student Where Email like '%@fpt.vn' or Email like '%@fpt.com.vn'

--2:
CREATE PROCEDURE Lab4_2 
AS 
Select * From Class Where CloseDate = '07/23/2006'

--3:
Alter PROCEDURE Lab4_3
@CloseDate datetime
AS
DELETE FROM MARK WHERE RollNo in (Select RollNo from Student where ClassCode in (select ClassCode from Class where CloseDate < @CloseDate ))
DELETE FROM STUDENT WHERE ClassCode in (select ClassCode from Class where CloseDate < @CloseDate)
DELETE FROM CLASS WHERE CloseDate < @CloseDate