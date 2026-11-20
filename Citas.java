package Conceptos;

import java.io.Serializable;
import java.util.ArrayList;

/**
Hecho por Fabián Eduarte Linkimer y Luciana Mora Delgado
#2026130994 | #2026006344
 */
public class Citas implements Serializable{
    private String ID;
    private String idCliente;
    private String fecha;
    private String idVet;
    private String observaciones;
    private ArrayList<String> diagnosticos;
    private ArrayList<String> tratamientos;

    public Citas() {
        this.idVet = "";
        this.diagnosticos = new ArrayList<>();
        this.tratamientos = new ArrayList<>();
    }

    public Citas(String ID, String idCliente, String fecha, String observaciones) {
        this();
        this.ID = ID;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.observaciones = observaciones;
    }
    
    public void agregarDiagnostico(String diagnostico){
        this.diagnosticos.add(diagnostico);
    }
    
    public void agregarTratamiento(String tratamiento){
        this.tratamientos.add(tratamiento);
    }

    public String getId() {
        return ID;
    }

    public void setId(String ID) {
        this.ID = ID;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdVet() {
        return idVet;
    }

    public void setIdVet(String idVet) {
        this.idVet = idVet;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public ArrayList<String> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(ArrayList<String> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public ArrayList<String> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(ArrayList<String> tratamientos) {
        this.tratamientos = tratamientos;
    }
    
    
}
