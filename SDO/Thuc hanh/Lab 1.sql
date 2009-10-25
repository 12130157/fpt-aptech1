Create Database Aptech
on Primary
(
	Name = aptech,
	Filename = "C:\aptech.mdf",
	size = 10,
	MAXSIZE = 50,
	FILEGROWTH = 20MB
),
(	Name = "primarydat2",
	FILENAME = "C:\primarydat2.ndf",
	size = 10,
	Maxsize = 20,
	FILEGROWTH = 15%
)
Log on
(
	name = Aptech_log,
	Filename="C:\aptech_log.log"
)

Use Aptech

Create TABLE Classes
(
	ClassName  Nchar(6) primary key,
	Teacher Nvarchar(20) not null,
	TimeSlot Nvarchar(15),
	Class int check (Class>0 and Class<4),
	Lab int check (Lab>0 and Lab<4),
)

Create table Students
(
	RollNumber nchar(7) Primary key,
	ClassName Nchar(6) References Classes(ClassName),
	StudenName Nvarchar(25) not null,
	Address Nvarchar(50) not null, 
	DOB Datetime check (YEAR(DOB) < YEAR (GETDATE()) - 15),
	Sex Bit Default 1,
	Bobbies xml
)

Create Table Marks
(
	MarkID INT Identity (1,1) primary key,
	RollNumber Nchar(7) References Students(RollNumber),
	Subject Nvarchar(10) check (Subject in ('CF','SQL','Java','C#')),
	Mark Decimal check (Mark >=0 and Mark <=25)
)

Alter Table Classes Add constraint ClassNameCheck
	Check(
		ClassName Like '[CT]%[GILM]' and
		CAST(Substring(ClassName,2,2) As INT) <100 and
		CAST(Substring(ClassName,4,2) as INT) <13 and
		LEN (ClassName) = 6
		) 
