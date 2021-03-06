package br.com.taxi.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import br.com.taxi.adapter.FuncionarioAdapter;
import br.com.taxi.adapter.OcorrenciaAdapter;
import br.com.taxi.adapter.VeiculoAdapter;
import br.com.taxi.hibernate.HibernateUtil;

public class View extends JFrame {

	public JTabbedPane tabbedPane;

	public JPanel panelPanels;
	public JPanel panelDisponibilidade;
	public JPanel panelDadosFuncionario;
	public JPanel panelAluguel;

	public JLabel lblNome;
	public JLabel lblBairro;
	public JLabel lblCidade;

	public JTextField txtNomeFunc;
	public JTextField txtBairroFunc;
	public JTextField txtCidadeFunc;

	public JMenuBar menuBar;
	public JMenu menuAjuda;

	public JMenuItem subNovo, subSobre;
	public JTextField txtEnderecoFunc;
	public JTextField txtTelefoneFunc;
	public JTextField txtCepFunc;

	public JTable tableVeiculosAlocados;
	public JTable tableVeiculosDisponiveis;
	public JTable tableFuncionariosAlocados;
	public JTable tableFuncionariosDisponiveis;

	public DefaultTableModel tableModelVeiculosAlocados;
	public DefaultTableModel tableModelFuncionariosAlocados;
	public DefaultTableModel tableModelVeiculosDisponiveis;
	public DefaultTableModel tableModelFuncionariosDisponiveis;

	public JTextField txtNumFunc;
	public JLabel lblMotorista;
	public JLabel lblVeiculo;
	public JComboBox cbxFuncionarioAluguel;
	public JComboBox cbxVeiculoAluguel;
	public JButton btnCadastrarAluguel;
	public JLabel lblCarrosAlugados;
	public JLabel lblCarrosDisponveis;
	public JPanel panelEndereco;

	public JPanel panelDadosVeiculo;
	public JPanel panelCadastroVeiculo;
	public JPanel panel_1;
	public JButton btnSalvarVeiculo;
	public JButton btnLimparVeiculo;
	public JTextField txtTipo;
	public JLabel lblTipo;
	public JTextField txtMarca;
	public JLabel lblMarca;
	public JLabel lblAno;
	public JTextField txtAno;
	public JLabel lblPlaca;
	public JTextField txtPlaca;
	public JLabel lblCor;
	public JTextField txtCor;
	public JLabel lblCadastrarNovoVeculo;
	public JLabel lblCadastrarNovoFuncionrio;

	public JPanel panelDevolucao;
	public JPanel panelDevolucaoVeiculo;
	public JComboBox cbxDevolucaoPedido;
	public JLabel lblSelecioneOPedido;
	public JButton btnDevolverVeiculo;
	public JLabel lblDevoluoDeVeculo;
	public JLabel lblKmInicial;
	public JTextField txtKmInicial;
	public JTextField txtEstadoFunc;
	public JButton btnSalvarFuncionario;
	public JButton btnLimparFunc;
	public JButton btnLimparOcorrencia;
	public JTextArea txtDescricao;
	public JLabel lblSetFuncionario;
	public JLabel lblSetVeiculo;
	public JLabel lblSetDataAluguel;
	public JScrollPane scrollPaneVeiculosDisponíveis;
	public JScrollPane scrollPaneFuncionariosAlocados;
	public JScrollPane scrollPaneFuncionariosDisponiveis;
	public JTextField txtDataAluguel;
	public JLabel lblDataEntrega_1;
	public JTextField txtDataEntrega;
	public JLabel lblDataDevolucao;
	public JLabel lblSetDataDevolucao;
	public JTextField txtKmFinal;

	public View() {
		initialize();
		initializeTabAluguel();
		initializeTabDevolucao();
		initializeTabCadastroFuncionario();
		initializeTabCadastroVeiculo();
		initializeMenus();
		initializeAdapters();
	}

