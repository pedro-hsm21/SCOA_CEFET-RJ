package controller;

import java.util.ArrayList;


import model.NotaAvaliacao;

public class NotasController {

	public boolean alterarNota(int idNA, int idAv, int idMT, float nota) throws Exception{
		
		if (idNA > 0 &&  idAv > 0 && idMT  > 0 && nota  > 0 ){
			NotaAvaliacao notaAv = new NotaAvaliacao(idNA, idAv, idMT, nota);
			notaAv.alterar(notaAv);
			return true;
		} 
			return false;
	}
	
	public ArrayList<NotaAvaliacao> listarNotas(int idAv) throws Exception{
		return new NotaAvaliacao().listar(idAv);
		
	}
}
