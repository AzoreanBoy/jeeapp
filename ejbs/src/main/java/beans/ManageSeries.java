package beans;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import static java.util.stream.Collectors.*;
import jpaprimer.generated.*;

@Stateless
public class ManageSeries implements IManageSeries {
	@PersistenceContext(unitName = "playSeriesShow")
	EntityManager em;

	/**
	 * Gets All the Series in the Database and returns a list of Series
	 * 
	 * @return
	 */
	public List<Serie> getSeries() {
		System.out.println("Getting Series from DB...");
		TypedQuery<Serie> q = em.createQuery("FROM Serie s", Serie.class);
		List<Serie> list = q.getResultList();
		return list;
	}

	/**
	 * Returns a list with all the Series Titles in the database
	 */
	public List<String> getSeriesTitles() {
		System.out.println("Getting Series from DB...");
		TypedQuery<Serie> q = em.createQuery("from Serie s", Serie.class);
		List<Serie> series = q.getResultList();
		List<String> ss = new ArrayList<>();

		for (Serie s : series) {
			ss.add(s.getTitle());
		}
		return ss;
	}

	/**
	 * Returns a List of all the Actors and Stars names in all the Series in the DB
	 */
	public List<String> getAllActors() {
		System.out.println("Retrieving the actors from the database...");
		TypedQuery<Serie> q = em.createQuery("FROM Serie s", Serie.class);
		List<Serie> list = q.getResultList();
		List<String> actors = new ArrayList<>();
		for (Serie s : list) {
			for (String act : s.getActor()) {
				if (!actors.contains(act)) {
					actors.add(act);
				}
			}
			for (String act : s.getStar()) {
				if (!actors.contains(act)) {
					actors.add(act);
				}
			}
		}
		return actors;
	}

	/**
	 * Return a list of the series which the score and the number of votes are above
	 * the given parameters
	 * 
	 * @param score         allowed object is {@link BigDecimal }
	 * @param NumberOfVotes object is {@link BigInteger }
	 * 
	 * @return List of series Titles above the parameters
	 */
	public List<String> getAbove(BigDecimal score, BigInteger NumberOfVotes) {
		List<Serie> series = getSeries();
		List<String> serieAbove = new ArrayList<>();
		System.out.println("Comparig the values...");
		for (Serie s : series) {
			BigInteger votes = s.getNumberOfVotes();
			BigDecimal rating = s.getScore();
			if (votes.compareTo(NumberOfVotes) == 1 && rating.compareTo(score) == 1) {
				serieAbove.add(s.getTitle());
			}
		}
		return serieAbove;
	}

	/**
	 * Given a Genre, obtains all Series that match that genre
	 * 
	 * @param genre object is a {@link String}
	 */
	public List<String> genresMatch(String genre) {
		List<Serie> series = getSeries();
		List<String> list = new ArrayList<>();
		for (Serie serie : series) {
			if (serie.getGenre().contains(genre)) {
				list.add(serie.getTitle()); // Estou a adicionar o título da Série de qual o Género faz parte mas ainda
											// nao sei se é para adicionar a serie toda ou basta o titulo
			}
		}
		return list;
	}

	/**
	 * Given a Genre, obtains all Series that match that genre
	 * 
	 * @param genre object is a {@link String}
	 */
	public Map<String, Integer> genresActors(String genre) {
		List<Serie> series = getSeries();
		Map<String, Integer> actorsNumbers = new HashMap<String, Integer>();

		for (Serie serie : series) { // Os atores têm de ser ordenados
			if (serie.getGenre().contains(genre)) {
				for (String actor : serie.getStar()) {
					if (actorsNumbers.containsKey(actor)) {
						Integer numberOfTimes = actorsNumbers.get(actor);
						actorsNumbers.replace(actor, numberOfTimes, numberOfTimes + 1);
					} else {
						actorsNumbers.put(actor, 1);
					}
				}
				for (String actor : serie.getActor()) {
					if (actorsNumbers.containsKey(actor)) {
						Integer numberOfTimes = actorsNumbers.get(actor);
						actorsNumbers.replace(actor, numberOfTimes, numberOfTimes + 1);
					} else {
						actorsNumbers.put(actor, 1);
					}
				}
			}
		}
		Map<String, Integer> sorted = actorsNumbers.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		return sorted;
	}

	/**
	 * Given a set of Keywords, obtains the Series titles that inclued at least of
	 * of the keywords in the Description of the Serie
	 */
	public List<String> atLeastOneKeyword(List<String> keyword) {
		List<Serie> series = getSeries();
		List<String> list = new ArrayList<>();
		for (String key : keyword) {
			for (Serie serie : series) {
				if (serie.getSummaryOfSerie().toLowerCase().contains(key)) {
					if (!list.contains(serie.getTitle())) {
						list.add(serie.getTitle());
					}
				}
			}
		}
		return list;
	}

	/**
	 * Given a set of Keywords, obtains the Series titles that inclued all the
	 * keywords in the description of the Serie
	 */
	public List<String> allKeywords(List<String> keyword) {
		List<Serie> series = getSeries();
		List<String> list = new ArrayList<>();

		for (Serie serie : series) {
			boolean b = true;
			for (String key : keyword) {
				if (!serie.getSummaryOfSerie().toLowerCase().contains(key)) {
					b = false;
				}
			}
			if (b == true) {
				list.add(serie.getTitle());
			}
		}
		return list;
	}

	public Map<String, BigDecimal> genresRating() {
		@SuppressWarnings("unchecked")
		List<Object[]> results = (List<Object[]>) em
				.createNativeQuery(
						"select distinct genre, round(avg(s.score),2) as n " + "from serie as s, serie_genre as sg "
								+ "where sg.serie_id = s.id " + "group by sg.genre " + "FETCH NEXT 30 ROWS ONLY")
				.getResultList();
		Map<String, BigDecimal> avgRatingByGenre = new HashMap<>();
		for (Object[] o : results) {
			String g = (String) o[0];
			BigDecimal avg = (BigDecimal) o[1];
			avgRatingByGenre.put(g, avg);
		}

		return avgRatingByGenre;
	}
}
