package model; 
public abstract class Pessoa { // Define a classe abstrata 'Pessoa', que será a classe base para outras classes como Estudante, Professor e etc.
    
    // Atributos privados de instância que armazenam dados comuns entre todas as pessoas.
    private int id; 
    private String nome; 
    private int idade;

    // Construtor padrão (sem parâmetros), necessário para algumas operações como serialização ou frameworks que necessitam de um construtor sem argumentos.
    public Pessoa() {}

    // Construtor com parâmetros, que inicializa os atributos 'nome' e 'idade' da pessoa.
    public Pessoa(String nome, int idade) {
        this.nome = nome;  
        this.idade = idade; 
    }

    // Getteres e Setteres
    public int getId() {
        return id;  
    }

    public void setId(int id) {
        this.id = id;  
    }

   
    public String getNome() {
        return nome;  
    }

    public void setNome(String nome) {
        this.nome = nome;  

    public int getIdade() {
        return idade;  
    }

    public void setIdade(int idade) {
        this.idade = idade; 
    }

    // Método abstrato que deve ser implementado por classes filhas. 
    // Cada tipo de 'Pessoa' (Estudante, Professor, etc.) deve definir como exibir seus dados.
    public abstract void exibirdados(); 
}
