package velasco.karen.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ErrorDlg extends JDialog{
	private String datoFaltante;
	private JLabel lblError;
	private JButton btnOk;
	
	public ErrorDlg(JDialog parent) {
		super(parent, "Error", true);
        super.setSize(500,200);
//        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setLayout(new FlowLayout());
        
        Font fuente = new Font("Dialog", Font.BOLD, 16);
        
        lblError = new JLabel();
        
        lblError.setText("Debes ingresar los datos que se piden. ");
        
        btnOk = new JButton("Aceptar");
        btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ErrorDlg.this.setVisible(false);
			}
		});
        
        lblError.setPreferredSize(new Dimension(400,40));
        btnOk.setPreferredSize(new Dimension(120,40));
        
        lblError.setFont(fuente);
        btnOk.setFont(fuente);
        
      
        
        super.add(lblError);
    	super.add(btnOk);
	}

	public void setError() {
		
	}
	
	public String getDatoFaltante() {
		return datoFaltante;
	}

	public void setDatoFaltante(String datoFaltante) {
		System.out.println("Texto faltante : "+datoFaltante);
		this.datoFaltante = datoFaltante;
	}
	
	
}
