package velasco.karen.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import velasco.karen.DAO.AlumnoDAO;
import velasco.karen.objects.Alumno;

public class AlumnoSelectDlg extends JDialog{
	private JLabel lblBuscar;
	private JTextField txtBuscar;
	private JLabel lblIntrucciones;
	private JButton btn;
	private AlumnoSelectListener listener;
	
	public AlumnoSelectDlg(JFrame parent){
	        super(parent, "Buscar estudiante", true);
	        super.setSize(350,150);
	        super.setLocationRelativeTo(null);
	        super.setLayout(new GridLayout(3, 1));
	        Font fuente = new Font("Dialog", Font.BOLD, 18);
	        
	        JPanel pnlBuscar = new JPanel();
	        pnlBuscar.setLayout(new FlowLayout());
	        
	        lblBuscar = new JLabel("Buscar: ");
	        lblBuscar.setFont(fuente);
	        txtBuscar = new JTextField();
	        txtBuscar.setPreferredSize(new Dimension(120,40));
	        txtBuscar.setFont(fuente);
	        
	        pnlBuscar.add(lblBuscar);
	        pnlBuscar.add(txtBuscar);
	        
	        lblIntrucciones = new JLabel("Puede buscar por id, nombre y/o apellido.");
	        
	        btn = new JButton("Buscar");
//	        btn.setPreferredSize(new Dimension(50,15));
	        
	        btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String buscar = AlumnoSelectDlg.this.getTxtBuscar().getText();
					listener.onBtnClick(buscar);
					AlumnoSelectDlg.this.reset();
					AlumnoSelectDlg.this.setVisible(false);
				}
			});
	        
	        super.add(pnlBuscar);
	        super.add(btn);
	        super.add(lblIntrucciones);
	 }
	
	public void setListener(AlumnoSelectListener listener) {
		this.listener = listener;
	}

	public JTextField getTxtBuscar() {
		return txtBuscar;
	}

	public void setTxtBuscar(JTextField txtBuscar) {
		this.txtBuscar = txtBuscar;
	}
	
	public void reset() {
		this.getTxtBuscar().setText("");
	}
	
	
	/*public static void main(String[] args) {
		JFrame frame = new JFrame("Tabla");
		frame.setLayout(new BorderLayout());
		frame.setSize(1000, 500);
		JButton btn = new JButton("OK");
		
		AlumnoSelectDlg dlgSelect = new AlumnoSelectDlg(frame);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dlgSelect.setVisible(true);
			}
		});
		
		frame.add(btn, BorderLayout.SOUTH);
		frame.setVisible(true);
	}*/
}