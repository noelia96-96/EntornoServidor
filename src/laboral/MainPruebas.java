package laboral;

import java.util.ArrayList;



public class MainPruebas {
	static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost:3307/empleado";
	static String USER = "root";
	static String PASS = "";

	public static void main(String[] args) {
		 ArrayList<Empleado> empleados = ConsultaBBDD.consultarEmpleados(DB_URL, USER, PASS,JDBC_DRIVER);
		 System.out.println(empleados);
		 Empleado empleadosconsultado = ConsultaBBDD.consultarEmpleadoPorDni(DB_URL, USER, PASS,JDBC_DRIVER, "32000031R");
		 System.out.println(empleadosconsultado);
		 
			String nombre = "";	
			String dni = "";	
			String sexo = "";
			String categoria = "1";
			String anyos = "";	
			
			empleados = ConsultaBBDD.consultarEmpleadosPorDatos(DB_URL, USER, PASS,JDBC_DRIVER, nombre, dni, sexo, categoria, anyos);
	}

}
