package dao;
import model.Pessoa;

import Util.Conexao;

import java.sql.*;
public class ProfessorDAO extends Pessoa {

    private Connection conexao;
    private String especialidade;

    public ProfessorDAO(String nome, int idade, String especialidade) {
        super(nome, idade);
        this.especialidade = especialidade;
        this.conexao = Conexao.getConnection();
    }
    
    public String getEspecialidade() {
		return especialidade ;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

    public boolean CadastrarProfessor(ProfessorDAO prof) {
    	String sql = "{CALL cadastrar_professor(?, ?, ?)}"; 
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, prof.getNome());
            stmt.setInt(2, prof.getIdade());
            stmt.setString(3, prof.getEspecialidade());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean EditarProfessor(String nome, String especialidade, String Nome) {
        String sql = "UPDATE professor SET nome = ?, especialidade = ?  WHERE nome = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, especialidade);
            stmt.setString(3, Nome);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ExcluirProfessor(String nome) {
        String sql = "DELETE FROM professor WHERE nome = ?";
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
	public void exibirdados() {
		System.out.println("Nome: " + getNome() + 
		        "\nIdade: " + getIdade() + "\nEspecialidade: " + getEspecialidade());
		
	}
}
