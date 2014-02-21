package es.indra.formacion.pr.persistence.servlet.persona;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.indra.formacion.pr.persistence.model.Persona;
import es.indra.formacion.pr.persistence.service.IPersonaService;
import es.indra.formacion.pr.persistence.service.PersonaServiceFactory;

/**
 * Servlet implementation class AgregarPersonaServlet
 */
@WebServlet("/persona/Agregar")
public class AgregarPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IPersonaService personaService = PersonaServiceFactory.createPersonaService();
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String sfechaNacimiento = request.getParameter("fechaNacimiento");
		String saltura = request.getParameter("altura");
		
		// TODO: Incluir validaciones!
		
		try {
			Date fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(sfechaNacimiento);
			Double altura = Double.parseDouble(saltura);
			
			Persona p = new Persona(
						nombre,
						apellido,
						fechaNacimiento,
						altura
					);
			
			personaService.agregarPersona(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("Principal");
	}

}
