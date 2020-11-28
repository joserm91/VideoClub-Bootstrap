/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.*;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbc.DB;

/**
 *
 * @author PC3
 */
public class ServletAlta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean fechaValida = true;
        ServletContext contexto = request.getServletContext();
        RequestDispatcher rd;
        String errores = "";
        java.sql.Date fecha1 = null;
        String titulo = request.getParameter("titulo");
        int directorID = Integer.parseInt(request.getParameter("directorSeleccionado"));
        String fecha = request.getParameter("fecha");
        String exito = "";
        contexto.setAttribute("exito", exito);

        try {

            fecha1 = Date.valueOf(fecha);
            java.sql.Date fecha2 = Date.valueOf("1895-03-19");
            if (fecha1.before(fecha2)) {
                fechaValida = false;
                errores += "Los hermanos Lumière fueron los primeros en realizar y"
                        + " proyectar el primer film de la historia. "
                        + "Fue filmada en Paris, el 19 de marzo de 1895 y se llamó "
                        + "<a href='https://www.lareserva.com/primera__pel%C3%ADcula_historia_del_cine' target=blank>“La sortie des ouvriers des usines Lumière à Lyon”</a> (La salida de los obreros de la fábrica Lumière en Lyon)."
                        + "\tPorfavor, introduzca una fecha posterior a (1895/03/19).\t";
            }

        } catch (java.lang.IllegalArgumentException e) {
            System.out.println(e + " PROBLEMAS EN LA FECHA");
            errores += "La fecha no puede estar vacia.\t";
            fechaValida = false;
        }
        if (titulo.isEmpty() || titulo == null) {
            errores += "El titulo no puede estar vacio.\t";
        }

        if ((!titulo.isEmpty() && titulo != null) && fechaValida) {

            if (DB.darAltaPelicula(titulo, directorID, fecha1)) {

                contexto.setAttribute("tituloPeli", titulo);
                exito = "Pelicula añadida con exito";
                contexto.setAttribute("exito", exito);
                rd = request.getRequestDispatcher("/anadirPelicula.jsp");
                rd.forward(request, response);
            }

        } else {

            contexto.setAttribute("erroresAñadir", errores);

            rd = request.getRequestDispatcher("/anadirPelicula.jsp");
            rd.forward(request, response);

        }

    }

}
