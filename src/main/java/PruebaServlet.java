package main.java;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laboral.ConsultaBBDD;
import laboral.Empleado;
import laboral.Nomina;

/**
 * @author Noelia
 * @version 1.2
 */

/**
 * Servlet implementation class PruebaServlet
 */
public class PruebaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Declaracion de variables para la conexion a la base de datos
	 */
	String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	String DB_URL = "jdbc:mysql://localhost:3307/empleado";
	String USER = "root";
	String PASS = "";
	
	/**
	 * Conexion con la base de datos
	 */
	
	public void init() {
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PruebaServlet() {
		super();

	}

	/**
	 * 
	 * Acciones que se invocan pasando parametros doGet
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/**
		 * para la opcion de consultar salario
		 */
		String dni = (String) request.getParameter("dni");
		
		/**
		 * para la opcion de consultar para modificar datos
		 */
		String dni2 = (String) request.getParameter("dni2");
		String nombre2 = (String) request.getParameter("nombre2");
		String sexo2 = (String) request.getParameter("sexo2");
		String categoria2 = (String) request.getParameter("categoria2");
		String anyos2 = (String) request.getParameter("anyos2");
		
		
		if(dni!=null){
			
			//llamada metodo
			salarioEmpleado(request, response,dni);
		
			/**
			 * para la opcion de consultar para modificar datos
			 */
		}else if((nombre2!= null && !nombre2.isEmpty()) ||
				(dni2!= null && !dni2.isEmpty())|| 
				(sexo2!= null && !sexo2.isEmpty())||
				(categoria2!= null && !categoria2.isEmpty())||
				(anyos2!= null && !anyos2.isEmpty())){
			
			//llamada de metodo
			modificarDatos(request, response, nombre2, dni2, sexo2, categoria2, anyos2);
		}
	}

	/**
	 * Menu de opciones
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		
		String action = request.getParameter("action");
		String method = request.getParameter("method");

		switch (action) {
		case "mostrarInfo":
				mostrarInfo(request, response);
				break;
		case "mostrarSalario":
			mostrarSalario(request, response);
			break;

		case "modificarDatos":
			consultarDatos(request, response);
			break;
		
		case "index":
			index(request, response);
		default:
			break;
		}
		
		
	}
	
	/**
	 * Mostrar la ventana principal con el menu
	 * Te dirige a un jsp donde muestra un menu de opciones 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

	}
	
	/**
	 * Mostrar la informacion de los empleados de la base de datos
	 * Te dirige al jsp donde se muestra una tabla con los datos de todos los empleados
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void mostrarInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Empleado> empleados = ConsultaBBDD.consultarEmpleados(DB_URL, USER, PASS,JDBC_DRIVER);
		
		// invocar un recurso web, encapsularlo y mostrarlo en un Servlet/jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrarInfo.jsp");
		request.setAttribute("lista", empleados);
		dispatcher.forward(request, response);


	}
	
	/**
	 * Introducir dni para mostrar salario de un empleado 
	 * Te dirige a la ventana (jsp) con el formulario donde introducir dni
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void mostrarSalario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrarSalario.jsp");
		dispatcher.forward(request, response);

	}
	
	/**
	 * Muestra del salario de un empleado
	 * Te dirige a la ventana (jsp) con el salario del empleado
	 * @param request
	 * @param response
	 * @param dni 
	 * @throws ServletException
	 * @throws IOException
	 */
	private void salarioEmpleado(HttpServletRequest request, HttpServletResponse response, String dni)
			throws ServletException, IOException {
		
		
		/**
		 * Crear un objeto empleado a traves de la clase utilidad (ConsultaBBDD) 
		 * que consulta a BBDD un empleado por dni
		 */
		Empleado empleadoConsultado = ConsultaBBDD.consultarEmpleadoPorDni(DB_URL, USER, PASS, JDBC_DRIVER, dni);
		response.getWriter().append(empleadoConsultado.toString());
		/**
		 * Variable sueldo a traves de la que se consulta la clase Nomina y se accede al sueldo
		 * de un empleado consultado
		 */
		int sueldo =Nomina.sueldo(empleadoConsultado);
		
		/**
		 * Se pasa a la request el atributo con el nombre sueldo
		 * se conecta con el jsp para que muestre sueldo
		 */
		request.setAttribute("sueldo", sueldo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("salarioEmpleado.jsp");
		dispatcher.forward(request, response);

	}
	
	/**
	 * Metodo consultar datos 
	 * Te dirige al jsp donde te muestra el formulario para introducir los datos a buscar
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void consultarDatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("modificarDatos.jsp");
		dispatcher.forward(request, response);
		
		
	}

	
	/**
	 * Modificar datos de un empleado
	 * Te dirige al jsp donde muestra los empleados consultados
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	private void modificarDatos(HttpServletRequest request, HttpServletResponse response, String nombre2, 
			String dni2, String sexo2, String categoria2, String anyos2)
			throws ServletException, IOException {
		
		ArrayList<Empleado> listempleados = ConsultaBBDD.consultarEmpleadosPorDatos(DB_URL, USER, PASS,JDBC_DRIVER, nombre2, dni2, sexo2, categoria2, anyos2);
		
		request.setAttribute("lista", listempleados);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrarInfo.jsp");
		dispatcher.forward(request, response);
		
		
	}


}
