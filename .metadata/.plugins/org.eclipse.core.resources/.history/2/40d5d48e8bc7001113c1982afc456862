package br.com.taxi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OCORRENCIA")
public class Ocorrencia {

	private int id;
	private String descricao;
	private Funcionario funcionario;
	private Veiculo veiculo;
	private String dataCriacao;
	private String dataDevolucao;
	private String kmInicial;
	private String kmFinal;
	private boolean devolvido = false;

	public Ocorrencia() {
	}

	public Ocorrencia(Funcionario func, Veiculo veic) {
		this.funcionario = func;
		this.veiculo = veic;
	}

	public Ocorrencia(Funcionario func, Veiculo veic, String data_criacao,
			String data_devolucao) {
		this.funcionario = func;
		this.veiculo = veic;
		this.dataCriacao = data_criacao;
		this.dataDevolucao = data_devolucao;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/* AutoIncrement */
	@Column(name = "OCOR_ID", nullable = false, unique = true, columnDefinition = "INTEGER(20)")
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the descricao
	 */
	@Column(name = "OCOR_DESCRICAO", columnDefinition = "VARCHAR(200)")
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@ManyToOne
	@JoinColumn(name = "FUNC_ID", referencedColumnName = "FUNC_ID")
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the veiculo
	 */
	@ManyToOne
	@JoinColumn(name = "VEIC_ID", referencedColumnName = "VEIC_ID")
	public Veiculo getVeiculo() {
		return veiculo;
	}

	/**
	 * @param veiculo
	 *            the veiculo to set
	 */
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	@Column(name = "DATA_CRIACAO", columnDefinition = "VARCHAR(200)")
	public String getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(String data) {
		this.dataCriacao = data;
	}

	/**
	 * @return the dataDevolucao
	 */
	@Column(name = "DATA_DEVOLUCAO", columnDefinition = "VARCHAR(200)")
	public String getDataDevolucao() {
		return dataDevolucao;
	}

	/**
	 * @param dataDevolucao
	 *            the dataDevolucao to set
	 */
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	/**
	 * @return the kmInicial
	 */
	@Column(name = "OCOR_KMINICIAL", columnDefinition = "VARCHAR(200)")
	public String getKmInicial() {
		return kmInicial;
	}

	/**
	 * @param kmInicial
	 *            the kmInicial to set
	 */
	public void setKmInicial(String kmInicial) {
		this.kmInicial = kmInicial;
	}

	/**
	 * @return the kmFinal
	 */
	@Column(name = "OCOR_KMFINAL", columnDefinition = "VARCHAR(200)")
	public String getKmFinal() {
		return kmFinal;
	}

	/**
	 * @param kmFinal
	 *            the kmFinal to set
	 */
	public void setKmFinal(String kmFinal) {
		this.kmFinal = kmFinal;
	}

	/**
	 * @return the devolvido
	 */
	@Column(name = "IS_DEVOLVIDO", columnDefinition = "BOOLEAN")
	public boolean isDevolvido() {
		return devolvido;
	}

	/**
	 * @param devolvido
	 *            the devolvido to set
	 */
	public void setDevolvido(boolean devolvido) {
		this.devolvido = devolvido;
	}

}
