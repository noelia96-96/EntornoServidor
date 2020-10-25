package main.java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laboral.ConexionBBDD;
import laboral.ConsultaBBDD;
import laboral.Empleado;

/**
 * Servlet implementation class DemoServlet
 */

public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	String DB_URL = "jdbc:mysql://localhost/empleado";
	String USER = "root";
	String PASS = "";
	ArrayList<Empleado> empleados;
	public void init() {

		
		try {
			 empleados = ConsultaBBDD.consultarEmpleados(DB_URL, USER, PASS,JDBC_DRIVER);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DemoServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Hola");
		
		/*String action = request.getParameter("action");
		String method = request.getParameter("method");

		switch (action) {
		case "mostrarInfo":
				mostrarInfo(request, response);
				break;
		case "mostrarSalario":
			mostrarSalario(request, response);
			break;

		case "modificarDatos":
			modificarDatos(request, response);
			break;
		default:
			break;
		}
*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}

	
	protected void index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

	}

	private void mostrarInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// invocar un recurso web, encapsularlo y mostrarlo en un Servlet/jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrarInfo.jsp");
		request.setAttribute("lista", empleados);
		dispatcher.forward(request, response);

	}
	
	

	private void mostrarSalario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dato = request.getParameter("dato");
		request.setAttribute("dato", dato);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrarSalario.jsp");
		dispatcher.forward(request, response);

	}

	private void modificarDatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/modificarDatos.jsp");
		dispatcher.forward(request, response);
	}

}
