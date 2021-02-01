/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 * Clase Articulos, aqui estan la definicion del objeto Articulos, usado en la aplicacion,
 * con sus Getter y Setters definidos.
 * @author JuanMi
 */
public class Articulos {
            
        int id_art;
        String descripcion;
        String foto;
        double precio;
        int stock;
/**
 * Codigo de articulo. 
 * @return el codigo de articulo.
 */
    public int getId_art() {
        return id_art;
    }

 /**
  * Codigo de articulo.
  * @param id_art 
  */  
    public void setId_art(int id_art) {
        this.id_art = id_art;
    }

    /**
     * Descripcion de articulo. 
     * @return la descripcion del articulo
     */
    public String getDescripcion() {
        return descripcion;
    }
    
/**
 * Descripcion de articulo. 
 * @param descripcion 
 */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

  
            
}  // FIn class
