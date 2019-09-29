package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.fornecedor;

public class FornecedorDAO {

	private Connection conexao;
	
	public FornecedorDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	public void Inserir(fornecedor _o) throws SQLException {
		
		String SQL = "INSERT INTO _estilista (cnpj, nome, end, tel, email) VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _o.getCnpj());
		ps.setString(2, _o.getNome());
		ps.setString(3, _o.getEnd());
		ps.setInt(4, _o.getTel());
		ps.setString(5, _o.getEmail());
		
		ps.execute();

	}
	
	public Boolean Alterar(fornecedor _o) throws SQLException {

		String SQL = "UPDATE _estilista SET cnpj = ?, nome = ?, end = ?, tel = ?, email = ? WHERE cnpj = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _o.getCnpj());
		ps.setString(2, _o.getNome());
		ps.setString(3, _o.getEnd());
		ps.setInt(4, _o.getTel());
		ps.setString(5, _o.getEmail());
		
		return ps.execute();
	}
	
	public Boolean Excluir(fornecedor _o) throws SQLException {

		String SQL = "DELETE FROM _estilista WHERE cnpj = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _o.getCnpj());
		
		return ps.execute();
	}

	public fornecedor BuscarPorCnpj(int _cnpj) throws SQLException {
		
		String SQL = "SELECT cnpj, nome, end, tel, email FROM _estilista WHERE cnpj = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _cnpj);
		
		ResultSet rs = ps.executeQuery();
		
		fornecedor f = null;
		
		if(rs.next()) {
			f = new fornecedor();
			
			f.setCnpj(rs.getInt(1));
			f.setNome(rs.getString(2));
			f.setEnd(rs.getString(3));
			f.setTel(rs.getInt(4));
			f.setEmail(rs.getString(5));
		}
		
		return f;
	}

	public List<fornecedor> Listar() throws SQLException {
		
		String SQL = "SELECT * FROM _estilista";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		List<fornecedor> fornecedores = new ArrayList<fornecedor>();
		ResultSet rs = ps.executeQuery();
		
		fornecedor f = null;
		
		while(rs.next()) {
			f = new fornecedor();
			
			f.setCnpj(rs.getInt(1));
			f.setNome(rs.getString(2));
			f.setEnd(rs.getString(3));
			f.setTel(rs.getInt(4));
			f.setEmail(rs.getString(5));
			
			fornecedores.add(f);
		}
	
		return fornecedores;
	}


}
