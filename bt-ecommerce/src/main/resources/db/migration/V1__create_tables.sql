CREATE TABLE brand (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE product (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE price (
    id INT AUTO_INCREMENT PRIMARY KEY,
    brand_id INT NOT NULL,
    product_id INT NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    priority INT NOT NULL,
    PRICE DECIMAL(6,2) NOT NULL,
    currency_iso VARCHAR(3) NOT NULL,
   -- created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    --updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (brand_id) REFERENCES brand(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

