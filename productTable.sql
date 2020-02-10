CREATE TABLE Products (
    product_name VARCHAR(100) PRIMARY KEY,
    category VARCHAR(100)
);

CREATE TABLE Price_History (
    history_id INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2),
    begin_date DATE,
    end_date DATE,
    FOREIGN KEY(product_name) REFERENCES Products(product_name) ON DELETE CASCADE
);

INSERT INTO Products
VALUES ('Basketball', 'Sports');
INSERT INTO Products
VALUES ('Laptop', 'Electronics');

INSERT INTO Price_History
VALUES (1, 'Basketball', 10.99, 2020-1-07, NULL);
INSERT INTO Price_History
VALUES (2, 'Laptop', 1250.00, 2020-1-07, NULL);
INSERT INTO Price_History
VALUES (3, 'Basketball', 9.99, 2020-1-09, NULL);

UPDATE Price_History 
SET Price_History.end_date = (SELECT MAX(begin_date) FROM Price_History)
WHERE Price_History.product_name = 'Basketball'
AND Price_History.end_date = NULL;

SELECT Products.product_name,
        Products.category,
        Price_History.price,
        Price_History.begin_date,
        Price_History.end_date,
        Price_History.history_id
    FROM Products
    INNER JOIN Price_History
    ON Price_History.product_name = Products.product_name;