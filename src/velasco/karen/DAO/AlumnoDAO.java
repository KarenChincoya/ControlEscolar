package velasco.karen.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import velasco.karen.objects.Alumno;
import velasco.karen.objects.Carrera;

public class AlumnoDAO {
	private Connection conexion;

	public AlumnoDAO() {
		try {
			Class.forName("org.postgresql.Driver");// 8082

			String url = "jdbc:postgresql://localhost/escueladb"; // tabla, bd

			Properties props = new Properties();
			props.setProperty("user", "adminescolar");
			props.setProperty("password", "control");

			this.conexion = DriverManager.getConnection(url, props);

			System.out.println(conexion.toString());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se realizo la conexion");
			e.printStackTrace();
		}
	}

	public String normalizarCadena(String cadena) {
		cadena = cadena.toLowerCase();
		char[] letras = cadena.toCharArray();
		String c;
		cadena = "";
		for (int i = 0; i < letras.length; i++) {
			switch (letras[i]) {
			case 'á':
				letras[i] = 'a';
				break;
			case 'é':
				letras[i] = 'e';
				break;
			case 'í':
				letras[i] = 'i';
				break;
			case 'ó':
				letras[i] = 'o';
				break;
			case 'ú':
				letras[i] = 'u';
				break;
			case 'ñ':
				letras[i] = 'n';
				break;
			}
			c = String.valueOf(letras[i]);
			cadena = cadena.concat(c);
		}
		System.out.println("Resultado normalizacion: " + cadena);
		return cadena;
	}

	public ArrayList<Alumno> getAlumnos(String cadena) {
		cadena = cadena.trim();// sin normalizar
		System.out.println("cadena = " + cadena);
		Integer num = 0;
		Alumno alumno;
		Carrera carrera;
		CarreraDAO daoCarrera = new CarreraDAO();

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		String query = "select * from alumnos where ";
		
		try {
			num = Integer.valueOf(cadena.trim());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if (cadena == "") {
			System.out.println("TODOS");
			query = "select * from alumnos";
		}else if (num != 0) {// buscar por id
			query = query.concat("id ='" + num + "'");
		} else {
			String[] tokens = cadena.split(" ");
			int agregados = 0;

			for (int i = 0; i < tokens.length; i++) {
				if (tokens[i].length() > 1) {
					if (agregados == 0) {
						query = query.concat("nombre LIKE '%" + tokens[i] + "%'");
						query = query.concat("OR apellido1 LIKE '%" + tokens[i] + "%'");
						query = query.concat("OR apellido2 LIKE '%" + tokens[i] + "%'");
					} else {
						query = query.concat(" OR apellido1 LIKE '%" + tokens[i] + "%'");
						query = query.concat(" OR apellido2 LIKE '%" + tokens[i] + "%'");
					}
					agregados++;
				}
			}

		}

		query = query.concat(" order by 1");
		System.out.println("Consulta = " + query);
		try {
			PreparedStatement stn = conexion.prepareStatement(query);
			// stn.setInt(1, 2); //1 es el indice
			ResultSet rs = stn.executeQuery();

			while (rs.next()) {// por columna
				carrera = daoCarrera.getCarrera(String.valueOf(rs.getInt(5)));

				alumno = new Alumno(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(6),
						carrera);

				alumnos.add(alumno);
				// System.out.println(rs.getString(1));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No leyeron nada");
			e.printStackTrace();
		}
		return alumnos;
	}

	public void insertStudent(Integer id, String nombre, String apellido1, String apellido2, Integer carrera,
			Date fechanacimiento) {
		try {
			PreparedStatement ins = conexion.prepareStatement("insert into alumnos(id, nombre, apellido1, "
					+ "apellido2, carrera, fechanacimiento) values (?, ?, ?, ?, ?, ?)");
			ins.setInt(1, id);
			ins.setString(2, nombre);
			ins.setString(3, apellido1);
			ins.setString(4, apellido2);
			ins.setInt(5, carrera);
			ins.setDate(6, fechanacimiento);

			int rowcount = ins.executeUpdate();
			System.out.println("cantidad de registros afectados: " + rowcount);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void insertStudent(Alumno alumno) {
		Integer id = alumno.getId();
		String nombre = alumno.getNombre();
		String apellido1 = alumno.getApellido1();
		String apellido2 = alumno.getApellido2();
		Integer carrera = alumno.getCarrera().getId();
		Date fechanacimiento = alumno.getFechaNacimiento();
		this.insertStudent(id, nombre, apellido1, apellido2, carrera, fechanacimiento);
	}

	public void updateStudent(Integer id, String nombre, String apellido1, String apellido2, Integer carrera,
			Date fechanacimiento) {

		try {
			PreparedStatement ins = conexion.prepareStatement("update alumnos " + "set nombre=?, apellido1=?, "
					+ "apellido2=?, carrera=?, fechanacimiento=? " + "where id=?");
			// ins.setInt(1, id);
			ins.setString(1, nombre);
			ins.setString(2, apellido1);
			ins.setString(3, apellido2);
			ins.setInt(4, carrera);
			ins.setDate(5, fechanacimiento);
			ins.setInt(6, id);

			int rowcount = ins.executeUpdate();
			System.out.println("cantidad de registros afectados: " + rowcount);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteStudent(Integer id) {
		try {
			PreparedStatement ins = conexion.prepareStatement("delete from alumnos where id=?");
			ins.setInt(1, id);

			int rowcount = ins.executeUpdate();
			System.out.println("cantidad de registros afectados: " + rowcount);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			this.conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se cerro la conexion");
			e.printStackTrace();
		}
	}

	
	/* public static void main(String[] args) { AlumnoDAO daoAlumno = new
	  AlumnoDAO(); String str="1997-06-26"; Date date = Date.valueOf(str);
	 //daoAlumno.updateStudent(7, "Metzli", "Torres", "Amaya", 14, date);
	 
	  if(daoAlumno.getAlumnos("Medina")!=null) {
	  System.out.println(daoAlumno.getAlumnos("Medina").get(0).getFechaNacimiento().toString()); 
	  } 
	  
	 }*/
	 

	/*
	 * AlumnoDAO daoAlumno = new AlumnoDAO(); Date date = new Date(1996,6,3);
	 * daoAlumno.insertData(4, "Lorena", "Valencia", "Chavez", 4, date); }
	 */
}
