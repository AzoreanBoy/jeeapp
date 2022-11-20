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

@WebServlet("/series")
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private IManageSeries manageSeries;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<Serie> series = manageSeries.getSeries().stream().collect(Collectors.toList());
		System.out.println(series);
		request.setAttribute("today", new Date());
		request.getSession(true).setAttribute("mySeries", series);
		request.getRequestDispatcher("/series.jsp").forward(request, response);
	}
}