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
 * @author Ramos-PC
 */
public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       RequestDispatcher rd;
        ServletContext contexto = request.getServletContext();
        String usuario = request.getParameter("username");
        String password = request.getParameter("password");

        String errores = "";

        if ((!usuario.isEmpty() && usuario != null) && (!password.isEmpty() && password != null)) {

            //hacemos cosas
            boolean exito = DB.consultaUsuarios(usuario, password);
           
            if (exito) {
                contexto.setAttribute("usuario", usuario);
                
                rd = request.getRequestDispatcher("/vistaAdministrador.jsp");
                rd.forward(request, response);
            } else {
                errores = "No existe nadie asociado a esa identificacion.";
                contexto.setAttribute("errores", errores);
                rd = request.getRequestDispatcher("/indexError.jsp");
                rd.forward(request, response);

            }

        } else {
            errores = "El usuario o la contraseña no pueden estar vacios.";
            contexto.setAttribute("errores", errores);
            rd = request.getRequestDispatcher("/indexError.jsp");
            rd.forward(request, response);

        }
       
        
        
   
        
    }//END doPost

    // METODOS =========================================================
    
  
 
}
