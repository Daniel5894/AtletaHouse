package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.produto;

public class ProdutoDAO {
	
	private Connection conexao;
	
	public ProdutoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	public void Inserir(produto _o) throws SQLException {
		
		String SQL = "INSERT INTO _produto (codProduto, nome, desc, val, estoque) VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _o.getCodProduto());
		ps.setString(2, _o.getNome());
		ps.setString(3, _o.getDesc());
		ps.setBigDecimal(4, _o.getVal());
		ps.setInt(5, _o.getEstoque());
		
		ps.execute();

	}
	public Boolean Alterar(produto _o) throws SQLException {

		String SQL = "UPDATE _vestido SET codVestido = ?, nome = ?, desc = ?, tam = ?, val = ?, estoque = ? WHERE codVestido = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _o.getCodProduto());
		ps.setString(2, _o.getNome());
		ps.setString(3, _o.getDesc());
		ps.setBigDecimal(4, _o.getVal());
		ps.setInt(5, _o.getEstoque());
		
		return ps.execute();
	}
	
	public Boolean Excluir(produto _o) throws SQLException 
	{

		String SQL = "DELETE FROM _produto WHERE codProduto = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _o.getCodProduto());
		
		return ps.execute();
	}
	
	public produto BuscarPorCodProduto(int _codProduto) throws SQLException {
		
		String SQL = "SELECT codCli, tipo FROM _produto WHERE codCli = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _codProduto);
		
		ResultSet rs = ps.executeQuery();
		
		produto p = null;
		
		if(rs.next()) {
			p = new produto();
			
			p.setCodProduto(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setDesc(rs.getString(3));
			p.setVal(rs.getBigDecimal(4));
			p.setEstoque(rs.getInt(5));

		}
		
		return p;
	}

	public List<produto> Listar() throws SQLException {

		String SQL = "SELECT * FROM produto";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		List<produto> produtos = new ArrayList<produto>();
		ResultSet rs = ps.executeQuery();
		
		produto p = null;
		
		while(rs.next()) 
		{
			p = new produto();
			
			p.setCodProduto(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setDesc(rs.getString(3));
			p.setVal(rs.getBigDecimal(4));
			p.setEstoque(rs.getInt(5));
			
			produtos.add(p);
		}
		
		return produtos;
	}


}