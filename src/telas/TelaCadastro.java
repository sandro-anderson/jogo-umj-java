package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import DAO.Endereco;
import DAO.Jogador;
import DAO.Pontuacao;
import model.DAO.Endereco_DB;
import model.DAO.Jogador_DB;
import model.DAO.Pontuacao_DB;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import static java.lang.Integer.*;
import javax.swing.JOptionPane;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textEnd;
	private JTextField textNum;
	private JTextField textBairro;
	private JTextField textNick_name;
	private JPasswordField passwordSenha;
	
	String aux = "";
	
	
	JLabel lblAvisoNome = new JLabel("* NOME INVÁLIDO");
	JLabel lblAvisoEmail = new JLabel("* E-MAIL INVÁLIDO");
	JLabel lblAvisoCPF = new JLabel("* CPF INVÁLIDO");
	JLabel lblAvisoCELL = new JLabel("* CELULAR INVÁLIDO");
	JLabel lblAvisoNASC = new JLabel("* DATA INVÁLIDA");
	JLabel lblAvisoCEP = new JLabel("* CEP NÃO LOCALIZADO");
	JLabel lblNicknameCom = new JLabel("* Nick_Name ( 5  Digitos alfanumericos )                          \r\n* Senha ( 4 Digitos Numéricos )\r\n");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaCadastro() throws ParseException {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastro.class.getResource("/imagens/logo02.png")));
		setTitle("CADASTRO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1100, 650);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		
		//---------------------------------------------//
		
				lblAvisoNome.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblAvisoNome.setForeground(new Color(255, 0, 0));
				lblAvisoNome.setBounds(104, 72, 121, 14);
				contentPane.add(lblAvisoNome);
				lblAvisoNome.setVisible(false);
				
				
				lblAvisoEmail.setForeground(Color.RED);
				lblAvisoEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblAvisoEmail.setBounds(104, 138, 121, 14);
				contentPane.add(lblAvisoEmail);
				lblAvisoEmail.setVisible(false);
				
				lblAvisoCPF.setForeground(Color.RED);
				lblAvisoCPF.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblAvisoCPF.setBounds(626, 72, 121, 14);
				contentPane.add(lblAvisoCPF);
				lblAvisoCPF.setVisible(false);
				
				lblAvisoCELL.setForeground(Color.RED);
				lblAvisoCELL.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblAvisoCELL.setBounds(626, 139, 140, 14);
				contentPane.add(lblAvisoCELL);
				lblAvisoCELL.setVisible(false);
				
				lblAvisoNASC.setForeground(Color.RED);
				lblAvisoNASC.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblAvisoNASC.setBounds(161, 197, 140, 14);
				contentPane.add(lblAvisoNASC);
				lblAvisoNASC.setVisible(false);
				
				lblAvisoCEP.setForeground(Color.RED);
				lblAvisoCEP.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblAvisoCEP.setBounds(190, 322, 155, 14);
				contentPane.add(lblAvisoCEP);
				lblAvisoCEP.setVisible(false);
				
				lblNicknameCom.setToolTipText("");
				lblNicknameCom.setHorizontalAlignment(SwingConstants.LEFT);
				lblNicknameCom.setVerticalAlignment(SwingConstants.TOP);
				lblNicknameCom.setForeground(Color.RED);
				lblNicknameCom.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNicknameCom.setBounds(136, 466, 572, 28);
				contentPane.add(lblNicknameCom);
				lblNicknameCom.setVisible(false);
				
				//-------------------------------------------------------------//
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(35, 35, 65, 28);
		lblNome.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		
		textNome = new JTextField();
		textNome.setBounds(104, 31, 458, 37);
		textNome.setForeground(new Color(0, 0, 0));
		textNome.setBackground(new Color(255, 255, 255));
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(572, 35, 44, 28);
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		
		JFormattedTextField formattedTextCpf = new JFormattedTextField(new MaskFormatter("### . ### . ### - ##"));
		formattedTextCpf.setFont(new Font("Tahoma", Font.PLAIN, 25));
		formattedTextCpf.setBounds(626, 29, 244, 37);
		contentPane.add(formattedTextCpf);
		
		JLabel lblNasc = new JLabel("Nascimento:");
		lblNasc.setBounds(35, 169, 122, 28);
		lblNasc.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		
		JFormattedTextField formattedTextNasc = new JFormattedTextField(new MaskFormatter(" ## / ## / ####"));
		formattedTextNasc.setFont(new Font("Tahoma", Font.PLAIN, 25));
		formattedTextNasc.setBounds(161, 163, 184, 37);
		contentPane.add(formattedTextNasc);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(349, 169, 65, 28);
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSexo.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		
		textEmail = new JTextField();
		textEmail.setBounds(104, 97, 458, 37);
		textEmail.setForeground(Color.BLACK);
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textEmail.setColumns(10);
		textEmail.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		contentPane.add(lblNome);
		contentPane.add(textNome);
		contentPane.add(lblCpf);
		contentPane.add(lblNasc);
		contentPane.add(lblSexo);
		
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setBackground(new Color(255, 255, 255));
		comboBoxSexo.setBounds(424, 163, 53, 37);
		comboBoxSexo.setFont(new Font("Arial Black", Font.PLAIN, 25));
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		contentPane.add(comboBoxSexo);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblEmail.setBounds(35, 103, 65, 28);
		contentPane.add(lblEmail);
		contentPane.add(textEmail);
		
		JLabel lblCell = new JLabel("Cell:");
		lblCell.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCell.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblCell.setBounds(572, 103, 44, 28);
		contentPane.add(lblCell);
		
		JFormattedTextField formattedTextCell = new JFormattedTextField(new MaskFormatter("(##) # #### - ####"));
		formattedTextCell.setFont(new Font("Tahoma", Font.PLAIN, 25));
		formattedTextCell.setBounds(626, 97, 244, 37);
		contentPane.add(formattedTextCell);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 213, 858, 10);
		contentPane.add(separator);
		
		JLabel lblEnd = new JLabel("Endereço:");
		lblEnd.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblEnd.setBounds(35, 234, 106, 28);
		contentPane.add(lblEnd);
		
		textEnd = new JTextField();
		textEnd.setForeground(Color.BLACK);
		textEnd.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textEnd.setColumns(10);
		textEnd.setBackground(Color.WHITE);
		textEnd.setBounds(136, 225, 734, 37);
		contentPane.add(textEnd);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblCep.setBounds(136, 291, 44, 28);
		contentPane.add(lblCep);
		
		JFormattedTextField formattedTextCep = new JFormattedTextField(new MaskFormatter("##### - ###"));
		formattedTextCep.setFont(new Font("Tahoma", Font.PLAIN, 25));
		formattedTextCep.setBounds(190, 285, 173, 37);
		contentPane.add(formattedTextCep);
		
		JLabel lblNum = new JLabel("Nº:");
		lblNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNum.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblNum.setBounds(374, 291, 44, 28);
		contentPane.add(lblNum);
		
		textNum = new JTextField();
		textNum.setForeground(Color.BLACK);
		textNum.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textNum.setColumns(10);
		textNum.setBackground(Color.WHITE);
		textNum.setBounds(430, 285, 73, 37);
		contentPane.add(textNum);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblBairro.setBounds(531, 291, 73, 28);
		contentPane.add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setForeground(Color.BLACK);
		textBairro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textBairro.setColumns(10);
		textBairro.setBackground(Color.WHITE);
		textBairro.setBounds(607, 285, 263, 37);
		contentPane.add(textBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblCidade.setBounds(136, 356, 89, 28);
		contentPane.add(lblCidade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"São Paulo", "Rio de Janeiro", "Salvador", "Brasília", "Fortaleza", "Belo Horizonte", "Manaus", "Curitiba", "Recife", "Porto Alegre", "Belém", "Goiânia", "Guarulhos", "Campinas", "São Luís", "São Gonçalo", "Maceió", "Duque de Caxias", "Natal", "Campo Grande", "Arapiraca", "Rio Largo"}));
		comboBox.setBounds(221, 347, 282, 37);
		contentPane.add(comboBox);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblUf.setBounds(523, 354, 37, 28);
		contentPane.add(lblUf);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"SP", "RJ", "BA", "DF", "CE", "MG", "AM", "PR", "PE", "RS", "GO", "MA", "AL", "RN", "MS"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox_1.setBounds(560, 347, 310, 37);
		contentPane.add(comboBox_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 401, 860, 10);
		contentPane.add(separator_1);
		
		JLabel lblNickname = new JLabel("Nick_Name:");
		lblNickname.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblNickname.setBounds(136, 427, 122, 28);
		contentPane.add(lblNickname);
		
		textNick_name = new JTextField();
		textNick_name.setForeground(Color.BLACK);
		textNick_name.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textNick_name.setColumns(10);
		textNick_name.setBackground(Color.WHITE);
		textNick_name.setBounds(265, 418, 193, 37);
		contentPane.add(textNick_name);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblSenha.setBounds(482, 427, 73, 28);
		contentPane.add(lblSenha);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordSenha.setBounds(560, 418, 148, 37);
		contentPane.add(passwordSenha);
		
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*BOTAO CADASTRAR - primeiro verifica se os campos estao ok 
				 * estando ok, joga para o banco, tela cadastro some e tela login entra 
				 * - VAI PARA A TELA DE LOGIN  E SE FOR CONCLUIDO JOGAR OPTIONPANE DIZENDO CADASTRO FEITO
				*/
				int cont=0;
				//----------------------------------
				if ( formattedTextCpf.getText().replaceAll("[\\s()-.]", "").length() != 0  ) {	
					if( ValidarCPF( formattedTextCpf.getText().replaceAll("[\\s()-.]", "")  ) ) {
						cont++;
						lblAvisoCPF.setVisible(false);
					}else {
						lblAvisoCPF.setVisible(true);
					}
				}else { lblAvisoCPF.setVisible(true);   } 
				
				if (ValidarNOME(  textNome.getText().trim()  ) ) {
					cont++;
					lblAvisoNome.setVisible(false);
				}else {
					lblAvisoNome.setVisible(true);
				}
				
				if(ValidarEMAIL( textEmail.getText().trim()  )  ) {
					cont++;
					lblAvisoEmail.setVisible(false);
				}else {
					lblAvisoEmail.setVisible(true);
				}
				
				if ( formattedTextNasc.getText().replaceAll("[\\s()-./]", "").length() != 0  ) {
					if(ValidarNASC(formattedTextNasc.getText().replaceAll("[\\s()-./]", "")   )  ) {
						cont++;
						lblAvisoNASC.setVisible(false);
					}else {
						lblAvisoNASC.setVisible(true);
					}
				}else { lblAvisoNASC.setVisible(true);  } 
				
				if ( formattedTextCell.getText().replaceAll("[\\s()-]", "").length() != 0 ) {
					if( ValidarCELULAR(formattedTextCell.getText().replaceAll("[\\s()-]", "")   ) ) {
						cont++;
						lblAvisoCELL.setVisible(false);
					}else {
						lblAvisoCELL.setVisible(true);
					}
				
				}else { lblAvisoCELL.setVisible(true); } 
				
				if ( formattedTextCep.getText().replaceAll("[\\s()-]", "").length() != 0 ) {
					if(ValidarCEP( formattedTextCep.getText().replaceAll("[\\s()-]", "")  ) ) {
						cont++;
						lblAvisoCEP.setVisible(false);
					}else {
						lblAvisoCEP.setVisible(true);
					}
				
				}else {lblAvisoCEP.setVisible(true);  } 
				
				
				if(ValidarNICK(textNick_name.getText().trim().replace(" ", ""), passwordSenha.getText() ) ) {
					cont++;
					lblNicknameCom.setVisible(false);
				}else {
					lblNicknameCom.setVisible(true);
				}
				//----------------------------------			
				
				if(  cont == 7    ) {
					//todos corretos
					Jogador jogador = new Jogador();
					jogador.setNome(   textNome.getText().trim()    );
					jogador.setCpf(  formattedTextCpf.getText().replaceAll("[\\s()-.]", "")   );
					jogador.setNasc(  formattedTextNasc.getText().replaceAll("[\\s()-./]", "")   );
					jogador.setSexo( String.valueOf(comboBoxSexo.getSelectedItem()));    // comboBoxSexo.getSelectedItem()
					jogador.setEmail( textEmail.getText().trim()   );
					jogador.setCell(  formattedTextCell.getText().replaceAll("[\\s()-]", "")    );
					jogador.setNick_name( textNick_name.getText().trim()   );
					jogador.setSenha(Integer.parseInt(passwordSenha.getText()));
					Jogador_DB jogadorDB = new Jogador_DB();
					jogadorDB.inserir(jogador);
					
					Endereco endereco = new Endereco();
					endereco.setCep(  formattedTextCep.getText().replaceAll("[\\s()-]", "")  );
					endereco.setNum( textNum.getText().trim() );
					endereco.setEnd( textEnd.getText().trim() );
					endereco.setBairro( textBairro.getText().trim() );
					endereco.setCidade( String.valueOf( comboBox.getSelectedItem())  );
					endereco.setEstado( String.valueOf( comboBox_1.getSelectedItem())  );
					Endereco_DB enderecoDB = new Endereco_DB();
					enderecoDB.inserir(endereco);
					
					
					Pontuacao pontuacao = new Pontuacao();
					pontuacao.setPontos(0);
					Pontuacao_DB pontuacaoDB = new Pontuacao_DB();
					pontuacaoDB.inserir(pontuacao);
					
					JOptionPane.showMessageDialog(null,"CADASTRO FEITO COM SUCESSO");
					
					setVisible(false);
					new TelaLogin().setVisible(true);					
				}else {
					//algum errad
				}
				
				/*
				
				
				jogador.setNome(textNome.getText());
				jogador.setCpf(formattedTextCpf.getText());
				jogador.setNasc(formattedTextNasc.getText());
				jogador.setSexo(String.valueOf(comboBoxSexo.getSelectedItem()));    // comboBoxSexo.getSelectedItem()
				jogador.setEmail(textEmail.getText());
				jogador.setCell(formattedTextCell.getText());
				jogador.setNick_name(textNick_name.getText());
				jogador.setSenha(Integer.parseInt(passwordSenha.getText()));
				
				
				
				System.out.println("OK adicionado");
				System.out.println(textNome.getText().trim());
				aux = formattedTextCpf.getText().replaceAll("[\\s()-.]", "");
				System.out.println(formattedTextCpf.getText());
				System.out.println(aux);
				System.out.println(aux.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d"));
				System.out.println(formattedTextNasc.getText());
				aux = formattedTextNasc.getText().replaceAll("[\\s()-./]", "");
				System.out.println(aux);
				System.out.println(comboBoxSexo.getSelectedItem());//certo
				System.out.println();
				aux = formattedTextCell.getText().replaceAll("[\\s()-]", "");
				System.out.println(formattedTextCell.getText() );
				System.out.println(aux);
				System.out.println(textNick_name.getText().trim() );
				System.out.println(passwordSenha.getText() );
				*/
				
				
				
				
				
			}//fim da açao botao cadastro
		});
		btnCadastrar.setBackground(new Color(0, 191, 255));
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Gill Sans Ultra Bold", Font.ITALIC, 40));
		btnCadastrar.setBounds(35, 533, 365, 48);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// BOTÃO BOLTAR - VAI PARA A TELA DE LOGIN
				setVisible(false);
				new TelaLogin().setVisible(true);

			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Gill Sans Ultra Bold", Font.ITALIC, 40));
		btnVoltar.setBackground(new Color(0, 191, 255));
		btnVoltar.setBounds(477, 533, 365, 48);
		contentPane.add(btnVoltar);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//fim do construtor
	
	
	
	
