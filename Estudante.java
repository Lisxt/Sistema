package sistema;

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
        for (Estudante estudante : estudantes) {
            estudante.exibirDados();
        }
    }
    

    // Método cadastrar estudante
    public static void cadastrarEstudante(String nome, int idade, String matricula) {
        Estudante novoEstudante = new Estudante(nome, idade, matricula);
        estudantes.add(novoEstudante);
        System.out.println("Estudante " + nome + " cadastrado com sucesso.");
    }

    // Método editar estudante
    public static void editarEstudante(String nome, String novoNome, int novaIdade, String novaMatricula) {
        for (Estudante estudante : estudantes) {
            if (estudante.getNome().equals(nome)) { // Ignora maiúsculas/minúsculas
                estudante.setNome(novoNome);
                estudante.setIdade(novaIdade);
                estudante.setMatricula(novaMatricula);
                System.out.println("Dados do estudante " + nome + " editados com sucesso.");
                return;
            }
        }
        System.out.println("Estudante com o nome " + nome + " não encontrado.");
    }

    // Método excluir estudante
    public static void excluirEstudante(String nome) {
        for (int i = 0; i < estudantes.size(); i++) {
            Estudante estudante = estudantes.get(i);
            if (estudante.getNome().equalsIgnoreCase(nome)) { // Ignora maiúsculas/minúsculas
                estudante.exclusao();
                estudantes.remove(i);
                System.out.println("Estudante " + nome + " excluído com sucesso.");
                return;
            }
        }
        System.out.println("Estudante com o nome " + nome + " não encontrado.");
    }
   // Método exclusão
        public void exclusao() {
            setNome(null);
            setIdade(0);
            setMatricula(null);
            System.out.println("Dados do estudante excluídos com sucesso!");
        }

}