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
	private JButton btn;
	private AlumnoDeleteListener listener;
	
	public AlumnoDeleteDlg(JFrame parent){
	        super(parent, "Eliminar estudiante", true);
	        super.setSize(400,150);
	        super.setLocationRelativeTo(null);
	        super.setLayout(new GridLayout(3, 1));
	        Font fuente = new Font("Dialog", Font.BOLD, 14);
	        
	        JPanel pnlBuscar = new JPanel();
	        pnlBuscar.setLayout(new FlowLayout());
	        
	        lblBuscar = new JLabel("Eliminar: ");
	        lblBuscar.setFont(fuente);
	        txtBuscar = new JTextField();
	        txtBuscar.setPreferredSize(new Dimension(120,40));
	        txtBuscar.setFont(fuente);
	        
	        pnlBuscar.add(lblBuscar);
	        pnlBuscar.add(txtBuscar);
	        
	        lblIntrucciones = new JLabel("Ingrese el numero de control del estudiante.");
	        lblIntrucciones.setFont(fuente);
	        
	        btn = new JButton("Eliminar");
	        btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//castear el numero
					try {
						Integer num = Integer.valueOf(txtBuscar.getText());
						listener.onBtnClick(num);
						AlumnoDeleteDlg.this.reset();
						AlumnoDeleteDlg.this.setVisible(false);
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println("Debe ingresar un numero");
					}
				}
			});
	        
	        super.add(lblIntrucciones);
	        super.add(pnlBuscar);
	        super.add(btn);
	 }
	
	public void setListener(AlumnoDeleteListener listener) {
		this.listener = listener;
	}
	public void reset() {
		this.txtBuscar.setText("");
	}
}
