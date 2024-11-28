package dao;
import model.Pessoa;
import Util.Conexao;
import java.sql.*;


public class EstudanteDAO extends Pessoa {

    private Connection conexao;
    private String matricula;
    public EstudanteDAO(String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
        this.conexao = Conexao.getConnection();
    }

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

    public boolean CadastrarEstudante(EstudanteDAO est) {
    	String sql = "{CALL cadastrar_estudante(?, ?, ?)}"; 
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

    public boolean EditarEstudante(String nome, int idade, String Nome) {
        String sql = "UPDATE estudante SET nome = ?,  idade = ?  WHERE nome = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
        	stmt.setString(1, nome);       // Nome novo
            stmt.setInt(2, idade);         // Idade nova
            stmt.setString(3, Nome);       // Nome do estudante a ser editado (condição no WHERE)
            stmt.executeUpdate();
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ExcluirEstudante(String nome) {
        String sql = "DELETE FROM estudante WHERE nome = ?";
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
    // Método para exibir dados do estudante
    public void exibirdados() {
        System.out.println("Nome: " + getNome() + 
        "\nIdade: " + getIdade() + "\nMatrícula: " + getMatricula());
     
    }
    
 }
