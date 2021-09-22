package model;

import java.util.ArrayList;

public class Endereco{
	int id_endereco, id_usuario;
	String uf, cidade, bairro, rua;
	
	public Endereco(int id_endereco, int id_usuario, String uf, String cidade, String bairro, String rua) {
		super();
		this.id_endereco = id_endereco;
		this.id_usuario = id_usuario;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
	}
	
	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void cadastrar(Endereco endereco) throws Exception{
		//new EnderecoDao().cadastrarEndereco(endereco);
	}	
	
	public void alterar() throws Exception{
		//new EnderecoDao().alterarEndereco(obenderecoj);
	}	
	
	public void excluir(int cod) throws Exception{
		//new EnderecoDao().excluirEndereco(cod);
	}	
	
	public void buscar(int cod) throws Exception{
		//new EnderecoDao().buscarEndereco(cod)
	}
	public ArrayList<String> listarAtores() throws Exception{
		//return new EnderecoDao().listarEndereco();
		return null;
	}
	}