CREATE SCHEMA `desafio` ;

use desafio;

CREATE TABLE TB_VENDA
(
    ID_VENDA    INT NOT NULL,
    DATA		TIMESTAMP DEFAULT NOW(),
    LOJA	    INT,
    PDV			INT,
    STATUS      VARCHAR(15)
);

CREATE TABLE TB_ITEM_VENDA
(
	ID_VENDA	  INT NOT NULL,
    ID_ITEM_VENDA INT NOT NULL,
    PRODUTO	      INT,
    PRECO_UNITARIO DECIMAL(12,2),
    DESCONTO      DECIMAL(12,2)
);

CREATE TABLE TB_PROCESSAMENTO
(
    ID_PROCESSAMENTO INT NOT NULL,
    DATA			 TIMESTAMP DEFAULT NOW(),
    LOJA	    	 INT,
    PDV				 INT,
	NOME_ARQUIVO  	 VARCHAR(50),
    STATUS      	 VARCHAR(15)
);


insert into tb_venda (id_venda, data, loja, pdv, status) values ( 1 ,'2017-06-26 18:41',1,1,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 2 ,'2017-06-27 18:41',2,1,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 3 ,'2017-06-28 18:41',3,1,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 4 ,'2017-06-29 18:41',1,2,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 5 ,'2017-06-30 18:41',2,2,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 6 ,'2017-07-01 18:41',3,2,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 7 ,'2017-07-02 18:41',1,3,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 8 ,'2017-07-03 18:41',2,3,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 9 ,'2017-07-04 18:41',3,3,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 10,'2017-07-05 18:41',1,4,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 11,'2017-07-06 18:41',2,4,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 12,'2017-07-07 18:41',3,4,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 13,'2017-07-08 18:41',1,5,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 14,'2017-07-09 18:41',2,5,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 15,'2017-07-10 18:41',3,5,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 16,'2017-07-11 18:41',1,6,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 17,'2017-07-12 18:41',2,6,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 18,'2017-07-13 18:41',3,6,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 19,'2017-07-14 18:41',1,7,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 20,'2017-07-15 18:41',2,7,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 21,'2017-07-16 18:41',3,7,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 22,'2017-07-17 18:41',1,8,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 22,'2017-07-17 18:41',2,8,'NÃO PROCESSADO');
insert into tb_venda (id_venda, data, loja, pdv, status) values ( 22,'2017-07-17 18:41',3,8,'NÃO PROCESSADO');


insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (1,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (2,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (3,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (4,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (5,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (6,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (7,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (8,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (9,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (10,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (11,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (12,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (13,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (14,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (15,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (16,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (17,1,987654329,1.99,0.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (18,1,1234567890,2.99,1.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (19,1,1234567890,2.99,1.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (20,1,1234567890,2.99,1.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (21,1,1234567890,2.99,1.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (22,1,1234567890,2.99,1.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (22,1,1234567890,2.99,1.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (22,1,1234567890,2.99,1.00);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (1,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (2,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (3,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (4,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (5,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (6,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (7,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (8,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (9,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (10,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (11,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (12,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (13,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (14,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (15,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (16,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (17,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (18,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (19,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (20,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (21,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (22,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (22,2,2123456789,3.99,0.99);
insert into tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) values (22,2,2123456789,3.99,0.99);
