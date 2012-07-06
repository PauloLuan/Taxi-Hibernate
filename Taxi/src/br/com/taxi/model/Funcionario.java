package br.com.taxi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "FUNCIONARIO", uniqueConstraints = { @UniqueConstraint(columnNames = "FUNC_ID") })
public class Funcionario {

	private int registro;
	private String nome;
	private String endereco;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String telefone;

	public Funcionario() {
	}

	public Funcionario(String nome) {
		this.nome = nome;
	}

	public Funcionario(int registro, String nome, String endereco,
			String bairro, String cidade, String estado, String cep,
			String telefone) {
		this.registro = registro;
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.telefone = telefone;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/* AutoIncrement */
	@Column(name = "FUNC_ID", nullable = false, unique = true, columnDefinition = "INTEGER(20)", length = 20)
	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	@Column(name = "FUNC_NOME", columnDefinition = "VARCHAR(200)")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "FUNC_ENDERECO", columnDefinition = "VARCHAR(200)")
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the numero
	 */
	@Column(name = "FUNC_NUMERO", columnDefinition = "VARCHAR(200)")
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the bairro
	 */
	@Column(name = "FUNC_BAIRRO", columnDefinition = "VARCHAR(200)")
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro
	 *            the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cidade
	 */
	@Column(name = "FUNC_CIDADE", columnDefinition = "VARCHAR(200)")
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade
	 *            the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the estado
	 */
	@Column(name = "FUNC_ESTADO", columnDefinition = "VARCHAR(200)")
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the cep
	 */
	@Column(name = "FUNC_CEP", columnDefinition = "VARCHAR(200)")
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep
	 *            the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "FUNC_TELEFONE", columnDefinition = "VARCHAR(200)")
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return getNome();
	}

}
