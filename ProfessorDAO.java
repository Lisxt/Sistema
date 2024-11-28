package dao; 

import model.Pessoa; // Importa a classe 'Pessoa' 
import Util.Conexao; // Importa a classe de conexão com o banco de dados.
import java.sql.*; // Importa pacotes relacionados ao uso de JDBC para conexão e manipulação de banco de dados.

public class ProfessorDAO extends Pessoa {  // A classe 'ProfessorDAO' herda a classe 'Pessoa' para ser especializada em professores.
    
    private Connection conexao;  // Atributo para armazenar a conexão com o banco de dados.
    private String especialidade;  // Atributo específico de 'Professor', para armazenar a especialidade do professor.

    // Construtor que recebe o nome, idade e especialidade do professor, além de estabelecer a conexão com o banco.
    public ProfessorDAO(String nome, int idade, String especialidade) {
        super(nome, idade); .
        this.especialidade = especialidade;  
        this.conexao = Conexao.getConnection(); 
    }

    // Getter e Setter
    public String getEspecialidade() {
        return especialidade;  // Retorna a especialidade do professor.
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;  // Define uma nova especialidade para o professor.
    }

    // Método para cadastrar um professor no banco de dados. 
    public boolean CadastrarProfessor(ProfessorDAO prof) {
        String sql = "{CALL cadastrar_professor(?, ?, ?)}";  // Chama um procedimento armazenado 'cadastrar_professor' no banco.
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {  // Prepara a instrução SQL.
            stmt.setString(1, prof.getNome());  
            stmt.setInt(2, prof.getIdade()); 
            stmt.setString(3, prof.getEspecialidade());  
            stmt.executeUpdate();  // Executa a instrução no banco de dados.
            return true;  
        } catch (SQLException e) {  
            e.printStackTrace();  
            return false;  
        }
    }

    // Método para editar os dados de um professor existente no banco de dados.
    public boolean EditarProfessor(String nome, String especialidade, String Nome) {
        String sql = "UPDATE professor SET nome = ?, especialidade = ? WHERE nome = ?";  // SQL para atualizar os dados de um professor.
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {  // Prepara a instrução SQL.
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

    // Método para excluir um professor do banco de dados. Recebe o nome do professor a ser excluído.
    public boolean ExcluirProfessor(String nome) {
        String sql = "DELETE FROM professor WHERE nome = ?";  // SQL para excluir um professor.
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {  
            stmt.setString(1, nome);  
            stmt.executeUpdate();  
            return true;  
        } catch (SQLException e) {  
            e.printStackTrace();  
            return false;  
        }
    }

    // Implementação do método abstrato exibirdados() da classe 'Pessoa'.
    @Override
    public void exibirdados() {
        System.out.println("Nome: " + getNome() + 
                "\nIdade: " + getIdade() + "\nEspecialidade: " + getEspecialidade());
    }
}
