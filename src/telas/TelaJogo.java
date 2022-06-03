package telas;

import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.Jogador;
import DAO.Pontuacao;
import model.DAO.Jogador_DB;
import model.DAO.Pontuacao_DB;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaJogo extends JFrame {

	private JPanel contentPane;
	
	//TelaJogoA telajj = new TelaJogoA();	
	
	JLabel lblbonecolado = new JLabel("");
	JLabel lblbonecofrente = new JLabel("");
	int eixox = 77;
	//int add = 10;
	int id, pontos;
	String nick;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogo frame = new TelaJogo();
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
	public TelaJogo() {
		
		setResizable(false);
		setTitle("GAME");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaJogo.class.getResource("/imagens/logo02.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1100, 650);
		setVisible(true);
		Jogador_DB jogadorD = new Jogador_DB(); //pegar nick
		
		List<Integer> listaPontuacao = new ArrayList<Integer>();
		listaPontuacao = jogadorD.listarAtual();
		
		id = listaPontuacao.get(0);
		pontos = listaPontuacao.get(1);
		//Pontuacao_DB pontuacaoDB = new Pontuacao_DB();//pegar pontos
		
		
		//List<Pontuacao> listaPontuacao = new ArrayList<Pontuacao>();
		List<Jogador> listaJogador = new ArrayList<Jogador>();
		
		//listaPontuacao = pontuacaoDB.listarTodos();
		listaJogador =  jogadorD.listarLogin();
		
		for (  int i =0; i < listaJogador.size() ; i++ ) {
			System.out.println( );
			if ( listaJogador.get(i).getId_jogador() == id  ) {
				nick = listaJogador.get(i).getNick_name();
						break;
			}
			//System.out.println(listaJogador.get(i).getCpf()      );
			//System.out.println( listaJogador.get(i).getNick_name()     );
		}
		
		//pegar a tabela atual ..e pegar o id e armazenar no id só isso
		//nick = listaJogador.get(8).getNick_name();
		
		//pontos = listaPontuacao.get(id).getPontos();
		
		//System.out.println( listaPontuacao.get(0) );  pega o id
		//System.out.println( listaPontuacao.get(1) );  pega a pontucao
		
		
		
		
		//System.out.println(" algo");
		//Acao();
		
		
		contentPane = new JPanel();
	
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//botao entrar vai para a tela jogoA
				if(eixox == 877) {
					setVisible(false);
					new TelaJogoA().setVisible(true);
					//TelaJogoA telajogo = new TelaJogoA();
					/*
					telajj= new TelaJogoA();
					telajj.setLocationRelativeTo(null);
					telajj.setVisible(true);
					telajj.setResizable(false);*/
					
				}
				
			}
		});
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(EXIT_ON_CLOSE);
			}
		});
		
		JLabel lblPontos = new JLabel("POINT");
		lblPontos.setVerticalAlignment(SwingConstants.TOP);
		lblPontos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPontos.setForeground(Color.WHITE);
		lblPontos.setFont(new Font("Arial Black", Font.BOLD, 40));
		lblPontos.setBounds(860, 117, 174, 51);
		contentPane.add(lblPontos);
		
		JLabel lblnomejogador = new JLabel("JOGADOR");
		lblnomejogador.setVerticalAlignment(SwingConstants.TOP);
		lblnomejogador.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnomejogador.setForeground(Color.WHITE);
		lblnomejogador.setFont(new Font("Arial Black", Font.BOLD, 40));
		lblnomejogador.setBackground(new Color(0, 191, 255));
		lblnomejogador.setBounds(547, 117, 303, 51);
		contentPane.add(lblnomejogador);
		btnSair.setBackground(Color.RED);
		btnSair.setForeground(new Color(0, 0, 0));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSair.setBounds(841, 44, 115, 35);
		contentPane.add(btnSair);
		btnEntrar.setBackground(new Color(105, 105, 105));
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnEntrar.setBounds(901, 545, 139, 43);
		contentPane.add(btnEntrar);
		
		JLabel lblNomeComandos = new JLabel("");
		lblNomeComandos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//lado esquerdo seta esquerda
				lblbonecofrente.setVisible(false);
				lblbonecolado.setVisible(true);
				if(eixox != 77) {
					eixox -= 50;
				}else {
					eixox = 77;
				}
				
				lblbonecolado.setBounds(  (eixox),  275, 153, 223);
	
			}
		});
		lblNomeComandos.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/setae.png")));
		lblNomeComandos.setForeground(new Color(255, 255, 255));
		lblNomeComandos.setVerticalAlignment(SwingConstants.TOP);
		lblNomeComandos.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 24));
		lblNomeComandos.setBounds(709, 545, 83, 43);
		contentPane.add(lblNomeComandos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//lado direito vai para direita
				lblbonecofrente.setVisible(false);
				lblbonecolado.setVisible(true);
				if(eixox != 877) {
					eixox += 50;
				}else {
					eixox = 877;
				}
				
				lblbonecolado.setBounds(  (eixox),  275, 153, 223);
				
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/setad.png")));
		lblNewLabel.setBounds(786, 534, 105, 66);
		contentPane.add(lblNewLabel);
		
		
	
		lblbonecolado.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/bonecos jogold.png")));
		lblbonecolado.setBounds(eixox, 275, 153, 223);
		contentPane.add(lblbonecolado);
		lblbonecolado.setVisible(false);
		
		lblbonecofrente.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/bonecojogo.png")));
		lblbonecofrente.setBounds(0, 275, 153, 223);
		contentPane.add(lblbonecofrente);
		
		
		JLabel lblseta = new JLabel("");
		lblseta.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/s1.gif")));
		lblseta.setBounds(924, 224, 36, 51);
		contentPane.add(lblseta);
		
		JLabel lblPontuacao = new JLabel(nick);
		lblPontuacao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPontuacao.setForeground(new Color(255, 255, 255));
		lblPontuacao.setBackground(new Color(0, 191, 255));
		lblPontuacao.setVerticalAlignment(SwingConstants.TOP);
		lblPontuacao.setFont(new Font("Arial Black", Font.BOLD, 40));
		lblPontuacao.setBounds(547, 175, 303, 51);
		contentPane.add(lblPontuacao);
		
		JLabel lblPontosDB = new JLabel(Integer.toString(pontos));
		lblPontosDB.setHorizontalAlignment(SwingConstants.CENTER);
		lblPontosDB.setForeground(new Color(255, 255, 255));
		lblPontosDB.setVerticalAlignment(SwingConstants.TOP);
		lblPontosDB.setFont(new Font("Arial Black", Font.BOLD, 40));
		lblPontosDB.setBounds(870, 175, 132, 51);
		contentPane.add(lblPontosDB);
		
		JLabel lblcenario = new JLabel("");
		lblcenario.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/cenarionv.jpeg")));
		lblcenario.setBounds(0, 0, 1100, 650);
		contentPane.add(lblcenario);
	}//fim construtor
}//fim classe
