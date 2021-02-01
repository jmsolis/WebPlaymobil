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
public class Ventas {
            
    int id_venta;
    int id_linea;
    int id_cliente_vt;
    String nombre;
    int id_art_vt;
    String descripcion;
    String fecha_vt;
    double precio_art;
    int cantidad_art;
    double total_linea;

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_linea() {
        return id_linea;
    }

    public void setId_linea(int id_linea) {
        this.id_linea = id_linea;
    }

    public int getId_cliente_vt() {
        return id_cliente_vt;
    }

    public void setId_cliente_vt(int id_cliente_vt) {
        this.id_cliente_vt = id_cliente_vt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_art_vt() {
        return id_art_vt;
    }

    public void setId_art_vt(int id_art_vt) {
        this.id_art_vt = id_art_vt;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_vt() {
        return fecha_vt;
    }

    public void setFecha_vt(String fecha_vt) {
        this.fecha_vt = fecha_vt;
    }

    public double getPrecio_art() {
        return precio_art;
    }

    public void setPrecio_art(double precio_art) {
        this.precio_art = precio_art;
    }

    public int getCantidad_art() {
        return cantidad_art;
    }

    public void setCantidad_art(int cantidad_art) {
        this.cantidad_art = cantidad_art;
    }

    public double getTotal_linea() {
        return total_linea;
    }

    public void setTotal_linea(double total_linea) {
        this.total_linea = total_linea;
    }
    
    

        
        
}  // FIn class
