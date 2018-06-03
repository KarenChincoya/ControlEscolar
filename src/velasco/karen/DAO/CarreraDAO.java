package velasco.karen.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import velasco.karen.objects.Carrera;

public class CarreraDAO {
private Connection conexion;
	
	public CarreraDAO() {
		
		try {
			Class.forName("org.postgresql.Driver");//8082

	         String url = "jdbc:postgresql://localhost/escueladb"; //tabla, bd
	        
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
	
	public String normalizarCadena(String cadena){
		cadena = cadena.toLowerCase().trim();
		char[] letras = cadena.toCharArray();
		String c;
		cadena="";
		for(int i=0; i<letras.length; i++) {
			switch(letras[i]) {
				case 'á': letras[i]='a';break;
				case 'é': letras[i]='e';break;
				case 'í': letras[i]='i';break;
				case 'ó': letras[i]='o';break;
				case 'ú': letras[i]='u';break;
				case 'ñ': letras[i]='n';break;
			}
			c = String.valueOf(letras[i]);
			cadena = cadena.concat(c);
		}
		System.out.println("Resultado normalizacion: "+cadena);
		return cadena;
	}
	
	public Carrera getCarrera(String cadena) {
		Carrera carrera = null;
		Integer num=0;
		cadena =cadena.trim(); //no hace falta normalizar
		String query="";
		
		try {
			num = Integer.valueOf(cadena.trim());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Es una letra");
		}
		
		if(num!=0) {
			query = "select * from carreras where id='"+num+"'";
		}else {
			
			query = "select * from carreras where descripcion LIKE '%"+cadena+"%'";
		}
		
		try {
			PreparedStatement stn = conexion.prepareStatement(query);
	        //        stn.setInt(1, 2); //1 es el indice
	        ResultSet rs = stn.executeQuery();
	        
	        while (rs.next()) {//por columna 
	        	carrera = new Carrera(rs.getInt(1), rs.getString(2));
	            System.out.println(rs.getInt(1));
	            System.out.println(rs.getString(2));
	        }
	        
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR BASE DE DATOS");
		}
        
        System.out.println("Consulta = "+query);
		
		return carrera;

	}
	
	public ArrayList<String> getCarreras() {
		ArrayList<String> carreras = new ArrayList<String>();
		Integer num=0;
		String query="select descripcion from carreras";
		
		try {
			PreparedStatement stn = conexion.prepareStatement(query);
	        //        stn.setInt(1, 2); //1 es el indice
	        ResultSet rs = stn.executeQuery();
	        
	        while (rs.next()) {//por columna 
	        	carreras.add(rs.getString(1));
	        }
	        
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR BASE DE DATOS");
		}
        
        System.out.println("Consulta = "+query);
		
		return carreras;

	}
	
	public void insertData(Integer id, String descripcion) {
		try {
        	PreparedStatement ins = conexion.prepareStatement("insert into carreras(id, descripcion) values (?, ?)");
            ins.setInt(1, id);
            ins.setString(2, descripcion);

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
	
}
