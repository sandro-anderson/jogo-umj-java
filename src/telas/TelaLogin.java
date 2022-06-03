package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.Jogador;
import DAO.Pontuacao;
import model.DAO.Jogador_DB;
import model.DAO.Pontuacao_DB;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtNick;
	private JPasswordField txtSenha;
	
	//TelaJogo telaJogo = new TelaJogo();
	
	//TelaIndex telaIndex = new TelaIndex();
	
	JLabel lblAvisoNick = new JLabel("Nick_Name / CPF Incorretos");
	JLabel lblSenhaIncorreta = new JLabel("Senha Incorreta");
	JLabel lblAvisoGeral = new JLabel("Entre com Nick__Name ou CPF");

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/logo02.png")));
		setTitle("LOGIN");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1100, 650);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(30, 144, 255));
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNick = new JLabel("NICK NAME:");
		lblNick.setBounds(198, 79, 318, 51);
		lblNick.setVerticalAlignment(SwingConstants.TOP);
		lblNick.setBackground(new Color(245, 245, 245));
		lblNick.setForeground(new Color(255, 255, 255));
		lblNick.setFont(new Font("Gill Sans Ultra Bold", Font.ITALIC, 40));
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setBounds(315, 148, 206, 51);
		lblSenha.setVerticalAlignment(SwingConstants.TOP);
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Gill Sans Ultra Bold", Font.ITALIC, 40));
		lblSenha.setBackground(new Color(245, 245, 245));
		
		txtNick = new JTextField();
		txtNick.setBounds(534, 84, 352, 41);
		txtNick.setForeground(new Color(0, 191, 255));
		txtNick.setBackground(Color.WHITE);
		txtNick.setFont(new Font("Gill Sans MT", Font.ITALIC, 40));
		txtNick.setColumns(10);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(362, 228, 352, 56);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//LEVA PARA A TELA DO JOGO 
				//setVisible(false);				
				//Jogador jogador = new Jogador();				
				//int aux =0;
				int id = 0;
				int pontos = 0;
				/*
				 * lblAvisoGeral.setVisible(false);
		lblSenhaIncorreta.setVisible(false);
		lblAvisoNick.setVisible(false);
				Jogador_DB jogadorD = new Jogador_DB();
				List<Jogador> listaJogador = new ArrayList<Jogador>();
				listaJogador =  jogadorD.listarLogin();
				*/
				
				
				
				if ( txtNick.getText().length() == 11    ) {
					id = ValidarLogin(id,txtNick.getText()); 
					if(id == -1 ) {
						lblAvisoNick.setVisible(true);
						//avisocpf incorreto
					}else {
						lblAvisoNick.setVisible(false);
						lblAvisoGeral.setVisible(false);
						//remove aviso e verifica senha
						id = ValidarSenha(id,txtSenha.getText());
						if( id== -1) {
							//senha errado e cpf certo
							lblAvisoGeral.setVisible(false);
							lblSenhaIncorreta.setVisible(true);
						}else {
							//entrou jogar id no banco e ir para a tela de jogo
							lblSenhaIncorreta.setVisible(false);
							setVisible(false);
							Pontuacao_DB pontuacaoDB = new Pontuacao_DB();
							List<Pontuacao> listaPontuacao = new ArrayList<Pontuacao>();
							listaPontuacao = pontuacaoDB.listarTodos();
							for (  int i =0; i < listaPontuacao.size() ; i++ ) {
								if ( id == listaPontuacao.get(i).getId_pontuacao() ) {
									pontos = listaPontuacao.get(i).getPontos();
								}
								
							}
							//pontos = listaPontuacao.get(id).getPontos();
							Jogador_DB jogadorD = new Jogador_DB();
							jogadorD.deleteAtual();
							jogadorD.inserirAtual(id, pontos);
							// fica a tela do jogo
							new  TelaJogo().setVisible(true);
							
						}
					}
				}
				else if( txtNick.getText().length() == 5   ) {
					id = ValidarNick(id, txtNick.getText());
					if(id == -1 ) {
						//aviso nick errado
						lblAvisoGeral.setVisible(false);
						lblAvisoNick.setVisible(true);
					}else {
						//NICK CERTO
						id = ValidarSenha(id,txtSenha.getText());
						if(id == -1 ) {
							//nick certo senha errada
							lblAvisoGeral.setVisible(false);
							lblSenhaIncorreta.setVisible(true);
							
						}
						else {
							//entrou nick e senha certos
							lblSenhaIncorreta.setVisible(false);
							Pontuacao_DB pontuacaoDB = new Pontuacao_DB();
							List<Pontuacao> listaPontuacao = new ArrayList<Pontuacao>();
							
							listaPontuacao = pontuacaoDB.listarTodos();
							for (  int i =0; i < listaPontuacao.size() ; i++ ) {
								if ( id == listaPontuacao.get(i).getId_pontuacao() ) {
									pontos = listaPontuacao.get(i).getPontos();
								}
								
							}

							Jogador_DB jogadorD = new Jogador_DB();
							jogadorD.deleteAtual();
							jogadorD.inserirAtual(id, pontos);
							//fica o iniciar do telajogo
							new  TelaJogo().setVisible(true);

							setVisible(false);
							
						}
					}
					
				}
				else {
					//aviso usuario e senha incorreto
					lblAvisoGeral.setVisible(true);
					
				}
								
			}
		});
		btnEntrar.setBackground(new Color(0, 191, 255));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setFont(new Font("Gill Sans Ultra Bold", Font.ITALIC, 40));
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBounds(167, 538, 352, 56);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 //LEVA PARA A TELA DE CADASTRO
				
				setVisible(false);
				try {
					//fica a tela de cadastro
					new TelaCadastro().setVisible(true);
					
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Gill Sans Ultra Bold", Font.ITALIC, 40));
		btnCadastrar.setBackground(new Color(0, 191, 255));
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(564, 538, 352, 56);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//volta para a tela de index
				
				setVisible(false);
				//tela index
				new TelaIndex().setVisible(true);

			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Gill Sans Ultra Bold", Font.ITALIC, 40));
		btnVoltar.setBackground(new Color(0, 191, 255));
		
		txtSenha = new JPasswordField();
		txtSenha.setBackground(new Color(255, 255, 255));
		txtSenha.setBounds(539, 148, 352, 43);
		txtSenha.setFont(new Font("Gill Sans MT", Font.ITALIC, 40));
		contentPane.setLayout(null);
		
		
		lblSenhaIncorreta.setBounds(895, 169, 183, 19);
		lblSenhaIncorreta.setForeground(Color.RED);
		lblSenhaIncorreta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblSenhaIncorreta);
		lblSenhaIncorreta.setVisible(false);
		lblAvisoGeral.setBackground(Color.YELLOW);
		
		
		lblAvisoGeral.setBounds(534, 54, 327, 19);
		lblAvisoGeral.setForeground(Color.RED);
		lblAvisoGeral.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblAvisoGeral);
		lblAvisoGeral.setVisible(false);
		
		
		lblAvisoNick.setBounds(888, 88, 186, 19);
		lblAvisoNick.setForeground(new Color(255, 0, 0));
		lblAvisoNick.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblAvisoNick);
		lblAvisoNick.setVisible(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/barra25.gif")));
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1.setBounds(503, 492, 581, 10);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/barra25.gif")));
		lblNewLabel_1.setBounds(10, 492, 571, 10);
		contentPane.add(lblNewLabel_1);
		contentPane.add(btnEntrar);
		contentPane.add(lblSenha);
		contentPane.add(txtSenha);
		contentPane.add(lblNick);
		contentPane.add(txtNick);
		contentPane.add(btnCadastrar);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/cenariogeral.jpeg")));
		lblNewLabel.setBounds(0, 0, 1100, 650);
		contentPane.add(lblNewLabel);
	}//fim construtor
	
	
	public int ValidarLogin(int id, String login) {
		
		Jogador_DB jogadorD = new Jogador_DB();
		List<Jogador> listaJogador = new ArrayList<Jogador>();
		listaJogador =  jogadorD.listarLogin();
		
		for (  int i =0; i < listaJogador.size() ; i++ ) {
			if( listaJogador.get(i).getCpf().equals(login)   ) {
				id = listaJogador.get(i).getId_jogador();
				return id;
			}
			
		}
		id = -1;
		
		return id;
	}
	
	
	public int ValidarNick(int id, String nick) {
		
		Jogador_DB jogadorD = new Jogador_DB();
		List<Jogador> listaJogador = new ArrayList<Jogador>();
		listaJogador =  jogadorD.listarLogin();
		
		for (  int i =0; i < listaJogador.size() ; i++ ) {
			if( listaJogador.get(i).getNick_name().equals(nick)   ) {
				
				id = listaJogador.get(i).getId_jogador();
				return id;
			}
			
		}
		id = -1;
		
		return id;
	}
	
	public int ValidarSenha(int id, String senha) {
		
		Jogador_DB jogadorD = new Jogador_DB();
		List<Jogador> listaJogador = new ArrayList<Jogador>();
		listaJogador =  jogadorD.listarLogin();
		
		for (  int i =0; i < listaJogador.size() ; i++ ) {
			
			if ( id == listaJogador.get(i).getId_jogador()   ) {
				if( listaJogador.get(i).getSenha() ==  Integer.parseInt(senha)  ) {
					id = listaJogador.get(i).getId_jogador();
					return id;
				}else {
					id = -1;
				}
				
			}
		}
		
		
		id = -1;
		
		
		return id;
	}
}
