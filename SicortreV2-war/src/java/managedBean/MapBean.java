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
        //advancedModel = new DefaultMapModel();  
          
        //Shared coordinates
        
    } 
    
    @PostConstruct
    public void init(){
        camiones = camionFacade.findAll();
        CoordenadaFacade a = new CoordenadaFacade();
        
        for(Camion camion : camiones){
            String lat = a.obtenerLatitud(camion.getUsuarioGLatitude());
            String lng = a.obtenerLongitud(camion.getUsuarioGLatitude());
            
            if(!lat.equals("Error") && !lng.equals("Error")){
                LatLng coord1 = new LatLng( Double.parseDouble(lat), Double.parseDouble(lng));            
                advancedModel.addOverlay(new Marker(coord1, camion.getPatente(), "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            }
        }
        for(Marker marker : advancedModel.getMarkers()) { 
            marker.setDraggable(true); 
            marker.setCursor("hola");
        } 
      //  LatLng coord1 = new LatLng( Double.parseDouble(a.obtenerLatitud("2781247900090555142")), Double.parseDouble(a.obtenerLongitud("2781247900090555142")));
      //  LatLng coord2 = new LatLng( Double.parseDouble(a.obtenerLatitud("140446060491853871")), Double.parseDouble(a.obtenerLongitud("140446060491853871")));
        // LatLng coord1 = new LatLng(-33.358818,-70.6854664);
       // LatLng coord3 = new LatLng( -32.4372,-70.6506); 
        //advancedModel.addOverlay(new Marker(coord3, "Karaalioglu Parki", "karaalioglu.png", "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png")); 
        //Icons and Data  
       

       // advancedModel.addOverlay(new Marker(coord1, "Konyaalti", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
     //   advancedModel.addOverlay(new Marker(coord2, "Ataturk Parki","sadasd" ,"http://maps.google.com/mapfiles/ms/micons/pink-dot.png"));  
        /*advancedModel.addOverlay(new Marker(coord4, "Kaleici", "kaleici.png", "http://maps.google.com/mapfiles/ms/micons/pink-dot.png"));  
        advancedModel.addOverlay(new Marker(coord3, "Karaalioglu Parki", "karaalioglu.png", "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));*/  
                  
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
        //List<String> latList = new ArrayList<String>();
       // List<String> lngList = new ArrayList<String>();
        int i = 0;
        //LatLng coord3 = new LatLng( -33.4372,-70.6506); 
        //Marker marker = new Marker(coord3);  
        //advancedModel.addOverlay(new Marker(coord3, "Karaalioglu Parki", "karaalioglu.png", "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png")); 
        CoordenadaFacade a = new CoordenadaFacade();
        
        for(Camion camion : camiones){             
            String lat = a.obtenerLatitud(camion.getUsuarioGLatitude());
            String lng = a.obtenerLongitud(camion.getUsuarioGLatitude());
            
            if(!lat.equals("Error") && !lng.equals("Error")){
                 RequestContext.getCurrentInstance().addCallbackParam("lat" + i, Double.parseDouble(lat));
                 RequestContext.getCurrentInstance().addCallbackParam("lng" + i, Double.parseDouble(lng));
            }
            i++;
        }
       // for (int i = 0; i < advancedModel.getMarkers().size(); i++){
           // advancedModel.getMarkers().get(i).setIcon("http://maps.google.com/mapfiles/ms/micons/pink-dot.png");
             //advancedModel.getMarkers().get(i).setLatlng(coord3);
         // RequestContext.getCurrentInstance().addCallbackParam("marker" + i, advancedModel.getMarkers().get(i));
          //RequestContext.getCurrentInstance().addCallbackParam("lat" + i, -33.4372);
          //RequestContext.getCurrentInstance().addCallbackParam("lng" + i, -70.6506);
        //}
    } 
}
