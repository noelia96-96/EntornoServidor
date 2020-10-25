package laboral;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * 
 * @author Noelia
 * @version 1.1
 * @since 1.8
 *
 */
public class ConsultaBBDD {
	

	public static ArrayList<Empleado> consultarEmpleados(String url, String user, String pass, String jDBC_DRIVER) {

		/**
		 * Declarar una lista de empleados
		 */
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

		try {

			/**
			 * Conexion a BBDD
			 */
			Class.forName(jDBC_DRIVER).newInstance();
			Connection conn = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexion a empleado realizada con exito");

			/**
			 * Preparar consulta
			 */

			PreparedStatement consulta = conn.prepareStatement("Select * from empleados");

			/**
			 * Ejecutar la consulta
			 */

			ResultSet resultado = consulta.executeQuery();

			/**
			 * Recorrer las dos filas con los datos
			 */
			while (resultado.next()) {
				String nombre = resultado.getString("nombre");
				String dni = resultado.getString("dni");
				String sexo = resultado.getString("sexo");
				int categoria = resultado.getInt("categoria");
				int anyos = resultado.getInt("anyos");

				Empleado empleado = new Empleado(nombre, dni, sexo.charAt(0), categoria, anyos);

				/**
				 * Guardar el empleado en una lista
				 */

				listaEmpleados.add(empleado);

			}

			/**
			 * Actualizar la BBDD Incremento anyos trabajados segundo empleado
			 * Cambiar a categoria 9 el primer empleado
			 */

			//actualizar(listaEmpleados);

		} catch (Exception e) {

		}
		return listaEmpleados;

	}
	
	
	/**
	 * Metodo actualizar categoria, anyos y sueldo
	 * 
	 * @param listaEmpleados
	 */
	public static void actualizar(ArrayList<Empleado> listaEmpleados) {
		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/empleado", "root", "");
			System.out.println("Conexion a empleado realizada con éxito");

			PreparedStatement consulta = conn.prepareStatement("Select * from empleados");

			consulta.executeUpdate("UPDATE empleados SET categoria = " + listaEmpleados.get(0).getCategoria()
					+ "  WHERE dni = " + listaEmpleados.get(0).dni);
			consulta.executeUpdate("UPDATE empleados SET anyos = " + listaEmpleados.get(1).anyos + " WHERE dni = "
					+ listaEmpleados.get(1).dni);
			consulta.executeUpdate("UPDATE empleados set sueldo = " + Nomina.sueldo(listaEmpleados.get(0))
					+ " WHERE dni = " + listaEmpleados.get(0).dni);

		} catch (Exception e) {

		}

	}

	public static void insertarEmpleado(Empleado empleado) {
		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/empleado", "root", "");
			System.out.println("Conexion a empleado realizada con éxito");

			PreparedStatement consulta = conn.prepareStatement("Select * from empleados");
			consulta.executeQuery("INSERT into empleados VALUES('" + empleado.nombre + "', '" + empleado.dni + "', '"
					+ empleado.sexo + "', '" + empleado.getCategoria() + "', '" + empleado.anyos + "', '" + Nomina.sueldo(empleado) +"')");

		} catch (Exception e) {

		}

	}
	
	/**
	 * Metodo para recuperar un empleado introduciendo dni
	 * @param url
	 * @param user
	 * @param pass
	 * @param jDBC_DRIVER
	 * @param dni
	 * @return
	 */

	public static Empleado consultarEmpleadoPorDni(String url, String user, String pass, String jDBC_DRIVER, String dni) {

		/**
		 * Empleado
		 */
		Empleado empleadoConsultado = new Empleado();

		try {

			/**
			 * Conexion a BBDD
			 */
			Class.forName(jDBC_DRIVER).newInstance();
			Connection conn = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexion a empleado realizada con exito");

			/**
			 * Preparar consulta
			 */

			PreparedStatement consulta = conn.prepareStatement("Select * from empleados where dni='" + dni+"'");

			/**
			 * Ejecutar la consulta
			 */

			ResultSet resultado = consulta.executeQuery();

			/**
			 * Del resultado saca todos los datos
			 */
				resultado.next();
				String nombre = resultado.getString("nombre");
				String dni2 = resultado.getString("dni");
				String sexo = resultado.getString("sexo");
				int categoria = resultado.getInt("categoria");
				int anyos = resultado.getInt("anyos");

			/**
			 * Llamar al empleado creado y se le pasa todos los datos
			 */
				empleadoConsultado = new Empleado(nombre, dni2, sexo.charAt(0), categoria, anyos);

				
		} catch (Exception e) {

		}
		return empleadoConsultado;

	}


	public static ArrayList<Empleado> consultarEmpleadosPorDatos(String dB_URL, String uSER, String pASS,
			String jDBC_DRIVER, String nombre, String dni, String sexo, String categoria, String anyos) {
		/**
		 * Declarar una lista de empleados
		 */
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

		try {

			/**
			 * Conexion a BBDD
			 */
			Class.forName(jDBC_DRIVER).newInstance();
			Connection conn = DriverManager.getConnection(dB_URL, uSER, pASS);
			System.out.println("Conexion a empleado realizada con exito");

			/**
			 * Preparar consulta para cada campo
			 * Se van a encadenar condiciones que puede que se cumplan o no
			 * Para eso se pone una condicion que siempre se vaya a cumplir 1=1
			 * Esto permite encadenar varias condiciones a la consulta
			 */
			String consulta="Select * from empleados where 1=1";
		
			
			if(nombre!= null && !nombre.isEmpty()){
				consulta = consulta + " AND nombre='" + nombre +"'";
			}
			
			if(dni!=null && !dni.isEmpty()){
				consulta = consulta + " AND dni='" + dni + "'";
			}
			
			if(sexo!=null && !sexo.isEmpty()){
				consulta = consulta + " AND sexo='" + sexo + "'";
				
			}
			
			if(categoria!=null && !categoria.isEmpty()){
				consulta = consulta + " AND categoria='" + categoria + "'";
			}
			
			if(anyos!=null && !anyos.isEmpty()){
				consulta = consulta + " AND anyos='" + anyos + "'";
			}
			
			
			/**
			 * Ejecutar la consulta
			 */
			PreparedStatement consultasql = conn.prepareStatement(consulta);
			ResultSet resultado = consultasql.executeQuery();

			/**
			 * Recorrer las dos filas con los datos y guardar en el objeto Empleado empleado
			 */
			while (resultado.next()) {
				String nombre2 = resultado.getString("nombre");
				String dni2 = resultado.getString("dni");
				String sexo2 = resultado.getString("sexo");
				int categoria2 = resultado.getInt("categoria");
				int anyos2 = resultado.getInt("anyos");

				Empleado empleado = new Empleado(nombre2, dni2, sexo2.charAt(0), categoria2, anyos2);

				/**
				 * Guardar el empleado en una lista
				 */

				listaEmpleados.add(empleado);

			}

			/**
			 * Actualizar la BBDD Incremento anyos trabajados segundo empleado
			 * Cambiar a categoria 9 el primer empleado
			 */

			//actualizar(listaEmpleados);

		} catch (Exception e) {

		}
		return listaEmpleados;

	}


}