<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <link href="style2.css" rel="stylesheet" type="text/css" />
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
          <span>
            <a href="http://localhost:8080/web/"><strong>Home</strong></a>
            <a href="http://localhost:8080/web/actors"><strong>Actors</strong></a>
            <a href="http://localhost:8080/web/series"><strong>Series</strong></a>
          </span>
        </div>
        <br />
        <c:forEach var="serie" items="${mySeries}">
          <section class="series">
            <article>
              <div class="serie">
                <img src="${serie.getCoverUrl()}" alt="serie cover" />
                <div class="serie-info">
                  <h2>
                    ${serie.getTitle()}
                  </h2>
                  <p id="seriesummary">
                    ${serie.getSummaryOfSerie()}
                  </p>
                  <div class="serie-stats">
                    <div class="stats">
                      <span>
                        <b>Year: </b>
                        ${serie.getYear()}
                      </span>
                      <span>
                        <b>Genre: </b>
                        <c:forEach var="genre" items="${serie.getGenre()}">
                          ${genre}
                        </c:forEach>
                      </span>
                      <span>
                        <b>Rating: </b>
                        ${serie.getScore()}
                      </span>
                      <span>
                        <b>Number Votes: </b>
                        ${serie.getNumberOfVotes()}
                      </span>
                      <span>
                        <b>PG-rating: </b>
                        ${serie.getPgRating()}
                      </span>
                      <span>
                        <b>Number of Seasons: </b>
                        ${serie.getNumberOfSeasons()}
                      </span>
                      
                    </div>
                  </div>
                </div>
              </div>
            </article>
          </section>
        </c:forEach>
        <br />
        <div>Current date: ${today}</div>
      </main>

      <footer>
        <p>Systems Integration - Project 1</p>
        <p>Mariana Montenegro - 2019245964</p>
        <p>Pedro Ferreira - 2019170165</p>
      </footer>

    </body>

    </html>