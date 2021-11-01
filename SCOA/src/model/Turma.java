package model;

import java.sql.Time;
import java.util.ArrayList;

import dao.TurmaDao;

public class Turma {
	int idTurma, periodo, numAlunos, numAulas, idProfessor, idSala, idGradeDisciplina;
	String nome, turno;
	Time horaInicio, horaFim;

	public Turma(int periodo, int numAlunos, int numAulas, int idProfessor, int idSala, int idGradeDisciplina,
			String nome, String turno, Time horaInicio, Time horaFim) {
		super();
		this.periodo = periodo;
		this.numAlunos = numAlunos;
		this.numAulas = numAulas;
		this.idProfessor = idProfessor;
		this.idSala = idSala;
		this.idGradeDisciplina = idGradeDisciplina;
		this.nome = nome;
		this.turno = turno;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}

	public Turma() {

	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getNumAlunos() {
		return numAlunos;
	}

	public void setNumAlunos(int numAlunos) {
		this.numAlunos = numAlunos;
	}

	public int getNumAulas() {
		return numAulas;
	}

	public void setNumAulas(int numAulas) {
		this.numAulas = numAulas;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public int getIdGradeDisciplina() {
		return idGradeDisciplina;
	}

	public void setIdGradeDisciplina(int idGradeDisciplina) {
		this.idGradeDisciplina = idGradeDisciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Time horaFim) {
		this.horaFim = horaFim;
	}

	public void cadastrar(Turma turma) throws Exception {
		new TurmaDao().cadastrarTurma(turma);
	}

	public void alterar(Turma turma) throws Exception {
		new TurmaDao().alterarTurma(turma);
	}

	public void excluir(int cod) throws Exception {
		new TurmaDao().excluirTurma(cod);
	}

	public Turma buscar(int cod) throws Exception {
		return new TurmaDao().buscarTurma(cod);
	}

	public ArrayList<Turma> listarTurmas() throws Exception {
		return new TurmaDao().listarTurmas();
	}
	
	public ArrayList<Turma> listarTurmas(int idprofessor) throws Exception {
		return new TurmaDao().listarTurmas(idprofessor);
	}
	
	public String toString(){
		return getNome();
	}

}