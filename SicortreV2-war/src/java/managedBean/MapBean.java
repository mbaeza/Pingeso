/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import sessionBeans.CoordenadaFacade;
import sessionBeans.CoordenadaFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Marco
 */
@Named(value = "mapBean")
@ApplicationScoped
public class MapBean {

    private MapModel advancedModel = new DefaultMapModel();  
    
    private Marker marker;  

    public MapBean() { 
        //advancedModel = new DefaultMapModel();  
          
        //Shared coordinates
        CoordenadaFacade a = new CoordenadaFacade();
        
        LatLng coord1 = new LatLng( Double.parseDouble(a.obtenerLatitud("2781247900090555142")), Double.parseDouble(a.obtenerLongitud("2781247900090555142")));
      //  LatLng coord2 = new LatLng( Double.parseDouble(a.obtenerLatitud("140446060491853871")), Double.parseDouble(a.obtenerLongitud("140446060491853871")));
        // LatLng coord1 = new LatLng(-33.358818,-70.6854664);
          
        //Icons and Data  
        advancedModel.addOverlay(new Marker(coord1, "Konyaalti", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
     //   advancedModel.addOverlay(new Marker(coord2, "Ataturk Parki","sadasd" ,"http://maps.google.com/mapfiles/ms/micons/pink-dot.png"));  
        /*advancedModel.addOverlay(new Marker(coord4, "Kaleici", "kaleici.png", "http://maps.google.com/mapfiles/ms/micons/pink-dot.png"));  
        advancedModel.addOverlay(new Marker(coord3, "Karaalioglu Parki", "karaalioglu.png", "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));*/  
        for(Marker marker : advancedModel.getMarkers()) { 
            marker.setDraggable(true);  
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
        LatLng coord3 = new LatLng( -33.4372,-70.6506); 
        Marker marker = new Marker(coord3);  
        advancedModel.addOverlay(new Marker(coord3, "Karaalioglu Parki", "karaalioglu.png", "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png")); 
    } 
}
