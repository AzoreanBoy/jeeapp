package book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import jpaprimer.generated.Serie;

@WebService
public class SeriesSoapWS {

	@PersistenceContext(unitName = "playSeriesShow")
	private EntityManager em;

	/**
	 * Gets All the Series in the Database and returns a list of Series
	 * 
	 * @return list of {@link Serie}
	 */
	public List<Serie> getSeries() {
		System.out.println("Getting Series from DB...");
		TypedQuery<Serie> q = em.createQuery("FROM Serie s", Serie.class);
		List<Serie> list = q.getResultList();
		return list;
	}

	/**
	 * Returns a List of the titles of the Series in the Database
	 * 
	 * @return list of {@link String}
	 */
	public List<String> getTitles() {
		List<Serie> list = getSeries();
		List<String> titles = new ArrayList<>();
		for (Serie s : list) {
			titles.add(s.getTitle());
		}
		return titles;
	}

	/**
	 * Given a Series Title, the Method Retrives all information about the Serie
	 * 
	 * @param title alowed object is {@link String}
	 * @return an object of type {@link Serie}
	 */
	public Serie getSerieData(String title) {
		List<Serie> list = getSeries();
		Serie s = null;
		for (Serie serie : list) {
			if (serie.getTitle().toLowerCase().equals(title.toLowerCase())) {
				s = serie;
			}
		}
		return s;
	}

	/**
	 * Given a Series Title, the Method Retrives the serie IMDB Rating score
	 * 
	 * @param title alowed object is {@link String}
	 * @return an object of type {@link BigDecimal}
	 */
	public BigDecimal getRating(String title) {
		List<Serie> list = getSeries();
		BigDecimal rating = null;
		for (Serie serie : list) {
			if (serie.getTitle().toLowerCase().equals(title.toLowerCase())) {
				rating = serie.getScore();
			}
		}
		return rating;
	}
}
