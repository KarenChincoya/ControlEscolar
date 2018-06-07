package velasco.karen.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EncabezadoPnl extends JPanel{
	private JLabel lblInstrucciones;
	private LogoPnl pnlLogo;
	private JLabel lblEstudiantes;
	private EncabezadoListener listener;
	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnBuscar;
	private JButton btnEliminar ;
	private JButton btnReset;
	private JPanel pnl1;
	private JPanel pnl2;
	
	public EncabezadoPnl() {
		super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Font fuente = new Font("Dialog", Font.BOLD, 18);
		Font fuente2 = new Font("Dialog", Font.BOLD, 14);
		
		lblInstrucciones = new JLabel("Universidad La Salle Oaxaca");
		lblInstrucciones.setFont(fuente);
		pnlLogo = new LogoPnl();
		
		lblEstudiantes = new JLabel("Operaciones con los estudiantes: ");
		lblEstudiantes.setFont(fuente2);
		
		pnl1 = new JPanel();
		pnl2 = new JPanel();
		
		pnl1.setLayout(new FlowLayout());
		pnl2.setLayout(new FlowLayout());
		
		btnAgregar = new JButton("Agregar");
		btnActualizar = new JButton("Actualizar");
		btnBuscar = new JButton("Buscar");
		btnEliminar = new JButton("Eliminar");
		btnReset = new JButton("Reset");
		
		btnAgregar.setPreferredSize(new Dimension(120,40));
		btnActualizar.setPreferredSize(new Dimension(120,40));
		btnBuscar.setPreferredSize(new Dimension(120,40));
		btnEliminar.setPreferredSize(new Dimension(120,40));
		btnReset.setPreferredSize(new Dimension(120,40));
		
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Encabezado: agregar");
				listener.onBtnClick(1);
			}
		});
		btnActualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listener.onBtnClick(2);
			}
		});
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listener.onBtnClick(4);
			}
		});
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listener.onBtnClick(3);
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listener.onBtnClick(5);
			}
		});
		
		pnl1.add(lblInstrucciones);
		pnl1.add(pnlLogo);
		
		pnl2.add(btnAgregar);
		pnl2.add(btnActualizar);
		pnl2.add(btnBuscar);
		pnl2.add(btnEliminar);
		pnl2.add(btnReset);
		
		super.add(pnl1);
		super.add(lblEstudiantes);
		super.add(pnl2);
	}

	public EncabezadoListener getListener() {
		return listener;
	}

	public void setListener(EncabezadoListener listener) {
		this.listener = listener;
	}
	
	
}
