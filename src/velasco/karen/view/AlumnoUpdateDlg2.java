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

import velasco.karen.DAO.AlumnoDAO;
import velasco.karen.objects.Alumno;

public class AlumnoUpdateDlg2 extends JDialog{
	private JButton btnAceptar;
    private JButton btnCancelar;

    private JLabel lblInstrucciones;
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
    private AlumnoUpdateListener2 listener;
    
    private String fechaAnterior;
    private Integer carreraAnterior;
    
    public AlumnoUpdateDlg2(JFrame parent, Alumno alumno){
        super(parent, "Actualizar datos del estudiante "+alumno.getId(), true);
        super.setSize(600,400);
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

        //Asignar los datos
        txtId.setText(String.valueOf(alumno.getId()));
        txtId.setEditable(false);
        txtNombre.setText(alumno.getNombre());
        txtApellido1.setText(alumno.getApellido1());
        txtApellido2.setText(alumno.getApellido2());
        
        JPanel pnlId = new JPanel();
        JPanel pnlNombre = new JPanel();
        JPanel pnlApellido1 = new JPanel();
        JPanel pnlApellido2 = new JPanel();
        JPanel pnlCarrera = new JPanel();//numero
        
        pnlId.setLayout(new FlowLayout());
        pnlNombre.setLayout(new FlowLayout());
        pnlApellido1.setLayout(new FlowLayout());
        pnlApellido2.setLayout(new FlowLayout());
        pnlCarrera.setLayout(new FlowLayout());
        
        comboCarreras = new CarrerasCombo();
        comboCarreras.setSelectedIndex(alumno.getCarrera().getId());
        
        pnlId.add(lblId); pnlId.add(txtId);
        pnlNombre.add(lblNombre); pnlNombre.add(txtNombre);
        pnlApellido1.add(lblApellido1); pnlApellido1.add(txtApellido1);
        pnlApellido2.add(lblApellido2); pnlApellido2.add(txtApellido2);
        pnlCarrera.add(lblCarrera);
        pnlCarrera.add(comboCarreras);
        
        this.carreraAnterior = alumno.getCarrera().getId();
        this.fechaAnterior = alumno.getFechaNacimiento().toString();
        System.out.println("Fecha anterior: "+this.fechaAnterior);
        
        pnlCalendario = new CalendarioPnl("Fecha de nacimiento");
        
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new FlowLayout());
        
        btnAceptar = new JButton("Aceptar");
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //listener.aceptarClickButton(edtTexto.getText());
                System.out.println("Dentro del dialog: "+pnlCalendario.getStringDate());
                
                String id = AlumnoUpdateDlg2.this.getTxtId().getText();
            	String nombre = AlumnoUpdateDlg2.this.getTxtNombre().getText();
            	String apellido1 = AlumnoUpdateDlg2.this.getTxtApellido1().getText();
            	String apellido2 = AlumnoUpdateDlg2.this.getTxtApellido2().getText();
            	
            	String fechaEnviar = null;
            	String fecha = AlumnoUpdateDlg2.this.getPnlCalendario().getStringDate();
            	if(fecha==null) {
            		fechaEnviar = AlumnoUpdateDlg2.this.getFechaAnterior();
            	}else {
            		fechaEnviar = fecha;
            	}
            	
            	Integer carreraEnviar = null;
            	Integer carrera = AlumnoUpdateDlg2.this.getComboCarreras().getSelectedIndex();
            	if(carreraEnviar==null) {
            		carreraEnviar = AlumnoUpdateDlg2.this.getCarreraAnterior();
            	}
            	
                listener.onBtnClick(id, nombre, apellido1, apellido2, fechaEnviar, carreraEnviar);
                
                AlumnoUpdateDlg2.this.setVisible(false);
                
            }
        });
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	AlumnoUpdateDlg2.this.setVisible(false);
            
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

    public void setListener(AlumnoUpdateListener2 listener){
        this.listener = listener;
    }

    
    public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido1() {
		return txtApellido1;
	}

	public void setTxtApellido1(JTextField txtApellido1) {
		this.txtApellido1 = txtApellido1;
	}

	public JTextField getTxtApellido2() {
		return txtApellido2;
	}

	public void setTxtApellido2(JTextField txtApellido2) {
		this.txtApellido2 = txtApellido2;
	}

	public CalendarioPnl getPnlCalendario() {
		return pnlCalendario;
	}

	public void setPnlCalendario(CalendarioPnl pnlCalendario) {
		this.pnlCalendario = pnlCalendario;
	}

	public CarrerasCombo getComboCarreras() {
		return comboCarreras;
	}

	public void setComboCarreras(CarrerasCombo comboCarreras) {
		this.comboCarreras = comboCarreras;
	}

	public void reset() {
    	this.txtId.setText("");
    	this.txtNombre.setText("");
    	this.txtApellido1.setText("");
    	this.txtApellido2.setText("");
    }

	public String getFechaAnterior() {
		return fechaAnterior;
	}

	public void setFechaAnterior(String fechaAnterior) {
		this.fechaAnterior = fechaAnterior;
	}

	public Integer getCarreraAnterior() {
		return carreraAnterior;
	}

	public void setCarreraAnterior(Integer carreraAnterior) {
		this.carreraAnterior = carreraAnterior;
	}
	
    
    /*public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setLayout(new BorderLayout());
        jframe.setSize(new Dimension(700,300));
        
        AlumnoDAO daoAlumno = new AlumnoDAO();
        Alumno alumno = daoAlumno.getAlumnos("").get(0);
        
        AlumnoUpdateDlg2 dlgA = new AlumnoUpdateDlg2(jframe, alumno);
        
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
