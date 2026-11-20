package Conceptos;

import java.io.Serializable;

/**
Hecho por Fabián Eduarte Linkimer y Luciana Mora Delgado
#2026130994 | #2026006344
 */
public class Clientes implements Serializable {
    private String ID;
    private String nombre;
    private String propietario;
    private String telefono;
    private String email;
    
    public Clientes(String ID, String nombre, String propietario, String telefono, String email) {
        this.ID = ID;
        this.nombre = nombre;
        this.propietario = propietario;
        this.telefono = telefono;
        this.email = email;
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

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
