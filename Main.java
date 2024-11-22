package Sistema;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
	//	janelaPrincipal.setVisible(true);
		
		 // Cadastrando Professores
        Professor.cadastrarProfessor("Carlos Silva", 40, "Matemática");
        Professor.cadastrarProfessor("Ana Pereira", 35, "Física");

        // Cadastrando Estudantes
        Estudante.cadastrarEstudante("João Santos", 20, "2023001");
        Estudante.cadastrarEstudante("Maria Oliveira", 22, "2023002");

        // Exibindo todos os Professores e Estudantes
        System.out.println("\nLista de Professores:");
        Professor.exibirTodosEstudantes();
        System.out.println("\nLista de Estudantes:");
        Estudante.exibirTodosEstudantes();

        // Editando e exibindo novamente
        Professor.editarProfessor("Carlos Silva", "Carlos Alberto Silva", 41, "Matemática Avançada");
        Estudante.editarEstudante("João Santos", "João Pedro Santos", 21, "2023001-A");
        
        System.out.println("\nApós edição:");
        Professor.exibirTodosEstudantes();
        Estudante.exibirTodosEstudantes();

        // Excluindo e exibindo novamente
        Professor.excluirProfessor("Ana Pereira");
        Estudante.excluirEstudante("Maria Oliveira");

        System.out.println("\nApós exclusão:");
        Professor.exibirTodosEstudantes();
        Estudante.exibirTodosEstudantes();
	}

}
