package servlets;

import beans.IManageSeries;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActorsServlet
 */
@WebServlet("/actors")
public class ActorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IManageSeries manageSeries;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> actores = manageSeries.getAllActors().stream().collect(Collectors.toList());
		request.setAttribute("actors", actores);
		request.setAttribute("today", new Date());
		request.getRequestDispatcher("/actorsdisplay.jsp").forward(request, response);
	}

}
