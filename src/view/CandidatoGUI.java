package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JTable;




public class CandidatoGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JLabel lblCandidato;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblCargo;
	private JRadioButton rdbtnProfEnFund;
	private JRadioButton rdbtnProfEnMedio;
	private JRadioButton rdbtnProfEnSuperior;
	private JButton btnEnviar;
	private JButton btnLimpar;
	private ButtonGroup grupo;	
	private JTable table;
	private JSeparator separator;
	private JScrollPane scrollPaneCandidato;
	private DefaultTableModel modelo;
	private String cargo = "";
	
	
	
	
	public CandidatoGUI() {
		Handler ouvinte = new Handler();
		setTitle("CONCURSO - INSCRI\u00C7\u00C3O");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCandidato = new JLabel("INSCRI\u00C7\u00C3O DE CANDIDATO");
		lblCandidato.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCandidato.setBounds(70, 11, 164, 24);
		contentPane.add(lblCandidato);
		
		lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(70, 68, 46, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(70, 85, 180, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(70, 116, 46, 14);
		contentPane.add(lblCpf);
		
		textCPF = new JTextField();
		textCPF.setBounds(70, 141, 180, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		lblCargo = new JLabel("CARGO");
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCargo.setBounds(70, 172, 46, 14);
		contentPane.add(lblCargo);
		
		rdbtnProfEnFund = new JRadioButton("Professor Ensino Fundamental");
		rdbtnProfEnFund.setBounds(70, 199, 180, 23);
		contentPane.add(rdbtnProfEnFund);
		
		rdbtnProfEnMedio = new JRadioButton("Professor Ensino M\u00E9dio");
		rdbtnProfEnMedio.setBounds(70, 225, 164, 23);
		contentPane.add(rdbtnProfEnMedio);
		
		rdbtnProfEnSuperior = new JRadioButton("Professor Ensino Superior");
		rdbtnProfEnSuperior.setBounds(70, 251, 180, 23);
		contentPane.add(rdbtnProfEnSuperior);
		
		grupo = new ButtonGroup();
		grupo.add(rdbtnProfEnFund);
		grupo.add(rdbtnProfEnMedio);
		grupo.add(rdbtnProfEnSuperior);
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEnviar.setBounds(168, 293, 82, 23);
		btnEnviar.addActionListener(ouvinte);
		contentPane.add(btnEnviar);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.setBounds(70, 293, 82, 23);
		btnLimpar.addActionListener(ouvinte);
		contentPane.add(btnLimpar);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(294, 329, -295, 1);
		contentPane.add(horizontalStrut);
		
		separator = new JSeparator();
		separator.setBounds(-2, 327, 389, 3);
		contentPane.add(separator);
		
		definirJTable();
		scrollPaneCandidato = new JScrollPane(table);
		scrollPaneCandidato.setBounds(8, 342, 379, 115);
		getContentPane().add(scrollPaneCandidato);
		scrollPaneCandidato.setVisible(false);
		
		setVisible(true);		
		
	}
	
	public void limpar() {
		textNome.setText("");
		textCPF.setText("");
		grupo.clearSelection();
		
	}
	public void definirJTable() {
		modelo = new DefaultTableModel();
		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("Cargo");
		table = new JTable(modelo);
	}
	
	public void adicionaDados(String nome, String cpf, String cargo) {
		Object[] candidato = {nome, cpf, cargo};
		modelo.addRow(candidato);
	}
	
	public class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnLimpar) {
				limpar();
			}
			else {
				if(e.getSource()==btnEnviar) {
					String nome = textNome.getText();
					String cpf = textCPF.getText();					
					if(rdbtnProfEnFund.isSelected()) {
						 cargo = "Professor Ensino Fundamental";
					}
					else
						if(rdbtnProfEnMedio.isSelected()) {
							 cargo = 	"Professor Ensino Médio";						
						}
						else
							if(rdbtnProfEnSuperior.isSelected()) {
								cargo = "Professor Ensino Superior";
							}
					if((nome.equals(""))|| (cpf.equals("")) || ((rdbtnProfEnFund.isSelected()==false) && (rdbtnProfEnMedio.isSelected()==false)&&(rdbtnProfEnSuperior.isSelected()==false))) {
						JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!", "ATENÇÃO!!", 2, null);
					}
					else {										 
							JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!", "SUCESSO!!", 1, null);
							limpar();
							scrollPaneCandidato.setVisible(true);
							adicionaDados(nome, cpf, cargo);
							}					
						
					}
				}
			}
		}
	
}

