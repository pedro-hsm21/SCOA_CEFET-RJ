package model;

import java.util.ArrayList;

import controller.AlunoController;
import controller.Curso_AlunoController;
import controller.UsuarioController;
import dao.MatriculaTurmaDao;

public class MatriculaTurma {
	int idMatriculaTurma, idTurma, idCursoAluno, statusAluno;
	float media, frequencia;
	Turma turma; Usuario user;
	
	public MatriculaTurma(int idTurma, int idCursoAluno) {
		super();
		this.idTurma = idTurma;
		this.idCursoAluno = idCursoAluno;
	}
	public MatriculaTurma() {

	}
	
	
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public int getIdMatriculaTurma() {
		return idMatriculaTurma;
	}
	
	public void setIdMatriculaTurma(int idMatriculaTurma) {
		this.idMatriculaTurma = idMatriculaTurma;
	}
	
	public int getIdTurma() {
		return idTurma;
	}
	
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	
	public int getIdCursoAluno() {
		return idCursoAluno;
	}
	
	public void setIdCursoAluno(int idCursoAluno) {
		this.idCursoAluno = idCursoAluno;
	}
	
	public int getStatusAluno() {
		return statusAluno;
	}
	
	public void setStatusAluno(int statusAluno) {
		this.statusAluno = statusAluno;
	}
	
	public float getMedia() {
		return media;
	}
	
	public void setMedia(float media) {
		this.media = media;
	}
	
	public float getFrequencia() {
		return frequencia;
	}
	
	public void setFrequencia(float frequencia) {
		this.frequencia = frequencia;
	}
	
	public void cadastrar(MatriculaTurma matriculaturma) throws Exception {
		new MatriculaTurmaDao().cadastrarMatriculaTurma(matriculaturma);
	}

	public void alterar(MatriculaTurma matriculaturma) throws Exception {
		new MatriculaTurmaDao().alterarMatriculaTurma(matriculaturma);
	}

	public void excluir(int id) throws Exception {
		new MatriculaTurmaDao().excluirMatriculaTurma(id);
	}

	public MatriculaTurma buscar(int idturma, int idCursoAluno) throws Exception {
		return new MatriculaTurmaDao().buscarMatriculaTurma(idTurma, idCursoAluno);
	}

	public ArrayList<MatriculaTurma> listar(int idturma) throws Exception {
		return new MatriculaTurmaDao().listarMatriculaTurmas(idturma);
	}
	
	public ArrayList<MatriculaTurma> listarT(int idCursoAluno) throws Exception {
		return new MatriculaTurmaDao().listarMatriculaTurmasT(idCursoAluno);
	}
	
	public ArrayList<MatriculaTurma> listar() throws Exception {
		return new MatriculaTurmaDao().listarMatriculaTurmas();
	}
	
	/*public String toString(){
		int idaluno = 0;
		int idusuario = 0;
		String matricula = null;
		String nomeUsuario = null;
		try {
			matricula = new Curso_AlunoController().buscarCurso_Aluno(getIdCursoAluno()).getMatricula();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			idaluno = new Curso_AlunoController().buscarCurso_Aluno(getIdCursoAluno()).getId_aluno();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			idusuario = new AlunoController().buscarAluno(idaluno).getId_usuario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			nomeUsuario = new UsuarioController().buscarUsuario(idusuario).getNome_usuario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nomeUsuario + " - " + matricula;
	}*/
	
}