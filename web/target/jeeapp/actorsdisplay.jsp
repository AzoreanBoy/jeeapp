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
        <a href="http://localhost:8080/web/homepage"><strong>Home</strong></a>
        <a href="http://localhost:8080/web/series"><strong>Series</strong></a>
        <a href="http://localhost:8080/web/actors"><strong>Actors</strong></a>
      </span>
    </div>
    <h1 class="pagetitle">Actors in the Database...</h1>
    <section>
        <c:forEach var="actor" items="${actors}">
          <div class="actor">
            <h2>
              ${actor}
            </h2>
          </div>
        </c:forEach>
    </section>
    <br />
    <div class="time">Current date: ${today}</div>
  </main>

  <footer>
    <p>Projeto 2 - WebServices</p>
    <p>Mariana Montenegro - 2019245964</p>
    <p>Pedro Ferreira - 2019170165</p>
  </footer>

</body>

</html>