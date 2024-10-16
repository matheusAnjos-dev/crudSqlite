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
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

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
		setBackground(new Color(0, 128, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1173, 737);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTeste = new JPanel();
		panelTeste.setBackground(new Color(255, 255, 255));
		panelTeste.setBounds(660, 74, 433, 613);
		contentPane.add(panelTeste);
		panelTeste.setLayout(null);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBackground(new Color(204, 255, 255));
		textFieldUsuario.setBounds(32, 227, 359, 36);
		panelTeste.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setBackground(new Color(0, 128, 255));
		lblNewLabel_1_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(34, 258, 341, 43);
		panelTeste.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(204, 255, 255));
		passwordField.setForeground(new Color(0, 128, 255));
		passwordField.setBounds(34, 299, 359, 36);
		panelTeste.add(passwordField);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		//evento botao login
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldUsuario.getText() != null &&
						!textFieldUsuario.getText().isEmpty() &&
						passwordField.getText()!= null &&
						!passwordField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Login realizado com sucesso.");
					dispose(); // fecha janela de login
					JMain jMain = new JMain();
					jMain.setLocationRelativeTo(jMain);
					jMain.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos. Verifique as informações", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(138, 485, 160, 36);
		panelTeste.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setBackground(new Color(0, 128, 255));
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setBounds(32, 180, 143, 49);
		panelTeste.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Jlogin.class.getResource("/icon/computer.png")));
		lblNewLabel_2.setBounds(176, 62, 71, 79);
		panelTeste.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 591, 698);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Jlogin.class.getResource("/icon/user.png")));
		lblNewLabel.setBounds(39, 89, 479, 521);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("LOGIN");
		lblNewLabel_3.setBackground(new Color(30, 144, 255));
		lblNewLabel_3.setForeground(new Color(30, 144, 255));
		lblNewLabel_3.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		lblNewLabel_3.setBounds(837, 11, 220, 52);
		contentPane.add(lblNewLabel_3);
	}
}
