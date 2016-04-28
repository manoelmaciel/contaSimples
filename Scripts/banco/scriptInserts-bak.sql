-- MySQL dump 10.10
--
-- Host: localhost    Database: relatorios
-- ------------------------------------------------------
-- Server version	5.0.18-nt

USE dbContaSimples;

INSERT INTO `CLIENTES` VALUES(1, 'Cliente1'),  (2, 'Cliente2'),  (3, 'Cliente3'),  (4, 'Cliente4'),  (5, 'Cliente5');


INSERT INTO `CONTAS` VALUES (1, 1), (2, 2), (3, 3), (4, 4), (5, 5); 

INSERT INTO `MOVIMENTOS` VALUES 
	(1, '2016-01-11', 'Saldo inicial', '1', 0, 1), 
	(2, '2016-01-11', 'Salario', '1', 2100.00, 1), 
	(3, '2016-01-11', 'Agua', '0', 101.00, 1), 
    (4, '2016-01-13', 'Luz', '0', 201.00, 1), 
	(5, '2016-01-13', 'Telefone', '0', 301.00, 1), 
    (6, '2016-01-15', 'Aluguel', '0', 401.00, 1), 
	(7, '2016-01-15', 'Supermercado', '0', 501.00, 1), 
    (8, '2016-01-17', 'Carne', '0', 601.00, 1), 
	(9, '2016-01-17', 'Feira', '0', 701.00, 1), 
    (10, '2016-01-19', 'Lanche', '0', 801.00, 1),
	(11, '2016-02-2', 'Salario', '1', 2200.00, 1), 
	(12, '2016-02-22', 'Agua', '0', 102.00, 1), 
    (13, '2016-02-22', 'Luz', '0', 202.00, 1), 
	(14, '2016-02-24', 'Telefone', '0', 302.00, 1), 
    (15, '2016-02-24', 'Aluguel', '0', 402.00, 1), 
	(16, '2016-02-26', 'Supermercado', '0', 502.00, 1), 
    (17, '2016-02-26', 'Carne', '0', 602.00, 1), 
	(18, '2016-02-28', 'Feira', '0', 702.00, 1), 
    (19, '2016-02-28', 'Lanche', '0', 802.00, 1),
	(20, '2016-03-25', 'Salario', '1', 2300.00, 1), 
	(21, '2016-03-25', 'Agua', '0', 103.00, 1), 
    (22, '2016-03-25', 'Luz', '0', 203.00, 1), 
	(23, '2016-03-25', 'Telefone', '0', 303.00, 1), 
    (24, '2016-03-25', 'Aluguel', '0', 403.00, 1), 
	(25, '2016-03-25', 'Supermercado', '0', 503.00, 1), 
    (26, '2016-03-25', 'Carne', '0', 603.00, 1), 
	(27, '2016-03-25', 'Feira', '0', 703.00, 1), 
    (28, '2016-03-25', 'Lanche', '0', 803.00, 1);