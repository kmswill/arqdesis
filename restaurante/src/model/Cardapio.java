package model;

import java.io.Serializable;

public class Cardapio implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nome, descr, valor;

	public Cardapio() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Cardapio [id=" + id + ", nome=" + nome + ", descr=" 
	+ descr + ", valor=" + valor + "]";
	}

}
