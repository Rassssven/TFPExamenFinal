CREATE DATABASE IF NOT EXISTS greetingsDB;

USE greetingsDB;

CREATE TABLE IF NOT EXISTS Greeting (
    GreetingID INT AUTO_INCREMENT PRIMARY KEY,
    Description VARCHAR(255) NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    TypeID INT,
    CategoryID INT
);

CREATE TABLE IF NOT EXISTS Type (
    TypeID INT AUTO_INCREMENT PRIMARY KEY,
    TypeName VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Category (
    CategoryID INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName VARCHAR(100) NOT NULL
);

INSERT INTO Type (TypeName) 
    VALUES ('Fizica'), ('Electronica');

INSERT INTO Category (CategoryName) 
    VALUES ('Aniversare'), ('Craciun'), ('Paste'), ('ziua mamei'), ('absolvire');

INSERT INTO Greeting (Description, Price, TypeID, CategoryID) 
    VALUES 
    ('Felicitare aniversara electronica', 15.00, 2, 1),
    ('Felicitare de Craciun fizica', 20.00, 1, 2),
    ('Felicitare de Paste electronica', 10.00, 2, 3),
    ('Felicitare de ziua mami fizica', 18.00, 1, 4),
    ('Felicitare de absolvire electronica', 25.00, 2, 5),
    ('Felicitare aniversara fizica', 22.00, 1, 1);