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
public class archivoDat {
    public static void guardar(ArrayList<?> lista, String ruta){
       new File("Data").mkdirs();
       try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta))){
           salida.writeObject(lista);
       } catch (IOException e){
           System.out.println("Error al guardar " + ruta + ": " + e.getMessage());
       }  
    }
    public static <T> ArrayList<T> cargar(String ruta){
        File archivo = new File(ruta);
        if (!archivo.exists()){
            return new ArrayList<>();
        }
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))){
            return (ArrayList<T>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Error al cargar " + ruta + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public static void limpiar(){
        guardar(new ArrayList<Clientes>(), "Data/CLIENTES.DAT");
        guardar(new ArrayList<Servicios>(), "Data/SERVICIOS.DAT");
        guardar(new ArrayList<Veterinarios>(), "Data/VETERINARIOS.DAT");
        guardar(new ArrayList<Citas>(), "Data/CITAS.DAT");
    }
}
