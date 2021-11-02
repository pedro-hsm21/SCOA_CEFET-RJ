package controller;

import java.util.ArrayList;

import model.Chamados;

public class ChamadosController {
	public boolean cadastrarChamado(int id_usuario, String titulo, String mensagem, String tipo_chamado) throws Exception{		
		if (id_usuario > 0 && titulo != null && titulo.length() > 0 && mensagem != null && mensagem.length() > 0 && tipo_chamado != null && tipo_chamado.length() > 0){
			Chamados chamado = new Chamados(id_usuario, titulo, mensagem, tipo_chamado, 0, "");
			chamado.cadastrar(chamado);
			return true;
		} 
			return false;
	}	
	
public boolean alterarChamados(int id, int id_usuario, String titulo, String mensagem, String tipo_chamado, int status, String solucao) throws Exception{
		
		if (id > 0 && id_usuario > 0 && titulo != null && titulo.length() > 0 && mensagem != null && mensagem.length() > 0 && tipo_chamado != null && tipo_chamado.length() > 0){
			Chamados chamado = new Chamados(id_usuario, titulo, mensagem, tipo_chamado, status, solucao);
			chamado.setIdchamado(id);
			chamado.alterar(chamado);
			return true;
		} 
			return false;
	}
	
	public boolean excluirChamados(int cod) throws Exception {
		
		if (cod == 0){
			return false;
		}
		
		new Chamados().excluir(cod);
		return true;
	}
	
	public ArrayList<Chamados> listarChamados(int id, int idUser) throws Exception{
		return new Chamados().listarChamados(id, idUser);
		
	}
}
