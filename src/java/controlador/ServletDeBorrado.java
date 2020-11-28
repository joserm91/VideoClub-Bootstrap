/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
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
public class ServletDeBorrado extends HttpServlet {

    

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         RequestDispatcher rd;
        ServletContext contexto = request.getServletContext();
        
        int id = Integer.parseInt(request.getParameter("peliculaSeleccionada"));
       
        String titulo = DB.consultarUnTituloPorId(id);
        
        if (DB.borradoPelicula(id)) {
            contexto.setAttribute("peliculaBorrada", titulo);
            rd = request.getRequestDispatcher("/borrarPelicula.jsp");
            rd.forward(request, response);
        }
       
    }

    
}
