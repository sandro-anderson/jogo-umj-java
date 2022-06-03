package telas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.Pontuacao;
import model.DAO.Jogador_DB;
import model.DAO.Pontuacao_DB;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaJogoA extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	JLabel lblfundo2 = new JLabel("");
	JLabel lbfundo = new JLabel("");
	JLabel lblcorrida3 = new JLabel("");
	JLabel lblcorrida1 = new JLabel("");
	JLabel lblcorrida2 = new JLabel("");
	JLabel lblfbru = new JLabel("");
	JLabel lblfpoo = new JLabel("");
	JLabel lblfna = new JLabel("");
	int x = 35;
	int y = 35;
	int z = 35;
	int a = 164;
	int b = 164;
	int c = 164;
	int op = 0;
	int aux;
	int id, pontos;
	Random andar = new Random();
	boolean repetir = true;
	private final JLabel lblEscolha = new JLabel("VOCÊ ESCOLHEU O 1º CARRO");
	private final JLabel lblVocEscolheuO = new JLabel("VOCÊ ESCOLHEU O 2º CARRO");
	private final JLabel lblVocEscolheuO_1 = new JLabel("VOCÊ ESCOLHEU O 3º CARRO");
	private final JButton btnVoltar = new JButton("VOLTAR");
	private final JLabel lblbarracorrida = new JLabel("New label");
	private final JLabel lblbarracorrida_1 = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogoA frame = new TelaJogoA();
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
	public TelaJogoA() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaJogoA.class.getResource("/imagens/logo02.png")));
		setTitle("JOGO_APOSTA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				 new TelaJogo().setVisible(true);
				//TelaJogo telajogo = new TelaJogo();
				
			}
		});
		lblbarracorrida_1.setIcon(new ImageIcon(TelaJogoA.class.getResource("/imagens/barra07.gif")));
		lblbarracorrida_1.setBounds(454, 597, 620, 14);
		
		contentPane.add(lblbarracorrida_1);
		lblbarracorrida.setIcon(new ImageIcon(TelaJogoA.class.getResource("/imagens/barra07.gif")));
		lblbarracorrida.setBounds(0, 597, 620, 14);
		
		contentPane.add(lblbarracorrida);
		
		JLabel lblNewLabel_1_1 = new JLabel("3º");
		lblNewLabel_1_1.setBackground(Color.YELLOW);
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1_1.setBounds(10, 476, 46, 36);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("2º");
		lblNewLabel_1.setBackground(Color.YELLOW);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(10, 292, 46, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("1º");
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(10, 152, 46, 36);
		contentPane.add(lblNewLabel);
		btnVoltar.setBackground(new Color(0, 0, 255));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 77));
		btnVoltar.setBounds(489, 24, 372, 81);
		
		contentPane.add(btnVoltar);
		btnVoltar.setVisible(false);
		lblVocEscolheuO_1.setForeground(Color.RED);
		lblVocEscolheuO_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		lblVocEscolheuO_1.setBounds(496, 24, 333, 31);
		
		contentPane.add(lblVocEscolheuO_1);
		lblVocEscolheuO_1.setVisible(false);
		
		lblVocEscolheuO.setForeground(Color.RED);
		lblVocEscolheuO.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		lblVocEscolheuO.setBounds(496, 24, 333, 31);
		
		contentPane.add(lblVocEscolheuO);
		lblVocEscolheuO.setVisible(false);
		
		lblEscolha.setForeground(new Color(255, 0, 0));
		lblEscolha.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		lblEscolha.setBounds(496, 24, 333, 31);
		
		contentPane.add(lblEscolha);
		lblEscolha.setVisible(false);
		
		
		lblfna.setIcon(new ImageIcon(TelaJogoA.class.getResource("/imagens/natty.png")));
		lblfna.setBounds(c, 470, 58, 58);
		contentPane.add(lblfna);
		
		lblfpoo.setIcon(new ImageIcon(TelaJogoA.class.getResource("/imagens/poo_png.png")));
		lblfpoo.setBounds(b, 287, 58, 58);
		contentPane.add(lblfpoo);
		
		
		lblfbru.setIcon(new ImageIcon(TelaJogoA.class.getResource("/imagens/bruno_png.png")));
		lblfbru.setBounds(a, 142, 58, 58);
		contentPane.add(lblfbru);
		
		
		
		lblcorrida3.setIcon(new ImageIcon(TelaJogoA.class.getResource("/imagens/rosa_fim.gif")));
		lblcorrida3.setBounds(z, 470, 200, 130);
		contentPane.add(lblcorrida3);
		
		
		lblcorrida1.setIcon(new ImageIcon(TelaJogoA.class.getResource("/imagens/carbru_fim.gif")));
		lblcorrida1.setBounds(x, 142, 196, 123);
		contentPane.add(lblcorrida1);
		
		
		lblcorrida2.setIcon(new ImageIcon(TelaJogoA.class.getResource("/imagens/poo_fim.gif")));
		lblcorrida2.setBounds(y, 287, 169, 130);
		contentPane.add(lblcorrida2);
		
		JLabel lblcarro2 = new JLabel("");
		lblcarro2.setIcon(new ImageIcon(TelaJogoA.class.getResource("/imagens/carro2.jpeg")));
		lblcarro2.setBounds(219, 24, 106, 51);
		contentPane.add(lblcarro2);
		
		JLabel lblcarro3 = new JLabel("");
		lblcarro3.setIcon(new ImageIcon(TelaJogoA.class.getResource("/imagens/carro3.jpeg")));
		lblcarro3.setBounds(361, 24, 106, 51);
		contentPane.add(lblcarro3);
		
		JLabel lbcarro1 = new JLabel("");
		lbcarro1.setIcon(new ImageIcon(TelaJogoA.class.getResource("/imagens/carro1.jpeg")));
		lbcarro1.setBounds(72, 24, 106, 49);
		contentPane.add(lbcarro1);
		
		JRadioButton rdbtncarro1 = new JRadioButton("CARRO 01");
		buttonGroup.add(rdbtncarro1);
		rdbtncarro1.setBounds(85, 82, 93, 23);
		contentPane.add(rdbtncarro1);
		
		JRadioButton rdbtncarro2 = new JRadioButton("CARRO 02");
		buttonGroup.add(rdbtncarro2);
		rdbtncarro2.setBounds(232, 82, 93, 23);
		contentPane.add(rdbtncarro2);
		
		JRadioButton rdbtncarro3 = new JRadioButton("CARRO 03");
		buttonGroup.add(rdbtncarro3);
		rdbtncarro3.setBounds(372, 82, 95, 23);
		contentPane.add(rdbtncarro3);
		
		JButton btnApostar = new JButton("APOSTAR");
		btnApostar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if  (  rdbtncarro1.isSelected()  ) {
					rdbtncarro1.setVisible(false);
					rdbtncarro2.setVisible(false);
					rdbtncarro3.setVisible(false);
					btnApostar.setVisible(false);
					lblEscolha.setVisible(true);
					op = 1;
					Jogo jogoA = new Jogo();
					jogoA.start();
					
					
				}
				
				if  (  rdbtncarro2.isSelected()  ) {
					
					rdbtncarro1.setVisible(false);
					rdbtncarro2.setVisible(false);
					rdbtncarro3.setVisible(false);
					btnApostar.setVisible(false);
					lblVocEscolheuO.setVisible(true);
					op = 2;
					Jogo jogoA = new Jogo();
					jogoA.start();
				}
				
				if  (  rdbtncarro3.isSelected()  ) {
					
					rdbtncarro1.setVisible(false);
					rdbtncarro2.setVisible(false);
					rdbtncarro3.setVisible(false);
					btnApostar.setVisible(false);
					lblVocEscolheuO_1.setVisible(true);
					op = 3;
					Jogo jogoA = new Jogo();
					jogoA.start();
				}
				
				
				
				
				
			}
		});
		btnApostar.setBackground(new Color(255, 255, 0));
		btnApostar.setFont(new Font("Berlin Sans FB", Font.BOLD, 33));
		btnApostar.setBounds(550, 66, 191, 39);
		contentPane.add(btnApostar);
		
		lbfundo.setIcon(new ImageIcon(TelaJogoA.class.getResource("/imagens/pista1.jpeg")));
		lbfundo.setBounds(0, 0, 1100, 650);
		contentPane.add(lbfundo);
		
		
		lblfundo2.setIcon(new ImageIcon(TelaJogoA.class.getResource("/imagens/pista2.jpeg")));
		lblfundo2.setBounds(0, 0, 1100, 650);
		contentPane.add(lblfundo2);
	}//FIM CONSTRUTOR
	
	

	
	
	public class Jogo extends Thread {
		public void jogo() {
			
			
		}
	
		public void run() {
			
			
			while(repetir) {
				
				try {
					
					aux = andar.nextInt(4);
					if (aux != 0 ) {
						switch (aux) {
						case 1:
							a += 10;
							lblfbru.setBounds(a, 142, 58, 58);
							x += 10;
							lblcorrida1.setBounds(x, 142, 196, 123);
							
							break;
						case 2:
							b += 10;
							lblfpoo.setBounds(b, 287, 58, 58);
							y += 10;
							lblcorrida2.setBounds(y, 287, 169, 130);
							
							break;
						case 3:
							c += 10;
							lblfna.setBounds(c, 470, 58, 58);
							z += 10;
							lblcorrida3.setBounds(z, 470, 200, 130);
							
							break;
						default:
							
							
							break;
						}
						/*
						System.out.println("valor X" + x);
						System.out.println("valor y" + y);
						System.out.println("valor z" + z);*/
				
					}else {
							
					}
					
					sleep(50);
					//sleep(1000);
					if(  x == 875) {
						
						
						if ( op == 1) {
							System.out.println("ganhou o 1");
							JOptionPane.showMessageDialog(null,"VOCÊ GANHOU! + 50 PONTOS");
							repetir = false;
							btnVoltar.setVisible(true);
							//----------novo
							Jogador_DB jogadorD = new Jogador_DB(); //pegar nick	
							List<Integer> listaPontuacao = new ArrayList<Integer>();
							listaPontuacao = jogadorD.listarAtual();
							id = listaPontuacao.get(0);
							pontos = listaPontuacao.get(1);
							pontos += 50;
							jogadorD.AtualizarPontos(pontos, id);
							jogadorD.deleteAtual();
							jogadorD.inserirAtual(id, pontos);
							//----------novo
							
							//setVisible(false);
							//TelaJogo telajogo = new TelaJogo();
							//System.exit(DISPOSE_ON_CLOSE);
						}else {
							JOptionPane.showMessageDialog(null,"VOCÊ PERDEU!");
							repetir = false;
							btnVoltar.setVisible(true);
							//setVisible(false);
							//TelaJogo telajogo = new TelaJogo();
							//System.exit(DISPOSE_ON_CLOSE);
						}

					}
					else if(y == 875 ) {
						if ( op == 2) {
							System.out.println("ganhou o 2");
							JOptionPane.showMessageDialog(null,"VOCÊ GANHOU! + 50 PONTOS");
							//TelaJogo telajogo = new TelaJogo();
							//System.exit(DISPOSE_ON_CLOSE);
							repetir = false;
							btnVoltar.setVisible(true);
							//----------novo
							Jogador_DB jogadorD = new Jogador_DB(); //pegar nick	
							List<Integer> listaPontuacao = new ArrayList<Integer>();
							listaPontuacao = jogadorD.listarAtual();
							id = listaPontuacao.get(0);
							pontos = listaPontuacao.get(1);
							pontos += 50;
							jogadorD.AtualizarPontos(pontos, id);
							jogadorD.deleteAtual();
							jogadorD.inserirAtual(id, pontos);
							//----------novo
							//setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null,"VOCÊ PERDEU!");
							//TelaJogo telajogo = new TelaJogo();
							//System.exit(DISPOSE_ON_CLOSE);
							repetir = false;
							btnVoltar.setVisible(true);
							//setVisible(false);
						}

						
					}
					else if ( z == 875) {
						if ( op == 3) {
							System.out.println("ganhou o 3");
							JOptionPane.showMessageDialog(null,"VOCÊ GANHOU! + 50 PONTOS");
							//TelaJogo telajogo = new TelaJogo();
							//System.exit(DISPOSE_ON_CLOSE);
							btnVoltar.setVisible(true);
							repetir = false;
							//----------novo
							Jogador_DB jogadorD = new Jogador_DB(); //pegar nick	
							List<Integer> listaPontuacao = new ArrayList<Integer>();
							listaPontuacao = jogadorD.listarAtual();
							id = listaPontuacao.get(0);
							pontos = listaPontuacao.get(1);
							pontos += 50;
							jogadorD.AtualizarPontos(pontos, id);
							jogadorD.deleteAtual();
							jogadorD.inserirAtual(id, pontos);
							//----------novo
							//setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null,"VOCÊ PERDEU!");
							
							//TelaJogo telajogo = new TelaJogo();
							btnVoltar.setVisible(true);
							//System.exit(DISPOSE_ON_CLOSE);
							repetir = false;
							//setVisible(false);
						}

						
						
					}

					//875 PARA
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//acão

				//setVisible(false);
				//TelaJogo telaJogo = new TelaJogo();
	
			}//fim do while
			
			
		}//fim run
		
	}
}//FIM
