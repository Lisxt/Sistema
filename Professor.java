package Pessoas;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa{
	
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
    public String toString() {
        return  getNome();
    }
	
	@Override
	public void exibirDados() {
		System.out.println("Nome: " + getNome() + 
		        "\nIdade: " + getIdade() + "\nEspecialidade: " + getEspecialidade());
		
	}
	
	 public static void exibirTodosProfessores() {
	        for (Professor prof: professores) {
	            prof.exibirDados();
	        }
	    }
	 
	 public static void cadastrarProfessor(Professor professor) {
	       	professores.add(professor);
	        System.out.println("Professor(a) cadastrado com sucesso.");
	    }

	    // Método editar professor
	    public static void editarProfessor(String nome, String novoNome, String novaEspecialidade) {
	        for (Professor prof : professores) {
	            if (prof.getNome().equals(nome)) {
	            	prof.setNome(novoNome);
	            	prof.setEspecialidade(novaEspecialidade);
	                System.out.println("Dados do Professor(a) " + nome + " foram editados.");
	                return;
	            }
	        }
	        System.out.println("Professor(a)" + nome + " não foi encontrado.");
	    }

	    // Método excluir professor
	    public static void excluirProfessor(String nome) {
	        for (Professor prof : professores) {
	            if (prof.getNome().equals(nome)) { 
	                prof.exclusao();
	                professores.remove(prof);
	                System.out.println("Professor(a) " + nome + " foi excluído.");
	                return;
	            }
	        }
	        System.out.println("Professor(a) " + nome + " não foi encontrado.");
	    }
	   // Método exclusão
	        public void exclusao() {
	            setNome(null); setIdade(0); setEspecialidade(null);
	            System.out.println("Dados do professor(a) foram excluídos com sucesso!");
	        }



	
	
}
