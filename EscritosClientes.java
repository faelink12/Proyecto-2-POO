/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Util;

import Conceptos.Clientes;
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

public class EscritorClientes {
    
    public static void guardar(String nombreArchivo, ArrayList<Clientes> clientes) {
        
        try {
            
            DocumentBuilderFactory categoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder creador = categoria.newDocumentBuilder();
            Document documento = creador.newDocument();
            
            
            Element raiz = documento.createElement("clientes");
            documento.appendChild(raiz);
            
            
            for (int i = 0; i < clientes.size(); i++) {
                
                Clientes cliente = clientes.get(i);
                
                Element elementoCliente = documento.createElement("cliente");
                elementoCliente.setAttribute("id", cliente.getID());
                raiz.appendChild(elementoCliente);
                
                
                Element nombre = documento.createElement("nombre");
                nombre.setTextContent(cliente.getNombre());
                elementoCliente.appendChild(nombre);
                
                
                Element propietario = documento.createElement("propietario");
                propietario.setTextContent(cliente.getPropietario());
                elementoCliente.appendChild(propietario);
                
                
                Element telefono = documento.createElement("telefono");
                telefono.setTextContent(cliente.getTelefono());
                elementoCliente.appendChild(telefono);
                
                
                Element email = documento.createElement("email");
                email.setTextContent(cliente.getEmail());
                elementoCliente.appendChild(email);
                
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
