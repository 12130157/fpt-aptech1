﻿Create Database Aptech
on Primary
(
	Name = Aptech,
	Filename = "C:\Aptech.mdf",
	size = 10,
	MAXSIZE = 50,
	FILEGROWTH = 20MB
),
(	Name = "Aptech2",
	FILENAME = "C:\Aptech2.ndf",
	size = 10,
	Maxsize = 20,
	FILEGROWTH = 15%
)
Log on
(
	name = Aptech_log,
	Filename="C:\Aptech_log.log"
)

Use Aptech

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

---------------------------------------------

--1:
Create View viewClass1
As
Select ClassCode,HeadTeacher From Class
Where ((Select count(Student.ClassCode) From Student 
Where Class.ClassCode=Student.ClassCode)<=17)
WITH CHECK OPTION

--2:

Insert into viewClass1 (ClassCode,HeadTeacher) Values (5,'TuNN')
Insert into viewClass1 (ClassCode,HeadTeacher) Values (6,'HoangNH')
Insert into viewClass1 (ClassCode,HeadTeacher) Values (7,'DuyDT')
Insert into viewClass1 (ClassCode,HeadTeacher) Values (8,'TungPH')

--3:

Alter View viewClass1 WITH SCHEMABINDING 
As
Select ClassCode,HeadTeacher From dbo.Class
Where ((Select count(Student.ClassCode) From dbo.Student 
Where Class.ClassCode=Student.ClassCode)<=17)
WITH CHECK OPTION
--hoặc:

IF exists (Select * From Sys.Objects Where name='viewClass1')
Drop View viewClass1
go

Create View viewClass1 WITH SCHEMABINDING 
As
Select ClassCode,HeadTeacher From dbo.Class
Where ((Select count(Student.ClassCode) From dbo.Student 
Where Class.ClassCode=Student.ClassCode)<=17)
WITH CHECK OPTION