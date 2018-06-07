package velasco.karen.view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AlumnoDeleteDlgV2 extends JDialog{

	private AlumnoDeleteListener listener;
	
	public AlumnoDeleteDlgV2(JFrame parent){
		
		super(parent, "Eliminar estudiante", true);
        super.setSize(400,150);
        super.setLocationRelativeTo(null);
        super.setLayout(new FlowLayout());
        Font fuente = new Font("Dialog", Font.BOLD, 14);
	
      //Custom button text
        Object[] options = {"Sí, estoy seguro.",
                            "No."};
        int n = JOptionPane.showOptionDialog(parent,
            "¿Está seguro que desea eliminar al estudiante? "
            ,
            "Importante.",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.WARNING_MESSAGE,
            null,
            options,
            options[1]);
        switch(n) {
        case 1:
        	listener.onBtnClick();
			AlumnoDeleteDlgV2.this.setVisible(false);
        	break;
        case 2:
        	AlumnoDeleteDlgV2.this.setVisible(false);
        }
        
	}

	public AlumnoDeleteListener getListener() {
		return listener;
	}

	public void setListener(AlumnoDeleteListener listener) {
		this.listener = listener;
	}
	
	
}
