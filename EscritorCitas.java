/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Util;

import Conceptos.Citas;
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

public class EscritorCitas {
    
    public static void guardar(String nombreArchivo, ArrayList<Citas> citas){
        
        try {
            
            DocumentBuilderFactory categoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder creador = categoria.newDocumentBuilder();
            Document documento = creador.newDocument();
            
            Element raiz = documento.createElement("citas");
            
            documento.appendChild(raiz);
            
            for (int i = 0; i < citas.size(); i++){
                
                Citas cita = citas.get(i);
                
                Element elementoCita = documento.createElement("cita");
                elementoCita.setAttribute("id", cita.getId());
                
                raiz.appendChild(elementoCita);
                
                Element clienteId = documento.createElement("cliente_id");
                clienteId.setTextContent(cita.getIdCliente());
                
                elementoCita.appendChild(clienteId);
                
                Element fecha = documento.createElement("fecha");
                fecha.setTextContent(cita.getFecha());
                
                elementoCita.appendChild(fecha);
                
                Element veterinarioId = documento.createElement("veterinario_id");
                veterinarioId.setTextContent(cita.getIdVet());
                
                elementoCita.appendChild(veterinarioId);
                
                Element observaciones = documento.createElement("observaciones");
                observaciones.setTextContent(cita.getObservaciones());
                
                elementoCita.appendChild(observaciones);
                
                Element listaDiagnosticos = documento.createElement("diagnosticos");
                elementoCita.appendChild(listaDiagnosticos);
                
                for(int j = 0; j < cita.getDiagnosticos().size(); j++){
                    
                    Element diagnostico = documento.createElement("diagnostico");
                    diagnostico.setTextContent(cita.getDiagnosticos().get(j));
                    
                    listaDiagnosticos.appendChild(diagnostico);
                }
                
                Element listaTratamientos = documento.createElement("tratamientos");
                elementoCita.appendChild(listaTratamientos);
                
                for(int j = 0; j < cita.getTratamientos().size(); j++){
                    
                    Element tratamiento = documento.createElement("tratamiento");
                    tratamiento.setTextContent(cita.getTratamientos().get(j));
                    
                    listaTratamientos.appendChild(tratamiento);
                }
            }
            
            TransformerFactory fabrica = TransformerFactory.newInstance();
            Transformer transformador = fabrica.newTransformer();
            
            transformador.setOutputProperty(OutputKeys.INDENT, "yes");
            transformador.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            
            DOMSource fuente = new DOMSource(documento);
            
            StreamResult resultado = new StreamResult(new File(nombreArchivo));
            
            transformador.transform(fuente, resultado);
            
        } catch (ParserConfigurationException | TransformerException ex){
            
            ex.printStackTrace();
        }
    }
}