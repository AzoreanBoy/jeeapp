package servlets;

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

import beans.IManageSeries;
import jpaprimer.generated.Serie;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IManageSeries manageSeries;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		
		String genre = request.getParameter("genres");
		List<Serie> series = manageSeries.genreSeries(genre).stream().collect(Collectors.toList());
		
		
		request.setAttribute("genreRequest", capitalise(genre));
		request.setAttribute("today", new Date());
		request.getSession(true).setAttribute("mySeries", series);
		request.getRequestDispatcher("/genreSeries.jsp").forward(request, response);
	}
	
	private static String capitalise(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
	}

}