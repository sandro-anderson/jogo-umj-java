package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class TelaIndex extends JFrame {

	private JPanel contentPane;

	
	//TelaJogoA telajj = new TelaJogoA();	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaIndex frame = new TelaIndex();
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
	public TelaIndex() {
		setVisible(true);
		setBackground(new Color(30, 144, 255));
		setTitle("INICIAR");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaIndex.class.getResource("/imagens/logo02.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1100, 650);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIniciar = new JButton("INICIAR");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				setVisible(false);
				
				new TelaLogin().setVisible(true);
				/*
				TelaLogin telaLogin = new TelaLogin();
				//telaLogin = new TelaLogin();
				telaLogin.setLocationRelativeTo(null);
				telaLogin.setVisible(true);
				telaLogin.setResizable(false);
				*/
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setIcon(new ImageIcon(TelaIndex.class.getResource("/imagens/barra16.gif")));
		lblNewLabel_2.setBounds(660, 462, 388, 6);
		contentPane.add(lblNewLabel_2);
		btnIniciar.setBackground(new Color(0, 191, 255));
		btnIniciar.setForeground(new Color(255, 255, 255));
		btnIniciar.setFont(new Font("Gill Sans Ultra Bold", Font.ITALIC, 40));
		btnIniciar.setBounds(660, 383, 388, 86);
		contentPane.add(btnIniciar);
		
		JButton btnRanking = new JButton("RANKING");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TelaJogoA().setVisible(true);
				//telajj= new TelaJogoA();
				/*
				telajj.setLocationRelativeTo(null);
				telajj.setVisible(true);
				telajj.setResizable(false);*/
			}
		});
		btnRanking.setForeground(new Color(255, 255, 255));
		btnRanking.setFont(new Font("Gill Sans Ultra Bold", Font.ITALIC, 40));
		btnRanking.setBackground(new Color(0, 191, 255));
		btnRanking.setBounds(660, 502, 388, 86);
		contentPane.add(btnRanking);
		btnRanking.setVisible(false);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaIndex.class.getResource("/imagens/bonecoinicio.png")));
		lblNewLabel_1.setBounds(0, 155, 366, 456);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaIndex.class.getResource("/imagens/cenariogeral.jpeg")));
		lblNewLabel.setBounds(0, 0, 1084, 611);
		contentPane.add(lblNewLabel);
	}
}
