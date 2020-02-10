--Author: Trish Lam
--Date: 2/9/2020
--File: productTable.sql
--For: Taboola Backend Software Engineer Intern Take Home Test (Part 3)
--Purpose: Design two new tables to store information about products and its price history



--Create Table for Products, including strings: the product name as the
--primary key and the category in which the product is in.
CREATE TABLE Products (
    product_name VARCHAR(100) PRIMARY KEY,
    category VARCHAR(100)
);



--Create Table for the Price History of the Products
--Includes a History ID in order to uniquely define the different rows
--Product name which is the foreign key that refers back to the Products table
--Price, begin_date, end_date which describe the product
CREATE TABLE Price_History (
    history_id INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2),
    begin_date DATE,
    end_date DATE,
    FOREIGN KEY(product_name) REFERENCES Products(product_name) ON DELETE CASCADE
);



--Insert instances for Products table: Basketball and Laptop
INSERT INTO Products
VALUES ('Basketball', 'Sports');
INSERT INTO Products
VALUES ('Laptop', 'Electronics');



--Insert instances for Price_History of the products added
--into the Products table: Basketball and Laptop.
--The end dates for the products are set to NULL,
--because the current price doed not have an end date.
INSERT INTO Price_History
VALUES (1,'Basketball', 10.99, '2020-01-07', NULL);
INSERT INTO Price_History
VALUES (2,'Laptop', 1250.00, '2020-01-07', NULL);



--Basketball gets added into Price History again because
--its price has been changed.
INSERT INTO Price_History
VALUES (3,'Basketball', 9.99, '2020-01-11', NULL);



--Updates the end date for the old Basketball row, since its
--price has changed and thus is not the current price.
UPDATE Price_History 
--Selects latest begin date because it is the date in which
--the current price has changed
SET end_date = (SELECT MAX(begin_date) FROM Price_History)
WHERE Price_History.product_name = 'Basketball'
AND Price_History.end_date IS NULL
--To ensure that the current price does not have an end date
AND Price_History.begin_date < (SELECT MAX(begin_date) FROM Price_History);



--Combines both tables and its columns using the product name
SELECT Products.product_name,
        Products.category,
        Price_History.price,
        Price_History.begin_date,
        Price_History.end_date,
        Price_History.history_id
    FROM Products
    INNER JOIN Price_History
    ON Price_History.product_name = Products.product_name;