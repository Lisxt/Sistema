package dao;  //onde a classe EstudanteDAO está localizada.

import model.Pessoa;  // classe Pessoa do pacote model
import Util.Conexao;  //classe Conexao do pacote Util
import java.sql.*;  // classes necessárias para manipulação do banco de dados (Connection, PreparedStatement, SQLException, etc.).

public class EstudanteDAO extends Pessoa {  // A classe EstudanteDAO herda da classe Pessoa, representando um estudante.

    private Connection conexao;  
    private String matricula;  
    
    // Construtor da classe EstudanteDAO, que recebe o nome, idade e matrícula do estudante e inicializa a conexão com o banco de dados.
    public EstudanteDAO(String nome, int idade, String matricula) {
        super(nome, idade); 
        this.matricula = matricula;  
        this.conexao = Conexao.getConnection();  // Obtém a conexão com o banco de dados através da classe Conexao.
    }

    // getters e setters 
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    //Método para cadastrar um novo estudante no banco de dados, utilizando um procedimento armazenado.
    public boolean CadastrarEstudante(EstudanteDAO est) {
        String sql = "{CALL cadastrar_estudante(?, ?, ?)}";  // Chama um procedimento armazenado para cadastrar um estudante.
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, est.getNome());  
            stmt.setInt(2, est.getIdade());   
            stmt.setString(3, est.getMatricula());  
            stmt.executeUpdate();  
            return true;  
        } catch (SQLException e) {  
            e.printStackTrace();  
            return false;  
        }
    }

    //Método para editar as informações de um estudante no banco de dados.
    public boolean EditarEstudante(String nome, int idade, String Nome) {
        String sql = "UPDATE estudante SET nome = ?, idade = ? WHERE nome = ?";  // Consulta SQL para atualizar as informações de um estudante.
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);  
            stmt.setInt(2, idade);   
            stmt.setString(3, Nome);  
            stmt.executeUpdate();  
            return true;  
        } catch (SQLException e) {  
            e.printStackTrace(); 
            return false;  
        }
    }

    //Método para excluir um estudante do banco de dados.
    public boolean ExcluirEstudante(String nome) {
        String sql = "DELETE FROM estudante WHERE nome = ?";  // Consulta SQL para excluir um estudante pelo nome.
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);  
            stmt.executeUpdate();  
            return true;  
        } catch (SQLException e) {  
            e.printStackTrace();  
            return false; 
        }
    }
    
    @Override
    //Método que exibe os dados do estudante (sobrescreve o método da classe Pessoa).
    public void exibirdados() {
        System.out.println("Nome: " + getNome() + 
        "\nIdade: " + getIdade() + "\nMatrícula: " + getMatricula());
    }

}
