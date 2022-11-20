package book;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import beans.IManageSeries;
import jpaprimer.generated.Serie;

@RequestScoped
@Path("/myservice")
@Produces(MediaType.APPLICATION_JSON)
public class MyService {

	@EJB
	private IManageSeries manageSeries;

	@GET
	@Path("/test")
	public String method1() {
		System.out.println("M1 executing....");
		return "M1 executed...";
	}

	@GET
	@Path("/series")
	public List<Serie> method2() {
		System.out.println("M3 executing....");
		List<Serie> list = manageSeries.getSeries();
		return list;
	}

	@GET
	@Path("/actors")
	public List<String> method3() {
		System.out.println("M4 Executing...");
		List<String> actores = manageSeries.getAllActors();
		return actores;
	}

	@GET
	@Path("/seriesAbove/{score}/{voters}")
	public List<String> method4(@PathParam("score") BigDecimal score, @PathParam("voters") BigInteger voters) {
		System.out.println("M5 Executing...");
		List<String> seriesAbove = manageSeries.getAbove(score, voters);
		return seriesAbove;
	}

	@GET
	@Path("/genreMatch/{genre}")
	public List<String> method5(@PathParam("genre") String genre) {
		System.out.println("M6 Executing...");
		List<String> seriesAbove = manageSeries.genresMatch(genre);
		return seriesAbove;
	}

	@POST
	@Path("/getKeyword")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<String> method6(List<String> keywords) {
		System.out.println("M4 Executing...");
		List<String> actores = manageSeries.atLeastOneKeyword(keywords);
		return actores;
	}

	@POST
	@Path("/getAllKeywords")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<String> method7(List<String> keywords) {
		System.out.println("M4 Executing...");
		List<String> actores = manageSeries.allKeywords(keywords);
		return actores;
	}

	@GET
	@Path("/genresActors/{genre}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Integer> mathod9(@PathParam("genre") String genre) {
		System.out.println("M6 Executing...");
		Map<String, Integer> list = manageSeries.genresActors(genre);
//		Entity<Map<String,Integer>> lista = Entity.entity(list, MediaType.APPLICATION_JSON);
		return list;
	}

	@GET
	@Path("/genresRating")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, BigDecimal> method10(@QueryParam("num") int n) {
		System.out.println("Getting Rating");
		Map<String, BigDecimal> list = manageSeries.genresRating();
		Map<String, BigDecimal> avgRating = new HashMap<>();
		List<String> keys = new ArrayList<>(list.keySet());
		if (n > list.size()) {
			n = list.size();
		}
		for (int i = 0; i < n; i++) {
			avgRating.put(keys.get(i), list.get(keys.get(1)));
		}
		return avgRating;
	}

}
