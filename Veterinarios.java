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

public class Veterinarios implements Serializable {
    
    private String ID;
    private String nombre;
    private String puesto;
    private String telefono;
    
    public Veterinarios(String ID, String nombre, String puesto, String telefono) {

        this.ID = ID;
        this.nombre = nombre;
        this.puesto = puesto;
        this.telefono = telefono;
    }

    public Veterinarios(String ID, String nombre, String puesto) {
        this(ID, nombre, puesto, "");
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}