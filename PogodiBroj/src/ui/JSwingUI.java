package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enums.Enumerations;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JSwingUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUnosGGranice;
	private JTextField txtUnosPokusaj;
	private JTextField txtIspis;
	private JTextField txtBrPokusaja;
	protected classes.PogodiBroj PogodiBroj;
	private JTextField txtPoeni;

	/**
	 * Create the frame.
	 */
	public JSwingUI() {
		frame();
		this.PogodiBroj = new classes.PogodiBroj();
	}
	
	private void frame() {
		setTitle("Pogodi Broj");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblGGranica = new JLabel("Unesite broj za gornju granicu:");
		lblGGranica.setBounds(10, 25, 264, 26);
		contentPane.add(lblGGranica);
		
		txtUnosGGranice = new JTextField();
		txtUnosGGranice.setBounds(245, 25, 228, 26);
		contentPane.add(txtUnosGGranice);
		txtUnosGGranice.setColumns(10);
		
		JButton btnGenerisiBr = new JButton("Generisi Broj");
		btnGenerisiBr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PogodiBroj.setX(Integer.parseInt(txtUnosGGranice.getText()));
				PogodiBroj.Generisi();
				PogodiBroj.BrPokusaja();
				PogodiBroj.BrPoena();
			}
		});
		btnGenerisiBr.setBounds(480, 27, 151, 23);
		contentPane.add(btnGenerisiBr);
		
		JLabel lblPokusaj = new JLabel("Unesite broj za pokusaj: ");
		lblPokusaj.setBounds(10, 93, 197, 26);
		contentPane.add(lblPokusaj);
		
		txtUnosPokusaj = new JTextField();
		txtUnosPokusaj.setBounds(197, 89, 113, 34);
		contentPane.add(txtUnosPokusaj);
		txtUnosPokusaj.setColumns(10);
		
		JButton btnPokusaj = new JButton("Proveri");
		btnPokusaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PogodiBroj.setZ(Integer.parseInt(txtUnosPokusaj.getText()));
				PogodiBroj.Pokusaj();//vece,manje,jednako
				txtIspis.setText(String.valueOf(PogodiBroj.getOdnos()));
			
				txtPoeni.setText(String.valueOf(PogodiBroj.getP()));
				txtBrPokusaja.setText(String.valueOf(PogodiBroj.getQ()));
				
				PogodiBroj.setQ(PogodiBroj.getQ()-1);
				PogodiBroj.setP(PogodiBroj.getP()-100);
				int neca=PogodiBroj.getY();
				if(PogodiBroj.getQ() <0) {
					
					txtIspis.setText(String.valueOf(PogodiBroj.getY())); 
					JOptionPane.showMessageDialog(null, "Trazeni broj je " + neca);
					System.exit(0);
				}
				
				if(PogodiBroj.getZ()==PogodiBroj.getY())
				{
					
					JOptionPane.showMessageDialog(null, "Pogodili ste!! Cestitam!!");
					System.exit(0);
				}
				
			}
		});
		btnPokusaj.setBounds(329, 95, 113, 23);
		contentPane.add(btnPokusaj);
		
		JLabel lvlVas1 = new JLabel("Vas broj je:");
		lvlVas1.setBounds(10, 154, 151, 14);
		contentPane.add(lvlVas1);
		
		txtIspis = new JTextField();
		txtIspis.setEditable(false);
		txtIspis.setBounds(134, 151, 86, 20);
		contentPane.add(txtIspis);
		txtIspis.setColumns(10);
		
		JLabel lblVas2 = new JLabel("od trazenog.");
		lblVas2.setBounds(229, 154, 141, 14);
		contentPane.add(lblVas2);
		
		JLabel lblPreostalo1 = new JLabel("Preostalo Vam je jos:");
		lblPreostalo1.setBounds(10, 179, 210, 14);
		contentPane.add(lblPreostalo1);
		
		txtBrPokusaja = new JTextField();
		txtBrPokusaja.setEditable(false);
		txtBrPokusaja.setBounds(225, 176, 93, 20);
		contentPane.add(txtBrPokusaja);
		txtBrPokusaja.setColumns(10);
		
		JLabel lblPokusaj2 = new JLabel("pokusaja.");
		lblPokusaj2.setBounds(322, 184, 76, 14);
		contentPane.add(lblPokusaj2);
		
		JLabel lblPoeni = new JLabel("POENI");
		lblPoeni.setBounds(10, 234, 69, 20);
		contentPane.add(lblPoeni);
		
		txtPoeni = new JTextField();
		txtPoeni.setEditable(false);
		txtPoeni.setBounds(70, 231, 146, 26);
		contentPane.add(txtPoeni);
		txtPoeni.setColumns(10);
	}
}