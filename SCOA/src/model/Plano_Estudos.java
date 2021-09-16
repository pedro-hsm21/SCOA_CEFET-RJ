package model;

import java.util.ArrayList;

public class Plano_Estudos{
	int idplano_estudos, periodo, id_aluno, id_disciplina;

	public Plano_Estudos(int idplano_estudos, int periodo, int id_aluno, int id_disciplina) {
		super();
		this.idplano_estudos = idplano_estudos;
		this.periodo = periodo;
		this.id_aluno = id_aluno;
		this.id_disciplina = id_disciplina;
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