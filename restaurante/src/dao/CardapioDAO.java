package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cardapio;

public class CardapioDAO {
	public int criar(Cardapio cardapio) {
		String sqlInsert = "INSERT INTO cardapio(nome, descr, valor) VALUES (?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, cardapio.getNome());
			stm.setString(2, cardapio.getDescr());
			stm.setString(3, cardapio.getValor());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					cardapio.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cardapio.getId();
	}
	
	public void atualizar(Cardapio cardapio)
	{
		String sqlUpdate = "UPDATE cardapio SET nome=?, descr=?, valor=? WHERE id=?";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			stm.setString(1, cardapio.getNome());
			stm.setString(2, cardapio.getDescr());
			stm.setString(3, cardapio.getValor());
			stm.setInt(4, cardapio.getId());
			stm.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void excluir(int id)
	{
		String sqlDelete = "DELETE FROM cardapio WHERE id=?";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1, id);
			stm.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Cardapio carregar(int id)
	{
		Cardapio cardapio = new Cardapio();
		cardapio.setId(id);
		String sqlSelect = "SELECT nome, descr, valor FROM cardapio WHERE cardapio.id = ?";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, cardapio.getId());
			try(ResultSet rs = stm.executeQuery();){
				if(rs.next()){
					cardapio.setNome(rs.getString("nome"));
					cardapio.setDescr(rs.getString("descr"));
					cardapio.setValor(rs.getString("valor"));
				}else{
					cardapio.setId(-1);
					cardapio.setNome(null);
					cardapio.setDescr(null);
					cardapio.setValor(null);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}catch(SQLException e1){
			System.out.print(e1.getStackTrace());
		}
			return cardapio;
	}
	
	public ArrayList<Cardapio> listarTodos(){
		ArrayList<Cardapio> cardapios = new ArrayList<>();
		
		Cardapio cardapio;
		
		String sqlSelect = "SELECT id, nome, descr, valor FROM cardapio";
		
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);
				
				ResultSet rs = stm.executeQuery();){
			while(rs.next())
			{
				cardapio = new Cardapio();
				cardapio.setId(rs.getInt("id"));
				cardapio.setNome(rs.getString("nome"));
				cardapio.setDescr(rs.getString("descr"));
				cardapio.setValor(rs.getString("valor"));
				
				cardapios.add(cardapio);
			}
		} catch(SQLException e1){
			System.out.print(e1.getStackTrace());
		}
		
		return cardapios;
	}
}
