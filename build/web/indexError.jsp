<%-- 
    Document   : index
    Created on : 26-nov-2020, 9:32:20
    Author     : Ramos-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

    <title>Pagina Principal</title>
  </head>
  <style>
      .error{
          color: red;   
         margin-right: 10px;
      }
  </style>
  <body>
      <%
         String errores ="";
       errores = (String)getServletContext().getAttribute("errores");
      %>
    <div class="container-fluid">
      <!-- NAVBAR -->
      <nav
        class="navbar navbar-expand-lg fixed-top navbar navbar-dark bg-dark py-3"
      >
        <!-- Image and text -->

        <a class="navbar-brand" href="index.jsp">
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
        
        </button>

        <!-- BOTOENES DEL NAVBAR -->
        <div class="row ml-auto">
           <span class="error"><%if(errores != null && !errores.isEmpty()){%><%=errores%><%}%></span> 
          <button
            type="button"
            class="btn btn-outline-info mr-lg-3 mr-md-3 mr-sm-3 " 
            data-toggle="modal"
            data-target="#staticBackdrop"
          >
          Iniciar Sesión
          </button>
          
        </div>
        <!-- BOTOENES DEL NAVBAR -->
      </nav>
      <!-- NAVBAR -->
    </div>

    <!-- SECTION -->
    <section class="container-fluid">
            <div class="container-fluid mt-5 pt-5">
                <div class="row my-3 ">
                    <div class="col-2-lg col-md-5 col-sm-12 text-center">

                        <h3 class="font-weight-bold">Página de bienvenida</h3>

                        <p class="font-italic">“Que la fuerza te acompañe” Han Solo</p>
                        <p class="lead mb-5">
                            Lorem ipsum dolor sit amet consectetur adipisicing elit.
                            Molestiae, tempore. Ea aut magni obcaecati labore magnam at
                            maiores, reprehenderit doloremque in suscipit, excepturi fuga,
                            laudantium accusantium praesentium voluptate dicta tenetur?
                        </p>

                        <div class="card rounded m-auto" style="width: 18rem;">
                            <img src="images/foto2.png" class="card-img-top" alt="...">
                            <div class="card-body ">
                                <h5 class="card-title">José Ramos Mangano 2ºDAW</h5>
                                <p class="card-text"></p>
                                <a href="https://github.com/joserm91" target="blank" class="btn btn-primary">GitHub</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-10-lg col-md-7 col-sm-12 my-5">
                        <img
                            class="img-fluid w-100 rounded "
                            src="images/fondoPrincipal.jpg"
                            alt=""
                            srcset=""
                            />
                    </div>
                </div>
            </div>
            <!-- SECTION -->
        </section>
    <!-- FOOTER -->

    <footer
      class="container-fluid bg-dark text-center text-white mt-5 py-md-4 fixed-bottom"
    >
      Lorem ipsum dolor sit amet consectetur adipisicing elit. Consectetur sit
      soluta suscipit iusto deserunt amet.
    </footer>
    <!-- FOOTER -->

    <!-- MODAL LOGIN -->
    <div
      class="modal fade"
      id="staticBackdrop"
      data-backdrop="static"
      data-keyboard="false"
      tabindex="-1"
      aria-labelledby="staticBackdropLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="staticBackdropLabel">Login</h5>
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-label="Close"
            >
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form
              action="ServletLogin"
              method="POST"
              class="form-inline ml-5 my-2"
            >
                 
                
              
              <input
                class="form-control mr-sm-2"
                type="text"
                name="username"
                placeholder="Username"
                aria-label="Username"
              />
              
              <input
                class="form-control mr-sm-2"
                type="text"
                name="password"
                placeholder="Contraseña"
                aria-label="Contraseña"
              />
              <input
                class="btn btn-outline-info my-lg-2 my-sm-2 ml-auto mr-lg-2 mr-md-2 mr-sm-2"
                type="submit"
                value="Iniciar Sesión"
              />
            </form>
          </div>
          <div class="modal-footer">
            <!-- <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Understood</button> -->
          </div>
        </div>
      </div>
    </div>
    <!-- MODAL LOGIN -->

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


