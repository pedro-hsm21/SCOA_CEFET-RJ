package controller;

import java.util.ArrayList;

import model.Endereco;

public class EnderecoController {
	public boolean cadastrarEndereco(int id_usuario, String uf, String cidade, String bairro, String rua, int numero, String complemento) throws Exception{		
		if (id_usuario > 0 && uf != null && uf.length() > 0 && cidade != null && cidade.length() > 0 && rua != null && rua.length() > 0 &&
				numero > 0 && complemento != null && complemento.length() > 0){
			Endereco endereco = new Endereco(id_usuario, uf, cidade, bairro, rua, numero, complemento);
			endereco.cadastrar(endereco);
			return true;
		} 
			return false;
	}	
	
public boolean alterarEndereco(int id, int id_usuario, String uf, String cidade, String bairro, String rua, int numero, String complemento) throws Exception{
		
		if (id > 0 && id_usuario > 0 && uf != null && uf.length() > 0 && cidade != null && cidade.length() > 0 && rua != null && rua.length() > 0 &&
				numero > 0 && complemento != null && complemento.length() > 0){
			Endereco endereco = new Endereco(id_usuario, uf, cidade, bairro, rua, numero, complemento);
			endereco.alterar(endereco);
			return true;
		} 
			return false;
	}
	
	public boolean excluirEndereco(int cod) throws Exception {
		
		if (cod == 0){
			return false;
		}
		
		new Endereco().excluir(cod);
			return true;
	}
	
	public ArrayList<String> listarEnderecos() throws Exception{
		//return new Endereco().listarEnderecos();
		return null;
	}
}
