/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Conceptos.Servicios;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
Hecho por Fabián Eduarte Linkimer y Luciana Mora Delgado
#2026130994 | #2026006344
 */

public class EscritorServicios {
    
    public static void guardar(String nombreArchivo, ArrayList<Servicios> servicios) {
        
        try {
            
            DocumentBuilderFactory categoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder creador = categoria.newDocumentBuilder();
            Document documento = creador.newDocument();
            
            
            Element raiz = documento.createElement("servicios");
            documento.appendChild(raiz);
            
            
            for (int i = 0; i < servicios.size(); i++) {
                
                Servicios servicio = servicios.get(i);
                
                Element elementoServicio = documento.createElement("servicio");
                elementoServicio.setAttribute("id", servicio.getID());
                raiz.appendChild(elementoServicio);
                
                
                Element nombre = documento.createElement("nombre");
                nombre.setTextContent(servicio.getNombre());
                elementoServicio.appendChild(nombre);
                
                
                Element p = documento.createElement("precio");
                String precio = Double.toString(servicio.getPrecio());
                p.setTextContent(precio);
                elementoServicio.appendChild(p);
                
            }
            
            
            TransformerFactory fabrica = TransformerFactory.newInstance();
            Transformer transformador = fabrica.newTransformer();
            
            transformador.setOutputProperty(OutputKeys.INDENT, "yes");
            transformador.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            
            
            DOMSource fuente = new DOMSource(documento);
            StreamResult resultado = new StreamResult(new File(nombreArchivo));
            
            transformador.transform(fuente, resultado);
            
            
        } catch (ParserConfigurationException | TransformerException ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
}