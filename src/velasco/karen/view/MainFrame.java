package velasco.karen.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	AlumnoInsertDlg dlgEstudiante; 
	
	public MainFrame() {
		super("Universidad La Salle Oaxaca");
	    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    super.setLayout(new BorderLayout());
	    super.setSize(500, 500);
	    
	    super.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
