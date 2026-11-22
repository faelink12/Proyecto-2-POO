

package Util;

import Conceptos.Veterinarios;
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


public class EscritorVeterinarios {
    
    public static void guardar(String nombreArchivo, ArrayList<Veterinarios> veterinarios) {
        
        try {
            
            DocumentBuilderFactory categoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder creador = categoria.newDocumentBuilder();
            Document documento = creador.newDocument();
            
            
            Element raiz = documento.createElement("veterinarios");
            documento.appendChild(raiz);
            
            
            for (int i = 0; i < veterinarios.size(); i++) {
                
                Veterinarios veterinario = veterinarios.get(i);
                
                Element elementoVeterinario = documento.createElement("veterinario");
                elementoVeterinario.setAttribute("id", veterinario.getID());
                raiz.appendChild(elementoVeterinario);
                
                
                Element nombre = documento.createElement("nombre");
                nombre.setTextContent(veterinario.getNombre());
                elementoVeterinario.appendChild(nombre);
                
                Element telefono = documento.createElement("telefono");
                telefono.setTextContent(veterinario.getTelefono());
                elementoVeterinario.appendChild(telefono);
                
                
                Element puesto = documento.createElement("puesto");
                puesto.setTextContent(veterinario.getPuesto());
                elementoVeterinario.appendChild(puesto);
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
