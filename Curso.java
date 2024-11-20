package Sistema;

public class Curso {

	//ATRIBUTOS
	String NomeCurso;
	int cargaHoraria;
	String professor;
	
	//CONSTRUTOR
	public Curso(String nomeCurso, int cargaHoraria, String professor) {
		
		this.NomeCurso = nomeCurso;
		this.cargaHoraria = cargaHoraria;
		this.professor = professor;
	}
	
	//METODOS
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
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	
	
}
