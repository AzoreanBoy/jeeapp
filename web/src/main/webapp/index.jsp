<html>

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <link href="style2.css" rel="stylesheet" type="text/css" />
  <title>Web Services</title>
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
        <a href="http://localhost:8080/web/series"><strong>Series</strong></a>
        <a href="http://localhost:8080/web/actors"><strong>Actors</strong></a>
      </span>
    </div>

    <div>
      <div>
        <h1 class="pagetitle">Choose an Option</h1>
      </div>
    </div>

    <div>
      <article class="mainMenu">
          <a href="http://localhost:8080/web/series"><h4>Series Catalog</h4></a>
          <a href="http://localhost:8080/web/actors"><h4>Actors in DB</h4></a>
          <span class="seriesByGenre">
          <form>
            <h4>List of Series By Genre</h4>
            <br>
            <label for="Genres">Choose a genre:</label>
            <select name="genres" id="cars">
              <option value="drama">Drama</option>
              <option value="adventure">Adventure</option>
              <option value="action">Action</option>
              <option value="horror">Horror</option>
            </select>
            <br> <br>
            <input type="submit" value="Get Series">
          </form>
        </span>
      </article>
    </div>

  </main>
  <footer>
    <p>Projeto 2 - WebServices</p>
    <p>Pedro Ferreira</p>
    <p>Mariana Montenegro</p>
  </footer>
</body>

</html>