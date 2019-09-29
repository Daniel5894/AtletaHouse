package modelo;

import java.io.Serializable;
import java.math.BigDecimal;

public class produto implements Serializable 
{
	
	private static final long serialVersionUID = 1L;
	private int codProduto; //PK
	private String nome;
	private String desc;
	private BigDecimal val;
	private int estoque;
	
	private fornecedor _fornecedor; //FK
	
	public produto() 
	{
		
	}
	
	public produto(int codProduto, String nome, String desc, BigDecimal val, int estoque) 
	{
		super();
		this.codProduto = codProduto;
		this.nome = nome;
		this.desc = desc;
		this.val = val;
		this.estoque = estoque;
	}

//GETTERS AND SETTERS	
	
	public int getCodProduto() 
	{
		return codProduto;
	}

	public void setCodProduto(int codProduto) 
	{
		this.codProduto = codProduto;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getDesc() 
	{
		return desc;
	}

	public void setDesc(String desc) 
	{
		this.desc = desc;
	}

	public BigDecimal getVal() 
	{
		return val;
	}

	public void setVal(BigDecimal val) 
	{
		this.val = val;
	}

	public int getEstoque() 
	{
		return estoque;
	}

	public void setEstoque(int estoque) 
	{
		this.estoque = estoque;
	}

	public fornecedor get_fornecedor() 
	{
		return _fornecedor;
	}

	public void set_fornecedor(fornecedor _fornecedor) 
	{
		this._fornecedor = _fornecedor;
	}

	public static long getSerialversionuid() 
	{
		return serialVersionUID;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_fornecedor == null) ? 0 : _fornecedor.hashCode());
		result = prime * result + codProduto;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + estoque;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((val == null) ? 0 : val.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		produto other = (produto) obj;
		if (_fornecedor == null) {
			if (other._fornecedor != null)
				return false;
		} else if (!_fornecedor.equals(other._fornecedor))
			return false;
		if (codProduto != other.codProduto)
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (estoque != other.estoque)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (val == null) {
			if (other.val != null)
				return false;
		} else if (!val.equals(other.val))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "produto [codProduto =" + codProduto + ", nome =" + nome + ", desc =" + desc + ", val =" + val + ", estoque ="
				+ estoque + ", _fornecedor =" + _fornecedor + "]";
	}

	
    

	
}
