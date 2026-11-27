/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Util;

import Conceptos.Veterinarios;
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


public class CargadorVeterinarios {
    
    private static String obtenerValor(String etiqueta, Element element){
        
        NodeList nodos = element.getElementsByTagName(etiqueta);
        
        if (nodos.getLength() == 0) {
            
            return "";
        }
        
        return nodos.item(0).getTextContent().trim();
    }
    
    
    public static ArrayList<Veterinarios> cargar(String nombreArchivo){
        
        ArrayList<Veterinarios> veterinarios = new ArrayList<Veterinarios>();
        
        try{
            
            File archivoXML = new File(nombreArchivo);
            
            DocumentBuilderFactory categoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder creador = categoria.newDocumentBuilder();
            Document documento = creador.parse(archivoXML);
            
            NodeList nodos = documento.getElementsByTagName("veterinario");
            
            for (int i = 0; i < nodos.getLength(); i++){
                
                Node nVeterinario = nodos.item(i);
                
                if (nVeterinario.getNodeType() == Node.ELEMENT_NODE){
                    
                    Element elemento = (Element)nVeterinario;
                    
                    String ID = elemento.getAttribute("id");
                    String nombre = obtenerValor("nombre", elemento);
                    String puesto = obtenerValor("puesto", elemento);
                    String telefono = obtenerValor("telefono", elemento);
                    Veterinarios veterinario = new Veterinarios(ID, nombre, puesto, telefono);
                    veterinarios.add(veterinario);
                    
                }
                
            }
            
        } catch (IOException | SAXException | ParserConfigurationException ex){
            
            ex.printStackTrace();
        }
        
        return veterinarios;
    }
}
