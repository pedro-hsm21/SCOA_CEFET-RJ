package model;

import java.sql.Date;
import java.util.ArrayList;

import dao.Curso_AlunoDao;

public class Curso_Aluno{

	
	

	int id_curso_aluno, id_curso, id_aluno, status_matricula; 
	String matricula; Date data_fim;
	
	public Curso_Aluno(int id_curso, int id_aluno, String matricula, int status_matricula, Date data_fim) {
		super();
		this.id_curso = id_curso;
		this.id_aluno = id_aluno;
		this.matricula = matricula;
		this.status_matricula = status_matricula;
		this.data_fim = data_fim;
	}

	public Curso_Aluno() {

	}
	
	

	public int getId_curso_aluno() {
		return id_curso_aluno;
	}

	public void setId_curso_aluno(int id_curso_aluno) {
		this.id_curso_aluno = id_curso_aluno;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public int getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(int id_aluno) {
		this.id_aluno = id_aluno;
	}

	public int getStatus_matricula() {
		return status_matricula;
	}

	public void setStatus_matricula(int status_matricula) {
		this.status_matricula = status_matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	public void cadastrar(Curso_Aluno curso_aluno) throws Exception{
		new Curso_AlunoDao().cadastrarcurso_aluno(curso_aluno);
	}	
	
	public void alterar(Curso_Aluno curso_aluno) throws Exception{
		new Curso_AlunoDao().alterarcurso_aluno(curso_aluno);
	}
	
	public void excluir(int cod) throws Exception{
		new Curso_AlunoDao().excluircurso_aluno(cod);
	}	
	
	public void buscar(int cod) throws Exception{
		//new AlunoTurmaDao().buscarAlunoTurma(cod)
	}
	public ArrayList<Curso_Aluno> listar(int id) throws Exception{
		return new Curso_AlunoDao().listarcurso_alunos(id);
		
	}
	}