public boolean ValidarCPF(String cpf) {
	int soma =0;
	
	
	Jogador_DB jogadorD = new Jogador_DB();
	List<Jogador> listaJogador = new ArrayList<Jogador>();
	listaJogador =  jogadorD.listarLogin();
	
	for (  int i =0; i < listaJogador.size() ; i++ ) { //verifica se tem o cpf no banco de dados, para não colocar duplicado
		if( listaJogador.get(i).getCpf().equals(cpf)   ) {
			return false;
		}
		
	}
	
		
	if( cpf.length()  != 11 ||  cpf.equals("00000000000")  || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") ) {
		return false;
	}
		
	for (int i = 0, j=10; i < 9 ; i++) {
		soma += Integer.parseInt(cpf.substring( i ,(i+1))) * j;
		j--;
	}
	soma = ( soma * 10) % 11;
	if ( soma == 10 || soma == 11) {soma = 0;}
	if( soma != Integer.parseInt(cpf.substring(9, 10) )   ) {
		return false;
	}
	soma =0;
	for(int i =0, j=11; i<10; i++) {
		soma += Integer.parseInt(cpf.substring( i ,(i+1))) * j;
		j--;
	}
	soma = ( soma * 10) % 11;
	if ( soma == 10 || soma == 11) {soma = 0;}
	if( soma != Integer.parseInt(cpf.substring(10) )   ) {
		return false;
	}else { 
		return true;
	}
	
	}//fim validarcpf
	
