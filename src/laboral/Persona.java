package laboral;

	/**
	 * Clase Persona contiene atributos de la persona y dos metodos publicos

	 * 
	 * @author Noelia
	 * @version 1.0
	 * @since 1.8
	 */
	
	/**
	 * Atributos de persona
	 */
public class Persona {

	public String nombre;
	public String dni;
	public char sexo;

	/**
	 * Constructor 1 - atributos
	 * 
	 * @param nombre
	 * @param dni
	 * @param sexo
	 */
	
	public Persona() {

	}
	public Persona(String nombre, String dni, char sexo) {

		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
	}

	/**
	 * Constructor 2 - atributos
	 * 
	 * @param nombre
	 * @param sexo
	 */

	public Persona(String nombre, char sexo) {

		this.nombre = nombre;
		this.sexo = sexo;
	}

	/**
	 * Metodo setDni
	 * 
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Imprimir nombre y dni
	 * 
	 * @return el nombre y el dni
	 */
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getDni() {
		return dni;
	}

}
