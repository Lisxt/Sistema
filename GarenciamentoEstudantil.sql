-- Criação e uso do banco de dados 'GerenciamentoEstudantil'
CREATE DATABASE GerenciamentoEstudantil;
USE GerenciamentoEstudantil;

-- Criação da tabela 'estudante' 
-- A chave primária é o campo 'nome' 
CREATE TABLE estudante (
    nome VARCHAR(100) NOT NULL, 
    idade INT NOT NULL,         
    matricula VARCHAR(50) NOT NULL,  
    PRIMARY KEY (nome)  
);

-- Criação da tabela 'professor' 
-- A chave primária é o campo 'nome' 
CREATE TABLE professor (
    nome VARCHAR(100) NOT NULL,  
    idade INT NOT NULL,          
    especialidade VARCHAR(50) NOT NULL,  
    PRIMARY KEY (nome)  
);

-- Criação da tabela 'curso' 
-- A chave primária é o campo 'nome' 
CREATE TABLE curso (
    nome VARCHAR(100) NOT NULL,  
    cargaHoraria INT NOT NULL,   
    PRIMARY KEY (nome)  
);

-- Exibe todas as tabelas criadas no banco de dados
SHOW TABLES;

-- Muda o delimitador de comando para '//' para definir procedimentos armazenados
DELIMITER //

-- Criação do procedimento armazenado para cadastrar um estudante
CREATE PROCEDURE cadastrar_estudante(
    IN p_nome VARCHAR(100),    
    IN p_idade INT,           
    IN p_matricula VARCHAR(50) 
)
BEGIN
    -- Insere os dados fornecidos no banco de dados na tabela 'estudante'
    INSERT INTO estudante (nome, idade, matricula) 
    VALUES (p_nome, p_idade, p_matricula);
END //

-- Restaura o delimitador para o padrão ';' após a criação do procedimento
DELIMITER ;

-- Exibe a estrutura da tabela 'estudante' para verificar os campos
DESCRIBE estudante;

-- Muda o delimitador novamente para criar outro procedimento
DELIMITER //

-- Criação do procedimento armazenado para cadastrar um professor
CREATE PROCEDURE cadastrar_professor(
    IN p_nome VARCHAR(100),          
    IN p_idade INT,                  
    IN p_especialidade VARCHAR(50)   
)
BEGIN
    -- Insere os dados fornecidos no banco de dados na tabela 'professor'
    INSERT INTO professor (nome, idade, especialidade) 
    VALUES (p_nome, p_idade, p_especialidade);
END //

-- Restaura o delimitador para o padrão ';' após a criação do procedimento
DELIMITER ;

-- Exibe a estrutura da tabela 'professor' para verificar os campos
DESCRIBE professor;

-- Muda o delimitador para criar o procedimento para 'curso'
DELIMITER //

-- Criação do procedimento armazenado para cadastrar um curso
CREATE PROCEDURE cadastrar_curso(
    IN p_nome VARCHAR(100),   
    IN p_cargaHoraria INT    
)
BEGIN
    -- Insere os dados fornecidos no banco de dados na tabela 'curso'
    INSERT INTO curso (nome, cargaHoraria) 
    VALUES (p_nome, p_cargaHoraria);
END //

-- Restaura o delimitador para o padrão ';' após a criação do procedimento
DELIMITER ;

-- Exibe a estrutura da tabela 'curso' para verificar os campos
DESCRIBE curso;

-- Criação da tabela 'Professor_Curso' para armazenar a relação entre professores e cursos
-- Cada linha representa a associação de um professor a um curso
CREATE TABLE Professor_Curso (
    professor_nome VARCHAR(100) NOT NULL,   
    curso_nome VARCHAR(100) NOT NULL,      
    PRIMARY KEY (professor_nome, curso_nome),  -- Chave primária composta pelos nomes do professor e do curso
    FOREIGN KEY (professor_nome) REFERENCES professor(nome),  -- Chave estrangeira que faz referência à tabela 'professor'
    FOREIGN KEY (curso_nome) REFERENCES curso(nome)           -- Chave estrangeira que faz referência à tabela 'curso'
);