public boolean ValidarNASC(String nasc ) {
	
	if (  Integer.parseInt(nasc.substring(0, 1) )  == 0 || Integer.parseInt(nasc.substring(0, 1) ) == 1 || Integer.parseInt(nasc.substring(0, 1) ) == 2 || Integer.parseInt(nasc.substring(0, 1) ) ==3 ) {
		if( Integer.parseInt(nasc.substring(0, 2)) > 31 || Integer.parseInt(nasc.substring(0, 2) ) == 00  ) {return false; }
		
	}else {
		return false;
	}
	
	if(Integer.parseInt(nasc.substring(2,3) ) == 0 || Integer.parseInt(nasc.substring(2,3) )  == 1 ) {
		if( Integer.parseInt(nasc.substring(2, 4)) > 12  ||    Integer.parseInt(nasc.substring(2,4))  == 00 ) {return false; }
	}else {
		return false;
		}
	
	if ( Integer.parseInt(nasc.substring(4)) < 1910  || Integer.parseInt(nasc.substring(4)) > 2022 ) {return false; } 
	
	
	return true;
	}//fim validarnasc
	
public boolean ValidarCEP(String cep ) {
	if( Integer.parseInt(cep.substring(0,5)) > 57999 || Integer.parseInt(cep.substring(0,5)) < 50000 ) { return false;}
	
	
	return true;
}//fim validarcep

