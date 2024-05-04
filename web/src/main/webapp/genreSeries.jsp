<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="style.css" rel="stylesheet" type="text/css" />
<title>Series Catalog</title>
</head>

<body>
	<main>
		<header>
			<h1>IMDb Series</h1>
			<p>Projeto 2</p>
			<p>University of Coimbra</p>
			<p>Faculty of Sciences and Tecnology - 2022/2023</p>
			<p>Master's in Biomedical Engineering</p>
		</header>
		<div class="menu">
			<span> <a href="http://localhost:8080/web/homepage"><strong>Home</strong></a>
				<a href="http://localhost:8080/web/series"><strong>Series</strong></a>
				<a href="http://localhost:8080/web/actors"><strong>Actors</strong></a>
			</span>
		</div>
		<form action="main" method="get">
			<h4>List of Series By Genre</h4>
			<br> <label for="Genres">Choose a genre:</label> <select
				name="genres" id="g">
				<option value="drama">Drama</option>
				<option value="adventure">Adventure</option>
				<option value="action">Action</option>
				<option value="horror">Horror</option>
				<option value="Fantasy">Fantasy</option>
				<option value="History">History</option>
				<option value="Biography">Biography</option>
			</select> <br> <br> <input type="submit" value="Get Series">
		</form>
		<br />
		<h1 id="genreID">${genreRequest}</h1>

		<br />
		<c:forEach var="serie" items="${mySeries}">
			<section class="series">
				<article>
					<div class="serie">
						<img src="${serie.getCoverUrl()}" alt="serie cover" />
						<div class="serie-info">
							<h2>${serie.getTitle()}</h2>
							<p id="seriesummary">${serie.getSummaryOfSerie()}</p>
							<div class="serie-stats">
								<div class="stats">
									<span> <b>Year: </b> ${serie.getYear()}
									</span> <span> <b>Genre: </b> <c:forEach var="genre"
											items="${serie.getGenre()}" varStatus="status">
                          ${genre}<c:if test="${!status.last}">,</c:if>
										</c:forEach>
									</span> <span> <b>Rating: </b> ${serie.getScore()}
									</span> <span> <b>Number Votes: </b>
										${serie.getNumberOfVotes()}
									</span> <span> <b>PG-rating: </b> ${serie.getPgRating()}
									</span> <span> <b>Number of Seasons: </b>
										${serie.getNumberOfSeasons()}
									</span>
								</div>
								<div class="cast">
									<h4>Cast and Crew</h4>
									<span> <b>Stars: </b> <c:forEach var="star"
											items="${serie.getStar()}" varStatus="status">
                          ${star}<c:if test="${!status.last}">,</c:if>
										</c:forEach>
									</span> <span> <b>Actors: </b> <c:forEach var="actor"
											items="${serie.getActor()}" varStatus="status">
                          ${actor }<c:if test="${!status.last}">,</c:if>
										</c:forEach>
									</span> <span> <b>Directors: </b> <c:forEach var="director"
											items="${serie.getDirector() }" varStatus="status">
                          ${director }<c:if test="${!status.last}">,</c:if>
										</c:forEach>
									</span> <span> <b>Writers: </b> <c:forEach var="writer"
											items="${serie.getWriter() }" varStatus="status">
                          ${writer }<c:if test="${!status.last}">,</c:if>
										</c:forEach>
									</span> <span> <b>Creators: </b> <c:forEach var="creator"
											items="${serie.getCreator() }" varStatus="status">
                          ${creator }<c:if test="${!status.last}">,</c:if>
										</c:forEach>
									</span>
								</div>
							</div>
						</div>
					</div>
					<c:forEach var="season" items="${serie.getSeason()}"
						varStatus="status">
						<div class="season">
							<h3>Season ${status.count}</h3>
							<div class="episodes">
								<c:forEach var="episode" items="${season.getEpisode()}"
									varStatus="status">
									<div class="ep">
										<div class="header">
											<h4>Episode&nbsp;${status.count}: ${episode.getTitle()}
											</h4>
											<span> <b>Duration: </b>${episode.getDuration()}
											</span>
										</div>
										<p>${episode.getDescription()}</p>
										<div>
											<span>
												<p>
													<b>Reviews: </b>
													<c:forEach var="review" items="${episode.getReview()}"
														varStatus="status">
														<p>&nbsp;&nbsp;&nbsp;${review}</p>
													</c:forEach>
												</p>
											</span>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>

					</c:forEach>
				</article>
			</section>
		</c:forEach>
		<br />
		<div>Current date: ${today}</div>
	</main>

	<footer>
		<p>Projeto 2 - WebServices</p>
		<p>Mariana Montenegro - 2019245964</p>
		<p>Pedro Ferreira - 2019170165</p>
	</footer>

</body>

</html>