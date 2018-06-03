package velasco.karen.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import velasco.karen.DAO.AlumnoDAO;
import velasco.karen.objects.Alumno;

public class AlumnoTabla extends JPanel implements TableModelListener{
	private ArrayList<Alumno> oAlumnos;
	private ArrayList<String> columnas;
	private JTable table;
	private AlumnoTableModel alumnoTableModel;
	
	public AlumnoTabla(ArrayList<Alumno> Alumnos){
        super();
        //super.setSize(500, 500);
        this.oAlumnos = Alumnos;
        
        alumnoTableModel = new AlumnoTableModel(oAlumnos);
        alumnoTableModel.fireTableDataChanged();
        
        table = new JTable(alumnoTableModel);
        table.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Cambios en la tabla");
				table.revalidate();
				table.repaint();
			}
		});
        
        JScrollPane scrollPane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 300));
        table.setFillsViewportHeight(true);
        
        table.getModel().addTableModelListener(this);
        
        super.add(scrollPane);
    }
	
	public ArrayList<Alumno> getoAlumnos() {
		return oAlumnos;
	}

	public void setoAlumnos(ArrayList<Alumno> nueva) {
		this.oAlumnos = nueva;
		this.alumnoTableModel.setoAlumnos(nueva);
	}

	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getType());
    }

	
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	/*public static void main(String[] args) {
		AlumnoDAO daoAlumno = new AlumnoDAO();
		ArrayList<Alumno> alumnos;
		alumnos = daoAlumno.getAlumnos("");
		
		AlumnoTabla tablaAlumno = new AlumnoTabla(alumnos);
		
		for(int i=0; i<alumnos.size(); i++) {
			System.out.println("id "+i+" : "+alumnos.get(i).getId());
			System.out.println("Nombre "+i+" : "+alumnos.get(i).getNombre());
			System.out.println();
		}
		
		JFrame frame = new JFrame("Tabla");
		frame.setLayout(new BorderLayout());
		frame.setSize(1000, 500);
		JButton btn = new JButton("OK");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Date date = new Date(1995, 11, 9);
				Date date = new Date(1997,03,26);
				
				
				//System.out.println("Date: "+date.toString());
				//daoAlumno.insertData(7, "Metzli", "Torres", "Amaya", 13, date);
				
				ArrayList<Alumno> nueva= daoAlumno.getAlumnos("Karen");
				
				tablaAlumno.setoAlumnos(nueva);
				tablaAlumno.revalidate();
				tablaAlumno.repaint();
				
				System.out.println("Cambios implementados");
			
			}
		});
		
		frame.add(tablaAlumno, BorderLayout.CENTER);
		frame.add(btn, BorderLayout.SOUTH);
		frame.setVisible(true);
	}*/
}
