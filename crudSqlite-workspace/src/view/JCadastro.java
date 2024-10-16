package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;

import dao.DAO;
import model.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCpfCnpj;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextArea textAreaEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastro frame = new JCadastro(null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JCadastro(Cliente clienteSelecionado, JMain jMain) {
		DAO dao = new DAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 361);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 25, 479, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpfcnpj.setBounds(10, 51, 62, 14);
		contentPane.add(lblCpfcnpj);
		
		textFieldCpfCnpj = new JTextField();
		textFieldCpfCnpj.setColumns(10);
		textFieldCpfCnpj.setBounds(10, 65, 216, 20);
		contentPane.add(textFieldCpfCnpj);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefone.setBounds(273, 51, 62, 14);
		contentPane.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(273, 65, 216, 20);
		contentPane.add(textFieldTelefone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(10, 96, 46, 14);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(10, 110, 479, 20);
		contentPane.add(textFieldEmail);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEndereo.setBounds(10, 141, 113, 14);
		contentPane.add(lblEndereo);
		
		textAreaEndereco = new JTextArea();
		textAreaEndereco.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaEndereco.setBounds(10, 157, 382, 51);
		contentPane.add(textAreaEndereco);
		
		JButton btnNewButton = new JButton(clienteSelecionado == null?"Incluir":"Alterar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cliente cliente = new Cliente(null, textFieldNome.getText(), textFieldCpfCnpj.getText(),
						textFieldEmail.getText(),textFieldTelefone.getText(),textAreaEndereco.getText());
				if(clienteSelecionado == null) {
					if(!"".equalsIgnoreCase(textFieldNome.getText())  &&  !"".equalsIgnoreCase(textFieldCpfCnpj.getText())) {
						dao.cadastrarCliente(cliente);
						abrirTelaPrincipal(jMain);
					}else {
						JOptionPane.showMessageDialog(null, "Campos Nome e CPF/CNPJ são obrigatorios");
					}
				}
				else {
					if(!"".equalsIgnoreCase(textFieldNome.getText())  &&  !"".equalsIgnoreCase(textFieldCpfCnpj.getText())) {
						dao.alterarCliente(cliente, clienteSelecionado.getId());
						abrirTelaPrincipal(jMain);
					}else {
						JOptionPane.showMessageDialog(null, "Campos Nome e CPF/CNPJ são obrigatorios");
					}
				}

			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(378, 273, 119, 38);
		contentPane.add(btnNewButton);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao.excluirCliente(clienteSelecionado.getId());
				abrirTelaPrincipal(jMain);
				
			}
		});
		
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluir.setBackground(new Color(255, 0, 0));
		btnExcluir.setBounds(10, 273, 119, 38);
		btnExcluir.setVisible(false);
		contentPane.add(btnExcluir);
		
		if(clienteSelecionado != null) {
		preencherCampos(clienteSelecionado);
		btnExcluir.setVisible(true);
		}
	}
	
	private void preencherCampos(Cliente clienteSelecionado) {
		textFieldNome.setText(clienteSelecionado.getNome());
		textFieldCpfCnpj.setText(clienteSelecionado.getCpfCnpj());
		textFieldEmail.setText(clienteSelecionado.getEmail());
		textFieldTelefone.setText(clienteSelecionado.getTelefone());
		textAreaEndereco.setText(clienteSelecionado.getEndereco());
	}
	
	private void abrirTelaPrincipal(JMain jMain) {
		jMain.dispose();
		dispose();
		jMain = new JMain();
		jMain.setLocationRelativeTo(jMain);
		jMain.setVisible(true);
	}
}
