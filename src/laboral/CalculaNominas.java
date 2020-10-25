package laboral;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * clase CalculaNominas con dos empleados creados
 * 
 * @author Noelia
 * @version 1.0
 * @since 1.8
 */

public class CalculaNominas {

	public static void main(String[] args) throws DatosNoCorrectosException, IOException {

		/**
		 * Lista vacia Ejecucion del metodo que recupera empleados Se rellana la
		 * lista con los datos BBDD
		 */
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

		//listaEmpleados = ConsultaBBDD.consultarEmpleados();

		/**
		 * Recuperar de la lista los dos empleados
		 */

		Empleado empleado1 = listaEmpleados.get(0);
		Empleado empleado2 = listaEmpleados.get(1);

		/**
		 * Generar fichero empleado.txt Generar fichero sueldos.txt
		 */

		File fichero = new File("./files/empleados.txt");
		File fichero2 = new File("./files/sueldos.txt");

		/**
		 * Escribir datos en fichero empleado.txt Escribir datos en fichero
		 * sueldos.txt
		 */

		escribirDatos(empleado1, empleado2);
		guardarDatos(empleado1, empleado2);

		/**
		 * Mostrar datos del fichero empleado.txt
		 */

		mostrarContenidoFichero("./files/empleados.txt");
		mostrarContenidoFichero2("./files/sueldos.txt");

		/**
		 * Llamada del metodo escribe
		 */
		escribe(empleado1, empleado2);

		/**
		 * Incremento años trabajados segundo empleado Actualizar de categoria
		 * primer empleado
		 */

		empleado2.incrAnyo();
		empleado1.setCategoria(9);
		escribirDatos(empleado1, empleado2);

		/**
		 * Llamada del metodo para actualizar la BBDD Se pasa la lista de
		 * empleados y no devuelve nada
		 */
		ConsultaBBDD.actualizar(listaEmpleados);

		/**
		 * Llamada del metodo escribe los sueldos
		 */

		escribe(empleado1, empleado2);

		/**
		 * Llamada del metodo para dar de alta a un empleado
		 */
		Empleado empleado=crearEmpleado();


		/**
		 * Llamada del metodo insertar empleado
		 */
		ConsultaBBDD.insertarEmpleado(empleado);

	}

	/**
	 * Metodo escribir datos en el fichero
	 * 
	 * @param empleado1
	 * @param empleado2
	 */
	private static void escribirDatos(Empleado empleado1, Empleado empleado2) {
		try {
			FileWriter fichero = new FileWriter("./files/empleados.txt");
			fichero.write("Nombre: " + empleado1.nombre + " /" + " Dni:" + empleado1.dni + " /" + " Sexo: "
					+ empleado1.sexo + " /" + " Categoria: " + empleado1.getCategoria() + " /" + " Anyos: "
					+ empleado1.anyos + "\n");
			fichero.write("Nombre: " + empleado2.nombre + " /" + " Dni:" + empleado2.dni + " /" + " Sexo: "
					+ empleado2.sexo + " /" + " Categoria: " + empleado2.getCategoria() + " /" + " Anyos: "
					+ empleado2.anyos + "\n");
			fichero.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo mostrar datos del fichero empleado.txt
	 * 
	 * @param ruta
	 */
	public static void mostrarContenidoFichero(String ruta) {
		String cadenaLeida = "";
		try {
			FileReader fichero = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fichero);
			cadenaLeida = br.readLine();
			System.out.println(cadenaLeida);

			while ((cadenaLeida = br.readLine()) != null) {
				System.out.println(cadenaLeida);

			}
			fichero.close();

		} catch (Exception e) {
			e.printStackTrace();// muestra la descripcion de la excepcion
		}
	}

	/**
	 * Guardar datos en sueldos.txt
	 * 
	 * @param empleado1
	 * @param empleado2
	 */

	private static void guardarDatos(Empleado empleado1, Empleado empleado2) {
		try {
			FileWriter fichero2 = new FileWriter("./files/sueldos.txt");
			fichero2.write(" Dni:" + empleado1.dni + " /" + Nomina.sueldo(empleado1) + "\n");
			fichero2.write(" Dni:" + empleado2.dni + " /" + Nomina.sueldo(empleado2) + "\n");
			fichero2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo mostrar datos del fichero sueldo.txt
	 * 
	 * @param ruta
	 */
	public static void mostrarContenidoFichero2(String ruta) {
		String cadenaLeida = "";
		try {
			FileReader fichero2 = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fichero2);
			cadenaLeida = br.readLine();
			System.out.println(cadenaLeida);

			while ((cadenaLeida = br.readLine()) != null) {
				System.out.println(cadenaLeida);

			}
			fichero2.close();

		} catch (Exception e) {
			e.printStackTrace();// muestra la descripcion de la excepcion
		}
	}

	/**
	 * Metodo mostrar atributos y sueldo de los empleados
	 * 
	 * @param empleado1
	 * @param empleado2
	 */
	private static void escribe(Empleado empleado1, Empleado empleado2) {
		System.out.println(empleado1 + " Su sueldo es: " + Nomina.sueldo(empleado1));
		System.out.println(empleado2 + " Su sueldo es: " + Nomina.sueldo(empleado2));

	}
	
	public static Empleado crearEmpleado() throws DatosNoCorrectosException{
		Scanner teclado = new Scanner(System.in);
		String nombre;
		String dni;
		String sexo;
		int categoria;
		int anyos;
		int sueldo;
		
		System.out.println("Introduce un nombre: ");
		nombre = teclado.nextLine();
		System.out.println("Introduce un dni:");
		dni = teclado.nextLine();
		System.out.println("Introduce sexo: ");
		sexo = teclado.nextLine();
		
		System.out.println("Introduce categoria: ");
		categoria = teclado.nextInt();
		System.out.println("Introduce anyos: ");
		anyos = teclado.nextInt();
		
		Empleado empleado= new Empleado(nombre, dni, sexo.charAt(0), categoria, anyos);
		
		return empleado;
		
	
		
	}

}
