package model;

import java.util.ArrayList;

public class Curso{
	int id_curso, periodos;
	String nome_curso, tipo_curso, descricao_curso;
	
	
	public Curso(int periodos, String nome_curso, String tipo_curso, String descricao_curso) {
		super();
		this.periodos = periodos;
		this.nome_curso = nome_curso;
		this.tipo_curso = tipo_curso;
		this.descricao_curso = descricao_curso;
	}
	
	public Curso() {

	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public int getPeriodos() {
		return periodos;
	}

	public void setPeriodos(int periodos) {
		this.periodos = periodos;
	}

	public String getNome_curso() {
		return nome_curso;
	}

	public void setNome_curso(String nome_curso) {
		this.nome_curso = nome_curso;
	}

	public String getTipo_curso() {
		return tipo_curso;
	}

	public void setTipo_curso(String tipo_curso) {
		this.tipo_curso = tipo_curso;
	}

	public String getDescricao_curso() {
		return descricao_curso;
	}

	public void setDescricao_curso(String descricao_curso) {
		this.descricao_curso = descricao_curso;
	}

	public void cadastrar(Curso curso) throws Exception{
		//new CursoDao().cadastrarCurso(curso);
	}	
	
	public void alterar() throws Exception{
		//new CursoDao().alterarCurso(curso);
	}	
	
	public void excluir(int cod) throws Exception{
		//new CursoDao().excluirCurso(cod);
	}	
	
	public void buscar(int cod) throws Exception{
		//new CursoDao().buscarCurso(cod)
	}
	public ArrayList<String> listarAtores() throws Exception{
		//return new CursoDao().listarCurso();
		return null;
	}
}