/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entitiesClass.Camion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import sessionBeans.CoordenadaFacade;
import sessionBeans.CoordenadaFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import sessionBeans.CamionFacadeLocal;

/**
 *
 * @author Marco
 */
@Named(value = "mapBean")
@ApplicationScoped
public class MapBean {
    @EJB
    private CamionFacadeLocal camionFacade;

    private MapModel advancedModel = new DefaultMapModel();  
    private List<Camion> camiones;
    private Marker marker;  

    public MapBean() { 
    } 
    
    @PostConstruct
    public void init(){
        camiones = camionFacade.findAll();
        CoordenadaFacade a = new CoordenadaFacade();
        
        for(Camion camion : camiones){
            if(camion.getControl().equals("En Ruta")){
                String lat = a.obtenerLatitud(camion.getUsuarioGLatitude());
                String lng = a.obtenerLongitud(camion.getUsuarioGLatitude());

                if(!lat.equals("Error") && !lng.equals("Error")){
                    LatLng coord1 = new LatLng( Double.parseDouble(lat), Double.parseDouble(lng));            
                    advancedModel.addOverlay(new Marker(coord1, camion.getPatente(), "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
                }
            }
        }        
    }
    public void setAdvancedModel(MapModel advancedModel) {
        this.advancedModel = advancedModel;
    }
    
    public MapModel getAdvancedModel() {  
        return advancedModel;  
    }  
    public void onMarkerSelect(OverlaySelectEvent event) {   
        marker = (Marker) event.getOverlay();  
    }  
      
    public Marker getMarker() {  
        return marker;  
    }  
    public void addMarker() {  
   
        int i = 0;
      
        CoordenadaFacade a = new CoordenadaFacade();
        
        for(int u = 0; u < advancedModel.getMarkers().size();u++){
            String lat ="0";
            String lng ="0";
            for(Camion camion : camiones){
                if(camion.getPatente().equals(advancedModel.getMarkers().get(u).getTitle())){
                    lat = a.obtenerLatitud(camion.getUsuarioGLatitude());
                    lng = a.obtenerLongitud(camion.getUsuarioGLatitude());

                    if(!lat.equals("Error") && !lng.equals("Error")){
                         RequestContext.getCurrentInstance().addCallbackParam("lat" + i, Double.parseDouble(lat));
                         RequestContext.getCurrentInstance().addCallbackParam("lng" + i, Double.parseDouble(lng));
                    }
                }
            }
            i++;
        }
    } 
}
