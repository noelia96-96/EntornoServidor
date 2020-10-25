package laboral;

/**
 * clase Empleado contiene atributos del empleado y dos metodos publicos
 * 
 * @author Noelia
 * @version 1.0
 * @since 1.8
 * @see clase Persona
 */

/**
 * Atributos nuevos de persona
 */
public class Empleado extends Persona {

	private int categoria;
	public int anyos;

	/**
	 * Constructor 1 - atributos
	 * 
	 * @param nombre
	 * @param dni
	 * @param sexo
	 * @param categoria
	 * @param anyos
	 * @throws DatosNoCorrectosException 
	 */
	public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) throws DatosNoCorrectosException {
		super(nombre, dni, sexo);
		
		/**
		 * Controlar que la categoria sea positivo entre 1-10
		 */

		if(categoria >=1 && categoria <=10){
			this.categoria = categoria;
		}else{
			throw new DatosNoCorrectosException("Datos no correctos");
		}
		
		/**
		 * Controlar que la anyos sea positivo
		 */
		
		if(anyos >= 0){
			this.anyos = anyos;
		}else{
			throw new DatosNoCorrectosException("Datos no correctos");
		}
		
	}
	
	public Empleado(){
		super();
	}

	/**
	 * Constructor 2 - atributos
	 * 
	 * @param nombre
	 * @param dni
	 * @param sexo
	 */
	public Empleado(String nombre, String dni, char sexo) {
		super(nombre, dni, sexo);
		
		/**
		 * Se añade el valor de categoria y anyos por defecto, ya que no estan en el constructor
		 */
		this.categoria=1;
		this.anyos=0;

	}

	/**
	 * Metodo getCategoria
	 * 
	 * @return categoria
	 */
	public int getCategoria() {
		return categoria;
	}

	/**
	 * Metodo setCategoria - cambia de categoria, se controla que el dato introducido sea positivo entre 1-10
	 * 
	 * @param categoria
	 * @throws DatosNoCorrectosException 
	 */
	public void setCategoria(int categoria) throws DatosNoCorrectosException {
		if(categoria >=1 && categoria <=10){
			this.categoria = categoria;
		}else{
			throw new DatosNoCorrectosException("Datos no correctos");
		}
	}
	
	/**
	 * Metodo incrementa años trabajados
	 */
    
    public void incrAnyo(){
       anyos = anyos + 1;
    }

	/**
	 * Imprime todos los datos del empleado
	 */
	@Override
	public String toString() {
		return "Empleado [categoria=" + categoria + ", anyos=" + anyos + ", nombre=" + nombre + ", dni=" + dni
				+ ", sexo=" + sexo + "]";
	}

	public int getAnyos() {
		return anyos;
	}

	public void setAnyos(int anyos) {
		this.anyos = anyos;
	}
	
	

}
