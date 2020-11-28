<%-- 
    Document   : listadoDePeliculas
    Created on : 26-nov-2020, 14:05:13
    Author     : Ramos-PC
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Pelicula"%>
<%@page import="dbc.DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
      crossorigin="anonymous"
    />

    <title>Lista de películas</title>
  </head>
  <style>
      .starWars{
          box-shadow: 1px 7px 12px black;
      }
  </style>
  <body>
      <%
        ArrayList<Pelicula> listaPeliculas=DB.consultaPelis();
    String usuario = (String) getServletContext().getAttribute("usuario");
    String tabla  = DB.consultarTodasPelis();
    %>
    <div class="container-fluid">
      <!-- NAVBAR -->
      <nav
        class="navbar navbar-expand-lg fixed-top navbar navbar-dark bg-dark py-3"
      >
        <!-- Image and text -->

        <a class="navbar-brand" href="vistaAdministrador.jsp">
            <img
            src="images/logo.jpg"
            width="30"
            height="30"
            class="d-inline-block align-top rounded"
            alt=""
            loading="lazy"
          />
          VideoClub
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto ml-5">
            <li class="nav-item active">
                <a class="nav-link" href="vistaAdministrador.jsp"
                >Home <span class="sr-only">(current)</span></a
              >
            </li>

            <li class="nav-item dropdown">
              <a
                class="nav-link dropdown-toggle"
                href="#"
                id="navbarDropdown"
                role="button"
                data-toggle="dropdown"
                aria-haspopup="true"
                aria-expanded="false"
              >
                Herramientas de gestión
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="listadoDePeliculas.jsp"
                  >Listado de películas</a
                >
                <a class="dropdown-item" href="busquedaPersonalizada.jsp"
                  >Búsqueda personalizada</a
                >
                 <a class="dropdown-item" href="busquedaFiltradaDirectores.jsp"
                                   >Búsqueda por directores</a
                                >
                <div class="dropdown-divider border-dark"></div>
                <a
                  class="dropdown-item bg-success text-white font-weight-bold"
                  href="anadirPelicula.jsp"
                  >Añadir película</a
                >
                <div class="dropdown-divider border-dark"></div>
                <a
                  class="dropdown-item bg-warning text-white font-weight-bold"
                  href="modificarPelicula.jsp"
                  >Modificar película</a
                >
                <div class="dropdown-divider border-dark"></div>
                <a
                  class="dropdown-item bg-danger text-white font-weight-bold"
                  href="borrarPelicula.jsp"
                  >Borrar película</a
                >
              </div>
            </li>
          </ul>

          <!-- BOTOENES DEL NAVBAR -->
 <h3 class="text-justify mr-3 text-white"><%=usuario%></h3>
          <button
            type="button"
            class="btn btn-danger ml-3"
            data-toggle="modal"
            data-target="#staticBackdrop"
          >
            Cerrar Sesión</button
          ><!-- BOTOENES DEL NAVBAR -->
        </div>
      </nav>
      <!-- NAVBAR -->
    </div>

    <!-- SECTION -->
    <section class="container-fluid">
      <div class="container-fluid mt-5 pt-5">
        <div class="row my-3">
          <div class="col-2-lg col-md-3 col-sm-0">
            <h4>“Que la fuerza te acompañe” Han Solo</h4>
           
            <a href="https://www.starwars.com/" target="_blank"><img src="images/Star_Wars_Logo.svg" class="img-fluid my-3 rounded starWars"></a>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit.
              Molestiae, tempore. Ea aut magni obcaecati labore magnam at
              maiores, reprehenderit doloremque in suscipit, excepturi fuga,
              laudantium accusantium praesentium voluptate dicta tenetur?
            </p>
          </div>

          <div class="col-10-lg col-md-9 col-sm-12">
              <h1 class="my-3">Listado de Películas</h1>
            <table class="table">
              <thead class="thead-dark">
                <tr>
                  <th scope="col">Pelicula</th>
                  <th scope="col">Director</th>
                  <th scope="col">Fecha de estreno</th>
                </tr>
              </thead>
              <tbody>
                <%=tabla%>
              </tbody>
            </table>

            
          </div>
        </div>
      </div>
      <!-- SECTION -->
    </section>

    <!-- FOOTER -->

    <footer
      class="container-fluid bg-dark text-center text-white mt-5 py-md-4 bottom"
    >
      Lorem ipsum dolor sit amet consectetur adipisicing elit. Consectetur sit
      soluta suscipit iusto deserunt amet.
    </footer>

    <!-- FOOTER -->

  

    <!-- SCRIPTS BOOSTRAP -->
    <script
      src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
      integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
      integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
      integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
      crossorigin="anonymous"
    ></script>
    <!-- SCRIPTS BOOSTRAP -->
  </body>
</html>
