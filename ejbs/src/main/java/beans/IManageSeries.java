package beans;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

import jpaprimer.generated.Serie;

@Remote
public interface IManageSeries {
	public List<Serie> getSeries();												// Retrives all the Series Data
	public List<String> getSeriesTitles();										// Retrives all the Series Titles
	public List<String> getAllActors();											// Retrives all actors in the DB
	public List<String> getAbove(BigDecimal score, BigInteger NumberOfVotes);	// Retrives The Series with rating above the given ones
	public List<String> genresMatch(String genre);								// Retrives the Series that match da genre
	public Map<String, Integer> genresActors(String genre);						// Retives the actors that perform in series that are considered in that genre
	public List<String> atLeastOneKeyword(List<String> keyword);				// Retrives the series that contains at least one of the keywords in their description
	public List<String> allKeywords(List<String> keyword);						// Retrives the series that contains all the keywords in their description
	public Map<String, BigDecimal> genresRating();
}