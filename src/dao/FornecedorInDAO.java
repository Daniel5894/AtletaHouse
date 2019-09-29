package dao;

import java.sql.SQLException;
import java.util.List;

import modelo.fornecedor;

public interface FornecedorInDAO
{
void Inserir(fornecedor _o) throws SQLException;
	
	Boolean Alterar(fornecedor _o) throws SQLException;
	
	Boolean Excluir(fornecedor _o) throws SQLException;
	
	fornecedor BuscarPorID(int _id) throws SQLException;
	
	List<fornecedor> Listar() throws SQLException;

}
