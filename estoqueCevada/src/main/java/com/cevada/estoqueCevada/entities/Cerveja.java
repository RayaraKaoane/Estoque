package com.cevada.estoqueCevada.entities;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_cerveja")
public class Cerveja {
	
	{/*byte
	short
	int
	long
	char
	float
	double
	boolean*/}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String sku;
	private String nome;
	private String origem;
	private String descricao;
	private float valor;
	private float teor_alcool;
	private boolean alcoolico;
	private int quantidade;
	private String foto;
	
	
	@ManyToOne
	@JoinColumn(name= "estilo_id")
	private Estilo estilo;
	
	@ManyToOne
	@JoinColumn(name= "marca_id")
	private Marca marca;
		
	@ManyToOne
	@JoinColumn(name= "Sabor_id")
	private Sabor Sabor;
	
	public Cerveja() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public String getorigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getTeor_alcool() {
		return teor_alcool;
	}

	public void setTeor_alcool(float teor_alcool) {
		this.teor_alcool = teor_alcool;
	}

	public boolean isAlcoolico() {
		return alcoolico;
	}

	public void setAlcoolico(boolean alcoolico) {
		this.alcoolico = alcoolico;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Sabor getSabor() {
		return Sabor;
	}

	public void setSabor(Sabor sabor) {
		Sabor = sabor;
	}


	

	

}
