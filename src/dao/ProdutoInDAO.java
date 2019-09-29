package dao;

import java.sql.SQLException;
import java.util.List;

import modelo.produto;

public interface ProdutoInDAO 
{
	
  void Inserir(produto _o) throws SQLException;
	
	Boolean Alterar(produto _o) throws SQLException;
	
	Boolean Excluir(produto _o) throws SQLException;
	
	produto BuscarPorID(int _id) throws SQLException;
	
	List<produto> Listar() throws SQLException;

}