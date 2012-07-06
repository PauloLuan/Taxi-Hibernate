package br.com.taxi.controller;

import br.com.taxi.model.Veiculo;
import br.com.taxi.model.dao.VeiculoDAO;
import br.com.taxi.view.View;

public class VeiculoController {

	private View view;

	public VeiculoController(View view) {
		this.view = view;
	}

	public boolean salvarVeiculo() {
		boolean salvou = false;

		try {
			Veiculo veiculo = new Veiculo();
			VeiculoDAO dao = new VeiculoDAO();

			veiculo.setTipo(view.txtTipo.getText());
			veiculo.setAno(Integer.parseInt(view.txtAno.getText()));
			veiculo.setCor(view.txtCor.getText());
			veiculo.setMarca(view.txtMarca.getText());
			veiculo.setPlaca(view.txtPlaca.getText());

			dao.SalvarVeiculo(veiculo);
			salvou = true;

			limparDadosVeiculo();
		} catch (Exception e) {
			salvou = false;
		}
		return salvou;
	}

	public void limparDadosVeiculo() {
		view.txtTipo.setText("");
		view.txtAno.setText("");
		view.txtCor.setText("");
		view.txtMarca.setText("");
		view.txtPlaca.setText("");
	}
}
