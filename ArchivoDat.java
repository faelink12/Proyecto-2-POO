/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Util;

import Conceptos.Citas;
import Conceptos.Clientes;
import Conceptos.Servicios;
import Conceptos.Veterinarios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
Hecho por Fabián Eduarte Linkimer y Luciana Mora Delgado
#2026130994 | #2026006344
 */
public class ArchivoDat {
    
    public static final String RUTA_DAT_CLIENTES = "Data/CLIENTES.DAT";
    public static final String RUTA_DAT_SERVICIOS = "Data/SERVICIOS.DAT";
    public static final String RUTA_DAT_VETERINARIOS = "Data/VETERINARIOS.DAT";
    public static final String RUTA_DAT_CITAS = "Data/CITAS.DAT";

    public static final String RUTA_XML_CLIENTES = "Export/clientes.xml";
    public static final String RUTA_XML_SERVICIOS = "Export/servicios.xml";
    public static final String RUTA_XML_VETERINARIOS = "Export/veterinarios.xml";
    public static final String RUTA_XML_CITAS = "Export/citas.xml";
    
    public static void guardar(ArrayList<?> lista, String ruta) {
        new File("Data").mkdirs();
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta))) {
            salida.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Error al guardar " + ruta + ": " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> cargar(String ruta) {
        File archivo = new File(ruta);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))) {
            return (ArrayList<T>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar " + ruta + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Métodos tipados para facilitar el acceso a cada concepto
    public static ArrayList<Clientes> cargarClientes() {
        return cargar(RUTA_DAT_CLIENTES);
    }

    public static void guardarClientes(ArrayList<Clientes> clientes) {
        guardar(clientes, RUTA_DAT_CLIENTES);
    }

    public static ArrayList<Servicios> cargarServicios() {
        return cargar(RUTA_DAT_SERVICIOS);
    }

    public static void guardarServicios(ArrayList<Servicios> servicios) {
        guardar(servicios, RUTA_DAT_SERVICIOS);
    }

    public static ArrayList<Veterinarios> cargarVeterinarios() {
        return cargar(RUTA_DAT_VETERINARIOS);
    }

    public static void guardarVeterinarios(ArrayList<Veterinarios> veterinarios) {
        guardar(veterinarios, RUTA_DAT_VETERINARIOS);
    }

    public static ArrayList<Citas> cargarCitas() {
        return cargar(RUTA_DAT_CITAS);
    }

    public static void guardarCitas(ArrayList<Citas> citas) {
        guardar(citas, RUTA_DAT_CITAS);
    }
    
    /**
     * Operación IMPORTAR:
     * Carga la información que está en los XML's de Export/ para cada concepto
     * y la reescribe en los archivos .DAT correspondientes.
     */
    public static void importar() {
        new File("Data").mkdirs();
        
        ArrayList<Clientes> clientes = CargadorClientes.cargar(RUTA_XML_CLIENTES);
        guardarClientes(clientes);
        
        ArrayList<Servicios> servicios = CargadorServicios.cargar(RUTA_XML_SERVICIOS);
        guardarServicios(servicios);
        
        ArrayList<Veterinarios> veterinarios = CargadorVeterinarios.cargar(RUTA_XML_VETERINARIOS);
        guardarVeterinarios(veterinarios);
        
        ArrayList<Citas> citas = CargadorCitas.cargar(RUTA_XML_CITAS);
        guardarCitas(citas);
    }
    
    /**
     * Operación EXPORTAR:
     * Toma los objetos de los archivos .DAT y genera/reescribe los archivos .XML en Export/.
     */
    public static void exportar() {
        new File("Export").mkdirs();
        
        ArrayList<Clientes> clientes = cargarClientes();
        EscritorClientes.guardar(RUTA_XML_CLIENTES, clientes);
        
        ArrayList<Servicios> servicios = cargarServicios();
        EscritorServicios.guardar(RUTA_XML_SERVICIOS, servicios);
        
        ArrayList<Veterinarios> veterinarios = cargarVeterinarios();
        EscritorVeterinarios.guardar(RUTA_XML_VETERINARIOS, veterinarios);
        
        ArrayList<Citas> citas = cargarCitas();
        EscritorCitas.guardar(RUTA_XML_CITAS, citas);
    }
    
    /**
     * Operación LIMPIAR:
     * Elimina la información en los DAT's dejándolos vacíos.
     */
    public static void limpiar() {
        guardar(new ArrayList<Clientes>(), RUTA_DAT_CLIENTES);
        guardar(new ArrayList<Servicios>(), RUTA_DAT_SERVICIOS);
        guardar(new ArrayList<Veterinarios>(), RUTA_DAT_VETERINARIOS);
        guardar(new ArrayList<Citas>(), RUTA_DAT_CITAS);
    }
}
