/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Util;

import Conceptos.Citas;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
Hecho por Fabián Eduarte Linkimer y Luciana Mora Delgado
#2026130994 | #2026006344
 */

public class CargadorCitas {
    
    private static String obtenerValor(String etiqueta, Element element){
        
        NodeList nodos = element.getElementsByTagName(etiqueta);
        
        if (nodos.getLength() == 0){
            return "";
        }
        
        return nodos.item(0).getTextContent().trim();
    }
    
    public static ArrayList<Citas> cargar(String nombreArchivo){
        
        ArrayList<Citas> citas = new ArrayList<Citas>();
        
        try{
            
            File archivoXML = new File(nombreArchivo);
            
            DocumentBuilderFactory categoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder creador = categoria.newDocumentBuilder();
            Document documento = creador.parse(archivoXML);
            
            NodeList nodos = documento.getElementsByTagName("cita");
            
            for (int i = 0; i < nodos.getLength(); i++){
                
                Node nCita = nodos.item(i);
                
                if (nCita.getNodeType() == Node.ELEMENT_NODE){
                    
                    Element elemento = (Element) nCita;
                    
                    String id = elemento.getAttribute("id");
                    String idCliente = obtenerValor("cliente_id", elemento);
                    String fecha = obtenerValor("fecha", elemento);
                    String idVet = obtenerValor("veterinario_id", elemento);
                    String observaciones = obtenerValor("observaciones", elemento);
                    
                    Citas cita = new Citas(id, idCliente, fecha, observaciones);
                    
                    cita.setIdVet(idVet);
                    
                    NodeList listaDiagnosticos = elemento.getElementsByTagName("diagnostico");
                    
                    for (int j = 0; j < listaDiagnosticos.getLength(); j++){
                        
                        cita.agregarDiagnostico(listaDiagnosticos.item(j).getTextContent().trim());
                    }
                    
                    NodeList listaTratamientos = elemento.getElementsByTagName("tratamiento");
                    
                    for(int j = 0; j < listaTratamientos.getLength(); j++){
                        
                        cita.agregarTratamiento(listaTratamientos.item(j).getTextContent().trim());
                    }
                    
                    citas.add(cita);
                }
            }
        } catch (IOException | SAXException | ParserConfigurationException ex){
            
            ex.printStackTrace();
        }
        
        return citas;
    }
    
}