public boolean ValidarNOME(String nome) {
	//System.out.println( nome1.matches("\\D+") ); busca tudo menos numerico retorna falso - se tiver numero retorna falso
   // System.out.println( nome1.matches("[^0-9]+") ); 
	//System.out.println( nome1.matches("\\w+") ); se tudo for letra ele retorna verdadeiro
	
	if( nome.length() > 45 || nome.length() < 6) {return false; }
	String aux;
	aux = nome.replace(" ", "");
	if( aux.matches("\\D+") ) { // verifico se tem numero
		if(aux.matches("\\w+")) { // verifico se tudo é letra
			return true;
		}else {
			return false;
		}
	}else {
		return false;
	}
	
}//fim validarNOME



public boolean ValidarNICK(String nick, String senha) {
	
	Jogador_DB jogadorD = new Jogador_DB();
	List<Jogador> listaJogador = new ArrayList<Jogador>();
	listaJogador =  jogadorD.listarLogin();
	
	for (  int i =0; i < listaJogador.size() ; i++ ) { //verifica se ja tem o nick no banco de dados
		if( listaJogador.get(i).getNick_name().equals(nick)   ) {
			return false;
		}
		
	}
	
	if( nick.length() == 5 && senha.length() == 4 ) {
		if(senha.matches("\\d+")) {
			return true;
		}
		else {
			return false;
		}
	}else {
		return false;
	}

}//fim validarNICK


