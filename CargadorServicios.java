package Util;

import Conceptos.Servicios;
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


public class CargadorServicios {
    
    private static String obtenerValor(String etiqueta, Element element){
        
        NodeList nodos = element.getElementsByTagName(etiqueta);
        
        if (nodos.getLength() == 0) {
            
            return "";
            
        }
        
        return nodos.item(0).getTextContent().trim();
    }
    

    
    public static ArrayList<Servicios> cargar(String nombreArchivo){
        
        ArrayList<Servicios> servicios = new ArrayList<Servicios>();
        
        try{
            
            File archivoXML = new File(nombreArchivo);
            
            DocumentBuilderFactory categoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder creador = categoria.newDocumentBuilder();
            Document documento = creador.parse(archivoXML);
            
            NodeList nodos = documento.getElementsByTagName("servicio");
            
            for (int i = 0; i < nodos.getLength(); i++){
                
                Node nServicio = nodos.item(i);
                
                if (nServicio.getNodeType() == Node.ELEMENT_NODE){ 
                    
                    Element elemento = (Element)nServicio;
                    
                    String ID = elemento.getAttribute("id");
                    String nombre = obtenerValor("nombre", elemento);
                    String p = obtenerValor("precio", elemento);
                    double precio = Double.parseDouble(p);
                    
                    Servicios servicio = new Servicios(ID, nombre, precio);
                    servicios.add(servicio);
                    
                    }
                }
            
            } catch (IOException | SAXException | ParserConfigurationException ex){
                
                ex.printStackTrace();
        }
        
        return servicios;
    }
}
