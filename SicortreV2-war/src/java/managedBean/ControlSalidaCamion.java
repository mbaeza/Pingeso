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
    
    private int cantidad_basura;
    private AsignacionConductorCamion camion_seleccionado;
    private List<AsignacionConductorCamion> asignaciones;     
    
    public ControlSalidaCamion() {       
    }
    
    @PostConstruct
    public void init(){       
        asignaciones = asignacionConductorCamionFacade.asignacionesActivas();          
    }
    
    public void ingresarControl(){
        
        try {
            Control control = new Control();
            
            SimpleDateFormat formato_fecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha_con_formato = formato_fecha.parse(controlBeans.getFecha());
            control.setFecha(fecha_con_formato);
            
            SimpleDateFormat formato_hora = new SimpleDateFormat("hh:mm:ss");
            Date hora_con_formato = formato_hora.parse(controlBeans.getHora_salida());
            control.setHoraSalida(hora_con_formato);
            
            control.setCantidadBasura(null);
            control.setHoraLlegada(null);
            control.setIdCamion(camion_seleccionado.getIdCamion());

            controlFacade.create(control);
            
            camion_seleccionado.getIdCamion().setControl("En Ruta");
            camionFacade.edit(camion_seleccionado.getIdCamion());
        
        } catch (ParseException ex) {
            Logger.getLogger(ControlSalidaCamion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void onRowSelect(SelectEvent event) {         
       controlBeans.setConductor_nombres(camion_seleccionado.getIdConductor().getNombres());
       controlBeans.setConductor_apellidos(camion_seleccionado.getIdConductor().getPrimerApellido() + camion_seleccionado.getIdConductor().getSegundoApellido());
       controlBeans.setPatente(camion_seleccionado.getIdCamion().getPatente());
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

    public int getCantidad_basura() {
        return cantidad_basura;
    }

    public void setCantidad_basura(int cantidad_basura) {
        this.cantidad_basura = cantidad_basura;
    }

    public AsignacionConductorCamion getCamion_seleccionado() {
        return camion_seleccionado;
    }

    public void setCamion_seleccionado(AsignacionConductorCamion camion_seleccionado) {
        this.camion_seleccionado = camion_seleccionado;
    }

    public List<AsignacionConductorCamion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<AsignacionConductorCamion> asignaciones) {
        this.asignaciones = asignaciones;
    }

}
