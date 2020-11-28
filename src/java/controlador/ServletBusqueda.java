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
public class ServletBusqueda extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        ServletContext contexto = request.getServletContext();
        String cadenaDeBusqueda = "";
        cadenaDeBusqueda = request.getParameter("cadenaDeBusqueda").trim();
        String errorBusqueda = "";
        String tabla="";
        
        
        if (!cadenaDeBusqueda.isEmpty() && cadenaDeBusqueda != null) {
             tabla = DB.consultaPorTitulo(cadenaDeBusqueda);
            
            if (!tabla.isEmpty() && tabla != null) {
                contexto.setAttribute("tablaBusqueda", tabla);
                rd = request.getRequestDispatcher("busquedaPersonalizada.jsp");
                rd.forward(request, response);
            }else {
                tabla="";
                contexto.setAttribute("tablaBusqueda", tabla);
            errorBusqueda = "No se encontró nada.";
            contexto.setAttribute("errorBusqueda", errorBusqueda);
            rd = request.getRequestDispatcher("busquedaPersonalizada.jsp");
            rd.forward(request, response);
        }

        } else {
             tabla="";
                contexto.setAttribute("tablaBusqueda", tabla);
            errorBusqueda = "No se especificó la búsqueda.";
            contexto.setAttribute("errorBusqueda", errorBusqueda);
            rd = request.getRequestDispatcher("busquedaPersonalizada.jsp");
            rd.forward(request, response);
        }

    }

}
