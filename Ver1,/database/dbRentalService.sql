CREATE DATABASE RentalService
GO

USE RentalService
GO

CREATE TABLE tblUser
(
	[uId] VARCHAR (20) PRIMARY KEY, 
	uUser VARCHAR (40) UNIQUE,
	uPass VARCHAR (20),
	uName NVARCHAR (100),
	uGender int, --0: nam, 1: nữ
	uAddress NVARCHAR (200),
	uDateOfBirth DATE,
	uPhone VARCHAR (20),
	uAvatar NVARCHAR (200),
	uRole int, --0: nhân viên, 1: tài xế, 2: manager
)

INSERT INTO tblUser ([uId], uUser, uPass, uRole) VALUES
('u01', 'admin', '123456', 2),
('u02', 'staff1', '123456', 0),
('u03', 'staff2', '123456', 0),
('u04', 'staff3', '123456', 0),
('u05', 'driver', '123456', 1)

SELECT * FROM tblUser

CREATE TABLE tblCar
(
	cId VARCHAR (20) PRIMARY KEY,
	cName NVARCHAR (40),
	cType NVARCHAR (40),
	cBrand NVARCHAR (40),
	cSeat int,
	cImage NVARCHAR (200),
	cRentCost FLOAT,
	cStatus int, --0: chưa thuê, 1: đã thuê
	[uId] VARCHAR (20) FOREIGN KEY REFERENCES tblUser([uId])
)

SELECT * FROM tblCar

INSERT INTO tblCar (cId) VALUES
('c01')

SELECT * FROM tblCar

CREATE TABLE tblCustomer
(
	cusId VARCHAR (20) PRIMARY KEY,
	cusName NVARCHAR (100),
	cusPhone VARCHAR (20),
	cusAddress NVARCHAR (200),
	cusIdCard VARCHAR (50)
)

CREATE TABLE tblService
(
	[sId] VARCHAR (20) PRIMARY KEY,
	cId VARCHAR (20) FOREIGN KEY REFERENCES tblCar (cId),
	cusId VARCHAR (20) FOREIGN KEY REFERENCES tblCustomer (cusId),
	sMoney FLOAT,
	sStartDate SMALLDATETIME,
	sEndDate SMALLDATETIME,
	sStatus int --0: đang hoạt động, 1: hết hạn
)
