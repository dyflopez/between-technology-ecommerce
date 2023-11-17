INSERT INTO brand (name) VALUES ('ZARA');


INSERT INTO product (id,name) VALUES (35455,'VESTIDO RIB CUT OUT');
INSERT INTO product (id,name) VALUES (35456,'VESTIDO ENTALLADO INTERLOCKESPALDA DESCUBIERTA');
INSERT INTO product (id,name) VALUES (35457,'CAMISETA EFECTO LAVADO ESTAMPADO');



INSERT INTO price (brand_id,product_id,start_date,end_date,priority,price,currency_iso) VALUES
                (1,35455,'2020-06-14 00:00:00','2020-12-31 23:59:59',0,35.50,'EUR'),
                (1,35455,'2020-06-14 15:00:00','2020-06-14 18:30:00',1,25.45,'EUR'),
                (1,35455,'2020-06-15 00:00:00','2020-06-15 11:00:00',1,30.50,'EUR'),
                (1,35455,'2020-06-15 16:00:00','2020-12-31 23:59:59',1,38.95,'EUR');