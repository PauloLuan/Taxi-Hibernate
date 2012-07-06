package br.com.taxi.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.taxi.controller.VeiculoController;
import br.com.taxi.view.View;

public class VeiculoAdapter {

	private VeiculoController controller;
	private View view;

	public VeiculoAdapter(View view) {
		this.view = view;
		controller = new VeiculoController(view);
		addEventsToVeiculo();
	}

	public void addEventsToVeiculo() {

		view.btnSalvarVeiculo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (controller.salvarVeiculo()) {
					JOptionPane.showMessageDialog(null,
							"Veiculo Cadastrado com sucesso!!");
				} else {
					JOptionPane.showMessageDialog(null,
							"Erro ao cadastrar Veículo!!");
				}
			}
		});

		view.btnLimparVeiculo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.limparDadosVeiculo();
			}
		});
	}
}