-- Criação da tabela 'Estudante_Curso' para armazenar a relação entre estudantes e cursos
-- Cada linha representa a associação de um estudante a um curso
CREATE TABLE Estudante_Curso (
    estudante_nome VARCHAR(100) NOT NULL,  
    curso_nome VARCHAR(100) NOT NULL,      
    PRIMARY KEY (estudante_nome, curso_nome),  -- Chave primária composta pelos nomes do estudante e do curso
    FOREIGN KEY (estudante_nome) REFERENCES estudante(nome),  -- Chave estrangeira que faz referência à tabela 'estudante'
    FOREIGN KEY (curso_nome) REFERENCES curso(nome)           -- Chave estrangeira que faz referência à tabela 'curso'
);


-- Alteração para permitir que, ao atualizar o nome de um estudante, as referências na tabela 'Estudante_Curso' também sejam atualizadas
ALTER TABLE estudante_curso
DROP FOREIGN KEY estudante_curso_ibfk_1;
ALTER TABLE estudante_curso
ADD CONSTRAINT estudante_curso_ibfk_1 FOREIGN KEY (estudante_nome) REFERENCES estudante(nome) ON UPDATE CASCADE;

-- Alteração para definir que, ao excluir um curso, as referências na tabela 'Estudante_Curso' sejam removidas
ALTER TABLE estudante_curso
DROP FOREIGN KEY estudante_curso_ibfk_2;
ALTER TABLE estudante_curso
ADD CONSTRAINT estudante_curso_ibfk_2 FOREIGN KEY (curso_nome) REFERENCES curso(nome) ON UPDATE CASCADE ON DELETE CASCADE;

-- Alteração para permitir que, ao atualizar o nome de um professor, as referências na tabela 'Professor_Curso' também sejam atualizadas
ALTER TABLE professor_curso
DROP FOREIGN KEY professor_curso_ibfk_1;
ALTER TABLE professor_curso
ADD CONSTRAINT professor_curso_ibfk_1 FOREIGN KEY (professor_nome) REFERENCES professor(nome) ON UPDATE CASCADE;

-- Alteração para definir que, ao excluir um curso, as referências na tabela 'Professor_Curso' sejam removidas
ALTER TABLE professor_curso
DROP FOREIGN KEY professor_curso_ibfk_2;
ALTER TABLE professor_curso
ADD CONSTRAINT professor_curso_ibfk_2 FOREIGN KEY (curso_nome) REFERENCES curso(nome) ON UPDATE CASCADE ON DELETE CASCADE;

-- Ajuste para garantir que, ao excluir um estudante, as referências na tabela 'Estudante_Curso' sejam removidas
ALTER TABLE estudante_curso
DROP FOREIGN KEY estudante_curso_ibfk_1;
ALTER TABLE estudante_curso
ADD CONSTRAINT estudante_curso_ibfk_1 FOREIGN KEY (estudante_nome) REFERENCES estudante(nome) ON DELETE CASCADE ON UPDATE CASCADE;

-- Ajuste para restringir a exclusão de um curso se houver estudantes associados a ele
ALTER TABLE estudante_curso
DROP FOREIGN KEY estudante_curso_ibfk_2;
ALTER TABLE estudante_curso
ADD CONSTRAINT estudante_curso_ibfk_2 FOREIGN KEY (curso_nome) REFERENCES curso(nome) ON DELETE RESTRICT ON UPDATE CASCADE;

-- Ajuste para garantir que, ao excluir um professor, as referências na tabela 'Professor_Curso' sejam removidas
ALTER TABLE professor_curso
DROP FOREIGN KEY professor_curso_ibfk_1;
ALTER TABLE professor_curso
ADD CONSTRAINT professor_curso_ibfk_1 FOREIGN KEY (professor_nome) REFERENCES professor(nome) ON DELETE CASCADE ON UPDATE CASCADE;

-- Ajuste para garantir que, ao excluir um curso, as referências na tabela 'Professor_Curso' sejam removidas
ALTER TABLE professor_curso
DROP FOREIGN KEY professor_curso_ibfk_2;
ALTER TABLE professor_curso
ADD CONSTRAINT professor_curso_ibfk_2 FOREIGN KEY (curso_nome) REFERENCES curso(nome) ON DELETE CASCADE ON UPDATE CASCADE;

-- Consultas para verificar os dados nas tabelas após os procedimentos de inserção
SELECT * FROM estudante;
SELECT * FROM curso;
SELECT * FROM professor;
SELECT * FROM estudante_curso;
SELECT * FROM professor_curso;

-- Exclui todos os dados nas tabelas de relacionamento entre estudante e curso, professor e curso
DELETE FROM estudante_curso;
DELETE FROM professor_curso;
DELETE FROM estudante;
DELETE FROM professor;
DELETE FROM curso;
