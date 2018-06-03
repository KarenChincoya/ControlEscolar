package velasco.karen.view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import velasco.karen.objects.Alumno;

public class AlumnoTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Alumno> oAlumnos;
	
	public AlumnoTableModel(ArrayList<Alumno> alumnos) {
		this.oAlumnos = alumnos;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return oAlumnos.size();
	}

	@Override
	public Object getValueAt(int i, int j) {
		// TODO Auto-generated method stub
		Alumno alumno = oAlumnos.get(i);
		String result = null;
		switch(j) {
			case 0: result = String.valueOf(alumno.getId()); break;
			case 1: result = alumno.getNombre();break;
			case 2: result = alumno.getApellido1(); break;
			case 3: result = alumno.getApellido2(); break;
			case 4: result = alumno.getCarrera().getDescripcion(); break;
			case 5: result = alumno.getFechaNacimiento().toString(); break;
		}
		return result;
	}
		
	public String getColumnName(int column){
		String result;
		switch(column) {
			case 0: result = "Numero de control"; break;
			case 1: result = "Nombre "; break;
			case 2: result = "Apellido paterno"; break;
			case 3: result = "Apellido materno"; break;
			case 4: result = "Carrera "; break;
			case 5: result = "Fecha de nacimiento"; break;
			default: result = "UN";
		}
		return result;
	}

	public ArrayList<Alumno> getoAlumnos() {
		return oAlumnos;
	}

	public void setoAlumnos(ArrayList<Alumno> oAlumnos) {
		this.oAlumnos = oAlumnos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}