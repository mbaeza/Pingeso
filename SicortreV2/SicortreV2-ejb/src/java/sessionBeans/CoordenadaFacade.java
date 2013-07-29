/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.Camion;
import entitiesClass.Coordenada;
import entitiesClass.Marca;
import entitiesClass.Modelo;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;

/**
 *
 * @author Marco
 */
@Stateless
public class CoordenadaFacade extends AbstractFacade<Coordenada> implements CoordenadaFacadeLocal {
    @EJB
    private ModeloFacadeLocal modeloFacade;
    @EJB
    private MarcaFacadeLocal marcaFacade;
    @EJB
    private sessionBeans.CamionFacadeLocal camionFacade;
    @PersistenceContext(unitName = "SicortreV2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CoordenadaFacade() {
        super(Coordenada.class);
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
    @Schedule(minute = "*", second = "*/30", dayOfMonth = "*", month = "*", year = "*", hour = "*", dayOfWeek = "Mon-Fri")
    @Override
    public void guardarCoordenadas() {
        List<Camion> camiones =  camionFacade.findAll();       
        
      for(Camion camionEleg : camiones){
           
            Coordenada coordenadas = new Coordenada();      

            String latitud = obtenerLatitud(camionEleg.getUsuarioGLatitude());
            String longitud = obtenerLongitud(camionEleg.getUsuarioGLatitude());
            //System.out.println(longitud);
            
            if((longitud.equals("Error") == false && latitud.equals("Error") == false)  && (camionEleg.getControl().equals("En Ruta")==true && camionEleg.getEstado().equals("Activo")==true)){
                System.out.println("HOlA");
                coordenadas.setLongitud(longitud);
                coordenadas.setLatitud(latitud);
                coordenadas.setFecha(new Date());
                coordenadas.setHora(new Date());
                coordenadas.setIdCamion(camionEleg);
                create(coordenadas);
        
            }
      }
    }
    
}
