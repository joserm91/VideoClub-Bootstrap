/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Director;
import modelo.Pelicula;

public class DB {

    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3306";
    public static String basedatos = "videoclub";

    public DB() {
        Connection cnn = null;
        try {
            cnn = CrearConexion();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection CrearConexion() throws SQLException {
        Connection cnn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//Invocamos al driver
            String url = "jdbc:mysql://" + servidor + "/" + basedatos;
            cnn = DriverManager.getConnection(url, usuario, password); //nos conectamos a la base de datos
            System.out.println("exito");
        } catch (ClassNotFoundException e) {
            System.out.println("Controlador JDBC no encontrado" + e.toString());
        } catch (Exception e) {
            System.out.println("Otras excepciones" + e.toString());
        }

        return cnn;
    }

    public static boolean consultaUsuarios(String usuario, String password) {

        Connection cnn = null;
        try {
            cnn = CrearConexion();
            String sql = "SELECT * FROM usuario WHERE usuario = ? AND password = ?";
            PreparedStatement pst = cnn.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex + " PROBLEMAS EN CONSULTA USUARIOS");
            return false;
        }

        return false;
    }

    public static ArrayList<Director> consultaDirectores() {
        Connection cnn = null;
        ArrayList<Director> listaDirectores = new ArrayList<Director>();
        Director director = null;
        try {
            cnn = CrearConexion();
            String sql = "SELECT * FROM director";
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                director = new Director(id, nombre);

                listaDirectores.add(director);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaDirectores;
    }

    public static boolean darAltaPelicula(String titulo, int directorID, Date fecha) {
        Connection cnn = null;
        try {
            cnn = CrearConexion();

            String sql = "INSERT INTO peliculas(titulo, director, fecha_estreno) VALUES (?,?,?)";
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs;
            pst.setString(1, titulo);
            pst.setInt(2, directorID);

            pst.setDate(3, fecha);

            pst.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex + " FALLO EN EL INSERT");
        }

        return false;
    }

    public static ArrayList<Pelicula> consultaPelis() {
        ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
        Connection cnn = null;

        try {
            cnn = CrearConexion();
            String sql = "SELECT * FROM peliculas";
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                int director = rs.getInt("director");
                Date fecha = rs.getDate("fecha_estreno");

                Pelicula peli = new Pelicula(id, titulo, director, fecha);
                listaPeliculas.add(peli);

            }

        } catch (SQLException ex) {
            System.out.println(ex + " ERROR EN LA CONSULTA DE PELIS");
        }

        return listaPeliculas;
    }

    public static boolean borradoPelicula(int id) {

        Connection cnn = null;
        try {
            cnn = CrearConexion();
            String sql = "DELETE FROM peliculas WHERE id = ?";
            PreparedStatement pst = cnn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex + " ERROR EN EL BORRADO");
        }

        return false;
    }

    public static Pelicula buscarPorTitulo(String titulo) {
        Pelicula encontrada = null;
        Connection cnn = null;
        try {
            cnn = CrearConexion();
            String sql = "SELECT * FROM peliculas WHERE titulo = ?";
            PreparedStatement pst = cnn.prepareStatement(sql);
            pst.setString(1, titulo);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String tituloPeli = rs.getString("titulo");
                int director = rs.getInt("director");
                Date fecha_estreno = rs.getDate("fecha_estreno");

                encontrada = new Pelicula(id, titulo, director, fecha_estreno);

            }

        } catch (SQLException ex) {
            System.out.println(ex + " ERROR EN CONSULTA TITULO");
        }

        return encontrada;
    }

    public static String consultarTodasPelis() {
        ArrayList<Pelicula> listaFull = new ArrayList<>();
        String tabla = "";
        Connection cnn = null;

        try {

            cnn = CrearConexion();

            String sql = "SELECT peliculas.titulo as titulo, director.nombre as director, peliculas.fecha_estreno as fecha "
                    + " FROM peliculas,director"
                    + " WHERE peliculas.director = director.id";

            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String director = rs.getString("director");
                String fecha = rs.getString("fecha");
                tabla += "<tr><td>" + titulo + "</td><td>" + director + "</td><td>" + fecha + "</td>";

            }

        } catch (SQLException ex) {
            System.out.println(ex + " ERROR EN LA CONSUTLA FULL");
        }

        return tabla;
    }

    public static String consultarUnTituloPorId(int id) {
        String titulo = "";
        Connection cnn = null;

        try {

            cnn = CrearConexion();

            String sql = "SELECT titulo FROM peliculas WHERE id = ?";

            PreparedStatement pst = cnn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                titulo = rs.getString("titulo");
                return titulo;

            }

        } catch (SQLException ex) {
            System.out.println(ex + " ERROR EN LA CONSUTLA POR ID");
        }

        return titulo;
    }

    public static boolean modificaPelicula(int idPeli, String nuevoTitulo, int idDirector, Date fecha) {

        Connection cnn = null;
        try {
            cnn = CrearConexion();
            String sql = "UPDATE peliculas SET titulo = ?,director = ?,fecha_estreno = ? WHERE id = ?";
            PreparedStatement pst = cnn.prepareStatement(sql);
            pst.setString(1, nuevoTitulo);
            pst.setInt(2, idDirector);
            pst.setDate(3, fecha);
            pst.setInt(4, idPeli);

            pst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex + " PROBLEMAS EN modificaPelicula();");

        }

        return false;
    }

    public static String consultaPorTitulo(String cadenaDeBusqueda) {

        String tabla = "";
        Connection cnn = null;

        try {

            cnn = CrearConexion();

            String sql = "SELECT * "
                    + " FROM peliculas"
                    + " WHERE peliculas.titulo LIKE ?";

            PreparedStatement pst = cnn.prepareStatement(sql);
            pst.setString(1, "%" + cadenaDeBusqueda + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String director = rs.getString("director");
                String fecha = rs.getString("fecha_estreno");
                tabla += "<tr><td>" + titulo + "</td><td>" + director + "</td><td>" + fecha + "</td>";

            }

        } catch (SQLException ex) {
            System.out.println(ex + " ERROR EN LA CONSUTLA FILTRADA");
        }

        return tabla;
    }

    public static String consultaPelisDirector(int directorSeleccionado){
   String tabla = "";
        Connection cnn = null;

        try {

            cnn = CrearConexion();

            String sql = "SELECT * "
                    + " FROM peliculas"
                    + " WHERE peliculas.director = ?";

            PreparedStatement pst = cnn.prepareStatement(sql);
            pst.setInt(1, directorSeleccionado);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String director = rs.getString("director");
                String fecha = rs.getString("fecha_estreno");
                tabla += "<tr><td>" + titulo + "</td><td>" + director + "</td><td>" + fecha + "</td>";

            }

        } catch (SQLException ex) {
            System.out.println(ex + " ERROR EN LA CONSUTLA FILTRADA DIRECTOR");
        }

        return tabla;
    
}
}
