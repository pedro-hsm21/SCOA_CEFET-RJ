package model;

import java.sql.Date;
import java.util.ArrayList;

import dao.MetasDao;

public class Metas {
	int idMeta, idProf, tipo, status;
	Date dataInicio, dataFim;
	String titulo, descricao;
	Usuario user;


	public Metas( int prof, int tipo, int status, Date inicio, Date fim, String titulo, String descr){		
		this.idProf = prof;
		this.tipo = tipo;
		this.status = status;
		this.dataInicio = inicio;
		this.dataFim = fim;
		this.titulo = titulo;
		this.descricao = descr;
	}
	
	public Metas(){
		super();
	}

	public int getIdMeta() {
		return idMeta;
	}

	public void setIdMeta(int idMeta) {
		this.idMeta = idMeta;
	}

	public int getIdProf() {
		return idProf;
	}

	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	
	public void cadastrar(Metas meta) throws Exception {
		new MetasDao().cadastrarMetas(meta);
	}

	public void alterar(Metas meta) throws Exception {
		new MetasDao().alterarMetas(meta);
	}

	public void excluir(int cod) throws Exception {
		new MetasDao().excluirMetas(cod);
	}

	public Metas buscar(int cod) throws Exception {
		return new MetasDao().buscarMetas(cod);
	}

	public ArrayList<Metas> listarMetas(int id) throws Exception {
		return new MetasDao().listarMetas(id);
	}

}
