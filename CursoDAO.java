package dao;
import Util.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CursoDAO{

    private Connection conexao;
    
    private String NomeCurso;
	private int cargaHoraria; 
	private ProfessorDAO professor;
	
    public CursoDAO(String nomeCurso, int cargaHoraria) {
    	this.NomeCurso = nomeCurso;
		this.cargaHoraria = cargaHoraria;
        this.conexao = Conexao.getConnection();
    }
    
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

    public boolean CadastrarCurso(CursoDAO c) {
    	String sql = "{CALL cadastrar_curso(?, ?)}"; 
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, c.getNomeCurso());
            stmt.setInt(2, c.getCargaHoraria());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean EditarCurso(String nome, int cargahoraria, String Nome) {
        String sql = "UPDATE Curso SET nome = ?,  CargaHoraria= ? WHERE nome = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, cargahoraria);
            stmt.setString(3, Nome);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ExcluirCurso(String nome) {
        String sql = "DELETE FROM Curso WHERE nome = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean AssociarProfessorAoCurso(ProfessorDAO professor, CursoDAO curso) {
        String sql = "INSERT INTO Professor_Curso (professor_nome, curso_nome) VALUES (?, ?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, professor.getNome()); // nome do professor
            stmt.setString(2, curso.getNomeCurso()); // Nome do curso
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean AssociarEstudanteAoCurso(EstudanteDAO estudante, CursoDAO curso) {
        String sql = "INSERT INTO Estudante_Curso (estudante_nome, curso_nome) VALUES (?, ?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, estudante.getNome()); // nome do aluno
            stmt.setString(2, curso.getNomeCurso()); // Nome do curso
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

		public void exibirDados() {
		    List<CursoDAO> cursos = new ArrayList<>();
		    String sql = "SELECT * FROM curso";

		    try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
		        if (!rs.isBeforeFirst()) { // Verifica se há dados no ResultSet
		            System.out.println("Nenhum curso cadastrado.");
		        } else {
		            while (rs.next()) {
		                CursoDAO curso = new CursoDAO(rs.getString("nome"), rs.getInt("CargaHoraria"));
		                cursos.add(curso);
		                System.out.println("Curso: " + curso.getNomeCurso() + ", Carga Horária: " + curso.getCargaHoraria());
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

}


