CREATE DATABASE dbprojeto;
USE dbprojeto;

CREATE TABLE tbusuario (
	pkusuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60),
    email VARCHAR(40) UNIQUE NOT NULL,
    senha VARCHAR(40) NOT NULL,
    datanasc DATE,
    ativo BOOLEAN DEFAULT TRUE    
);

INSERT INTO tbusuario(nome, email, senha, datanasc, ativo) VALUES
('theo', 'theo@gmail.com', 'musica', '2007-08-13', true);
UPDATE tbusuario SET senha = SHA1('musica');


