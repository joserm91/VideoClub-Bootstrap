/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author PC3
 */
public class Pelicula {
    private int id;
     private String titulo;
     private int director;
     private Date fecha_estreno;

    public Pelicula(int id, String titulo, int director, Date fecha_estreno) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.fecha_estreno = fecha_estreno;
    }

    public Pelicula(String titulo, int director, Date fecha_estreno) {
        this.titulo = titulo;
        this.director = director;
        this.fecha_estreno = fecha_estreno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDirector() {
        return director;
    }

    public void setDirector(int director) {
        this.director = director;
    }

    public Date getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(Date fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }
     
     
}
