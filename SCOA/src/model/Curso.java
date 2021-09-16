package model;

import java.util.ArrayList;

public class Curso{
	int id_curso, periodos;
	String nome_curso, tipo_curso, descricao_curso;
	
	
	public Curso(int id_curso, int periodos, String nome_curso, String tipo_curso, String descricao_curso) {
		super();
		this.id_curso = id_curso;
		this.periodos = periodos;
		this.nome_curso = nome_curso;
		this.tipo_curso = tipo_curso;
		this.descricao_curso = descricao_curso;
	}
	
	public void cadastrar() throws Exception{
		//new Dao().cadastrar(obj);
	}	
	
	public void alterar() throws Exception{
		//new Dao().alterar(obj);
	}	
	
	public void excluir(int cod) throws Exception{
		//new Dao().excluir(cod);
	}	
	
	public void buscar(int cod) throws Exception{
		//new Dao().buscar(cod)
	}
	public ArrayList<String> listarAtores() throws Exception{
		//return new Dao().listar();
		return null;
	}
}