	public void initialize() {

		panelPanels = new JPanel();
		panelPanels.setLayout(new BorderLayout(0, 0));
		panelAluguel = new JPanel();
		panelDevolucao = new JPanel();
		panelDisponibilidade = new JPanel();
		panelDadosFuncionario = new JPanel();
		panelDadosVeiculo = new JPanel();

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panelPanels.add(tabbedPane);
		tabbedPane.addTab("Aluguel de Veiculo", panelAluguel);
		tabbedPane.addTab("Devolução de Veiculo", panelDevolucao);
		panelDevolucao.setLayout(new BoxLayout(panelDevolucao, BoxLayout.X_AXIS));

		tabbedPane.addTab("Disponibilidade", panelDisponibilidade);
		panelDisponibilidade.setLayout(new BoxLayout(panelDisponibilidade,
				BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panelDisponibilidade.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPaneVeiculosAlocados = new JScrollPane();
		scrollPaneVeiculosAlocados.setBounds(73, 34, 308, 72);
		panel.add(scrollPaneVeiculosAlocados);

		scrollPaneVeiculosDisponíveis = new JScrollPane();
		scrollPaneVeiculosDisponíveis.setBounds(430, 34, 308, 72);
		panel.add(scrollPaneVeiculosDisponíveis);
		
		scrollPaneFuncionariosDisponiveis = new JScrollPane();
		scrollPaneFuncionariosDisponiveis.setBounds(430, 149, 308, 72);
		panel.add(scrollPaneFuncionariosDisponiveis);

		scrollPaneFuncionariosAlocados = new JScrollPane();
		scrollPaneFuncionariosAlocados.setBounds(73, 149, 308, 72);
		panel.add(scrollPaneFuncionariosAlocados);
		
		lblCarrosAlugados = new JLabel("Carros Alugados");
		lblCarrosAlugados.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCarrosAlugados.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarrosAlugados.setBounds(73, 6, 308, 16);
		panel.add(lblCarrosAlugados);

		lblCarrosDisponveis = new JLabel("Carros Disponíveis");
		lblCarrosDisponveis.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCarrosDisponveis.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarrosDisponveis.setBounds(420, 6, 320, 16);
		panel.add(lblCarrosDisponveis);

		String[] colunaVeiculosAlugados = new String[]{"Veículos Alocados"}; 
		String[] colunaVeiculosDisponiveis = new String[]{"Veículos Disponíveis"}; 
		String[] colunaFuncionariosAlocados = new String[]{"Funcionários Alocados"}; 
		String[] colunaFuncionariosDisponiveis = new String[]{"Veículos Disponíveis"}; 

		tableModelVeiculosAlocados = new DefaultTableModel(null, colunaVeiculosAlugados);
		tableModelVeiculosDisponiveis = new DefaultTableModel(null, colunaVeiculosDisponiveis);
		tableModelFuncionariosAlocados = new DefaultTableModel(null, colunaFuncionariosAlocados);
		tableModelFuncionariosDisponiveis = new DefaultTableModel(null, colunaFuncionariosDisponiveis);

		tableVeiculosAlocados = new JTable();
		tableVeiculosDisponiveis = new JTable();
		tableFuncionariosAlocados = new JTable();
		tableFuncionariosDisponiveis = new JTable();

		tableVeiculosAlocados.setModel(tableModelVeiculosAlocados);
		tableVeiculosDisponiveis.setModel(tableModelVeiculosDisponiveis);
		tableFuncionariosAlocados.setModel(tableModelFuncionariosAlocados);
		tableFuncionariosDisponiveis.setModel(tableModelFuncionariosDisponiveis);

		scrollPaneVeiculosAlocados.setViewportView(tableVeiculosAlocados);
		scrollPaneVeiculosDisponíveis.setViewportView(tableVeiculosDisponiveis);
		scrollPaneFuncionariosAlocados.setViewportView(tableFuncionariosAlocados);
		scrollPaneFuncionariosDisponiveis.setViewportView(tableFuncionariosDisponiveis);

		JLabel lblFuncionariosAlocados = new JLabel("Funcionarios Alocados");
		lblFuncionariosAlocados.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuncionariosAlocados.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFuncionariosAlocados.setBounds(73, 121, 308, 16);
		panel.add(lblFuncionariosAlocados);

		JLabel lblFuncionariosdisponiveis = new JLabel(
				"FuncionariosDisponiveis");
		lblFuncionariosdisponiveis
		.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuncionariosdisponiveis
		.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFuncionariosdisponiveis.setBounds(420, 121, 320, 16);
		panel.add(lblFuncionariosdisponiveis);


		tabbedPane.addTab("Cadastrar Funcionario", panelDadosFuncionario);
		tabbedPane.addTab("Cadastrar Veículo", panelDadosVeiculo);
		panelDadosVeiculo.setLayout(new BoxLayout(panelDadosVeiculo,
				BoxLayout.X_AXIS));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(805, 319);
		setLocationRelativeTo(null);
		getContentPane().setLayout(
				new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		getContentPane().add(panelPanels);
	}

	public void initializeTabAluguel() {
		panelAluguel.setLayout(new BoxLayout(panelAluguel, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panelAluguel.add(panel);
		panel.setLayout(null);

		btnCadastrarAluguel = new JButton("Cadastrar Aluguel");
		btnCadastrarAluguel.setBounds(527, 186, 168, 39);
		panel.add(btnCadastrarAluguel);

		cbxVeiculoAluguel = new JComboBox();
		cbxVeiculoAluguel.setBounds(223, 88, 158, 20);
		panel.add(cbxVeiculoAluguel);

		lblVeiculo = new JLabel("Veiculo:");
		lblVeiculo.setBounds(67, 88, 153, 14);
		panel.add(lblVeiculo);

		lblMotorista = new JLabel("Funcionario:");
		lblMotorista.setBounds(67, 52, 153, 14);
		panel.add(lblMotorista);

		cbxFuncionarioAluguel = new JComboBox();
		cbxFuncionarioAluguel.setBounds(223, 52, 158, 20);
		panel.add(cbxFuncionarioAluguel);

		JLabel label = new JLabel(
				"Cadastre um Veículo em nome de um funcionário");
		label.setFont(new Font("SansSerif", Font.BOLD, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(113, 6, 566, 14);
		panel.add(label);

		JLabel lblDataEntrega = new JLabel("Data Aluguel:");
		lblDataEntrega.setBounds(67, 120, 153, 16);
		panel.add(lblDataEntrega);

		JLabel lblDescrioDoPedido = new JLabel("Descrição do Pedido");
		lblDescrioDoPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrioDoPedido.setBounds(427, 32, 261, 16);
		panel.add(lblDescrioDoPedido);

		lblKmInicial = new JLabel("Km Inicial");
		lblKmInicial.setBounds(427, 117, 101, 16);
		panel.add(lblKmInicial);

		txtKmInicial = new JTextField();
		txtKmInicial.setBounds(537, 111, 158, 28);
		panel.add(txtKmInicial);
		txtKmInicial.setColumns(10);

		txtDescricao = new JTextArea();
		txtDescricao.setBounds(427, 48, 268, 56);
		panel.add(txtDescricao);

		btnLimparOcorrencia = new JButton("Limpar Formulário");
		btnLimparOcorrencia.setBounds(330, 186, 168, 39);
		panel.add(btnLimparOcorrencia);

		txtDataAluguel = new JTextField();
		txtDataAluguel.setBounds(223, 120, 135, 27);
		panel.add(txtDataAluguel);
		txtDataAluguel.setColumns(10);

		lblDataEntrega_1 = new JLabel("Data Entrega:");
		lblDataEntrega_1.setBounds(67, 152, 153, 16);
		panel.add(lblDataEntrega_1);

		txtDataEntrega = new JTextField();
		txtDataEntrega.setColumns(10);
		txtDataEntrega.setBounds(223, 152, 135, 27);
		panel.add(txtDataEntrega);

	}

	public void initializeTabDevolucao() {
		panelDevolucaoVeiculo = new JPanel();
		panelDevolucao.add(panelDevolucaoVeiculo);
		panelDevolucaoVeiculo.setLayout(null);

		cbxDevolucaoPedido = new JComboBox();
		cbxDevolucaoPedido.setBounds(290, 39, 238, 26);
		panelDevolucaoVeiculo.add(cbxDevolucaoPedido);

		lblSelecioneOPedido = new JLabel("Selecione o Pedido:");
		lblSelecioneOPedido.setBounds(114, 39, 167, 16);
		panelDevolucaoVeiculo.add(lblSelecioneOPedido);

		btnDevolverVeiculo = new JButton("Devolver veículo");
		btnDevolverVeiculo.setBounds(248, 191, 193, 28);
		panelDevolucaoVeiculo.add(btnDevolverVeiculo);

		lblDevoluoDeVeculo = new JLabel("Devolução de veículo");
		lblDevoluoDeVeculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDevoluoDeVeculo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDevoluoDeVeculo.setBounds(141, 6, 402, 16);
		panelDevolucaoVeiculo.add(lblDevoluoDeVeculo);

		JLabel lblKmFinal = new JLabel("Digite a Km Final:");
		lblKmFinal.setBounds(114, 158, 167, 16);
		panelDevolucaoVeiculo.add(lblKmFinal);

		JLabel lblFuncionario = new JLabel("Funcionario: ");
		lblFuncionario.setBounds(114, 67, 167, 16);
		panelDevolucaoVeiculo.add(lblFuncionario);

		JLabel lblVeiculo_1 = new JLabel("Veiculo:");
		lblVeiculo_1.setBounds(114, 83, 167, 16);
		panelDevolucaoVeiculo.add(lblVeiculo_1);

		JLabel lblDataDoAluguel = new JLabel("Data do Aluguel");
		lblDataDoAluguel.setBounds(114, 103, 167, 16);
		panelDevolucaoVeiculo.add(lblDataDoAluguel);

		lblSetFuncionario = new JLabel("");
		lblSetFuncionario.setBounds(290, 72, 238, 16);
		panelDevolucaoVeiculo.add(lblSetFuncionario);

		lblSetVeiculo = new JLabel("");
		lblSetVeiculo.setBounds(290, 88, 238, 16);
		panelDevolucaoVeiculo.add(lblSetVeiculo);

		lblSetDataAluguel = new JLabel("");
		lblSetDataAluguel.setBounds(290, 108, 238, 16);
		panelDevolucaoVeiculo.add(lblSetDataAluguel);

		lblDataDevolucao = new JLabel("Data Devolucao");
		lblDataDevolucao.setBounds(114, 125, 167, 16);
		panelDevolucaoVeiculo.add(lblDataDevolucao);

		lblSetDataDevolucao = new JLabel("");
		lblSetDataDevolucao.setBounds(290, 130, 238, 16);
		panelDevolucaoVeiculo.add(lblSetDataDevolucao);

		txtKmFinal = new JTextField();
		txtKmFinal.setBounds(290, 152, 193, 27);
		panelDevolucaoVeiculo.add(txtKmFinal);
		txtKmFinal.setColumns(10);

	}

	public void initializeTabCadastroFuncionario() {
		panelDadosFuncionario.setLayout(new BoxLayout(panelDadosFuncionario,
				BoxLayout.X_AXIS));

		panelEndereco = new JPanel();
		panelDadosFuncionario.add(panelEndereco);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(150, 49, 88, 14);
		lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(150, 105, 88, 14);
		lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(416, 109, 73, 14);

		txtNomeFunc = new JTextField();
		txtNomeFunc.setBounds(250, 49, 399, 20);
		txtBairroFunc = new JTextField();
		txtBairroFunc.setBounds(250, 105, 154, 20);
		txtCidadeFunc = new JTextField();
		txtCidadeFunc.setBounds(490, 105, 159, 20);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(150, 77, 88, 14);

		txtEnderecoFunc = new JTextField();
		txtEnderecoFunc.setBounds(250, 77, 219, 20);

		txtTelefoneFunc = new JTextField();
		txtTelefoneFunc.setBounds(490, 132, 159, 20);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(416, 134, 73, 14);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(150, 135, 88, 14);

		txtEstadoFunc = new JTextField();
		txtEstadoFunc.setBounds(250, 135, 37, 20);

		JLabel lblCep = new JLabel("Cep");
		lblCep.setBounds(297, 139, 37, 14);

		txtCepFunc = new JTextField();
		txtCepFunc.setBounds(327, 135, 77, 20);

		btnSalvarFuncionario = new JButton("Salvar");
		btnSalvarFuncionario.setBounds(285, 167, 110, 31);

		btnLimparFunc = new JButton("Limpar");
		btnLimparFunc.setBounds(411, 167, 110, 31);

		panelEndereco.setLayout(null);
		panelEndereco.add(btnSalvarFuncionario);
		panelEndereco.add(btnLimparFunc);
		panelEndereco.add(txtNomeFunc);
		panelEndereco.add(lblNome);
		panelEndereco.add(txtEnderecoFunc);
		panelEndereco.add(lblEndereco);
		panelEndereco.add(lblBairro);
		panelEndereco.add(txtBairroFunc);
		panelEndereco.add(lblCidade);
		panelEndereco.add(txtCidadeFunc);
		panelEndereco.add(lblEstado);
		panelEndereco.add(txtEstadoFunc);
		panelEndereco.add(lblCep);
		panelEndereco.add(txtCepFunc);
		panelEndereco.add(lblTelefone);
		panelEndereco.add(txtTelefoneFunc);

		JLabel lblNum = new JLabel("Numero");
		lblNum.setBounds(503, 80, 70, 14);
		panelEndereco.add(lblNum);

		txtNumFunc = new JTextField();
		txtNumFunc.setBounds(573, 77, 76, 20);
		panelEndereco.add(txtNumFunc);

		lblCadastrarNovoFuncionrio = new JLabel("Cadastrar novo funcionário");
		lblCadastrarNovoFuncionrio
		.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCadastrarNovoFuncionrio
		.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovoFuncionrio.setBounds(263, 21, 310, 16);
		panelEndereco.add(lblCadastrarNovoFuncionrio);
	}

	public void initializeTabCadastroVeiculo() {
		panelCadastroVeiculo = new JPanel();
		panelDadosVeiculo.add(panelCadastroVeiculo);
		panelCadastroVeiculo.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(126, 17, 463, 205);
		panelCadastroVeiculo.add(panel_1);

		btnSalvarVeiculo = new JButton("Salvar");
		btnSalvarVeiculo.setBounds(108, 158, 110, 41);
		panel_1.add(btnSalvarVeiculo);

		btnLimparVeiculo = new JButton("Limpar");
		btnLimparVeiculo.setBounds(245, 158, 100, 41);
		panel_1.add(btnLimparVeiculo);

		txtTipo = new JTextField();
		txtTipo.setBounds(99, 47, 333, 20);
		panel_1.add(txtTipo);

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(6, 50, 70, 14);
		panel_1.add(lblTipo);

		txtMarca = new JTextField();
		txtMarca.setBounds(99, 75, 182, 20);
		panel_1.add(txtMarca);

		lblMarca = new JLabel("Nome");
		lblMarca.setBounds(6, 78, 70, 14);
		panel_1.add(lblMarca);

		lblAno = new JLabel("Ano");
		lblAno.setBounds(6, 106, 70, 14);
		panel_1.add(lblAno);

		txtAno = new JTextField();
		txtAno.setBounds(99, 103, 104, 20);
		panel_1.add(txtAno);

		lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(223, 108, 58, 14);
		panel_1.add(lblPlaca);

		txtPlaca = new JTextField();
		txtPlaca.setBounds(289, 103, 143, 20);
		panel_1.add(txtPlaca);

		lblCor = new JLabel("Cor");
		lblCor.setBounds(302, 78, 43, 14);
		panel_1.add(lblCor);

		txtCor = new JTextField();
		txtCor.setBounds(345, 75, 87, 20);
		panel_1.add(txtCor);

		lblCadastrarNovoVeculo = new JLabel("Cadastrar novo veículo");
		lblCadastrarNovoVeculo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCadastrarNovoVeculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovoVeculo.setBounds(62, 6, 333, 16);
		panel_1.add(lblCadastrarNovoVeculo);

	}

	public void initializeMenus() {

		menuBar = new JMenuBar();

		/* Instancia��o dos Menus */
		menuAjuda = new JMenu("Ajuda");

		/* SubMenus do Menu Arquivo */
		subNovo = new JMenuItem("Novo");

		menuBar.add(menuAjuda);

		/* SubManus do Menu Ajuda */
		subSobre = new JMenuItem("Sobre");

		/* Menu Ajuda: Adiciona subItens ao menu Ajuda */
		menuAjuda.add(subSobre);

		this.setJMenuBar(menuBar);
	}

	public void initializeAdapters() {
		new FuncionarioAdapter(this);
		new VeiculoAdapter(this);
		new OcorrenciaAdapter(this);
	}

	public static void main(String[] args) {
		HibernateUtil.instanciaDadosNoBD();
		View gui = new View();
		gui.setVisible(true);
	}
}
