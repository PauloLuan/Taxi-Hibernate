package br.com.taxi.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.taxi.controller.OcorrenciaController;
import br.com.taxi.view.View;

public class OcorrenciaAdapter {

	private OcorrenciaController controller;
	private View view;

	public OcorrenciaAdapter(View view) {
		this.view = view;
		controller = new OcorrenciaController(view);
		addEventsToOcorrencia();
		controller.initializeInoformationsInTabAluguelVeiculo();
		controller.initializeInoformationsInTabDevolucaoVeiculo();
		controller.initializeInoformationsInTabDisponibilidade();
	}

	public void addEventsToOcorrencia() {
		view.btnCadastrarAluguel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (controller.salvarAluguel()) {
					JOptionPane.showMessageDialog(null,	"Ocorrencia Cadastrado com sucesso!!");
					controller.initializeInoformationsInTabDevolucaoVeiculo();
					controller.initializeInoformationsInTabAluguelVeiculo();
					controller.initializeInoformationsInTabDisponibilidade();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar Ocorrencia!!");
				}
			}
		});

		view.btnLimparOcorrencia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.limparDadosOcorrencia();
			}
		});

		view.cbxDevolucaoPedido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int idSelecionado = Integer.parseInt(view.cbxDevolucaoPedido.getSelectedItem().toString());
					if (idSelecionado != 0) {
						controller.updateInoformationsInTabDevolucaoVeiculo(idSelecionado);
					}
				} catch (Exception e2) {
					System.out.println("Erro no ActionPerformed do ComboDevolução");
				}
			}
		});

		view.btnDevolverVeiculo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int idSelecionado = Integer.parseInt(view.cbxDevolucaoPedido.getSelectedItem().toString());
					if (idSelecionado != 0) {
						controller.devolverAluguel(idSelecionado);
						controller.limparDadosOcorrencia();
					}
				} catch (Exception e2) {
					controller.limparDadosOcorrencia();
					JOptionPane.showMessageDialog(null, "Erro ao Efetuar Devolução do Pedido");
				}
			}
		});
	}
}
