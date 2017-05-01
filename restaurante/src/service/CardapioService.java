package service;

import java.util.ArrayList;

import dao.CardapioDAO;
import model.Cardapio;

public class CardapioService {
	CardapioDAO dao = new CardapioDAO();
	
	public int criar(Cardapio cardapio)
	{
		return dao.criar(cardapio);
	}
	
	public void atualizar(Cardapio cardapio)
	{
		dao.atualizar(cardapio);
	}
	
	public void excluir(int id)
	{
		dao.excluir(id);
	}
	
	public Cardapio carregar(int id)
	{
		return dao.carregar(id);
	}
	
	public ArrayList<Cardapio> listarTodos()
	{
		return dao.listarTodos();
	}
	
	
}
