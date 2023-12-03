CREATE DATABASE IF NOT EXISTS dianome;

USE dianome;


CREATE TABLE IF NOT EXISTS entregador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(255),
    contato VARCHAR(255),
    capacidade_do_veiculo_em_kg DOUBLE
);

