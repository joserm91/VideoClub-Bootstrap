/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dbc.DB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC3
 */
public class ServletBusquedaDirectores extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        ServletContext contexto = request.getServletContext();
        
        String errorBusqueda = "";
        String tabla="";
        int directorSeleccionado=0;
         directorSeleccionado = Integer.parseInt(request.getParameter("directorSeleccionado"));
        
        if (directorSeleccionado>0) {
           
           tabla = DB.consultaPelisDirector(directorSeleccionado);
            contexto.setAttribute("tablaDirectores", tabla);
            rd = request.getRequestDispatcher("busquedaFiltradaDirectores.jsp");
            rd.forward(request, response);
           
            
            
       }else{
        
            
        }
        
        
        
        
        
        
    }

}

