package model;

import java.util.ArrayList;

import dao.Plano_EstudosDao;

public class Plano_Estudos{
	int idplano_estudos, periodo, id_aluno, id_disciplina;
	Disciplina disciplina;

	public Plano_Estudos(int periodo, int id_aluno, int id_disciplina) {
		super();
		this.periodo = periodo;
		this.id_aluno = id_aluno;
		this.id_disciplina = id_disciplina;
	}
	
	public Plano_Estudos() {

	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public int getIdplano_estudos() {
		return idplano_estudos;
	}

	public void setIdplano_estudos(int idplano_estudos) {
		this.idplano_estudos = idplano_estudos;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(int id_aluno) {
		this.id_aluno = id_aluno;
	}

	public int getId_disciplina() {
		return id_disciplina;
	}

	public void setId_disciplina(int id_disciplina) {
		this.id_disciplina = id_disciplina;
	}

	public void cadastrar(Plano_Estudos planos_estudos) throws Exception{
		new Plano_EstudosDao().cadastrarPlano_Estudos(planos_estudos);
	}	
	
	public void alterar(Plano_Estudos planos_estudos) throws Exception{
		new Plano_EstudosDao().alterarPlano_Estudos(planos_estudos);
	}	
	
	public void excluir(int cod) throws Exception{
		new Plano_EstudosDao().excluirPlano_Estudos(cod);
	}	
	
	public Plano_Estudos buscar(int cod) throws Exception{
		return new Plano_EstudosDao().buscarPlano_Estudoss(cod);
	}
	
	public ArrayList<Plano_Estudos> listar() throws Exception{
		return new Plano_EstudosDao().listarPlano_Estudoss();
	}
	
	public ArrayList<Plano_Estudos> listar(int idaluno) throws Exception{
		return new Plano_EstudosDao().listarPlano_Estudoss(idaluno);
	}
	
	}