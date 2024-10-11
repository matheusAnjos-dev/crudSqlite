package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jlogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jlogin frame = new Jlogin();
					frame.setLocationRelativeTo(null);
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
	public Jlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 351);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(146, 42, 250, 226);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem Vindo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(80, 11, 99, 14);
		panel.add(lblNewLabel);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(47, 75, 160, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(47, 58, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(47, 112, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(47, 125, 160, 20);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldUsuario.getText() != null &&
						!textFieldUsuario.getText().isEmpty() &&
						passwordField.getText()!= null &&
						!passwordField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnNewButton, "Login realizado com sucesso.");
				}
				else {
					JOptionPane.showMessageDialog(btnNewButton, "Usuario ou senha incorretos. Verifique as informações", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBackground(new Color (0, 128, 255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(80, 178, 89, 23);
		panel.add(btnNewButton);
	}
}
