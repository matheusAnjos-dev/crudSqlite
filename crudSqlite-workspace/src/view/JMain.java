package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.ModeloTabela;

import javax.swing.JScrollPane;

public class JMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private ArrayList<Cliente> clientes;

	
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
		clientes = new ArrayList<>();
		clientes.add(new Cliente ("1", "Matheus", "777777777", "teste@gmail.com", "99999999999", "xxxxxxxxx"));
		clientes.add(new Cliente ("2", "Julia", "9999999999", "teste2@gmail.com", "55555555555", "yyyyyyyyyy"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(42, 53, 103, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(172, 54, 520, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 133, 712, 297);
		contentPane.add(scrollPane);
		ModeloTabela modeloTabela = new ModeloTabela(clientes);
		
		table = new JTable();
		table.setModel(modeloTabela);
		table.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(table);

		table.setBackground(new Color(230, 230, 230));
	}
}
