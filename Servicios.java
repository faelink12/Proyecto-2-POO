/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Conceptos;

import java.io.Serializable;

/**
Hecho por Fabián Eduarte Linkimer y Luciana Mora Delgado
#2026130994 | #2026006344
 */

public class Servicios implements Serializable{
    
    private String ID;
    private String nombre;
    private double precio;
    
    public Servicios(String ID, String nombre, double precio) {
        
        this.ID = ID;
        this.nombre = nombre;
        this.precio = precio;
    }

    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}