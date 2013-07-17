/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.Coordenadas;
import java.io.IOException;
import java.net.URL;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;

/**
 *
 * @author Marco
 */
@Stateless
public class CoordenadasFacade extends AbstractFacade<Coordenadas> implements CoordenadasFacadeLocal {
    @PersistenceContext(unitName = "SicortreV2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CoordenadasFacade() {
        super(Coordenadas.class);
    }
    
    @Override
    public String obtenerLongitud(String nombreUsuarioGLongitud) {
        
        JsonFactory jfactory = new JsonFactory();
        String Longitud = "Error";
        JsonParser jParser;
        
        try {
            jParser = jfactory.createJsonParser(new URL("https://latitude.google.com/latitude/apps/badge/api?user="+nombreUsuarioGLongitud+"&type=json&callback=?"));
            // loop until token equal to "}"
	while (jParser.nextToken() != null) {
 
		String fieldname = jParser.getCurrentName();
                
		if ("coordinates".equals(fieldname)) {
                  jParser.nextToken();
                  jParser.nextToken();
                  Longitud = jParser.getText();
                  break;		
		}      
        }
        jParser.close();
        } catch (IOException ex) {
            
        }
        return Longitud;
    }

    @Override
    public String obtenerLatitud(String nombreUsuarioGLatitude) {
        JsonFactory jfactory = new JsonFactory();
        String Latitud = "Error";
        JsonParser jParser;
        
        try {
            jParser = jfactory.createJsonParser(new URL("https://latitude.google.com/latitude/apps/badge/api?user="+nombreUsuarioGLatitude+"&type=json&callback=?"));
            // loop until token equal to "}"
	while (jParser.nextToken() != null) {
 
		String fieldname = jParser.getCurrentName();
                
		if ("coordinates".equals(fieldname)) {
                  jParser.nextToken();
                  jParser.nextToken();
                  jParser.nextToken();
                  Latitud = jParser.getText();
                  break;		
		}           
        }
        jParser.close();
        } catch (IOException ex) {
           
        }
        return Latitud;
    }
    
}
