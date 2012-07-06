package br.com.taxi.controller;

import java.util.List;
import java.util.Vector;

import br.com.taxi.model.Funcionario;
import br.com.taxi.model.Ocorrencia;
import br.com.taxi.model.Veiculo;
import br.com.taxi.model.dao.FuncionarioDAO;
import br.com.taxi.model.dao.OcorrenciaDAO;
import br.com.taxi.model.dao.VeiculoDAO;
import br.com.taxi.view.View;

public class OcorrenciaController {

	private View view;

	public OcorrenciaController(View view) {
		this.view = view;
	}

	public boolean salvarAluguel() {
		boolean salvou = false;
		try {
			Ocorrencia ocorrencia = new Ocorrencia();
			OcorrenciaDAO dao = new OcorrenciaDAO();

			ocorrencia.setDescricao(view.txtDescricao.getText());
			ocorrencia.setFuncionario((Funcionario) view.cbxFuncionarioAluguel.getSelectedItem());
			ocorrencia.setVeiculo((Veiculo) view.cbxVeiculoAluguel.getSelectedItem());
			ocorrencia.setDataCriacao(view.txtDataAluguel.getText());
			ocorrencia.setDataDevolucao(view.txtDataEntrega.getText());
			ocorrencia.setKmInicial(view.txtKmInicial.getText());

			dao.SalvarOcorrencia(ocorrencia);
			salvou = true;
			limparDadosOcorrencia();
			
			initializeInoformationsInTabDevolucaoVeiculo();
			initializeInoformationsInTabAluguelVeiculo();
			initializeInoformationsInTabDisponibilidade();
		
		} catch (Exception e) {
			salvou = false;
		}
		return salvou;
	}

	public boolean devolverAluguel(int idOcorrencia) {
		boolean devolveu = false;
		try {
			Ocorrencia ocorrencia;
			OcorrenciaDAO dao = new OcorrenciaDAO();

			ocorrencia = dao.getOcorrencia(idOcorrencia);
			ocorrencia.setKmFinal(view.txtKmFinal.getText());
			ocorrencia.setDevolvido(true);
			dao.AlterarOcorrencia(ocorrencia);

			devolveu = true;
			
			limparDadosOcorrencia();
			initializeInoformationsInTabDevolucaoVeiculo();
			initializeInoformationsInTabAluguelVeiculo();
			initializeInoformationsInTabDisponibilidade();
		} catch (Exception e) {
			devolveu = false;
		}
		return devolveu;
	}

	public void limparDadosOcorrencia() {
		view.txtDescricao.setText("");
		view.cbxFuncionarioAluguel.setSelectedIndex(0);
		view.cbxVeiculoAluguel.setSelectedIndex(0);
		view.txtDataAluguel.setText("");
		view.txtDataEntrega.setText("");
		view.txtKmInicial.setText("");
		
		view.lblSetDataAluguel.setText("");
		view.lblSetDataDevolucao.setText("");
		view.lblSetFuncionario.setText("");
		view.lblSetVeiculo.setText("");
		view.txtKmFinal.setText("");
	}

	public void initializeInoformationsInTabAluguelVeiculo() {
		FuncionarioDAO funcDao = new FuncionarioDAO();
		VeiculoDAO veicDao = new VeiculoDAO();

		view.cbxFuncionarioAluguel.removeAllItems();
		view.cbxVeiculoAluguel.removeAllItems();

		List<Funcionario> funcionarios = funcDao.getFuncionariosNaoAlocados();
		for (Funcionario funcionario : funcionarios) {
			view.cbxFuncionarioAluguel.addItem(funcionario);
		}
		List<Veiculo> veiculos = veicDao.getVeiculosNaoAlocados();
		for (Veiculo veiculo : veiculos) {
			view.cbxVeiculoAluguel.addItem(veiculo);
		}
	}

	public void updateInoformationsInTabDevolucaoVeiculo(int idPedido) {
		OcorrenciaDAO ocorrDao = new OcorrenciaDAO();
		Ocorrencia ocor = ocorrDao.getOcorrencia(idPedido);
		
		view.lblSetFuncionario.setText(ocor.getFuncionario().getNome());
		view.lblSetVeiculo.setText(ocor.getVeiculo().getMarca());
		view.lblSetDataAluguel.setText(ocor.getDataCriacao());
		view.lblSetDataDevolucao.setText(ocor.getDataDevolucao());
	}

	public void initializeInoformationsInTabDevolucaoVeiculo() {
		OcorrenciaDAO ocorrDao = new OcorrenciaDAO();
		List<Ocorrencia> ocorrencias;

		ocorrencias = ocorrDao.getOcorrencias();
		view.cbxDevolucaoPedido.removeAllItems();
		for (Ocorrencia ocorrencia : ocorrencias) {
			view.cbxDevolucaoPedido.addItem(ocorrencia.getId());
		}
	}

	public void initializeInoformationsInTabDisponibilidade() {
		VeiculoDAO veicDao = new VeiculoDAO();
		FuncionarioDAO funcDao = new FuncionarioDAO();

		Vector<Veiculo> veiculosAlocados = new Vector<Veiculo>();
		Vector<Veiculo> veiculosDisponiveis = new Vector<Veiculo>();
		Vector<Funcionario> funcionariosAlocados = new Vector<Funcionario>();
		Vector<Funcionario> funcionariosDisponiveis = new Vector<Funcionario>();

		List<Veiculo> veicAlocadoList = veicDao.getVeiculosAlocados();
		List<Veiculo> veicDispoList = veicDao.getVeiculosNaoAlocados();
		List<Funcionario> funcAlocadoList = funcDao.getFuncionariosAlocados();
		List<Funcionario> funcDispoList = funcDao.getFuncionariosNaoAlocados();

		for (Veiculo veicAloc : veicAlocadoList) {
			veiculosAlocados.add(veicAloc);
		}

		for (Veiculo veicDispo : veicDispoList) {
			veiculosDisponiveis.add(veicDispo);
		}

		for (Funcionario funcAloc : funcAlocadoList) {
			funcionariosAlocados.add(funcAloc);
		}

		for (Funcionario funcDisp : funcDispoList) {
			funcionariosDisponiveis.add(funcDisp);
		}

		view.tableModelVeiculosAlocados.addRow(veiculosAlocados);
		view.tableModelVeiculosDisponiveis.addRow(veiculosDisponiveis);
		view.tableModelFuncionariosAlocados.addRow(funcionariosAlocados);
		view.tableModelFuncionariosDisponiveis.addRow(funcionariosDisponiveis);
	}

}
