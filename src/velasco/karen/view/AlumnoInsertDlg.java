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
        
        pnlId.add(lblId); pnlId.add(txtId);
        pnlNombre.add(lblNombre); pnlNombre.add(txtNombre);
        pnlApellido1.add(lblApellido1); pnlApellido1.add(txtApellido1);
        pnlApellido2.add(lblApellido2); pnlApellido2.add(txtApellido2);
        pnlCarrera.add(lblCarrera);
        pnlCarrera.add(comboCarreras);
        
        pnlCalendario = new CalendarioPnl("Fecha de nacimiento");
        
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new FlowLayout());
        
        btnAceptar = new JButton("Aceptar");
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //listener.aceptarClickButton(edtTexto.getText());
                System.out.println("Dentro del dialog: "+pnlCalendario.getStringDate());
            	listener.onBtnClick();
                
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
        this.listener = listener;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JLabel getNoControl() {
        return lblId;
    }

    public void setNoControl(JLabel noControl) {
        this.lblId = noControl;
    }

    public JLabel getNombre() {
        return lblNombre;
    }

    public void setNombre(JLabel nombre) {
        this.lblNombre = nombre;
    }

    public JLabel getPaterno() {
        return lblApellido1;
    }

    public void setPaterno(JLabel paterno) {
        this.lblApellido1 = paterno;
    }

    public JLabel getMaterno() {
        return lblApellido2;
    }

    public void setMaterno(JLabel materno) {
        this.lblApellido2 = materno;
    }

    public void setCarrera(JLabel carrera) {
        this.lblCarrera = carrera;
    }

    public JTextField getNoControlInput() {
        return txtId;
    }

    public void setNoControlInput(JTextField noControlInput) {
        this.txtId = noControlInput;
    }

    public JTextField getNombreInput() {
        return txtNombre;
    }

    public void setNombreInput(JTextField nombreInput) {
        this.txtNombre = nombreInput;
    }

    public JTextField getPaternoInput() {
        return txtApellido1;
    }

    public void setPaternoInput(JTextField paternoInput) {
        this.txtApellido1 = paternoInput;
    }

    public JTextField getMaternoInput() {
        return txtApellido2;
    }

    public void setMaternoInput(JTextField maternoInput) {
        this.txtApellido2 = maternoInput;
    }

    public Integer getCarrera() {
    	return comboCarreras.getSelectedIndex();
    }
    public void reset() {
    	this.txtId.setText("");
    	this.txtNombre.setText("");
    	this.txtApellido1.setText("");
    	this.txtApellido2.setText("");
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
