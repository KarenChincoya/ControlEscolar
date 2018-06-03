package velasco.karen.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlumnoInsertDlg extends JDialog{
	private JButton btnAceptar;
    private JButton btnCancelar;

    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblApellido1;
    private JLabel lblApellido2;
    private JLabel lblCarrera;
    
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtApellido1;
    private JTextField txtApellido2;
    
    private CalendarioPnl pnlCalendario;
    private CarrerasCombo comboCarreras;
    private AlumnoInsertListener listener;
    
    private JPanel pnlId;
    private JPanel pnlNombre;
    private JPanel pnlApellido1;
    private JPanel pnlApellido2;
    private JPanel pnlCarrera;
    private JPanel pnlBotones;
    
    public AlumnoInsertDlg(JFrame parent){
        super(parent, "Agregar estudiante", true);
        super.setSize(600,400);
//        super.setResizable(false);
        super.setLocationRelativeTo(null);
        
        super.setLayout(new FlowLayout());
        
        lblId = new JLabel("Id: ");
        lblNombre = new JLabel("Nombre: ");
        lblApellido1 = new JLabel("Apellido paterno: ");
        lblApellido2 = new JLabel("Apellido materno: ");
        lblCarrera = new JLabel("Carrera: ");
        
        txtId = new JTextField();
        txtNombre = new JTextField();
        txtApellido1 = new JTextField();
        txtApellido2 = new JTextField();
        
        lblId.setPreferredSize(new Dimension(130,30));
        lblNombre.setPreferredSize(new Dimension(130,30));
        lblApellido1.setPreferredSize(new Dimension(130,30));
        lblApellido2.setPreferredSize(new Dimension(130,30));
        lblCarrera.setPreferredSize(new Dimension(100,30));
        
        txtId.setPreferredSize(new Dimension(80,30));
        txtNombre.setPreferredSize(new Dimension(80,30));
        txtApellido1.setPreferredSize(new Dimension(80,30));
        txtApellido2.setPreferredSize(new Dimension(80,30));

        
        pnlId = new JPanel();
        pnlNombre = new JPanel();
        pnlApellido1 = new JPanel();
        pnlApellido2 = new JPanel();
        pnlCarrera = new JPanel();//numero
        
        pnlId.setLayout(new FlowLayout());
        pnlNombre.setLayout(new FlowLayout());
        pnlApellido1.setLayout(new FlowLayout());
        pnlApellido2.setLayout(new FlowLayout());
        pnlCarrera.setLayout(new FlowLayout());
        
        comboCarreras = new CarrerasCombo();
        
        pnlId.add(lblId); pnlId.add(txtId);
        pnlNombre.add(lblNombre); pnlNombre.add(txtNombre);
        pnlApellido1.add(lblApellido1); pnlApellido1.add(txtApellido1);
        pnlApellido2.add(lblApellido2); pnlApellido2.add(txtApellido2);
        pnlCarrera.add(lblCarrera);
        pnlCarrera.add(comboCarreras);
        
        pnlCalendario = new CalendarioPnl("Fecha de nacimiento");
        
        pnlBotones = new JPanel();
        pnlBotones.setLayout(new FlowLayout());
        
        btnAceptar = new JButton("Aceptar");
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("1. Dentro del Dlg");
            	String id = AlumnoInsertDlg.this.getTxtId().getText();
            	String nombre = AlumnoInsertDlg.this.getTxtNombre().getText();
            	String apellido1 = AlumnoInsertDlg.this.getTxtApellido1().getText();
            	String apellido2 = AlumnoInsertDlg.this.getTxtApellido2().getText();
            	String fecha = AlumnoInsertDlg.this.getPnlCalendario().getStringDate();
            	Integer carrera = AlumnoInsertDlg.this.getComboCarreras().getSelectedIndex();
            	
            	System.out.println("Dentro del dlg "+ id);
            	System.out.println("Dentro del dlg "+ nombre);
            	System.out.println("Dentro del dlg "+ apellido1);
            	System.out.println("Dentro del dlg "+apellido2);
            	System.out.println("Dentro del dlg "+fecha);
            	System.out.println("Dentro del dlg "+carrera);
            	
            	listener.onBtnClick(id, nombre, apellido1, apellido2, fecha, carrera);
            	
            	AlumnoInsertDlg.this.reset();
            	AlumnoInsertDlg.this.setVisible(false);
            }
        });
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	AlumnoInsertDlg.this.setVisible(false);
            
            }
        });
        
        btnAceptar.setPreferredSize(new Dimension(100,40));
        btnCancelar.setPreferredSize(new Dimension(100,40));
        pnlBotones.add(btnAceptar); pnlBotones.add(btnCancelar);
        
        super.add(pnlId);
        super.add(pnlNombre);
        super.add(pnlApellido1);
        super.add(pnlApellido2);
        super.add(pnlCarrera);
        super.add(pnlCalendario);
        super.add(pnlBotones);
    }
    
    public void mostrar(){
        txtId.setText("0");
        super.setVisible(true);
    }
    
    public void Modificar(String textito){
        txtId.setText("");
        super.setVisible(true);
    }

    public void setListener(AlumnoInsertListener listener){
    	System.out.println("Set listener");
        this.listener = listener;
    }

    
    public JTextField getTxtId() {
		return txtId;
	}


	public JTextField getTxtNombre() {
		return txtNombre;
	}


	public JTextField getTxtApellido1() {
		return txtApellido1;
	}

	public JTextField getTxtApellido2() {
		return txtApellido2;
	}

	public CalendarioPnl getPnlCalendario() {
		return pnlCalendario;
	}

	
	public void reset() {
    	this.txtId.setText("");
    	this.txtNombre.setText("");
    	this.txtApellido1.setText("");
    	this.txtApellido2.setText("");
    }

	public CarrerasCombo getComboCarreras() {
		return comboCarreras;
	}

	public void setComboCarreras(CarrerasCombo comboCarreras) {
		this.comboCarreras = comboCarreras;
	}
    
    /*public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setLayout(new BorderLayout());
        jframe.setSize(new Dimension(700,300));
        
        AlumnoInsertDlg dlgA = new AlumnoInsertDlg(jframe);
        
        JButton btn = new JButton("Agregar estudiante");
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
