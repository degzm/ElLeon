package logic;

public class Persona {
	public String nombre;
	public int edad;
	public double estatura;
	public String genero;
	
	public Persona() {
		super();
	}
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	public Persona(String nombre, int edad, double estatura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.estatura = estatura;
	}
	public Persona(String nombre, int edad, double estatura, String genero) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.estatura = estatura;
		this.genero = genero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getEstatura() {
		return estatura;
	}
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
