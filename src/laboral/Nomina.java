package laboral;

/**
 * clase Nomina contiene tabla de sueldos 
 * 
 * @author Noelia
 * @version 1.0
 * @since 1.8
 */

/**
 * 
 * Array de tipo int para almacenar los sueldos base
 *
 */
public class Nomina {
	
	private static final int SUELDO_BASE[] = {50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000};
	
	/**
	 * Metodo para calcular el sueldo final del empleado
	 * 
	 * @param empleado
	 * @return sueldo final
	 */
	public static int sueldo(Empleado empleado){
		int sueldo = 0;
		sueldo = SUELDO_BASE[empleado.getCategoria()-1] + 5000 * empleado.anyos;
		return sueldo;
		
	}


}
