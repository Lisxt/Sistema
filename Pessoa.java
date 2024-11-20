package Sistema;

public abstract class Pessoa{

	//classe abastrata, super classe
	
	
	//ATRIBUTOS
	String nome;
	int idade;
	
	//CONSTRUTOR
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	//METODOS
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public abstract void exibirDados();
	
	
	
}
