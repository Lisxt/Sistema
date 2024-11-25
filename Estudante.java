package Pessoas;

import java.util.ArrayList;
import java.util.List;

public class Estudante extends Pessoa {
	
    private String matricula;
    
    private static List<Estudante> estudantes = new ArrayList<>(); // Lista estática de estudantes

    // Construtor
    public Estudante(String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    // Get e Set
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    @Override
    // Método para exibir dados do estudante
    public void exibirDados() {
        System.out.println("Nome: " + getNome() + 
        "\nIdade: " + getIdade() + "\nMatrícula: " + getMatricula());
     
    }
    
    // Método para exibir todos os estudantes
   public static void exibirTodosEstudantes() {
        for (Estudante est : estudantes) {
            est.exibirDados();
        }
    }
    

    // Método cadastrar estudante
    public static void cadastrarEstudante(Estudante estudante) {
        estudantes.add(estudante);
        System.out.println("Estudante cadastrado com sucesso.");
    }

    // Método editar estudante
    public static void editarEstudante(String nome, String novoNome, int novaIdade) {
        for (Estudante est : estudantes) {
            if (est.getNome().equals(nome)) {
                est.setNome(novoNome);
                est.setIdade(novaIdade);
                System.out.println("Dados do estudante " + nome + " foram editados.");
                return;
            }
        }
        System.out.println("Estudante " + nome + " não foi encontrado.");
    }

    // Método excluir estudante
    public static void excluirEstudante(String nome) {
        for (Estudante est : estudantes) {
            if (est.getNome().equals(nome)) {
                est.exclusao();
                estudantes.remove(est);
                System.out.println("Estudante " + nome + " foi excluído.");
                return;
            }
        }
        System.out.println("Estudante " + nome + " não foi encontrado.");
    }
   // Método exclusão
        public void exclusao() {
            setNome(null); setIdade(0); setMatricula(null);
            System.out.println("Dados do estudante foram excluídos com sucesso!");
        }

