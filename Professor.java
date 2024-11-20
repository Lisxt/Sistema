package Sistema;

public class Professor extends Pessoa{
	//subclasse de pessoa
	
	//ATRIBUTOS
	String especialidade;
	
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
	public void exibirDdos() {
		// TODO Auto-generated method stub
		
	}

	
	
}
