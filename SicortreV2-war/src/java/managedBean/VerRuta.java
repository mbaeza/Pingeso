/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entitiesClass.Camion;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polyline;
import sessionBeans.CamionFacadeLocal;

/**
 *
 * @author Marco
 */
@Named(value = "verRuta")
@RequestScoped
public class VerRuta {
    @EJB
    private CamionFacadeLocal camionFacade;

    /**
     * Creates a new instance of VerRuta
     */
    private MapModel polylineModel;  
    private Camion camionSeleccionado;  
    private List<Camion> camiones;
  
    public VerRuta() {  
        polylineModel = new DefaultMapModel();   
    }  
    @PostConstruct
    public void init(){       
        camiones = camionFacade.findAll();
    }
  
    public MapModel getPolylineModel() {  
        return polylineModel;  
    }  
    
    public void onRowSelect(SelectEvent event) {  
        if(camionSeleccionado.getPatente().equals("PK-82-31")){
            polylineModel.getPolylines().clear();
            LatLng coord1 = new LatLng(-33.456053009147155, -70.65480208038935);  
            LatLng coord2 = new LatLng(-33.45550234711707, -70.64982390039631);  
            LatLng coord3 = new LatLng(-33.45273632502631, -70.65020477405596);  
            LatLng coord4 = new LatLng(-33.45286291837039, -70.650751944695);  
            LatLng coord5 = new LatLng(-33.454230114450596, -70.65055882564593);
            LatLng coord6 = new LatLng(-33.45438202381973, -70.65143859020282);
            LatLng coord7 = new LatLng(-33.45439468291981, -70.65246855846453);
            LatLng coord8 = new LatLng(-33.453407267516376, -70.65338050961145);
            LatLng coord9 = new LatLng(-33.45356550791315, -70.65417444347986);
            LatLng coord10 = new LatLng(-33.45443898970719, -70.65405106186518);
            LatLng coord11 = new LatLng(-33.45450228509922, -70.65660452517477);

            Polyline polyline = new Polyline();  
            polyline.getPaths().add(coord1);  
            polyline.getPaths().add(coord2);  
            polyline.getPaths().add(coord3);  
            polyline.getPaths().add(coord4);  
            polyline.getPaths().add(coord5);
            polyline.getPaths().add(coord6);
            polyline.getPaths().add(coord7);
            polyline.getPaths().add(coord8);
            polyline.getPaths().add(coord9);
            polyline.getPaths().add(coord10);
            polyline.getPaths().add(coord11); 
            
            polylineModel.addOverlay(new Marker(coord1, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord2, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord3, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord4, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord5, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord6, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord7, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord8, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord9, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord10, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord11, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            
            polyline.setStrokeWeight(10);  
            polyline.setStrokeColor("#FF9900");  
            polyline.setStrokeOpacity(0.7);  

            polylineModel.addOverlay(polyline);  
        }else{
            
            polylineModel.getPolylines().clear();
            LatLng coord1 = new LatLng(-33.43695530507557, -70.658384077542);  
            LatLng coord2 = new LatLng(-33.4426135011404, -70.65765451636253);  
            LatLng coord3 = new LatLng(-33.44273883676116, -70.6589419770171);  
            LatLng coord4 = new LatLng(-33.441619762855886, -70.65918874024646);  
            LatLng coord5 = new LatLng(-33.441297466190036, -70.65632414069114);
            LatLng coord6 = new LatLng(-33.43910402969674, -70.65680693847753);
            LatLng coord7 = new LatLng(-33.43896078406415, -70.6553478167325);
            LatLng coord8 = new LatLng(-33.44117212848692, -70.65490793461777);

            Polyline polyline = new Polyline();  
            polyline.getPaths().add(coord1);  
            polyline.getPaths().add(coord2);  
            polyline.getPaths().add(coord3);  
            polyline.getPaths().add(coord4);  
            polyline.getPaths().add(coord5);
            polyline.getPaths().add(coord6);
            polyline.getPaths().add(coord7);
            polyline.getPaths().add(coord8);
 
            
            polylineModel.addOverlay(new Marker(coord1, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord2, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord3, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord4, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord5, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord6, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord7, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
            polylineModel.addOverlay(new Marker(coord8, "Puntos Check", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));             
            
            polyline.setStrokeWeight(10);  
            polyline.setStrokeColor("#FF9900");  
            polyline.setStrokeOpacity(0.7);  

            polylineModel.addOverlay(polyline); 
        }
    }  

    public Camion getCamionSeleccionado() {
        return camionSeleccionado;
    }

    public void setCamionSeleccionado(Camion camionSeleccionado) {
        this.camionSeleccionado = camionSeleccionado;
    }

    public List<Camion> getCamiones() {
        return camiones;
    }

    public void setCamiones(List<Camion> camiones) {
        this.camiones = camiones;
    }
    
}
