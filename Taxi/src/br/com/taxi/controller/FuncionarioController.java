package br.com.taxi.controller;

import br.com.taxi.model.Funcionario;
import br.com.taxi.model.dao.FuncionarioDAO;
import br.com.taxi.view.View;

public class FuncionarioController {

	private View view;

	public FuncionarioController(View view) {
		this.view = view;
	}

	public boolean salvarFuncionario() {
		boolean salvou = false;

		try {
			Funcionario funcionario = new Funcionario();
			FuncionarioDAO dao = new FuncionarioDAO();

			funcionario.setNome(view.txtNomeFunc.getText());
			funcionario.setEndereco(view.txtEnderecoFunc.getText());
			funcionario.setNumero(view.txtNumFunc.getText());
			funcionario.setBairro(view.txtBairroFunc.getText());
			funcionario.setCidade(view.txtCidadeFunc.getText());
			funcionario.setEstado(view.txtEstadoFunc.getText());
			funcionario.setCep(view.txtCepFunc.getText());
			funcionario.setTelefone(view.txtTelefoneFunc.getText());

			dao.SalvarFuncionario(funcionario);
			salvou = true;

			limparDados();
		} catch (Exception e) {
			salvou = false;
		}
		return salvou;
	}

	public void limparDados() {
		view.txtNomeFunc.setText("");
		view.txtEnderecoFunc.setText("");
		view.txtNumFunc.setText("");
		view.txtBairroFunc.setText("");
		view.txtCidadeFunc.setText("");
		view.txtEstadoFunc.setText("");
		view.txtCepFunc.setText("");
		view.txtTelefoneFunc.setText("");
	}
}
