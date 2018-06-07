package velasco.karen.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class OpcionesDlg extends JDialog{
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private OpcionesDlgListener listener;
	private Integer id;
	
	public OpcionesDlg(JFrame parent){
		super(parent, "Opciones", true);
		super.setSize(300,200);
        super.setLocationRelativeTo(null);
        super.setLayout(new FlowLayout());
        
        btnActualizar = new JButton("Actualizar datos");
        btnEliminar = new JButton("Eliminar estudiante");
        btnCancelar = new JButton("Cancelar");
        
        Dimension dimension = new Dimension(120,40);
        
        btnActualizar.setPreferredSize(dimension);
        btnEliminar.setPreferredSize(dimension);
        btnCancelar.setPreferredSize(dimension);
        
        btnActualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listener.onBtnClick(1);
			}
		});
        
        btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listener.onBtnClick(2);
			}
		});
        
        btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				OpcionesDlg.this.setVisible(false);
			}
		});
        super.add(btnActualizar);
        super.add(btnEliminar);
        super.add(btnCancelar);
	}
	
	public void setListener(OpcionesDlgListener listener) {
		this.listener = listener;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
