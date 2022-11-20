<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  
    <strong>Hi there!</strong>
    <div>Greetings from your JSP page!</div>
  
    <br />
  
    <strong>
      <c:choose>
        <c:when test="${empty myListOfNumbers}">No items to be shown...</c:when>
        <c:when test="${myListOfNumbers.size()==1}">A single item...</c:when>
        <c:otherwise>Too many items...</c:otherwise>
      </c:choose>
    </strong>
  
    <br />
  
    <strong>A list of items...</strong>
    <c:forEach var="item" items="${myListOfNumbers}">
      <div>Content is ${item}</div>
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