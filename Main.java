package Pessoas;
import GerenciarCurso.Curso;
import GerenciarCurso.Relatorios;

public class Main {
	public static void main(String[] args) {
		       
				//criar PROFESSORES
				Professor professor1 = new Professor("Maria", 35, "Matemática");
				Professor professor2 = new Professor("Matheus", 60, "Física");
				//cadastrar PROFESSORES
				Professor.cadastrarProfessor(professor1);
				Professor.cadastrarProfessor(professor2);
				
				//criar CURSO
				Curso curso1 = new Curso("Programação", 60, professor1);
				Curso curso2 = new Curso("Estrutura de Dados", 180, professor2);
				//cadastrar CURSO
				Curso.cadastrarCurso(curso1);
				Curso.cadastrarCurso(curso2);
				
				//criar ESTUDANTE
				Estudante estudante1 = new Estudante("João", 20, "12345");
		        Estudante estudante2 = new Estudante("Julia", 35, "14555");
		        //matricular ESTUDANTE
		        Estudante.cadastrarEstudante(estudante1);
		        Estudante.cadastrarEstudante(estudante2);
		        
		        //matricula aluno no curso
		        curso1.matricularEstudante(estudante1);
		        curso2.matricularEstudante(estudante2);
		        
		        // Editar o curso
		        //Curso.exibirTodosCursos();
		      //Curso.editarCurso("Programação", "Algoritmos", 80);
		        System.out.println("------------------------");
		        Estudante.exibirTodosEstudantes();
		        System.out.println("------------------------");
		        Professor.exibirTodosProfessores();
		        System.out.println("------------------------");
		      //Estudante.editarEstudante("João", "Juciene", 28);
		       //Curso.excluirCurso("Programação");
		       //System.out.println("------------------------");
		        Curso.exibirTodosCursos();
		    
		    }

	}


