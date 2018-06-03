package velasco.karen.objects;

import java.sql.Date;

public class Alumno {
	private Integer id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechaNacimiento;
    private Carrera carrera;
    
    private Alumno next;
    
    public Alumno(Integer id, String nombre, String apellido1, String apellido2, 
    		Date fechaNacimiento, Carrera carrera){//Carrera carrera
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.carrera = carrera;
        this.fechaNacimiento = fechaNacimiento;
        //        System.out.println("La fecha es: "+ fechaNacimiento.fechaToString());
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Alumno getNext() {
		return next;
	}

	public void setNext(Alumno next) {
		this.next = next;
	}
    
}
