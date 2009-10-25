Use master
Go
--drop databAse Amazonz
If not exists(Select * From sys.databases Where name = 'Amazonz')
Create Database Amazonz

Go
Use Amazonz
Go
--Cau 1:
Create Table Books
(
	BookCode int identity primary key,
	CateGory varchar(50),
	Author varchar(100),
	Publisher varchar(100),
	Title	varchar(100),
	Price	float,
	InStore int
)
Go
Create Table Customers
(
	CustomerID int identity primary key,
	CustomerName varchar(100),
	Address	varchar(100),
	Phone	varchar(30)
)
Go
Create Table BookSold
(
	BookSoldID int identity primary key,
	CustomerID int references Customers(CustomerID),
	BookCode int references Books(BookCode),
	Date datetime,
	Price float,
	Amount int,
)


--Cau 2:
Insert Into Books values('Children''s Book','Gillian Cullinan','Savuti Muti Publishing','''Rory'',The Adventures of a Lion Club',20,50)
Insert Into Books values('Business','John Kremer','Open Horizons','1001 Ways To Market Your Books',30,70)
Insert Into Books values('Mystery','Ed McBain&Otto Penzler','Houghton MIfflin','1999 The Best of American Mystery Stories',25,60)
Go
Insert Into Customers values('Hanna Moos','London','0621-08460')
Insert Into Customers values('Elizabeth Lincoln','Berlin','(604)555-4729')
Insert Into Customers values('Janine Labrune','London','40.67.88.88')
Go
Insert Into BookSold values(1,2,'11/1/2008',30,2)
Insert Into BookSold values(1,3,'2/4/2007',20,5)
Insert Into BookSold values(2,2,'2/5/2008',10,4)
Insert Into BookSold values(2,1,'2/2/2006',7,5)
Go


--Cau 3:
Select * From Books 
Where Publisher='Open Horizons'


--Cau 4:
Select Publisher,count(Publisher) As [Number of Books published]From Books
group by Publisher


--Cau 5:
Select Customers.*,Books.Title As [Book Name]From Customers,Books
Where (Customers.Address='LonDon') and exists(Select * From BookSold Where Customers.CustomerID=BookSold.CustomerID and Books.BookCode=BookSold.BookCode)


--Cau 6:
Create View View6
As
Select Customers.CustomerName,Books.Title As [Book Name],Books.Publisher From Customers,Books
Where exists(Select * From BookSold Where Customers.CustomerID=BookSold.CustomerID and Books.BookCode=BookSold.BookCode)


--Cau 7:
Select Books.* From Books,BookSold
Where Books.BookCode=BookSold.BookCode and year(BookSold.date)=2008


--Cau 8:
Create Proc sp_8
@cateGory varchar(50)
As
Begin
	If exists(Select * From Books Where CateGory=@cateGory)
		Select * From Books Where CateGory=@cateGory
	Else Select * From Books 
End


--Cau 9:
Create trigger trigger_9
on Customers
For delete
As
Begin
	If exists(Select * From deleted Where Address='LonDon')
	Begin
		print 'Don''t allow you to delete customer From LonDon'
		rollback
	End
End
