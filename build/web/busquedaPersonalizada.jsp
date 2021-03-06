<%-- 
    Document   : busquedaPersonalizada
    Created on : 27-nov-2020, 0:29:37
    Author     : Ramos-PC
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Pelicula"%>
<%@page import="modelo.Pelicula"%>
<%@page import="dbc.DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
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

        <title>Búsqueda personalizada</title>
    </head>
    <style>



    </style>
    <%
        ServletContext contexto = request.getServletContext();
        String usuario = (String) getServletContext().getAttribute("usuario");
         ArrayList<Pelicula> listaPeliculas = DB.consultaPelis();
       String tabla  = (String)contexto.getAttribute("tablaBusqueda");
 String errores="";
    errores = (String)getServletContext().getAttribute("errorBusqueda");

    %>
    <body>

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
                                    >Borrar película</a>
                            </div>
                        </li>
                    </ul>

                    <!-- BOTOENES DEL NAVBAR -->
                    <h3 class="text-justify mr-3 text-white"><%=usuario%></h3>
                    <a href="index.jsp"
                       type="button"
                       class="btn btn-danger mr-lg-3 mr-md-3 mr-sm-3"
                       >
                        Cerrar Sesión
                    </a><!-- BOTOENES DEL NAVBAR -->
                </div>
            </nav>
            <!-- NAVBAR -->
        </div>

        <!-- SECTION -->
        <section class="container-fluid">
            <div class="container-fluid mt-5 pt-5">
                <div class="row my-3">
                    <div class="col-2-lg col-md-2 col-sm-12">
                        <form action="ServletBusqueda" method="post" class="input-group">
                            <label class="lead">Filtrar por título</label>
                    </div>

                        <div class="col-10-lg col-md-9 col-sm-12"> 


                            <div class="input-group-append">
                                <input name="cadenaDeBusqueda"type="text" class="form-control" placeholder="Búsqueda" aria-label="Búsqueda" aria-describedby="button-addon2">
                                <input class="btn btn-info" type="submit" value="Filtrar">
                            </div>

                        </div>
                    </form>

                </div>
            </div>
            <!-- SECTION -->

        </section>

        <section class="container-fluid ">
           
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
                  <%if(errores != null && !errores.isEmpty()){%>
                  <tr><td><%=errores%><img class="imf-fluid" width="30px" src="images/icons8-cerrar-ventana-48.png"><td></tr>
                  <%
                  errores ="";
                  contexto.setAttribute("errorBusqueda", errores);
                  %>
                  <%}else{%>
                  <%if(tabla != null && !tabla.isEmpty()){%>
                <%=tabla%>
                <%}}%>
              </tbody>
            </table>

            
          </div>
        </section>

        <!-- FOOTER -->

        <footer class="container-fluid bg-dark text-center text-white mt-5 py-md-4 bottom">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Consectetur sit
            soluta suscipit iusto deserunt amet.
        </footer>

        <!-- FOOTER -->
    </div>


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