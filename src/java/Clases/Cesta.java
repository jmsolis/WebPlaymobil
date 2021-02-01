/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author JuanMi
 */
public class Cesta {
            
        int id_cliente;
        String nombre;
        int id_art;
        String descripcion;
        String foto;
        int und_cesta;
        double precio;
        double total_linea;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_art() {
        return id_art;
    }

    public void setId_art(int id_art) {
        this.id_art = id_art;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getUnd_cesta() {
        return und_cesta;
    }

    public void setUnd_cesta(int und_cesta) {
        this.und_cesta = und_cesta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal_linea() {
        return total_linea;
    }

    public void setTotal_linea(double total_linea) {
        this.total_linea = total_linea;
    }

    

   
            
}  // FIn class
