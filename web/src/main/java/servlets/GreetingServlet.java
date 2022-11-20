package servlets;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IManageSeries manageSeries;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
//		response.getWriter().println("Hello World");
		request.setAttribute("today", new Date());
//		request.getRequestDispatcher("/display.jsp").forward(request, response);
		List<String> myList = new ArrayList<String>();
		myList.add("One...");
		myList.add("Two...");
		myList.add("Three...");
		request.setAttribute("myListOfNumbers", myList);
		
//		List<List<String>> series = manageSeries.getSeries().stream().map(Serie::getGenre).collect(Collectors.toList());
		request.getRequestDispatcher("/display.jsp").forward(request, response);

	}
}
