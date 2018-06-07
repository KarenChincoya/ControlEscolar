package velasco.karen.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlumnoDeleteDlg extends JDialog{
	private JLabel lblBuscar;
	private JTextField txtBuscar;
	private JLabel lblIntrucciones;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private AlumnoDeleteListener listener;
	private JLabel lblConfirmacion;
	
	public AlumnoDeleteDlg(JFrame parent){
	        super(parent, "Eliminar estudiante", true);
	        super.setSize(550,200);
	        super.setLocationRelativeTo(null);
	        super.setLayout(new FlowLayout());
	        Font fuente = new Font("Dialog", Font.BOLD, 21);
	        
	        JPanel pnlBuscar = new JPanel();
	        pnlBuscar.setLayout(new FlowLayout());
	        
	        lblBuscar = new JLabel("Eliminar: ");
	        lblBuscar.setFont(fuente);
	        txtBuscar = new JTextField();
	        txtBuscar.setPreferredSize(new Dimension(170,40));
	        txtBuscar.setFont(fuente);
	        
	        pnlBuscar.add(lblBuscar);
	        pnlBuscar.add(txtBuscar);
	        
	        lblIntrucciones = new JLabel("Ingrese el numero de control del estudiante.");
	        lblIntrucciones.setFont(fuente);
	        
	        btnAceptar = new JButton("Eliminar");
	        
	       // btnAceptar.addActionListener(new ActionListener() {
			//	@Override
			//	public void actionPerformed(ActionEvent e) {
					lblConfirmacion = new JLabel("¿Está seguro que desea eliminar al estudiante?");
					lblConfirmacion.setFont(fuente);
					//castear el numero
					btnEliminar = new JButton("Sí");
					btnCancelar = new JButton("No");
					
					btnEliminar.setFont(fuente);
					btnCancelar.setFont(fuente);
					
					btnEliminar.setPreferredSize(new Dimension(120,40));
					btnCancelar.setPreferredSize(new Dimension(120,40));
					
					btnEliminar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							try {
								listener.onBtnClick();
								AlumnoDeleteDlg.this.setVisible(false);
							} catch (Exception e2) {
								// TODO: handle exception
								System.out.println("Debe ingresar un numero");
							}
						}
					});
					
					btnCancelar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							AlumnoDeleteDlg.this.setVisible(false);
						}
					});
					super.add(lblConfirmacion);
					super.add(btnEliminar);
					super.add(btnCancelar);
					
					AlumnoDeleteDlg.this.revalidate();
					AlumnoDeleteDlg.this.repaint();
		//		}
		//	});
	        
	     //   super.add(lblIntrucciones);
	     //   super.add(pnlBuscar);
	        
	 }
	
	public void setListener(AlumnoDeleteListener listener) {
		this.listener = listener;
	}
	public void reset() {
		this.txtBuscar.setText("");
	}
}
