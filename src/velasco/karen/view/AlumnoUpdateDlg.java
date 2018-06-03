package velasco.karen.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlumnoUpdateDlg extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblId;
	private JTextField txtId;
	private JButton btnId;
	private AlumnoUpdateListener listener;
	
	public AlumnoUpdateDlg(JFrame parent){
        super(parent, "Actualizar datos de estudiante", true);
        super.setSize(350,150);
        super.setLocationRelativeTo(null);
        super.setLayout(new FlowLayout());
        Font fuente = new Font("Dialog", Font.BOLD, 18);
        
        //primero preguntar el id del estudiante que modificara
        JPanel pnlId = new JPanel();
        pnlId.setLayout(new FlowLayout());
        
        lblId = new JLabel("Numero de control: ");
        txtId = new JTextField();
        btnId = new JButton("Actualizar");
        
        lblId.setFont(fuente);
        txtId.setPreferredSize(new Dimension(120,40));
        txtId.setFont(fuente);
        
        pnlId.add(lblId);
        pnlId.add(txtId);
        pnlId.add(btnId);
        
        btnId.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Integer num = Integer.valueOf(txtId.getText());
					listener.onBtnClick(num);
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("El dato debe ser un numero entero");
				}
				
			}
		});
        
        super.add(pnlId);
        super.add(btnId);
        super.setVisible(true);
	}
	
	public void setListener(AlumnoUpdateListener listener) {
		this.listener = listener;
	}
	
	/*public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setLayout(new BorderLayout());
        jframe.setSize(new Dimension(700,300));
        
        AlumnoUpdateDlg dlgA = new AlumnoUpdateDlg(jframe);
        
        JButton btn = new JButton("Actualizar");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dlgA.setVisible(true);
            }
        });
        
        jframe.add(btn);
        jframe.setVisible(true);
    }*/
}
