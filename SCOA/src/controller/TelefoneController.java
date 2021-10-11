package controller;

import java.util.ArrayList;

import model.Telefone;

public class TelefoneController {
	public boolean cadastrarTelefone(int id_usuario, String tipo_telefone, String numero_telefone) throws Exception{		
		if (id_usuario > 0 && tipo_telefone != null && tipo_telefone.length() > 0 && numero_telefone != null && numero_telefone.length() > 0){
			Telefone telefone = new Telefone(id_usuario, tipo_telefone, numero_telefone);
			telefone.cadastrar(telefone);
			return true;
		} 
			return false;
	}	
	
public boolean alterarTelefone(int id, int id_usuario, String tipo_telefone, String numero_telefone) throws Exception{
		
		if (id > 0 && id_usuario > 0 && tipo_telefone != null && tipo_telefone.length() > 0 && numero_telefone != null && numero_telefone.length() > 0){
			Telefone telefone = new Telefone(id_usuario, tipo_telefone, numero_telefone);
			telefone.alterar(telefone);
			return true;
		} 
			return false;
	}
	
	public boolean excluirTelefone(int cod) throws Exception {
		
		if (cod == 0){
			return false;
		}
		
		new Telefone().excluir(cod);
			return true;
	}
	
	public ArrayList<String> listarTelefones() throws Exception{
		//return new Telefone().listarTelefones();
		return null;
	}
}
