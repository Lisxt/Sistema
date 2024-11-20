package Sistema;

public class Estudante extends Pessoa {
	//subclasse de pessoa
	
	//ATRIBUTOS
	String matricula;
	
	//CONSTRUTOR
	public Estudante(String nome, int idade, String matricula) {
		super(nome, idade);
		this.matricula = matricula;
	}
	
	//METODOS
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public void exibirDdos() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
