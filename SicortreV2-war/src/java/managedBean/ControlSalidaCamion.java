/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entitiesClass.AsignacionConductorCamion;
import entitiesClass.Camion;
import entitiesClass.Control;
import java.awt.event.ActionEvent;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import sessionBeans.AsignacionConductorCamionFacadeLocal;
import sessionBeans.CamionFacadeLocal;
import sessionBeans.ControlFacadeLocal;

/**
 *
 * @author Marco
 */
@Named(value = "controlSalidaCamion")
@RequestScoped
public class ControlSalidaCamion {
    @EJB
    private ControlFacadeLocal controlFacade;
    @EJB
    private AsignacionConductorCamionFacadeLocal asignacionConductorCamionFacade;
    @EJB
    private CamionFacadeLocal camionFacade;
    @Inject ControlBeans controlBeans;
    
    private int cantidadBasura;
    private AsignacionConductorCamion camionSeleccionado;
    private List<AsignacionConductorCamion> asignaciones;     
    
    public ControlSalidaCamion() {       
    }
    
    @PostConstruct
    public void init(){       
        asignaciones = asignacionConductorCamionFacade.asignacionesActivas();          
    }
    
    public void ingresarControl(){
        
        try {
            String[] split=controlBeans.getFecha().split("/");
            String aux="";
            aux+=split[2]+"-"+split[1]+"-"+split[0];
            Control control = new Control();
            
            SimpleDateFormat formato_fecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha_con_formato = formato_fecha.parse(aux);
            control.setFecha(fecha_con_formato);
            
            SimpleDateFormat formato_hora = new SimpleDateFormat("hh:mm:ss");
            Date hora_con_formato = formato_hora.parse(controlBeans.getHoraSalida());
            control.setHoraSalida(hora_con_formato);
            
            control.setCantidadBasura(null);
            control.setHoraLlegada(null);
            control.setIdCamion(camionSeleccionado.getIdCamion());

            controlFacade.create(control);
            
            camionSeleccionado.getIdCamion().setControl("En Ruta");
            camionFacade.edit(camionSeleccionado.getIdCamion());
        
        } catch (ParseException ex) {
            Logger.getLogger(ControlSalidaCamion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void onRowSelect(SelectEvent event) {         
       controlBeans.setConductorNombres(camionSeleccionado.getIdConductor().getNombres());
       controlBeans.setConductorApellidos(camionSeleccionado.getIdConductor().getPrimerApellido() + camionSeleccionado.getIdConductor().getSegundoApellido());
       controlBeans.setPatente(camionSeleccionado.getIdCamion().getPatente());
    } 
    
    public void confirmacionControlSalida(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Control de salida realizado",  "Se ha controlado la salida de un camion del sistema satisfactoriamente");    
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }

    public ControlFacadeLocal getControlFacade() {
        return controlFacade;
    }

    public void setControlFacade(ControlFacadeLocal controlFacade) {
        this.controlFacade = controlFacade;
    }

    public AsignacionConductorCamionFacadeLocal getAsignacionConductorCamionFacade() {
        return asignacionConductorCamionFacade;
    }

    public void setAsignacionConductorCamionFacade(AsignacionConductorCamionFacadeLocal asignacionConductorCamionFacade) {
        this.asignacionConductorCamionFacade = asignacionConductorCamionFacade;
    }

    public CamionFacadeLocal getCamionFacade() {
        return camionFacade;
    }

    public void setCamionFacade(CamionFacadeLocal camionFacade) {
        this.camionFacade = camionFacade;
    }

    public int getCantidadBasura() {
        return cantidadBasura;
    }

    public void setCantidadBasura(int cantidadBasura) {
        this.cantidadBasura = cantidadBasura;
    }

    public AsignacionConductorCamion getCamionSeleccionado() {
        return camionSeleccionado;
    }

    public void setCamionSeleccionado(AsignacionConductorCamion camionSeleccionado) {
        this.camionSeleccionado = camionSeleccionado;
    }

    public List<AsignacionConductorCamion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<AsignacionConductorCamion> asignaciones) {
        this.asignaciones = asignaciones;
    }

}
