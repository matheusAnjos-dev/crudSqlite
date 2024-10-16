package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.DAO;
import model.Cliente;
import model.ModeloTabela;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ArrayList<Cliente> clientes;
	private JMain jMain;
	private JTextField textFieldBusca;
	private TableRowSorter<ModeloTabela> rowSorter;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMain frame = new JMain();
					frame.setLocationRelativeTo(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public JMain() {
		this.jMain = this;
		DAO dao = new DAO();
		try {
			clientes = dao.listarClientes();
		} catch (Exception e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 534);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCadastro jCadastro = new JCadastro(null, jMain);
				jCadastro.setLocationRelativeTo(jCadastro);
				jCadastro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				jCadastro.setVisible(true);
			}
		});
		btnNewButton.setBounds(25, 38, 134, 36);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(192, 192, 192));
		scrollPane.setBounds(21, 133, 819, 327);
		contentPane.add(scrollPane);
		ModeloTabela modeloTabela = new ModeloTabela(clientes);
		
		table = new JTable();
		table.setModel(modeloTabela);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // metodo para editar cadastro atraves do mouse
				if(e.getButton()==1) {
					try {
						Cliente clienteSelecionado = dao.consultarCliente(modeloTabela.getValueAt(table.getSelectedRow(), 0).toString());
						JCadastro jCadastro = new JCadastro(clienteSelecionado, jMain);
						jCadastro.setLocationRelativeTo(jCadastro);
						jCadastro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						jCadastro.setVisible(true);
					} catch (Exception e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		
		rowSorter = new TableRowSorter<>(modeloTabela);
		table.setRowSorter(rowSorter);
		table.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(table);

		table.setBackground(new Color(230, 230, 230));
		
		textFieldBusca = new JTextField();
		textFieldBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				filtrar();
			}
		});
		textFieldBusca.setBounds(21, 101, 446, 20);
		contentPane.add(textFieldBusca);
		textFieldBusca.setColumns(10);
		
		// não precisa. alterar para icon de lupa
		JButton btnNewButton_1 = new JButton("Pesquisar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(492, 99, 124, 23);
		contentPane.add(btnNewButton_1);
	}
	
	//funcao de filtrar busca
	private void filtrar() {
		String busca = textFieldBusca.getText().trim();
		if(busca.length() == 0) {
			rowSorter.setRowFilter(null);
		}else {
			rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ busca));
		}
		
	}
}
