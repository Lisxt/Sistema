package GerenciarCurso;

import java.util.ArrayList;
import java.util.List;

import Pessoas.Estudante;
import Pessoas.Professor;

public class Curso {

	//ATRIBUTOS
	private String NomeCurso;
	private int cargaHoraria; 
	private Professor professor;
	
	private List<Estudante> estudantes;
	
	private static List<Curso> cursos = new ArrayList<>();
	
	//CONSTRUTOR
	public Curso(String nomeCurso, int cargaHoraria, Professor professor) {
		this.NomeCurso = nomeCurso;
		this.cargaHoraria = cargaHoraria;
		this.professor = professor;
		this.estudantes = new ArrayList<>();
	}
	
	// Get Set
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
	public Professor getProfessor() {
		return  professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public List<Estudante> getEstudantes() {
        return estudantes;
    }
	
	//CRIAR METODO PARA LISTA SOMENTE OS CURSOS
	
	//METODOS
	// Método para exibir dados do curso
	public void exibirDados() {
	    System.out.println("Nome: " + getNomeCurso() +
	            "\nCarga Horaria: " + getCargaHoraria() +
	            "\nProfessor responsável pelo curso: " + getProfessor());

	    if (estudantes.isEmpty()) {
	        System.out.println("Alunos do Curso: Nenhum aluno matriculado.");
	    } else {
	        System.out.println("Quantidade de Alunos: " + estudantes.size());
	        System.out.println("Nomes dos Alunos:");
	        for (Estudante estudante : estudantes) {
	            System.out.println("- " + estudante.getNome());
	        }
	    }
	}

    
    // Método para exibir todos os cursos
   public static void exibirTodosCursos() {
       for (Curso c : cursos) {
            c.exibirDados();
        }
    }
	//// Método para cadastrar um curso
	public static void cadastrarCurso(Curso curso) {
        cursos.add(curso);
        System.out.println("Curso cadastrado com sucesso!");
    }

    // Método para editar os dados de um curso
    public static void editarCurso(String nomeCurso, String novoNome, int novaCargaHoraria) {
        for (Curso c : cursos) {
            if (c.getNomeCurso().equals(nomeCurso)) {
                c.setNomeCurso(novoNome);
                c.setCargaHoraria(novaCargaHoraria);
                System.out.println("Dados do curso atualizados!");
                return;
            }
        }
        System.out.println("Curso não encontrado.");
    }
	
    public static void excluirCurso(String nomeCurso) {
        for (Curso c : cursos) {
            if (c.getNomeCurso().equals(nomeCurso)) {
                c.exclusao();
                cursos.remove(c);
                System.out.println("Curso de" + nomeCurso + " foi excluído.");
                return;
            }
        }
        System.out.println("Curso de " + nomeCurso + " não foi encontrado.");
    }
    
     // Método exclusão
        public void exclusao() {
            setNomeCurso(null); setCargaHoraria(0); setProfessor(null);
            System.out.println("Dados do curso foram excluídos com sucesso!");
        }
        
        public void matricularEstudante(Estudante estudante) {
        	estudantes.add(estudante);
            System.out.println("Estudante " + estudante.getNome() + " matriculado no curso " + getNomeCurso());
        }

	
	
}
