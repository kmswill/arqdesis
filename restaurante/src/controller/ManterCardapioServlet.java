package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cardapio;
import service.CardapioService;

@WebServlet("/ManterCardapio.do")
public class ManterCardapioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String descr = request.getParameter("descr");
		String valor = request.getParameter("valor");
		String acao = request.getParameter("acao");
		
		Cardapio cardapio = new Cardapio();
		cardapio.setNome(nome);
		cardapio.setDescr(descr);
		cardapio.setValor(valor);
		
		CardapioService service = new CardapioService();
		RequestDispatcher dispatcher = null;
		
		switch(acao){
		case "Incluir":
			int id = service.criar(cardapio);
			cardapio = service.carregar(id);
			
			request.setAttribute("cardapio", cardapio);
			
			dispatcher = request.getRequestDispatcher("Cardapio.jsp");
			break;
			
		case "Listar Todos":
			ArrayList<Cardapio> cardapios = service.listarTodos();
			
			request.setAttribute("cardapios", cardapios);
			
			dispatcher = request.getRequestDispatcher("ListarCardapio.jsp");
			break;
			
		
		}
		
		dispatcher.forward(request, response);
	}

}
