package Sistema;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa{
	//subclasse de pessoa
	
	//ATRIBUTOS
	private String especialidade;
	private static List<Professor> professores = new ArrayList<>();
	
	//CONSTRUTOR
	public Professor(String nome, int idade, String especialidade) {
		super(nome, idade);
		this.especialidade = especialidade;
	}
	
	//METODOS
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public void exibirDados() {
		System.out.println("Nome: " + getNome() + 
		        "\nIdade: " + getIdade() + "\nMatrícula: " + getEspecialidade());
		
	}
	
	 public static void exibirTodosEstudantes() {
	        for (Professor professor : professores) {
	            professor.exibirDados();
	        }
	    }
	 
	 public static void cadastrarProfessor(String nome, int idade, String especialidade) {
		 Professor novoProfessor = new Professor(nome, idade, especialidade);
	       	professores.add(novoProfessor);
	        System.out.println("Professor " + nome + " cadastrado com sucesso.");
	    }

	    // Método editar professor
	    public static void editarProfessor(String nome, String novoNome, int novaIdade, String novaEspecialidade) {
	        for (Professor professor : professores) {
	            if (professor.getNome().equals(nome)) { // Ignora maiúsculas/minúsculas
	            	professor.setNome(novoNome);
	            	professor.setIdade(novaIdade);
	            	professor.setEspecialidade(novaEspecialidade);
	                System.out.println("Dados do Professor " + nome + " editados com sucesso.");
	                return;
	            }
	        }
	        System.out.println("Professor com o nome " + nome + " não encontrado.");
	    }

	    // Método excluir professor
	    public static void excluirProfessor(String nome) {
	        for (int i = 0; i < professores.size(); i++) {
	            Professor professor = professores.get(i);
	            if (professor.getNome().equalsIgnoreCase(nome)) { // Ignora maiúsculas/minúsculas
	                professor.exclusao();
	                professores.remove(i);
	                System.out.println("Professor " + nome + " excluído com sucesso.");
	                return;
	            }
	        }
	        System.out.println("Professor com o nome " + nome + " não encontrado.");
	    }
	   // Método exclusão
	        public void exclusao() {
	            setNome(null);
	            setIdade(0);
	            setEspecialidade(null);
	            System.out.println("Dados do professor excluídos com sucesso!");
	        }



	
	
}