public boolean ValidarCELULAR(String cell) {
	if( cell.length() < 11 ) { return false;}
	
	if( Integer.parseInt(cell.substring(2, 3)) != 9 ) { return false;}
	
	int[] ddd = {71,73,74,75,77,81,82,85,88,98,99,83,87,86,89,84,79}; //17
	int[] pre = { 67,71,72,95,96,97,98,99,68,73,74,75,76,91,92,93,94,69,79,80,81,82,83,84,85,86,87,88,89};//29
	
    for ( int i = 0; i < 17 ; i ++) {
    	if ( Integer.parseInt(cell.substring(0, 2)) == ddd[i] ) {
    		for( int j=0; j < 29; j++) {
    			if( Integer.parseInt(cell.substring(3, 5)) == pre[j] ) {
    				return true;
    			}
    		}
    		return false;
    	}
    }
	
	
	return false;
}//fim validarCELULAR

public boolean ValidarEMAIL(String email) {
	if( email.length() > 40 ) { return false;}
	if(email.contains("@")) {
		
	}else {
		return false;
	}
	if( email.matches(".*\\.com$")  ) {
		
	}else {
		return false;
	}
	int aux=0;
	for ( int i =0; i < email.length(); i++) {
		if (email.charAt(i) == '@') {
			aux = i;
			break;
		}
	}
	if( email.substring(0, (aux)).contains("@")) {return false;}
		
	if ( email.substring(0, (aux)).matches( "[a-z_0-9]+"  )){ // verifica espaço e se tem outro caracter 
		
	}else {
		return false;
	}
	if ( email.substring((aux + 1)).equals("hotmail.com")   || email.substring((aux + 1)).equals("gmail.com")  ||  email.substring((aux + 1)).equals("outlook.com")  ||  email.substring((aux + 1)).equals("yahoo.com")  ||  email.substring((aux + 1)).equals("live.com")  ) {
		return true;
	}
	
	
	
	
	return false;
}//fim validarEMAIL

	
	
}//fim
