Create Database Lab5

Use Lab5

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
	PTest_per Smallint not null
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

-----------------------------------------------------

--1:
Create Trigger Mark1
on Mark
For Insert
As
DECLARE @WMark float
DECLARE @PMark float
DECLARE @Mark float
Select @WMark = WMark, @PMark = PMark, @Mark = Mark From Mark

If (@WMark <0 or @WMark >25) or (@PMark <0 or @PMark >25) or (@Mark <0 or @Mark >25)
BEGIN
PRINT 'Gia tri diem ban nhap khong thich hop'
ROLLBACK
END


--2:
Create Trigger Mark2
On Mark 
For Update 
As 
Declare @Mark_Old float
Declare @Mark_New float
select @Mark_Old = Mark from Deleted 
select @Mark_New = Mark from Inserted 
If (@Mark_New < @Mark_Old) 
Begin 
Print 'Diem sua lai khong the nho hon diem cu' 
RollBack 
End