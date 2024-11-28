CREATE DATABASE GerenciamentoEstudantil; 
USE GerenciamentoEstudantil; 

CREATE TABLE estudante (
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    matricula VARCHAR(50) NOT NULL,
    PRIMARY KEY (nome)
);

CREATE TABLE professor (
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    especialidade VARCHAR(50) NOT NULL,
    PRIMARY KEY (nome)
);

CREATE TABLE curso (
    nome VARCHAR(100) NOT NULL,
    cargaHoraria INT NOT NULL,
    PRIMARY KEY (nome)
);

SHOW TABLES;

DELIMITER //

CREATE PROCEDURE cadastrar_estudante(
    IN p_nome VARCHAR(100),
    IN p_idade INT,
    IN p_matricula VARCHAR(50)
)

BEGIN
    INSERT INTO estudante (nome, idade, matricula) 
    VALUES (p_nome, p_idade, p_matricula);
END //

DELIMITER ;

DESCRIBE estudante;

DELIMITER //

CREATE PROCEDURE cadastrar_professor(
    IN p_nome VARCHAR(100),
    IN p_idade INT,
    IN p_especialidade VARCHAR(50)
)

BEGIN
    INSERT INTO professor (nome, idade, especialidade) 
    VALUES (p_nome, p_idade, p_especialidade);
END //

DELIMITER ;

DESCRIBE professor;

DELIMITER //

CREATE PROCEDURE cadastrar_curso(
    IN p_nome VARCHAR(100),
    IN p_cargaHoraria INT
)

BEGIN
    INSERT INTO curso (nome, cargaHoraria) 
    VALUES (p_nome, p_cargaHoraria);
END //

DELIMITER ;

DESCRIBE curso;

CREATE TABLE Professor_Curso (
    professor_nome VARCHAR(100) NOT NULL,
    curso_nome VARCHAR(100) NOT NULL,
    PRIMARY KEY (professor_nome, curso_nome),
    FOREIGN KEY (professor_nome) REFERENCES Professor(nome),
    FOREIGN KEY (curso_nome) REFERENCES Curso(nome)
);

CREATE TABLE Estudante_Curso (
    estudante_nome VARCHAR(100) NOT NULL,
    curso_nome VARCHAR(100) NOT NULL,
    PRIMARY KEY (estudante_nome, curso_nome),
    FOREIGN KEY (estudante_nome) REFERENCES Estudante(nome),
    FOREIGN KEY (curso_nome) REFERENCES Curso(nome)
);
-- alterar o estudante
ALTER TABLE estudante_curso
DROP FOREIGN KEY estudante_curso_ibfk_1;
ALTER TABLE estudante_curso
ADD CONSTRAINT estudante_curso_ibfk_1 FOREIGN KEY (estudante_nome) REFERENCES estudante(nome) ON UPDATE CASCADE;

-- alterar o curso
ALTER TABLE estudante_curso
DROP FOREIGN KEY estudante_curso_ibfk_2;
ALTER TABLE estudante_curso
ADD CONSTRAINT estudante_curso_ibfk_2 FOREIGN KEY (curso_nome) REFERENCES curso(nome) ON UPDATE CASCADE ON DELETE CASCADE;

-- alterar professor
ALTER TABLE professor_curso
DROP FOREIGN KEY professor_curso_ibfk_1;
ALTER TABLE professor_curso
ADD CONSTRAINT professor_curso_ibfk_1 FOREIGN KEY (professor_nome) REFERENCES professor(nome) ON UPDATE CASCADE;

-- alterar o curso
ALTER TABLE professor_curso
DROP FOREIGN KEY professor_curso_ibfk_2;
ALTER TABLE professor_curso
ADD CONSTRAINT professor_curso_ibfk_2 FOREIGN KEY (curso_nome) REFERENCES curso(nome) ON UPDATE CASCADE ON DELETE CASCADE;

-- excluir estudante
ALTER TABLE estudante_curso
DROP FOREIGN KEY estudante_curso_ibfk_1;
ALTER TABLE estudante_curso
ADD CONSTRAINT estudante_curso_ibfk_1 FOREIGN KEY (estudante_nome) REFERENCES estudante(nome) ON DELETE CASCADE ON UPDATE CASCADE;

-- excluir o curso
-- verificar
ALTER TABLE estudante_curso
DROP FOREIGN KEY estudante_curso_ibfk_2;
ALTER TABLE estudante_curso
ADD CONSTRAINT estudante_curso_ibfk_2 FOREIGN KEY (curso_nome) REFERENCES curso(nome) ON DELETE RESTRICT ON UPDATE CASCADE;

-- excluir professor
ALTER TABLE professor_curso
DROP FOREIGN KEY professor_curso_ibfk_1;
ALTER TABLE professor_curso
ADD CONSTRAINT professor_curso_ibfk_1 FOREIGN KEY (professor_nome) REFERENCES professor(nome) ON DELETE CASCADE ON UPDATE CASCADE;

-- excluir o curso
ALTER TABLE professor_curso
DROP FOREIGN KEY professor_curso_ibfk_2;
ALTER TABLE professor_curso
ADD CONSTRAINT professor_curso_ibfk_2 FOREIGN KEY (curso_nome) REFERENCES curso(nome) ON DELETE CASCADE ON UPDATE CASCADE;

SELECT * FROM estudante;
SELECT * FROM curso;
SELECT * FROM professor;
SELECT * FROM estudante_curso;
SELECT * FROM professor_curso;

DELETE FROM estudante_curso;
DELETE FROM professor_curso;
DELETE FROM estudante;
DELETE FROM professor;
DELETE FROM curso;


