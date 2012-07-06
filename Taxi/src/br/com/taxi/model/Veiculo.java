package br.com.taxi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEICULO")
public class Veiculo {

	private int idVeiculo;
	private String tipo;
	private String marca;
	private int ano;
	private String placa;
	private String cor;

	public Veiculo() {
	}

	public Veiculo(String marca) {
		this.marca = marca;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VEIC_ID", nullable = false, unique = true, columnDefinition = "INTEGER(20)")
	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	@Column(name = "VEIC_TIPO", columnDefinition = "VARCHAR(200)")
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name = "VEIC_MARCA", columnDefinition = "VARCHAR(200)")
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Column(name = "VEIC_ANO", columnDefinition = "INTEGER(5)")
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Column(name = "VEIC_PLACA", columnDefinition = "VARCHAR(200)")
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Column(name = "VEIC_COR", columnDefinition = "VARCHAR(200)")
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return getMarca();
	}

}
