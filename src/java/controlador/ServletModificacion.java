/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dbc.DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramos-PC
 */
public class ServletModificacion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto = request.getServletContext();
        RequestDispatcher rd;
        String exitoModificando = "";
        String erroresModificacion = "";
      
        int idPelicula = Integer.parseInt(request.getParameter("peliculaSeleccionada"));
        String nuevoTitulo = request.getParameter("nuevoTitulo");
        int idDirector = Integer.parseInt(request.getParameter("directorSeleccionado"));
        String fecha1 = request.getParameter("fecha");
        boolean fechaValida = true;
        Date fecha = null;
        try {
            fecha = Date.valueOf(fecha1);
            
             java.sql.Date fecha2 = Date.valueOf("1895-03-19");
            if (fecha.before(fecha2)) {
                fechaValida = false;
                erroresModificacion += "Los hermanos Lumière fueron los primeros en realizar y"
                        + " proyectar el primer film de la historia. "
                        + "Fue filmada en Paris, el 19 de marzo de 1895 y se llamó "
                        + "<a href='https://www.lareserva.com/primera__pel%C3%ADcula_historia_del_cine' target=blank>“La sortie des ouvriers des usines Lumière à Lyon”</a> (La salida de los obreros de la fábrica Lumière en Lyon)."
                        + "\tPorfavor, introduzca una fecha posterior a (1895/03/19).\t";
            }
            
        } catch (java.lang.IllegalArgumentException e) {
            System.out.println(e + " PROBLEMAS EN LA FECHA");
            erroresModificacion += "La fecha no puede estar vacia.\t";
            fechaValida = false;
        }
        if (nuevoTitulo.isEmpty() || nuevoTitulo == null) {
            erroresModificacion += "El título es obligatorio";
        }

        if ((!nuevoTitulo.isEmpty() && nuevoTitulo != null) && fechaValida) {

            if (DB.modificaPelicula(idPelicula, nuevoTitulo, idDirector, fecha)) {
                exitoModificando = "Éxito en la modificación";
                contexto.setAttribute("exitoModificando", exitoModificando);
                rd = request.getRequestDispatcher("/modificarPelicula.jsp");
                rd.forward(request, response);

            } else {
                
               
                contexto.setAttribute("erroresModificacion", erroresModificacion);
                rd = request.getRequestDispatcher("/modificarPelicula.jsp");
                rd.forward(request, response);
            }

        } else {

            contexto.setAttribute("erroresModificacion", erroresModificacion);

            rd = request.getRequestDispatcher("/modificarPelicula.jsp");
            rd.forward(request, response);

        }

    }

}
