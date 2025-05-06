package com.perritotoystore.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Brinquedo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int codigo;
	private String descricao;
	private String categoria;
	private String marca;
	
	
	@Lob
    //@Column(columnDefinition = "text")
	private byte[] img;
	private String imgType;
	
	private double valor;
	private String detalhes;
	
	public Brinquedo() {
	}

	public Brinquedo(int codigo, String descricao, String categoria, String marca, byte[] img, double valor,
			String detalhes) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.categoria = categoria;
		this.marca = marca;
		this.img = img;
		this.valor = valor;
		this.detalhes = detalhes;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	
	public String[] getListaCategoria() {
	    String[] categorias = {
	        "Jogos Eletrônicos",
	        "Jogos Infantis",
	        "Pelucias"
	    };
	    return categorias;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}
}
