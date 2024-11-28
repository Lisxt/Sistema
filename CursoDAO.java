package dao;  //classe CursoDAO está localizada aqui no dao

import Util.Conexao;  //Importa a classe Conexao do pacote Util para obter a conexão com o banco de dados.
import java.sql.*;  //classes necessárias para manipulação do banco de dados 
import java.util.ArrayList;  //classe ArrayList para criar uma lista de cursos.
import java.util.List;  //interface List para usar como tipo de dado para a lista de cursos.

public class CursoDAO {  //Define a classe CursoDAO, que será responsável por interagir com o banco de dados relacionado aos cursos.

    private Connection conexao;  //Declara a variável de conexão com o banco de dados.
    
    private String NomeCurso; 
    private int cargaHoraria;  
    private ProfessorDAO professor;  
    
    // Construtor da classe CursoDAO que inicializa o nome do curso, carga horária e obtém a conexão com o banco de dados.
    public CursoDAO(String nomeCurso, int cargaHoraria) {
        this.NomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.conexao = Conexao.getConnection();  //Obtém a conexão com o banco de dados usando o método estático da classe Conexao.
    }
    
    //getters e setters 
    public String getNomeCurso() {
        return NomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        NomeCurso = nomeCurso;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public ProfessorDAO getProfessor() {
        return professor;
    }

    // Método para cadastrar um novo curso no banco de dados.
    public boolean CadastrarCurso(CursoDAO c) {
        String sql = "{CALL cadastrar_curso(?, ?)}";  //Chama um procedimento armazenado no banco de dados para cadastrar um curso.
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, c.getNomeCurso());  
            stmt.setInt(2, c.getCargaHoraria());  
            stmt.executeUpdate();  
            return true;  
        } catch (SQLException e) {  //Caso ocorra um erro durante a execução, captura a exceção SQL.
            e.printStackTrace();  //Exibe o stack trace do erro.
            return false;  
        }
    }

    //Método para editar as informações de um curso existente no banco de dados.
    public boolean EditarCurso(String nome, int cargahoraria, String Nome) {
        String sql = "UPDATE Curso SET nome = ?, CargaHoraria = ? WHERE nome = ?";  //Consulta para atualizar as informações de um curso.
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);  
            stmt.setInt(2, cargahoraria);  
            stmt.setString(3, Nome);  
            stmt.executeUpdate(); 
            return true;  
        } catch (SQLException e) {  //Caso ocorra um erro durante a execução, captura a exceção SQL.
            e.printStackTrace();  
            return false;  
        }
    }

    //Método para excluir um curso do banco de dados.
    public boolean ExcluirCurso(String nome) {
        String sql = "DELETE FROM Curso WHERE nome = ?";  //Consulta para excluir um curso pelo nome.
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);  
            stmt.executeUpdate();  
            return true;  
        } catch (SQLException e) {  
            e.printStackTrace();  
            return false;  
        }
    }
    
    //Método para associar um professor a um curso.
    public boolean AssociarProfessorAoCurso(ProfessorDAO professor, CursoDAO curso) {
        String sql = "INSERT INTO Professor_Curso (professor_nome, curso_nome) VALUES (?, ?)";  // Insere a associação de um professor a um curso.
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, professor.getNome());  
            stmt.setString(2, curso.getNomeCurso());  
            stmt.executeUpdate();  
            return true;  
        } catch (SQLException e) {  
            e.printStackTrace(); 
            return false;  
        }
    }
    
    //Método para associar um estudante a um curso.
    public boolean AssociarEstudanteAoCurso(EstudanteDAO estudante, CursoDAO curso) {
        String sql = "INSERT INTO Estudante_Curso (estudante_nome, curso_nome) VALUES (?, ?)";  //Insere a associação de um estudante a um curso.
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, estudante.getNome());  
            stmt.setString(2, curso.getNomeCurso());  
            stmt.executeUpdate();  
            return true;  
        } catch (SQLException e) {  
            e.printStackTrace();  
            return false;  
        }
    }

    //Método para exibir todos os cursos cadastrados no banco de dados.
    public void exibirDados() {
        List<CursoDAO> cursos = new ArrayList<>();  //Cria uma lista para armazenar os cursos.
        String sql = "SELECT * FROM curso";  //Consulta para selecionar todos os cursos cadastrados.

        try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (!rs.isBeforeFirst()) {  //Verifica se o ResultSet está vazio 
                System.out.println("Nenhum curso cadastrado.");
            } else {
                while (rs.next()) {  //todos os resultados retornados pela consulta.
                    CursoDAO curso = new CursoDAO(rs.getString("nome"), rs.getInt("CargaHoraria"));  //Cria um novo objeto CursoDAO com os dados do curso.
                    cursos.add(curso);  
                    System.out.println("Curso: " + curso.getNomeCurso() + ", Carga Horária: " + curso.getCargaHoraria());  
                }
            }
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
    }

}
