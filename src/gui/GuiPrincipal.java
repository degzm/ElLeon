package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import logic.AtletaCentralClass;
import logic.Excpt;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiPrincipal {

	private JFrame frmAtletas;

/**
* Lanza la aplicacion
*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiPrincipal window = new GuiPrincipal();
					window.frmAtletas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

/**
* Creea la aplicacion
*/
	public GuiPrincipal() {
		initialize();
	}

/**
* Inicia el contenido del frame
*/
	private void initialize() {
		
		AtletaCentralClass atlet = new AtletaCentralClass(5);
//Frame principal
		frmAtletas = new JFrame();
		frmAtletas.setUndecorated(true);
		frmAtletas.getContentPane().setBackground(new Color(220, 220, 220));
		frmAtletas.setTitle("Atletas");
		frmAtletas.setResizable(false);
		frmAtletas.setBounds(100, 100, 452, 266);
		frmAtletas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAtletas.getContentPane().setLayout(null);
//Texto atletas
		JLabel txtAtletas = new JLabel("\u00BFQue acci\u00F3n quieres hacer con los atletas?");
		txtAtletas.setHorizontalAlignment(SwingConstants.CENTER);
		txtAtletas.setFont(new Font("Calibri", Font.PLAIN, 21));
		txtAtletas.setBounds(10, 11, 430, 31);
		frmAtletas.getContentPane().add(txtAtletas);
//Boton nuevo atleta
		JButton btnNewAtleta = new JButton("Nuevo Atleta");
		btnNewAtleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atlet.alta();
			}
		});
		btnNewAtleta.setForeground(Color.BLACK);
		btnNewAtleta.setBackground(new Color(176, 196, 222));
		btnNewAtleta.setBounds(10, 53, 108, 31);
		frmAtletas.getContentPane().add(btnNewAtleta);		
//Boton dar de baja atleta
		JButton btnBajaAtleta = new JButton("Baja Atleta");
		btnBajaAtleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int np = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cual numero de atleta quieres borrar?"));
				atlet.baja(np);
			}
		});
		btnBajaAtleta.setForeground(Color.BLACK);
		btnBajaAtleta.setBackground(new Color(176, 196, 222));
		btnBajaAtleta.setBounds(10, 95, 108, 31);
		frmAtletas.getContentPane().add(btnBajaAtleta);
//Boton consultar atleta
		JButton btnConsultaAtleta = new JButton("Consulta");
		btnConsultaAtleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int np = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cual numero de atleta quieres consultar?"));
				try {
					atlet.consulta(np);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnConsultaAtleta.setForeground(Color.BLACK);
		btnConsultaAtleta.setBackground(new Color(176, 196, 222));
		btnConsultaAtleta.setBounds(10, 137, 108, 31);
		frmAtletas.getContentPane().add(btnConsultaAtleta);		
//Boton modificar atleta
		JButton btnModAtleta = new JButton("Modificaciones");
		btnModAtleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int np = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cual numero de atleta quieres modificar?"));
				try {
					atlet.cambio(np);
				} catch (Excpt e) {
					JOptionPane.showMessageDialog(null, "Ocurrio algo!", "Error.", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnModAtleta.setForeground(Color.BLACK);
		btnModAtleta.setBackground(new Color(176, 196, 222));
		btnModAtleta.setBounds(10, 179, 108, 31);
		frmAtletas.getContentPane().add(btnModAtleta);
//Boton enlistar atletas
		JButton btnListadoAtletas = new JButton("Listado");
		btnListadoAtletas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, atlet.toString());
			}
		});
		btnListadoAtletas.setForeground(Color.BLACK);
		btnListadoAtletas.setBackground(new Color(176, 196, 222));
		btnListadoAtletas.setBounds(10, 221, 108, 31);
		frmAtletas.getContentPane().add(btnListadoAtletas);		
//Boton para guardar
		JButton btnSave = new JButton("Guardar");
		btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atlet.guardar();
			}
		});
		btnSave.setForeground(Color.BLACK);
		btnSave.setBackground(new Color(176, 196, 222));
		btnSave.setBounds(334, 53, 108, 31);
		frmAtletas.getContentPane().add(btnSave);		
//Boton para cargar
		JButton btnLoad = new JButton("Cargar");
		btnLoad.setEnabled(false);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atlet.cargar();
			}
		});
		btnLoad.setForeground(Color.BLACK);
		btnLoad.setBackground(new Color(176, 196, 222));
		btnLoad.setBounds(332, 95, 108, 31);
		frmAtletas.getContentPane().add(btnLoad);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAtletas.dispose();
			}
		});
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setBackground(new Color(250, 128, 114));
		btnCerrar.setBounds(332, 221, 108, 31);
		frmAtletas.getContentPane().add(btnCerrar);
	}
}
